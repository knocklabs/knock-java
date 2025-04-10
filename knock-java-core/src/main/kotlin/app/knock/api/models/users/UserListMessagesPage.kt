// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.models.messages.Message
import app.knock.api.services.blocking.UserService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List messages */
class UserListMessagesPage
private constructor(
    private val usersService: UserService,
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

        return /* spotless:off */ other is UserListMessagesPage && usersService == other.usersService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(usersService, params, response) /* spotless:on */

    override fun toString() =
        "UserListMessagesPage{usersService=$usersService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<UserListMessagesPage> {
        return getNextPageParams().map { usersService.listMessages(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            usersService: UserService,
            params: UserListMessagesParams,
            response: UserListMessagesPageResponse,
        ) = UserListMessagesPage(usersService, params, response)
    }

    class AutoPager(private val firstPage: UserListMessagesPage) : Iterable<Message> {

        override fun iterator(): Iterator<Message> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.entries().size) {
                    yield(page.entries()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<Message> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
