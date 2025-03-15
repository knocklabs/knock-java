// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.objects.Object
import app.knock.api.models.recipients.Recipient
import app.knock.api.models.users.User
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A schedule that represents a recurring workflow execution */
@NoAutoDetect
class Schedule
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("inserted_at")
    @ExcludeMissing
    private val insertedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("recipient")
    @ExcludeMissing
    private val recipient: JsonField<Recipient> = JsonMissing.of(),
    @JsonProperty("repeats")
    @ExcludeMissing
    private val repeats: JsonField<List<ScheduleRepeatRule>> = JsonMissing.of(),
    @JsonProperty("updated_at")
    @ExcludeMissing
    private val updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("workflow")
    @ExcludeMissing
    private val workflow: JsonField<String> = JsonMissing.of(),
    @JsonProperty("__typename")
    @ExcludeMissing
    private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("actor")
    @ExcludeMissing
    private val actor: JsonField<Recipient> = JsonMissing.of(),
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<Data> = JsonMissing.of(),
    @JsonProperty("last_occurrence_at")
    @ExcludeMissing
    private val lastOccurrenceAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("next_occurrence_at")
    @ExcludeMissing
    private val nextOccurrenceAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("tenant")
    @ExcludeMissing
    private val tenant: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun insertedAt(): OffsetDateTime = insertedAt.getRequired("inserted_at")

    /**
     * A recipient, which is either a user or an object
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipient(): Recipient = recipient.getRequired("recipient")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun repeats(): List<ScheduleRepeatRule> = repeats.getRequired("repeats")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun workflow(): String = workflow.getRequired("workflow")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun _typename(): Optional<String> = Optional.ofNullable(_typename.getNullable("__typename"))

    /**
     * A recipient, which is either a user or an object
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun actor(): Optional<Recipient> = Optional.ofNullable(actor.getNullable("actor"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<Data> = Optional.ofNullable(data.getNullable("data"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun lastOccurrenceAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(lastOccurrenceAt.getNullable("last_occurrence_at"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun nextOccurrenceAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(nextOccurrenceAt.getNullable("next_occurrence_at"))

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tenant(): Optional<String> = Optional.ofNullable(tenant.getNullable("tenant"))

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

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
     * Returns the raw JSON value of [repeats].
     *
     * Unlike [repeats], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("repeats")
    @ExcludeMissing
    fun _repeats(): JsonField<List<ScheduleRepeatRule>> = repeats

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    /**
     * Returns the raw JSON value of [workflow].
     *
     * Unlike [workflow], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("workflow") @ExcludeMissing fun _workflow(): JsonField<String> = workflow

    /**
     * Returns the raw JSON value of [_typename].
     *
     * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    /**
     * Returns the raw JSON value of [actor].
     *
     * Unlike [actor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<Recipient> = actor

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [lastOccurrenceAt].
     *
     * Unlike [lastOccurrenceAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("last_occurrence_at")
    @ExcludeMissing
    fun _lastOccurrenceAt(): JsonField<OffsetDateTime> = lastOccurrenceAt

    /**
     * Returns the raw JSON value of [nextOccurrenceAt].
     *
     * Unlike [nextOccurrenceAt], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("next_occurrence_at")
    @ExcludeMissing
    fun _nextOccurrenceAt(): JsonField<OffsetDateTime> = nextOccurrenceAt

    /**
     * Returns the raw JSON value of [tenant].
     *
     * Unlike [tenant], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tenant") @ExcludeMissing fun _tenant(): JsonField<String> = tenant

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Schedule = apply {
        if (validated) {
            return@apply
        }

        id()
        insertedAt()
        recipient().validate()
        repeats().forEach { it.validate() }
        updatedAt()
        workflow()
        _typename()
        actor().ifPresent { it.validate() }
        data().ifPresent { it.validate() }
        lastOccurrenceAt()
        nextOccurrenceAt()
        tenant()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [Schedule].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .insertedAt()
         * .recipient()
         * .repeats()
         * .updatedAt()
         * .workflow()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Schedule]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var insertedAt: JsonField<OffsetDateTime>? = null
        private var recipient: JsonField<Recipient>? = null
        private var repeats: JsonField<MutableList<ScheduleRepeatRule>>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var workflow: JsonField<String>? = null
        private var _typename: JsonField<String> = JsonMissing.of()
        private var actor: JsonField<Recipient> = JsonMissing.of()
        private var data: JsonField<Data> = JsonMissing.of()
        private var lastOccurrenceAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var nextOccurrenceAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var tenant: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(schedule: Schedule) = apply {
            id = schedule.id
            insertedAt = schedule.insertedAt
            recipient = schedule.recipient
            repeats = schedule.repeats.map { it.toMutableList() }
            updatedAt = schedule.updatedAt
            workflow = schedule.workflow
            _typename = schedule._typename
            actor = schedule.actor
            data = schedule.data
            lastOccurrenceAt = schedule.lastOccurrenceAt
            nextOccurrenceAt = schedule.nextOccurrenceAt
            tenant = schedule.tenant
            additionalProperties = schedule.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

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

        /** A recipient, which is either a user or an object */
        fun recipient(recipient: Recipient) = recipient(JsonField.of(recipient))

        /**
         * Sets [Builder.recipient] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipient] with a well-typed [Recipient] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun recipient(recipient: JsonField<Recipient>) = apply { this.recipient = recipient }

        /** Alias for calling [recipient] with `Recipient.ofUser(user)`. */
        fun recipient(user: User) = recipient(Recipient.ofUser(user))

        /** Alias for calling [recipient] with `Recipient.ofObject(object_)`. */
        fun recipient(object_: Object) = recipient(Recipient.ofObject(object_))

        fun repeats(repeats: List<ScheduleRepeatRule>) = repeats(JsonField.of(repeats))

        /**
         * Sets [Builder.repeats] to an arbitrary JSON value.
         *
         * You should usually call [Builder.repeats] with a well-typed `List<ScheduleRepeatRule>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun repeats(repeats: JsonField<List<ScheduleRepeatRule>>) = apply {
            this.repeats = repeats.map { it.toMutableList() }
        }

        /**
         * Adds a single [ScheduleRepeatRule] to [repeats].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRepeat(repeat: ScheduleRepeatRule) = apply {
            repeats =
                (repeats ?: JsonField.of(mutableListOf())).also {
                    checkKnown("repeats", it).add(repeat)
                }
        }

        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        fun workflow(workflow: String) = workflow(JsonField.of(workflow))

        /**
         * Sets [Builder.workflow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workflow] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun workflow(workflow: JsonField<String>) = apply { this.workflow = workflow }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** A recipient, which is either a user or an object */
        fun actor(actor: Recipient?) = actor(JsonField.ofNullable(actor))

        /** Alias for calling [Builder.actor] with `actor.orElse(null)`. */
        fun actor(actor: Optional<Recipient>) = actor(actor.getOrNull())

        /**
         * Sets [Builder.actor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.actor] with a well-typed [Recipient] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun actor(actor: JsonField<Recipient>) = apply { this.actor = actor }

        /** Alias for calling [actor] with `Recipient.ofUser(user)`. */
        fun actor(user: User) = actor(Recipient.ofUser(user))

        /** Alias for calling [actor] with `Recipient.ofObject(object_)`. */
        fun actor(object_: Object) = actor(Recipient.ofObject(object_))

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

        fun lastOccurrenceAt(lastOccurrenceAt: OffsetDateTime?) =
            lastOccurrenceAt(JsonField.ofNullable(lastOccurrenceAt))

        /** Alias for calling [Builder.lastOccurrenceAt] with `lastOccurrenceAt.orElse(null)`. */
        fun lastOccurrenceAt(lastOccurrenceAt: Optional<OffsetDateTime>) =
            lastOccurrenceAt(lastOccurrenceAt.getOrNull())

        /**
         * Sets [Builder.lastOccurrenceAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.lastOccurrenceAt] with a well-typed [OffsetDateTime]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun lastOccurrenceAt(lastOccurrenceAt: JsonField<OffsetDateTime>) = apply {
            this.lastOccurrenceAt = lastOccurrenceAt
        }

        fun nextOccurrenceAt(nextOccurrenceAt: OffsetDateTime?) =
            nextOccurrenceAt(JsonField.ofNullable(nextOccurrenceAt))

        /** Alias for calling [Builder.nextOccurrenceAt] with `nextOccurrenceAt.orElse(null)`. */
        fun nextOccurrenceAt(nextOccurrenceAt: Optional<OffsetDateTime>) =
            nextOccurrenceAt(nextOccurrenceAt.getOrNull())

        /**
         * Sets [Builder.nextOccurrenceAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nextOccurrenceAt] with a well-typed [OffsetDateTime]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun nextOccurrenceAt(nextOccurrenceAt: JsonField<OffsetDateTime>) = apply {
            this.nextOccurrenceAt = nextOccurrenceAt
        }

        fun tenant(tenant: String?) = tenant(JsonField.ofNullable(tenant))

        /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        /**
         * Sets [Builder.tenant] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tenant] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tenant(tenant: JsonField<String>) = apply { this.tenant = tenant }

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

        fun build(): Schedule =
            Schedule(
                checkRequired("id", id),
                checkRequired("insertedAt", insertedAt),
                checkRequired("recipient", recipient),
                checkRequired("repeats", repeats).map { it.toImmutable() },
                checkRequired("updatedAt", updatedAt),
                checkRequired("workflow", workflow),
                _typename,
                actor,
                data,
                lastOccurrenceAt,
                nextOccurrenceAt,
                tenant,
                additionalProperties.toImmutable(),
            )
    }

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

        return /* spotless:off */ other is Schedule && id == other.id && insertedAt == other.insertedAt && recipient == other.recipient && repeats == other.repeats && updatedAt == other.updatedAt && workflow == other.workflow && _typename == other._typename && actor == other.actor && data == other.data && lastOccurrenceAt == other.lastOccurrenceAt && nextOccurrenceAt == other.nextOccurrenceAt && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, insertedAt, recipient, repeats, updatedAt, workflow, _typename, actor, data, lastOccurrenceAt, nextOccurrenceAt, tenant, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Schedule{id=$id, insertedAt=$insertedAt, recipient=$recipient, repeats=$repeats, updatedAt=$updatedAt, workflow=$workflow, _typename=$_typename, actor=$actor, data=$data, lastOccurrenceAt=$lastOccurrenceAt, nextOccurrenceAt=$nextOccurrenceAt, tenant=$tenant, additionalProperties=$additionalProperties}"
}
