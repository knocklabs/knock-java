// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.Enum
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.immutableEmptyMap
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
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A message delivery log */
@NoAutoDetect
class MessageDeliveryLog
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("__typename")
    @ExcludeMissing
    private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("environment_id")
    @ExcludeMissing
    private val environmentId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("inserted_at")
    @ExcludeMissing
    private val insertedAt: JsonField<String> = JsonMissing.of(),
    @JsonProperty("request")
    @ExcludeMissing
    private val request: JsonField<Request> = JsonMissing.of(),
    @JsonProperty("response")
    @ExcludeMissing
    private val response: JsonField<Response> = JsonMissing.of(),
    @JsonProperty("service_name")
    @ExcludeMissing
    private val serviceName: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun id(): String = id.getRequired("id")

    fun _typename(): String = _typename.getRequired("__typename")

    fun environmentId(): String = environmentId.getRequired("environment_id")

    fun insertedAt(): String = insertedAt.getRequired("inserted_at")

    /** A message delivery log request */
    fun request(): Request = request.getRequired("request")

    /** A message delivery log response */
    fun response(): Response = response.getRequired("response")

    fun serviceName(): String = serviceName.getRequired("service_name")

    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    @JsonProperty("environment_id")
    @ExcludeMissing
    fun _environmentId(): JsonField<String> = environmentId

    @JsonProperty("inserted_at") @ExcludeMissing fun _insertedAt(): JsonField<String> = insertedAt

    /** A message delivery log request */
    @JsonProperty("request") @ExcludeMissing fun _request(): JsonField<Request> = request

    /** A message delivery log response */
    @JsonProperty("response") @ExcludeMissing fun _response(): JsonField<Response> = response

    @JsonProperty("service_name")
    @ExcludeMissing
    fun _serviceName(): JsonField<String> = serviceName

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

        fun id(id: JsonField<String>) = apply { this.id = id }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        fun environmentId(environmentId: String) = environmentId(JsonField.of(environmentId))

        fun environmentId(environmentId: JsonField<String>) = apply {
            this.environmentId = environmentId
        }

        fun insertedAt(insertedAt: String) = insertedAt(JsonField.of(insertedAt))

        fun insertedAt(insertedAt: JsonField<String>) = apply { this.insertedAt = insertedAt }

        /** A message delivery log request */
        fun request(request: Request) = request(JsonField.of(request))

        /** A message delivery log request */
        fun request(request: JsonField<Request>) = apply { this.request = request }

        /** A message delivery log response */
        fun response(response: Response) = response(JsonField.of(response))

        /** A message delivery log response */
        fun response(response: JsonField<Response>) = apply { this.response = response }

        fun serviceName(serviceName: String) = serviceName(JsonField.of(serviceName))

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

        fun build(): MessageDeliveryLog =
            MessageDeliveryLog(
                checkRequired("id", id),
                checkRequired("_typename", _typename),
                checkRequired("environmentId", environmentId),
                checkRequired("insertedAt", insertedAt),
                checkRequired("request", request),
                checkRequired("response", response),
                checkRequired("serviceName", serviceName),
                additionalProperties.toImmutable(),
            )
    }

    /** A message delivery log request */
    @NoAutoDetect
    class Request
    @JsonCreator
    private constructor(
        @JsonProperty("body") @ExcludeMissing private val body: JsonField<Body> = JsonMissing.of(),
        @JsonProperty("headers")
        @ExcludeMissing
        private val headers: JsonField<Headers> = JsonMissing.of(),
        @JsonProperty("host")
        @ExcludeMissing
        private val host: JsonField<String> = JsonMissing.of(),
        @JsonProperty("method")
        @ExcludeMissing
        private val method: JsonField<Method> = JsonMissing.of(),
        @JsonProperty("path")
        @ExcludeMissing
        private val path: JsonField<String> = JsonMissing.of(),
        @JsonProperty("query")
        @ExcludeMissing
        private val query: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun body(): Optional<Body> = Optional.ofNullable(body.getNullable("body"))

        fun headers(): Optional<Headers> = Optional.ofNullable(headers.getNullable("headers"))

        fun host(): Optional<String> = Optional.ofNullable(host.getNullable("host"))

        fun method(): Optional<Method> = Optional.ofNullable(method.getNullable("method"))

        fun path(): Optional<String> = Optional.ofNullable(path.getNullable("path"))

        fun query(): Optional<String> = Optional.ofNullable(query.getNullable("query"))

        @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<Body> = body

        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

        @JsonProperty("host") @ExcludeMissing fun _host(): JsonField<String> = host

        @JsonProperty("method") @ExcludeMissing fun _method(): JsonField<Method> = method

        @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

        @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Request = apply {
            if (validated) {
                return@apply
            }

            body().ifPresent { it.validate() }
            headers().ifPresent { it.validate() }
            host()
            method()
            path()
            query()
            validated = true
        }

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

            fun body(body: Body) = body(JsonField.of(body))

            fun body(body: JsonField<Body>) = apply { this.body = body }

            fun body(string: String) = body(Body.ofString(string))

            fun body(unionMember1: Body.UnionMember1) = body(Body.ofUnionMember1(unionMember1))

            fun headers(headers: Headers?) = headers(JsonField.ofNullable(headers))

            fun headers(headers: Optional<Headers>) = headers(headers.getOrNull())

            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

            fun host(host: String) = host(JsonField.of(host))

            fun host(host: JsonField<String>) = apply { this.host = host }

            fun method(method: Method) = method(JsonField.of(method))

            fun method(method: JsonField<Method>) = apply { this.method = method }

            fun path(path: String) = path(JsonField.of(path))

            fun path(path: JsonField<String>) = apply { this.path = path }

            fun query(query: String?) = query(JsonField.ofNullable(query))

            fun query(query: Optional<String>) = query(query.getOrNull())

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

            fun build(): Request =
                Request(
                    body,
                    headers,
                    host,
                    method,
                    path,
                    query,
                    additionalProperties.toImmutable(),
                )
        }

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

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    string != null -> visitor.visitString(string)
                    unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                    else -> visitor.unknown(_json)
                }
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

                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                        return Body(string = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<UnionMember1>()) { it.validate() }
                        ?.let {
                            return Body(unionMember1 = it, _json = json)
                        }

                    return Body(_json = json)
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

            @NoAutoDetect
            class UnionMember1
            @JsonCreator
            private constructor(
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): UnionMember1 = apply {
                    if (validated) {
                        return@apply
                    }

                    validated = true
                }

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

                    fun build(): UnionMember1 = UnionMember1(additionalProperties.toImmutable())
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

        @NoAutoDetect
        class Headers
        @JsonCreator
        private constructor(
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Headers = apply {
                if (validated) {
                    return@apply
                }

                validated = true
            }

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

                fun build(): Headers = Headers(additionalProperties.toImmutable())
            }

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
    @NoAutoDetect
    class Response
    @JsonCreator
    private constructor(
        @JsonProperty("body") @ExcludeMissing private val body: JsonField<Body> = JsonMissing.of(),
        @JsonProperty("headers")
        @ExcludeMissing
        private val headers: JsonField<Headers> = JsonMissing.of(),
        @JsonProperty("status")
        @ExcludeMissing
        private val status: JsonField<Long> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun body(): Optional<Body> = Optional.ofNullable(body.getNullable("body"))

        fun headers(): Optional<Headers> = Optional.ofNullable(headers.getNullable("headers"))

        fun status(): Optional<Long> = Optional.ofNullable(status.getNullable("status"))

        @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<Body> = body

        @JsonProperty("headers") @ExcludeMissing fun _headers(): JsonField<Headers> = headers

        @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Long> = status

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

            fun body(body: Body) = body(JsonField.of(body))

            fun body(body: JsonField<Body>) = apply { this.body = body }

            fun body(string: String) = body(Body.ofString(string))

            fun body(unionMember1: Body.UnionMember1) = body(Body.ofUnionMember1(unionMember1))

            fun headers(headers: Headers?) = headers(JsonField.ofNullable(headers))

            fun headers(headers: Optional<Headers>) = headers(headers.getOrNull())

            fun headers(headers: JsonField<Headers>) = apply { this.headers = headers }

            fun status(status: Long) = status(JsonField.of(status))

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

            fun build(): Response =
                Response(body, headers, status, additionalProperties.toImmutable())
        }

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

            fun <T> accept(visitor: Visitor<T>): T {
                return when {
                    string != null -> visitor.visitString(string)
                    unionMember1 != null -> visitor.visitUnionMember1(unionMember1)
                    else -> visitor.unknown(_json)
                }
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

                    tryDeserialize(node, jacksonTypeRef<String>())?.let {
                        return Body(string = it, _json = json)
                    }
                    tryDeserialize(node, jacksonTypeRef<UnionMember1>()) { it.validate() }
                        ?.let {
                            return Body(unionMember1 = it, _json = json)
                        }

                    return Body(_json = json)
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

            @NoAutoDetect
            class UnionMember1
            @JsonCreator
            private constructor(
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): UnionMember1 = apply {
                    if (validated) {
                        return@apply
                    }

                    validated = true
                }

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

                    fun build(): UnionMember1 = UnionMember1(additionalProperties.toImmutable())
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

        @NoAutoDetect
        class Headers
        @JsonCreator
        private constructor(
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
        ) {

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Headers = apply {
                if (validated) {
                    return@apply
                }

                validated = true
            }

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

                fun build(): Headers = Headers(additionalProperties.toImmutable())
            }

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
