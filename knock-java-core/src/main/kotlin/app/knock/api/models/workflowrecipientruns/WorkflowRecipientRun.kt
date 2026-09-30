// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflowrecipientruns

import app.knock.api.core.Enum
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkRequired
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.recipients.RecipientReference
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * A workflow recipient run represents an individual execution of a workflow for a specific
 * recipient.
 */
class WorkflowRecipientRun
private constructor(
    private val id: JsonField<String>,
    private val _typename: JsonField<String>,
    private val insertedAt: JsonField<OffsetDateTime>,
    private val recipient: JsonField<RecipientReference>,
    private val status: JsonField<Status>,
    private val triggerSource: JsonField<TriggerSource>,
    private val updatedAt: JsonField<OffsetDateTime>,
    private val workflow: JsonField<String>,
    private val workflowRunId: JsonField<String>,
    private val actor: JsonField<RecipientReference>,
    private val errorCount: JsonField<Long>,
    private val tenant: JsonField<String>,
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
        recipient: JsonField<RecipientReference> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("trigger_source")
        @ExcludeMissing
        triggerSource: JsonField<TriggerSource> = JsonMissing.of(),
        @JsonProperty("updated_at")
        @ExcludeMissing
        updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("workflow") @ExcludeMissing workflow: JsonField<String> = JsonMissing.of(),
        @JsonProperty("workflow_run_id")
        @ExcludeMissing
        workflowRunId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("actor")
        @ExcludeMissing
        actor: JsonField<RecipientReference> = JsonMissing.of(),
        @JsonProperty("error_count") @ExcludeMissing errorCount: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("tenant") @ExcludeMissing tenant: JsonField<String> = JsonMissing.of(),
    ) : this(
        id,
        _typename,
        insertedAt,
        recipient,
        status,
        triggerSource,
        updatedAt,
        workflow,
        workflowRunId,
        actor,
        errorCount,
        tenant,
        mutableMapOf(),
    )

    /**
     * The unique identifier for the workflow recipient run (per-recipient).
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The typename of the schema.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): String = _typename.getRequired("__typename")

    /**
     * Timestamp when the resource was created.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun insertedAt(): OffsetDateTime = insertedAt.getRequired("inserted_at")

    /**
     * A reference to a recipient, either a user identifier (string) or an object reference (ID,
     * collection).
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipient(): RecipientReference = recipient.getRequired("recipient")

    /**
     * The current status of the workflow recipient run. One of `queued`, `processing`, `paused`,
     * `completed`, or `cancelled`.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Describes how the workflow was triggered.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun triggerSource(): TriggerSource = triggerSource.getRequired("trigger_source")

    /**
     * The timestamp when the resource was last updated.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

    /**
     * The key of the workflow that was executed.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun workflow(): String = workflow.getRequired("workflow")

    /**
     * The identifier for the top-level workflow run shared across all recipients in a single
     * trigger.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun workflowRunId(): String = workflowRunId.getRequired("workflow_run_id")

    /**
     * A reference to a recipient, either a user identifier (string) or an object reference (ID,
     * collection).
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun actor(): Optional<RecipientReference> = actor.getOptional("actor")

    /**
     * The number of errors encountered during the workflow recipient run.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun errorCount(): Optional<Long> = errorCount.getOptional("error_count")

    /**
     * The tenant associated with the workflow recipient run.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tenant(): Optional<String> = tenant.getOptional("tenant")

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
    @JsonProperty("recipient")
    @ExcludeMissing
    fun _recipient(): JsonField<RecipientReference> = recipient

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [triggerSource].
     *
     * Unlike [triggerSource], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("trigger_source")
    @ExcludeMissing
    fun _triggerSource(): JsonField<TriggerSource> = triggerSource

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
     * Returns the raw JSON value of [workflowRunId].
     *
     * Unlike [workflowRunId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("workflow_run_id")
    @ExcludeMissing
    fun _workflowRunId(): JsonField<String> = workflowRunId

    /**
     * Returns the raw JSON value of [actor].
     *
     * Unlike [actor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<RecipientReference> = actor

    /**
     * Returns the raw JSON value of [errorCount].
     *
     * Unlike [errorCount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error_count") @ExcludeMissing fun _errorCount(): JsonField<Long> = errorCount

    /**
     * Returns the raw JSON value of [tenant].
     *
     * Unlike [tenant], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tenant") @ExcludeMissing fun _tenant(): JsonField<String> = tenant

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
         * Returns a mutable builder for constructing an instance of [WorkflowRecipientRun].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .insertedAt()
         * .recipient()
         * .status()
         * .triggerSource()
         * .updatedAt()
         * .workflow()
         * .workflowRunId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WorkflowRecipientRun]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var _typename: JsonField<String>? = null
        private var insertedAt: JsonField<OffsetDateTime>? = null
        private var recipient: JsonField<RecipientReference>? = null
        private var status: JsonField<Status>? = null
        private var triggerSource: JsonField<TriggerSource>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var workflow: JsonField<String>? = null
        private var workflowRunId: JsonField<String>? = null
        private var actor: JsonField<RecipientReference> = JsonMissing.of()
        private var errorCount: JsonField<Long> = JsonMissing.of()
        private var tenant: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(workflowRecipientRun: WorkflowRecipientRun) = apply {
            id = workflowRecipientRun.id
            _typename = workflowRecipientRun._typename
            insertedAt = workflowRecipientRun.insertedAt
            recipient = workflowRecipientRun.recipient
            status = workflowRecipientRun.status
            triggerSource = workflowRecipientRun.triggerSource
            updatedAt = workflowRecipientRun.updatedAt
            workflow = workflowRecipientRun.workflow
            workflowRunId = workflowRecipientRun.workflowRunId
            actor = workflowRecipientRun.actor
            errorCount = workflowRecipientRun.errorCount
            tenant = workflowRecipientRun.tenant
            additionalProperties = workflowRecipientRun.additionalProperties.toMutableMap()
        }

        /** The unique identifier for the workflow recipient run (per-recipient). */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The typename of the schema. */
        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** Timestamp when the resource was created. */
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
         * A reference to a recipient, either a user identifier (string) or an object reference (ID,
         * collection).
         */
        fun recipient(recipient: RecipientReference) = recipient(JsonField.of(recipient))

        /**
         * Sets [Builder.recipient] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipient] with a well-typed [RecipientReference] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recipient(recipient: JsonField<RecipientReference>) = apply {
            this.recipient = recipient
        }

        /** Alias for calling [recipient] with `RecipientReference.ofUser(user)`. */
        fun recipient(user: String) = recipient(RecipientReference.ofUser(user))

        /**
         * Alias for calling [recipient] with
         * `RecipientReference.ofObjectReference(objectReference)`.
         */
        fun recipient(objectReference: RecipientReference.ObjectReference) =
            recipient(RecipientReference.ofObjectReference(objectReference))

        /**
         * The current status of the workflow recipient run. One of `queued`, `processing`,
         * `paused`, `completed`, or `cancelled`.
         */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** Describes how the workflow was triggered. */
        fun triggerSource(triggerSource: TriggerSource) = triggerSource(JsonField.of(triggerSource))

        /**
         * Sets [Builder.triggerSource] to an arbitrary JSON value.
         *
         * You should usually call [Builder.triggerSource] with a well-typed [TriggerSource] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun triggerSource(triggerSource: JsonField<TriggerSource>) = apply {
            this.triggerSource = triggerSource
        }

        /** The timestamp when the resource was last updated. */
        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        /** The key of the workflow that was executed. */
        fun workflow(workflow: String) = workflow(JsonField.of(workflow))

        /**
         * Sets [Builder.workflow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workflow] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun workflow(workflow: JsonField<String>) = apply { this.workflow = workflow }

        /**
         * The identifier for the top-level workflow run shared across all recipients in a single
         * trigger.
         */
        fun workflowRunId(workflowRunId: String) = workflowRunId(JsonField.of(workflowRunId))

        /**
         * Sets [Builder.workflowRunId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workflowRunId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun workflowRunId(workflowRunId: JsonField<String>) = apply {
            this.workflowRunId = workflowRunId
        }

        /**
         * A reference to a recipient, either a user identifier (string) or an object reference (ID,
         * collection).
         */
        fun actor(actor: RecipientReference?) = actor(JsonField.ofNullable(actor))

        /** Alias for calling [Builder.actor] with `actor.orElse(null)`. */
        fun actor(actor: Optional<RecipientReference>) = actor(actor.getOrNull())

        /**
         * Sets [Builder.actor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.actor] with a well-typed [RecipientReference] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun actor(actor: JsonField<RecipientReference>) = apply { this.actor = actor }

        /** Alias for calling [actor] with `RecipientReference.ofUser(user)`. */
        fun actor(user: String) = actor(RecipientReference.ofUser(user))

        /**
         * Alias for calling [actor] with `RecipientReference.ofObjectReference(objectReference)`.
         */
        fun actor(objectReference: RecipientReference.ObjectReference) =
            actor(RecipientReference.ofObjectReference(objectReference))

        /** The number of errors encountered during the workflow recipient run. */
        fun errorCount(errorCount: Long) = errorCount(JsonField.of(errorCount))

        /**
         * Sets [Builder.errorCount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.errorCount] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun errorCount(errorCount: JsonField<Long>) = apply { this.errorCount = errorCount }

        /** The tenant associated with the workflow recipient run. */
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

        /**
         * Returns an immutable instance of [WorkflowRecipientRun].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .insertedAt()
         * .recipient()
         * .status()
         * .triggerSource()
         * .updatedAt()
         * .workflow()
         * .workflowRunId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WorkflowRecipientRun =
            WorkflowRecipientRun(
                checkRequired("id", id),
                checkRequired("__typename", _typename),
                checkRequired("inserted_at", insertedAt),
                checkRequired("recipient", recipient),
                checkRequired("status", status),
                checkRequired("trigger_source", triggerSource),
                checkRequired("updated_at", updatedAt),
                checkRequired("workflow", workflow),
                checkRequired("workflow_run_id", workflowRunId),
                actor,
                errorCount,
                tenant,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): WorkflowRecipientRun = apply {
        if (validated) {
            return@apply
        }

        id()
        _typename()
        insertedAt()
        recipient().validate()
        status().validate()
        triggerSource().validate()
        updatedAt()
        workflow()
        workflowRunId()
        actor().ifPresent { it.validate() }
        errorCount()
        tenant()
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
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (triggerSource.asKnown().getOrNull()?.validity() ?: 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0) +
            (if (workflow.asKnown().isPresent) 1 else 0) +
            (if (workflowRunId.asKnown().isPresent) 1 else 0) +
            (actor.asKnown().getOrNull()?.validity() ?: 0) +
            (if (errorCount.asKnown().isPresent) 1 else 0) +
            (if (tenant.asKnown().isPresent) 1 else 0)

    /**
     * The current status of the workflow recipient run. One of `queued`, `processing`, `paused`,
     * `completed`, or `cancelled`.
     */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val QUEUED = of("queued")

            @JvmField val PROCESSING = of("processing")

            @JvmField val PAUSED = of("paused")

            @JvmField val COMPLETED = of("completed")

            @JvmField val CANCELLED = of("cancelled")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            QUEUED,
            PROCESSING,
            PAUSED,
            COMPLETED,
            CANCELLED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            QUEUED,
            PROCESSING,
            PAUSED,
            COMPLETED,
            CANCELLED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                QUEUED -> Value.QUEUED
                PROCESSING -> Value.PROCESSING
                PAUSED -> Value.PAUSED
                COMPLETED -> Value.COMPLETED
                CANCELLED -> Value.CANCELLED
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
                QUEUED -> Known.QUEUED
                PROCESSING -> Known.PROCESSING
                PAUSED -> Known.PAUSED
                COMPLETED -> Known.COMPLETED
                CANCELLED -> Known.CANCELLED
                else -> throw KnockInvalidDataException("Unknown Status: $value")
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

        fun validate(): Status = apply {
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

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Describes how the workflow was triggered. */
    class TriggerSource
    private constructor(
        private val type: JsonField<Type>,
        private val audienceKey: JsonField<String>,
        private val cancellationKey: JsonField<String>,
        private val scheduleId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
            @JsonProperty("audience_key")
            @ExcludeMissing
            audienceKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cancellation_key")
            @ExcludeMissing
            cancellationKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("schedule_id")
            @ExcludeMissing
            scheduleId: JsonField<String> = JsonMissing.of(),
        ) : this(type, audienceKey, cancellationKey, scheduleId, mutableMapOf())

        /**
         * The type of trigger source. One of `api`, `audience`, `schedule`, `broadcast`,
         * `workflow_step`, `integration`, or `rehearsal`.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun type(): Type = type.getRequired("type")

        /**
         * The key of the audience that triggered the workflow.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun audienceKey(): Optional<String> = audienceKey.getOptional("audience_key")

        /**
         * The cancellation key provided when the workflow was triggered via the API.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cancellationKey(): Optional<String> = cancellationKey.getOptional("cancellation_key")

        /**
         * The ID of the schedule that triggered the workflow.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun scheduleId(): Optional<String> = scheduleId.getOptional("schedule_id")

        /**
         * Returns the raw JSON value of [type].
         *
         * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

        /**
         * Returns the raw JSON value of [audienceKey].
         *
         * Unlike [audienceKey], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("audience_key")
        @ExcludeMissing
        fun _audienceKey(): JsonField<String> = audienceKey

        /**
         * Returns the raw JSON value of [cancellationKey].
         *
         * Unlike [cancellationKey], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cancellation_key")
        @ExcludeMissing
        fun _cancellationKey(): JsonField<String> = cancellationKey

        /**
         * Returns the raw JSON value of [scheduleId].
         *
         * Unlike [scheduleId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("schedule_id")
        @ExcludeMissing
        fun _scheduleId(): JsonField<String> = scheduleId

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
             * Returns a mutable builder for constructing an instance of [TriggerSource].
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TriggerSource]. */
        class Builder internal constructor() {

            private var type: JsonField<Type>? = null
            private var audienceKey: JsonField<String> = JsonMissing.of()
            private var cancellationKey: JsonField<String> = JsonMissing.of()
            private var scheduleId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(triggerSource: TriggerSource) = apply {
                type = triggerSource.type
                audienceKey = triggerSource.audienceKey
                cancellationKey = triggerSource.cancellationKey
                scheduleId = triggerSource.scheduleId
                additionalProperties = triggerSource.additionalProperties.toMutableMap()
            }

            /**
             * The type of trigger source. One of `api`, `audience`, `schedule`, `broadcast`,
             * `workflow_step`, `integration`, or `rehearsal`.
             */
            fun type(type: Type) = type(JsonField.of(type))

            /**
             * Sets [Builder.type] to an arbitrary JSON value.
             *
             * You should usually call [Builder.type] with a well-typed [Type] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun type(type: JsonField<Type>) = apply { this.type = type }

            /** The key of the audience that triggered the workflow. */
            fun audienceKey(audienceKey: String?) = audienceKey(JsonField.ofNullable(audienceKey))

            /** Alias for calling [Builder.audienceKey] with `audienceKey.orElse(null)`. */
            fun audienceKey(audienceKey: Optional<String>) = audienceKey(audienceKey.getOrNull())

            /**
             * Sets [Builder.audienceKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.audienceKey] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun audienceKey(audienceKey: JsonField<String>) = apply {
                this.audienceKey = audienceKey
            }

            /** The cancellation key provided when the workflow was triggered via the API. */
            fun cancellationKey(cancellationKey: String?) =
                cancellationKey(JsonField.ofNullable(cancellationKey))

            /** Alias for calling [Builder.cancellationKey] with `cancellationKey.orElse(null)`. */
            fun cancellationKey(cancellationKey: Optional<String>) =
                cancellationKey(cancellationKey.getOrNull())

            /**
             * Sets [Builder.cancellationKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cancellationKey] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cancellationKey(cancellationKey: JsonField<String>) = apply {
                this.cancellationKey = cancellationKey
            }

            /** The ID of the schedule that triggered the workflow. */
            fun scheduleId(scheduleId: String?) = scheduleId(JsonField.ofNullable(scheduleId))

            /** Alias for calling [Builder.scheduleId] with `scheduleId.orElse(null)`. */
            fun scheduleId(scheduleId: Optional<String>) = scheduleId(scheduleId.getOrNull())

            /**
             * Sets [Builder.scheduleId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scheduleId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun scheduleId(scheduleId: JsonField<String>) = apply { this.scheduleId = scheduleId }

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
             * Returns an immutable instance of [TriggerSource].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .type()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): TriggerSource =
                TriggerSource(
                    checkRequired("type", type),
                    audienceKey,
                    cancellationKey,
                    scheduleId,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): TriggerSource = apply {
            if (validated) {
                return@apply
            }

            type().validate()
            audienceKey()
            cancellationKey()
            scheduleId()
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
            (type.asKnown().getOrNull()?.validity() ?: 0) +
                (if (audienceKey.asKnown().isPresent) 1 else 0) +
                (if (cancellationKey.asKnown().isPresent) 1 else 0) +
                (if (scheduleId.asKnown().isPresent) 1 else 0)

        /**
         * The type of trigger source. One of `api`, `audience`, `schedule`, `broadcast`,
         * `workflow_step`, `integration`, or `rehearsal`.
         */
        class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val API = of("api")

                @JvmField val AUDIENCE = of("audience")

                @JvmField val SCHEDULE = of("schedule")

                @JvmField val BROADCAST = of("broadcast")

                @JvmField val WORKFLOW_STEP = of("workflow_step")

                @JvmField val INTEGRATION = of("integration")

                @JvmField val REHEARSAL = of("rehearsal")

                @JvmStatic fun of(value: String) = Type(JsonField.of(value))
            }

            /** An enum containing [Type]'s known values. */
            enum class Known {
                API,
                AUDIENCE,
                SCHEDULE,
                BROADCAST,
                WORKFLOW_STEP,
                INTEGRATION,
                REHEARSAL,
            }

            /**
             * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Type] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                API,
                AUDIENCE,
                SCHEDULE,
                BROADCAST,
                WORKFLOW_STEP,
                INTEGRATION,
                REHEARSAL,
                /** An enum member indicating that [Type] was instantiated with an unknown value. */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    API -> Value.API
                    AUDIENCE -> Value.AUDIENCE
                    SCHEDULE -> Value.SCHEDULE
                    BROADCAST -> Value.BROADCAST
                    WORKFLOW_STEP -> Value.WORKFLOW_STEP
                    INTEGRATION -> Value.INTEGRATION
                    REHEARSAL -> Value.REHEARSAL
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws KnockInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    API -> Known.API
                    AUDIENCE -> Known.AUDIENCE
                    SCHEDULE -> Known.SCHEDULE
                    BROADCAST -> Known.BROADCAST
                    WORKFLOW_STEP -> Known.WORKFLOW_STEP
                    INTEGRATION -> Known.INTEGRATION
                    REHEARSAL -> Known.REHEARSAL
                    else -> throw KnockInvalidDataException("Unknown Type: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws KnockInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    KnockInvalidDataException("Value is not a String")
                }

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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is TriggerSource && type == other.type && audienceKey == other.audienceKey && cancellationKey == other.cancellationKey && scheduleId == other.scheduleId && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(type, audienceKey, cancellationKey, scheduleId, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TriggerSource{type=$type, audienceKey=$audienceKey, cancellationKey=$cancellationKey, scheduleId=$scheduleId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is WorkflowRecipientRun && id == other.id && _typename == other._typename && insertedAt == other.insertedAt && recipient == other.recipient && status == other.status && triggerSource == other.triggerSource && updatedAt == other.updatedAt && workflow == other.workflow && workflowRunId == other.workflowRunId && actor == other.actor && errorCount == other.errorCount && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, insertedAt, recipient, status, triggerSource, updatedAt, workflow, workflowRunId, actor, errorCount, tenant, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WorkflowRecipientRun{id=$id, _typename=$_typename, insertedAt=$insertedAt, recipient=$recipient, status=$status, triggerSource=$triggerSource, updatedAt=$updatedAt, workflow=$workflow, workflowRunId=$workflowRunId, actor=$actor, errorCount=$errorCount, tenant=$tenant, additionalProperties=$additionalProperties}"
}
