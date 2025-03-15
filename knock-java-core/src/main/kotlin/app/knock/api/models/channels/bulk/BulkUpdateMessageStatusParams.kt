// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.channels.bulk

import app.knock.api.core.Enum
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.Params
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/**
 * Bulk update messages for a specific channel. The channel is specified by the `channel_id`
 * parameter. The action to perform is specified by the `action` parameter, where the action is a
 * status change action (e.g. `archive`, `unarchive`).
 */
class BulkUpdateMessageStatusParams
private constructor(
    private val channelId: String,
    private val action: Action,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun channelId(): String = channelId

    fun action(): Action = action

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun archived(): Optional<Archived> = body.archived()

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun deliveryStatus(): Optional<DeliveryStatus> = body.deliveryStatus()

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun engagementStatus(): Optional<EngagementStatus> = body.engagementStatus()

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun hasTenant(): Optional<Boolean> = body.hasTenant()

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun newerThan(): Optional<OffsetDateTime> = body.newerThan()

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun olderThan(): Optional<OffsetDateTime> = body.olderThan()

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun recipientIds(): Optional<List<String>> = body.recipientIds()

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tenants(): Optional<List<String>> = body.tenants()

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun triggerData(): Optional<String> = body.triggerData()

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun workflows(): Optional<List<String>> = body.workflows()

    /**
     * Returns the raw JSON value of [archived].
     *
     * Unlike [archived], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _archived(): JsonField<Archived> = body._archived()

    /**
     * Returns the raw JSON value of [deliveryStatus].
     *
     * Unlike [deliveryStatus], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _deliveryStatus(): JsonField<DeliveryStatus> = body._deliveryStatus()

    /**
     * Returns the raw JSON value of [engagementStatus].
     *
     * Unlike [engagementStatus], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _engagementStatus(): JsonField<EngagementStatus> = body._engagementStatus()

    /**
     * Returns the raw JSON value of [hasTenant].
     *
     * Unlike [hasTenant], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _hasTenant(): JsonField<Boolean> = body._hasTenant()

    /**
     * Returns the raw JSON value of [newerThan].
     *
     * Unlike [newerThan], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _newerThan(): JsonField<OffsetDateTime> = body._newerThan()

    /**
     * Returns the raw JSON value of [olderThan].
     *
     * Unlike [olderThan], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _olderThan(): JsonField<OffsetDateTime> = body._olderThan()

    /**
     * Returns the raw JSON value of [recipientIds].
     *
     * Unlike [recipientIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _recipientIds(): JsonField<List<String>> = body._recipientIds()

    /**
     * Returns the raw JSON value of [tenants].
     *
     * Unlike [tenants], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tenants(): JsonField<List<String>> = body._tenants()

    /**
     * Returns the raw JSON value of [triggerData].
     *
     * Unlike [triggerData], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _triggerData(): JsonField<String> = body._triggerData()

    /**
     * Returns the raw JSON value of [workflows].
     *
     * Unlike [workflows], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _workflows(): JsonField<List<String>> = body._workflows()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> channelId
            1 -> action.toString()
            else -> ""
        }
    }

    /** Request body for bulk updating messages for a specific channel */
    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("archived")
        @ExcludeMissing
        private val archived: JsonField<Archived> = JsonMissing.of(),
        @JsonProperty("delivery_status")
        @ExcludeMissing
        private val deliveryStatus: JsonField<DeliveryStatus> = JsonMissing.of(),
        @JsonProperty("engagement_status")
        @ExcludeMissing
        private val engagementStatus: JsonField<EngagementStatus> = JsonMissing.of(),
        @JsonProperty("has_tenant")
        @ExcludeMissing
        private val hasTenant: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("newer_than")
        @ExcludeMissing
        private val newerThan: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("older_than")
        @ExcludeMissing
        private val olderThan: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("recipient_ids")
        @ExcludeMissing
        private val recipientIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("tenants")
        @ExcludeMissing
        private val tenants: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("trigger_data")
        @ExcludeMissing
        private val triggerData: JsonField<String> = JsonMissing.of(),
        @JsonProperty("workflows")
        @ExcludeMissing
        private val workflows: JsonField<List<String>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun archived(): Optional<Archived> = Optional.ofNullable(archived.getNullable("archived"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun deliveryStatus(): Optional<DeliveryStatus> =
            Optional.ofNullable(deliveryStatus.getNullable("delivery_status"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun engagementStatus(): Optional<EngagementStatus> =
            Optional.ofNullable(engagementStatus.getNullable("engagement_status"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun hasTenant(): Optional<Boolean> =
            Optional.ofNullable(hasTenant.getNullable("has_tenant"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun newerThan(): Optional<OffsetDateTime> =
            Optional.ofNullable(newerThan.getNullable("newer_than"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun olderThan(): Optional<OffsetDateTime> =
            Optional.ofNullable(olderThan.getNullable("older_than"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun recipientIds(): Optional<List<String>> =
            Optional.ofNullable(recipientIds.getNullable("recipient_ids"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tenants(): Optional<List<String>> = Optional.ofNullable(tenants.getNullable("tenants"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun triggerData(): Optional<String> =
            Optional.ofNullable(triggerData.getNullable("trigger_data"))

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun workflows(): Optional<List<String>> =
            Optional.ofNullable(workflows.getNullable("workflows"))

        /**
         * Returns the raw JSON value of [archived].
         *
         * Unlike [archived], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("archived") @ExcludeMissing fun _archived(): JsonField<Archived> = archived

        /**
         * Returns the raw JSON value of [deliveryStatus].
         *
         * Unlike [deliveryStatus], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("delivery_status")
        @ExcludeMissing
        fun _deliveryStatus(): JsonField<DeliveryStatus> = deliveryStatus

        /**
         * Returns the raw JSON value of [engagementStatus].
         *
         * Unlike [engagementStatus], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("engagement_status")
        @ExcludeMissing
        fun _engagementStatus(): JsonField<EngagementStatus> = engagementStatus

        /**
         * Returns the raw JSON value of [hasTenant].
         *
         * Unlike [hasTenant], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("has_tenant") @ExcludeMissing fun _hasTenant(): JsonField<Boolean> = hasTenant

        /**
         * Returns the raw JSON value of [newerThan].
         *
         * Unlike [newerThan], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("newer_than")
        @ExcludeMissing
        fun _newerThan(): JsonField<OffsetDateTime> = newerThan

        /**
         * Returns the raw JSON value of [olderThan].
         *
         * Unlike [olderThan], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("older_than")
        @ExcludeMissing
        fun _olderThan(): JsonField<OffsetDateTime> = olderThan

        /**
         * Returns the raw JSON value of [recipientIds].
         *
         * Unlike [recipientIds], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("recipient_ids")
        @ExcludeMissing
        fun _recipientIds(): JsonField<List<String>> = recipientIds

        /**
         * Returns the raw JSON value of [tenants].
         *
         * Unlike [tenants], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tenants") @ExcludeMissing fun _tenants(): JsonField<List<String>> = tenants

        /**
         * Returns the raw JSON value of [triggerData].
         *
         * Unlike [triggerData], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("trigger_data")
        @ExcludeMissing
        fun _triggerData(): JsonField<String> = triggerData

        /**
         * Returns the raw JSON value of [workflows].
         *
         * Unlike [workflows], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("workflows")
        @ExcludeMissing
        fun _workflows(): JsonField<List<String>> = workflows

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            archived()
            deliveryStatus()
            engagementStatus()
            hasTenant()
            newerThan()
            olderThan()
            recipientIds()
            tenants()
            triggerData()
            workflows()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var archived: JsonField<Archived> = JsonMissing.of()
            private var deliveryStatus: JsonField<DeliveryStatus> = JsonMissing.of()
            private var engagementStatus: JsonField<EngagementStatus> = JsonMissing.of()
            private var hasTenant: JsonField<Boolean> = JsonMissing.of()
            private var newerThan: JsonField<OffsetDateTime> = JsonMissing.of()
            private var olderThan: JsonField<OffsetDateTime> = JsonMissing.of()
            private var recipientIds: JsonField<MutableList<String>>? = null
            private var tenants: JsonField<MutableList<String>>? = null
            private var triggerData: JsonField<String> = JsonMissing.of()
            private var workflows: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                archived = body.archived
                deliveryStatus = body.deliveryStatus
                engagementStatus = body.engagementStatus
                hasTenant = body.hasTenant
                newerThan = body.newerThan
                olderThan = body.olderThan
                recipientIds = body.recipientIds.map { it.toMutableList() }
                tenants = body.tenants.map { it.toMutableList() }
                triggerData = body.triggerData
                workflows = body.workflows.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun archived(archived: Archived) = archived(JsonField.of(archived))

            /**
             * Sets [Builder.archived] to an arbitrary JSON value.
             *
             * You should usually call [Builder.archived] with a well-typed [Archived] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun archived(archived: JsonField<Archived>) = apply { this.archived = archived }

            fun deliveryStatus(deliveryStatus: DeliveryStatus) =
                deliveryStatus(JsonField.of(deliveryStatus))

            /**
             * Sets [Builder.deliveryStatus] to an arbitrary JSON value.
             *
             * You should usually call [Builder.deliveryStatus] with a well-typed [DeliveryStatus]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun deliveryStatus(deliveryStatus: JsonField<DeliveryStatus>) = apply {
                this.deliveryStatus = deliveryStatus
            }

            fun engagementStatus(engagementStatus: EngagementStatus) =
                engagementStatus(JsonField.of(engagementStatus))

            /**
             * Sets [Builder.engagementStatus] to an arbitrary JSON value.
             *
             * You should usually call [Builder.engagementStatus] with a well-typed
             * [EngagementStatus] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun engagementStatus(engagementStatus: JsonField<EngagementStatus>) = apply {
                this.engagementStatus = engagementStatus
            }

            fun hasTenant(hasTenant: Boolean) = hasTenant(JsonField.of(hasTenant))

            /**
             * Sets [Builder.hasTenant] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasTenant] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasTenant(hasTenant: JsonField<Boolean>) = apply { this.hasTenant = hasTenant }

            fun newerThan(newerThan: OffsetDateTime) = newerThan(JsonField.of(newerThan))

            /**
             * Sets [Builder.newerThan] to an arbitrary JSON value.
             *
             * You should usually call [Builder.newerThan] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun newerThan(newerThan: JsonField<OffsetDateTime>) = apply {
                this.newerThan = newerThan
            }

            fun olderThan(olderThan: OffsetDateTime) = olderThan(JsonField.of(olderThan))

            /**
             * Sets [Builder.olderThan] to an arbitrary JSON value.
             *
             * You should usually call [Builder.olderThan] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun olderThan(olderThan: JsonField<OffsetDateTime>) = apply {
                this.olderThan = olderThan
            }

            fun recipientIds(recipientIds: List<String>) = recipientIds(JsonField.of(recipientIds))

            /**
             * Sets [Builder.recipientIds] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recipientIds] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun recipientIds(recipientIds: JsonField<List<String>>) = apply {
                this.recipientIds = recipientIds.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [recipientIds].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRecipientId(recipientId: String) = apply {
                recipientIds =
                    (recipientIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recipientIds", it).add(recipientId)
                    }
            }

            fun tenants(tenants: List<String>) = tenants(JsonField.of(tenants))

            /**
             * Sets [Builder.tenants] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tenants] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tenants(tenants: JsonField<List<String>>) = apply {
                this.tenants = tenants.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [tenants].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTenant(tenant: String) = apply {
                tenants =
                    (tenants ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tenants", it).add(tenant)
                    }
            }

            fun triggerData(triggerData: String) = triggerData(JsonField.of(triggerData))

            /**
             * Sets [Builder.triggerData] to an arbitrary JSON value.
             *
             * You should usually call [Builder.triggerData] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun triggerData(triggerData: JsonField<String>) = apply {
                this.triggerData = triggerData
            }

            fun workflows(workflows: List<String>) = workflows(JsonField.of(workflows))

            /**
             * Sets [Builder.workflows] to an arbitrary JSON value.
             *
             * You should usually call [Builder.workflows] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun workflows(workflows: JsonField<List<String>>) = apply {
                this.workflows = workflows.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [workflows].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addWorkflow(workflow: String) = apply {
                workflows =
                    (workflows ?: JsonField.of(mutableListOf())).also {
                        checkKnown("workflows", it).add(workflow)
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

            fun build(): Body =
                Body(
                    archived,
                    deliveryStatus,
                    engagementStatus,
                    hasTenant,
                    newerThan,
                    olderThan,
                    (recipientIds ?: JsonMissing.of()).map { it.toImmutable() },
                    (tenants ?: JsonMissing.of()).map { it.toImmutable() },
                    triggerData,
                    (workflows ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && archived == other.archived && deliveryStatus == other.deliveryStatus && engagementStatus == other.engagementStatus && hasTenant == other.hasTenant && newerThan == other.newerThan && olderThan == other.olderThan && recipientIds == other.recipientIds && tenants == other.tenants && triggerData == other.triggerData && workflows == other.workflows && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(archived, deliveryStatus, engagementStatus, hasTenant, newerThan, olderThan, recipientIds, tenants, triggerData, workflows, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{archived=$archived, deliveryStatus=$deliveryStatus, engagementStatus=$engagementStatus, hasTenant=$hasTenant, newerThan=$newerThan, olderThan=$olderThan, recipientIds=$recipientIds, tenants=$tenants, triggerData=$triggerData, workflows=$workflows, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [BulkUpdateMessageStatusParams].
         *
         * The following fields are required:
         * ```java
         * .channelId()
         * .action()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BulkUpdateMessageStatusParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var channelId: String? = null
        private var action: Action? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(bulkUpdateMessageStatusParams: BulkUpdateMessageStatusParams) = apply {
            channelId = bulkUpdateMessageStatusParams.channelId
            action = bulkUpdateMessageStatusParams.action
            body = bulkUpdateMessageStatusParams.body.toBuilder()
            additionalHeaders = bulkUpdateMessageStatusParams.additionalHeaders.toBuilder()
            additionalQueryParams = bulkUpdateMessageStatusParams.additionalQueryParams.toBuilder()
        }

        fun channelId(channelId: String) = apply { this.channelId = channelId }

        fun action(action: Action) = apply { this.action = action }

        fun archived(archived: Archived) = apply { body.archived(archived) }

        /**
         * Sets [Builder.archived] to an arbitrary JSON value.
         *
         * You should usually call [Builder.archived] with a well-typed [Archived] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun archived(archived: JsonField<Archived>) = apply { body.archived(archived) }

        fun deliveryStatus(deliveryStatus: DeliveryStatus) = apply {
            body.deliveryStatus(deliveryStatus)
        }

        /**
         * Sets [Builder.deliveryStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.deliveryStatus] with a well-typed [DeliveryStatus] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun deliveryStatus(deliveryStatus: JsonField<DeliveryStatus>) = apply {
            body.deliveryStatus(deliveryStatus)
        }

        fun engagementStatus(engagementStatus: EngagementStatus) = apply {
            body.engagementStatus(engagementStatus)
        }

        /**
         * Sets [Builder.engagementStatus] to an arbitrary JSON value.
         *
         * You should usually call [Builder.engagementStatus] with a well-typed [EngagementStatus]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun engagementStatus(engagementStatus: JsonField<EngagementStatus>) = apply {
            body.engagementStatus(engagementStatus)
        }

        fun hasTenant(hasTenant: Boolean) = apply { body.hasTenant(hasTenant) }

        /**
         * Sets [Builder.hasTenant] to an arbitrary JSON value.
         *
         * You should usually call [Builder.hasTenant] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun hasTenant(hasTenant: JsonField<Boolean>) = apply { body.hasTenant(hasTenant) }

        fun newerThan(newerThan: OffsetDateTime) = apply { body.newerThan(newerThan) }

        /**
         * Sets [Builder.newerThan] to an arbitrary JSON value.
         *
         * You should usually call [Builder.newerThan] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun newerThan(newerThan: JsonField<OffsetDateTime>) = apply { body.newerThan(newerThan) }

        fun olderThan(olderThan: OffsetDateTime) = apply { body.olderThan(olderThan) }

        /**
         * Sets [Builder.olderThan] to an arbitrary JSON value.
         *
         * You should usually call [Builder.olderThan] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun olderThan(olderThan: JsonField<OffsetDateTime>) = apply { body.olderThan(olderThan) }

        fun recipientIds(recipientIds: List<String>) = apply { body.recipientIds(recipientIds) }

        /**
         * Sets [Builder.recipientIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipientIds] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recipientIds(recipientIds: JsonField<List<String>>) = apply {
            body.recipientIds(recipientIds)
        }

        /**
         * Adds a single [String] to [recipientIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRecipientId(recipientId: String) = apply { body.addRecipientId(recipientId) }

        fun tenants(tenants: List<String>) = apply { body.tenants(tenants) }

        /**
         * Sets [Builder.tenants] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tenants] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun tenants(tenants: JsonField<List<String>>) = apply { body.tenants(tenants) }

        /**
         * Adds a single [String] to [tenants].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTenant(tenant: String) = apply { body.addTenant(tenant) }

        fun triggerData(triggerData: String) = apply { body.triggerData(triggerData) }

        /**
         * Sets [Builder.triggerData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.triggerData] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun triggerData(triggerData: JsonField<String>) = apply { body.triggerData(triggerData) }

        fun workflows(workflows: List<String>) = apply { body.workflows(workflows) }

        /**
         * Sets [Builder.workflows] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workflows] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun workflows(workflows: JsonField<List<String>>) = apply { body.workflows(workflows) }

        /**
         * Adds a single [String] to [workflows].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addWorkflow(workflow: String) = apply { body.addWorkflow(workflow) }

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

        fun build(): BulkUpdateMessageStatusParams =
            BulkUpdateMessageStatusParams(
                checkRequired("channelId", channelId),
                checkRequired("action", action),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    class Archived @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val EXCLUDE = of("exclude")

            @JvmField val INCLUDE = of("include")

            @JvmField val ONLY = of("only")

            @JvmStatic fun of(value: String) = Archived(JsonField.of(value))
        }

        /** An enum containing [Archived]'s known values. */
        enum class Known {
            EXCLUDE,
            INCLUDE,
            ONLY,
        }

        /**
         * An enum containing [Archived]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Archived] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            EXCLUDE,
            INCLUDE,
            ONLY,
            /** An enum member indicating that [Archived] was instantiated with an unknown value. */
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
                EXCLUDE -> Value.EXCLUDE
                INCLUDE -> Value.INCLUDE
                ONLY -> Value.ONLY
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
                EXCLUDE -> Known.EXCLUDE
                INCLUDE -> Known.INCLUDE
                ONLY -> Known.ONLY
                else -> throw KnockInvalidDataException("Unknown Archived: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Archived && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class DeliveryStatus @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val SENT = of("sent")

            @JvmField val DELIVERED = of("delivered")

            @JvmField val DELIVERY_ATTEMPTED = of("delivery_attempted")

            @JvmField val UNDELIVERED = of("undelivered")

            @JvmField val NOT_SENT = of("not_sent")

            @JvmField val BOUNCED = of("bounced")

            @JvmStatic fun of(value: String) = DeliveryStatus(JsonField.of(value))
        }

        /** An enum containing [DeliveryStatus]'s known values. */
        enum class Known {
            QUEUED,
            SENT,
            DELIVERED,
            DELIVERY_ATTEMPTED,
            UNDELIVERED,
            NOT_SENT,
            BOUNCED,
        }

        /**
         * An enum containing [DeliveryStatus]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [DeliveryStatus] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            QUEUED,
            SENT,
            DELIVERED,
            DELIVERY_ATTEMPTED,
            UNDELIVERED,
            NOT_SENT,
            BOUNCED,
            /**
             * An enum member indicating that [DeliveryStatus] was instantiated with an unknown
             * value.
             */
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
                SENT -> Value.SENT
                DELIVERED -> Value.DELIVERED
                DELIVERY_ATTEMPTED -> Value.DELIVERY_ATTEMPTED
                UNDELIVERED -> Value.UNDELIVERED
                NOT_SENT -> Value.NOT_SENT
                BOUNCED -> Value.BOUNCED
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
                SENT -> Known.SENT
                DELIVERED -> Known.DELIVERED
                DELIVERY_ATTEMPTED -> Known.DELIVERY_ATTEMPTED
                UNDELIVERED -> Known.UNDELIVERED
                NOT_SENT -> Known.NOT_SENT
                BOUNCED -> Known.BOUNCED
                else -> throw KnockInvalidDataException("Unknown DeliveryStatus: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is DeliveryStatus && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class EngagementStatus @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val SEEN = of("seen")

            @JvmField val UNSEEN = of("unseen")

            @JvmField val READ = of("read")

            @JvmField val UNREAD = of("unread")

            @JvmField val ARCHIVED = of("archived")

            @JvmField val UNARCHIVED = of("unarchived")

            @JvmField val LINK_CLICKED = of("link_clicked")

            @JvmField val INTERACTED = of("interacted")

            @JvmStatic fun of(value: String) = EngagementStatus(JsonField.of(value))
        }

        /** An enum containing [EngagementStatus]'s known values. */
        enum class Known {
            SEEN,
            UNSEEN,
            READ,
            UNREAD,
            ARCHIVED,
            UNARCHIVED,
            LINK_CLICKED,
            INTERACTED,
        }

        /**
         * An enum containing [EngagementStatus]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [EngagementStatus] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SEEN,
            UNSEEN,
            READ,
            UNREAD,
            ARCHIVED,
            UNARCHIVED,
            LINK_CLICKED,
            INTERACTED,
            /**
             * An enum member indicating that [EngagementStatus] was instantiated with an unknown
             * value.
             */
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
                SEEN -> Value.SEEN
                UNSEEN -> Value.UNSEEN
                READ -> Value.READ
                UNREAD -> Value.UNREAD
                ARCHIVED -> Value.ARCHIVED
                UNARCHIVED -> Value.UNARCHIVED
                LINK_CLICKED -> Value.LINK_CLICKED
                INTERACTED -> Value.INTERACTED
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
                SEEN -> Known.SEEN
                UNSEEN -> Known.UNSEEN
                READ -> Known.READ
                UNREAD -> Known.UNREAD
                ARCHIVED -> Known.ARCHIVED
                UNARCHIVED -> Known.UNARCHIVED
                LINK_CLICKED -> Known.LINK_CLICKED
                INTERACTED -> Known.INTERACTED
                else -> throw KnockInvalidDataException("Unknown EngagementStatus: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is EngagementStatus && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class Action @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val SEEN = of("seen")

            @JvmField val UNSEEN = of("unseen")

            @JvmField val READ = of("read")

            @JvmField val UNREAD = of("unread")

            @JvmField val ARCHIVED = of("archived")

            @JvmField val UNARCHIVED = of("unarchived")

            @JvmField val INTERACTED = of("interacted")

            @JvmField val ARCHIVE = of("archive")

            @JvmField val UNARCHIVE = of("unarchive")

            @JvmField val DELETE = of("delete")

            @JvmStatic fun of(value: String) = Action(JsonField.of(value))
        }

        /** An enum containing [Action]'s known values. */
        enum class Known {
            SEEN,
            UNSEEN,
            READ,
            UNREAD,
            ARCHIVED,
            UNARCHIVED,
            INTERACTED,
            ARCHIVE,
            UNARCHIVE,
            DELETE,
        }

        /**
         * An enum containing [Action]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Action] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            SEEN,
            UNSEEN,
            READ,
            UNREAD,
            ARCHIVED,
            UNARCHIVED,
            INTERACTED,
            ARCHIVE,
            UNARCHIVE,
            DELETE,
            /** An enum member indicating that [Action] was instantiated with an unknown value. */
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
                SEEN -> Value.SEEN
                UNSEEN -> Value.UNSEEN
                READ -> Value.READ
                UNREAD -> Value.UNREAD
                ARCHIVED -> Value.ARCHIVED
                UNARCHIVED -> Value.UNARCHIVED
                INTERACTED -> Value.INTERACTED
                ARCHIVE -> Value.ARCHIVE
                UNARCHIVE -> Value.UNARCHIVE
                DELETE -> Value.DELETE
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
                SEEN -> Known.SEEN
                UNSEEN -> Known.UNSEEN
                READ -> Known.READ
                UNREAD -> Known.UNREAD
                ARCHIVED -> Known.ARCHIVED
                UNARCHIVED -> Known.UNARCHIVED
                INTERACTED -> Known.INTERACTED
                ARCHIVE -> Known.ARCHIVE
                UNARCHIVE -> Known.UNARCHIVE
                DELETE -> Known.DELETE
                else -> throw KnockInvalidDataException("Unknown Action: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Action && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BulkUpdateMessageStatusParams && channelId == other.channelId && action == other.action && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(channelId, action, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BulkUpdateMessageStatusParams{channelId=$channelId, action=$action, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
