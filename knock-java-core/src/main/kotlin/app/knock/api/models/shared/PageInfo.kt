// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.shared

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkRequired
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Pagination information for a list of resources. */
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
        @JsonProperty("__typename") @ExcludeMissing _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("page_size") @ExcludeMissing pageSize: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("after") @ExcludeMissing after: JsonField<String> = JsonMissing.of(),
        @JsonProperty("before") @ExcludeMissing before: JsonField<String> = JsonMissing.of(),
    ) : this(_typename, pageSize, after, before, mutableMapOf())

    /**
     * The typename of the schema.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): String = _typename.getRequired("__typename")

    /**
     * The number of items per page.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun pageSize(): Long = pageSize.getRequired("page_size")

    /**
     * The cursor to fetch entries after.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun after(): Optional<String> = after.getOptional("after")

    /**
     * The cursor to fetch entries before.
     *
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

        /** The typename of the schema. */
        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** The number of items per page. */
        fun pageSize(pageSize: Long) = pageSize(JsonField.of(pageSize))

        /**
         * Sets [Builder.pageSize] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pageSize] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun pageSize(pageSize: JsonField<Long>) = apply { this.pageSize = pageSize }

        /** The cursor to fetch entries after. */
        fun after(after: String?) = after(JsonField.ofNullable(after))

        /** Alias for calling [Builder.after] with `after.orElse(null)`. */
        fun after(after: Optional<String>) = after(after.getOrNull())

        /**
         * Sets [Builder.after] to an arbitrary JSON value.
         *
         * You should usually call [Builder.after] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun after(after: JsonField<String>) = apply { this.after = after }

        /** The cursor to fetch entries before. */
        fun before(before: String?) = before(JsonField.ofNullable(before))

        /** Alias for calling [Builder.before] with `before.orElse(null)`. */
        fun before(before: Optional<String>) = before(before.getOrNull())

        /**
         * Sets [Builder.before] to an arbitrary JSON value.
         *
         * You should usually call [Builder.before] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
     * Returns a score indicating how many valid values are contained in this object recursively.
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
