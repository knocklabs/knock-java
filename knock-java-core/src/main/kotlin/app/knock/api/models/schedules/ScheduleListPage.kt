// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.ScheduleService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [ScheduleService.list] */
class ScheduleListPage
private constructor(
    private val service: ScheduleService,
    private val params: ScheduleListParams,
    private val response: ScheduleListPageResponse,
) {

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

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ScheduleListParams> {
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

    fun getNextPage(): Optional<ScheduleListPage> = getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

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

    class AutoPager(private val firstPage: ScheduleListPage) : Iterable<Schedule> {

        override fun iterator(): Iterator<Schedule> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.entries().size) {
                    yield(page.entries()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<Schedule> {
            return StreamSupport.stream(spliterator(), false)
        }
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
