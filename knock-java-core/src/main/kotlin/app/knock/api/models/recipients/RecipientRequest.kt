// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.JsonValue
import app.knock.api.core.allMaxBy
import app.knock.api.core.getOrThrow
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Objects
import java.util.Optional

/**
 * Specifies a recipient in a request. This can either be a user identifier (string), an inline user
 * request (object), or an inline object request, which is determined by the presence of a
 * `collection` property.
 */
@JsonDeserialize(using = RecipientRequest.Deserializer::class)
@JsonSerialize(using = RecipientRequest.Serializer::class)
class RecipientRequest
private constructor(
    private val userRecipient: String? = null,
    private val inlineIdentifyUser: InlineIdentifyUserRequest? = null,
    private val inlineObject: InlineObjectRequest? = null,
    private val _json: JsonValue? = null,
) {

    /** The id of the user. */
    fun userRecipient(): Optional<String> = Optional.ofNullable(userRecipient)

    /**
     * A set of parameters to inline-identify a user with. Inline identifying the user will ensure
     * that the user is available before the request is executed in Knock. It will perform an upsert
     * for the user you're supplying, replacing any properties specified.
     */
    fun inlineIdentifyUser(): Optional<InlineIdentifyUserRequest> =
        Optional.ofNullable(inlineIdentifyUser)

    /** A custom object entity which belongs to a collection. */
    fun inlineObject(): Optional<InlineObjectRequest> = Optional.ofNullable(inlineObject)

    fun isUserRecipient(): Boolean = userRecipient != null

    fun isInlineIdentifyUser(): Boolean = inlineIdentifyUser != null

    fun isInlineObject(): Boolean = inlineObject != null

    /** The id of the user. */
    fun asUserRecipient(): String = userRecipient.getOrThrow("userRecipient")

    /**
     * A set of parameters to inline-identify a user with. Inline identifying the user will ensure
     * that the user is available before the request is executed in Knock. It will perform an upsert
     * for the user you're supplying, replacing any properties specified.
     */
    fun asInlineIdentifyUser(): InlineIdentifyUserRequest =
        inlineIdentifyUser.getOrThrow("inlineIdentifyUser")

    /** A custom object entity which belongs to a collection. */
    fun asInlineObject(): InlineObjectRequest = inlineObject.getOrThrow("inlineObject")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            userRecipient != null -> visitor.visitUserRecipient(userRecipient)
            inlineIdentifyUser != null -> visitor.visitInlineIdentifyUser(inlineIdentifyUser)
            inlineObject != null -> visitor.visitInlineObject(inlineObject)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RecipientRequest = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitUserRecipient(userRecipient: String) {}

                override fun visitInlineIdentifyUser(
                    inlineIdentifyUser: InlineIdentifyUserRequest
                ) {
                    inlineIdentifyUser.validate()
                }

                override fun visitInlineObject(inlineObject: InlineObjectRequest) {
                    inlineObject.validate()
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
                override fun visitUserRecipient(userRecipient: String) = 1

                override fun visitInlineIdentifyUser(
                    inlineIdentifyUser: InlineIdentifyUserRequest
                ) = inlineIdentifyUser.validity()

                override fun visitInlineObject(inlineObject: InlineObjectRequest) =
                    inlineObject.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RecipientRequest && userRecipient == other.userRecipient && inlineIdentifyUser == other.inlineIdentifyUser && inlineObject == other.inlineObject /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userRecipient, inlineIdentifyUser, inlineObject) /* spotless:on */

    override fun toString(): String =
        when {
            userRecipient != null -> "RecipientRequest{userRecipient=$userRecipient}"
            inlineIdentifyUser != null -> "RecipientRequest{inlineIdentifyUser=$inlineIdentifyUser}"
            inlineObject != null -> "RecipientRequest{inlineObject=$inlineObject}"
            _json != null -> "RecipientRequest{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RecipientRequest")
        }

    companion object {

        /** The id of the user. */
        @JvmStatic
        fun ofUserRecipient(userRecipient: String) = RecipientRequest(userRecipient = userRecipient)

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert for the user you're supplying, replacing any properties specified.
         */
        @JvmStatic
        fun ofInlineIdentifyUser(inlineIdentifyUser: InlineIdentifyUserRequest) =
            RecipientRequest(inlineIdentifyUser = inlineIdentifyUser)

        /** A custom object entity which belongs to a collection. */
        @JvmStatic
        fun ofInlineObject(inlineObject: InlineObjectRequest) =
            RecipientRequest(inlineObject = inlineObject)
    }

    /**
     * An interface that defines how to map each variant of [RecipientRequest] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** The id of the user. */
        fun visitUserRecipient(userRecipient: String): T

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert for the user you're supplying, replacing any properties specified.
         */
        fun visitInlineIdentifyUser(inlineIdentifyUser: InlineIdentifyUserRequest): T

        /** A custom object entity which belongs to a collection. */
        fun visitInlineObject(inlineObject: InlineObjectRequest): T

        /**
         * Maps an unknown variant of [RecipientRequest] to a value of type [T].
         *
         * An instance of [RecipientRequest] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws KnockInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw KnockInvalidDataException("Unknown RecipientRequest: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<RecipientRequest>(RecipientRequest::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RecipientRequest {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<InlineIdentifyUserRequest>())?.let {
                            RecipientRequest(inlineIdentifyUser = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<InlineObjectRequest>())?.let {
                            RecipientRequest(inlineObject = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            RecipientRequest(userRecipient = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from array).
                0 -> RecipientRequest(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<RecipientRequest>(RecipientRequest::class) {

        override fun serialize(
            value: RecipientRequest,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.userRecipient != null -> generator.writeObject(value.userRecipient)
                value.inlineIdentifyUser != null -> generator.writeObject(value.inlineIdentifyUser)
                value.inlineObject != null -> generator.writeObject(value.inlineObject)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RecipientRequest")
            }
        }
    }
}
