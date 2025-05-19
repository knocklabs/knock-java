// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages.activities

import app.knock.api.core.checkRequired
import app.knock.api.models.messages.Activity
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.messages.ActivityService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [ActivityService.list] */
class ActivityListPage
private constructor(
    private val service: ActivityService,
    private val params: ActivityListParams,
    private val response: ActivityListPageResponse,
) {

    /**
     * Delegates to [ActivityListPageResponse], but gracefully handles missing data.
     *
     * @see [ActivityListPageResponse.items]
     */
    fun items(): List<Activity> = response._items().getOptional("items").getOrNull() ?: emptyList()

    /**
     * Delegates to [ActivityListPageResponse], but gracefully handles missing data.
     *
     * @see [ActivityListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ActivityListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params
                .toBuilder()
                .apply {
                    pageInfo().flatMap { it._after().getOptional("after") }.ifPresent { after(it) }
                }
                .build()
        )
    }

    fun getNextPage(): Optional<ActivityListPage> = getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

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

    class AutoPager(private val firstPage: ActivityListPage) : Iterable<Activity> {

        override fun iterator(): Iterator<Activity> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.items().size) {
                    yield(page.items()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<Activity> {
            return StreamSupport.stream(spliterator(), false)
        }
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
