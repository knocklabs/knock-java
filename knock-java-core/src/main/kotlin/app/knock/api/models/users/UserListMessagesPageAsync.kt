// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.models.messages.Message
import app.knock.api.services.async.UserServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List messages */
class UserListMessagesPageAsync
private constructor(
    private val usersService: UserServiceAsync,
    private val params: UserListMessagesParams,
    private val response: UserListMessagesPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): UserListMessagesPageResponse = response

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
    fun pageInfo(): Optional<UserListMessagesPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListMessagesPageAsync && usersService == other.usersService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(usersService, params, response) /* spotless:on */

    override fun toString() =
        "UserListMessagesPageAsync{usersService=$usersService, params=$params, response=$response}"

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

    fun getNextPage(): CompletableFuture<Optional<UserListMessagesPageAsync>> {
        return getNextPageParams()
            .map { usersService.listMessages(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            usersService: UserServiceAsync,
            params: UserListMessagesParams,
            response: UserListMessagesPageResponse,
        ) = UserListMessagesPageAsync(usersService, params, response)
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
}
