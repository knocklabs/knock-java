// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.services.blocking.UserService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List users */
class UserListPage
private constructor(
    private val usersService: UserService,
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

        return /* spotless:off */ other is UserListPage && usersService == other.usersService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(usersService, params, response) /* spotless:on */

    override fun toString() =
        "UserListPage{usersService=$usersService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<UserListPage> {
        return getNextPageParams().map { usersService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(usersService: UserService, params: UserListParams, response: UserListPageResponse) =
            UserListPage(usersService, params, response)
    }

    class AutoPager(private val firstPage: UserListPage) : Iterable<User> {

        override fun iterator(): Iterator<User> = iterator {
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

        fun stream(): Stream<User> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
