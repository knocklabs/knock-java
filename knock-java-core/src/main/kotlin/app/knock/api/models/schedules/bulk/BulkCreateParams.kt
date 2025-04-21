// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules.bulk

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.allMaxBy
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.recipients.RecipientRequest
import app.knock.api.models.schedules.ScheduleRepeatRule
import app.knock.api.models.tenants.TenantRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
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

/**
 * Bulk creates up to 1,000 schedules at a time. This endpoint also handles
 * [inline identifications](/managing-recipients/identifying-recipients#inline-identifying-recipients)
 * for the `actor`, `recipient`, and `tenant` fields.
 */
class BulkCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * A list of schedules.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun schedules(): List<Schedule> = body.schedules()

    /**
     * Returns the raw JSON value of [schedules].
     *
     * Unlike [schedules], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _schedules(): JsonField<List<Schedule>> = body._schedules()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BulkCreateParams].
         *
         * The following fields are required:
         * ```java
         * .schedules()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BulkCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(bulkCreateParams: BulkCreateParams) = apply {
            body = bulkCreateParams.body.toBuilder()
            additionalHeaders = bulkCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = bulkCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [schedules]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** A list of schedules. */
        fun schedules(schedules: List<Schedule>) = apply { body.schedules(schedules) }

        /**
         * Sets [Builder.schedules] to an arbitrary JSON value.
         *
         * You should usually call [Builder.schedules] with a well-typed `List<Schedule>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun schedules(schedules: JsonField<List<Schedule>>) = apply { body.schedules(schedules) }

        /**
         * Adds a single [Schedule] to [schedules].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSchedule(schedule: Schedule) = apply { body.addSchedule(schedule) }

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
         * Returns an immutable instance of [BulkCreateParams].
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
        fun build(): BulkCreateParams =
            BulkCreateParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * A request to bulk create schedules. Accepts a list of schedules to create. Each schedule must
     * have a single recipient. The recipients do not have to be unique.
     */
    class Body
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
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .schedules()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var schedules: JsonField<MutableList<Schedule>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                schedules = body.schedules.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Body].
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
            fun build(): Body =
                Body(
                    checkRequired("schedules", schedules).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (schedules.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && schedules == other.schedules && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(schedules, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{schedules=$schedules, additionalProperties=$additionalProperties}"
    }

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
        private val tenant: JsonField<Tenant>,
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
            @JsonProperty("tenant") @ExcludeMissing tenant: JsonField<Tenant> = JsonMissing.of(),
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
         * The tenant to trigger the workflow for. Triggering with a tenant will use any
         * tenant-level overrides associated with the tenant object, and all messages produced from
         * workflow runs will be tagged with the tenant.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tenant(): Optional<Tenant> = tenant.getOptional("tenant")

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
        @JsonProperty("tenant") @ExcludeMissing fun _tenant(): JsonField<Tenant> = tenant

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
            private var tenant: JsonField<Tenant> = JsonMissing.of()
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

            /**
             * The tenant to trigger the workflow for. Triggering with a tenant will use any
             * tenant-level overrides associated with the tenant object, and all messages produced
             * from workflow runs will be tagged with the tenant.
             */
            fun tenant(tenant: Tenant?) = tenant(JsonField.ofNullable(tenant))

            /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
            fun tenant(tenant: Optional<Tenant>) = tenant(tenant.getOrNull())

            /**
             * Sets [Builder.tenant] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tenant] with a well-typed [Tenant] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tenant(tenant: JsonField<Tenant>) = apply { this.tenant = tenant }

            /** Alias for calling [tenant] with `Tenant.ofString(string)`. */
            fun tenant(string: String) = tenant(Tenant.ofString(string))

            /** Alias for calling [tenant] with `Tenant.ofRequest(request)`. */
            fun tenant(request: TenantRequest) = tenant(Tenant.ofRequest(request))

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

        /**
         * The tenant to trigger the workflow for. Triggering with a tenant will use any
         * tenant-level overrides associated with the tenant object, and all messages produced from
         * workflow runs will be tagged with the tenant.
         */
        @JsonDeserialize(using = Tenant.Deserializer::class)
        @JsonSerialize(using = Tenant.Serializer::class)
        class Tenant
        private constructor(
            private val string: String? = null,
            private val request: TenantRequest? = null,
            private val _json: JsonValue? = null,
        ) {

            /** The unique identifier for the tenant. */
            fun string(): Optional<String> = Optional.ofNullable(string)

            /**
             * A tenant to be set in the system. You can supply any additional properties on the
             * tenant object.
             */
            fun request(): Optional<TenantRequest> = Optional.ofNullable(request)

            fun isString(): Boolean = string != null

            fun isRequest(): Boolean = request != null

            /** The unique identifier for the tenant. */
            fun asString(): String = string.getOrThrow("string")

            /**
             * A tenant to be set in the system. You can supply any additional properties on the
             * tenant object.
             */
            fun asRequest(): TenantRequest = request.getOrThrow("request")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    string != null -> visitor.visitString(string)
                    request != null -> visitor.visitRequest(request)
                    else -> visitor.unknown(_json)
                }

            private var validated: Boolean = false

            fun validate(): Tenant = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitString(string: String) {}

                        override fun visitRequest(request: TenantRequest) {
                            request.validate()
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

                        override fun visitRequest(request: TenantRequest) = request.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Tenant && string == other.string && request == other.request /* spotless:on */
            }

            override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, request) /* spotless:on */

            override fun toString(): String =
                when {
                    string != null -> "Tenant{string=$string}"
                    request != null -> "Tenant{request=$request}"
                    _json != null -> "Tenant{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Tenant")
                }

            companion object {

                /** The unique identifier for the tenant. */
                @JvmStatic fun ofString(string: String) = Tenant(string = string)

                /**
                 * A tenant to be set in the system. You can supply any additional properties on the
                 * tenant object.
                 */
                @JvmStatic fun ofRequest(request: TenantRequest) = Tenant(request = request)
            }

            /**
             * An interface that defines how to map each variant of [Tenant] to a value of type [T].
             */
            interface Visitor<out T> {

                /** The unique identifier for the tenant. */
                fun visitString(string: String): T

                /**
                 * A tenant to be set in the system. You can supply any additional properties on the
                 * tenant object.
                 */
                fun visitRequest(request: TenantRequest): T

                /**
                 * Maps an unknown variant of [Tenant] to a value of type [T].
                 *
                 * An instance of [Tenant] can contain an unknown variant if it was deserialized
                 * from data that doesn't match any known variant. For example, if the SDK is on an
                 * older version than the API, then the API may respond with new variants that the
                 * SDK is unaware of.
                 *
                 * @throws KnockInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw KnockInvalidDataException("Unknown Tenant: $json")
                }
            }

            internal class Deserializer : BaseDeserializer<Tenant>(Tenant::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): Tenant {
                    val json = JsonValue.fromJsonNode(node)

                    val bestMatches =
                        sequenceOf(
                                tryDeserialize(node, jacksonTypeRef<TenantRequest>())?.let {
                                    Tenant(request = it, _json = json)
                                },
                                tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                    Tenant(string = it, _json = json)
                                },
                            )
                            .filterNotNull()
                            .allMaxBy { it.validity() }
                            .toList()
                    return when (bestMatches.size) {
                        // This can happen if what we're deserializing is completely incompatible
                        // with all the possible variants (e.g. deserializing from array).
                        0 -> Tenant(_json = json)
                        1 -> bestMatches.single()
                        // If there's more than one match with the highest validity, then use the
                        // first completely valid match, or simply the first match if none are
                        // completely valid.
                        else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                    }
                }
            }

            internal class Serializer : BaseSerializer<Tenant>(Tenant::class) {

                override fun serialize(
                    value: Tenant,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.string != null -> generator.writeObject(value.string)
                        value.request != null -> generator.writeObject(value.request)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid Tenant")
                    }
                }
            }
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

        return /* spotless:off */ other is BulkCreateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BulkCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
