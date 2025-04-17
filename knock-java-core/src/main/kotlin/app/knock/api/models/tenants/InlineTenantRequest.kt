// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.JsonValue
import app.knock.api.core.allMaxBy
import app.knock.api.core.getOrThrow
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Objects
import java.util.Optional

/** An request to set a tenant inline. */
@JsonDeserialize(using = InlineTenantRequest.Deserializer::class)
@JsonSerialize(using = InlineTenantRequest.Serializer::class)
class InlineTenantRequest
private constructor(
    private val string: String? = null,
    private val tenantRequest: TenantRequest? = null,
    private val _json: JsonValue? = null,
) {

    /** The unique identifier for the tenant. */
    fun string(): Optional<String> = Optional.ofNullable(string)

    /** A request to get a tenant. */
    fun tenantRequest(): Optional<TenantRequest> = Optional.ofNullable(tenantRequest)

    fun isString(): Boolean = string != null

    fun isTenantRequest(): Boolean = tenantRequest != null

    /** The unique identifier for the tenant. */
    fun asString(): String = string.getOrThrow("string")

    /** A request to get a tenant. */
    fun asTenantRequest(): TenantRequest = tenantRequest.getOrThrow("tenantRequest")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            string != null -> visitor.visitString(string)
            tenantRequest != null -> visitor.visitTenantRequest(tenantRequest)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): InlineTenantRequest = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitTenantRequest(tenantRequest: TenantRequest) {
                    tenantRequest.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitString(string: String) = 1

                override fun visitTenantRequest(tenantRequest: TenantRequest) =
                    tenantRequest.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is InlineTenantRequest && string == other.string && tenantRequest == other.tenantRequest /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, tenantRequest) /* spotless:on */

    override fun toString(): String =
        when {
            string != null -> "InlineTenantRequest{string=$string}"
            tenantRequest != null -> "InlineTenantRequest{tenantRequest=$tenantRequest}"
            _json != null -> "InlineTenantRequest{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid InlineTenantRequest")
        }

    companion object {

        /** The unique identifier for the tenant. */
        @JvmStatic fun ofString(string: String) = InlineTenantRequest(string = string)

        /** A request to get a tenant. */
        @JvmStatic
        fun ofTenantRequest(tenantRequest: TenantRequest) =
            InlineTenantRequest(tenantRequest = tenantRequest)
    }

    /**
     * An interface that defines how to map each variant of [InlineTenantRequest] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** The unique identifier for the tenant. */
        fun visitString(string: String): T

        /** A request to get a tenant. */
        fun visitTenantRequest(tenantRequest: TenantRequest): T

        /**
         * Maps an unknown variant of [InlineTenantRequest] to a value of type [T].
         *
         * An instance of [InlineTenantRequest] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws KnockInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw KnockInvalidDataException("Unknown InlineTenantRequest: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<InlineTenantRequest>(InlineTenantRequest::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): InlineTenantRequest {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<TenantRequest>())?.let {
                            InlineTenantRequest(tenantRequest = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            InlineTenantRequest(string = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from array).
                0 -> InlineTenantRequest(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<InlineTenantRequest>(InlineTenantRequest::class) {

        override fun serialize(
            value: InlineTenantRequest,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.tenantRequest != null -> generator.writeObject(value.tenantRequest)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid InlineTenantRequest")
            }
        }
    }
}
