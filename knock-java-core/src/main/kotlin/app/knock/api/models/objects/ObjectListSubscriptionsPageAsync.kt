// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.ObjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectServiceAsync.listSubscriptions] */
class ObjectListSubscriptionsPageAsync
private constructor(
    private val service: ObjectServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ObjectListSubscriptionsParams,
    private val response: ObjectListSubscriptionsPageResponse,
) : PageAsync<Subscription> {

    /**
     * Delegates to [ObjectListSubscriptionsPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListSubscriptionsPageResponse.entries]
     */
    fun entries(): List<Subscription> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ObjectListSubscriptionsPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListSubscriptionsPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    override fun items(): List<Subscription> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): ObjectListSubscriptionsParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ObjectListSubscriptionsPageAsync> =
        service.listSubscriptions(nextPageParams())

    fun autoPager(): AutoPagerAsync<Subscription> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ObjectListSubscriptionsParams = params

    /** The response that this page was parsed from. */
    fun response(): ObjectListSubscriptionsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ObjectListSubscriptionsPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ObjectListSubscriptionsPageAsync]. */
    class Builder internal constructor() {

        private var service: ObjectServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ObjectListSubscriptionsParams? = null
        private var response: ObjectListSubscriptionsPageResponse? = null

        @JvmSynthetic
        internal fun from(objectListSubscriptionsPageAsync: ObjectListSubscriptionsPageAsync) =
            apply {
                service = objectListSubscriptionsPageAsync.service
                streamHandlerExecutor = objectListSubscriptionsPageAsync.streamHandlerExecutor
                params = objectListSubscriptionsPageAsync.params
                response = objectListSubscriptionsPageAsync.response
            }

        fun service(service: ObjectServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ObjectListSubscriptionsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ObjectListSubscriptionsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [ObjectListSubscriptionsPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ObjectListSubscriptionsPageAsync =
            ObjectListSubscriptionsPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListSubscriptionsPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListSubscriptionsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
