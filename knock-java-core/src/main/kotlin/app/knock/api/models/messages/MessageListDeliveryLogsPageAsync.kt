// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.checkRequired
import app.knock.api.services.async.MessageServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [MessageServiceAsync.listDeliveryLogs] */
class MessageListDeliveryLogsPageAsync
private constructor(
    private val service: MessageServiceAsync,
    private val params: MessageListDeliveryLogsParams,
    private val response: MessageListDeliveryLogsPageResponse,
) {

    /**
     * Delegates to [MessageListDeliveryLogsPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListDeliveryLogsPageResponse.entries]
     */
    fun entries(): List<MessageDeliveryLog> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListDeliveryLogsPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListDeliveryLogsPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<MessageListDeliveryLogsPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<MessageListDeliveryLogsParams> {
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

    fun getNextPage(): CompletableFuture<Optional<MessageListDeliveryLogsPageAsync>> =
        getNextPageParams()
            .map { service.listDeliveryLogs(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): MessageListDeliveryLogsParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListDeliveryLogsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [MessageListDeliveryLogsPageAsync].
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

    /** A builder for [MessageListDeliveryLogsPageAsync]. */
    class Builder internal constructor() {

        private var service: MessageServiceAsync? = null
        private var params: MessageListDeliveryLogsParams? = null
        private var response: MessageListDeliveryLogsPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListDeliveryLogsPageAsync: MessageListDeliveryLogsPageAsync) =
            apply {
                service = messageListDeliveryLogsPageAsync.service
                params = messageListDeliveryLogsPageAsync.params
                response = messageListDeliveryLogsPageAsync.response
            }

        fun service(service: MessageServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListDeliveryLogsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListDeliveryLogsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [MessageListDeliveryLogsPageAsync].
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
        fun build(): MessageListDeliveryLogsPageAsync =
            MessageListDeliveryLogsPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: MessageListDeliveryLogsPageAsync) {

        fun forEach(
            action: Predicate<MessageDeliveryLog>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<MessageListDeliveryLogsPageAsync>>.forEach(
                action: (MessageDeliveryLog) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<MessageDeliveryLog>> {
            val values = mutableListOf<MessageDeliveryLog>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListDeliveryLogsPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "MessageListDeliveryLogsPageAsync{service=$service, params=$params, response=$response}"
}
