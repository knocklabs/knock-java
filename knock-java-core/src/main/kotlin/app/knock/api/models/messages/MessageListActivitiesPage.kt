// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.MessageService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [MessageService.listActivities] */
class MessageListActivitiesPage
private constructor(
    private val service: MessageService,
    private val params: MessageListActivitiesParams,
    private val response: MessageListActivitiesPageResponse,
) : Page<Activity> {

    /**
     * Delegates to [MessageListActivitiesPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListActivitiesPageResponse.items]
     */
    override fun items(): List<Activity> =
        response._items().getOptional("items").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListActivitiesPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListActivitiesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): MessageListActivitiesParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): MessageListActivitiesPage = service.listActivities(nextPageParams())

    fun autoPager(): AutoPager<Activity> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): MessageListActivitiesParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListActivitiesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageListActivitiesPage].
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

    /** A builder for [MessageListActivitiesPage]. */
    class Builder internal constructor() {

        private var service: MessageService? = null
        private var params: MessageListActivitiesParams? = null
        private var response: MessageListActivitiesPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListActivitiesPage: MessageListActivitiesPage) = apply {
            service = messageListActivitiesPage.service
            params = messageListActivitiesPage.params
            response = messageListActivitiesPage.response
        }

        fun service(service: MessageService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListActivitiesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListActivitiesPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [MessageListActivitiesPage].
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
        fun build(): MessageListActivitiesPage =
            MessageListActivitiesPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListActivitiesPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "MessageListActivitiesPage{service=$service, params=$params, response=$response}"
}
