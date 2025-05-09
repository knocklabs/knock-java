// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.UserServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [UserServiceAsync.listSubscriptions] */
class UserListSubscriptionsPageAsync
private constructor(
    private val service: UserServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: UserListSubscriptionsParams,
    private val response: UserListSubscriptionsPageResponse,
) : PageAsync<Subscription> {

    /**
     * Delegates to [UserListSubscriptionsPageResponse], but gracefully handles missing data.
     *
     * @see [UserListSubscriptionsPageResponse.entries]
     */
    fun entries(): List<Subscription> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [UserListSubscriptionsPageResponse], but gracefully handles missing data.
     *
     * @see [UserListSubscriptionsPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<Subscription> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): UserListSubscriptionsParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<UserListSubscriptionsPageAsync> =
        service.listSubscriptions(nextPageParams())

    fun autoPager(): AutoPagerAsync<Subscription> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): UserListSubscriptionsParams = params

    /** The response that this page was parsed from. */
    fun response(): UserListSubscriptionsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [UserListSubscriptionsPageAsync].
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

    /** A builder for [UserListSubscriptionsPageAsync]. */
    class Builder internal constructor() {

        private var service: UserServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: UserListSubscriptionsParams? = null
        private var response: UserListSubscriptionsPageResponse? = null

        @JvmSynthetic
        internal fun from(userListSubscriptionsPageAsync: UserListSubscriptionsPageAsync) = apply {
            service = userListSubscriptionsPageAsync.service
            streamHandlerExecutor = userListSubscriptionsPageAsync.streamHandlerExecutor
            params = userListSubscriptionsPageAsync.params
            response = userListSubscriptionsPageAsync.response
        }

        fun service(service: UserServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: UserListSubscriptionsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: UserListSubscriptionsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [UserListSubscriptionsPageAsync].
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
        fun build(): UserListSubscriptionsPageAsync =
            UserListSubscriptionsPageAsync(
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

        return /* spotless:off */ other is UserListSubscriptionsPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "UserListSubscriptionsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
