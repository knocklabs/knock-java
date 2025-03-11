// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.recipients

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.knock.api.core.BaseDeserializer
import com.knock.api.core.BaseSerializer
import com.knock.api.core.JsonValue
import com.knock.api.core.getOrThrow
import com.knock.api.errors.KnockInvalidDataException
import com.knock.api.models.objects.InlineObjectRequest
import com.knock.api.models.users.InlineIdentifyUserRequest
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
    private val string: String? = null,
    private val inlineIdentifyUser: InlineIdentifyUserRequest? = null,
    private val inlineObject: InlineObjectRequest? = null,
    private val _json: JsonValue? = null,
) {

    /** A user identifier */
    fun string(): Optional<String> = Optional.ofNullable(string)

    /**
     * A set of parameters to inline-identify a user with. Inline identifying the user will ensure
     * that the user is available before the request is executed in Knock. It will perform an upsert
     * against the user you're supplying, replacing any properties specified.
     */
    fun inlineIdentifyUser(): Optional<InlineIdentifyUserRequest> =
        Optional.ofNullable(inlineIdentifyUser)

    /** Inline identifies a custom object belonging to a collection */
    fun inlineObject(): Optional<InlineObjectRequest> = Optional.ofNullable(inlineObject)

    fun isString(): Boolean = string != null

    fun isInlineIdentifyUser(): Boolean = inlineIdentifyUser != null

    fun isInlineObject(): Boolean = inlineObject != null

    /** A user identifier */
    fun asString(): String = string.getOrThrow("string")

    /**
     * A set of parameters to inline-identify a user with. Inline identifying the user will ensure
     * that the user is available before the request is executed in Knock. It will perform an upsert
     * against the user you're supplying, replacing any properties specified.
     */
    fun asInlineIdentifyUser(): InlineIdentifyUserRequest =
        inlineIdentifyUser.getOrThrow("inlineIdentifyUser")

    /** Inline identifies a custom object belonging to a collection */
    fun asInlineObject(): InlineObjectRequest = inlineObject.getOrThrow("inlineObject")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            string != null -> visitor.visitString(string)
            inlineIdentifyUser != null -> visitor.visitInlineIdentifyUser(inlineIdentifyUser)
            inlineObject != null -> visitor.visitInlineObject(inlineObject)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): RecipientRequest = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RecipientRequest && string == other.string && inlineIdentifyUser == other.inlineIdentifyUser && inlineObject == other.inlineObject /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, inlineIdentifyUser, inlineObject) /* spotless:on */

    override fun toString(): String =
        when {
            string != null -> "RecipientRequest{string=$string}"
            inlineIdentifyUser != null -> "RecipientRequest{inlineIdentifyUser=$inlineIdentifyUser}"
            inlineObject != null -> "RecipientRequest{inlineObject=$inlineObject}"
            _json != null -> "RecipientRequest{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RecipientRequest")
        }

    companion object {

        /** A user identifier */
        @JvmStatic fun ofString(string: String) = RecipientRequest(string = string)

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert against the user you're supplying, replacing any properties specified.
         */
        @JvmStatic
        fun ofInlineIdentifyUser(inlineIdentifyUser: InlineIdentifyUserRequest) =
            RecipientRequest(inlineIdentifyUser = inlineIdentifyUser)

        /** Inline identifies a custom object belonging to a collection */
        @JvmStatic
        fun ofInlineObject(inlineObject: InlineObjectRequest) =
            RecipientRequest(inlineObject = inlineObject)
    }

    /**
     * An interface that defines how to map each variant of [RecipientRequest] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** A user identifier */
        fun visitString(string: String): T

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert against the user you're supplying, replacing any properties specified.
         */
        fun visitInlineIdentifyUser(inlineIdentifyUser: InlineIdentifyUserRequest): T

        /** Inline identifies a custom object belonging to a collection */
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

            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                return RecipientRequest(string = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<InlineIdentifyUserRequest>()) { it.validate() }
                ?.let {
                    return RecipientRequest(inlineIdentifyUser = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<InlineObjectRequest>()) { it.validate() }
                ?.let {
                    return RecipientRequest(inlineObject = it, _json = json)
                }

            return RecipientRequest(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<RecipientRequest>(RecipientRequest::class) {

        override fun serialize(
            value: RecipientRequest,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.inlineIdentifyUser != null -> generator.writeObject(value.inlineIdentifyUser)
                value.inlineObject != null -> generator.writeObject(value.inlineObject)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RecipientRequest")
            }
        }
    }
}
