// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.core.Enum
import app.knock.api.core.JsonField
import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonCreator
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Returns a paginated list of feed items for a user, including metadata about the feed. */
class FeedListItemsParams
private constructor(
    private val userId: String,
    private val channelId: String,
    private val after: String?,
    private val archived: Archived?,
    private val before: String?,
    private val hasTenant: Boolean?,
    private val pageSize: Long?,
    private val source: String?,
    private val status: Status?,
    private val tenant: String?,
    private val triggerData: String?,
    private val workflowCategories: List<String>?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): String = userId

    fun channelId(): String = channelId

    /** The cursor to fetch entries after. */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** The archived status of the feed items. */
    fun archived(): Optional<Archived> = Optional.ofNullable(archived)

    /** The cursor to fetch entries before. */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /** Whether the feed items have a tenant. */
    fun hasTenant(): Optional<Boolean> = Optional.ofNullable(hasTenant)

    /** The number of items per page. */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** The source of the feed items. */
    fun source(): Optional<String> = Optional.ofNullable(source)

    /** The status of the feed items. */
    fun status(): Optional<Status> = Optional.ofNullable(status)

    /** The tenant associated with the feed items. */
    fun tenant(): Optional<String> = Optional.ofNullable(tenant)

    /** The trigger data of the feed items (as a JSON string). */
    fun triggerData(): Optional<String> = Optional.ofNullable(triggerData)

    /** The workflow categories of the feed items. */
    fun workflowCategories(): Optional<List<String>> = Optional.ofNullable(workflowCategories)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FeedListItemsParams].
         *
         * The following fields are required:
         * ```java
         * .userId()
         * .channelId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FeedListItemsParams]. */
    class Builder internal constructor() {

        private var userId: String? = null
        private var channelId: String? = null
        private var after: String? = null
        private var archived: Archived? = null
        private var before: String? = null
        private var hasTenant: Boolean? = null
        private var pageSize: Long? = null
        private var source: String? = null
        private var status: Status? = null
        private var tenant: String? = null
        private var triggerData: String? = null
        private var workflowCategories: MutableList<String>? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(feedListItemsParams: FeedListItemsParams) = apply {
            userId = feedListItemsParams.userId
            channelId = feedListItemsParams.channelId
            after = feedListItemsParams.after
            archived = feedListItemsParams.archived
            before = feedListItemsParams.before
            hasTenant = feedListItemsParams.hasTenant
            pageSize = feedListItemsParams.pageSize
            source = feedListItemsParams.source
            status = feedListItemsParams.status
            tenant = feedListItemsParams.tenant
            triggerData = feedListItemsParams.triggerData
            workflowCategories = feedListItemsParams.workflowCategories?.toMutableList()
            additionalHeaders = feedListItemsParams.additionalHeaders.toBuilder()
            additionalQueryParams = feedListItemsParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String) = apply { this.userId = userId }

        fun channelId(channelId: String) = apply { this.channelId = channelId }

        /** The cursor to fetch entries after. */
        fun after(after: String?) = apply { this.after = after }

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /** The archived status of the feed items. */
        fun archived(archived: Archived?) = apply { this.archived = archived }

        /** Alias for calling [Builder.archived] with `archived.orElse(null)`. */
        fun archived(archived: Optional<Archived>) = archived(archived.getOrNull())

        /** The cursor to fetch entries before. */
        fun before(before: String?) = apply { this.before = before }

        /** Alias for calling [Builder.before] with `before.orElse(null)`. */
        fun before(before: Optional<String>) = before(before.getOrNull())

        /** Whether the feed items have a tenant. */
        fun hasTenant(hasTenant: Boolean?) = apply { this.hasTenant = hasTenant }

        /**
         * Alias for [Builder.hasTenant].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun hasTenant(hasTenant: Boolean) = hasTenant(hasTenant as Boolean?)

        /** Alias for calling [Builder.hasTenant] with `hasTenant.orElse(null)`. */
        fun hasTenant(hasTenant: Optional<Boolean>) = hasTenant(hasTenant.getOrNull())

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

        /** The source of the feed items. */
        fun source(source: String?) = apply { this.source = source }

        /** Alias for calling [Builder.source] with `source.orElse(null)`. */
        fun source(source: Optional<String>) = source(source.getOrNull())

        /** The status of the feed items. */
        fun status(status: Status?) = apply { this.status = status }

        /** Alias for calling [Builder.status] with `status.orElse(null)`. */
        fun status(status: Optional<Status>) = status(status.getOrNull())

        /** The tenant associated with the feed items. */
        fun tenant(tenant: String?) = apply { this.tenant = tenant }

        /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        /** The trigger data of the feed items (as a JSON string). */
        fun triggerData(triggerData: String?) = apply { this.triggerData = triggerData }

        /** Alias for calling [Builder.triggerData] with `triggerData.orElse(null)`. */
        fun triggerData(triggerData: Optional<String>) = triggerData(triggerData.getOrNull())

        /** The workflow categories of the feed items. */
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
         * Returns an immutable instance of [FeedListItemsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .userId()
         * .channelId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FeedListItemsParams =
            FeedListItemsParams(
                checkRequired("userId", userId),
                checkRequired("channelId", channelId),
                after,
                archived,
                before,
                hasTenant,
                pageSize,
                source,
                status,
                tenant,
                triggerData,
                workflowCategories?.toImmutable(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> userId
            1 -> channelId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                archived?.let { put("archived", it.toString()) }
                before?.let { put("before", it) }
                hasTenant?.let { put("has_tenant", it.toString()) }
                pageSize?.let { put("page_size", it.toString()) }
                source?.let { put("source", it) }
                status?.let { put("status", it.toString()) }
                tenant?.let { put("tenant", it) }
                triggerData?.let { put("trigger_data", it) }
                workflowCategories?.forEach { put("workflow_categories[]", it) }
                putAll(additionalQueryParams)
            }
            .build()

    /** The archived status of the feed items. */
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

        private var validated: Boolean = false

        fun validate(): Archived = apply {
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

            return /* spotless:off */ other is Archived && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** The status of the feed items. */
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

            @JvmField val UNREAD = of("unread")

            @JvmField val READ = of("read")

            @JvmField val UNSEEN = of("unseen")

            @JvmField val SEEN = of("seen")

            @JvmField val ALL = of("all")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            UNREAD,
            READ,
            UNSEEN,
            SEEN,
            ALL,
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
            UNREAD,
            READ,
            UNSEEN,
            SEEN,
            ALL,
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
                UNREAD -> Value.UNREAD
                READ -> Value.READ
                UNSEEN -> Value.UNSEEN
                SEEN -> Value.SEEN
                ALL -> Value.ALL
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
                UNREAD -> Known.UNREAD
                READ -> Known.READ
                UNSEEN -> Known.UNSEEN
                SEEN -> Known.SEEN
                ALL -> Known.ALL
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

        return /* spotless:off */ other is FeedListItemsParams && userId == other.userId && channelId == other.channelId && after == other.after && archived == other.archived && before == other.before && hasTenant == other.hasTenant && pageSize == other.pageSize && source == other.source && status == other.status && tenant == other.tenant && triggerData == other.triggerData && workflowCategories == other.workflowCategories && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, channelId, after, archived, before, hasTenant, pageSize, source, status, tenant, triggerData, workflowCategories, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "FeedListItemsParams{userId=$userId, channelId=$channelId, after=$after, archived=$archived, before=$before, hasTenant=$hasTenant, pageSize=$pageSize, source=$source, status=$status, tenant=$tenant, triggerData=$triggerData, workflowCategories=$workflowCategories, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
