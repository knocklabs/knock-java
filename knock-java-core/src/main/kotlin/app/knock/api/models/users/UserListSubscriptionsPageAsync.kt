// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.checkRequired
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.async.UserServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [UserServiceAsync.listSubscriptions] */
class UserListSubscriptionsPageAsync
private constructor(
    private val service: UserServiceAsync,
    private val params: UserListSubscriptionsParams,
    private val response: UserListSubscriptionsPageResponse,
) {

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
    fun pageInfo(): Optional<UserListSubscriptionsPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<UserListSubscriptionsParams> {
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

    fun getNextPage(): CompletableFuture<Optional<UserListSubscriptionsPageAsync>> =
        getNextPageParams()
            .map { service.listSubscriptions(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

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
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserListSubscriptionsPageAsync]. */
    class Builder internal constructor() {

        private var service: UserServiceAsync? = null
        private var params: UserListSubscriptionsParams? = null
        private var response: UserListSubscriptionsPageResponse? = null

        @JvmSynthetic
        internal fun from(userListSubscriptionsPageAsync: UserListSubscriptionsPageAsync) = apply {
            service = userListSubscriptionsPageAsync.service
            params = userListSubscriptionsPageAsync.params
            response = userListSubscriptionsPageAsync.response
        }

        fun service(service: UserServiceAsync) = apply { this.service = service }

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
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserListSubscriptionsPageAsync =
            UserListSubscriptionsPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: UserListSubscriptionsPageAsync) {

        fun forEach(action: Predicate<Subscription>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<UserListSubscriptionsPageAsync>>.forEach(
                action: (Subscription) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Subscription>> {
            val values = mutableListOf<Subscription>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListSubscriptionsPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "UserListSubscriptionsPageAsync{service=$service, params=$params, response=$response}"
}
