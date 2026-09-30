// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

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

/** Returns a paginated list of feed items for a user, including metadata about the feed. */
class FeedListItemsParams
private constructor(
    private val userId: String?,
    private val id: String?,
    private val after: String?,
    private val archived: Archived?,
    private val before: String?,
    private val exclude: String?,
    private val hasTenant: Boolean?,
    private val insertedAt: InsertedAt?,
    private val locale: String?,
    private val mode: Mode?,
    private val pageSize: Long?,
    private val source: String?,
    private val status: Status?,
    private val tenant: String?,
    private val triggerData: String?,
    private val workflowCategories: List<String>?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): Optional<String> = Optional.ofNullable(userId)

    fun id(): Optional<String> = Optional.ofNullable(id)

    /** The cursor to fetch entries after. */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** The archived status of the feed items. */
    fun archived(): Optional<Archived> = Optional.ofNullable(archived)

    /** The cursor to fetch entries before. */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /**
     * Comma-separated list of field paths to exclude from the response. Use dot notation for nested
     * fields (e.g., `entries.archived_at`). Limited to 3 levels deep.
     */
    fun exclude(): Optional<String> = Optional.ofNullable(exclude)

    /** Whether the feed items have a tenant. */
    fun hasTenant(): Optional<Boolean> = Optional.ofNullable(hasTenant)

    /** Filters feed items by the time they were inserted. */
    fun insertedAt(): Optional<InsertedAt> = Optional.ofNullable(insertedAt)

    /**
     * The locale to render the feed items in. Must be in the IETF 5646 format (e.g. `en-US`). When
     * not provided, will default to the locale that the feed items were rendered in. Only available
     * for enterprise plan customers using custom translations.
     */
    fun locale(): Optional<String> = Optional.ofNullable(locale)

    /**
     * The mode to render the feed items in. Can be `compact` or `rich`. Defaults to `rich`. When
     * `mode` is `compact`, feed items will not have `activities` and `total_activities` fields, and
     * the `data` field will not include nested arrays and objects.
     */
    fun mode(): Optional<Mode> = Optional.ofNullable(mode)

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

        @JvmStatic fun none(): FeedListItemsParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [FeedListItemsParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FeedListItemsParams]. */
    class Builder internal constructor() {

        private var userId: String? = null
        private var id: String? = null
        private var after: String? = null
        private var archived: Archived? = null
        private var before: String? = null
        private var exclude: String? = null
        private var hasTenant: Boolean? = null
        private var insertedAt: InsertedAt? = null
        private var locale: String? = null
        private var mode: Mode? = null
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
            id = feedListItemsParams.id
            after = feedListItemsParams.after
            archived = feedListItemsParams.archived
            before = feedListItemsParams.before
            exclude = feedListItemsParams.exclude
            hasTenant = feedListItemsParams.hasTenant
            insertedAt = feedListItemsParams.insertedAt
            locale = feedListItemsParams.locale
            mode = feedListItemsParams.mode
            pageSize = feedListItemsParams.pageSize
            source = feedListItemsParams.source
            status = feedListItemsParams.status
            tenant = feedListItemsParams.tenant
            triggerData = feedListItemsParams.triggerData
            workflowCategories = feedListItemsParams.workflowCategories?.toMutableList()
            additionalHeaders = feedListItemsParams.additionalHeaders.toBuilder()
            additionalQueryParams = feedListItemsParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String?) = apply { this.userId = userId }

        /** Alias for calling [Builder.userId] with `userId.orElse(null)`. */
        fun userId(userId: Optional<String>) = userId(userId.getOrNull())

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

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

        /**
         * Comma-separated list of field paths to exclude from the response. Use dot notation for
         * nested fields (e.g., `entries.archived_at`). Limited to 3 levels deep.
         */
        fun exclude(exclude: String?) = apply { this.exclude = exclude }

        /** Alias for calling [Builder.exclude] with `exclude.orElse(null)`. */
        fun exclude(exclude: Optional<String>) = exclude(exclude.getOrNull())

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

        /** Filters feed items by the time they were inserted. */
        fun insertedAt(insertedAt: InsertedAt?) = apply { this.insertedAt = insertedAt }

        /** Alias for calling [Builder.insertedAt] with `insertedAt.orElse(null)`. */
        fun insertedAt(insertedAt: Optional<InsertedAt>) = insertedAt(insertedAt.getOrNull())

        /**
         * The locale to render the feed items in. Must be in the IETF 5646 format (e.g. `en-US`).
         * When not provided, will default to the locale that the feed items were rendered in. Only
         * available for enterprise plan customers using custom translations.
         */
        fun locale(locale: String?) = apply { this.locale = locale }

        /** Alias for calling [Builder.locale] with `locale.orElse(null)`. */
        fun locale(locale: Optional<String>) = locale(locale.getOrNull())

        /**
         * The mode to render the feed items in. Can be `compact` or `rich`. Defaults to `rich`.
         * When `mode` is `compact`, feed items will not have `activities` and `total_activities`
         * fields, and the `data` field will not include nested arrays and objects.
         */
        fun mode(mode: Mode?) = apply { this.mode = mode }

        /** Alias for calling [Builder.mode] with `mode.orElse(null)`. */
        fun mode(mode: Optional<Mode>) = mode(mode.getOrNull())

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
         */
        fun build(): FeedListItemsParams =
            FeedListItemsParams(
                userId,
                id,
                after,
                archived,
                before,
                exclude,
                hasTenant,
                insertedAt,
                locale,
                mode,
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
            0 -> userId ?: ""
            1 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                after?.let { put("after", it) }
                archived?.let { put("archived", it.toString()) }
                before?.let { put("before", it) }
                exclude?.let { put("exclude", it) }
                hasTenant?.let { put("has_tenant", it.toString()) }
                insertedAt?.let {
                    it.gt().ifPresent { put("inserted_at.gt", it) }
                    it.gte().ifPresent { put("inserted_at.gte", it) }
                    it.lt().ifPresent { put("inserted_at.lt", it) }
                    it.lte().ifPresent { put("inserted_at.lte", it) }
                    it._additionalProperties().keys().forEach { key ->
                        it._additionalProperties().values(key).forEach { value ->
                            put("inserted_at.$key", value)
                        }
                    }
                }
                locale?.let { put("locale", it) }
                mode?.let { put("mode", it.toString()) }
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

    /**
     * The mode to render the feed items in. Can be `compact` or `rich`. Defaults to `rich`. When
     * `mode` is `compact`, feed items will not have `activities` and `total_activities` fields, and
     * the `data` field will not include nested arrays and objects.
     */
    class Mode @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val COMPACT = of("compact")

            @JvmField val RICH = of("rich")

            @JvmStatic fun of(value: String) = Mode(JsonField.of(value))
        }

        /** An enum containing [Mode]'s known values. */
        enum class Known {
            COMPACT,
            RICH,
        }

        /**
         * An enum containing [Mode]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Mode] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            COMPACT,
            RICH,
            /** An enum member indicating that [Mode] was instantiated with an unknown value. */
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
                COMPACT -> Value.COMPACT
                RICH -> Value.RICH
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
                COMPACT -> Known.COMPACT
                RICH -> Known.RICH
                else -> throw KnockInvalidDataException("Unknown Mode: $value")
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

        fun validate(): Mode = apply {
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

            return /* spotless:off */ other is Mode && value == other.value /* spotless:on */
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

    /** Filters feed items by the time they were inserted. */
    class InsertedAt
    private constructor(
        private val gt: String?,
        private val gte: String?,
        private val lt: String?,
        private val lte: String?,
        private val additionalProperties: QueryParams,
    ) {

        /** Limits the results to items inserted after the given date. */
        fun gt(): Optional<String> = Optional.ofNullable(gt)

        /** Limits the results to items inserted after or on the given date. */
        fun gte(): Optional<String> = Optional.ofNullable(gte)

        /** Limits the results to items inserted before the given date. */
        fun lt(): Optional<String> = Optional.ofNullable(lt)

        /** Limits the results to items inserted before or on the given date. */
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

            /** Limits the results to items inserted after the given date. */
            fun gt(gt: String?) = apply { this.gt = gt }

            /** Alias for calling [Builder.gt] with `gt.orElse(null)`. */
            fun gt(gt: Optional<String>) = gt(gt.getOrNull())

            /** Limits the results to items inserted after or on the given date. */
            fun gte(gte: String?) = apply { this.gte = gte }

            /** Alias for calling [Builder.gte] with `gte.orElse(null)`. */
            fun gte(gte: Optional<String>) = gte(gte.getOrNull())

            /** Limits the results to items inserted before the given date. */
            fun lt(lt: String?) = apply { this.lt = lt }

            /** Alias for calling [Builder.lt] with `lt.orElse(null)`. */
            fun lt(lt: Optional<String>) = lt(lt.getOrNull())

            /** Limits the results to items inserted before or on the given date. */
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

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(gt, gte, lt, lte, additionalProperties) /* spotless:on */

        override fun toString() =
            "InsertedAt{gt=$gt, gte=$gte, lt=$lt, lte=$lte, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FeedListItemsParams && userId == other.userId && id == other.id && after == other.after && archived == other.archived && before == other.before && exclude == other.exclude && hasTenant == other.hasTenant && insertedAt == other.insertedAt && locale == other.locale && mode == other.mode && pageSize == other.pageSize && source == other.source && status == other.status && tenant == other.tenant && triggerData == other.triggerData && workflowCategories == other.workflowCategories && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, id, after, archived, before, exclude, hasTenant, insertedAt, locale, mode, pageSize, source, status, tenant, triggerData, workflowCategories, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "FeedListItemsParams{userId=$userId, id=$id, after=$after, archived=$archived, before=$before, exclude=$exclude, hasTenant=$hasTenant, insertedAt=$insertedAt, locale=$locale, mode=$mode, pageSize=$pageSize, source=$source, status=$status, tenant=$tenant, triggerData=$triggerData, workflowCategories=$workflowCategories, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
