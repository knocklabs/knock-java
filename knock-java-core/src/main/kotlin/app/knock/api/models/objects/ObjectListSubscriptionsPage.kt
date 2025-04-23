// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.checkRequired
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.ObjectService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectService.listSubscriptions] */
class ObjectListSubscriptionsPage
private constructor(
    private val service: ObjectService,
    private val params: ObjectListSubscriptionsParams,
    private val response: ObjectListSubscriptionsPageResponse,
) {

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

    fun getNextPage(): Optional<ObjectListSubscriptionsPage> =
        getNextPageParams().map { service.listSubscriptions(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): ObjectListSubscriptionsParams = params

    /** The response that this page was parsed from. */
    fun response(): ObjectListSubscriptionsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectListSubscriptionsPage].
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

    /** A builder for [ObjectListSubscriptionsPage]. */
    class Builder internal constructor() {

        private var service: ObjectService? = null
        private var params: ObjectListSubscriptionsParams? = null
        private var response: ObjectListSubscriptionsPageResponse? = null

        @JvmSynthetic
        internal fun from(objectListSubscriptionsPage: ObjectListSubscriptionsPage) = apply {
            service = objectListSubscriptionsPage.service
            params = objectListSubscriptionsPage.params
            response = objectListSubscriptionsPage.response
        }

        fun service(service: ObjectService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ObjectListSubscriptionsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ObjectListSubscriptionsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [ObjectListSubscriptionsPage].
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
        fun build(): ObjectListSubscriptionsPage =
            ObjectListSubscriptionsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListSubscriptionsPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListSubscriptionsPage{service=$service, params=$params, response=$response}"
}
