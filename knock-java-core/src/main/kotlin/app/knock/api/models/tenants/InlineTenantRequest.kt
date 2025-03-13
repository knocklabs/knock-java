// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.JsonValue
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

/** An inline tenant request */
@JsonDeserialize(using = InlineTenantRequest.Deserializer::class)
@JsonSerialize(using = InlineTenantRequest.Serializer::class)
class InlineTenantRequest private constructor(
    private val string: String? = null,
    private val tenantRequest: TenantRequest? = null,
    private val _json: JsonValue? = null,

) {

    /** A tenant identifier */
    fun string(): Optional<String> = Optional.ofNullable(string)

    /** A tenant to be set in the system */
    fun tenantRequest(): Optional<TenantRequest> = Optional.ofNullable(tenantRequest)

    fun isString(): Boolean = string != null

    fun isTenantRequest(): Boolean = tenantRequest != null

    /** A tenant identifier */
    fun asString(): String = string.getOrThrow("string")

    /** A tenant to be set in the system */
    fun asTenantRequest(): TenantRequest = tenantRequest.getOrThrow("tenantRequest")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
      return when {
          string != null -> visitor.visitString(string)
          tenantRequest != null -> visitor.visitTenantRequest(tenantRequest)
          else -> visitor.unknown(_json)
      }
    }

    private var validated: Boolean = false

    fun validate(): InlineTenantRequest =
        apply {
            if (validated) {
              return@apply
            }

            accept(object : Visitor<Unit> {
                override fun visitString(string: String) {

                }

                override fun visitTenantRequest(tenantRequest: TenantRequest) {
                  tenantRequest.validate()
                }
            })
            validated = true
        }

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

        /** A tenant identifier */
        @JvmStatic
        fun ofString(string: String) = InlineTenantRequest(string = string)

        /** A tenant to be set in the system */
        @JvmStatic
        fun ofTenantRequest(tenantRequest: TenantRequest) = InlineTenantRequest(tenantRequest = tenantRequest)
    }

    /**
     * An interface that defines how to map each variant of [InlineTenantRequest] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        /** A tenant identifier */
        fun visitString(string: String): T

        /** A tenant to be set in the system */
        fun visitTenantRequest(tenantRequest: TenantRequest): T

        /**
         * Maps an unknown variant of [InlineTenantRequest] to a value of type [T].
         *
         * An instance of [InlineTenantRequest] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the
         * SDK is on an older version than the API, then the API may respond with new
         * variants that the SDK is unaware of.
         *
         * @throws KnockInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
          throw KnockInvalidDataException("Unknown InlineTenantRequest: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<InlineTenantRequest>(InlineTenantRequest::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): InlineTenantRequest {
          val json = JsonValue.fromJsonNode(node)

          tryDeserialize(node, jacksonTypeRef<String>())?.let {
              return InlineTenantRequest(string = it, _json = json)
          }
          tryDeserialize(node, jacksonTypeRef<TenantRequest>()){ it.validate() }?.let {
              return InlineTenantRequest(tenantRequest = it, _json = json)
          }

          return InlineTenantRequest(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<InlineTenantRequest>(InlineTenantRequest::class) {

        override fun serialize(value: InlineTenantRequest, generator: JsonGenerator, provider: SerializerProvider) {
          when {
              value.string != null -> generator.writeObject(value.string)
              value.tenantRequest != null -> generator.writeObject(value.tenantRequest)
              value._json != null -> generator.writeObject(value._json)
              else -> throw IllegalStateException("Invalid InlineTenantRequest")
          }
        }
    }
}
