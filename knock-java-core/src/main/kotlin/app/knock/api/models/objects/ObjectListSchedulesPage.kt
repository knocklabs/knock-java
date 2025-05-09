// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.models.schedules.Schedule
import app.knock.api.models.shared.PageInfo
import app.knock.api.services.blocking.ObjectService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [ObjectService.listSchedules] */
class ObjectListSchedulesPage
private constructor(
    private val service: ObjectService,
    private val params: ObjectListSchedulesParams,
    private val response: ObjectListSchedulesPageResponse,
) : Page<Schedule> {

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

    override fun items(): List<Schedule> = entries()

    override fun hasNextPage(): Boolean =
        items().isNotEmpty() && pageInfo().flatMap { it._after().getOptional("after") }.isPresent

    fun nextPageParams(): ObjectListSchedulesParams {
        val nextCursor =
            pageInfo().flatMap { it._after().getOptional("after") }.getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): ObjectListSchedulesPage = service.listSchedules(nextPageParams())

    fun autoPager(): AutoPager<Schedule> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ObjectListSchedulesParams = params

    /** The response that this page was parsed from. */
    fun response(): ObjectListSchedulesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectListSchedulesPage].
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

    /** A builder for [ObjectListSchedulesPage]. */
    class Builder internal constructor() {

        private var service: ObjectService? = null
        private var params: ObjectListSchedulesParams? = null
        private var response: ObjectListSchedulesPageResponse? = null

        @JvmSynthetic
        internal fun from(objectListSchedulesPage: ObjectListSchedulesPage) = apply {
            service = objectListSchedulesPage.service
            params = objectListSchedulesPage.params
            response = objectListSchedulesPage.response
        }

        fun service(service: ObjectService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ObjectListSchedulesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ObjectListSchedulesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ObjectListSchedulesPage].
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
        fun build(): ObjectListSchedulesPage =
            ObjectListSchedulesPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectListSchedulesPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ObjectListSchedulesPage{service=$service, params=$params, response=$response}"
}
