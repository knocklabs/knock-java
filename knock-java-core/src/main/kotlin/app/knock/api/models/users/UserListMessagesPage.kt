// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.messages.Message
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.UserService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [UserService.listMessages] */
class UserListMessagesPage
private constructor(
    private val service: UserService,
    private val params: UserListMessagesParams,
    private val response: UserListMessagesPageResponse,
) : Page<Message> {

    /**
     * Delegates to [UserListMessagesPageResponse], but gracefully handles missing data.
     *
     * @see [UserListMessagesPageResponse.items]
     */
    override fun items(): List<Message> =
        response._items().getOptional("items").getOrNull() ?: emptyList()

    /**
     * Delegates to [UserListMessagesPageResponse], but gracefully handles missing data.
     *
     * @see [UserListMessagesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): UserListMessagesParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): UserListMessagesPage = service.listMessages(nextPageParams())

    fun autoPager(): AutoPager<Message> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): UserListMessagesParams = params

    /** The response that this page was parsed from. */
    fun response(): UserListMessagesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserListMessagesPage].
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

    /** A builder for [UserListMessagesPage]. */
    class Builder internal constructor() {

        private var service: UserService? = null
        private var params: UserListMessagesParams? = null
        private var response: UserListMessagesPageResponse? = null

        @JvmSynthetic
        internal fun from(userListMessagesPage: UserListMessagesPage) = apply {
            service = userListMessagesPage.service
            params = userListMessagesPage.params
            response = userListMessagesPage.response
        }

        fun service(service: UserService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: UserListMessagesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: UserListMessagesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [UserListMessagesPage].
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
        fun build(): UserListMessagesPage =
            UserListMessagesPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserListMessagesPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "UserListMessagesPage{service=$service, params=$params, response=$response}"
}
