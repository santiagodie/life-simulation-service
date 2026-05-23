package org.trabajott1.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Modelo de error estándar para la API, basado en el estándar RFC 7807 (Problem Details for HTTP APIs).
 * Se usa para devolver información estructurada cuando ocurre un error en algún endpoint.
 *
 * @author Lucas, Ana, Clara, Santiago
 * @version 1.0
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-04-14T15:27:37.393153+02:00[Europe/Madrid]", comments = "Generator version: 7.21.0")
public class ProblemDetails {

    /** URI que identifica el tipo de problema (p.ej. una URL de documentación del error). */
    private JsonNullable<String> type = JsonNullable.<String>undefined();

    /** Resumen breve del tipo de problema, legible por humanos. */
    private JsonNullable<String> title = JsonNullable.<String>undefined();

    /** Código de estado HTTP asociado al problema. */
    private JsonNullable<Integer> status = JsonNullable.<Integer>undefined();

    /** Explicación detallada del problema concreto que ha ocurrido. */
    private JsonNullable<String> detail = JsonNullable.<String>undefined();

    /** URI que identifica la instancia específica donde ocurrió el problema. */
    private JsonNullable<String> instance = JsonNullable.<String>undefined();

    /** Propiedades adicionales no declaradas explícitamente en el esquema de la API. */
    private Map<String, Object> additionalProperties;

    /**
     * Compara dos valores {@link JsonNullable} considerando iguales solo los pares en que ambos están presentes
     * y sus contenidos son profundamente iguales.
     *
     * @param <T> tipo del valor envuelto
     * @param a   primer valor nullable
     * @param b   segundo valor nullable
     * @return {@code true} si ambos están presentes y sus contenidos son iguales, o si son la misma referencia
     */
    private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
        return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
    }

    /**
     * Calcula el hash code de un valor {@link JsonNullable}.
     *
     * @param <T> tipo del valor envuelto
     * @param a   valor nullable del que se calcula el hash
     * @return hash basado en el contenido si está presente, {@code 31} si está vacío, o {@code 1} si es {@code null}
     */
    private static <T> int hashCodeNullable(JsonNullable<T> a) {
        if (a == null) {
            return 1;
        }
        return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
    }

    /**
     * Establece el campo {@code type} usando la API fluida del builder.
     *
     * @param type URI que identifica el tipo de problema
     * @return esta misma instancia para encadenar llamadas
     */
    public ProblemDetails type(String type) {
        this.type = JsonNullable.of(type);
        return this;
    }

    /**
     * Obtiene la URI que identifica el tipo de problema.
     *
     * @return URI del tipo de problema envuelta en {@link JsonNullable}
     */
    @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("type")
    public JsonNullable<String> getType() {
        return type;
    }

    /**
     * Establece la URI que identifica el tipo de problema.
     *
     * @param type URI del tipo de problema
     */
    public void setType(JsonNullable<String> type) {
        this.type = type;
    }

    /**
     * Establece el campo {@code title} usando la API fluida del builder.
     *
     * @param title resumen breve del tipo de problema
     * @return esta misma instancia para encadenar llamadas
     */
    public ProblemDetails title(String title) {
        this.title = JsonNullable.of(title);
        return this;
    }

    /**
     * Obtiene el resumen breve del tipo de problema.
     *
     * @return título del problema envuelto en {@link JsonNullable}
     */
    @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("title")
    public JsonNullable<String> getTitle() {
        return title;
    }

    /**
     * Establece el resumen breve del tipo de problema.
     *
     * @param title título del problema
     */
    public void setTitle(JsonNullable<String> title) {
        this.title = title;
    }

    /**
     * Establece el campo {@code status} usando la API fluida del builder.
     *
     * @param status código de estado HTTP asociado al problema
     * @return esta misma instancia para encadenar llamadas
     */
    public ProblemDetails status(Integer status) {
        this.status = JsonNullable.of(status);
        return this;
    }

    /**
     * Obtiene el código de estado HTTP asociado al problema.
     *
     * @return código de estado HTTP envuelto en {@link JsonNullable}
     */
    @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("status")
    public JsonNullable<Integer> getStatus() {
        return status;
    }

    /**
     * Establece el código de estado HTTP asociado al problema.
     *
     * @param status código de estado HTTP
     */
    public void setStatus(JsonNullable<Integer> status) {
        this.status = status;
    }

    /**
     * Establece el campo {@code detail} usando la API fluida del builder.
     *
     * @param detail explicación detallada del problema concreto
     * @return esta misma instancia para encadenar llamadas
     */
    public ProblemDetails detail(String detail) {
        this.detail = JsonNullable.of(detail);
        return this;
    }

    /**
     * Obtiene la explicación detallada del problema concreto que ha ocurrido.
     *
     * @return detalle del problema envuelto en {@link JsonNullable}
     */
    @Schema(name = "detail", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("detail")
    public JsonNullable<String> getDetail() {
        return detail;
    }

    /**
     * Establece la explicación detallada del problema concreto.
     *
     * @param detail descripción del problema
     */
    public void setDetail(JsonNullable<String> detail) {
        this.detail = detail;
    }

    /**
     * Establece el campo {@code instance} usando la API fluida del builder.
     *
     * @param instance URI que identifica la instancia específica donde ocurrió el problema
     * @return esta misma instancia para encadenar llamadas
     */
    public ProblemDetails instance(String instance) {
        this.instance = JsonNullable.of(instance);
        return this;
    }

    /**
     * Obtiene la URI que identifica la instancia específica donde ocurrió el problema.
     *
     * @return URI de instancia envuelta en {@link JsonNullable}
     */
    @Schema(name = "instance", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("instance")
    public JsonNullable<String> getInstance() {
        return instance;
    }

    /**
     * Establece la URI que identifica la instancia específica donde ocurrió el problema.
     *
     * @param instance URI de la instancia
     */
    public void setInstance(JsonNullable<String> instance) {
        this.instance = instance;
    }

    /**
     * Establece una propiedad adicional (no declarada en el esquema) con el nombre y valor indicados.
     * Si la propiedad ya existe, su valor es reemplazado.
     *
     * @param key   nombre de la propiedad adicional
     * @param value valor de la propiedad adicional
     * @return esta misma instancia para encadenamiento de llamadas
     */
    @JsonAnySetter
    public ProblemDetails putAdditionalProperty(String key, Object value) {
        if (this.additionalProperties == null) {
            this.additionalProperties = new HashMap<String, Object>();
        }
        this.additionalProperties.put(key, value);
        return this;
    }

    /**
     * Devuelve todas las propiedades adicionales (no declaradas en el esquema).
     *
     * @return mapa con todas las propiedades adicionales, o {@code null} si no hay ninguna
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    /**
     * Devuelve el valor de la propiedad adicional (no declarada en el esquema) con el nombre indicado.
     *
     * @param key nombre de la propiedad adicional a recuperar
     * @return valor de la propiedad, o {@code null} si no existe o no hay propiedades adicionales
     */
    public Object getAdditionalProperty(String key) {
        if (this.additionalProperties == null) {
            return null;
        }
        return this.additionalProperties.get(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProblemDetails problemDetails = (ProblemDetails) o;
        return equalsNullable(this.type, problemDetails.type) &&
                equalsNullable(this.title, problemDetails.title) &&
                equalsNullable(this.status, problemDetails.status) &&
                equalsNullable(this.detail, problemDetails.detail) &&
                equalsNullable(this.instance, problemDetails.instance) &&
                Objects.equals(this.additionalProperties, problemDetails.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hashCodeNullable(type), hashCodeNullable(title), hashCodeNullable(status), hashCodeNullable(detail), hashCodeNullable(instance), additionalProperties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProblemDetails {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
        sb.append("    instance: ").append(toIndentedString(instance)).append("\n");

        sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
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

