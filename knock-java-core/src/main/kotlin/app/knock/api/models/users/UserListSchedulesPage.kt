// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.UserService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [UserService.listSchedules] */
class UserListSchedulesPage
private constructor(
    private val service: UserService,
    private val params: UserListSchedulesParams,
    private val response: UserListSchedulesPageResponse,
) : Page<Schedule> {

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

    override fun items(): List<Schedule> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): UserListSchedulesParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): UserListSchedulesPage = service.listSchedules(nextPageParams())

    fun autoPager(): AutoPager<Schedule> = AutoPager.from(this)

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
