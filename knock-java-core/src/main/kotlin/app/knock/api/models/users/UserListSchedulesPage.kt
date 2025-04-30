// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.checkRequired
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.UserService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [UserService.listSchedules] */
class UserListSchedulesPage
private constructor(
    private val service: UserService,
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

    fun getNextPage(): Optional<UserListSchedulesPage> =
        getNextPageParams().map { service.listSchedules(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): UserListSchedulesParams = params

    /** The response that this page was parsed from. */
    fun response(): UserListSchedulesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserListSchedulesPage].
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

    /** A builder for [UserListSchedulesPage]. */
    class Builder internal constructor() {

        private var service: UserService? = null
        private var params: UserListSchedulesParams? = null
        private var response: UserListSchedulesPageResponse? = null

        @JvmSynthetic
        internal fun from(userListSchedulesPage: UserListSchedulesPage) = apply {
            service = userListSchedulesPage.service
            params = userListSchedulesPage.params
            response = userListSchedulesPage.response
        }

        fun service(service: UserService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: UserListSchedulesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: UserListSchedulesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [UserListSchedulesPage].
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
        fun build(): UserListSchedulesPage =
            UserListSchedulesPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListSchedulesPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "UserListSchedulesPage{service=$service, params=$params, response=$response}"
}
