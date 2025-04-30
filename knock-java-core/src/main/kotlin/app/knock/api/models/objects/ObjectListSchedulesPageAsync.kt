// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.checkRequired
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.async.ObjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectServiceAsync.listSchedules] */
class ObjectListSchedulesPageAsync
private constructor(
    private val service: ObjectServiceAsync,
    private val params: ObjectListSchedulesParams,
    private val response: ObjectListSchedulesPageResponse,
) {

    /**
     * Delegates to [ObjectListSchedulesPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListSchedulesPageResponse.entries]
     */
    fun entries(): List<Schedule> =
        response._entries().getOptional("entries").getOrNull() ?: emptyList()

    /**
     * Delegates to [ObjectListSchedulesPageResponse], but gracefully handles missing data.
     *
     * @see [ObjectListSchedulesPageResponse.pageInfo]
     */
    fun pageInfo(): Optional<PageInfo> = response._pageInfo().getOptional("page_info")

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ObjectListSchedulesParams> {
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

    fun getNextPage(): CompletableFuture<Optional<ObjectListSchedulesPageAsync>> =
        getNextPageParams()
            .map { service.listSchedules(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ObjectListSchedulesParams = params

    /** The response that this page was parsed from. */
    fun response(): ObjectListSchedulesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectListSchedulesPageAsync].
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

    /** A builder for [ObjectListSchedulesPageAsync]. */
    class Builder internal constructor() {

        private var service: ObjectServiceAsync? = null
        private var params: ObjectListSchedulesParams? = null
        private var response: ObjectListSchedulesPageResponse? = null

        @JvmSynthetic
        internal fun from(objectListSchedulesPageAsync: ObjectListSchedulesPageAsync) = apply {
            service = objectListSchedulesPageAsync.service
            params = objectListSchedulesPageAsync.params
            response = objectListSchedulesPageAsync.response
        }

        fun service(service: ObjectServiceAsync) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ObjectListSchedulesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ObjectListSchedulesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ObjectListSchedulesPageAsync].
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
        fun build(): ObjectListSchedulesPageAsync =
            ObjectListSchedulesPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: ObjectListSchedulesPageAsync) {

        fun forEach(action: Predicate<Schedule>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ObjectListSchedulesPageAsync>>.forEach(
                action: (Schedule) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Schedule>> {
            val values = mutableListOf<Schedule>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListSchedulesPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListSchedulesPageAsync{service=$service, params=$params, response=$response}"
}
