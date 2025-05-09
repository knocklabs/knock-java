// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.UserService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [UserService.list] */
class UserListPage
private constructor(
    private val service: UserService,
    private val params: UserListParams,
    private val response: UserListPageResponse,
) : Page<User> {

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
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<User> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): UserListParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): UserListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<User> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): UserListParams = params

    /** The response that this page was parsed from. */
    fun response(): UserListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserListPage].
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

    /** A builder for [UserListPage]. */
    class Builder internal constructor() {

        private var service: UserService? = null
        private var params: UserListParams? = null
        private var response: UserListPageResponse? = null

        @JvmSynthetic
        internal fun from(userListPage: UserListPage) = apply {
            service = userListPage.service
            params = userListPage.params
            response = userListPage.response
        }

        fun service(service: UserService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: UserListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: UserListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [UserListPage].
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
        fun build(): UserListPage =
            UserListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() = "UserListPage{service=$service, params=$params, response=$response}"
}
