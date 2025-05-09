// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.Enum
import app.knock.api.core.JsonField
import app.knock.api.core.Params
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Returns a paginated list of messages for a specific object in the given collection. Allows
 * filtering by message status and provides various sorting options.
 */
class ObjectListMessagesParams
private constructor(
    private val collection: String?,
    private val id: String?,
    private val after: String?,
    private val before: String?,
    private val channelId: String?,
    private val engagementStatus: List<EngagementStatus>?,
    private val insertedAt: InsertedAt?,
    private val messageIds: List<String>?,
    private val pageSize: Long?,
    private val source: String?,
    private val status: List<Status>?,
    private val tenant: String?,
    private val triggerData: String?,
    private val workflowCategories: List<String>?,
    private val workflowRecipientRunId: String?,
    private val workflowRunId: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun collection(): Optional<String> = Optional.ofNullable(collection)

    fun id(): Optional<String> = Optional.ofNullable(id)

    /** The cursor to fetch entries after. */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** The cursor to fetch entries before. */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /** Limits the results to items with the corresponding channel ID. */
    fun channelId(): Optional<String> = Optional.ofNullable(channelId)

    /** Limits the results to messages with the given engagement status. */
    fun engagementStatus(): Optional<List<EngagementStatus>> = Optional.ofNullable(engagementStatus)

    fun insertedAt(): Optional<InsertedAt> = Optional.ofNullable(insertedAt)

    /**
     * Limits the results to only the message IDs given (max 50). Note: when using this option, the
     * results will be subject to any other filters applied to the query.
     */
    fun messageIds(): Optional<List<String>> = Optional.ofNullable(messageIds)

    /** The number of items per page. */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** Limits the results to messages triggered by the given workflow key. */
    fun source(): Optional<String> = Optional.ofNullable(source)

    /** Limits the results to messages with the given delivery status. */
    fun status(): Optional<List<Status>> = Optional.ofNullable(status)

    /** Limits the results to items with the corresponding tenant. */
    fun tenant(): Optional<String> = Optional.ofNullable(tenant)

    /**
     * Limits the results to only messages that were generated with the given data. See
     * [trigger data filtering](/api-reference/overview/trigger-data-filtering) for more
     * information.
     */
    fun triggerData(): Optional<String> = Optional.ofNullable(triggerData)

    /** Limits the results to messages related to any of the provided categories. */
    fun workflowCategories(): Optional<List<String>> = Optional.ofNullable(workflowCategories)

    /** Limits the results to messages for a specific recipient's workflow run. */
    fun workflowRecipientRunId(): Optional<String> = Optional.ofNullable(workflowRecipientRunId)

    /**
     * Limits the results to messages associated with the top-level workflow run ID returned by the
     * workflow trigger request.
     */
    fun workflowRunId(): Optional<String> = Optional.ofNullable(workflowRunId)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): ObjectListMessagesParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [ObjectListMessagesParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ObjectListMessagesParams]. */
    class Builder internal constructor() {

        private var collection: String? = null
        private var id: String? = null
        private var after: String? = null
        private var before: String? = null
        private var channelId: String? = null
        private var engagementStatus: MutableList<EngagementStatus>? = null
        private var insertedAt: InsertedAt? = null
        private var messageIds: MutableList<String>? = null
        private var pageSize: Long? = null
        private var source: String? = null
        private var status: MutableList<Status>? = null
        private var tenant: String? = null
        private var triggerData: String? = null
        private var workflowCategories: MutableList<String>? = null
        private var workflowRecipientRunId: String? = null
        private var workflowRunId: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(objectListMessagesParams: ObjectListMessagesParams) = apply {
            collection = objectListMessagesParams.collection
            id = objectListMessagesParams.id
            after = objectListMessagesParams.after
            before = objectListMessagesParams.before
            channelId = objectListMessagesParams.channelId
            engagementStatus = objectListMessagesParams.engagementStatus?.toMutableList()
            insertedAt = objectListMessagesParams.insertedAt
            messageIds = objectListMessagesParams.messageIds?.toMutableList()
            pageSize = objectListMessagesParams.pageSize
            source = objectListMessagesParams.source
            status = objectListMessagesParams.status?.toMutableList()
            tenant = objectListMessagesParams.tenant
            triggerData = objectListMessagesParams.triggerData
            workflowCategories = objectListMessagesParams.workflowCategories?.toMutableList()
            workflowRecipientRunId = objectListMessagesParams.workflowRecipientRunId
            workflowRunId = objectListMessagesParams.workflowRunId
            additionalHeaders = objectListMessagesParams.additionalHeaders.toBuilder()
            additionalQueryParams = objectListMessagesParams.additionalQueryParams.toBuilder()
        }

        fun collection(collection: String?) = apply { this.collection = collection }

        /** Alias for calling [Builder.collection] with `collection.orElse(null)`. */
        fun collection(collection: Optional<String>) = collection(collection.getOrNull())

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /** The cursor to fetch entries after. */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** The cursor to fetch entries before. */
        fun before(before: String?) = apply { this.before = before }

        /** Alias for calling [Builder.before] with `before.orElse(null)`. */
        fun before(before: Optional<String>) = before(before.getOrNull())

        /** Limits the results to items with the corresponding channel ID. */
        fun channelId(channelId: String?) = apply { this.channelId = channelId }

        /** Alias for calling [Builder.channelId] with `channelId.orElse(null)`. */
        fun channelId(channelId: Optional<String>) = channelId(channelId.getOrNull())

        /** Limits the results to messages with the given engagement status. */
        fun engagementStatus(engagementStatus: List<EngagementStatus>?) = apply {
            this.engagementStatus = engagementStatus?.toMutableList()
        }

        /** Alias for calling [Builder.engagementStatus] with `engagementStatus.orElse(null)`. */
        fun engagementStatus(engagementStatus: Optional<List<EngagementStatus>>) =
            engagementStatus(engagementStatus.getOrNull())

        /**
         * Adds a single [EngagementStatus] to [Builder.engagementStatus].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEngagementStatus(engagementStatus: EngagementStatus) = apply {
            this.engagementStatus =
                (this.engagementStatus ?: mutableListOf()).apply { add(engagementStatus) }
        }

        fun insertedAt(insertedAt: InsertedAt?) = apply { this.insertedAt = insertedAt }

        /** Alias for calling [Builder.insertedAt] with `insertedAt.orElse(null)`. */
        fun insertedAt(insertedAt: Optional<InsertedAt>) = insertedAt(insertedAt.getOrNull())

        /**
         * Limits the results to only the message IDs given (max 50). Note: when using this option,
         * the results will be subject to any other filters applied to the query.
         */
        fun messageIds(messageIds: List<String>?) = apply {
            this.messageIds = messageIds?.toMutableList()
        }

        /** Alias for calling [Builder.messageIds] with `messageIds.orElse(null)`. */
        fun messageIds(messageIds: Optional<List<String>>) = messageIds(messageIds.getOrNull())

        /**
         * Adds a single [String] to [messageIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMessageId(messageId: String) = apply {
            messageIds = (messageIds ?: mutableListOf()).apply { add(messageId) }
        }

        /** The number of items per page. */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /**
         * Alias for [Builder.pageSize].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** Alias for calling [Builder.pageSize] with `pageSize.orElse(null)`. */
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.getOrNull())

        /** Limits the results to messages triggered by the given workflow key. */
        fun source(source: String?) = apply { this.source = source }

        /** Alias for calling [Builder.source] with `source.orElse(null)`. */
        fun source(source: Optional<String>) = source(source.getOrNull())

        /** Limits the results to messages with the given delivery status. */
        fun status(status: List<Status>?) = apply { this.status = status?.toMutableList() }

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<List<Status>>) = status(status.getOrNull())

        /**
         * Adds a single [Status] to [Builder.status].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addStatus(status: Status) = apply {
            this.status = (this.status ?: mutableListOf()).apply { add(status) }
        }

        /** Limits the results to items with the corresponding tenant. */
        fun tenant(tenant: String?) = apply { this.tenant = tenant }

        /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        /**
         * Limits the results to only messages that were generated with the given data. See
         * [trigger data filtering](/api-reference/overview/trigger-data-filtering) for more
         * information.
         */
        fun triggerData(triggerData: String?) = apply { this.triggerData = triggerData }

        /** Alias for calling [Builder.triggerData] with `triggerData.orElse(null)`. */
        fun triggerData(triggerData: Optional<String>) = triggerData(triggerData.getOrNull())

        /** Limits the results to messages related to any of the provided categories. */
        fun workflowCategories(workflowCategories: List<String>?) = apply {
            this.workflowCategories = workflowCategories?.toMutableList()
        }

        /**
         * Alias for calling [Builder.workflowCategories] with `workflowCategories.orElse(null)`.
         */
        fun workflowCategories(workflowCategories: Optional<List<String>>) =
            workflowCategories(workflowCategories.getOrNull())

        /**
         * Adds a single [String] to [workflowCategories].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addWorkflowCategory(workflowCategory: String) = apply {
            workflowCategories =
                (workflowCategories ?: mutableListOf()).apply { add(workflowCategory) }
        }

        /** Limits the results to messages for a specific recipient's workflow run. */
        fun workflowRecipientRunId(workflowRecipientRunId: String?) = apply {
            this.workflowRecipientRunId = workflowRecipientRunId
        }

        /**
         * Alias for calling [Builder.workflowRecipientRunId] with
         * `workflowRecipientRunId.orElse(null)`.
         */
        fun workflowRecipientRunId(workflowRecipientRunId: Optional<String>) =
            workflowRecipientRunId(workflowRecipientRunId.getOrNull())

        /**
         * Limits the results to messages associated with the top-level workflow run ID returned by
         * the workflow trigger request.
         */
        fun workflowRunId(workflowRunId: String?) = apply { this.workflowRunId = workflowRunId }

        /** Alias for calling [Builder.workflowRunId] with `workflowRunId.orElse(null)`. */
        fun workflowRunId(workflowRunId: Optional<String>) =
            workflowRunId(workflowRunId.getOrNull())

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
         * Returns an immutable instance of [ObjectListMessagesParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ObjectListMessagesParams =
            ObjectListMessagesParams(
                collection,
                id,
                after,
                before,
                channelId,
                engagementStatus?.toImmutable(),
                insertedAt,
                messageIds?.toImmutable(),
                pageSize,
                source,
                status?.toImmutable(),
                tenant,
                triggerData,
                workflowCategories?.toImmutable(),
                workflowRecipientRunId,
                workflowRunId,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> collection ?: ""
            1 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                before?.let { put("before", it) }
                channelId?.let { put("channel_id", it) }
                engagementStatus?.forEach { put("engagement_status[]", it.toString()) }
                insertedAt?.let {
                    it.gt().ifPresent { put("inserted_at[gt]", it) }
                    it.gte().ifPresent { put("inserted_at[gte]", it) }
                    it.lt().ifPresent { put("inserted_at[lt]", it) }
                    it.lte().ifPresent { put("inserted_at[lte]", it) }
                    it._additionalProperties().keys().forEach { key ->
                        it._additionalProperties().values(key).forEach { value ->
                            put("inserted_at[$key]", value)
                        }
                    }
                }
                messageIds?.forEach { put("message_ids[]", it) }
                pageSize?.let { put("page_size", it.toString()) }
                source?.let { put("source", it) }
                status?.forEach { put("status[]", it.toString()) }
                tenant?.let { put("tenant", it) }
                triggerData?.let { put("trigger_data", it) }
                workflowCategories?.forEach { put("workflow_categories[]", it) }
                workflowRecipientRunId?.let { put("workflow_recipient_run_id", it) }
                workflowRunId?.let { put("workflow_run_id", it) }
                putAll(additionalQueryParams)
            }
            .build()

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

            @JvmField val READ = of("read")

            @JvmField val INTERACTED = of("interacted")

            @JvmField val LINK_CLICKED = of("link_clicked")

            @JvmField val ARCHIVED = of("archived")

            @JvmStatic fun of(value: String) = EngagementStatus(JsonField.of(value))
        }

        /** An enum containing [EngagementStatus]'s known values. */
        enum class Known {
            SEEN,
            READ,
            INTERACTED,
            LINK_CLICKED,
            ARCHIVED,
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
            READ,
            INTERACTED,
            LINK_CLICKED,
            ARCHIVED,
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
                READ -> Value.READ
                INTERACTED -> Value.INTERACTED
                LINK_CLICKED -> Value.LINK_CLICKED
                ARCHIVED -> Value.ARCHIVED
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
                READ -> Known.READ
                INTERACTED -> Known.INTERACTED
                LINK_CLICKED -> Known.LINK_CLICKED
                ARCHIVED -> Known.ARCHIVED
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

        private var validated: Boolean = false

        fun validate(): EngagementStatus = apply {
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

            return /* spotless:off */ other is EngagementStatus && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    class InsertedAt
    private constructor(
        private val gt: String?,
        private val gte: String?,
        private val lt: String?,
        private val lte: String?,
        private val additionalProperties: QueryParams,
    ) {

        /** Limits the results to messages inserted after the given date. */
        fun gt(): Optional<String> = Optional.ofNullable(gt)

        /** Limits the results to messages inserted after or on the given date. */
        fun gte(): Optional<String> = Optional.ofNullable(gte)

        /** Limits the results to messages inserted before the given date. */
        fun lt(): Optional<String> = Optional.ofNullable(lt)

        /** Limits the results to messages inserted before or on the given date. */
        fun lte(): Optional<String> = Optional.ofNullable(lte)

        fun _additionalProperties(): QueryParams = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [InsertedAt]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [InsertedAt]. */
        class Builder internal constructor() {

            private var gt: String? = null
            private var gte: String? = null
            private var lt: String? = null
            private var lte: String? = null
            private var additionalProperties: QueryParams.Builder = QueryParams.builder()

            @JvmSynthetic
            internal fun from(insertedAt: InsertedAt) = apply {
                gt = insertedAt.gt
                gte = insertedAt.gte
                lt = insertedAt.lt
                lte = insertedAt.lte
                additionalProperties = insertedAt.additionalProperties.toBuilder()
            }

            /** Limits the results to messages inserted after the given date. */
            fun gt(gt: String?) = apply { this.gt = gt }

            /** Alias for calling [Builder.gt] with `gt.orElse(null)`. */
            fun gt(gt: Optional<String>) = gt(gt.getOrNull())

            /** Limits the results to messages inserted after or on the given date. */
            fun gte(gte: String?) = apply { this.gte = gte }

            /** Alias for calling [Builder.gte] with `gte.orElse(null)`. */
            fun gte(gte: Optional<String>) = gte(gte.getOrNull())

            /** Limits the results to messages inserted before the given date. */
            fun lt(lt: String?) = apply { this.lt = lt }

            /** Alias for calling [Builder.lt] with `lt.orElse(null)`. */
            fun lt(lt: Optional<String>) = lt(lt.getOrNull())

            /** Limits the results to messages inserted before or on the given date. */
            fun lte(lte: String?) = apply { this.lte = lte }

            /** Alias for calling [Builder.lte] with `lte.orElse(null)`. */
            fun lte(lte: Optional<String>) = lte(lte.getOrNull())

            fun additionalProperties(additionalProperties: QueryParams) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun additionalProperties(additionalProperties: Map<String, Iterable<String>>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: String) = apply {
                additionalProperties.put(key, value)
            }

            fun putAdditionalProperties(key: String, values: Iterable<String>) = apply {
                additionalProperties.put(key, values)
            }

            fun putAllAdditionalProperties(additionalProperties: QueryParams) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, Iterable<String>>) =
                apply {
                    this.additionalProperties.putAll(additionalProperties)
                }

            fun replaceAdditionalProperties(key: String, value: String) = apply {
                additionalProperties.replace(key, value)
            }

            fun replaceAdditionalProperties(key: String, values: Iterable<String>) = apply {
                additionalProperties.replace(key, values)
            }

            fun replaceAllAdditionalProperties(additionalProperties: QueryParams) = apply {
                this.additionalProperties.replaceAll(additionalProperties)
            }

            fun replaceAllAdditionalProperties(
                additionalProperties: Map<String, Iterable<String>>
            ) = apply { this.additionalProperties.replaceAll(additionalProperties) }

            fun removeAdditionalProperties(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                additionalProperties.removeAll(keys)
            }

            /**
             * Returns an immutable instance of [InsertedAt].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): InsertedAt = InsertedAt(gt, gte, lt, lte, additionalProperties.build())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is InsertedAt && gt == other.gt && gte == other.gte && lt == other.lt && lte == other.lte && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(gt, gte, lt, lte, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "InsertedAt{gt=$gt, gte=$gte, lt=$lt, lte=$lte, additionalProperties=$additionalProperties}"
    }

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

            @JvmField val SENT = of("sent")

            @JvmField val DELIVERED = of("delivered")

            @JvmField val DELIVERY_ATTEMPTED = of("delivery_attempted")

            @JvmField val UNDELIVERED = of("undelivered")

            @JvmField val NOT_SENT = of("not_sent")

            @JvmField val BOUNCED = of("bounced")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
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
            SENT,
            DELIVERED,
            DELIVERY_ATTEMPTED,
            UNDELIVERED,
            NOT_SENT,
            BOUNCED,
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListMessagesParams && collection == other.collection && id == other.id && after == other.after && before == other.before && channelId == other.channelId && engagementStatus == other.engagementStatus && insertedAt == other.insertedAt && messageIds == other.messageIds && pageSize == other.pageSize && source == other.source && status == other.status && tenant == other.tenant && triggerData == other.triggerData && workflowCategories == other.workflowCategories && workflowRecipientRunId == other.workflowRecipientRunId && workflowRunId == other.workflowRunId && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(collection, id, after, before, channelId, engagementStatus, insertedAt, messageIds, pageSize, source, status, tenant, triggerData, workflowCategories, workflowRecipientRunId, workflowRunId, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ObjectListMessagesParams{collection=$collection, id=$id, after=$after, before=$before, channelId=$channelId, engagementStatus=$engagementStatus, insertedAt=$insertedAt, messageIds=$messageIds, pageSize=$pageSize, source=$source, status=$status, tenant=$tenant, triggerData=$triggerData, workflowCategories=$workflowCategories, workflowRecipientRunId=$workflowRecipientRunId, workflowRunId=$workflowRunId, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
