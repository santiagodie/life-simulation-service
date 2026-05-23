package org.trabajott1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.Objects;

/**
 * Respuesta del endpoint de consulta de resultados de simulación.
 * Contiene el estado de la operación, el token de la solicitud, los datos de la simulación
 * y un mensaje de error si algo fue mal.
 *
 * @author Lucas, Ana, Clara, Santiago
 * @version 1.0
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-14T15:27:37.393153+02:00[Europe/Madrid]", comments = "Generator version: 7.21.0")
public class ResultsResponse {

    /** Indica si la consulta de resultados fue exitosa. */
    private @Nullable Boolean done;

    /** Token de la solicitud de simulación consultada. */
    private @Nullable Integer tokenSolicitud;

    /** Mensaje de error si la consulta no fue exitosa; no presente si fue correcta. */
    private JsonNullable<String> errorMessage = JsonNullable.<String>undefined();

    /** Datos de la simulación en formato de texto (p.ej. series temporales del grid). */
    private JsonNullable<String> data = JsonNullable.<String>undefined();

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
     * @param done {@code true} si la consulta fue exitosa, {@code false} o {@code null} en caso contrario
     * @return esta misma instancia para encadenamiento de llamadas
     */
    public ResultsResponse done(@Nullable Boolean done) {
        this.done = done;
        return this;
    }

    /**
     * Indica si la consulta de resultados de simulación fue exitosa.
     *
     * @return {@code true} si la consulta fue exitosa, {@code false} o {@code null} en caso contrario
     */
    @Schema(name = "done", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("done")
    public @Nullable Boolean getDone() {
        return done;
    }

    /**
     * Establece si la consulta de resultados fue exitosa.
     *
     * @param done {@code true} si la consulta fue exitosa, {@code false} o {@code null} en caso contrario
     */
    @JsonProperty("done")
    public void setDone(@Nullable Boolean done) {
        this.done = done;
    }

    /**
     * Establece el token de la solicitud consultada usando el patrón builder.
     *
     * @param tokenSolicitud token de la solicitud de simulación consultada
     * @return esta misma instancia para encadenamiento de llamadas
     */
    public ResultsResponse tokenSolicitud(@Nullable Integer tokenSolicitud) {
        this.tokenSolicitud = tokenSolicitud;
        return this;
    }

    /**
     * Devuelve el token de la solicitud de simulación consultada.
     *
     * @return token de la solicitud, o {@code null} si no está definido
     */
    @Schema(name = "tokenSolicitud", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("tokenSolicitud")
    public @Nullable Integer getTokenSolicitud() {
        return tokenSolicitud;
    }

    /**
     * Establece el token de la solicitud de simulación consultada.
     *
     * @param tokenSolicitud token de la solicitud
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
    public ResultsResponse errorMessage(String errorMessage) {
        this.errorMessage = JsonNullable.of(errorMessage);
        return this;
    }

    /**
     * Devuelve el mensaje de error de la consulta, si hubo alguno.
     *
     * @return mensaje de error envuelto en {@link org.openapitools.jackson.nullable.JsonNullable},
     *         o no presente si la consulta fue exitosa
     */
    @Schema(name = "errorMessage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("errorMessage")
    public JsonNullable<String> getErrorMessage() {
        return errorMessage;
    }

    /**
     * Establece el mensaje de error de la consulta.
     *
     * @param errorMessage mensaje de error envuelto en {@link org.openapitools.jackson.nullable.JsonNullable}
     */
    public void setErrorMessage(JsonNullable<String> errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Establece los datos de la simulación usando el patrón builder.
     *
     * @param data datos de la simulación en formato de texto
     * @return esta misma instancia para encadenamiento de llamadas
     */
    public ResultsResponse data(String data) {
        this.data = JsonNullable.of(data);
        return this;
    }

    /**
     * Devuelve los datos de la simulación en formato de texto.
     *
     * @return datos de simulación envueltos en {@link org.openapitools.jackson.nullable.JsonNullable},
     *         o no presente si aún no están disponibles
     */
    @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("data")
    public JsonNullable<String> getData() {
        return data;
    }

    /**
     * Establece los datos de la simulación.
     *
     * @param data datos de la simulación envueltos en {@link org.openapitools.jackson.nullable.JsonNullable}
     */
    public void setData(JsonNullable<String> data) {
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
        ResultsResponse resultsResponse = (ResultsResponse) o;
        return Objects.equals(this.done, resultsResponse.done) &&
                Objects.equals(this.tokenSolicitud, resultsResponse.tokenSolicitud) &&
                equalsNullable(this.errorMessage, resultsResponse.errorMessage) &&
                equalsNullable(this.data, resultsResponse.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(done, tokenSolicitud, hashCodeNullable(errorMessage), hashCodeNullable(data));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResultsResponse {\n");
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

