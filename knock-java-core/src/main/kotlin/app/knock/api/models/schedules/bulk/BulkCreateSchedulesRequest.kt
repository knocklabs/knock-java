// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules.bulk

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.recipients.RecipientRequest
import app.knock.api.models.schedules.ScheduleRepeatRule
import app.knock.api.models.tenants.InlineTenantRequest
import app.knock.api.models.tenants.TenantRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
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
 * MERYL A request to bulk create schedules. Accepts a list of schedules to create. Each schedule
 * must have a single recipient. The recipients do not have to be unique.
 */
class BulkCreateSchedulesRequest
private constructor(
    private val schedules: JsonField<List<Schedule>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("schedules")
        @ExcludeMissing
        schedules: JsonField<List<Schedule>> = JsonMissing.of()
    ) : this(schedules, mutableMapOf())

    /**
     * A list of schedules.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun schedules(): List<Schedule> = schedules.getRequired("schedules")

    /**
     * Returns the raw JSON value of [schedules].
     *
     * Unlike [schedules], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("schedules")
    @ExcludeMissing
    fun _schedules(): JsonField<List<Schedule>> = schedules

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
         * Returns a mutable builder for constructing an instance of [BulkCreateSchedulesRequest].
         *
         * The following fields are required:
         * ```java
         * .schedules()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BulkCreateSchedulesRequest]. */
    class Builder internal constructor() {

        private var schedules: JsonField<MutableList<Schedule>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(bulkCreateSchedulesRequest: BulkCreateSchedulesRequest) = apply {
            schedules = bulkCreateSchedulesRequest.schedules.map { it.toMutableList() }
            additionalProperties = bulkCreateSchedulesRequest.additionalProperties.toMutableMap()
        }

        /** A list of schedules. */
        fun schedules(schedules: List<Schedule>) = schedules(JsonField.of(schedules))

        /**
         * Sets [Builder.schedules] to an arbitrary JSON value.
         *
         * You should usually call [Builder.schedules] with a well-typed `List<Schedule>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun schedules(schedules: JsonField<List<Schedule>>) = apply {
            this.schedules = schedules.map { it.toMutableList() }
        }

        /**
         * Adds a single [Schedule] to [schedules].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSchedule(schedule: Schedule) = apply {
            schedules =
                (schedules ?: JsonField.of(mutableListOf())).also {
                    checkKnown("schedules", it).add(schedule)
                }
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
         * Returns an immutable instance of [BulkCreateSchedulesRequest].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .schedules()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BulkCreateSchedulesRequest =
            BulkCreateSchedulesRequest(
                checkRequired("schedules", schedules).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BulkCreateSchedulesRequest = apply {
        if (validated) {
            return@apply
        }

        schedules().forEach { it.validate() }
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
        (schedules.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** A schedule represents a recurring workflow execution. */
    class Schedule
    private constructor(
        private val workflow: JsonField<String>,
        private val actor: JsonField<RecipientRequest>,
        private val data: JsonField<Data>,
        private val endingAt: JsonField<OffsetDateTime>,
        private val recipient: JsonField<RecipientRequest>,
        private val repeats: JsonField<List<ScheduleRepeatRule>>,
        private val scheduledAt: JsonField<OffsetDateTime>,
        private val tenant: JsonField<InlineTenantRequest>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("workflow")
            @ExcludeMissing
            workflow: JsonField<String> = JsonMissing.of(),
            @JsonProperty("actor")
            @ExcludeMissing
            actor: JsonField<RecipientRequest> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
            @JsonProperty("ending_at")
            @ExcludeMissing
            endingAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("recipient")
            @ExcludeMissing
            recipient: JsonField<RecipientRequest> = JsonMissing.of(),
            @JsonProperty("repeats")
            @ExcludeMissing
            repeats: JsonField<List<ScheduleRepeatRule>> = JsonMissing.of(),
            @JsonProperty("scheduled_at")
            @ExcludeMissing
            scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("tenant")
            @ExcludeMissing
            tenant: JsonField<InlineTenantRequest> = JsonMissing.of(),
        ) : this(
            workflow,
            actor,
            data,
            endingAt,
            recipient,
            repeats,
            scheduledAt,
            tenant,
            mutableMapOf(),
        )

        /**
         * The key of the workflow.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun workflow(): String = workflow.getRequired("workflow")

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun actor(): Optional<RecipientRequest> = actor.getOptional("actor")

        /**
         * An optional map of data to pass into the workflow execution.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<Data> = data.getOptional("data")

        /**
         * The ending date and time for the schedule.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun endingAt(): Optional<OffsetDateTime> = endingAt.getOptional("ending_at")

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun recipient(): Optional<RecipientRequest> = recipient.getOptional("recipient")

        /**
         * The repeat rule for the schedule.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun repeats(): Optional<List<ScheduleRepeatRule>> = repeats.getOptional("repeats")

        /**
         * The starting date and time for the schedule.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun scheduledAt(): Optional<OffsetDateTime> = scheduledAt.getOptional("scheduled_at")

        /**
         * An request to set a tenant inline.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tenant(): Optional<InlineTenantRequest> = tenant.getOptional("tenant")

        /**
         * Returns the raw JSON value of [workflow].
         *
         * Unlike [workflow], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("workflow") @ExcludeMissing fun _workflow(): JsonField<String> = workflow

        /**
         * Returns the raw JSON value of [actor].
         *
         * Unlike [actor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<RecipientRequest> = actor

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

        /**
         * Returns the raw JSON value of [endingAt].
         *
         * Unlike [endingAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("ending_at")
        @ExcludeMissing
        fun _endingAt(): JsonField<OffsetDateTime> = endingAt

        /**
         * Returns the raw JSON value of [recipient].
         *
         * Unlike [recipient], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recipient")
        @ExcludeMissing
        fun _recipient(): JsonField<RecipientRequest> = recipient

        /**
         * Returns the raw JSON value of [repeats].
         *
         * Unlike [repeats], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("repeats")
        @ExcludeMissing
        fun _repeats(): JsonField<List<ScheduleRepeatRule>> = repeats

        /**
         * Returns the raw JSON value of [scheduledAt].
         *
         * Unlike [scheduledAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("scheduled_at")
        @ExcludeMissing
        fun _scheduledAt(): JsonField<OffsetDateTime> = scheduledAt

        /**
         * Returns the raw JSON value of [tenant].
         *
         * Unlike [tenant], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tenant")
        @ExcludeMissing
        fun _tenant(): JsonField<InlineTenantRequest> = tenant

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
             * Returns a mutable builder for constructing an instance of [Schedule].
             *
             * The following fields are required:
             * ```java
             * .workflow()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Schedule]. */
        class Builder internal constructor() {

            private var workflow: JsonField<String>? = null
            private var actor: JsonField<RecipientRequest> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var endingAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var recipient: JsonField<RecipientRequest> = JsonMissing.of()
            private var repeats: JsonField<MutableList<ScheduleRepeatRule>>? = null
            private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var tenant: JsonField<InlineTenantRequest> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(schedule: Schedule) = apply {
                workflow = schedule.workflow
                actor = schedule.actor
                data = schedule.data
                endingAt = schedule.endingAt
                recipient = schedule.recipient
                repeats = schedule.repeats.map { it.toMutableList() }
                scheduledAt = schedule.scheduledAt
                tenant = schedule.tenant
                additionalProperties = schedule.additionalProperties.toMutableMap()
            }

            /** The key of the workflow. */
            fun workflow(workflow: String) = workflow(JsonField.of(workflow))

            /**
             * Sets [Builder.workflow] to an arbitrary JSON value.
             *
             * You should usually call [Builder.workflow] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun workflow(workflow: JsonField<String>) = apply { this.workflow = workflow }

            /**
             * Specifies a recipient in a request. This can either be a user identifier (string), an
             * inline user request (object), or an inline object request, which is determined by the
             * presence of a `collection` property.
             */
            fun actor(actor: RecipientRequest?) = actor(JsonField.ofNullable(actor))

            /** Alias for calling [Builder.actor] with `actor.orElse(null)`. */
            fun actor(actor: Optional<RecipientRequest>) = actor(actor.getOrNull())

            /**
             * Sets [Builder.actor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.actor] with a well-typed [RecipientRequest] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun actor(actor: JsonField<RecipientRequest>) = apply { this.actor = actor }

            /** Alias for calling [actor] with `RecipientRequest.ofUserRecipient(userRecipient)`. */
            fun actor(userRecipient: String) =
                actor(RecipientRequest.ofUserRecipient(userRecipient))

            /**
             * Alias for calling [actor] with
             * `RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser)`.
             */
            fun actor(inlineIdentifyUser: InlineIdentifyUserRequest) =
                actor(RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser))

            /** Alias for calling [actor] with `RecipientRequest.ofInlineObject(inlineObject)`. */
            fun actor(inlineObject: InlineObjectRequest) =
                actor(RecipientRequest.ofInlineObject(inlineObject))

            /** An optional map of data to pass into the workflow execution. */
            fun data(data: Data?) = data(JsonField.ofNullable(data))

            /** Alias for calling [Builder.data] with `data.orElse(null)`. */
            fun data(data: Optional<Data>) = data(data.getOrNull())

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

            /** The ending date and time for the schedule. */
            fun endingAt(endingAt: OffsetDateTime?) = endingAt(JsonField.ofNullable(endingAt))

            /** Alias for calling [Builder.endingAt] with `endingAt.orElse(null)`. */
            fun endingAt(endingAt: Optional<OffsetDateTime>) = endingAt(endingAt.getOrNull())

            /**
             * Sets [Builder.endingAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.endingAt] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun endingAt(endingAt: JsonField<OffsetDateTime>) = apply { this.endingAt = endingAt }

            /**
             * Specifies a recipient in a request. This can either be a user identifier (string), an
             * inline user request (object), or an inline object request, which is determined by the
             * presence of a `collection` property.
             */
            fun recipient(recipient: RecipientRequest) = recipient(JsonField.of(recipient))

            /**
             * Sets [Builder.recipient] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recipient] with a well-typed [RecipientRequest]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun recipient(recipient: JsonField<RecipientRequest>) = apply {
                this.recipient = recipient
            }

            /**
             * Alias for calling [recipient] with `RecipientRequest.ofUserRecipient(userRecipient)`.
             */
            fun recipient(userRecipient: String) =
                recipient(RecipientRequest.ofUserRecipient(userRecipient))

            /**
             * Alias for calling [recipient] with
             * `RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser)`.
             */
            fun recipient(inlineIdentifyUser: InlineIdentifyUserRequest) =
                recipient(RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser))

            /**
             * Alias for calling [recipient] with `RecipientRequest.ofInlineObject(inlineObject)`.
             */
            fun recipient(inlineObject: InlineObjectRequest) =
                recipient(RecipientRequest.ofInlineObject(inlineObject))

            /** The repeat rule for the schedule. */
            fun repeats(repeats: List<ScheduleRepeatRule>) = repeats(JsonField.of(repeats))

            /**
             * Sets [Builder.repeats] to an arbitrary JSON value.
             *
             * You should usually call [Builder.repeats] with a well-typed
             * `List<ScheduleRepeatRule>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
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

            /** The starting date and time for the schedule. */
            fun scheduledAt(scheduledAt: OffsetDateTime?) =
                scheduledAt(JsonField.ofNullable(scheduledAt))

            /** Alias for calling [Builder.scheduledAt] with `scheduledAt.orElse(null)`. */
            fun scheduledAt(scheduledAt: Optional<OffsetDateTime>) =
                scheduledAt(scheduledAt.getOrNull())

            /**
             * Sets [Builder.scheduledAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scheduledAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun scheduledAt(scheduledAt: JsonField<OffsetDateTime>) = apply {
                this.scheduledAt = scheduledAt
            }

            /** An request to set a tenant inline. */
            fun tenant(tenant: InlineTenantRequest?) = tenant(JsonField.ofNullable(tenant))

            /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
            fun tenant(tenant: Optional<InlineTenantRequest>) = tenant(tenant.getOrNull())

            /**
             * Sets [Builder.tenant] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tenant] with a well-typed [InlineTenantRequest]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun tenant(tenant: JsonField<InlineTenantRequest>) = apply { this.tenant = tenant }

            /** Alias for calling [tenant] with `InlineTenantRequest.ofString(string)`. */
            fun tenant(string: String) = tenant(InlineTenantRequest.ofString(string))

            /**
             * Alias for calling [tenant] with `InlineTenantRequest.ofTenantRequest(tenantRequest)`.
             */
            fun tenant(tenantRequest: TenantRequest) =
                tenant(InlineTenantRequest.ofTenantRequest(tenantRequest))

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
             * Returns an immutable instance of [Schedule].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .workflow()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Schedule =
                Schedule(
                    checkRequired("workflow", workflow),
                    actor,
                    data,
                    endingAt,
                    recipient,
                    (repeats ?: JsonMissing.of()).map { it.toImmutable() },
                    scheduledAt,
                    tenant,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Schedule = apply {
            if (validated) {
                return@apply
            }

            workflow()
            actor().ifPresent { it.validate() }
            data().ifPresent { it.validate() }
            endingAt()
            recipient().ifPresent { it.validate() }
            repeats().ifPresent { it.forEach { it.validate() } }
            scheduledAt()
            tenant().ifPresent { it.validate() }
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
            (if (workflow.asKnown().isPresent) 1 else 0) +
                (actor.asKnown().getOrNull()?.validity() ?: 0) +
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                (if (endingAt.asKnown().isPresent) 1 else 0) +
                (recipient.asKnown().getOrNull()?.validity() ?: 0) +
                (repeats.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (scheduledAt.asKnown().isPresent) 1 else 0) +
                (tenant.asKnown().getOrNull()?.validity() ?: 0)

        /** An optional map of data to pass into the workflow execution. */
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

            return /* spotless:off */ other is Schedule && workflow == other.workflow && actor == other.actor && data == other.data && endingAt == other.endingAt && recipient == other.recipient && repeats == other.repeats && scheduledAt == other.scheduledAt && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(workflow, actor, data, endingAt, recipient, repeats, scheduledAt, tenant, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Schedule{workflow=$workflow, actor=$actor, data=$data, endingAt=$endingAt, recipient=$recipient, repeats=$repeats, scheduledAt=$scheduledAt, tenant=$tenant, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BulkCreateSchedulesRequest && schedules == other.schedules && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(schedules, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BulkCreateSchedulesRequest{schedules=$schedules, additionalProperties=$additionalProperties}"
}
