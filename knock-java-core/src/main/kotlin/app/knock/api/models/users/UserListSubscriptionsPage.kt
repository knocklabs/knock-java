// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.blocking.UserService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List subscriptions */
class UserListSubscriptionsPage
private constructor(
    private val usersService: UserService,
    private val params: UserListSubscriptionsParams,
    private val response: UserListSubscriptionsPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): UserListSubscriptionsPageResponse = response

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListSubscriptionsPage && usersService == other.usersService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(usersService, params, response) /* spotless:on */

    override fun toString() =
        "UserListSubscriptionsPage{usersService=$usersService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<UserListSubscriptionsPage> {
        return getNextPageParams().map { usersService.listSubscriptions(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            usersService: UserService,
            params: UserListSubscriptionsParams,
            response: UserListSubscriptionsPageResponse,
        ) = UserListSubscriptionsPage(usersService, params, response)
    }

    class AutoPager(private val firstPage: UserListSubscriptionsPage) : Iterable<Subscription> {

        override fun iterator(): Iterator<Subscription> = iterator {
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

        fun stream(): Stream<Subscription> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
