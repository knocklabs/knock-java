// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages.activities

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.messages.Activity
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.messages.ActivityServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [ActivityServiceAsync.list] */
class ActivityListPageAsync
private constructor(
    private val service: ActivityServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ActivityListParams,
    private val response: ActivityListPageResponse,
) : PageAsync<Activity> {

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

    override fun nextPage(): CompletableFuture<ActivityListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Activity> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ActivityListParams = params

    /** The response that this page was parsed from. */
    fun response(): ActivityListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ActivityListPageAsync].
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

    /** A builder for [ActivityListPageAsync]. */
    class Builder internal constructor() {

        private var service: ActivityServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ActivityListParams? = null
        private var response: ActivityListPageResponse? = null

        @JvmSynthetic
        internal fun from(activityListPageAsync: ActivityListPageAsync) = apply {
            service = activityListPageAsync.service
            streamHandlerExecutor = activityListPageAsync.streamHandlerExecutor
            params = activityListPageAsync.params
            response = activityListPageAsync.response
        }

        fun service(service: ActivityServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ActivityListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ActivityListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ActivityListPageAsync].
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
        fun build(): ActivityListPageAsync =
            ActivityListPageAsync(
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

        return /* spotless:off */ other is ActivityListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "ActivityListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
