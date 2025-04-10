// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.models.schedules.Schedule
import app.knock.api.services.blocking.UserService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List schedules */
class UserListSchedulesPage
private constructor(
    private val usersService: UserService,
    private val params: UserListSchedulesParams,
    private val response: UserListSchedulesPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): UserListSchedulesPageResponse = response

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
    fun pageInfo(): Optional<UserListSchedulesPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListSchedulesPage && usersService == other.usersService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(usersService, params, response) /* spotless:on */

    override fun toString() =
        "UserListSchedulesPage{usersService=$usersService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<UserListSchedulesPage> {
        return getNextPageParams().map { usersService.listSchedules(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            usersService: UserService,
            params: UserListSchedulesParams,
            response: UserListSchedulesPageResponse,
        ) = UserListSchedulesPage(usersService, params, response)
    }

    class AutoPager(private val firstPage: UserListSchedulesPage) : Iterable<Schedule> {

        override fun iterator(): Iterator<Schedule> = iterator {
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

        fun stream(): Stream<Schedule> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
