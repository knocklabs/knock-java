// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.knock.api.core.NoAutoDetect
import com.knock.api.core.Params
import com.knock.api.core.checkRequired
import com.knock.api.core.http.Headers
import com.knock.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional

/** List schedules */
class UserListSchedulesParams
private constructor(
    private val userId: String,
    private val after: String?,
    private val before: String?,
    private val pageSize: Long?,
    private val tenant: String?,
    private val workflow: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): String = userId

    /** The cursor to fetch entries after */
    fun after(): Optional<String> = Optional.ofNullable(after)

    /** The cursor to fetch entries before */
    fun before(): Optional<String> = Optional.ofNullable(before)

    /** The page size to fetch */
    fun pageSize(): Optional<Long> = Optional.ofNullable(pageSize)

    /** The ID of the tenant to list schedules for */
    fun tenant(): Optional<String> = Optional.ofNullable(tenant)

    /** The ID of the workflow to list schedules for */
    fun workflow(): Optional<String> = Optional.ofNullable(workflow)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams {
        val queryParams = QueryParams.builder()
        this.after?.let { queryParams.put("after", listOf(it.toString())) }
        this.before?.let { queryParams.put("before", listOf(it.toString())) }
        this.pageSize?.let { queryParams.put("page_size", listOf(it.toString())) }
        this.tenant?.let { queryParams.put("tenant", listOf(it.toString())) }
        this.workflow?.let { queryParams.put("workflow", listOf(it.toString())) }
        queryParams.putAll(additionalQueryParams)
        return queryParams.build()
    }

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> userId
            else -> ""
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserListSchedulesParams].
         *
         * The following fields are required:
         * ```java
         * .userId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserListSchedulesParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var userId: String? = null
        private var after: String? = null
        private var before: String? = null
        private var pageSize: Long? = null
        private var tenant: String? = null
        private var workflow: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userListSchedulesParams: UserListSchedulesParams) = apply {
            userId = userListSchedulesParams.userId
            after = userListSchedulesParams.after
            before = userListSchedulesParams.before
            pageSize = userListSchedulesParams.pageSize
            tenant = userListSchedulesParams.tenant
            workflow = userListSchedulesParams.workflow
            additionalHeaders = userListSchedulesParams.additionalHeaders.toBuilder()
            additionalQueryParams = userListSchedulesParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String) = apply { this.userId = userId }

        /** The cursor to fetch entries after */
        fun after(after: String?) = apply { this.after = after }

        /** The cursor to fetch entries after */
        fun after(after: Optional<String>) = after(after.orElse(null))

        /** The cursor to fetch entries before */
        fun before(before: String?) = apply { this.before = before }

        /** The cursor to fetch entries before */
        fun before(before: Optional<String>) = before(before.orElse(null))

        /** The page size to fetch */
        fun pageSize(pageSize: Long?) = apply { this.pageSize = pageSize }

        /** The page size to fetch */
        fun pageSize(pageSize: Long) = pageSize(pageSize as Long?)

        /** The page size to fetch */
        @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
        fun pageSize(pageSize: Optional<Long>) = pageSize(pageSize.orElse(null) as Long?)

        /** The ID of the tenant to list schedules for */
        fun tenant(tenant: String?) = apply { this.tenant = tenant }

        /** The ID of the tenant to list schedules for */
        fun tenant(tenant: Optional<String>) = tenant(tenant.orElse(null))

        /** The ID of the workflow to list schedules for */
        fun workflow(workflow: String?) = apply { this.workflow = workflow }

        /** The ID of the workflow to list schedules for */
        fun workflow(workflow: Optional<String>) = workflow(workflow.orElse(null))

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

        fun build(): UserListSchedulesParams =
            UserListSchedulesParams(
                checkRequired("userId", userId),
                after,
                before,
                pageSize,
                tenant,
                workflow,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListSchedulesParams && userId == other.userId && after == other.after && before == other.before && pageSize == other.pageSize && tenant == other.tenant && workflow == other.workflow && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, after, before, pageSize, tenant, workflow, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "UserListSchedulesParams{userId=$userId, after=$after, before=$before, pageSize=$pageSize, tenant=$tenant, workflow=$workflow, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
