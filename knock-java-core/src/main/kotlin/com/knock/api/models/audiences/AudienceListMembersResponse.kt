// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.audiences

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkKnown
import com.knock.api.core.checkRequired
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A response containing a list of audience members */
@NoAutoDetect
class AudienceListMembersResponse
@JsonCreator
private constructor(
    @JsonProperty("entries")
    @ExcludeMissing
    private val entries: JsonField<List<AudienceMember>> = JsonMissing.of(),
    @JsonProperty("page_info")
    @ExcludeMissing
    private val pageInfo: JsonField<PageInfo> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun entries(): List<AudienceMember> = entries.getRequired("entries")

    /** The information about a paginated result */
    fun pageInfo(): PageInfo = pageInfo.getRequired("page_info")

    @JsonProperty("entries")
    @ExcludeMissing
    fun _entries(): JsonField<List<AudienceMember>> = entries

    /** The information about a paginated result */
    @JsonProperty("page_info") @ExcludeMissing fun _pageInfo(): JsonField<PageInfo> = pageInfo

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): AudienceListMembersResponse = apply {
        if (validated) {
            return@apply
        }

        entries().forEach { it.validate() }
        pageInfo().validate()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AudienceListMembersResponse].
         *
         * The following fields are required:
         * ```java
         * .entries()
         * .pageInfo()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AudienceListMembersResponse]. */
    class Builder internal constructor() {

        private var entries: JsonField<MutableList<AudienceMember>>? = null
        private var pageInfo: JsonField<PageInfo>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(audienceListMembersResponse: AudienceListMembersResponse) = apply {
            entries = audienceListMembersResponse.entries.map { it.toMutableList() }
            pageInfo = audienceListMembersResponse.pageInfo
            additionalProperties = audienceListMembersResponse.additionalProperties.toMutableMap()
        }

        fun entries(entries: List<AudienceMember>) = entries(JsonField.of(entries))

        fun entries(entries: JsonField<List<AudienceMember>>) = apply {
            this.entries = entries.map { it.toMutableList() }
        }

        fun addEntry(entry: AudienceMember) = apply {
            entries =
                (entries ?: JsonField.of(mutableListOf())).also {
                    checkKnown("entries", it).add(entry)
                }
        }

        /** The information about a paginated result */
        fun pageInfo(pageInfo: PageInfo) = pageInfo(JsonField.of(pageInfo))

        /** The information about a paginated result */
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

        fun build(): AudienceListMembersResponse =
            AudienceListMembersResponse(
                checkRequired("entries", entries).map { it.toImmutable() },
                checkRequired("pageInfo", pageInfo),
                additionalProperties.toImmutable(),
            )
    }

    /** The information about a paginated result */
    @NoAutoDetect
    class PageInfo
    @JsonCreator
    private constructor(
        @JsonProperty("__typename")
        @ExcludeMissing
        private val _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("page_size")
        @ExcludeMissing
        private val pageSize: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("after")
        @ExcludeMissing
        private val after: JsonField<String> = JsonMissing.of(),
        @JsonProperty("before")
        @ExcludeMissing
        private val before: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun _typename(): String = _typename.getRequired("__typename")

        fun pageSize(): Long = pageSize.getRequired("page_size")

        fun after(): Optional<String> = Optional.ofNullable(after.getNullable("after"))

        fun before(): Optional<String> = Optional.ofNullable(before.getNullable("before"))

        @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

        @JsonProperty("page_size") @ExcludeMissing fun _pageSize(): JsonField<Long> = pageSize

        @JsonProperty("after") @ExcludeMissing fun _after(): JsonField<String> = after

        @JsonProperty("before") @ExcludeMissing fun _before(): JsonField<String> = before

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

            fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

            fun pageSize(pageSize: Long) = pageSize(JsonField.of(pageSize))

            fun pageSize(pageSize: JsonField<Long>) = apply { this.pageSize = pageSize }

            fun after(after: String?) = after(JsonField.ofNullable(after))

            fun after(after: Optional<String>) = after(after.getOrNull())

            fun after(after: JsonField<String>) = apply { this.after = after }

            fun before(before: String?) = before(JsonField.ofNullable(before))

            fun before(before: Optional<String>) = before(before.getOrNull())

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

            fun build(): PageInfo =
                PageInfo(
                    checkRequired("_typename", _typename),
                    checkRequired("pageSize", pageSize),
                    after,
                    before,
                    additionalProperties.toImmutable(),
                )
        }

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

        return /* spotless:off */ other is AudienceListMembersResponse && entries == other.entries && pageInfo == other.pageInfo && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(entries, pageInfo, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AudienceListMembersResponse{entries=$entries, pageInfo=$pageInfo, additionalProperties=$additionalProperties}"
}
