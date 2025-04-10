// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.services.blocking.ObjectService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/**
 * List subscriptions for an object. Either list all subscriptions that belong to the object, or all
 * subscriptions that this object has. Determined by the `mode` query parameter.
 */
class ObjectListSubscriptionsPage
private constructor(
    private val objectsService: ObjectService,
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

        return /* spotless:off */ other is ObjectListSubscriptionsPage && objectsService == other.objectsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(objectsService, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListSubscriptionsPage{objectsService=$objectsService, params=$params, response=$response}"

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

    fun getNextPage(): Optional<ObjectListSubscriptionsPage> {
        return getNextPageParams().map { objectsService.listSubscriptions(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            objectsService: ObjectService,
            params: ObjectListSubscriptionsParams,
            response: ObjectListSubscriptionsPageResponse,
        ) = ObjectListSubscriptionsPage(objectsService, params, response)
    }

    class AutoPager(private val firstPage: ObjectListSubscriptionsPage) : Iterable<Subscription> {

        override fun iterator(): Iterator<Subscription> = iterator {
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

        fun stream(): Stream<Subscription> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
