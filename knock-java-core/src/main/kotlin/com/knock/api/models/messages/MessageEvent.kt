// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.messages

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
import com.knock.api.core.BaseDeserializer
import com.knock.api.core.BaseSerializer
import com.knock.api.core.Enum
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkRequired
import com.knock.api.core.getOrThrow
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.errors.KnockInvalidDataException
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A single event that occurred for a message */
@NoAutoDetect
class MessageEvent @JsonCreator private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("__typename") @ExcludeMissing private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("inserted_at") @ExcludeMissing private val insertedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("recipient") @ExcludeMissing private val recipient: JsonField<Recipient> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonField<Type> = JsonMissing.of(),
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<Data> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

) {

    fun id(): String = id.getRequired("id")

    fun _typename(): String = _typename.getRequired("__typename")

    fun insertedAt(): OffsetDateTime = insertedAt.getRequired("inserted_at")

    /**
     * A reference to a recipient, either a user identifier (string) or an object
     * reference (id, collection).
     */
    fun recipient(): Recipient = recipient.getRequired("recipient")

    fun type(): Type = type.getRequired("type")

    /** The data associated with the event. Only present for some event types */
    fun data(): Optional<Data> = Optional.ofNullable(data.getNullable("data"))

    @JsonProperty("id")
    @ExcludeMissing
    fun _id(): JsonField<String> = id

    @JsonProperty("__typename")
    @ExcludeMissing
    fun __typename(): JsonField<String> = _typename

    @JsonProperty("inserted_at")
    @ExcludeMissing
    fun _insertedAt(): JsonField<OffsetDateTime> = insertedAt

    /**
     * A reference to a recipient, either a user identifier (string) or an object
     * reference (id, collection).
     */
    @JsonProperty("recipient")
    @ExcludeMissing
    fun _recipient(): JsonField<Recipient> = recipient

    @JsonProperty("type")
    @ExcludeMissing
    fun _type(): JsonField<Type> = type

    /** The data associated with the event. Only present for some event types */
    @JsonProperty("data")
    @ExcludeMissing
    fun _data(): JsonField<Data> = data

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MessageEvent =
        apply {
            if (validated) {
              return@apply
            }

            id()
            _typename()
            insertedAt()
            recipient().validate()
            type()
            data().ifPresent { it.validate() }
            validated = true
        }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageEvent].
         *
         * The following fields are required:
         *
         * ```java
         * .id()
         * ._typename()
         * .insertedAt()
         * .recipient()
         * .type()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
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
        internal fun from(messageEvent: MessageEvent) =
            apply {
                id = messageEvent.id
                _typename = messageEvent._typename
                insertedAt = messageEvent.insertedAt
                recipient = messageEvent.recipient
                type = messageEvent.type
                data = messageEvent.data
                additionalProperties = messageEvent.additionalProperties.toMutableMap()
            }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) =
            apply {
                this.id = id
            }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) =
            apply {
                this._typename = _typename
            }

        fun insertedAt(insertedAt: OffsetDateTime) = insertedAt(JsonField.of(insertedAt))

        fun insertedAt(insertedAt: JsonField<OffsetDateTime>) =
            apply {
                this.insertedAt = insertedAt
            }

        /**
         * A reference to a recipient, either a user identifier (string) or an object
         * reference (id, collection).
         */
        fun recipient(recipient: Recipient) = recipient(JsonField.of(recipient))

        /**
         * A reference to a recipient, either a user identifier (string) or an object
         * reference (id, collection).
         */
        fun recipient(recipient: JsonField<Recipient>) =
            apply {
                this.recipient = recipient
            }

        /** A user identifier */
        fun recipient(string: String) = recipient(Recipient.ofString(string))

        /** An object reference to a recipient */
        fun recipient(objectReference: Recipient.ObjectReference) = recipient(Recipient.ofObjectReference(objectReference))

        fun type(type: Type) = type(JsonField.of(type))

        fun type(type: JsonField<Type>) =
            apply {
                this.type = type
            }

        /** The data associated with the event. Only present for some event types */
        fun data(data: Data?) = data(JsonField.ofNullable(data))

        /** The data associated with the event. Only present for some event types */
        fun data(data: Optional<Data>) = data(data.getOrNull())

        /** The data associated with the event. Only present for some event types */
        fun data(data: JsonField<Data>) =
            apply {
                this.data = data
            }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
            apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

        fun putAdditionalProperty(key: String, value: JsonValue) =
            apply {
                additionalProperties.put(key, value)
            }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
            apply {
                this.additionalProperties.putAll(additionalProperties)
            }

        fun removeAdditionalProperty(key: String) =
            apply {
                additionalProperties.remove(key)
            }

        fun removeAllAdditionalProperties(keys: Set<String>) =
            apply {
                keys.forEach(::removeAdditionalProperty)
            }

        fun build(): MessageEvent =
            MessageEvent(
              checkRequired(
                "id", id
              ),
              checkRequired(
                "_typename", _typename
              ),
              checkRequired(
                "insertedAt", insertedAt
              ),
              checkRequired(
                "recipient", recipient
              ),
              checkRequired(
                "type", type
              ),
              data,
              additionalProperties.toImmutable(),
            )
    }

    /**
     * A reference to a recipient, either a user identifier (string) or an object
     * reference (id, collection).
     */
    @JsonDeserialize(using = Recipient.Deserializer::class)
    @JsonSerialize(using = Recipient.Serializer::class)
    class Recipient private constructor(
        private val string: String? = null,
        private val objectReference: ObjectReference? = null,
        private val _json: JsonValue? = null,

    ) {

        /** A user identifier */
        fun string(): Optional<String> = Optional.ofNullable(string)

        /** An object reference to a recipient */
        fun objectReference(): Optional<ObjectReference> = Optional.ofNullable(objectReference)

        fun isString(): Boolean = string != null

        fun isObjectReference(): Boolean = objectReference != null

        /** A user identifier */
        fun asString(): String = string.getOrThrow("string")

        /** An object reference to a recipient */
        fun asObjectReference(): ObjectReference = objectReference.getOrThrow("objectReference")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
          return when {
              string != null -> visitor.visitString(string)
              objectReference != null -> visitor.visitObjectReference(objectReference)
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
                    override fun visitString(string: String) {

                    }

                    override fun visitObjectReference(objectReference: ObjectReference) {
                      objectReference.validate()
                    }
                })
                validated = true
            }

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return /* spotless:off */ other is Recipient && string == other.string && objectReference == other.objectReference /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, objectReference) /* spotless:on */

        override fun toString(): String =
            when {
                string != null -> "Recipient{string=$string}"
                objectReference != null -> "Recipient{objectReference=$objectReference}"
                _json != null -> "Recipient{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Recipient")
            }

        companion object {

            /** A user identifier */
            @JvmStatic
            fun ofString(string: String) = Recipient(string = string)

            /** An object reference to a recipient */
            @JvmStatic
            fun ofObjectReference(objectReference: ObjectReference) = Recipient(objectReference = objectReference)
        }

        /**
         * An interface that defines how to map each variant of [Recipient] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            /** A user identifier */
            fun visitString(string: String): T

            /** An object reference to a recipient */
            fun visitObjectReference(objectReference: ObjectReference): T

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

              tryDeserialize(node, jacksonTypeRef<String>())?.let {
                  return Recipient(string = it, _json = json)
              }
              tryDeserialize(node, jacksonTypeRef<ObjectReference>()){ it.validate() }?.let {
                  return Recipient(objectReference = it, _json = json)
              }

              return Recipient(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Recipient>(Recipient::class) {

            override fun serialize(value: Recipient, generator: JsonGenerator, provider: SerializerProvider) {
              when {
                  value.string != null -> generator.writeObject(value.string)
                  value.objectReference != null -> generator.writeObject(value.objectReference)
                  value._json != null -> generator.writeObject(value._json)
                  else -> throw IllegalStateException("Invalid Recipient")
              }
            }
        }

        /** An object reference to a recipient */
        @NoAutoDetect
        class ObjectReference @JsonCreator private constructor(
            @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("collection") @ExcludeMissing private val collection: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

        ) {

            /** An object identifier */
            fun id(): String = id.getRequired("id")

            /** The collection the object belongs to */
            fun collection(): String = collection.getRequired("collection")

            /** An object identifier */
            @JsonProperty("id")
            @ExcludeMissing
            fun _id(): JsonField<String> = id

            /** The collection the object belongs to */
            @JsonProperty("collection")
            @ExcludeMissing
            fun _collection(): JsonField<String> = collection

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): ObjectReference =
                apply {
                    if (validated) {
                      return@apply
                    }

                    id()
                    collection()
                    validated = true
                }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [ObjectReference].
                 *
                 * The following fields are required:
                 *
                 * ```java
                 * .id()
                 * .collection()
                 * ```
                 */
                @JvmStatic
                fun builder() = Builder()
            }

            /** A builder for [ObjectReference]. */
            class Builder internal constructor() {

                private var id: JsonField<String>? = null
                private var collection: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(objectReference: ObjectReference) =
                    apply {
                        id = objectReference.id
                        collection = objectReference.collection
                        additionalProperties = objectReference.additionalProperties.toMutableMap()
                    }

                /** An object identifier */
                fun id(id: String) = id(JsonField.of(id))

                /** An object identifier */
                fun id(id: JsonField<String>) =
                    apply {
                        this.id = id
                    }

                /** The collection the object belongs to */
                fun collection(collection: String) = collection(JsonField.of(collection))

                /** The collection the object belongs to */
                fun collection(collection: JsonField<String>) =
                    apply {
                        this.collection = collection
                    }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                fun putAdditionalProperty(key: String, value: JsonValue) =
                    apply {
                        additionalProperties.put(key, value)
                    }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) =
                    apply {
                        additionalProperties.remove(key)
                    }

                fun removeAllAdditionalProperties(keys: Set<String>) =
                    apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                fun build(): ObjectReference =
                    ObjectReference(
                      checkRequired(
                        "id", id
                      ),
                      checkRequired(
                        "collection", collection
                      ),
                      additionalProperties.toImmutable(),
                    )
            }

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

            override fun toString() = "ObjectReference{id=$id, collection=$collection, additionalProperties=$additionalProperties}"
        }
    }

    class Type @JsonCreator private constructor(
        private val value: JsonField<String>,

    ) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that
         * doesn't match any known member, and you want to know that value. For example, if
         * the SDK is on an older version than the API, then the API may respond with new
         * members that the SDK is unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue
        fun _value(): JsonField<String> = value

        companion object {

            @JvmField val MESSAGE_QUEUED = of("message.queued")

            @JvmField val MESSAGE_SENT = of("message.sent")

            @JvmField val MESSAGE_DELIVERED = of("message.delivered")

            @JvmField val MESSAGE_UNDELIVERED = of("message.undelivered")

            @JvmField val MESSAGE_BOUNCED = of("message.bounced")

            @JvmField val MESSAGE_READ = of("message.read")

            @JvmField val MESSAGE_UNREAD = of("message.unread")

            @JvmField val MESSAGE_LINK_CLICKED = of("message.link_clicked")

            @JvmField val MESSAGE_INTERACTED = of("message.interacted")

            @JvmField val MESSAGE_SEEN = of("message.seen")

            @JvmField val MESSAGE_UNSEEN = of("message.unseen")

            @JvmField val MESSAGE_ARCHIVED = of("message.archived")

            @JvmField val MESSAGE_UNARCHIVED = of("message.unarchived")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            MESSAGE_QUEUED,
            MESSAGE_SENT,
            MESSAGE_DELIVERED,
            MESSAGE_UNDELIVERED,
            MESSAGE_BOUNCED,
            MESSAGE_READ,
            MESSAGE_UNREAD,
            MESSAGE_LINK_CLICKED,
            MESSAGE_INTERACTED,
            MESSAGE_SEEN,
            MESSAGE_UNSEEN,
            MESSAGE_ARCHIVED,
            MESSAGE_UNARCHIVED,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         *
         * - It was deserialized from data that doesn't match any known member. For
         *   example, if the SDK is on an older version than the API, then the API may
         *   respond with new members that the SDK is unaware of.
         *
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            MESSAGE_QUEUED,
            MESSAGE_SENT,
            MESSAGE_DELIVERED,
            MESSAGE_UNDELIVERED,
            MESSAGE_BOUNCED,
            MESSAGE_READ,
            MESSAGE_UNREAD,
            MESSAGE_LINK_CLICKED,
            MESSAGE_INTERACTED,
            MESSAGE_SEEN,
            MESSAGE_UNSEEN,
            MESSAGE_ARCHIVED,
            MESSAGE_UNARCHIVED,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or
         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if
         * you want to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                MESSAGE_QUEUED -> Value.MESSAGE_QUEUED
                MESSAGE_SENT -> Value.MESSAGE_SENT
                MESSAGE_DELIVERED -> Value.MESSAGE_DELIVERED
                MESSAGE_UNDELIVERED -> Value.MESSAGE_UNDELIVERED
                MESSAGE_BOUNCED -> Value.MESSAGE_BOUNCED
                MESSAGE_READ -> Value.MESSAGE_READ
                MESSAGE_UNREAD -> Value.MESSAGE_UNREAD
                MESSAGE_LINK_CLICKED -> Value.MESSAGE_LINK_CLICKED
                MESSAGE_INTERACTED -> Value.MESSAGE_INTERACTED
                MESSAGE_SEEN -> Value.MESSAGE_SEEN
                MESSAGE_UNSEEN -> Value.MESSAGE_UNSEEN
                MESSAGE_ARCHIVED -> Value.MESSAGE_ARCHIVED
                MESSAGE_UNARCHIVED -> Value.MESSAGE_UNARCHIVED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and
         * don't want to throw for the unknown case.
         *
         * @throws KnockInvalidDataException if this class instance's value is a not a
         * known member.
         */
        fun known(): Known =
            when (this) {
                MESSAGE_QUEUED -> Known.MESSAGE_QUEUED
                MESSAGE_SENT -> Known.MESSAGE_SENT
                MESSAGE_DELIVERED -> Known.MESSAGE_DELIVERED
                MESSAGE_UNDELIVERED -> Known.MESSAGE_UNDELIVERED
                MESSAGE_BOUNCED -> Known.MESSAGE_BOUNCED
                MESSAGE_READ -> Known.MESSAGE_READ
                MESSAGE_UNREAD -> Known.MESSAGE_UNREAD
                MESSAGE_LINK_CLICKED -> Known.MESSAGE_LINK_CLICKED
                MESSAGE_INTERACTED -> Known.MESSAGE_INTERACTED
                MESSAGE_SEEN -> Known.MESSAGE_SEEN
                MESSAGE_UNSEEN -> Known.MESSAGE_UNSEEN
                MESSAGE_ARCHIVED -> Known.MESSAGE_ARCHIVED
                MESSAGE_UNARCHIVED -> Known.MESSAGE_UNARCHIVED
                else -> throw KnockInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for
         * debugging and generally doesn't throw.
         *
         * @throws KnockInvalidDataException if this class instance's value does not have
         * the expected primitive type.
         */
        fun asString(): String = _value().asString().orElseThrow { KnockInvalidDataException("Value is not a String") }

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return /* spotless:off */ other is Type && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The data associated with the event. Only present for some event types */
    @NoAutoDetect
    class Data @JsonCreator private constructor(
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Data =
            apply {
                if (validated) {
                  return@apply
                }

                validated = true
            }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic
            fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) =
                apply {
                    additionalProperties = data.additionalProperties.toMutableMap()
                }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

            fun putAdditionalProperty(key: String, value: JsonValue) =
                apply {
                    additionalProperties.put(key, value)
                }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                apply {
                    this.additionalProperties.putAll(additionalProperties)
                }

            fun removeAdditionalProperty(key: String) =
                apply {
                    additionalProperties.remove(key)
                }

            fun removeAllAdditionalProperties(keys: Set<String>) =
                apply {
                    keys.forEach(::removeAdditionalProperty)
                }

            fun build(): Data = Data(additionalProperties.toImmutable())
        }

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

    override fun toString() = "MessageEvent{id=$id, _typename=$_typename, insertedAt=$insertedAt, recipient=$recipient, type=$type, data=$data, additionalProperties=$additionalProperties}"
}
