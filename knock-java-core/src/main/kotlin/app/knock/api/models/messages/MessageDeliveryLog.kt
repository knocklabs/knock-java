// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.Enum
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.allMaxBy
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A message delivery log */
class MessageDeliveryLog
private constructor(
    private val id: JsonField<String>,
    private val _typename: JsonField<String>,
    private val environmentId: JsonField<String>,
    private val insertedAt: JsonField<String>,
    private val request: JsonField<Request>,
    private val response: JsonField<Response>,
    private val serviceName: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("__typename") @ExcludeMissing _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("environment_id")
        @ExcludeMissing
        environmentId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inserted_at")
        @ExcludeMissing
        insertedAt: JsonField<String> = JsonMissing.of(),
        @JsonProperty("request") @ExcludeMissing request: JsonField<Request> = JsonMissing.of(),
        @JsonProperty("response") @ExcludeMissing response: JsonField<Response> = JsonMissing.of(),
        @JsonProperty("service_name")
        @ExcludeMissing
        serviceName: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        _typename,
        environmentId,
        insertedAt,
        request,
        response,
        serviceName,
        mutableMapOf(),
    )

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): String = _typename.getRequired("__typename")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun environmentId(): String = environmentId.getRequired("environment_id")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun insertedAt(): String = insertedAt.getRequired("inserted_at")

    /**
     * A message delivery log request
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun request(): Request = request.getRequired("request")

    /**
     * A message delivery log response
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun response(): Response = response.getRequired("response")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun serviceName(): String = serviceName.getRequired("service_name")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [_typename].
     *
     * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    /**
     * Returns the raw JSON value of [environmentId].
     *
     * Unlike [environmentId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("environment_id")
    @ExcludeMissing
    fun _environmentId(): JsonField<String> = environmentId

    /**
     * Returns the raw JSON value of [insertedAt].
     *
     * Unlike [insertedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inserted_at") @ExcludeMissing fun _insertedAt(): JsonField<String> = insertedAt

    /**
     * Returns the raw JSON value of [request].
     *
     * Unlike [request], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("request") @ExcludeMissing fun _request(): JsonField<Request> = request

    /**
     * Returns the raw JSON value of [response].
     *
     * Unlike [response], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

    /**
     * Returns the raw JSON value of [serviceName].
     *
     * Unlike [serviceName], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("service_name")
    @ExcludeMissing
    fun _serviceName(): JsonField<String> = serviceName

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageDeliveryLog].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .environmentId()
         * .insertedAt()
         * .request()
         * .response()
         * .serviceName()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageDeliveryLog]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var _typename: JsonField<String>? = null
        private var environmentId: JsonField<String>? = null
        private var insertedAt: JsonField<String>? = null
        private var request: JsonField<Request>? = null
        private var response: JsonField<Response>? = null
        private var serviceName: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageDeliveryLog: MessageDeliveryLog) = apply {
            id = messageDeliveryLog.id
            _typename = messageDeliveryLog._typename
            environmentId = messageDeliveryLog.environmentId
            insertedAt = messageDeliveryLog.insertedAt
            request = messageDeliveryLog.request
            response = messageDeliveryLog.response
            serviceName = messageDeliveryLog.serviceName
            additionalProperties = messageDeliveryLog.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        fun environmentId(environmentId: String) = environmentId(JsonField.of(environmentId))

        /**
         * Sets [Builder.environmentId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.environmentId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun environmentId(environmentId: JsonField<String>) = apply {
            this.environmentId = environmentId
        }

        fun insertedAt(insertedAt: String) = insertedAt(JsonField.of(insertedAt))

        /**
         * Sets [Builder.insertedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.insertedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun insertedAt(insertedAt: JsonField<String>) = apply { this.insertedAt = insertedAt }

        /** A message delivery log request */
        fun request(request: Request) = request(JsonField.of(request))

        /**
         * Sets [Builder.request] to an arbitrary JSON value.
         *
         * You should usually call [Builder.request] with a well-typed [Request] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun request(request: JsonField<Request>) = apply { this.request = request }

        /** A message delivery log response */
        fun response(response: Response) = response(JsonField.of(response))

        /**
         * Sets [Builder.response] to an arbitrary JSON value.
         *
         * You should usually call [Builder.response] with a well-typed [Response] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun response(response: JsonField<Response>) = apply { this.response = response }

        fun serviceName(serviceName: String) = serviceName(JsonField.of(serviceName))

        /**
         * Sets [Builder.serviceName] to an arbitrary JSON value.
         *
         * You should usually call [Builder.serviceName] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun serviceName(serviceName: JsonField<String>) = apply { this.serviceName = serviceName }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [MessageDeliveryLog].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .environmentId()
         * .insertedAt()
         * .request()
         * .response()
         * .serviceName()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageDeliveryLog =
            MessageDeliveryLog(
                checkRequired("id", id),
                checkRequired("_typename", _typename),
                checkRequired("environmentId", environmentId),
                checkRequired("insertedAt", insertedAt),
                checkRequired("request", request),
                checkRequired("response", response),
                checkRequired("serviceName", serviceName),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MessageDeliveryLog = apply {
        if (validated) {
            return@apply
        }

        id()
        _typename()
        environmentId()
        insertedAt()
        request().validate()
        response().validate()
        serviceName()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: KnockInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (_typename.asKnown().isPresent) 1 else 0) +
            (if (environmentId.asKnown().isPresent) 1 else 0) +
            (if (insertedAt.asKnown().isPresent) 1 else 0) +
            (request.asKnown().getOrNull()?.validity() ?: 0) +
            (response.asKnown().getOrNull()?.validity() ?: 0) +
            (if (serviceName.asKnown().isPresent) 1 else 0)

    /** A message delivery log request */
    class Request
    private constructor(
        private val body: JsonField<Body>,
        private val headers: JsonValue,
        private val host: JsonField<String>,
        private val method: JsonField<Method>,
        private val path: JsonField<String>,
        private val query: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("body") @ExcludeMissing body: JsonField<Body> = JsonMissing.of(),
            @JsonProperty("headers") @ExcludeMissing headers: JsonValue = JsonMissing.of(),
            @JsonProperty("host") @ExcludeMissing host: JsonField<String> = JsonMissing.of(),
            @JsonProperty("method") @ExcludeMissing method: JsonField<Method> = JsonMissing.of(),
            @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
            @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
        ) : this(body, headers, host, method, path, query, mutableMapOf())

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun body(): Optional<Body> = body.getOptional("body")

        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonValue = headers

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun host(): Optional<String> = host.getOptional("host")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun method(): Optional<Method> = method.getOptional("method")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun path(): Optional<String> = path.getOptional("path")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun query(): Optional<String> = query.getOptional("query")

        /**
         * Returns the raw JSON value of [body].
         *
         * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<Body> = body

        /**
         * Returns the raw JSON value of [host].
         *
         * Unlike [host], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("host") @ExcludeMissing fun _host(): JsonField<String> = host

        /**
         * Returns the raw JSON value of [method].
         *
         * Unlike [method], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("method") @ExcludeMissing fun _method(): JsonField<Method> = method

        /**
         * Returns the raw JSON value of [path].
         *
         * Unlike [path], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

        /**
         * Returns the raw JSON value of [query].
         *
         * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Request]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Request]. */
        class Builder internal constructor() {

            private var body: JsonField<Body> = JsonMissing.of()
            private var headers: JsonValue = JsonMissing.of()
            private var host: JsonField<String> = JsonMissing.of()
            private var method: JsonField<Method> = JsonMissing.of()
            private var path: JsonField<String> = JsonMissing.of()
            private var query: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(request: Request) = apply {
                body = request.body
                headers = request.headers
                host = request.host
                method = request.method
                path = request.path
                query = request.query
                additionalProperties = request.additionalProperties.toMutableMap()
            }

            fun body(body: Body) = body(JsonField.of(body))

            /**
             * Sets [Builder.body] to an arbitrary JSON value.
             *
             * You should usually call [Builder.body] with a well-typed [Body] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun body(body: JsonField<Body>) = apply { this.body = body }

            /** Alias for calling [body] with `Body.ofString(string)`. */
            fun body(string: String) = body(Body.ofString(string))

            /** Alias for calling [body] with `Body.ofJsonValue(jsonValue)`. */
            fun body(jsonValue: JsonValue) = body(Body.ofJsonValue(jsonValue))

            fun headers(headers: JsonValue) = apply { this.headers = headers }

            fun host(host: String) = host(JsonField.of(host))

            /**
             * Sets [Builder.host] to an arbitrary JSON value.
             *
             * You should usually call [Builder.host] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun host(host: JsonField<String>) = apply { this.host = host }

            fun method(method: Method) = method(JsonField.of(method))

            /**
             * Sets [Builder.method] to an arbitrary JSON value.
             *
             * You should usually call [Builder.method] with a well-typed [Method] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun method(method: JsonField<Method>) = apply { this.method = method }

            fun path(path: String) = path(JsonField.of(path))

            /**
             * Sets [Builder.path] to an arbitrary JSON value.
             *
             * You should usually call [Builder.path] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun path(path: JsonField<String>) = apply { this.path = path }

            fun query(query: String?) = query(JsonField.ofNullable(query))

            /** Alias for calling [Builder.query] with `query.orElse(null)`. */
            fun query(query: Optional<String>) = query(query.getOrNull())

            /**
             * Sets [Builder.query] to an arbitrary JSON value.
             *
             * You should usually call [Builder.query] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun query(query: JsonField<String>) = apply { this.query = query }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Request].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Request =
                Request(
                    body,
                    headers,
                    host,
                    method,
                    path,
                    query,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Request = apply {
            if (validated) {
                return@apply
            }

            body().ifPresent { it.validate() }
            host()
            method().ifPresent { it.validate() }
            path()
            query()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: KnockInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (body.asKnown().getOrNull()?.validity() ?: 0) +
                (if (host.asKnown().isPresent) 1 else 0) +
                (method.asKnown().getOrNull()?.validity() ?: 0) +
                (if (path.asKnown().isPresent) 1 else 0) +
                (if (query.asKnown().isPresent) 1 else 0)

        @JsonDeserialize(using = Body.Deserializer::class)
        @JsonSerialize(using = Body.Serializer::class)
        class Body
        private constructor(
            private val string: String? = null,
            private val jsonValue: JsonValue? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun jsonValue(): Optional<JsonValue> = Optional.ofNullable(jsonValue)

            fun isString(): Boolean = string != null

            fun isJsonValue(): Boolean = jsonValue != null

            fun asString(): String = string.getOrThrow("string")

            fun asJsonValue(): JsonValue = jsonValue.getOrThrow("jsonValue")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    jsonValue != null -> visitor.visitJsonValue(jsonValue)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Body = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitJsonValue(jsonValue: JsonValue) {}
                    }
                )
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: KnockInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                accept(
                    object : Visitor<Int> {
                        override fun visitString(string: String) = 1

                        override fun visitJsonValue(jsonValue: JsonValue) = 1

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Body && string == other.string && jsonValue == other.jsonValue /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, jsonValue) /* spotless:on */

            override fun toString(): String =
                when {
                    string != null -> "Body{string=$string}"
                    jsonValue != null -> "Body{jsonValue=$jsonValue}"
                    _json != null -> "Body{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Body")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = Body(string = string)

                @JvmStatic fun ofJsonValue(jsonValue: JsonValue) = Body(jsonValue = jsonValue)
            }

            /**
             * An interface that defines how to map each variant of [Body] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitJsonValue(jsonValue: JsonValue): T

                /**
                 * Maps an unknown variant of [Body] to a value of type [T].
                 *
                 * An instance of [Body] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * @throws KnockInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw KnockInvalidDataException("Unknown Body: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Body>(Body::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Body {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Body(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<JsonValue>())?.let {
                                    Body(jsonValue = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants.
                        0 -> Body(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Body>(Body::class) {

                override fun serialize(
                    value: Body,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.jsonValue != null -> generator.writeObject(value.jsonValue)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Body")
                    }
                }
            }
        }

        class Method @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val GET = of("GET")

                @JvmField val POST = of("POST")

                @JvmField val PUT = of("PUT")

                @JvmField val DELETE = of("DELETE")

                @JvmField val PATCH = of("PATCH")

                @JvmStatic fun of(value: String) = Method(JsonField.of(value))
            }

            /** An enum containing [Method]'s known values. */
            enum class Known {
                GET,
                POST,
                PUT,
                DELETE,
                PATCH,
            }

            /**
             * An enum containing [Method]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Method] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                GET,
                POST,
                PUT,
                DELETE,
                PATCH,
                /**
                 * An enum member indicating that [Method] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    GET -> Value.GET
                    POST -> Value.POST
                    PUT -> Value.PUT
                    DELETE -> Value.DELETE
                    PATCH -> Value.PATCH
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws KnockInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    GET -> Known.GET
                    POST -> Known.POST
                    PUT -> Known.PUT
                    DELETE -> Known.DELETE
                    PATCH -> Known.PATCH
                    else -> throw KnockInvalidDataException("Unknown Method: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws KnockInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    KnockInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): Method = apply {
                if (validated) {
                    return@apply
                }

                known()
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: KnockInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Method && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Request && body == other.body && headers == other.headers && host == other.host && method == other.method && path == other.path && query == other.query && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(body, headers, host, method, path, query, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Request{body=$body, headers=$headers, host=$host, method=$method, path=$path, query=$query, additionalProperties=$additionalProperties}"
    }

    /** A message delivery log response */
    class Response
    private constructor(
        private val body: JsonField<Body>,
        private val headers: JsonValue,
        private val status: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("body") @ExcludeMissing body: JsonField<Body> = JsonMissing.of(),
            @JsonProperty("headers") @ExcludeMissing headers: JsonValue = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Long> = JsonMissing.of(),
        ) : this(body, headers, status, mutableMapOf())

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun body(): Optional<Body> = body.getOptional("body")

        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonValue = headers

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun status(): Optional<Long> = status.getOptional("status")

        /**
         * Returns the raw JSON value of [body].
         *
         * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<Body> = body

        /**
         * Returns the raw JSON value of [status].
         *
         * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Long> = status

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Response]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Response]. */
        class Builder internal constructor() {

            private var body: JsonField<Body> = JsonMissing.of()
            private var headers: JsonValue = JsonMissing.of()
            private var status: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(response: Response) = apply {
                body = response.body
                headers = response.headers
                status = response.status
                additionalProperties = response.additionalProperties.toMutableMap()
            }

            fun body(body: Body) = body(JsonField.of(body))

            /**
             * Sets [Builder.body] to an arbitrary JSON value.
             *
             * You should usually call [Builder.body] with a well-typed [Body] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun body(body: JsonField<Body>) = apply { this.body = body }

            /** Alias for calling [body] with `Body.ofString(string)`. */
            fun body(string: String) = body(Body.ofString(string))

            /** Alias for calling [body] with `Body.ofJsonValue(jsonValue)`. */
            fun body(jsonValue: JsonValue) = body(Body.ofJsonValue(jsonValue))

            fun headers(headers: JsonValue) = apply { this.headers = headers }

            fun status(status: Long) = status(JsonField.of(status))

            /**
             * Sets [Builder.status] to an arbitrary JSON value.
             *
             * You should usually call [Builder.status] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun status(status: JsonField<Long>) = apply { this.status = status }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Response].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Response =
                Response(body, headers, status, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            body().ifPresent { it.validate() }
            status()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: KnockInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (body.asKnown().getOrNull()?.validity() ?: 0) +
                (if (status.asKnown().isPresent) 1 else 0)

        @JsonDeserialize(using = Body.Deserializer::class)
        @JsonSerialize(using = Body.Serializer::class)
        class Body
        private constructor(
            private val string: String? = null,
            private val jsonValue: JsonValue? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun jsonValue(): Optional<JsonValue> = Optional.ofNullable(jsonValue)

            fun isString(): Boolean = string != null

            fun isJsonValue(): Boolean = jsonValue != null

            fun asString(): String = string.getOrThrow("string")

            fun asJsonValue(): JsonValue = jsonValue.getOrThrow("jsonValue")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    jsonValue != null -> visitor.visitJsonValue(jsonValue)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Body = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitJsonValue(jsonValue: JsonValue) {}
                    }
                )
                validated = true
            }

            fun isValid(): Boolean =
                try {
                    validate()
                    true
                } catch (e: KnockInvalidDataException) {
                    false
                }

            /**
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                accept(
                    object : Visitor<Int> {
                        override fun visitString(string: String) = 1

                        override fun visitJsonValue(jsonValue: JsonValue) = 1

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Body && string == other.string && jsonValue == other.jsonValue /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, jsonValue) /* spotless:on */

            override fun toString(): String =
                when {
                    string != null -> "Body{string=$string}"
                    jsonValue != null -> "Body{jsonValue=$jsonValue}"
                    _json != null -> "Body{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Body")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = Body(string = string)

                @JvmStatic fun ofJsonValue(jsonValue: JsonValue) = Body(jsonValue = jsonValue)
            }

            /**
             * An interface that defines how to map each variant of [Body] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitJsonValue(jsonValue: JsonValue): T

                /**
                 * Maps an unknown variant of [Body] to a value of type [T].
                 *
                 * An instance of [Body] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * @throws KnockInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw KnockInvalidDataException("Unknown Body: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Body>(Body::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Body {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Body(string = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<JsonValue>())?.let {
                                    Body(jsonValue = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants.
                        0 -> Body(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Body>(Body::class) {

                override fun serialize(
                    value: Body,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.jsonValue != null -> generator.writeObject(value.jsonValue)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Body")
                    }
                }
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && body == other.body && headers == other.headers && status == other.status && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(body, headers, status, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Response{body=$body, headers=$headers, status=$status, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageDeliveryLog && id == other.id && _typename == other._typename && environmentId == other.environmentId && insertedAt == other.insertedAt && request == other.request && response == other.response && serviceName == other.serviceName && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, environmentId, insertedAt, request, response, serviceName, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageDeliveryLog{id=$id, _typename=$_typename, environmentId=$environmentId, insertedAt=$insertedAt, request=$request, response=$response, serviceName=$serviceName, additionalProperties=$additionalProperties}"
}
