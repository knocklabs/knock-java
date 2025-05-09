// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.recipients.subscriptions.Subscription
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.ObjectService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectService.listSubscriptions] */
class ObjectListSubscriptionsPage
private constructor(
    private val service: ObjectService,
    private val params: ObjectListSubscriptionsParams,
    private val response: ObjectListSubscriptionsPageResponse,
) : Page<Subscription> {

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

    override fun nextPage(): ObjectListSubscriptionsPage =
        service.listSubscriptions(nextPageParams())

    fun autoPager(): AutoPager<Subscription> = AutoPager.from(this)

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
