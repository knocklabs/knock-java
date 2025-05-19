// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.checkRequired
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.UserServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [UserServiceAsync.listSchedules] */
class UserListSchedulesPageAsync
private constructor(
    private val service: UserServiceAsync,
    private val params: UserListSchedulesParams,
    private val response: UserListSchedulesPageResponse,
) {

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

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<UserListSchedulesParams> {
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

    fun getNextPage(): CompletableFuture<Optional<UserListSchedulesPageAsync>> =
        getNextPageParams()
            .map { service.listSchedules(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

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
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserListSchedulesPageAsync]. */
    class Builder internal constructor() {

        private var service: UserServiceAsync? = null
        private var params: UserListSchedulesParams? = null
        private var response: UserListSchedulesPageResponse? = null

        @JvmSynthetic
        internal fun from(userListSchedulesPageAsync: UserListSchedulesPageAsync) = apply {
            service = userListSchedulesPageAsync.service
            params = userListSchedulesPageAsync.params
            response = userListSchedulesPageAsync.response
        }

        fun service(service: UserServiceAsync) = apply { this.service = service }

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
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserListSchedulesPageAsync =
            UserListSchedulesPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: UserListSchedulesPageAsync) {

        fun forEach(action: Predicate<Schedule>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<UserListSchedulesPageAsync>>.forEach(
                action: (Schedule) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Schedule>> {
            val values = mutableListOf<Schedule>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListSchedulesPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "UserListSchedulesPageAsync{service=$service, params=$params, response=$response}"
}
