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
import com.knock.api.core.Params
import com.knock.api.core.checkKnown
import com.knock.api.core.checkRequired
import com.knock.api.core.http.Headers
import com.knock.api.core.http.QueryParams
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import java.util.Objects
import java.util.Optional

/** Remove members */
class AudienceRemoveMembersParams
private constructor(
    private val key: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun key(): String = key

    fun members(): List<Member> = body.members()

    fun _members(): JsonField<List<Member>> = body._members()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> key
            else -> ""
        }
    }

    /** A request to remove members from an audience */
    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("members")
        @ExcludeMissing
        private val members: JsonField<List<Member>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun members(): List<Member> = members.getRequired("members")

        @JsonProperty("members") @ExcludeMissing fun _members(): JsonField<List<Member>> = members

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            members().forEach { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .members()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var members: JsonField<MutableList<Member>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                members = body.members.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun members(members: List<Member>) = members(JsonField.of(members))

            fun members(members: JsonField<List<Member>>) = apply {
                this.members = members.map { it.toMutableList() }
            }

            fun addMember(member: Member) = apply {
                members =
                    (members ?: JsonField.of(mutableListOf())).also {
                        checkKnown("members", it).add(member)
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
                    checkRequired("members", members).map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && members == other.members && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(members, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{members=$members, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AudienceRemoveMembersParams].
         *
         * The following fields are required:
         * ```java
         * .key()
         * .members()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AudienceRemoveMembersParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var key: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(audienceRemoveMembersParams: AudienceRemoveMembersParams) = apply {
            key = audienceRemoveMembersParams.key
            body = audienceRemoveMembersParams.body.toBuilder()
            additionalHeaders = audienceRemoveMembersParams.additionalHeaders.toBuilder()
            additionalQueryParams = audienceRemoveMembersParams.additionalQueryParams.toBuilder()
        }

        fun key(key: String) = apply { this.key = key }

        fun members(members: List<Member>) = apply { body.members(members) }

        fun members(members: JsonField<List<Member>>) = apply { body.members(members) }

        fun addMember(member: Member) = apply { body.addMember(member) }

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

        fun build(): AudienceRemoveMembersParams =
            AudienceRemoveMembersParams(
                checkRequired("key", key),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /** A request for an individual audience member */
    @NoAutoDetect
    class Member
    @JsonCreator
    private constructor(
        @JsonProperty("user")
        @ExcludeMissing
        private val user: JsonField<InlineIdentifyUserRequest> = JsonMissing.of(),
        @JsonProperty("tenant")
        @ExcludeMissing
        private val tenant: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert against the user you're supplying, replacing any properties specified.
         */
        fun user(): InlineIdentifyUserRequest = user.getRequired("user")

        fun tenant(): Optional<String> = Optional.ofNullable(tenant.getNullable("tenant"))

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert against the user you're supplying, replacing any properties specified.
         */
        @JsonProperty("user")
        @ExcludeMissing
        fun _user(): JsonField<InlineIdentifyUserRequest> = user

        @JsonProperty("tenant") @ExcludeMissing fun _tenant(): JsonField<String> = tenant

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Member = apply {
            if (validated) {
                return@apply
            }

            user().validate()
            tenant()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Member].
             *
             * The following fields are required:
             * ```java
             * .user()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Member]. */
        class Builder internal constructor() {

            private var user: JsonField<InlineIdentifyUserRequest>? = null
            private var tenant: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(member: Member) = apply {
                user = member.user
                tenant = member.tenant
                additionalProperties = member.additionalProperties.toMutableMap()
            }

            /**
             * A set of parameters to inline-identify a user with. Inline identifying the user will
             * ensure that the user is available before the request is executed in Knock. It will
             * perform an upsert against the user you're supplying, replacing any properties
             * specified.
             */
            fun user(user: InlineIdentifyUserRequest) = user(JsonField.of(user))

            /**
             * A set of parameters to inline-identify a user with. Inline identifying the user will
             * ensure that the user is available before the request is executed in Knock. It will
             * perform an upsert against the user you're supplying, replacing any properties
             * specified.
             */
            fun user(user: JsonField<InlineIdentifyUserRequest>) = apply { this.user = user }

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

            fun build(): Member =
                Member(checkRequired("user", user), tenant, additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Member && user == other.user && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(user, tenant, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Member{user=$user, tenant=$tenant, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AudienceRemoveMembersParams && key == other.key && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(key, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "AudienceRemoveMembersParams{key=$key, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
