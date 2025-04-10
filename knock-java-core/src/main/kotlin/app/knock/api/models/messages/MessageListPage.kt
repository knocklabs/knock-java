// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.checkRequired
import app.knock.api.services.blocking.MessageService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [MessageService.list] */
class MessageListPage
private constructor(
    private val service: MessageService,
    private val params: MessageListParams,
    private val response: MessageListPageResponse,
) {

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListPageResponse.entries]
     */
    fun entries(): List<Message> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<MessageListPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<MessageListParams> {
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

    fun getNextPage(): Optional<MessageListPage> = getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): MessageListParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageListPage].
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

    /** A builder for [MessageListPage]. */
    class Builder internal constructor() {

        private var service: MessageService? = null
        private var params: MessageListParams? = null
        private var response: MessageListPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListPage: MessageListPage) = apply {
            service = messageListPage.service
            params = messageListPage.params
            response = messageListPage.response
        }

        fun service(service: MessageService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MessageListPage].
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
        fun build(): MessageListPage =
            MessageListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: MessageListPage) : Iterable<Message> {

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

        return /* spotless:off */ other is MessageListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "MessageListPage{service=$service, params=$params, response=$response}"
}
