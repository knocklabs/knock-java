// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.allMaxBy
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

/**
 * A reference to a recipient, either a user identifier (string) or an object reference (ID,
 * collection).
 */
@JsonDeserialize(using = RecipientReference.Deserializer::class)
@JsonSerialize(using = RecipientReference.Serializer::class)
class RecipientReference
private constructor(
    private val user: String? = null,
    private val objectReference: ObjectReference? = null,
    private val _json: JsonValue? = null,
) {

    /** The ID of the user which is used as the reference for the recipient. */
    fun user(): Optional<String> = Optional.ofNullable(user)

    /** A reference to a recipient object. */
    fun objectReference(): Optional<ObjectReference> = Optional.ofNullable(objectReference)

    fun isUser(): Boolean = user != null

    fun isObjectReference(): Boolean = objectReference != null

    /** The ID of the user which is used as the reference for the recipient. */
    fun asUser(): String = user.getOrThrow("user")

    /** A reference to a recipient object. */
    fun asObjectReference(): ObjectReference = objectReference.getOrThrow("objectReference")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            user != null -> visitor.visitUser(user)
            objectReference != null -> visitor.visitObjectReference(objectReference)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RecipientReference = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitUser(user: String) {}

                override fun visitObjectReference(objectReference: ObjectReference) {
                    objectReference.validate()
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
                override fun visitUser(user: String) = 1

                override fun visitObjectReference(objectReference: ObjectReference) =
                    objectReference.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RecipientReference && user == other.user && objectReference == other.objectReference /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(user, objectReference) /* spotless:on */

    override fun toString(): String =
        when {
            user != null -> "RecipientReference{user=$user}"
            objectReference != null -> "RecipientReference{objectReference=$objectReference}"
            _json != null -> "RecipientReference{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RecipientReference")
        }

    companion object {

        /** The ID of the user which is used as the reference for the recipient. */
        @JvmStatic fun ofUser(user: String) = RecipientReference(user = user)

        /** A reference to a recipient object. */
        @JvmStatic
        fun ofObjectReference(objectReference: ObjectReference) =
            RecipientReference(objectReference = objectReference)
    }

    /**
     * An interface that defines how to map each variant of [RecipientReference] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** The ID of the user which is used as the reference for the recipient. */
        fun visitUser(user: String): T

        /** A reference to a recipient object. */
        fun visitObjectReference(objectReference: ObjectReference): T

        /**
         * Maps an unknown variant of [RecipientReference] to a value of type [T].
         *
         * An instance of [RecipientReference] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws KnockInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw KnockInvalidDataException("Unknown RecipientReference: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<RecipientReference>(RecipientReference::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RecipientReference {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<ObjectReference>())?.let {
                            RecipientReference(objectReference = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            RecipientReference(user = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from array).
                0 -> RecipientReference(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<RecipientReference>(RecipientReference::class) {

        override fun serialize(
            value: RecipientReference,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.user != null -> generator.writeObject(value.user)
                value.objectReference != null -> generator.writeObject(value.objectReference)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RecipientReference")
            }
        }
    }

    /** A reference to a recipient object. */
    class ObjectReference
    private constructor(
        private val id: JsonField<String>,
        private val collection: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("collection")
            @ExcludeMissing
            collection: JsonField<String> = JsonMissing.of(),
        ) : this(id, collection, mutableMapOf())

        /**
         * An identifier for the recipient object.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun id(): Optional<String> = id.getOptional("id")

        /**
         * The collection the recipient object belongs to.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun collection(): Optional<String> = collection.getOptional("collection")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [collection].
         *
         * Unlike [collection], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("collection")
        @ExcludeMissing
        fun _collection(): JsonField<String> = collection

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

            /** Returns a mutable builder for constructing an instance of [ObjectReference]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ObjectReference]. */
        class Builder internal constructor() {

            private var id: JsonField<String> = JsonMissing.of()
            private var collection: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(objectReference: ObjectReference) = apply {
                id = objectReference.id
                collection = objectReference.collection
                additionalProperties = objectReference.additionalProperties.toMutableMap()
            }

            /** An identifier for the recipient object. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The collection the recipient object belongs to. */
            fun collection(collection: String) = collection(JsonField.of(collection))

            /**
             * Sets [Builder.collection] to an arbitrary JSON value.
             *
             * You should usually call [Builder.collection] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun collection(collection: JsonField<String>) = apply { this.collection = collection }

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
             * Returns an immutable instance of [ObjectReference].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ObjectReference =
                ObjectReference(id, collection, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ObjectReference = apply {
            if (validated) {
                return@apply
            }

            id()
            collection()
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
            (if (id.asKnown().isPresent) 1 else 0) + (if (collection.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ObjectReference && id == other.id && collection == other.collection && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, collection, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ObjectReference{id=$id, collection=$collection, additionalProperties=$additionalProperties}"
    }
}
