/*
 * Static demo layer for GitHub Pages.
 *
 * The visualiser (simulacion.html) and the worker dashboard (dashboard.html)
 * are served unchanged; this script answers their API calls in the browser:
 *   - /Estadisticas?tok=  -> responses recorded from the real service, or
 *                            simulations run in the browser with sim.js
 *   - /Dashboard/Stats    -> replay of snapshots recorded during a real burst
 * and adds a small strip saying that this is a static demo.
 */
(function () {
  'use strict';

  var REPO = 'https://github.com/santiagodie/life-simulation-service';
  var MODES = ['standard', 'advanced'];
  var page = /dashboard\.html$/.test(location.pathname) ? 'dashboard' : 'visualizer';
  var nativeFetch = window.fetch.bind(window);

  function getJSON(url) {
    return nativeFetch(url).then(function (r) { return r.json(); });
  }

  // ── Recorded data ───────────────────────────────────────────
  var recorded = {};      // token -> recorded simulation
  var dashboard = null;   // recorded /Dashboard/Stats snapshots
  var notFound = null;    // recorded error response for an unknown token
  var ready = Promise.all(MODES.map(function (m) {
    return getJSON('demo/data/' + m + '/simulations.json').then(function (d) {
      d.simulations.forEach(function (s) { recorded[s.solicitar.response.tokenSolicitud] = s; });
      notFound = notFound || d.noExiste.estadisticas.response;
    });
  }).concat(getJSON('demo/data/standard/dashboard.json').then(function (d) { dashboard = d; })));

  // Simulations generated in this browser (kept for the session)
  var generated = {};
  try { generated = JSON.parse(sessionStorage.getItem('lifesim-demo') || '{}'); } catch (e) { generated = {}; }
  function saveGenerated() {
    try { sessionStorage.setItem('lifesim-demo', JSON.stringify(generated)); } catch (e) { /* ignore */ }
  }

  function jsonResponse(body, status) {
    return new Response(JSON.stringify(body), { status: status || 200, headers: { 'Content-Type': 'application/json' } });
  }

  // ── fetch shim ──────────────────────────────────────────────
  var t0 = Date.now();
  window.fetch = function (input, init) {
    var url = typeof input === 'string' ? input : input.url;
    var m = /\/Estadisticas\?tok=(-?\d+)/.exec(url);
    if (m) {
      var tok = Number(m[1]);
      return ready.then(function () {
        if (recorded[tok]) return jsonResponse(recorded[tok].estadisticas.response);
        if (generated[tok]) {
          var g = generated[tok];
          return jsonResponse(LifeSim.estadisticas(g.data, g.names, tok, g.mode));
        }
        var err = Object.assign({}, notFound, {
          tokenSolicitud: tok,
          errorMessage: 'No se encontraron estadísticas para el token ' + tok,
        });
        return jsonResponse(err, 404);
      });
    }
    if (/\/Dashboard\/Stats/.test(url)) {
      return ready.then(function () {
        var snaps = dashboard.snapshots;
        var span = snaps[snaps.length - 1].t + 4000;
        var t = (Date.now() - t0) % span;
        var cur = snaps[0];
        for (var i = 0; i < snaps.length && snaps[i].t <= t; i++) cur = snaps[i];
        var body = Object.assign({}, cur);
        delete body.t;
        return jsonResponse(body);
      });
    }
    return nativeFetch(input, init);
  };

  // ── UI ──────────────────────────────────────────────────────
  var css = [
    '.demo-strip{display:flex;flex-wrap:wrap;gap:6px 18px;align-items:baseline;justify-content:space-between;',
    'font-family:Mulish,system-ui,sans-serif;font-size:12.5px;line-height:1.5;color:var(--text-2);',
    'background:var(--surface-2);border:1px solid var(--border);border-radius:10px;padding:9px 14px;margin-bottom:28px}',
    '.demo-strip p{margin:0}',
    '.demo-strip strong{color:var(--text);font-weight:600}',
    '.demo-strip code{font-size:11.5px}',
    '.demo-strip nav{display:flex;flex-wrap:wrap;gap:4px 14px}',
    '.demo-strip a{color:var(--accent);text-decoration:none}',
    '.demo-strip a:hover{text-decoration:underline}',
    '.demo-strip a[aria-current]{color:var(--text);pointer-events:none}',
    '.demo-panel{font-family:Mulish,system-ui,sans-serif;font-size:13px;color:var(--text-2);',
    'background:var(--surface);border:1px solid var(--border);border-radius:12px;padding:16px 18px;margin:0 0 28px;',
    'display:grid;grid-template-columns:minmax(0,1fr) minmax(0,1.3fr);gap:18px 28px}',
    '.demo-panel h2{font-family:"Barlow Condensed",sans-serif;font-weight:600;font-size:13px;letter-spacing:.08em;',
    'text-transform:uppercase;color:var(--text-2);margin:0 0 10px}',
    '.demo-chips{display:flex;flex-wrap:wrap;gap:6px}',
    '.demo-chip{font:inherit;font-size:12px;border:1px solid var(--border-2);background:var(--surface);color:var(--text);',
    'border-radius:999px;padding:4px 10px;cursor:pointer;transition:background .15s var(--ease-out)}',
    '.demo-chip:hover{background:var(--surface-2)}',
    '.demo-chip span{color:var(--text-2)}',
    '.demo-form{display:grid;gap:8px}',
    '.demo-species{display:grid;grid-template-columns:repeat(3,minmax(0,1fr));gap:6px}',
    '.demo-species label{display:flex;gap:4px;align-items:center;min-width:0}',
    '.demo-species input[type=text]{min-width:0;flex:1}',
    '.demo-form input,.demo-form select{font:inherit;font-size:12.5px;color:var(--text);background:var(--surface);',
    'border:1px solid var(--border-2);border-radius:6px;padding:4px 6px}',
    '.demo-form input[type=number]{width:52px}',
    '.demo-row{display:flex;flex-wrap:wrap;gap:8px 14px;align-items:center}',
    '.demo-form button{font:inherit;font-size:12.5px;font-weight:600;color:#fff;background:var(--text);border:0;',
    'border-radius:6px;padding:6px 14px;cursor:pointer}',
    '.demo-note{font-size:11.5px;color:var(--text-2);margin:8px 0 0}',
    '@media (max-width:760px){.demo-panel{grid-template-columns:1fr}.demo-species{grid-template-columns:repeat(2,minmax(0,1fr))}}'
  ].join('');

  function el(html) {
    var t = document.createElement('template');
    t.innerHTML = html.trim();
    return t.content.firstChild;
  }

  function strip() {
    var date = new Date(dashboard.recordedAt).toLocaleDateString('es-ES', { day: 'numeric', month: 'long', year: 'numeric' });
    var what = page === 'dashboard'
      ? 'Repetición de datos reales de <code>/Dashboard/Stats</code> grabados el ' + date +
        ' mientras 5 workers procesaban ' + dashboard.burst + ' solicitudes enviadas en ' + dashboard.loadSeconds + ' s.'
      : 'Simulaciones grabadas del servicio real el ' + date + ' y simulaciones ejecutadas en el navegador con las mismas reglas.';
    return el(
      '<div class="demo-strip" role="note">' +
        '<p><strong>Demo estática.</strong> ' + what + ' Para ejecutarlo completo con Docker, ' +
        '<a href="' + REPO + '#getting-started">consulta el repositorio</a>.</p>' +
        '<nav aria-label="Demo">' +
          '<a href="./"' + (page === 'visualizer' ? ' aria-current="page"' : '') + '>Visualizador</a>' +
          '<a href="dashboard.html"' + (page === 'dashboard' ? ' aria-current="page"' : '') + '>Dashboard</a>' +
          '<a href="doc/">Javadoc</a>' +
          '<a href="' + REPO + '">Código</a>' +
        '</nav>' +
      '</div>');
  }

  var SPECIES = ['Rojo', 'Azul', 'Verde', 'Amarillo', 'Naranja', 'Morado'];
  var DEFAULT_QTY = [6, 6, 6, 0, 0, 0];

  function panel() {
    var chips = Object.keys(recorded).map(Number).sort(function (a, b) {
      var A = recorded[a], B = recorded[b];
      if (A.mode !== B.mode) return A.mode === 'standard' ? -1 : 1;
      return (B.params.names.length - A.params.names.length) || a - b;
    }).map(function (tok) {
      var s = recorded[tok];
      return '<button type="button" class="demo-chip" data-tok="' + tok + '">' + tok +
        ' <span>· ' + s.mode + ' · ' + s.params.names.length + ' esp.</span></button>';
    }).join('');
    var rows = SPECIES.map(function (n, i) {
      return '<label><input type="text" value="' + n + '" aria-label="Nombre de la especie ' + (i + 1) + '">' +
        '<input type="number" min="0" max="64" value="' + DEFAULT_QTY[i] + '" aria-label="Cantidad de ' + n + '"></label>';
    }).join('');
    return el(
      '<section class="demo-panel" aria-label="Demo">' +
        '<div><h2>Grabadas del servicio</h2><div class="demo-chips">' + chips + '</div>' +
          '<p class="demo-note">Respuestas reales de /Estadisticas, en modo standard y advanced.</p></div>' +
        '<form class="demo-form"><h2>Nueva simulación en el navegador</h2>' +
          '<div class="demo-species">' + rows + '</div>' +
          '<div class="demo-row">' +
            '<label>Modo <select name="mode"><option>standard</option><option>advanced</option></select></label>' +
            '<label>Semilla <input type="number" name="seed" placeholder="aleatoria" style="width:96px"></label>' +
            '<button type="submit">Simular</button>' +
          '</div>' +
          '<p class="demo-note">Las especies con cantidad 0 no participan. Con la misma semilla, el resultado coincide con el del servicio Java.</p>' +
        '</form>' +
      '</section>');
  }

  function load(tok) {
    document.getElementById('tokenInput').value = tok;
    if (typeof window.cargar === 'function') window.cargar();
  }

  function initVisualizer(layout) {
    var p = panel();
    layout.insertBefore(p, layout.querySelector('.divider'));

    p.querySelectorAll('.demo-chip').forEach(function (b) {
      b.addEventListener('click', function () { load(b.getAttribute('data-tok')); });
    });

    p.querySelector('form').addEventListener('submit', function (e) {
      e.preventDefault();
      var names = [], quantities = [];
      p.querySelectorAll('.demo-species label').forEach(function (l) {
        var inputs = l.querySelectorAll('input');
        var q = parseInt(inputs[1].value, 10);
        if (q > 0) { names.push(inputs[0].value.trim() || 'Especie'); quantities.push(Math.min(q, 64)); }
      });
      if (!names.length) { names.push(SPECIES[0]); quantities.push(1); }
      var mode = p.querySelector('[name=mode]').value;
      var seedVal = p.querySelector('[name=seed]').value;
      var tok;
      do { tok = 10000 + Math.floor(Math.random() * 90000); } while (recorded[tok] || generated[tok]);
      var data = LifeSim.simulate({ mode: mode, names: names, quantities: quantities, seed: seedVal === '' ? null : Number(seedVal) });
      generated[tok] = { mode: mode, names: names, data: data };
      saveGenerated();
      load(tok);
    });

    // Open the first recorded simulation so the page is not empty
    var first = p.querySelector('.demo-chip');
    if (first) load(first.getAttribute('data-tok'));
  }

  function initDashboard() {
    // The page labels its status "En vivo"; in the demo it is a replay
    var txt = document.getElementById('statusText');
    if (!txt) return;
    var relabel = function () { if (txt.textContent === 'En vivo') txt.textContent = 'Repetición'; };
    relabel();
    new MutationObserver(relabel).observe(txt, { childList: true, characterData: true, subtree: true });
  }

  document.addEventListener('DOMContentLoaded', function () {
    var style = document.createElement('style');
    style.textContent = css;
    document.head.appendChild(style);
    ready.then(function () {
      var layout = document.querySelector('.layout');
      layout.insertBefore(strip(), layout.firstChild);
      if (page === 'dashboard') initDashboard(); else initVisualizer(layout);
    });
  });
})();
