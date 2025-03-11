// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.recipients

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkRequired
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.models.objects.Object
import com.knock.api.models.users.User
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A subscription object */
@NoAutoDetect
class Subscription
@JsonCreator
private constructor(
    @JsonProperty("__typename")
    @ExcludeMissing
    private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("inserted_at")
    @ExcludeMissing
    private val insertedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("object")
    @ExcludeMissing
    private val object_: JsonField<Object> = JsonMissing.of(),
    @JsonProperty("recipient")
    @ExcludeMissing
    private val recipient: JsonField<Recipient> = JsonMissing.of(),
    @JsonProperty("updated_at")
    @ExcludeMissing
    private val updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("properties")
    @ExcludeMissing
    private val properties: JsonField<Properties> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun _typename(): String = _typename.getRequired("__typename")

    fun insertedAt(): OffsetDateTime = insertedAt.getRequired("inserted_at")

    /** A custom-object entity which belongs to a collection. */
    fun object_(): Object = object_.getRequired("object")

    /** A recipient, which is either a user or an object */
    fun recipient(): Recipient = recipient.getRequired("recipient")

    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

    /** The custom properties associated with the subscription */
    fun properties(): Optional<Properties> =
        Optional.ofNullable(properties.getNullable("properties"))

    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    @JsonProperty("inserted_at")
    @ExcludeMissing
    fun _insertedAt(): JsonField<OffsetDateTime> = insertedAt

    /** A custom-object entity which belongs to a collection. */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<Object> = object_

    /** A recipient, which is either a user or an object */
    @JsonProperty("recipient") @ExcludeMissing fun _recipient(): JsonField<Recipient> = recipient

    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /** The custom properties associated with the subscription */
    @JsonProperty("properties")
    @ExcludeMissing
    fun _properties(): JsonField<Properties> = properties

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Subscription = apply {
        if (validated) {
            return@apply
        }

        _typename()
        insertedAt()
        object_().validate()
        recipient().validate()
        updatedAt()
        properties().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [Subscription].
         *
         * The following fields are required:
         * ```java
         * ._typename()
         * .insertedAt()
         * .object_()
         * .recipient()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Subscription]. */
    class Builder internal constructor() {

        private var _typename: JsonField<String>? = null
        private var insertedAt: JsonField<OffsetDateTime>? = null
        private var object_: JsonField<Object>? = null
        private var recipient: JsonField<Recipient>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var properties: JsonField<Properties> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(subscription: Subscription) = apply {
            _typename = subscription._typename
            insertedAt = subscription.insertedAt
            object_ = subscription.object_
            recipient = subscription.recipient
            updatedAt = subscription.updatedAt
            properties = subscription.properties
            additionalProperties = subscription.additionalProperties.toMutableMap()
        }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        fun insertedAt(insertedAt: OffsetDateTime) = insertedAt(JsonField.of(insertedAt))

        fun insertedAt(insertedAt: JsonField<OffsetDateTime>) = apply {
            this.insertedAt = insertedAt
        }

        /** A custom-object entity which belongs to a collection. */
        fun object_(object_: Object) = object_(JsonField.of(object_))

        /** A custom-object entity which belongs to a collection. */
        fun object_(object_: JsonField<Object>) = apply { this.object_ = object_ }

        /** A recipient, which is either a user or an object */
        fun recipient(recipient: Recipient) = recipient(JsonField.of(recipient))

        /** A recipient, which is either a user or an object */
        fun recipient(recipient: JsonField<Recipient>) = apply { this.recipient = recipient }

        /** A user object */
        fun recipient(user: User) = recipient(Recipient.ofUser(user))

        /** A custom-object entity which belongs to a collection. */
        fun recipient(object_: Object) = recipient(Recipient.ofObject(object_))

        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /** The custom properties associated with the subscription */
        fun properties(properties: Properties?) = properties(JsonField.ofNullable(properties))

        /** The custom properties associated with the subscription */
        fun properties(properties: Optional<Properties>) = properties(properties.getOrNull())

        /** The custom properties associated with the subscription */
        fun properties(properties: JsonField<Properties>) = apply { this.properties = properties }

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

        fun build(): Subscription =
            Subscription(
                checkRequired("_typename", _typename),
                checkRequired("insertedAt", insertedAt),
                checkRequired("object_", object_),
                checkRequired("recipient", recipient),
                checkRequired("updatedAt", updatedAt),
                properties,
                additionalProperties.toImmutable(),
            )
    }

    /** The custom properties associated with the subscription */
    @NoAutoDetect
    class Properties
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Properties = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Properties]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Properties]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(properties: Properties) = apply {
                additionalProperties = properties.additionalProperties.toMutableMap()
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

            fun build(): Properties = Properties(additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Properties && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Properties{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Subscription && _typename == other._typename && insertedAt == other.insertedAt && object_ == other.object_ && recipient == other.recipient && updatedAt == other.updatedAt && properties == other.properties && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(_typename, insertedAt, object_, recipient, updatedAt, properties, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Subscription{_typename=$_typename, insertedAt=$insertedAt, object_=$object_, recipient=$recipient, updatedAt=$updatedAt, properties=$properties, additionalProperties=$additionalProperties}"
}
