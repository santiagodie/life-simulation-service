/**
 * Paquete que contiene la lógica de simulación del microservicio Worker.
 *
 * <p>Incluye:
 * <ul>
 *   <li>{@link org.trabajott1.service.ISimulationService} — interfaz que define el contrato
 *       para ejecutar una simulación de vida artificial.</li>
 *   <li>{@link org.trabajott1.service.SimulationListener} — listener de RabbitMQ que recibe
 *       mensajes de solicitud de simulación y delega su ejecución en la implementación activa.</li>
 *   <li>{@link org.trabajott1.service.StandardSimulationService} — implementación estándar
 *       del algoritmo de simulación basado en el modelo de Lotka-Volterra discreto.</li>
 *   <li>{@link org.trabajott1.service.AdvancedSimulationService} — implementación avanzada
 *       que extiende el modelo estándar con comportamientos adicionales entre entidades.</li>
 * </ul>
 *
 * @author Lucas, Ana, Clara, Santiago
 * @version 1.0
 */
package org.trabajott1.service;
