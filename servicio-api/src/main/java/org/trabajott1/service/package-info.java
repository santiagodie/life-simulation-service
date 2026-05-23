/**
 * Paquete que contiene la lógica de negocio del microservicio API.
 *
 * <p>Cada servicio encapsula las operaciones de su dominio e interactúa con los repositorios
 * JPA y con RabbitMQ para orquestar el flujo de simulación:
 * <ul>
 *   <li>{@link org.trabajott1.service.SolicitudService} — crea solicitudes de simulación,
 *       las persiste y publica el mensaje en RabbitMQ.</li>
 *   <li>{@link org.trabajott1.service.ResultadosService} — consulta los resultados de una
 *       simulación a partir de su token de solicitud.</li>
 *   <li>{@link org.trabajott1.service.EmailService} — envía notificaciones por correo electrónico
 *       al usuario cuando la simulación finaliza.</li>
 * </ul>
 *
 * @author Lucas, Ana, Clara, Santiago
 * @version 1.0
 */
package org.trabajott1.service;
