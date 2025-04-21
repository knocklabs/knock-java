// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

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
import app.knock.api.models.tenants.InlineTenantRequest
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
 * Updates one or more existing schedules with new timing, data, or other properties. All specified
 * schedule IDs will be updated with the same values.
 */
class ScheduleUpdateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * A list of schedule IDs.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun scheduleIds(): List<String> = body.scheduleIds()

    /**
     * Specifies a recipient in a request. This can either be a user identifier (string), an inline
     * user request (object), or an inline object request, which is determined by the presence of a
     * `collection` property.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun actor(): Optional<Actor> = body.actor()

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
     * The repeat rule for the schedule.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun repeats(): Optional<List<ScheduleRepeatRule>> = body.repeats()

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
     * Returns the raw JSON value of [scheduleIds].
     *
     * Unlike [scheduleIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _scheduleIds(): JsonField<List<String>> = body._scheduleIds()

    /**
     * Returns the raw JSON value of [actor].
     *
     * Unlike [actor], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _actor(): JsonField<Actor> = body._actor()

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
     * Returns the raw JSON value of [repeats].
     *
     * Unlike [repeats], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _repeats(): JsonField<List<ScheduleRepeatRule>> = body._repeats()

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
         * Returns a mutable builder for constructing an instance of [ScheduleUpdateParams].
         *
         * The following fields are required:
         * ```java
         * .scheduleIds()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ScheduleUpdateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(scheduleUpdateParams: ScheduleUpdateParams) = apply {
            body = scheduleUpdateParams.body.toBuilder()
            additionalHeaders = scheduleUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = scheduleUpdateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [scheduleIds]
         * - [actor]
         * - [data]
         * - [endingAt]
         * - [repeats]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** A list of schedule IDs. */
        fun scheduleIds(scheduleIds: List<String>) = apply { body.scheduleIds(scheduleIds) }

        /**
         * Sets [Builder.scheduleIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.scheduleIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun scheduleIds(scheduleIds: JsonField<List<String>>) = apply {
            body.scheduleIds(scheduleIds)
        }

        /**
         * Adds a single [String] to [scheduleIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addScheduleId(scheduleId: String) = apply { body.addScheduleId(scheduleId) }

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        fun actor(actor: Actor?) = apply { body.actor(actor) }

        /** Alias for calling [Builder.actor] with `actor.orElse(null)`. */
        fun actor(actor: Optional<Actor>) = actor(actor.getOrNull())

        /**
         * Sets [Builder.actor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.actor] with a well-typed [Actor] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun actor(actor: JsonField<Actor>) = apply { body.actor(actor) }

        /** Alias for calling [actor] with `Actor.ofUserRecipient(userRecipient)`. */
        fun actor(userRecipient: String) = apply { body.actor(userRecipient) }

        /**
         * Alias for calling [actor] with
         * `Actor.ofInlineIdentifyUserRequest(inlineIdentifyUserRequest)`.
         */
        fun actor(inlineIdentifyUserRequest: InlineIdentifyUserRequest) = apply {
            body.actor(inlineIdentifyUserRequest)
        }

        /** Alias for calling [actor] with `Actor.ofInlineObjectRequest(inlineObjectRequest)`. */
        fun actor(inlineObjectRequest: InlineObjectRequest) = apply {
            body.actor(inlineObjectRequest)
        }

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
         * Returns an immutable instance of [ScheduleUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .scheduleIds()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ScheduleUpdateParams =
            ScheduleUpdateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** A request to update a schedule. */
    class Body
    private constructor(
        private val scheduleIds: JsonField<List<String>>,
        private val actor: JsonField<Actor>,
        private val data: JsonField<Data>,
        private val endingAt: JsonField<OffsetDateTime>,
        private val repeats: JsonField<List<ScheduleRepeatRule>>,
        private val scheduledAt: JsonField<OffsetDateTime>,
        private val tenant: JsonField<InlineTenantRequest>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("schedule_ids")
            @ExcludeMissing
            scheduleIds: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("actor") @ExcludeMissing actor: JsonField<Actor> = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
            @JsonProperty("ending_at")
            @ExcludeMissing
            endingAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("repeats")
            @ExcludeMissing
            repeats: JsonField<List<ScheduleRepeatRule>> = JsonMissing.of(),
            @JsonProperty("scheduled_at")
            @ExcludeMissing
            scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("tenant")
            @ExcludeMissing
            tenant: JsonField<InlineTenantRequest> = JsonMissing.of(),
        ) : this(scheduleIds, actor, data, endingAt, repeats, scheduledAt, tenant, mutableMapOf())

        /**
         * A list of schedule IDs.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun scheduleIds(): List<String> = scheduleIds.getRequired("schedule_ids")

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun actor(): Optional<Actor> = actor.getOptional("actor")

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
         * Returns the raw JSON value of [scheduleIds].
         *
         * Unlike [scheduleIds], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("schedule_ids")
        @ExcludeMissing
        fun _scheduleIds(): JsonField<List<String>> = scheduleIds

        /**
         * Returns the raw JSON value of [actor].
         *
         * Unlike [actor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<Actor> = actor

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .scheduleIds()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var scheduleIds: JsonField<MutableList<String>>? = null
            private var actor: JsonField<Actor> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var endingAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var repeats: JsonField<MutableList<ScheduleRepeatRule>>? = null
            private var scheduledAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var tenant: JsonField<InlineTenantRequest> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                scheduleIds = body.scheduleIds.map { it.toMutableList() }
                actor = body.actor
                data = body.data
                endingAt = body.endingAt
                repeats = body.repeats.map { it.toMutableList() }
                scheduledAt = body.scheduledAt
                tenant = body.tenant
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** A list of schedule IDs. */
            fun scheduleIds(scheduleIds: List<String>) = scheduleIds(JsonField.of(scheduleIds))

            /**
             * Sets [Builder.scheduleIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.scheduleIds] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun scheduleIds(scheduleIds: JsonField<List<String>>) = apply {
                this.scheduleIds = scheduleIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [scheduleIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addScheduleId(scheduleId: String) = apply {
                scheduleIds =
                    (scheduleIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("scheduleIds", it).add(scheduleId)
                    }
            }

            /**
             * Specifies a recipient in a request. This can either be a user identifier (string), an
             * inline user request (object), or an inline object request, which is determined by the
             * presence of a `collection` property.
             */
            fun actor(actor: Actor?) = actor(JsonField.ofNullable(actor))

            /** Alias for calling [Builder.actor] with `actor.orElse(null)`. */
            fun actor(actor: Optional<Actor>) = actor(actor.getOrNull())

            /**
             * Sets [Builder.actor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.actor] with a well-typed [Actor] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun actor(actor: JsonField<Actor>) = apply { this.actor = actor }

            /** Alias for calling [actor] with `Actor.ofUserRecipient(userRecipient)`. */
            fun actor(userRecipient: String) = actor(Actor.ofUserRecipient(userRecipient))

            /**
             * Alias for calling [actor] with
             * `Actor.ofInlineIdentifyUserRequest(inlineIdentifyUserRequest)`.
             */
            fun actor(inlineIdentifyUserRequest: InlineIdentifyUserRequest) =
                actor(Actor.ofInlineIdentifyUserRequest(inlineIdentifyUserRequest))

            /**
             * Alias for calling [actor] with `Actor.ofInlineObjectRequest(inlineObjectRequest)`.
             */
            fun actor(inlineObjectRequest: InlineObjectRequest) =
                actor(Actor.ofInlineObjectRequest(inlineObjectRequest))

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .scheduleIds()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("scheduleIds", scheduleIds).map { it.toImmutable() },
                    actor,
                    data,
                    endingAt,
                    (repeats ?: JsonMissing.of()).map { it.toImmutable() },
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

            scheduleIds()
            actor().ifPresent { it.validate() }
            data().ifPresent { it.validate() }
            endingAt()
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
            (scheduleIds.asKnown().getOrNull()?.size ?: 0) +
                (actor.asKnown().getOrNull()?.validity() ?: 0) +
                (data.asKnown().getOrNull()?.validity() ?: 0) +
                (if (endingAt.asKnown().isPresent) 1 else 0) +
                (repeats.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (scheduledAt.asKnown().isPresent) 1 else 0) +
                (tenant.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && scheduleIds == other.scheduleIds && actor == other.actor && data == other.data && endingAt == other.endingAt && repeats == other.repeats && scheduledAt == other.scheduledAt && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(scheduleIds, actor, data, endingAt, repeats, scheduledAt, tenant, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{scheduleIds=$scheduleIds, actor=$actor, data=$data, endingAt=$endingAt, repeats=$repeats, scheduledAt=$scheduledAt, tenant=$tenant, additionalProperties=$additionalProperties}"
    }

    /**
     * Specifies a recipient in a request. This can either be a user identifier (string), an inline
     * user request (object), or an inline object request, which is determined by the presence of a
     * `collection` property.
     */
    @JsonDeserialize(using = Actor.Deserializer::class)
    @JsonSerialize(using = Actor.Serializer::class)
    class Actor
    private constructor(
        private val userRecipient: String? = null,
        private val inlineIdentifyUserRequest: InlineIdentifyUserRequest? = null,
        private val inlineObjectRequest: InlineObjectRequest? = null,
        private val _json: JsonValue? = null,
    ) {

        /** The ID of the user. */
        fun userRecipient(): Optional<String> = Optional.ofNullable(userRecipient)

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert for the user you're supplying, replacing any properties specified.
         */
        fun inlineIdentifyUserRequest(): Optional<InlineIdentifyUserRequest> =
            Optional.ofNullable(inlineIdentifyUserRequest)

        /** A custom object entity which belongs to a collection. */
        fun inlineObjectRequest(): Optional<InlineObjectRequest> =
            Optional.ofNullable(inlineObjectRequest)

        fun isUserRecipient(): Boolean = userRecipient != null

        fun isInlineIdentifyUserRequest(): Boolean = inlineIdentifyUserRequest != null

        fun isInlineObjectRequest(): Boolean = inlineObjectRequest != null

        /** The ID of the user. */
        fun asUserRecipient(): String = userRecipient.getOrThrow("userRecipient")

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert for the user you're supplying, replacing any properties specified.
         */
        fun asInlineIdentifyUserRequest(): InlineIdentifyUserRequest =
            inlineIdentifyUserRequest.getOrThrow("inlineIdentifyUserRequest")

        /** A custom object entity which belongs to a collection. */
        fun asInlineObjectRequest(): InlineObjectRequest =
            inlineObjectRequest.getOrThrow("inlineObjectRequest")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                userRecipient != null -> visitor.visitUserRecipient(userRecipient)
                inlineIdentifyUserRequest != null ->
                    visitor.visitInlineIdentifyUserRequest(inlineIdentifyUserRequest)
                inlineObjectRequest != null -> visitor.visitInlineObjectRequest(inlineObjectRequest)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Actor = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitUserRecipient(userRecipient: String) {}

                    override fun visitInlineIdentifyUserRequest(
                        inlineIdentifyUserRequest: InlineIdentifyUserRequest
                    ) {
                        inlineIdentifyUserRequest.validate()
                    }

                    override fun visitInlineObjectRequest(
                        inlineObjectRequest: InlineObjectRequest
                    ) {
                        inlineObjectRequest.validate()
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
                    override fun visitUserRecipient(userRecipient: String) = 1

                    override fun visitInlineIdentifyUserRequest(
                        inlineIdentifyUserRequest: InlineIdentifyUserRequest
                    ) = inlineIdentifyUserRequest.validity()

                    override fun visitInlineObjectRequest(
                        inlineObjectRequest: InlineObjectRequest
                    ) = inlineObjectRequest.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Actor && userRecipient == other.userRecipient && inlineIdentifyUserRequest == other.inlineIdentifyUserRequest && inlineObjectRequest == other.inlineObjectRequest /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(userRecipient, inlineIdentifyUserRequest, inlineObjectRequest) /* spotless:on */

        override fun toString(): String =
            when {
                userRecipient != null -> "Actor{userRecipient=$userRecipient}"
                inlineIdentifyUserRequest != null ->
                    "Actor{inlineIdentifyUserRequest=$inlineIdentifyUserRequest}"
                inlineObjectRequest != null -> "Actor{inlineObjectRequest=$inlineObjectRequest}"
                _json != null -> "Actor{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Actor")
            }

        companion object {

            /** The ID of the user. */
            @JvmStatic
            fun ofUserRecipient(userRecipient: String) = Actor(userRecipient = userRecipient)

            /**
             * A set of parameters to inline-identify a user with. Inline identifying the user will
             * ensure that the user is available before the request is executed in Knock. It will
             * perform an upsert for the user you're supplying, replacing any properties specified.
             */
            @JvmStatic
            fun ofInlineIdentifyUserRequest(inlineIdentifyUserRequest: InlineIdentifyUserRequest) =
                Actor(inlineIdentifyUserRequest = inlineIdentifyUserRequest)

            /** A custom object entity which belongs to a collection. */
            @JvmStatic
            fun ofInlineObjectRequest(inlineObjectRequest: InlineObjectRequest) =
                Actor(inlineObjectRequest = inlineObjectRequest)
        }

        /** An interface that defines how to map each variant of [Actor] to a value of type [T]. */
        interface Visitor<out T> {

            /** The ID of the user. */
            fun visitUserRecipient(userRecipient: String): T

            /**
             * A set of parameters to inline-identify a user with. Inline identifying the user will
             * ensure that the user is available before the request is executed in Knock. It will
             * perform an upsert for the user you're supplying, replacing any properties specified.
             */
            fun visitInlineIdentifyUserRequest(
                inlineIdentifyUserRequest: InlineIdentifyUserRequest
            ): T

            /** A custom object entity which belongs to a collection. */
            fun visitInlineObjectRequest(inlineObjectRequest: InlineObjectRequest): T

            /**
             * Maps an unknown variant of [Actor] to a value of type [T].
             *
             * An instance of [Actor] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Actor: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Actor>(Actor::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Actor {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<InlineIdentifyUserRequest>())?.let {
                                Actor(inlineIdentifyUserRequest = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<InlineObjectRequest>())?.let {
                                Actor(inlineObjectRequest = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Actor(userRecipient = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from array).
                    0 -> Actor(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Actor>(Actor::class) {

            override fun serialize(
                value: Actor,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.userRecipient != null -> generator.writeObject(value.userRecipient)
                    value.inlineIdentifyUserRequest != null ->
                        generator.writeObject(value.inlineIdentifyUserRequest)
                    value.inlineObjectRequest != null ->
                        generator.writeObject(value.inlineObjectRequest)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Actor")
                }
            }
        }
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

        return /* spotless:off */ other is ScheduleUpdateParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ScheduleUpdateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
