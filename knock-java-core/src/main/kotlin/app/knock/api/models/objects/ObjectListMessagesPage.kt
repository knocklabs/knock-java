// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.messages.Message
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.ObjectService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectService.listMessages] */
class ObjectListMessagesPage
private constructor(
    private val service: ObjectService,
    private val params: ObjectListMessagesParams,
    private val response: ObjectListMessagesPageResponse,
) : Page<Message> {

    /**
     * Delegates to [ObjectListMessagesPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListMessagesPageResponse.entries]
     */
    fun entries(): List<Message> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ObjectListMessagesPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListMessagesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<Message> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): ObjectListMessagesParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): ObjectListMessagesPage = service.listMessages(nextPageParams())

    fun autoPager(): AutoPager<Message> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ObjectListMessagesParams = params

    /** The response that this page was parsed from. */
    fun response(): ObjectListMessagesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectListMessagesPage].
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

    /** A builder for [ObjectListMessagesPage]. */
    class Builder internal constructor() {

        private var service: ObjectService? = null
        private var params: ObjectListMessagesParams? = null
        private var response: ObjectListMessagesPageResponse? = null

        @JvmSynthetic
        internal fun from(objectListMessagesPage: ObjectListMessagesPage) = apply {
            service = objectListMessagesPage.service
            params = objectListMessagesPage.params
            response = objectListMessagesPage.response
        }

        fun service(service: ObjectService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ObjectListMessagesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ObjectListMessagesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ObjectListMessagesPage].
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
        fun build(): ObjectListMessagesPage =
            ObjectListMessagesPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListMessagesPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListMessagesPage{service=$service, params=$params, response=$response}"
}
