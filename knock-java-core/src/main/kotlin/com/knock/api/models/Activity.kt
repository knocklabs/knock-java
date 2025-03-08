// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** An activity associated with a workflow run */
@NoAutoDetect
class Activity
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("__typename")
    @ExcludeMissing
    private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("actor")
    @ExcludeMissing
    private val actor: JsonField<Recipient> = JsonMissing.of(),
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<Data> = JsonMissing.of(),
    @JsonProperty("inserted_at")
    @ExcludeMissing
    private val insertedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("recipient")
    @ExcludeMissing
    private val recipient: JsonField<Recipient> = JsonMissing.of(),
    @JsonProperty("updated_at")
    @ExcludeMissing
    private val updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun id(): Optional<String> = Optional.ofNullable(id.getNullable("id"))

    fun _typename(): Optional<String> = Optional.ofNullable(_typename.getNullable("__typename"))

    /** A recipient, which is either a user or an object */
    fun actor(): Optional<Recipient> = Optional.ofNullable(actor.getNullable("actor"))

    /** The data associated with the activity */
    fun data(): Optional<Data> = Optional.ofNullable(data.getNullable("data"))

    fun insertedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(insertedAt.getNullable("inserted_at"))

    /** A recipient, which is either a user or an object */
    fun recipient(): Optional<Recipient> = Optional.ofNullable(recipient.getNullable("recipient"))

    fun updatedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(updatedAt.getNullable("updated_at"))

    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    /** A recipient, which is either a user or an object */
    @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<Recipient> = actor

    /** The data associated with the activity */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    @JsonProperty("inserted_at")
    @ExcludeMissing
    fun _insertedAt(): JsonField<OffsetDateTime> = insertedAt

    /** A recipient, which is either a user or an object */
    @JsonProperty("recipient") @ExcludeMissing fun _recipient(): JsonField<Recipient> = recipient

    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Activity = apply {
        if (validated) {
            return@apply
        }

        id()
        _typename()
        actor().ifPresent { it.validate() }
        data().ifPresent { it.validate() }
        insertedAt()
        recipient().ifPresent { it.validate() }
        updatedAt()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [Activity]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Activity]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var _typename: JsonField<String> = JsonMissing.of()
        private var actor: JsonField<Recipient> = JsonMissing.of()
        private var data: JsonField<Data> = JsonMissing.of()
        private var insertedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var recipient: JsonField<Recipient> = JsonMissing.of()
        private var updatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(activity: Activity) = apply {
            id = activity.id
            _typename = activity._typename
            actor = activity.actor
            data = activity.data
            insertedAt = activity.insertedAt
            recipient = activity.recipient
            updatedAt = activity.updatedAt
            additionalProperties = activity.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) = apply { this.id = id }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** A recipient, which is either a user or an object */
        fun actor(actor: Recipient?) = actor(JsonField.ofNullable(actor))

        /** A recipient, which is either a user or an object */
        fun actor(actor: Optional<Recipient>) = actor(actor.getOrNull())

        /** A recipient, which is either a user or an object */
        fun actor(actor: JsonField<Recipient>) = apply { this.actor = actor }

        /** A user object */
        fun actor(user: User) = actor(Recipient.ofUser(user))

        /** A custom-object entity which belongs to a collection. */
        fun actor(object_: Object) = actor(Recipient.ofObject(object_))

        /** The data associated with the activity */
        fun data(data: Data?) = data(JsonField.ofNullable(data))

        /** The data associated with the activity */
        fun data(data: Optional<Data>) = data(data.getOrNull())

        /** The data associated with the activity */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        fun insertedAt(insertedAt: OffsetDateTime) = insertedAt(JsonField.of(insertedAt))

        fun insertedAt(insertedAt: JsonField<OffsetDateTime>) = apply {
            this.insertedAt = insertedAt
        }

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

        fun build(): Activity =
            Activity(
                id,
                _typename,
                actor,
                data,
                insertedAt,
                recipient,
                updatedAt,
                additionalProperties.toImmutable(),
            )
    }

    /** The data associated with the activity */
    @NoAutoDetect
    class Data
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

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

        return /* spotless:off */ other is Activity && id == other.id && _typename == other._typename && actor == other.actor && data == other.data && insertedAt == other.insertedAt && recipient == other.recipient && updatedAt == other.updatedAt && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, actor, data, insertedAt, recipient, updatedAt, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Activity{id=$id, _typename=$_typename, actor=$actor, data=$data, insertedAt=$insertedAt, recipient=$recipient, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
