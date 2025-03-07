// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.knock.api.core.Enum
import com.knock.api.core.JsonField
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.Params
import com.knock.api.core.checkRequired
import com.knock.api.core.http.Headers
import com.knock.api.core.http.QueryParams
import com.knock.api.core.toImmutable
import com.knock.api.errors.KnockInvalidDataException
import java.util.Objects
import java.util.Optional

/** Returns a paginated list of feed items for a user, including metadata about the feed. */
class UserFeedListItemsParams
private constructor(
    private val userId: String,
    private val id: String,
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

    fun id(): String = id

    /** The cursor to fetch entries after */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** The archived status of the feed items to return */
    fun archived(): Optional<Archived> = Optional.ofNullable(archived)

    /** The cursor to fetch entries before */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /** Whether the feed items have a tenant */
    fun hasTenant(): Optional<Boolean> = Optional.ofNullable(hasTenant)

    /** The page size to fetch */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** The source of the feed items to return */
    fun source(): Optional<String> = Optional.ofNullable(source)

    /** The status of the feed items to return */
    fun status(): Optional<Status> = Optional.ofNullable(status)

    /** The tenant of the feed items to return */
    fun tenant(): Optional<String> = Optional.ofNullable(tenant)

    /** The trigger data of the feed items to return (as a JSON string) */
    fun triggerData(): Optional<String> = Optional.ofNullable(triggerData)

    /** The workflow categories of the feed items to return */
    fun workflowCategories(): Optional<List<String>> = Optional.ofNullable(workflowCategories)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams {
        val queryParams = QueryParams.builder()
        this.after?.let { queryParams.put("after", listOf(it.toString())) }
        this.archived?.let { queryParams.put("archived", listOf(it.toString())) }
        this.before?.let { queryParams.put("before", listOf(it.toString())) }
        this.hasTenant?.let { queryParams.put("has_tenant", listOf(it.toString())) }
        this.pageSize?.let { queryParams.put("page_size", listOf(it.toString())) }
        this.source?.let { queryParams.put("source", listOf(it.toString())) }
        this.status?.let { queryParams.put("status", listOf(it.toString())) }
        this.tenant?.let { queryParams.put("tenant", listOf(it.toString())) }
        this.triggerData?.let { queryParams.put("trigger_data", listOf(it.toString())) }
        this.workflowCategories?.let {
            queryParams.put("workflow_categories[]", it.map(Any::toString))
        }
        queryParams.putAll(additionalQueryParams)
        return queryParams.build()
    }

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> userId
            1 -> id
            else -> ""
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserFeedListItemsParams].
         *
         * The following fields are required:
         * ```java
         * .userId()
         * .id()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserFeedListItemsParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var userId: String? = null
        private var id: String? = null
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
        internal fun from(userFeedListItemsParams: UserFeedListItemsParams) = apply {
            userId = userFeedListItemsParams.userId
            id = userFeedListItemsParams.id
            after = userFeedListItemsParams.after
            archived = userFeedListItemsParams.archived
            before = userFeedListItemsParams.before
            hasTenant = userFeedListItemsParams.hasTenant
            pageSize = userFeedListItemsParams.pageSize
            source = userFeedListItemsParams.source
            status = userFeedListItemsParams.status
            tenant = userFeedListItemsParams.tenant
            triggerData = userFeedListItemsParams.triggerData
            workflowCategories = userFeedListItemsParams.workflowCategories?.toMutableList()
            additionalHeaders = userFeedListItemsParams.additionalHeaders.toBuilder()
            additionalQueryParams = userFeedListItemsParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String) = apply { this.userId = userId }

        fun id(id: String) = apply { this.id = id }

        /** The cursor to fetch entries after */
        fun after(after: String?) = apply { this.after = after }

        /** The cursor to fetch entries after */
        fun after(after: Optional<String>) = after(after.orElse(null))

        /** The archived status of the feed items to return */
        fun archived(archived: Archived?) = apply { this.archived = archived }

        /** The archived status of the feed items to return */
        fun archived(archived: Optional<Archived>) = archived(archived.orElse(null))

        /** The cursor to fetch entries before */
        fun before(before: String?) = apply { this.before = before }

        /** The cursor to fetch entries before */
        fun before(before: Optional<String>) = before(before.orElse(null))

        /** Whether the feed items have a tenant */
        fun hasTenant(hasTenant: Boolean?) = apply { this.hasTenant = hasTenant }

        /** Whether the feed items have a tenant */
        fun hasTenant(hasTenant: Boolean) = hasTenant(hasTenant as Boolean?)

        /** Whether the feed items have a tenant */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun hasTenant(hasTenant: Optional<Boolean>) = hasTenant(hasTenant.orElse(null) as Boolean?)

        /** The page size to fetch */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /** The page size to fetch */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** The page size to fetch */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.orElse(null) as Long?)

        /** The source of the feed items to return */
        fun source(source: String?) = apply { this.source = source }

        /** The source of the feed items to return */
        fun source(source: Optional<String>) = source(source.orElse(null))

        /** The status of the feed items to return */
        fun status(status: Status?) = apply { this.status = status }

        /** The status of the feed items to return */
        fun status(status: Optional<Status>) = status(status.orElse(null))

        /** The tenant of the feed items to return */
        fun tenant(tenant: String?) = apply { this.tenant = tenant }

        /** The tenant of the feed items to return */
        fun tenant(tenant: Optional<String>) = tenant(tenant.orElse(null))

        /** The trigger data of the feed items to return (as a JSON string) */
        fun triggerData(triggerData: String?) = apply { this.triggerData = triggerData }

        /** The trigger data of the feed items to return (as a JSON string) */
        fun triggerData(triggerData: Optional<String>) = triggerData(triggerData.orElse(null))

        /** The workflow categories of the feed items to return */
        fun workflowCategories(workflowCategories: List<String>?) = apply {
            this.workflowCategories = workflowCategories?.toMutableList()
        }

        /** The workflow categories of the feed items to return */
        fun workflowCategories(workflowCategories: Optional<List<String>>) =
            workflowCategories(workflowCategories.orElse(null))

        /** The workflow categories of the feed items to return */
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

        fun build(): UserFeedListItemsParams =
            UserFeedListItemsParams(
                checkRequired("userId", userId),
                checkRequired("id", id),
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

    /** The archived status of the feed items to return */
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

    /** The status of the feed items to return */
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

        return /* spotless:off */ other is UserFeedListItemsParams && userId == other.userId && id == other.id && after == other.after && archived == other.archived && before == other.before && hasTenant == other.hasTenant && pageSize == other.pageSize && source == other.source && status == other.status && tenant == other.tenant && triggerData == other.triggerData && workflowCategories == other.workflowCategories && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, id, after, archived, before, hasTenant, pageSize, source, status, tenant, triggerData, workflowCategories, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "UserFeedListItemsParams{userId=$userId, id=$id, after=$after, archived=$archived, before=$before, hasTenant=$hasTenant, pageSize=$pageSize, source=$source, status=$status, tenant=$tenant, triggerData=$triggerData, workflowCategories=$workflowCategories, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
