// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.checkRequired
import app.knock.api.services.blocking.MessageService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [MessageService.listActivities] */
class MessageListActivitiesPage
private constructor(
    private val service: MessageService,
    private val params: MessageListActivitiesParams,
    private val response: MessageListActivitiesPageResponse,
) {

    /**
     * Delegates to [MessageListActivitiesPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListActivitiesPageResponse.entries]
     */
    fun entries(): List<Activity> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListActivitiesPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListActivitiesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<MessageListActivitiesPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<MessageListActivitiesParams> {
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

    fun getNextPage(): Optional<MessageListActivitiesPage> =
        getNextPageParams().map { service.listActivities(it) }

    fun autoPager(): AutoPager = AutoPager(this)

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

    class AutoPager(private val firstPage: MessageListActivitiesPage) : Iterable<Activity> {

        override fun iterator(): Iterator<Activity> = iterator {
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

        fun stream(): Stream<Activity> {
            return StreamSupport.stream(spliterator(), false)
        }
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
