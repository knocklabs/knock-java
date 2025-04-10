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

/** @see [MessageServiceAsync.listActivities] */
class MessageListActivitiesPageAsync
private constructor(
    private val service: MessageServiceAsync,
    private val params: MessageListActivitiesParams,
    private val response: MessageListActivitiesPageResponse,
) {

    /**
     * Delegates to [MessageListActivitiesPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListActivitiesPageResponse.items]
     */
    fun items(): List<Activity> = response._items().getOptional("items").getOrNull() ?: emptyList()

    /**
     * Delegates to [MessageListActivitiesPageResponse], but gracefully handles missing data.
     *
     * @see [MessageListActivitiesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<MessageListActivitiesPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

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

    fun getNextPage(): CompletableFuture<Optional<MessageListActivitiesPageAsync>> =
        getNextPageParams()
            .map { service.listActivities(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): MessageListActivitiesParams = params

    /** The response that this page was parsed from. */
    fun response(): MessageListActivitiesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [MessageListActivitiesPageAsync].
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

    /** A builder for [MessageListActivitiesPageAsync]. */
    class Builder internal constructor() {

        private var service: MessageServiceAsync? = null
        private var params: MessageListActivitiesParams? = null
        private var response: MessageListActivitiesPageResponse? = null

        @JvmSynthetic
        internal fun from(messageListActivitiesPageAsync: MessageListActivitiesPageAsync) = apply {
            service = messageListActivitiesPageAsync.service
            params = messageListActivitiesPageAsync.params
            response = messageListActivitiesPageAsync.response
        }

        fun service(service: MessageServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MessageListActivitiesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MessageListActivitiesPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [MessageListActivitiesPageAsync].
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
        fun build(): MessageListActivitiesPageAsync =
            MessageListActivitiesPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: MessageListActivitiesPageAsync) {

        fun forEach(action: Predicate<Activity>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<MessageListActivitiesPageAsync>>.forEach(
                action: (Activity) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.items().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<Activity>> {
            val values = mutableListOf<Activity>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListActivitiesPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "MessageListActivitiesPageAsync{service=$service, params=$params, response=$response}"
}
