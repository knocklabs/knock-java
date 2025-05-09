// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages.activities

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.messages.Activity
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.messages.ActivityService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [ActivityService.list] */
class ActivityListPage
private constructor(
    private val service: ActivityService,
    private val params: ActivityListParams,
    private val response: ActivityListPageResponse,
) : Page<Activity> {

    /**
     * Delegates to [ActivityListPageResponse], but gracefully handles missing data.
     *
     * @see [ActivityListPageResponse.items]
     */
    override fun items(): List<Activity> =
        response._items().getOptional("items").getOrNull() ?: emptyList()

    /**
     * Delegates to [ActivityListPageResponse], but gracefully handles missing data.
     *
     * @see [ActivityListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): ActivityListParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): ActivityListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Activity> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ActivityListParams = params

    /** The response that this page was parsed from. */
    fun response(): ActivityListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ActivityListPage].
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

    /** A builder for [ActivityListPage]. */
    class Builder internal constructor() {

        private var service: ActivityService? = null
        private var params: ActivityListParams? = null
        private var response: ActivityListPageResponse? = null

        @JvmSynthetic
        internal fun from(activityListPage: ActivityListPage) = apply {
            service = activityListPage.service
            params = activityListPage.params
            response = activityListPage.response
        }

        fun service(service: ActivityService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ActivityListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ActivityListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ActivityListPage].
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
        fun build(): ActivityListPage =
            ActivityListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ActivityListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ActivityListPage{service=$service, params=$params, response=$response}"
}
