// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.recipients.RecipientRequest
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
 * Creates one or more schedules for a workflow with the specified recipients, timing, and data.
 * Schedules can be one-time or recurring. This endpoint also handles
 * [inline identifications](/managing-recipients/identifying-recipients#inline-identifying-recipients)
 * for the `actor`, `recipient`, and `tenant` fields.
 */
class ScheduleCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * The recipients to trigger the workflow for. Can inline identify users, objects, or use a list
     * of user IDs. Limited to 1,000 recipients in a single trigger.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipients(): List<RecipientRequest> = body.recipients()

    /**
     * The repeat rule for the schedule.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun repeats(): List<ScheduleRepeatRule> = body.repeats()

    /**
     * The key of the workflow.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun workflow(): String = body.workflow()

    /**
     * An optional map of data to pass into the workflow execution.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<Data> = body.data()

    /**
     * The ending date and time for the schedule.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun endingAt(): Optional<OffsetDateTime> = body.endingAt()

    /**
     * The starting date and time for the schedule.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun scheduledAt(): Optional<OffsetDateTime> = body.scheduledAt()

    /**
     * An request to set a tenant inline.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tenant(): Optional<InlineTenantRequest> = body.tenant()

    /**
     * Returns the raw JSON value of [recipients].
     *
     * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _recipients(): JsonField<List<RecipientRequest>> = body._recipients()

    /**
     * Returns the raw JSON value of [repeats].
     *
     * Unlike [repeats], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _repeats(): JsonField<List<ScheduleRepeatRule>> = body._repeats()

    /**
     * Returns the raw JSON value of [workflow].
     *
     * Unlike [workflow], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _workflow(): JsonField<String> = body._workflow()

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _data(): JsonField<Data> = body._data()

    /**
     * Returns the raw JSON value of [endingAt].
     *
     * Unlike [endingAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _endingAt(): JsonField<OffsetDateTime> = body._endingAt()

    /**
     * Returns the raw JSON value of [scheduledAt].
     *
     * Unlike [scheduledAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _scheduledAt(): JsonField<OffsetDateTime> = body._scheduledAt()

    /**
     * Returns the raw JSON value of [tenant].
     *
     * Unlike [tenant], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tenant(): JsonField<InlineTenantRequest> = body._tenant()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ScheduleCreateParams].
         *
         * The following fields are required:
         * ```java
         * .recipients()
         * .repeats()
         * .workflow()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ScheduleCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(scheduleCreateParams: ScheduleCreateParams) = apply {
            body = scheduleCreateParams.body.toBuilder()
            additionalHeaders = scheduleCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = scheduleCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [recipients]
         * - [repeats]
         * - [workflow]
         * - [data]
         * - [endingAt]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * The recipients to trigger the workflow for. Can inline identify users, objects, or use a
         * list of user IDs. Limited to 1,000 recipients in a single trigger.
         */
        fun recipients(recipients: List<RecipientRequest>) = apply { body.recipients(recipients) }

        /**
         * Sets [Builder.recipients] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipients] with a well-typed `List<RecipientRequest>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun recipients(recipients: JsonField<List<RecipientRequest>>) = apply {
            body.recipients(recipients)
        }

        /**
         * Adds a single [RecipientRequest] to [recipients].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRecipient(recipient: RecipientRequest) = apply { body.addRecipient(recipient) }

        /**
         * Alias for calling [addRecipient] with `RecipientRequest.ofUserRecipient(userRecipient)`.
         */
        fun addRecipient(userRecipient: String) = apply { body.addRecipient(userRecipient) }

        /**
         * Alias for calling [addRecipient] with
         * `RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser)`.
         */
        fun addRecipient(inlineIdentifyUser: InlineIdentifyUserRequest) = apply {
            body.addRecipient(inlineIdentifyUser)
        }

        /**
         * Alias for calling [addRecipient] with `RecipientRequest.ofInlineObject(inlineObject)`.
         */
        fun addRecipient(inlineObject: InlineObjectRequest) = apply {
            body.addRecipient(inlineObject)
        }

        /** The repeat rule for the schedule. */
        fun repeats(repeats: List<ScheduleRepeatRule>) = apply { body.repeats(repeats) }

        /**
         * Sets [Builder.repeats] to an arbitrary JSON value.
         *
         * You should usually call [Builder.repeats] with a well-typed `List<ScheduleRepeatRule>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun repeats(repeats: JsonField<List<ScheduleRepeatRule>>) = apply { body.repeats(repeats) }

        /**
         * Adds a single [ScheduleRepeatRule] to [repeats].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRepeat(repeat: ScheduleRepeatRule) = apply { body.addRepeat(repeat) }

        /** The key of the workflow. */
        fun workflow(workflow: String) = apply { body.workflow(workflow) }

        /**
         * Sets [Builder.workflow] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workflow] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun workflow(workflow: JsonField<String>) = apply { body.workflow(workflow) }

        /** An optional map of data to pass into the workflow execution. */
        fun data(data: Data?) = apply { body.data(data) }

        /** Alias for calling [Builder.data] with `data.orElse(null)`. */
        fun data(data: Optional<Data>) = data(data.getOrNull())

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { body.data(data) }

        /** The ending date and time for the schedule. */
        fun endingAt(endingAt: OffsetDateTime?) = apply { body.endingAt(endingAt) }

        /** Alias for calling [Builder.endingAt] with `endingAt.orElse(null)`. */
        fun endingAt(endingAt: Optional<OffsetDateTime>) = endingAt(endingAt.getOrNull())

        /**
         * Sets [Builder.endingAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endingAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun endingAt(endingAt: JsonField<OffsetDateTime>) = apply { body.endingAt(endingAt) }

        /** The starting date and time for the schedule. */
        fun scheduledAt(scheduledAt: OffsetDateTime?) = apply { body.scheduledAt(scheduledAt) }

        /** Alias for calling [Builder.scheduledAt] with `scheduledAt.orElse(null)`. */
        fun scheduledAt(scheduledAt: Optional<OffsetDateTime>) =
            scheduledAt(scheduledAt.getOrNull())

        /**
         * Sets [Builder.scheduledAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scheduledAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun scheduledAt(scheduledAt: JsonField<OffsetDateTime>) = apply {
            body.scheduledAt(scheduledAt)
        }

        /** An request to set a tenant inline. */
        fun tenant(tenant: InlineTenantRequest?) = apply { body.tenant(tenant) }

        /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
        fun tenant(tenant: Optional<InlineTenantRequest>) = tenant(tenant.getOrNull())

        /**
         * Sets [Builder.tenant] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tenant] with a well-typed [InlineTenantRequest] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun tenant(tenant: JsonField<InlineTenantRequest>) = apply { body.tenant(tenant) }

        /** Alias for calling [tenant] with `InlineTenantRequest.ofString(string)`. */
        fun tenant(string: String) = apply { body.tenant(string) }

        /** Alias for calling [tenant] with `InlineTenantRequest.ofTenantRequest(tenantRequest)`. */
        fun tenant(tenantRequest: TenantRequest) = apply { body.tenant(tenantRequest) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [ScheduleCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .recipients()
         * .repeats()
         * .workflow()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ScheduleCreateParams =
            ScheduleCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** A request to create a schedule. */
    class Body
    private constructor(
        private val recipients: JsonField<List<RecipientRequest>>,
        private val repeats: JsonField<List<ScheduleRepeatRule>>,
        private val workflow: JsonField<String>,
        private val data: JsonField<Data>,
        private val endingAt: JsonField<OffsetDateTime>,
        private val scheduledAt: JsonField<OffsetDateTime>,
        private val tenant: JsonField<InlineTenantRequest>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("recipients")
            @ExcludeMissing
            recipients: JsonField<List<RecipientRequest>> = JsonMissing.of(),
            @JsonProperty("repeats")
            @ExcludeMissing
            repeats: JsonField<List<ScheduleRepeatRule>> = JsonMissing.of(),
            @JsonProperty("workflow")
            @ExcludeMissing
            workflow: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
            @JsonProperty("ending_at")
            @ExcludeMissing
            endingAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("scheduled_at")
            @ExcludeMissing
            scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("tenant")
            @ExcludeMissing
            tenant: JsonField<InlineTenantRequest> = JsonMissing.of(),
        ) : this(recipients, repeats, workflow, data, endingAt, scheduledAt, tenant, mutableMapOf())

        /**
         * The recipients to trigger the workflow for. Can inline identify users, objects, or use a
         * list of user IDs. Limited to 1,000 recipients in a single trigger.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun recipients(): List<RecipientRequest> = recipients.getRequired("recipients")

        /**
         * The repeat rule for the schedule.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun repeats(): List<ScheduleRepeatRule> = repeats.getRequired("repeats")

        /**
         * The key of the workflow.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun workflow(): String = workflow.getRequired("workflow")

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
         * Returns the raw JSON value of [recipients].
         *
         * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recipients")
        @ExcludeMissing
        fun _recipients(): JsonField<List<RecipientRequest>> = recipients

        /**
         * Returns the raw JSON value of [repeats].
         *
         * Unlike [repeats], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("repeats")
        @ExcludeMissing
        fun _repeats(): JsonField<List<ScheduleRepeatRule>> = repeats

        /**
         * Returns the raw JSON value of [workflow].
         *
         * Unlike [workflow], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("workflow") @ExcludeMissing fun _workflow(): JsonField<String> = workflow

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .recipients()
             * .repeats()
             * .workflow()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var recipients: JsonField<MutableList<RecipientRequest>>? = null
            private var repeats: JsonField<MutableList<ScheduleRepeatRule>>? = null
            private var workflow: JsonField<String>? = null
            private var data: JsonField<Data> = JsonMissing.of()
            private var endingAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var tenant: JsonField<InlineTenantRequest> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                recipients = body.recipients.map { it.toMutableList() }
                repeats = body.repeats.map { it.toMutableList() }
                workflow = body.workflow
                data = body.data
                endingAt = body.endingAt
                scheduledAt = body.scheduledAt
                tenant = body.tenant
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * The recipients to trigger the workflow for. Can inline identify users, objects, or
             * use a list of user IDs. Limited to 1,000 recipients in a single trigger.
             */
            fun recipients(recipients: List<RecipientRequest>) =
                recipients(JsonField.of(recipients))

            /**
             * Sets [Builder.recipients] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recipients] with a well-typed
             * `List<RecipientRequest>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun recipients(recipients: JsonField<List<RecipientRequest>>) = apply {
                this.recipients = recipients.map { it.toMutableList() }
            }

            /**
             * Adds a single [RecipientRequest] to [recipients].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRecipient(recipient: RecipientRequest) = apply {
                recipients =
                    (recipients ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recipients", it).add(recipient)
                    }
            }

            /**
             * Alias for calling [addRecipient] with
             * `RecipientRequest.ofUserRecipient(userRecipient)`.
             */
            fun addRecipient(userRecipient: String) =
                addRecipient(RecipientRequest.ofUserRecipient(userRecipient))

            /**
             * Alias for calling [addRecipient] with
             * `RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser)`.
             */
            fun addRecipient(inlineIdentifyUser: InlineIdentifyUserRequest) =
                addRecipient(RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser))

            /**
             * Alias for calling [addRecipient] with
             * `RecipientRequest.ofInlineObject(inlineObject)`.
             */
            fun addRecipient(inlineObject: InlineObjectRequest) =
                addRecipient(RecipientRequest.ofInlineObject(inlineObject))

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .recipients()
             * .repeats()
             * .workflow()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("recipients", recipients).map { it.toImmutable() },
                    checkRequired("repeats", repeats).map { it.toImmutable() },
                    checkRequired("workflow", workflow),
                    data,
                    endingAt,
                    scheduledAt,
                    tenant,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            recipients().forEach { it.validate() }
            repeats().forEach { it.validate() }
            workflow()
            data().ifPresent { it.validate() }
            endingAt()
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
            (recipients.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (repeats.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (workflow.asKnown().isPresent) 1 else 0) +
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                (if (endingAt.asKnown().isPresent) 1 else 0) +
                (if (scheduledAt.asKnown().isPresent) 1 else 0) +
                (tenant.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && recipients == other.recipients && repeats == other.repeats && workflow == other.workflow && data == other.data && endingAt == other.endingAt && scheduledAt == other.scheduledAt && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(recipients, repeats, workflow, data, endingAt, scheduledAt, tenant, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{recipients=$recipients, repeats=$repeats, workflow=$workflow, data=$data, endingAt=$endingAt, scheduledAt=$scheduledAt, tenant=$tenant, additionalProperties=$additionalProperties}"
    }

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

        return /* spotless:off */ other is ScheduleCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ScheduleCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
