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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A message event. */
class MessageEvent
private constructor(
    private val id: JsonField<String>,
    private val _typename: JsonField<String>,
    private val insertedAt: JsonField<OffsetDateTime>,
    private val recipient: JsonField<Recipient>,
    private val type: JsonField<Type>,
    private val data: JsonField<Data>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("__typename") @ExcludeMissing _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inserted_at")
        @ExcludeMissing
        insertedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("recipient")
        @ExcludeMissing
        recipient: JsonField<Recipient> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
    ) : this(id, _typename, insertedAt, recipient, type, data, mutableMapOf())

    /**
     * The unique identifier for the message event.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The type name of the schema.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): String = _typename.getRequired("__typename")

    /**
     * Timestamp when the event was created.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun insertedAt(): OffsetDateTime = insertedAt.getRequired("inserted_at")

    /**
     * A reference to a recipient, either a user identifier (string) or an object reference (id,
     * collection).
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipient(): Recipient = recipient.getRequired("recipient")

    /**
     * The type of event that occurred.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * The data associated with the message event. Only present for some event types.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<Data> = data.getOptional("data")

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
     * Returns the raw JSON value of [insertedAt].
     *
     * Unlike [insertedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inserted_at")
    @ExcludeMissing
    fun _insertedAt(): JsonField<OffsetDateTime> = insertedAt

    /**
     * Returns the raw JSON value of [recipient].
     *
     * Unlike [recipient], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("recipient") @ExcludeMissing fun _recipient(): JsonField<Recipient> = recipient

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

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
         * Returns a mutable builder for constructing an instance of [MessageEvent].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .insertedAt()
         * .recipient()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageEvent]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var _typename: JsonField<String>? = null
        private var insertedAt: JsonField<OffsetDateTime>? = null
        private var recipient: JsonField<Recipient>? = null
        private var type: JsonField<Type>? = null
        private var data: JsonField<Data> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageEvent: MessageEvent) = apply {
            id = messageEvent.id
            _typename = messageEvent._typename
            insertedAt = messageEvent.insertedAt
            recipient = messageEvent.recipient
            type = messageEvent.type
            data = messageEvent.data
            additionalProperties = messageEvent.additionalProperties.toMutableMap()
        }

        /** The unique identifier for the message event. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The type name of the schema. */
        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** Timestamp when the event was created. */
        fun insertedAt(insertedAt: OffsetDateTime) = insertedAt(JsonField.of(insertedAt))

        /**
         * Sets [Builder.insertedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.insertedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun insertedAt(insertedAt: JsonField<OffsetDateTime>) = apply {
            this.insertedAt = insertedAt
        }

        /**
         * A reference to a recipient, either a user identifier (string) or an object reference (id,
         * collection).
         */
        fun recipient(recipient: Recipient) = recipient(JsonField.of(recipient))

        /**
         * Sets [Builder.recipient] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipient] with a well-typed [Recipient] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun recipient(recipient: JsonField<Recipient>) = apply { this.recipient = recipient }

        /** Alias for calling [recipient] with `Recipient.ofString(string)`. */
        fun recipient(string: String) = recipient(Recipient.ofString(string))

        /** Alias for calling [recipient] with `Recipient.ofReference(reference)`. */
        fun recipient(reference: Recipient.RecipientReference) =
            recipient(Recipient.ofReference(reference))

        /** The type of event that occurred. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** The data associated with the message event. Only present for some event types. */
        fun data(data: Data?) = data(JsonField.ofNullable(data))

        /** Alias for calling [Builder.data] with `data.orElse(null)`. */
        fun data(data: Optional<Data>) = data(data.getOrNull())

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

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
         * Returns an immutable instance of [MessageEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .insertedAt()
         * .recipient()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageEvent =
            MessageEvent(
                checkRequired("id", id),
                checkRequired("_typename", _typename),
                checkRequired("insertedAt", insertedAt),
                checkRequired("recipient", recipient),
                checkRequired("type", type),
                data,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MessageEvent = apply {
        if (validated) {
            return@apply
        }

        id()
        _typename()
        insertedAt()
        recipient().validate()
        type().validate()
        data().ifPresent { it.validate() }
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
            (if (insertedAt.asKnown().isPresent) 1 else 0) +
            (recipient.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (data.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * A reference to a recipient, either a user identifier (string) or an object reference (id,
     * collection).
     */
    @JsonDeserialize(using = Recipient.Deserializer::class)
    @JsonSerialize(using = Recipient.Serializer::class)
    class Recipient
    private constructor(
        private val string: String? = null,
        private val reference: RecipientReference? = null,
        private val _json: JsonValue? = null,
    ) {

        /** An identifier for a user recipient. */
        fun string(): Optional<String> = Optional.ofNullable(string)

        /**
         * A reference to a recipient, either a user identifier (string) or an object reference (id,
         * collection).
         */
        fun reference(): Optional<RecipientReference> = Optional.ofNullable(reference)

        fun isString(): Boolean = string != null

        fun isReference(): Boolean = reference != null

        /** An identifier for a user recipient. */
        fun asString(): String = string.getOrThrow("string")

        /**
         * A reference to a recipient, either a user identifier (string) or an object reference (id,
         * collection).
         */
        fun asReference(): RecipientReference = reference.getOrThrow("reference")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                string != null -> visitor.visitString(string)
                reference != null -> visitor.visitReference(reference)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Recipient = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitString(string: String) {}

                    override fun visitReference(reference: RecipientReference) {
                        reference.validate()
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

                    override fun visitReference(reference: RecipientReference) =
                        reference.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Recipient && string == other.string && reference == other.reference /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, reference) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Recipient{string=$string}"
                reference != null -> "Recipient{reference=$reference}"
                _json != null -> "Recipient{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Recipient")
            }

        companion object {

            /** An identifier for a user recipient. */
            @JvmStatic fun ofString(string: String) = Recipient(string = string)

            /**
             * A reference to a recipient, either a user identifier (string) or an object reference
             * (id, collection).
             */
            @JvmStatic
            fun ofReference(reference: RecipientReference) = Recipient(reference = reference)
        }

        /**
         * An interface that defines how to map each variant of [Recipient] to a value of type [T].
         */
        interface Visitor<out T> {

            /** An identifier for a user recipient. */
            fun visitString(string: String): T

            /**
             * A reference to a recipient, either a user identifier (string) or an object reference
             * (id, collection).
             */
            fun visitReference(reference: RecipientReference): T

            /**
             * Maps an unknown variant of [Recipient] to a value of type [T].
             *
             * An instance of [Recipient] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<RecipientReference>())?.let {
                                Recipient(reference = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Recipient(string = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from array).
                    0 -> Recipient(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Recipient>(Recipient::class) {

            override fun serialize(
                value: Recipient,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.string != null -> generator.writeObject(value.string)
                    value.reference != null -> generator.writeObject(value.reference)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Recipient")
                }
            }
        }

        /**
         * A reference to a recipient, either a user identifier (string) or an object reference (id,
         * collection).
         */
        class RecipientReference
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
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun id(): Optional<String> = id.getOptional("id")

            /**
             * The collection the recipient object belongs to.
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
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
             * Unlike [collection], this method doesn't throw if the JSON field has an unexpected
             * type.
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

                /**
                 * Returns a mutable builder for constructing an instance of [RecipientReference].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [RecipientReference]. */
            class Builder internal constructor() {

                private var id: JsonField<String> = JsonMissing.of()
                private var collection: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(recipientReference: RecipientReference) = apply {
                    id = recipientReference.id
                    collection = recipientReference.collection
                    additionalProperties = recipientReference.additionalProperties.toMutableMap()
                }

                /** An identifier for the recipient object. */
                fun id(id: String) = id(JsonField.of(id))

                /**
                 * Sets [Builder.id] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.id] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun id(id: JsonField<String>) = apply { this.id = id }

                /** The collection the recipient object belongs to. */
                fun collection(collection: String) = collection(JsonField.of(collection))

                /**
                 * Sets [Builder.collection] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.collection] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun collection(collection: JsonField<String>) = apply {
                    this.collection = collection
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
                 * Returns an immutable instance of [RecipientReference].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): RecipientReference =
                    RecipientReference(id, collection, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): RecipientReference = apply {
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
                (if (id.asKnown().isPresent) 1 else 0) +
                    (if (collection.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is RecipientReference && id == other.id && collection == other.collection && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(id, collection, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "RecipientReference{id=$id, collection=$collection, additionalProperties=$additionalProperties}"
        }
    }

    /** The type of event that occurred. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val MESSAGE_ARCHIVED = of("message.archived")

            @JvmField val MESSAGE_BOUNCED = of("message.bounced")

            @JvmField val MESSAGE_DELIVERED = of("message.delivered")

            @JvmField val MESSAGE_DELIVERY_ATTEMPTED = of("message.delivery_attempted")

            @JvmField val MESSAGE_INTERACTED = of("message.interacted")

            @JvmField val MESSAGE_LINK_CLICKED = of("message.link_clicked")

            @JvmField val MESSAGE_NOT_SENT = of("message.not_sent")

            @JvmField val MESSAGE_QUEUED = of("message.queued")

            @JvmField val MESSAGE_READ = of("message.read")

            @JvmField val MESSAGE_SEEN = of("message.seen")

            @JvmField val MESSAGE_SENT = of("message.sent")

            @JvmField val MESSAGE_UNARCHIVED = of("message.unarchived")

            @JvmField val MESSAGE_UNDELIVERED = of("message.undelivered")

            @JvmField val MESSAGE_UNREAD = of("message.unread")

            @JvmField val MESSAGE_UNSEEN = of("message.unseen")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            MESSAGE_ARCHIVED,
            MESSAGE_BOUNCED,
            MESSAGE_DELIVERED,
            MESSAGE_DELIVERY_ATTEMPTED,
            MESSAGE_INTERACTED,
            MESSAGE_LINK_CLICKED,
            MESSAGE_NOT_SENT,
            MESSAGE_QUEUED,
            MESSAGE_READ,
            MESSAGE_SEEN,
            MESSAGE_SENT,
            MESSAGE_UNARCHIVED,
            MESSAGE_UNDELIVERED,
            MESSAGE_UNREAD,
            MESSAGE_UNSEEN,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MESSAGE_ARCHIVED,
            MESSAGE_BOUNCED,
            MESSAGE_DELIVERED,
            MESSAGE_DELIVERY_ATTEMPTED,
            MESSAGE_INTERACTED,
            MESSAGE_LINK_CLICKED,
            MESSAGE_NOT_SENT,
            MESSAGE_QUEUED,
            MESSAGE_READ,
            MESSAGE_SEEN,
            MESSAGE_SENT,
            MESSAGE_UNARCHIVED,
            MESSAGE_UNDELIVERED,
            MESSAGE_UNREAD,
            MESSAGE_UNSEEN,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                MESSAGE_ARCHIVED -> Value.MESSAGE_ARCHIVED
                MESSAGE_BOUNCED -> Value.MESSAGE_BOUNCED
                MESSAGE_DELIVERED -> Value.MESSAGE_DELIVERED
                MESSAGE_DELIVERY_ATTEMPTED -> Value.MESSAGE_DELIVERY_ATTEMPTED
                MESSAGE_INTERACTED -> Value.MESSAGE_INTERACTED
                MESSAGE_LINK_CLICKED -> Value.MESSAGE_LINK_CLICKED
                MESSAGE_NOT_SENT -> Value.MESSAGE_NOT_SENT
                MESSAGE_QUEUED -> Value.MESSAGE_QUEUED
                MESSAGE_READ -> Value.MESSAGE_READ
                MESSAGE_SEEN -> Value.MESSAGE_SEEN
                MESSAGE_SENT -> Value.MESSAGE_SENT
                MESSAGE_UNARCHIVED -> Value.MESSAGE_UNARCHIVED
                MESSAGE_UNDELIVERED -> Value.MESSAGE_UNDELIVERED
                MESSAGE_UNREAD -> Value.MESSAGE_UNREAD
                MESSAGE_UNSEEN -> Value.MESSAGE_UNSEEN
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws KnockInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                MESSAGE_ARCHIVED -> Known.MESSAGE_ARCHIVED
                MESSAGE_BOUNCED -> Known.MESSAGE_BOUNCED
                MESSAGE_DELIVERED -> Known.MESSAGE_DELIVERED
                MESSAGE_DELIVERY_ATTEMPTED -> Known.MESSAGE_DELIVERY_ATTEMPTED
                MESSAGE_INTERACTED -> Known.MESSAGE_INTERACTED
                MESSAGE_LINK_CLICKED -> Known.MESSAGE_LINK_CLICKED
                MESSAGE_NOT_SENT -> Known.MESSAGE_NOT_SENT
                MESSAGE_QUEUED -> Known.MESSAGE_QUEUED
                MESSAGE_READ -> Known.MESSAGE_READ
                MESSAGE_SEEN -> Known.MESSAGE_SEEN
                MESSAGE_SENT -> Known.MESSAGE_SENT
                MESSAGE_UNARCHIVED -> Known.MESSAGE_UNARCHIVED
                MESSAGE_UNDELIVERED -> Known.MESSAGE_UNDELIVERED
                MESSAGE_UNREAD -> Known.MESSAGE_UNREAD
                MESSAGE_UNSEEN -> Known.MESSAGE_UNSEEN
                else -> throw KnockInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws KnockInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { KnockInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Type = apply {
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

            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The data associated with the message event. Only present for some event types. */
    class Data
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

            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                additionalProperties = data.additionalProperties.toMutableMap()
            }

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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data = Data(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
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

            return /* spotless:off */ other is Data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Data{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageEvent && id == other.id && _typename == other._typename && insertedAt == other.insertedAt && recipient == other.recipient && type == other.type && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, insertedAt, recipient, type, data, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageEvent{id=$id, _typename=$_typename, insertedAt=$insertedAt, recipient=$recipient, type=$type, data=$data, additionalProperties=$additionalProperties}"
}
