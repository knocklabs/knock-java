// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.users

import com.knock.api.core.NoAutoDetect
import com.knock.api.core.Params
import com.knock.api.core.checkRequired
import com.knock.api.core.http.Headers
import com.knock.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Get preference set */
class UserGetPreferencesParams private constructor(
    private val userId: String,
    private val preferenceSetId: String,
    private val tenant: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,

) : Params {

    fun userId(): String = userId

    fun preferenceSetId(): String = preferenceSetId

    /** Tenant ID */
    fun tenant(): Optional<String> = Optional.ofNullable(tenant)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams {
      val queryParams = QueryParams.builder()
      this.tenant?.let {
          queryParams.put(
            "tenant", listOf(it.toString())
          )
      }
      queryParams.putAll(additionalQueryParams)
      return queryParams.build()
    }

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> userId
          1 -> preferenceSetId
          else -> ""
      }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [UserGetPreferencesParams].
         *
         * The following fields are required:
         *
         * ```java
         * .userId()
         * .preferenceSetId()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [UserGetPreferencesParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var userId: String? = null
        private var preferenceSetId: String? = null
        private var tenant: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userGetPreferencesParams: UserGetPreferencesParams) =
            apply {
                userId = userGetPreferencesParams.userId
                preferenceSetId = userGetPreferencesParams.preferenceSetId
                tenant = userGetPreferencesParams.tenant
                additionalHeaders = userGetPreferencesParams.additionalHeaders.toBuilder()
                additionalQueryParams = userGetPreferencesParams.additionalQueryParams.toBuilder()
            }

        fun userId(userId: String) =
            apply {
                this.userId = userId
            }

        fun preferenceSetId(preferenceSetId: String) =
            apply {
                this.preferenceSetId = preferenceSetId
            }

        /** Tenant ID */
        fun tenant(tenant: String?) =
            apply {
                this.tenant = tenant
            }

        /** Tenant ID */
        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.clear()
                putAllAdditionalHeaders(additionalHeaders)
            }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.clear()
                putAllAdditionalHeaders(additionalHeaders)
            }

        fun putAdditionalHeader(name: String, value: String) =
            apply {
                additionalHeaders.put(name, value)
            }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) =
            apply {
                additionalHeaders.put(name, values)
            }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.putAll(additionalHeaders)
            }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.putAll(additionalHeaders)
            }

        fun replaceAdditionalHeaders(name: String, value: String) =
            apply {
                additionalHeaders.replace(name, value)
            }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) =
            apply {
                additionalHeaders.replace(name, values)
            }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.replaceAll(additionalHeaders)
            }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.replaceAll(additionalHeaders)
            }

        fun removeAdditionalHeaders(name: String) =
            apply {
                additionalHeaders.remove(name)
            }

        fun removeAllAdditionalHeaders(names: Set<String>) =
            apply {
                additionalHeaders.removeAll(names)
            }

        fun additionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.clear()
                putAllAdditionalQueryParams(additionalQueryParams)
            }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.clear()
                putAllAdditionalQueryParams(additionalQueryParams)
            }

        fun putAdditionalQueryParam(key: String, value: String) =
            apply {
                additionalQueryParams.put(key, value)
            }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) =
            apply {
                additionalQueryParams.put(key, values)
            }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) =
            apply {
                additionalQueryParams.replace(key, value)
            }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) =
            apply {
                additionalQueryParams.replace(key, values)
            }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) =
            apply {
                additionalQueryParams.remove(key)
            }

        fun removeAllAdditionalQueryParams(keys: Set<String>) =
            apply {
                additionalQueryParams.removeAll(keys)
            }

        fun build(): UserGetPreferencesParams =
            UserGetPreferencesParams(
              checkRequired(
                "userId", userId
              ),
              checkRequired(
                "preferenceSetId", preferenceSetId
              ),
              tenant,
              additionalHeaders.build(),
              additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is UserGetPreferencesParams && userId == other.userId && preferenceSetId == other.preferenceSetId && tenant == other.tenant && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, preferenceSetId, tenant, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() = "UserGetPreferencesParams{userId=$userId, preferenceSetId=$preferenceSetId, tenant=$tenant, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
