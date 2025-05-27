// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.messages.Message
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.UserServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [UserServiceAsync.listMessages] */
class UserListMessagesPageAsync
private constructor(
    private val service: UserServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: UserListMessagesParams,
    private val response: UserListMessagesPageResponse,
) : PageAsync<Message> {

    /**
     * Delegates to [UserListMessagesPageResponse], but gracefully handles missing data.
     *
     * @see [UserListMessagesPageResponse.items]
     */
    override fun items(): List<Message> =
        response._items().getOptional("items").getOrNull() ?: emptyList()

    /**
     * Delegates to [UserListMessagesPageResponse], but gracefully handles missing data.
     *
     * @see [UserListMessagesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): UserListMessagesParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<UserListMessagesPageAsync> =
        service.listMessages(nextPageParams())

    fun autoPager(): AutoPagerAsync<Message> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): UserListMessagesParams = params

    /** The response that this page was parsed from. */
    fun response(): UserListMessagesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserListMessagesPageAsync].
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

    /** A builder for [UserListMessagesPageAsync]. */
    class Builder internal constructor() {

        private var service: UserServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: UserListMessagesParams? = null
        private var response: UserListMessagesPageResponse? = null

        @JvmSynthetic
        internal fun from(userListMessagesPageAsync: UserListMessagesPageAsync) = apply {
            service = userListMessagesPageAsync.service
            streamHandlerExecutor = userListMessagesPageAsync.streamHandlerExecutor
            params = userListMessagesPageAsync.params
            response = userListMessagesPageAsync.response
        }

        fun service(service: UserServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: UserListMessagesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: UserListMessagesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [UserListMessagesPageAsync].
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
        fun build(): UserListMessagesPageAsync =
            UserListMessagesPageAsync(
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

        return /* spotless:off */ other is UserListMessagesPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "UserListMessagesPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
