// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.schedules.Schedule
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A paginated list of schedules in a collection. */
class ObjectListSchedulesPageResponse
private constructor(
    private val entries: JsonField<List<Schedule>>,
    private val pageInfo: JsonField<PageInfo>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("entries")
        @ExcludeMissing
        entries: JsonField<List<Schedule>> = JsonMissing.of(),
        @JsonProperty("page_info") @ExcludeMissing pageInfo: JsonField<PageInfo> = JsonMissing.of(),
    ) : this(entries, pageInfo, mutableMapOf())

    /**
     * The list of schedules
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun entries(): List<Schedule> = entries.getRequired("entries")

    /**
     * The information about a paginated result
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun pageInfo(): PageInfo = pageInfo.getRequired("page_info")

    /**
     * Returns the raw JSON value of [entries].
     *
     * Unlike [entries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("entries") @ExcludeMissing fun _entries(): JsonField<List<Schedule>> = entries

    /**
     * Returns the raw JSON value of [pageInfo].
     *
     * Unlike [pageInfo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("page_info") @ExcludeMissing fun _pageInfo(): JsonField<PageInfo> = pageInfo

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
         * Returns a mutable builder for constructing an instance of
         * [ObjectListSchedulesPageResponse].
         *
         * The following fields are required:
         * ```java
         * .entries()
         * .pageInfo()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ObjectListSchedulesPageResponse]. */
    class Builder internal constructor() {

        private var entries: JsonField<MutableList<Schedule>>? = null
        private var pageInfo: JsonField<PageInfo>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(objectListSchedulesPageResponse: ObjectListSchedulesPageResponse) =
            apply {
                entries = objectListSchedulesPageResponse.entries.map { it.toMutableList() }
                pageInfo = objectListSchedulesPageResponse.pageInfo
                additionalProperties =
                    objectListSchedulesPageResponse.additionalProperties.toMutableMap()
            }

        /** The list of schedules */
        fun entries(entries: List<Schedule>) = entries(JsonField.of(entries))

        /**
         * Sets [Builder.entries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entries] with a well-typed `List<Schedule>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun entries(entries: JsonField<List<Schedule>>) = apply {
            this.entries = entries.map { it.toMutableList() }
        }

        /**
         * Adds a single [Schedule] to [entries].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEntry(entry: Schedule) = apply {
            entries =
                (entries ?: JsonField.of(mutableListOf())).also {
                    checkKnown("entries", it).add(entry)
                }
        }

        /** The information about a paginated result */
        fun pageInfo(pageInfo: PageInfo) = pageInfo(JsonField.of(pageInfo))

        /**
         * Sets [Builder.pageInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pageInfo] with a well-typed [PageInfo] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun pageInfo(pageInfo: JsonField<PageInfo>) = apply { this.pageInfo = pageInfo }

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
         * Returns an immutable instance of [ObjectListSchedulesPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .entries()
         * .pageInfo()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ObjectListSchedulesPageResponse =
            ObjectListSchedulesPageResponse(
                checkRequired("entries", entries).map { it.toImmutable() },
                checkRequired("pageInfo", pageInfo),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ObjectListSchedulesPageResponse = apply {
        if (validated) {
            return@apply
        }

        entries().forEach { it.validate() }
        pageInfo().validate()
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
            (pageInfo.asKnown().getOrNull()?.validity() ?: 0)

    /** The information about a paginated result */
    class PageInfo
    private constructor(
        private val _typename: JsonField<String>,
        private val pageSize: JsonField<Long>,
        private val after: JsonField<String>,
        private val before: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("__typename")
            @ExcludeMissing
            _typename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("page_size") @ExcludeMissing pageSize: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("after") @ExcludeMissing after: JsonField<String> = JsonMissing.of(),
            @JsonProperty("before") @ExcludeMissing before: JsonField<String> = JsonMissing.of(),
        ) : this(_typename, pageSize, after, before, mutableMapOf())

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun _typename(): String = _typename.getRequired("__typename")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun pageSize(): Long = pageSize.getRequired("page_size")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun after(): Optional<String> = after.getOptional("after")

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun before(): Optional<String> = before.getOptional("before")

        /**
         * Returns the raw JSON value of [_typename].
         *
         * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

        /**
         * Returns the raw JSON value of [pageSize].
         *
         * Unlike [pageSize], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("page_size") @ExcludeMissing fun _pageSize(): JsonField<Long> = pageSize

        /**
         * Returns the raw JSON value of [after].
         *
         * Unlike [after], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("after") @ExcludeMissing fun _after(): JsonField<String> = after

        /**
         * Returns the raw JSON value of [before].
         *
         * Unlike [before], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("before") @ExcludeMissing fun _before(): JsonField<String> = before

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
             * ._typename()
             * .pageSize()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [PageInfo]. */
        class Builder internal constructor() {

            private var _typename: JsonField<String>? = null
            private var pageSize: JsonField<Long>? = null
            private var after: JsonField<String> = JsonMissing.of()
            private var before: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(pageInfo: PageInfo) = apply {
                _typename = pageInfo._typename
                pageSize = pageInfo.pageSize
                after = pageInfo.after
                before = pageInfo.before
                additionalProperties = pageInfo.additionalProperties.toMutableMap()
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

            fun pageSize(pageSize: Long) = pageSize(JsonField.of(pageSize))

            /**
             * Sets [Builder.pageSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pageSize] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pageSize(pageSize: JsonField<Long>) = apply { this.pageSize = pageSize }

            fun after(after: String?) = after(JsonField.ofNullable(after))

            /** Alias for calling [Builder.after] with `after.orElse(null)`. */
            fun after(after: Optional<String>) = after(after.getOrNull())

            /**
             * Sets [Builder.after] to an arbitrary JSON value.
             *
             * You should usually call [Builder.after] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun after(after: JsonField<String>) = apply { this.after = after }

            fun before(before: String?) = before(JsonField.ofNullable(before))

            /** Alias for calling [Builder.before] with `before.orElse(null)`. */
            fun before(before: Optional<String>) = before(before.getOrNull())

            /**
             * Sets [Builder.before] to an arbitrary JSON value.
             *
             * You should usually call [Builder.before] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun before(before: JsonField<String>) = apply { this.before = before }

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
             * ._typename()
             * .pageSize()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): PageInfo =
                PageInfo(
                    checkRequired("_typename", _typename),
                    checkRequired("pageSize", pageSize),
                    after,
                    before,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): PageInfo = apply {
            if (validated) {
                return@apply
            }

            _typename()
            pageSize()
            after()
            before()
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
                (if (pageSize.asKnown().isPresent) 1 else 0) +
                (if (after.asKnown().isPresent) 1 else 0) +
                (if (before.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is PageInfo && _typename == other._typename && pageSize == other.pageSize && after == other.after && before == other.before && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(_typename, pageSize, after, before, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "PageInfo{_typename=$_typename, pageSize=$pageSize, after=$after, before=$before, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListSchedulesPageResponse && entries == other.entries && pageInfo == other.pageInfo && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(entries, pageInfo, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ObjectListSchedulesPageResponse{entries=$entries, pageInfo=$pageInfo, additionalProperties=$additionalProperties}"
}
