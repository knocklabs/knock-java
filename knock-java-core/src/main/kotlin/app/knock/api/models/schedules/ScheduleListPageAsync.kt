// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.schedules

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.ScheduleServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [ScheduleServiceAsync.list] */
class ScheduleListPageAsync
private constructor(
    private val service: ScheduleServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ScheduleListParams,
    private val response: ScheduleListPageResponse,
) : PageAsync<Schedule> {

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

    override fun nextPage(): CompletableFuture<ScheduleListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Schedule> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ScheduleListParams = params

    /** The response that this page was parsed from. */
    fun response(): ScheduleListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ScheduleListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ScheduleListPageAsync]. */
    class Builder internal constructor() {

        private var service: ScheduleServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ScheduleListParams? = null
        private var response: ScheduleListPageResponse? = null

        @JvmSynthetic
        internal fun from(scheduleListPageAsync: ScheduleListPageAsync) = apply {
            service = scheduleListPageAsync.service
            streamHandlerExecutor = scheduleListPageAsync.streamHandlerExecutor
            params = scheduleListPageAsync.params
            response = scheduleListPageAsync.response
        }

        fun service(service: ScheduleServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ScheduleListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ScheduleListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ScheduleListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ScheduleListPageAsync =
            ScheduleListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ScheduleListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "ScheduleListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
