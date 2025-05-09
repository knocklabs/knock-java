// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.UserServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [UserServiceAsync.listSchedules] */
class UserListSchedulesPageAsync
private constructor(
    private val service: UserServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: UserListSchedulesParams,
    private val response: UserListSchedulesPageResponse,
) : PageAsync<Schedule> {

    /**
     * Delegates to [UserListSchedulesPageResponse], but gracefully handles missing data.
     *
     * @see [UserListSchedulesPageResponse.entries]
     */
    fun entries(): List<Schedule> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [UserListSchedulesPageResponse], but gracefully handles missing data.
     *
     * @see [UserListSchedulesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<Schedule> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): UserListSchedulesParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<UserListSchedulesPageAsync> =
        service.listSchedules(nextPageParams())

    fun autoPager(): AutoPagerAsync<Schedule> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): UserListSchedulesParams = params

    /** The response that this page was parsed from. */
    fun response(): UserListSchedulesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserListSchedulesPageAsync].
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

    /** A builder for [UserListSchedulesPageAsync]. */
    class Builder internal constructor() {

        private var service: UserServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: UserListSchedulesParams? = null
        private var response: UserListSchedulesPageResponse? = null

        @JvmSynthetic
        internal fun from(userListSchedulesPageAsync: UserListSchedulesPageAsync) = apply {
            service = userListSchedulesPageAsync.service
            streamHandlerExecutor = userListSchedulesPageAsync.streamHandlerExecutor
            params = userListSchedulesPageAsync.params
            response = userListSchedulesPageAsync.response
        }

        fun service(service: UserServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: UserListSchedulesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: UserListSchedulesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [UserListSchedulesPageAsync].
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
        fun build(): UserListSchedulesPageAsync =
            UserListSchedulesPageAsync(
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

        return /* spotless:off */ other is UserListSchedulesPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "UserListSchedulesPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
