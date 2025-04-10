// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.feeds

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** The response for the user's feed */
class FeedListItemsPageResponse
private constructor(
    private val entries: JsonField<List<FeedListItemsResponse>>,
    private val meta: JsonField<Meta>,
    private val pageInfo: JsonField<PageInfo>,
    private val vars: JsonField<Vars>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("entries")
        @ExcludeMissing
        entries: JsonField<List<FeedListItemsResponse>> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<Meta> = JsonMissing.of(),
        @JsonProperty("page_info") @ExcludeMissing pageInfo: JsonField<PageInfo> = JsonMissing.of(),
        @JsonProperty("vars") @ExcludeMissing vars: JsonField<Vars> = JsonMissing.of(),
    ) : this(entries, meta, pageInfo, vars, mutableMapOf())

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun entries(): List<FeedListItemsResponse> = entries.getRequired("entries")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun meta(): Meta = meta.getRequired("meta")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun pageInfo(): PageInfo = pageInfo.getRequired("page_info")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun vars(): Vars = vars.getRequired("vars")

    /**
     * Returns the raw JSON value of [entries].
     *
     * Unlike [entries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("entries")
    @ExcludeMissing
    fun _entries(): JsonField<List<FeedListItemsResponse>> = entries

    /**
     * Returns the raw JSON value of [meta].
     *
     * Unlike [meta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("meta") @ExcludeMissing fun _meta(): JsonField<Meta> = meta

    /**
     * Returns the raw JSON value of [pageInfo].
     *
     * Unlike [pageInfo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("page_info") @ExcludeMissing fun _pageInfo(): JsonField<PageInfo> = pageInfo

    /**
     * Returns the raw JSON value of [vars].
     *
     * Unlike [vars], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("vars") @ExcludeMissing fun _vars(): JsonField<Vars> = vars

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
         * Returns a mutable builder for constructing an instance of [FeedListItemsPageResponse].
         *
         * The following fields are required:
         * ```java
         * .entries()
         * .meta()
         * .pageInfo()
         * .vars()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FeedListItemsPageResponse]. */
    class Builder internal constructor() {

        private var entries: JsonField<MutableList<FeedListItemsResponse>>? = null
        private var meta: JsonField<Meta>? = null
        private var pageInfo: JsonField<PageInfo>? = null
        private var vars: JsonField<Vars>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(feedListItemsPageResponse: FeedListItemsPageResponse) = apply {
            entries = feedListItemsPageResponse.entries.map { it.toMutableList() }
            meta = feedListItemsPageResponse.meta
            pageInfo = feedListItemsPageResponse.pageInfo
            vars = feedListItemsPageResponse.vars
            additionalProperties = feedListItemsPageResponse.additionalProperties.toMutableMap()
        }

        fun entries(entries: List<FeedListItemsResponse>) = entries(JsonField.of(entries))

        /**
         * Sets [Builder.entries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entries] with a well-typed `List<FeedListItemsResponse>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun entries(entries: JsonField<List<FeedListItemsResponse>>) = apply {
            this.entries = entries.map { it.toMutableList() }
        }

        /**
         * Adds a single [FeedListItemsResponse] to [entries].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEntry(entry: FeedListItemsResponse) = apply {
            entries =
                (entries ?: JsonField.of(mutableListOf())).also {
                    checkKnown("entries", it).add(entry)
                }
        }

        fun meta(meta: Meta) = meta(JsonField.of(meta))

        /**
         * Sets [Builder.meta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meta] with a well-typed [Meta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun meta(meta: JsonField<Meta>) = apply { this.meta = meta }

        fun pageInfo(pageInfo: PageInfo) = pageInfo(JsonField.of(pageInfo))

        /**
         * Sets [Builder.pageInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pageInfo] with a well-typed [PageInfo] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun pageInfo(pageInfo: JsonField<PageInfo>) = apply { this.pageInfo = pageInfo }

        fun vars(vars: Vars) = vars(JsonField.of(vars))

        /**
         * Sets [Builder.vars] to an arbitrary JSON value.
         *
         * You should usually call [Builder.vars] with a well-typed [Vars] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun vars(vars: JsonField<Vars>) = apply { this.vars = vars }

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
         * Returns an immutable instance of [FeedListItemsPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .entries()
         * .meta()
         * .pageInfo()
         * .vars()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FeedListItemsPageResponse =
            FeedListItemsPageResponse(
                checkRequired("entries", entries).map { it.toImmutable() },
                checkRequired("meta", meta),
                checkRequired("pageInfo", pageInfo),
                checkRequired("vars", vars),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): FeedListItemsPageResponse = apply {
        if (validated) {
            return@apply
        }

        entries().forEach { it.validate() }
        meta().validate()
        pageInfo().validate()
        vars().validate()
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
        (entries.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (meta.asKnown().getOrNull()?.validity() ?: 0) +
            (pageInfo.asKnown().getOrNull()?.validity() ?: 0) +
            (vars.asKnown().getOrNull()?.validity() ?: 0)

    class Meta
    private constructor(
        private val _typename: JsonField<String>,
        private val totalCount: JsonField<Long>,
        private val unreadCount: JsonField<Long>,
        private val unseenCount: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("__typename")
            @ExcludeMissing
            _typename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("total_count")
            @ExcludeMissing
            totalCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("unread_count")
            @ExcludeMissing
            unreadCount: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("unseen_count")
            @ExcludeMissing
            unseenCount: JsonField<Long> = JsonMissing.of(),
        ) : this(_typename, totalCount, unreadCount, unseenCount, mutableMapOf())

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun _typename(): String = _typename.getRequired("__typename")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun totalCount(): Long = totalCount.getRequired("total_count")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun unreadCount(): Long = unreadCount.getRequired("unread_count")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun unseenCount(): Long = unseenCount.getRequired("unseen_count")

        /**
         * Returns the raw JSON value of [_typename].
         *
         * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

        /**
         * Returns the raw JSON value of [totalCount].
         *
         * Unlike [totalCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total_count") @ExcludeMissing fun _totalCount(): JsonField<Long> = totalCount

        /**
         * Returns the raw JSON value of [unreadCount].
         *
         * Unlike [unreadCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("unread_count")
        @ExcludeMissing
        fun _unreadCount(): JsonField<Long> = unreadCount

        /**
         * Returns the raw JSON value of [unseenCount].
         *
         * Unlike [unseenCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("unseen_count")
        @ExcludeMissing
        fun _unseenCount(): JsonField<Long> = unseenCount

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
             * Returns a mutable builder for constructing an instance of [Meta].
             *
             * The following fields are required:
             * ```java
             * ._typename()
             * .totalCount()
             * .unreadCount()
             * .unseenCount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Meta]. */
        class Builder internal constructor() {

            private var _typename: JsonField<String>? = null
            private var totalCount: JsonField<Long>? = null
            private var unreadCount: JsonField<Long>? = null
            private var unseenCount: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(meta: Meta) = apply {
                _typename = meta._typename
                totalCount = meta.totalCount
                unreadCount = meta.unreadCount
                unseenCount = meta.unseenCount
                additionalProperties = meta.additionalProperties.toMutableMap()
            }

            fun _typename(_typename: String) = _typename(JsonField.of(_typename))

            /**
             * Sets [Builder._typename] to an arbitrary JSON value.
             *
             * You should usually call [Builder._typename] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

            fun totalCount(totalCount: Long) = totalCount(JsonField.of(totalCount))

            /**
             * Sets [Builder.totalCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalCount(totalCount: JsonField<Long>) = apply { this.totalCount = totalCount }

            fun unreadCount(unreadCount: Long) = unreadCount(JsonField.of(unreadCount))

            /**
             * Sets [Builder.unreadCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.unreadCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun unreadCount(unreadCount: JsonField<Long>) = apply { this.unreadCount = unreadCount }

            fun unseenCount(unseenCount: Long) = unseenCount(JsonField.of(unseenCount))

            /**
             * Sets [Builder.unseenCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.unseenCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun unseenCount(unseenCount: JsonField<Long>) = apply { this.unseenCount = unseenCount }

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
             * Returns an immutable instance of [Meta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * ._typename()
             * .totalCount()
             * .unreadCount()
             * .unseenCount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Meta =
                Meta(
                    checkRequired("_typename", _typename),
                    checkRequired("totalCount", totalCount),
                    checkRequired("unreadCount", unreadCount),
                    checkRequired("unseenCount", unseenCount),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Meta = apply {
            if (validated) {
                return@apply
            }

            _typename()
            totalCount()
            unreadCount()
            unseenCount()
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
            (if (_typename.asKnown().isPresent) 1 else 0) +
                (if (totalCount.asKnown().isPresent) 1 else 0) +
                (if (unreadCount.asKnown().isPresent) 1 else 0) +
                (if (unseenCount.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Meta && _typename == other._typename && totalCount == other.totalCount && unreadCount == other.unreadCount && unseenCount == other.unseenCount && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(_typename, totalCount, unreadCount, unseenCount, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Meta{_typename=$_typename, totalCount=$totalCount, unreadCount=$unreadCount, unseenCount=$unseenCount, additionalProperties=$additionalProperties}"
    }

    class PageInfo
    private constructor(
        private val hasNextPage: JsonField<Boolean>,
        private val hasPreviousPage: JsonField<Boolean>,
        private val totalCount: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("has_next_page")
            @ExcludeMissing
            hasNextPage: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("has_previous_page")
            @ExcludeMissing
            hasPreviousPage: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("total_count")
            @ExcludeMissing
            totalCount: JsonField<Long> = JsonMissing.of(),
        ) : this(hasNextPage, hasPreviousPage, totalCount, mutableMapOf())

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun hasNextPage(): Boolean = hasNextPage.getRequired("has_next_page")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun hasPreviousPage(): Boolean = hasPreviousPage.getRequired("has_previous_page")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun totalCount(): Long = totalCount.getRequired("total_count")

        /**
         * Returns the raw JSON value of [hasNextPage].
         *
         * Unlike [hasNextPage], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("has_next_page")
        @ExcludeMissing
        fun _hasNextPage(): JsonField<Boolean> = hasNextPage

        /**
         * Returns the raw JSON value of [hasPreviousPage].
         *
         * Unlike [hasPreviousPage], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("has_previous_page")
        @ExcludeMissing
        fun _hasPreviousPage(): JsonField<Boolean> = hasPreviousPage

        /**
         * Returns the raw JSON value of [totalCount].
         *
         * Unlike [totalCount], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total_count") @ExcludeMissing fun _totalCount(): JsonField<Long> = totalCount

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
             * Returns a mutable builder for constructing an instance of [PageInfo].
             *
             * The following fields are required:
             * ```java
             * .hasNextPage()
             * .hasPreviousPage()
             * .totalCount()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PageInfo]. */
        class Builder internal constructor() {

            private var hasNextPage: JsonField<Boolean>? = null
            private var hasPreviousPage: JsonField<Boolean>? = null
            private var totalCount: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(pageInfo: PageInfo) = apply {
                hasNextPage = pageInfo.hasNextPage
                hasPreviousPage = pageInfo.hasPreviousPage
                totalCount = pageInfo.totalCount
                additionalProperties = pageInfo.additionalProperties.toMutableMap()
            }

            fun hasNextPage(hasNextPage: Boolean) = hasNextPage(JsonField.of(hasNextPage))

            /**
             * Sets [Builder.hasNextPage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasNextPage] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasNextPage(hasNextPage: JsonField<Boolean>) = apply {
                this.hasNextPage = hasNextPage
            }

            fun hasPreviousPage(hasPreviousPage: Boolean) =
                hasPreviousPage(JsonField.of(hasPreviousPage))

            /**
             * Sets [Builder.hasPreviousPage] to an arbitrary JSON value.
             *
             * You should usually call [Builder.hasPreviousPage] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun hasPreviousPage(hasPreviousPage: JsonField<Boolean>) = apply {
                this.hasPreviousPage = hasPreviousPage
            }

            fun totalCount(totalCount: Long) = totalCount(JsonField.of(totalCount))

            /**
             * Sets [Builder.totalCount] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalCount] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalCount(totalCount: JsonField<Long>) = apply { this.totalCount = totalCount }

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
             * Returns an immutable instance of [PageInfo].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .hasNextPage()
             * .hasPreviousPage()
             * .totalCount()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PageInfo =
                PageInfo(
                    checkRequired("hasNextPage", hasNextPage),
                    checkRequired("hasPreviousPage", hasPreviousPage),
                    checkRequired("totalCount", totalCount),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): PageInfo = apply {
            if (validated) {
                return@apply
            }

            hasNextPage()
            hasPreviousPage()
            totalCount()
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
            (if (hasNextPage.asKnown().isPresent) 1 else 0) +
                (if (hasPreviousPage.asKnown().isPresent) 1 else 0) +
                (if (totalCount.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is PageInfo && hasNextPage == other.hasNextPage && hasPreviousPage == other.hasPreviousPage && totalCount == other.totalCount && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(hasNextPage, hasPreviousPage, totalCount, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PageInfo{hasNextPage=$hasNextPage, hasPreviousPage=$hasPreviousPage, totalCount=$totalCount, additionalProperties=$additionalProperties}"
    }

    class Vars
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

            /** Returns a mutable builder for constructing an instance of [Vars]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Vars]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(vars: Vars) = apply {
                additionalProperties = vars.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Vars].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Vars = Vars(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Vars = apply {
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

            return /* spotless:off */ other is Vars && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Vars{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FeedListItemsPageResponse && entries == other.entries && meta == other.meta && pageInfo == other.pageInfo && vars == other.vars && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(entries, meta, pageInfo, vars, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "FeedListItemsPageResponse{entries=$entries, meta=$meta, pageInfo=$pageInfo, vars=$vars, additionalProperties=$additionalProperties}"
}
