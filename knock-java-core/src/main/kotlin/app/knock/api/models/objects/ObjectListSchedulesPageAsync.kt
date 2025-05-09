// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.ObjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectServiceAsync.listSchedules] */
class ObjectListSchedulesPageAsync
private constructor(
    private val service: ObjectServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ObjectListSchedulesParams,
    private val response: ObjectListSchedulesPageResponse,
) : PageAsync<Schedule> {

    /**
     * Delegates to [ObjectListSchedulesPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListSchedulesPageResponse.entries]
     */
    fun entries(): List<Schedule> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ObjectListSchedulesPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListSchedulesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<Schedule> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): ObjectListSchedulesParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ObjectListSchedulesPageAsync> =
        service.listSchedules(nextPageParams())

    fun autoPager(): AutoPagerAsync<Schedule> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ObjectListSchedulesParams = params

    /** The response that this page was parsed from. */
    fun response(): ObjectListSchedulesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectListSchedulesPageAsync].
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

    /** A builder for [ObjectListSchedulesPageAsync]. */
    class Builder internal constructor() {

        private var service: ObjectServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ObjectListSchedulesParams? = null
        private var response: ObjectListSchedulesPageResponse? = null

        @JvmSynthetic
        internal fun from(objectListSchedulesPageAsync: ObjectListSchedulesPageAsync) = apply {
            service = objectListSchedulesPageAsync.service
            streamHandlerExecutor = objectListSchedulesPageAsync.streamHandlerExecutor
            params = objectListSchedulesPageAsync.params
            response = objectListSchedulesPageAsync.response
        }

        fun service(service: ObjectServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ObjectListSchedulesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ObjectListSchedulesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ObjectListSchedulesPageAsync].
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
        fun build(): ObjectListSchedulesPageAsync =
            ObjectListSchedulesPageAsync(
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

        return /* spotless:off */ other is ObjectListSchedulesPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListSchedulesPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
