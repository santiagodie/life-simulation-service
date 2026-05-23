package org.trabajott1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.Objects;

/**
 * Respuesta del endpoint de creación de solicitudes de simulación.
 * Contiene el resultado de la operación y el token único asignado a la solicitud creada.
 *
 * @author Lucas, Ana, Clara, Santiago
 * @version 1.0
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-14T15:27:37.393153+02:00[Europe/Madrid]", comments = "Generator version: 7.21.0")
public class SolicitudResponse {

    /** Indica si la solicitud se creó correctamente. */
    private @Nullable Boolean done;

    /** Token único asignado a la solicitud de simulación recién creada. */
    private @Nullable Integer tokenSolicitud;

    /** Mensaje de error si la creación no fue exitosa; no presente si fue correcta. */
    private JsonNullable<String> errorMessage = JsonNullable.<String>undefined();

    /** Dato adicional de confirmación de la operación. */
    private @Nullable Boolean data;

    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
    }

    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
    }

    /**
     * Establece el estado de la operación usando el patrón builder.
     *
     * @param done {@code true} si la creación fue exitosa, {@code false} o {@code null} en caso contrario
     * @return esta misma instancia para encadenamiento de llamadas
     */
    public SolicitudResponse done(@Nullable Boolean done) {
        this.done = done;
        return this;
    }

    /**
     * Indica si la solicitud de simulación se creó correctamente.
     *
     * @return {@code true} si la creación fue exitosa, {@code false} o {@code null} en caso contrario
     */
    @Schema(name = "done", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("done")
    public @Nullable Boolean getDone() {
        return done;
    }

    /**
     * Establece si la solicitud de simulación se creó correctamente.
     *
     * @param done {@code true} si la creación fue exitosa, {@code false} o {@code null} en caso contrario
     */
    @JsonProperty("done")
    public void setDone(@Nullable Boolean done) {
        this.done = done;
    }

    /**
     * Establece el token de la solicitud usando el patrón builder.
     *
     * @param tokenSolicitud token único asignado a la solicitud recién creada
     * @return esta misma instancia para encadenamiento de llamadas
     */
    public SolicitudResponse tokenSolicitud(@Nullable Integer tokenSolicitud) {
        this.tokenSolicitud = tokenSolicitud;
        return this;
    }

    /**
     * Devuelve el token único asignado a la solicitud de simulación recién creada.
     *
     * @return token de la solicitud, o {@code null} si aún no ha sido asignado
     */
    @Schema(name = "tokenSolicitud", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("tokenSolicitud")
    public @Nullable Integer getTokenSolicitud() {
        return tokenSolicitud;
    }

    /**
     * Establece el token único de la solicitud de simulación.
     *
     * @param tokenSolicitud token asignado a la solicitud
     */
    @JsonProperty("tokenSolicitud")
    public void setTokenSolicitud(@Nullable Integer tokenSolicitud) {
        this.tokenSolicitud = tokenSolicitud;
    }

    /**
     * Establece el mensaje de error usando el patrón builder.
     *
     * @param errorMessage mensaje de error a incluir en la respuesta
     * @return esta misma instancia para encadenamiento de llamadas
     */
    public SolicitudResponse errorMessage(String errorMessage) {
        this.errorMessage = JsonNullable.of(errorMessage);
        return this;
    }

    /**
     * Devuelve el mensaje de error de la operación, si hubo alguno.
     *
     * @return mensaje de error envuelto en {@link org.openapitools.jackson.nullable.JsonNullable},
     *         o no presente si la operación fue exitosa
     */
    @Schema(name = "errorMessage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("errorMessage")
    public JsonNullable<String> getErrorMessage() {
        return errorMessage;
    }

    /**
     * Establece el mensaje de error de la operación.
     *
     * @param errorMessage mensaje de error envuelto en {@link org.openapitools.jackson.nullable.JsonNullable}
     */
    public void setErrorMessage(JsonNullable<String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Establece el dato de confirmación usando el patrón builder.
     *
     * @param data dato adicional de confirmación de la operación
     * @return esta misma instancia para encadenamiento de llamadas
     */
    public SolicitudResponse data(@Nullable Boolean data) {
        this.data = data;
        return this;
    }

    /**
     * Devuelve el dato adicional de confirmación de la operación.
     *
     * @return {@code true} si la operación incluye confirmación adicional, {@code false} o {@code null} en caso contrario
     */
    @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("data")
    public @Nullable Boolean getData() {
        return data;
    }

    /**
     * Establece el dato adicional de confirmación de la operación.
     *
     * @param data dato de confirmación
     */
    @JsonProperty("data")
    public void setData(@Nullable Boolean data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SolicitudResponse solicitudResponse = (SolicitudResponse) o;
        return Objects.equals(this.done, solicitudResponse.done) &&
                Objects.equals(this.tokenSolicitud, solicitudResponse.tokenSolicitud) &&
                equalsNullable(this.errorMessage, solicitudResponse.errorMessage) &&
                Objects.equals(this.data, solicitudResponse.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(done, tokenSolicitud, hashCodeNullable(errorMessage), data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SolicitudResponse {\n");
        sb.append("    done: ").append(toIndentedString(done)).append("\n");
        sb.append("    tokenSolicitud: ").append(toIndentedString(tokenSolicitud)).append("\n");
        sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convierte el objeto dado a cadena de texto con cada línea indentada 4 espacios
     * (excepto la primera).
     *
     * @param o objeto a convertir; puede ser {@code null}
     * @return representación en texto del objeto indentada, o {@code "null"} si el objeto es {@code null}
     */
    private String toIndentedString(@Nullable Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }
}

