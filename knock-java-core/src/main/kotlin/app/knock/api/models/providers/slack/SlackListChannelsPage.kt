// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.services.blocking.providers.SlackService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [SlackService.listChannels] */
class SlackListChannelsPage
private constructor(
    private val service: SlackService,
    private val params: SlackListChannelsParams,
    private val response: SlackListChannelsPageResponse,
) : Page<SlackListChannelsResponse> {

    /**
     * Delegates to [SlackListChannelsPageResponse], but gracefully handles missing data.
     *
     * @see [SlackListChannelsPageResponse.nextCursor]
     */
    fun nextCursor(): Optional<String> = response._nextCursor().getOptional("next_cursor")

    /**
     * Delegates to [SlackListChannelsPageResponse], but gracefully handles missing data.
     *
     * @see [SlackListChannelsPageResponse.slackChannels]
     */
    fun slackChannels(): List<SlackListChannelsResponse> =
        response._slackChannels().getOptional("slack_channels").getOrNull() ?: emptyList()

    override fun items(): List<SlackListChannelsResponse> = slackChannels()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && nextCursor().isPresent

    fun nextPageParams(): SlackListChannelsParams {
        val nextCursor =
            nextCursor().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().queryOptionsCursor(nextCursor).build()
    }

    override fun nextPage(): SlackListChannelsPage = service.listChannels(nextPageParams())

    fun autoPager(): AutoPager<SlackListChannelsResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): SlackListChannelsParams = params

    /** The response that this page was parsed from. */
    fun response(): SlackListChannelsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SlackListChannelsPage].
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

    /** A builder for [SlackListChannelsPage]. */
    class Builder internal constructor() {

        private var service: SlackService? = null
        private var params: SlackListChannelsParams? = null
        private var response: SlackListChannelsPageResponse? = null

        @JvmSynthetic
        internal fun from(slackListChannelsPage: SlackListChannelsPage) = apply {
            service = slackListChannelsPage.service
            params = slackListChannelsPage.params
            response = slackListChannelsPage.response
        }

        fun service(service: SlackService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: SlackListChannelsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SlackListChannelsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SlackListChannelsPage].
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
        fun build(): SlackListChannelsPage =
            SlackListChannelsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SlackListChannelsPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "SlackListChannelsPage{service=$service, params=$params, response=$response}"
}
