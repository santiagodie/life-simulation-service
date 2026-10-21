#!/usr/bin/env bash
# Assembles the static GitHub Pages site:
#   /            visualiser (simulacion.html) with the demo layer
#   /dashboard.html
#   /doc/        aggregated Javadoc (run `mvn javadoc:aggregate` first)
set -euo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
OUT="${1:-$ROOT/_site}"
STATIC="$ROOT/servicio-api/src/main/resources/static"

rm -rf "$OUT"
mkdir -p "$OUT/demo"
for page in simulacion.html dashboard.html; do
  sed 's#</head>#  <script src="demo/sim.js"></script>\n  <script src="demo/demo.js"></script>\n</head>#' "$STATIC/$page" > "$OUT/$page"
done
cp "$OUT/simulacion.html" "$OUT/index.html"
cp -r "$ROOT/demo/sim.js" "$ROOT/demo/demo.js" "$ROOT/demo/data" "$OUT/demo/"
if [ -d "$ROOT/target/site/apidocs" ]; then
  cp -r "$ROOT/target/site/apidocs" "$OUT/doc"
fi
echo "Site written to $OUT"
