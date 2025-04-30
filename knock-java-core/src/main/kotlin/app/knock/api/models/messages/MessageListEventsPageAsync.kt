// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.checkRequired
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.MessageServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [MessageServiceAsync.listEvents] */
class MessageListEventsPageAsync
private constructor(
    private val service: MessageServiceAsync,
    private val params: MessageListEventsParams,
    private val response: MessageListEventsPageResponse,
) {

    /**
     * Delegates to [MessageListEventsPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListEventsPageResponse.entries]
     */
    fun entries(): List<MessageEvent> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListEventsPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListEventsPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<MessageListEventsParams> {
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

    fun getNextPage(): CompletableFuture<Optional<MessageListEventsPageAsync>> =
        getNextPageParams()
            .map { service.listEvents(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): MessageListEventsParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListEventsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageListEventsPageAsync].
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

    /** A builder for [MessageListEventsPageAsync]. */
    class Builder internal constructor() {

        private var service: MessageServiceAsync? = null
        private var params: MessageListEventsParams? = null
        private var response: MessageListEventsPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListEventsPageAsync: MessageListEventsPageAsync) = apply {
            service = messageListEventsPageAsync.service
            params = messageListEventsPageAsync.params
            response = messageListEventsPageAsync.response
        }

        fun service(service: MessageServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListEventsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListEventsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MessageListEventsPageAsync].
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
        fun build(): MessageListEventsPageAsync =
            MessageListEventsPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: MessageListEventsPageAsync) {

        fun forEach(action: Predicate<MessageEvent>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<MessageListEventsPageAsync>>.forEach(
                action: (MessageEvent) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.entries().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<MessageEvent>> {
            val values = mutableListOf<MessageEvent>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListEventsPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "MessageListEventsPageAsync{service=$service, params=$params, response=$response}"
}
