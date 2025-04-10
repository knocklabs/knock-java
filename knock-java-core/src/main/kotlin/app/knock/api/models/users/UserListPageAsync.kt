// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.services.async.UserServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List users */
class UserListPageAsync
private constructor(
    private val usersService: UserServiceAsync,
    private val params: UserListParams,
    private val response: UserListPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): UserListPageResponse = response

    /**
     * Delegates to [UserListPageResponse], but gracefully handles missing data.
     *
     * @see [UserListPageResponse.entries]
     */
    fun entries(): List<User> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [UserListPageResponse], but gracefully handles missing data.
     *
     * @see [UserListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<UserListPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListPageAsync && usersService == other.usersService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(usersService, params, response) /* spotless:on */

    override fun toString() =
        "UserListPageAsync{usersService=$usersService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<UserListParams> {
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

    fun getNextPage(): CompletableFuture<Optional<UserListPageAsync>> {
        return getNextPageParams()
            .map { usersService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            usersService: UserServiceAsync,
            params: UserListParams,
            response: UserListPageResponse,
        ) = UserListPageAsync(usersService, params, response)
    }

    class AutoPager(private val firstPage: UserListPageAsync) {

        fun forEach(action: Predicate<User>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<UserListPageAsync>>.forEach(
                action: (User) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<User>> {
            val values = mutableListOf<User>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
