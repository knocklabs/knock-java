// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

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
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/** A response containing a list of audience members */
@NoAutoDetect
class AudienceListMembersResponse
@JsonCreator
private constructor(
    @JsonProperty("entries")
    @ExcludeMissing
    private val entries: JsonField<List<Entry>> = JsonMissing.of(),
    @JsonProperty("page_info")
    @ExcludeMissing
    private val pageInfo: JsonField<PageInfo> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun entries(): List<Entry> = entries.getRequired("entries")

    /** The information about a paginated result */
    fun pageInfo(): PageInfo = pageInfo.getRequired("page_info")

    @JsonProperty("entries") @ExcludeMissing fun _entries(): JsonField<List<Entry>> = entries

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

        private var entries: JsonField<MutableList<Entry>>? = null
        private var pageInfo: JsonField<PageInfo>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(audienceListMembersResponse: AudienceListMembersResponse) = apply {
            entries = audienceListMembersResponse.entries.map { it.toMutableList() }
            pageInfo = audienceListMembersResponse.pageInfo
            additionalProperties = audienceListMembersResponse.additionalProperties.toMutableMap()
        }

        fun entries(entries: List<Entry>) = entries(JsonField.of(entries))

        fun entries(entries: JsonField<List<Entry>>) = apply {
            this.entries = entries.map { it.toMutableList() }
        }

        fun addEntry(entry: Entry) = apply {
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

    /** A user belonging to an audience */
    @NoAutoDetect
    class Entry
    @JsonCreator
    private constructor(
        @JsonProperty("__typename")
        @ExcludeMissing
        private val _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("added_at")
        @ExcludeMissing
        private val addedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("user") @ExcludeMissing private val user: JsonField<User> = JsonMissing.of(),
        @JsonProperty("user_id")
        @ExcludeMissing
        private val userId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("tenant")
        @ExcludeMissing
        private val tenant: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun _typename(): String = _typename.getRequired("__typename")

        fun addedAt(): OffsetDateTime = addedAt.getRequired("added_at")

        /** A user object */
        fun user(): User = user.getRequired("user")

        fun userId(): String = userId.getRequired("user_id")

        fun tenant(): Optional<String> = Optional.ofNullable(tenant.getNullable("tenant"))

        @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

        @JsonProperty("added_at")
        @ExcludeMissing
        fun _addedAt(): JsonField<OffsetDateTime> = addedAt

        /** A user object */
        @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<User> = user

        @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

        @JsonProperty("tenant") @ExcludeMissing fun _tenant(): JsonField<String> = tenant

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Entry = apply {
            if (validated) {
                return@apply
            }

            _typename()
            addedAt()
            user().validate()
            userId()
            tenant()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Entry].
             *
             * The following fields are required:
             * ```java
             * ._typename()
             * .addedAt()
             * .user()
             * .userId()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Entry]. */
        class Builder internal constructor() {

            private var _typename: JsonField<String>? = null
            private var addedAt: JsonField<OffsetDateTime>? = null
            private var user: JsonField<User>? = null
            private var userId: JsonField<String>? = null
            private var tenant: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(entry: Entry) = apply {
                _typename = entry._typename
                addedAt = entry.addedAt
                user = entry.user
                userId = entry.userId
                tenant = entry.tenant
                additionalProperties = entry.additionalProperties.toMutableMap()
            }

            fun _typename(_typename: String) = _typename(JsonField.of(_typename))

            fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

            fun addedAt(addedAt: OffsetDateTime) = addedAt(JsonField.of(addedAt))

            fun addedAt(addedAt: JsonField<OffsetDateTime>) = apply { this.addedAt = addedAt }

            /** A user object */
            fun user(user: User) = user(JsonField.of(user))

            /** A user object */
            fun user(user: JsonField<User>) = apply { this.user = user }

            fun userId(userId: String) = userId(JsonField.of(userId))

            fun userId(userId: JsonField<String>) = apply { this.userId = userId }

            fun tenant(tenant: String?) = tenant(JsonField.ofNullable(tenant))

            fun tenant(tenant: Optional<String>) = tenant(tenant.orElse(null))

            fun tenant(tenant: JsonField<String>) = apply { this.tenant = tenant }

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

            fun build(): Entry =
                Entry(
                    checkRequired("_typename", _typename),
                    checkRequired("addedAt", addedAt),
                    checkRequired("user", user),
                    checkRequired("userId", userId),
                    tenant,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Entry && _typename == other._typename && addedAt == other.addedAt && user == other.user && userId == other.userId && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(_typename, addedAt, user, userId, tenant, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Entry{_typename=$_typename, addedAt=$addedAt, user=$user, userId=$userId, tenant=$tenant, additionalProperties=$additionalProperties}"
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

            fun after(after: Optional<String>) = after(after.orElse(null))

            fun after(after: JsonField<String>) = apply { this.after = after }

            fun before(before: String?) = before(JsonField.ofNullable(before))

            fun before(before: Optional<String>) = before(before.orElse(null))

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
