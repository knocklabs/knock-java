// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.models.messages.Message
import app.knock.api.services.async.ObjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** List messages */
class ObjectListMessagesPageAsync
private constructor(
    private val objectsService: ObjectServiceAsync,
    private val params: ObjectListMessagesParams,
    private val response: ObjectListMessagesPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): ObjectListMessagesPageResponse = response

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListMessagesPageAsync && objectsService == other.objectsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(objectsService, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListMessagesPageAsync{objectsService=$objectsService, params=$params, response=$response}"

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

    fun getNextPage(): CompletableFuture<Optional<ObjectListMessagesPageAsync>> {
        return getNextPageParams()
            .map { objectsService.listMessages(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            objectsService: ObjectServiceAsync,
            params: ObjectListMessagesParams,
            response: ObjectListMessagesPageResponse,
        ) = ObjectListMessagesPageAsync(objectsService, params, response)
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
}
