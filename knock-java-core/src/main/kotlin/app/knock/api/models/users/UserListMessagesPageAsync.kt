// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.checkRequired
import app.knock.api.models.messages.Message
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.UserServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [UserServiceAsync.listMessages] */
class UserListMessagesPageAsync
private constructor(
    private val service: UserServiceAsync,
    private val params: UserListMessagesParams,
    private val response: UserListMessagesPageResponse,
) {

    /**
     * Delegates to [UserListMessagesPageResponse], but gracefully handles missing data.
     *
     * @see [UserListMessagesPageResponse.entries]
     */
    fun entries(): List<Message> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [UserListMessagesPageResponse], but gracefully handles missing data.
     *
     * @see [UserListMessagesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<UserListMessagesParams> {
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

    fun getNextPage(): CompletableFuture<Optional<UserListMessagesPageAsync>> =
        getNextPageParams()
            .map { service.listMessages(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

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
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserListMessagesPageAsync]. */
    class Builder internal constructor() {

        private var service: UserServiceAsync? = null
        private var params: UserListMessagesParams? = null
        private var response: UserListMessagesPageResponse? = null

        @JvmSynthetic
        internal fun from(userListMessagesPageAsync: UserListMessagesPageAsync) = apply {
            service = userListMessagesPageAsync.service
            params = userListMessagesPageAsync.params
            response = userListMessagesPageAsync.response
        }

        fun service(service: UserServiceAsync) = apply { this.service = service }

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
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserListMessagesPageAsync =
            UserListMessagesPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: UserListMessagesPageAsync) {

        fun forEach(action: Predicate<Message>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<UserListMessagesPageAsync>>.forEach(
                action: (Message) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.entries().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<Message>> {
            val values = mutableListOf<Message>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListMessagesPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "UserListMessagesPageAsync{service=$service, params=$params, response=$response}"
}
