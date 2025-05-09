// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.UserService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [UserService.listSubscriptions] */
class UserListSubscriptionsPage
private constructor(
    private val service: UserService,
    private val params: UserListSubscriptionsParams,
    private val response: UserListSubscriptionsPageResponse,
) : Page<Subscription> {

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
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<Subscription> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): UserListSubscriptionsParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): UserListSubscriptionsPage = service.listSubscriptions(nextPageParams())

    fun autoPager(): AutoPager<Subscription> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): UserListSubscriptionsParams = params

    /** The response that this page was parsed from. */
    fun response(): UserListSubscriptionsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserListSubscriptionsPage].
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

    /** A builder for [UserListSubscriptionsPage]. */
    class Builder internal constructor() {

        private var service: UserService? = null
        private var params: UserListSubscriptionsParams? = null
        private var response: UserListSubscriptionsPageResponse? = null

        @JvmSynthetic
        internal fun from(userListSubscriptionsPage: UserListSubscriptionsPage) = apply {
            service = userListSubscriptionsPage.service
            params = userListSubscriptionsPage.params
            response = userListSubscriptionsPage.response
        }

        fun service(service: UserService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: UserListSubscriptionsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: UserListSubscriptionsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [UserListSubscriptionsPage].
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
        fun build(): UserListSubscriptionsPage =
            UserListSubscriptionsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListSubscriptionsPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "UserListSubscriptionsPage{service=$service, params=$params, response=$response}"
}
