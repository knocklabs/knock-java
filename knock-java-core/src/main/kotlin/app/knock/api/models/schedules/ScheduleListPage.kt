// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.ScheduleService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [ScheduleService.list] */
class ScheduleListPage
private constructor(
    private val service: ScheduleService,
    private val params: ScheduleListParams,
    private val response: ScheduleListPageResponse,
) : Page<Schedule> {

    /**
     * Delegates to [ScheduleListPageResponse], but gracefully handles missing data.
     *
     * @see [ScheduleListPageResponse.entries]
     */
    fun entries(): List<Schedule> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ScheduleListPageResponse], but gracefully handles missing data.
     *
     * @see [ScheduleListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<Schedule> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): ScheduleListParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): ScheduleListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Schedule> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ScheduleListParams = params

    /** The response that this page was parsed from. */
    fun response(): ScheduleListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ScheduleListPage].
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

    /** A builder for [ScheduleListPage]. */
    class Builder internal constructor() {

        private var service: ScheduleService? = null
        private var params: ScheduleListParams? = null
        private var response: ScheduleListPageResponse? = null

        @JvmSynthetic
        internal fun from(scheduleListPage: ScheduleListPage) = apply {
            service = scheduleListPage.service
            params = scheduleListPage.params
            response = scheduleListPage.response
        }

        fun service(service: ScheduleService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ScheduleListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ScheduleListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ScheduleListPage].
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
        fun build(): ScheduleListPage =
            ScheduleListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ScheduleListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ScheduleListPage{service=$service, params=$params, response=$response}"
}
