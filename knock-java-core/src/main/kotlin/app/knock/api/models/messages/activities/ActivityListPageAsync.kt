// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages.activities

import app.knock.api.core.checkRequired
import app.knock.api.models.messages.Activity
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.messages.ActivityServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [ActivityServiceAsync.list] */
class ActivityListPageAsync
private constructor(
    private val service: ActivityServiceAsync,
    private val params: ActivityListParams,
    private val response: ActivityListPageResponse,
) {

    /**
     * Delegates to [ActivityListPageResponse], but gracefully handles missing data.
     *
     * @see [ActivityListPageResponse.entries]
     */
    fun entries(): List<Activity> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ActivityListPageResponse], but gracefully handles missing data.
     *
     * @see [ActivityListPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ActivityListParams> {
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

    fun getNextPage(): CompletableFuture<Optional<ActivityListPageAsync>> =
        getNextPageParams()
            .map { service.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ActivityListParams = params

    /** The response that this page was parsed from. */
    fun response(): ActivityListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ActivityListPageAsync].
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

    /** A builder for [ActivityListPageAsync]. */
    class Builder internal constructor() {

        private var service: ActivityServiceAsync? = null
        private var params: ActivityListParams? = null
        private var response: ActivityListPageResponse? = null

        @JvmSynthetic
        internal fun from(activityListPageAsync: ActivityListPageAsync) = apply {
            service = activityListPageAsync.service
            params = activityListPageAsync.params
            response = activityListPageAsync.response
        }

        fun service(service: ActivityServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ActivityListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ActivityListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ActivityListPageAsync].
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
        fun build(): ActivityListPageAsync =
            ActivityListPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ActivityListPageAsync) {

        fun forEach(action: Predicate<Activity>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ActivityListPageAsync>>.forEach(
                action: (Activity) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Activity>> {
            val values = mutableListOf<Activity>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ActivityListPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ActivityListPageAsync{service=$service, params=$params, response=$response}"
}
