/**
 * Paquete que contiene las implementaciones reales de los delegates de la API.
 *
 * <p>Contiene las implementaciones de los delegates de la API y los controladores REST adicionales:
 * <ul>
 *   <li>{@link org.trabajott1.api.impl.EmailApiDelegateImpl} — implementa {@link org.trabajott1.api.EmailApiDelegate}.</li>
 *   <li>{@link org.trabajott1.api.impl.ResultadosApiDelegateImpl} — implementa {@link org.trabajott1.api.ResultadosApiDelegate}.</li>
 *   <li>{@link org.trabajott1.api.impl.SolicitudApiDelegateImpl} — implementa {@link org.trabajott1.api.SolicitudApiDelegate}.</li>
 *   <li>{@link org.trabajott1.api.impl.DashboardController} — expone métricas de RabbitMQ en tiempo real.</li>
 *   <li>{@link org.trabajott1.api.impl.EstadisticasController} — expone estadísticas agregadas de simulación.</li>
 * </ul>
 *
 * <p>Este paquete contiene el único código escrito a mano en la capa de API;
 * el resto es generado automáticamente por OpenAPI Generator.
 *
 * @author Lucas, Ana, Clara, Santiago
 * @version 1.0
 */
package org.trabajott1.api.impl;
