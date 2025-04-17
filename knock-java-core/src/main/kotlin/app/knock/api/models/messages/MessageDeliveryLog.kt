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
import app.knock.api.core.toImmutable
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

/** A message delivery log. */
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
     * The unique identifier for the message delivery log.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The typename of the schema.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): String = _typename.getRequired("__typename")

    /**
     * The ID of the environment in which the message delivery occurred.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun environmentId(): String = environmentId.getRequired("environment_id")

    /**
     * Timestamp when the message delivery log was created.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun insertedAt(): String = insertedAt.getRequired("inserted_at")

    /**
     * A message delivery log request.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun request(): Request = request.getRequired("request")

    /**
     * A message delivery log response.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun response(): Response = response.getRequired("response")

    /**
     * The name of the service that processed the delivery.
     *
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

        /** The unique identifier for the message delivery log. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The typename of the schema. */
        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** The ID of the environment in which the message delivery occurred. */
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

        /** Timestamp when the message delivery log was created. */
        fun insertedAt(insertedAt: String) = insertedAt(JsonField.of(insertedAt))

        /**
         * Sets [Builder.insertedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.insertedAt] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun insertedAt(insertedAt: JsonField<String>) = apply { this.insertedAt = insertedAt }

        /** A message delivery log request. */
        fun request(request: Request) = request(JsonField.of(request))

        /**
         * Sets [Builder.request] to an arbitrary JSON value.
         *
         * You should usually call [Builder.request] with a well-typed [Request] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun request(request: JsonField<Request>) = apply { this.request = request }

        /** A message delivery log response. */
        fun response(response: Response) = response(JsonField.of(response))

        /**
         * Sets [Builder.response] to an arbitrary JSON value.
         *
         * You should usually call [Builder.response] with a well-typed [Response] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun response(response: JsonField<Response>) = apply { this.response = response }

        /** The name of the service that processed the delivery. */
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

    /** A message delivery log request. */
    class Request
    private constructor(
        private val body: JsonField<Body>,
        private val headers: JsonField<Headers>,
        private val host: JsonField<String>,
        private val method: JsonField<Method>,
        private val path: JsonField<String>,
        private val query: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("body") @ExcludeMissing body: JsonField<Body> = JsonMissing.of(),
            @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
            @JsonProperty("host") @ExcludeMissing host: JsonField<String> = JsonMissing.of(),
            @JsonProperty("method") @ExcludeMissing method: JsonField<Method> = JsonMissing.of(),
            @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
            @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
        ) : this(body, headers, host, method, path, query, mutableMapOf())

        /**
         * The body content that was sent with the request.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun body(): Optional<Body> = body.getOptional("body")

        /**
         * The headers that were sent with the request.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun headers(): Optional<Headers> = headers.getOptional("headers")

        /**
         * The host to which the request was sent.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun host(): Optional<String> = host.getOptional("host")

        /**
         * The HTTP method used for the request.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun method(): Optional<Method> = method.getOptional("method")

        /**
         * The path of the URL that was requested.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun path(): Optional<String> = path.getOptional("path")

        /**
         * The query string of the URL that was requested.
         *
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
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

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
            private var headers: JsonField<Headers> = JsonMissing.of()
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

            /** The body content that was sent with the request. */
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

            /** Alias for calling [body] with `Body.ofUnionMember1(unionMember1)`. */
            fun body(unionMember1: Body.UnionMember1) = body(Body.ofUnionMember1(unionMember1))

            /** The headers that were sent with the request. */
            fun headers(headers: Headers?) = headers(JsonField.ofNullable(headers))

            /** Alias for calling [Builder.headers] with `headers.orElse(null)`. */
            fun headers(headers: Optional<Headers>) = headers(headers.getOrNull())

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed [Headers] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

            /** The host to which the request was sent. */
            fun host(host: String) = host(JsonField.of(host))

            /**
             * Sets [Builder.host] to an arbitrary JSON value.
             *
             * You should usually call [Builder.host] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun host(host: JsonField<String>) = apply { this.host = host }

            /** The HTTP method used for the request. */
            fun method(method: Method) = method(JsonField.of(method))

            /**
             * Sets [Builder.method] to an arbitrary JSON value.
             *
             * You should usually call [Builder.method] with a well-typed [Method] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun method(method: JsonField<Method>) = apply { this.method = method }

            /** The path of the URL that was requested. */
            fun path(path: String) = path(JsonField.of(path))

            /**
             * Sets [Builder.path] to an arbitrary JSON value.
             *
             * You should usually call [Builder.path] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun path(path: JsonField<String>) = apply { this.path = path }

            /** The query string of the URL that was requested. */
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
            headers().ifPresent { it.validate() }
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
                (headers.asKnown().getOrNull()?.validity() ?: 0) +
                (if (host.asKnown().isPresent) 1 else 0) +
                (method.asKnown().getOrNull()?.validity() ?: 0) +
                (if (path.asKnown().isPresent) 1 else 0) +
                (if (query.asKnown().isPresent) 1 else 0)

        /** The body content that was sent with the request. */
        @JsonDeserialize(using = Body.Deserializer::class)
        @JsonSerialize(using = Body.Serializer::class)
        class Body
        private constructor(
            private val string: String? = null,
            private val unionMember1: UnionMember1? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun unionMember1(): Optional<UnionMember1> = Optional.ofNullable(unionMember1)

            fun isString(): Boolean = string != null

            fun isUnionMember1(): Boolean = unionMember1 != null

            fun asString(): String = string.getOrThrow("string")

            fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
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

                        override fun visitUnionMember1(unionMember1: UnionMember1) {
                            unionMember1.validate()
                        }
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

                        override fun visitUnionMember1(unionMember1: UnionMember1) =
                            unionMember1.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Body && string == other.string && unionMember1 == other.unionMember1 /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, unionMember1) /* spotless:on */

            override fun toString(): String =
                when {
                    string != null -> "Body{string=$string}"
                    unionMember1 != null -> "Body{unionMember1=$unionMember1}"
                    _json != null -> "Body{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Body")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = Body(string = string)

                @JvmStatic
                fun ofUnionMember1(unionMember1: UnionMember1) = Body(unionMember1 = unionMember1)
            }

            /**
             * An interface that defines how to map each variant of [Body] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitUnionMember1(unionMember1: UnionMember1): T

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
                                tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                                    Body(unionMember1 = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Body(string = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from array).
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
                        value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Body")
                    }
                }
            }

            class UnionMember1
            @JsonCreator
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [UnionMember1]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [UnionMember1]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(unionMember1: UnionMember1) = apply {
                        additionalProperties = unionMember1.additionalProperties.toMutableMap()
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [UnionMember1].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): UnionMember1 = UnionMember1(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): UnionMember1 = apply {
                    if (validated) {
                        return@apply
                    }

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
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is UnionMember1 && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "UnionMember1{additionalProperties=$additionalProperties}"
            }
        }

        /** The headers that were sent with the request. */
        class Headers
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Headers]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Headers]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(headers: Headers) = apply {
                    additionalProperties = headers.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Headers].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Headers = Headers(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Headers = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Headers && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "Headers{additionalProperties=$additionalProperties}"
        }

        /** The HTTP method used for the request. */
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

    /** A message delivery log response. */
    class Response
    private constructor(
        private val body: JsonField<Body>,
        private val headers: JsonField<Headers>,
        private val status: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("body") @ExcludeMissing body: JsonField<Body> = JsonMissing.of(),
            @JsonProperty("headers") @ExcludeMissing headers: JsonField<Headers> = JsonMissing.of(),
            @JsonProperty("status") @ExcludeMissing status: JsonField<Long> = JsonMissing.of(),
        ) : this(body, headers, status, mutableMapOf())

        /**
         * The body content that was received with the response.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun body(): Optional<Body> = body.getOptional("body")

        /**
         * The headers that were received with the response.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun headers(): Optional<Headers> = headers.getOptional("headers")

        /**
         * The HTTP status code of the response.
         *
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
         * Returns the raw JSON value of [headers].
         *
         * Unlike [headers], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

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
            private var headers: JsonField<Headers> = JsonMissing.of()
            private var status: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(response: Response) = apply {
                body = response.body
                headers = response.headers
                status = response.status
                additionalProperties = response.additionalProperties.toMutableMap()
            }

            /** The body content that was received with the response. */
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

            /** Alias for calling [body] with `Body.ofUnionMember1(unionMember1)`. */
            fun body(unionMember1: Body.UnionMember1) = body(Body.ofUnionMember1(unionMember1))

            /** The headers that were received with the response. */
            fun headers(headers: Headers?) = headers(JsonField.ofNullable(headers))

            /** Alias for calling [Builder.headers] with `headers.orElse(null)`. */
            fun headers(headers: Optional<Headers>) = headers(headers.getOrNull())

            /**
             * Sets [Builder.headers] to an arbitrary JSON value.
             *
             * You should usually call [Builder.headers] with a well-typed [Headers] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

            /** The HTTP status code of the response. */
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
            headers().ifPresent { it.validate() }
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
                (headers.asKnown().getOrNull()?.validity() ?: 0) +
                (if (status.asKnown().isPresent) 1 else 0)

        /** The body content that was received with the response. */
        @JsonDeserialize(using = Body.Deserializer::class)
        @JsonSerialize(using = Body.Serializer::class)
        class Body
        private constructor(
            private val string: String? = null,
            private val unionMember1: UnionMember1? = null,
            private val _json: JsonValue? = null,
        ) {

            fun string(): Optional<String> = Optional.ofNullable(string)

            fun unionMember1(): Optional<UnionMember1> = Optional.ofNullable(unionMember1)

            fun isString(): Boolean = string != null

            fun isUnionMember1(): Boolean = unionMember1 != null

            fun asString(): String = string.getOrThrow("string")

            fun asUnionMember1(): UnionMember1 = unionMember1.getOrThrow("unionMember1")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
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

                        override fun visitUnionMember1(unionMember1: UnionMember1) {
                            unionMember1.validate()
                        }
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

                        override fun visitUnionMember1(unionMember1: UnionMember1) =
                            unionMember1.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Body && string == other.string && unionMember1 == other.unionMember1 /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, unionMember1) /* spotless:on */

            override fun toString(): String =
                when {
                    string != null -> "Body{string=$string}"
                    unionMember1 != null -> "Body{unionMember1=$unionMember1}"
                    _json != null -> "Body{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Body")
                }

            companion object {

                @JvmStatic fun ofString(string: String) = Body(string = string)

                @JvmStatic
                fun ofUnionMember1(unionMember1: UnionMember1) = Body(unionMember1 = unionMember1)
            }

            /**
             * An interface that defines how to map each variant of [Body] to a value of type [T].
             */
            interface Visitor<out T> {

                fun visitString(string: String): T

                fun visitUnionMember1(unionMember1: UnionMember1): T

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
                                tryDeserialize(node, jacksonTypeRef<UnionMember1>())?.let {
                                    Body(unionMember1 = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Body(string = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from array).
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
                        value.unionMember1 != null -> generator.writeObject(value.unionMember1)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Body")
                    }
                }
            }

            class UnionMember1
            @JsonCreator
            private constructor(
                @com.fasterxml.jackson.annotation.JsonValue
                private val additionalProperties: Map<String, JsonValue>
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [UnionMember1]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [UnionMember1]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(unionMember1: UnionMember1) = apply {
                        additionalProperties = unionMember1.additionalProperties.toMutableMap()
                    }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [UnionMember1].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): UnionMember1 = UnionMember1(additionalProperties.toImmutable())
                }

                private var validated: Boolean = false

                fun validate(): UnionMember1 = apply {
                    if (validated) {
                        return@apply
                    }

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
                    additionalProperties.count { (_, value) ->
                        !value.isNull() && !value.isMissing()
                    }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is UnionMember1 && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "UnionMember1{additionalProperties=$additionalProperties}"
            }
        }

        /** The headers that were received with the response. */
        class Headers
        @JsonCreator
        private constructor(
            @com.fasterxml.jackson.annotation.JsonValue
            private val additionalProperties: Map<String, JsonValue>
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /** Returns a mutable builder for constructing an instance of [Headers]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Headers]. */
            class Builder internal constructor() {

                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(headers: Headers) = apply {
                    additionalProperties = headers.additionalProperties.toMutableMap()
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [Headers].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Headers = Headers(additionalProperties.toImmutable())
            }

            private var validated: Boolean = false

            fun validate(): Headers = apply {
                if (validated) {
                    return@apply
                }

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
                additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Headers && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "Headers{additionalProperties=$additionalProperties}"
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
