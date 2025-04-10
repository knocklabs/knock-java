// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.checkRequired
import app.knock.api.models.messages.Message
import app.knock.api.services.blocking.UserService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [UserService.listMessages] */
class UserListMessagesPage
private constructor(
    private val service: UserService,
    private val params: UserListMessagesParams,
    private val response: UserListMessagesPageResponse,
) {

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

    fun getNextPage(): Optional<UserListMessagesPage> =
        getNextPageParams().map { service.listMessages(it) }

    fun autoPager(): AutoPager = AutoPager(this)

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
