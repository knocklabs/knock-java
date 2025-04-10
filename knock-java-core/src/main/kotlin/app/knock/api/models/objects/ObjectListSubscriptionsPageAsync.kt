// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.async.ObjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/**
 * List subscriptions for an object. Either list all subscriptions that belong to the object, or all
 * subscriptions that this object has. Determined by the `mode` query parameter.
 */
class ObjectListSubscriptionsPageAsync
private constructor(
    private val objectsService: ObjectServiceAsync,
    private val params: ObjectListSubscriptionsParams,
    private val response: ObjectListSubscriptionsPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ObjectListSubscriptionsPageResponse = response

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
    fun pageInfo(): Optional<ObjectListSubscriptionsPageResponse.PageInfo> =
        response._pageInfo().getOptional("page_info")

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListSubscriptionsPageAsync && objectsService == other.objectsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(objectsService, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListSubscriptionsPageAsync{objectsService=$objectsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean =
        entries().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun getNextPageParams(): Optional<ObjectListSubscriptionsParams> {
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

    fun getNextPage(): CompletableFuture<Optional<ObjectListSubscriptionsPageAsync>> {
        return getNextPageParams()
            .map { objectsService.listSubscriptions(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            objectsService: ObjectServiceAsync,
            params: ObjectListSubscriptionsParams,
            response: ObjectListSubscriptionsPageResponse,
        ) = ObjectListSubscriptionsPageAsync(objectsService, params, response)
    }

    class AutoPager(private val firstPage: ObjectListSubscriptionsPageAsync) {

        fun forEach(action: Predicate<Subscription>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ObjectListSubscriptionsPageAsync>>.forEach(
                action: (Subscription) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<Subscription>> {
            val values = mutableListOf<Subscription>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
