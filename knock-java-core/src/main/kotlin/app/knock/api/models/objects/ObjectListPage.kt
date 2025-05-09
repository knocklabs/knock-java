// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.ObjectService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectService.list] */
class ObjectListPage
private constructor(
    private val service: ObjectService,
    private val params: ObjectListParams,
    private val response: ObjectListPageResponse,
) : Page<Object> {

    /**
     * Delegates to [ObjectListPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListPageResponse.entries]
     */
    fun entries(): List<Object> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ObjectListPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<Object> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): ObjectListParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): ObjectListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Object> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ObjectListParams = params

    /** The response that this page was parsed from. */
    fun response(): ObjectListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ObjectListPage]. */
    class Builder internal constructor() {

        private var service: ObjectService? = null
        private var params: ObjectListParams? = null
        private var response: ObjectListPageResponse? = null

        @JvmSynthetic
        internal fun from(objectListPage: ObjectListPage) = apply {
            service = objectListPage.service
            params = objectListPage.params
            response = objectListPage.response
        }

        fun service(service: ObjectService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ObjectListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ObjectListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ObjectListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ObjectListPage =
            ObjectListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() = "ObjectListPage{service=$service, params=$params, response=$response}"
}
