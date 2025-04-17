// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.checkRequired
import app.knock.api.models.messages.Message
import app.knock.api.services.async.ObjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectServiceAsync.listMessages] */
class ObjectListMessagesPageAsync
private constructor(
    private val service: ObjectServiceAsync,
    private val params: ObjectListMessagesParams,
    private val response: ObjectListMessagesPageResponse,
) {

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
    fun pageInfo(): Optional<ObjectListMessagesPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ObjectListMessagesParams> {
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

    fun getNextPage(): CompletableFuture<Optional<ObjectListMessagesPageAsync>> =
        getNextPageParams()
            .map { service.listMessages(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ObjectListMessagesParams = params

    /** The response that this page was parsed from. */
    fun response(): ObjectListMessagesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectListMessagesPageAsync].
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

    /** A builder for [ObjectListMessagesPageAsync]. */
    class Builder internal constructor() {

        private var service: ObjectServiceAsync? = null
        private var params: ObjectListMessagesParams? = null
        private var response: ObjectListMessagesPageResponse? = null

        @JvmSynthetic
        internal fun from(objectListMessagesPageAsync: ObjectListMessagesPageAsync) = apply {
            service = objectListMessagesPageAsync.service
            params = objectListMessagesPageAsync.params
            response = objectListMessagesPageAsync.response
        }

        fun service(service: ObjectServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ObjectListMessagesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ObjectListMessagesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ObjectListMessagesPageAsync].
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
        fun build(): ObjectListMessagesPageAsync =
            ObjectListMessagesPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ObjectListMessagesPageAsync) {

        fun forEach(action: Predicate<Message>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ObjectListMessagesPageAsync>>.forEach(
                action: (Message) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Message>> {
            val values = mutableListOf<Message>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListMessagesPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListMessagesPageAsync{service=$service, params=$params, response=$response}"
}
