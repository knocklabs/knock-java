// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.JsonValue
import app.knock.api.core.getOrThrow
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.objects.Object
import app.knock.api.models.users.User
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Objects
import java.util.Optional

/** A recipient, which is either a user or an object */
@JsonDeserialize(using = Recipient.Deserializer::class)
@JsonSerialize(using = Recipient.Serializer::class)
class Recipient private constructor(
    private val user: User? = null,
    private val object_: Object? = null,
    private val _json: JsonValue? = null,

) {

    /** A user object */
    fun user(): Optional<User> = Optional.ofNullable(user)

    /** A custom-object entity which belongs to a collection. */
    fun object_(): Optional<Object> = Optional.ofNullable(object_)

    fun isUser(): Boolean = user != null

    fun isObject(): Boolean = object_ != null

    /** A user object */
    fun asUser(): User = user.getOrThrow("user")

    /** A custom-object entity which belongs to a collection. */
    fun asObject(): Object = object_.getOrThrow("object_")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
      return when {
          user != null -> visitor.visitUser(user)
          object_ != null -> visitor.visitObject(object_)
          else -> visitor.unknown(_json)
      }
    }

    private var validated: Boolean = false

    fun validate(): Recipient =
        apply {
            if (validated) {
              return@apply
            }

            accept(object : Visitor<Unit> {
                override fun visitUser(user: User) {
                  user.validate()
                }

                override fun visitObject(object_: Object) {
                  object_.validate()
                }
            })
            validated = true
        }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is Recipient && user == other.user && object_ == other.object_ /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(user, object_) /* spotless:on */

    override fun toString(): String =
        when {
            user != null -> "Recipient{user=$user}"
            object_ != null -> "Recipient{object_=$object_}"
            _json != null -> "Recipient{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Recipient")
        }

    companion object {

        /** A user object */
        @JvmStatic
        fun ofUser(user: User) = Recipient(user = user)

        /** A custom-object entity which belongs to a collection. */
        @JvmStatic
        fun ofObject(object_: Object) = Recipient(object_ = object_)
    }

    /**
     * An interface that defines how to map each variant of [Recipient] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /** A user object */
        fun visitUser(user: User): T

        /** A custom-object entity which belongs to a collection. */
        fun visitObject(object_: Object): T

        /**
         * Maps an unknown variant of [Recipient] to a value of type [T].
         *
         * An instance of [Recipient] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an
         * older version than the API, then the API may respond with new variants that the
         * SDK is unaware of.
         *
         * @throws KnockInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
          throw KnockInvalidDataException("Unknown Recipient: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<Recipient>(Recipient::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Recipient {
          val json = JsonValue.fromJsonNode(node)

          tryDeserialize(node, jacksonTypeRef<User>()){ it.validate() }?.let {
              return Recipient(user = it, _json = json)
          }
          tryDeserialize(node, jacksonTypeRef<Object>()){ it.validate() }?.let {
              return Recipient(object_ = it, _json = json)
          }

          return Recipient(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<Recipient>(Recipient::class) {

        override fun serialize(value: Recipient, generator: JsonGenerator, provider: SerializerProvider) {
          when {
              value.user != null -> generator.writeObject(value.user)
              value.object_ != null -> generator.writeObject(value.object_)
              value._json != null -> generator.writeObject(value._json)
              else -> throw IllegalStateException("Invalid Recipient")
          }
        }
    }
}
