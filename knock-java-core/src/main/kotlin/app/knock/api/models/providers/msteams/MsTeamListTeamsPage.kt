// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.AutoPager
import app.knock.api.core.Page
import app.knock.api.core.checkRequired
import app.knock.api.services.blocking.providers.MsTeamService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [MsTeamService.listTeams] */
class MsTeamListTeamsPage
private constructor(
    private val service: MsTeamService,
    private val params: MsTeamListTeamsParams,
    private val response: MsTeamListTeamsPageResponse,
) : Page<MsTeamListTeamsResponse> {

    /**
     * Delegates to [MsTeamListTeamsPageResponse], but gracefully handles missing data.
     *
     * @see [MsTeamListTeamsPageResponse.skipToken]
     */
    fun skipToken(): Optional<String> = response._skipToken().getOptional("skip_token")

    /**
     * Delegates to [MsTeamListTeamsPageResponse], but gracefully handles missing data.
     *
     * @see [MsTeamListTeamsPageResponse.msTeamsTeams]
     */
    fun msTeamsTeams(): List<MsTeamListTeamsResponse> =
        response._msTeamsTeams().getOptional("ms_teams_teams").getOrNull() ?: emptyList()

    override fun items(): List<MsTeamListTeamsResponse> = msTeamsTeams()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && skipToken().isPresent

    fun nextPageParams(): MsTeamListTeamsParams {
        val nextCursor =
            skipToken().getOrNull()
                ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().queryOptionsSkiptoken(nextCursor).build()
    }

    override fun nextPage(): MsTeamListTeamsPage = service.listTeams(nextPageParams())

    fun autoPager(): AutoPager<MsTeamListTeamsResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): MsTeamListTeamsParams = params

    /** The response that this page was parsed from. */
    fun response(): MsTeamListTeamsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MsTeamListTeamsPage].
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

    /** A builder for [MsTeamListTeamsPage]. */
    class Builder internal constructor() {

        private var service: MsTeamService? = null
        private var params: MsTeamListTeamsParams? = null
        private var response: MsTeamListTeamsPageResponse? = null

        @JvmSynthetic
        internal fun from(msTeamListTeamsPage: MsTeamListTeamsPage) = apply {
            service = msTeamListTeamsPage.service
            params = msTeamListTeamsPage.params
            response = msTeamListTeamsPage.response
        }

        fun service(service: MsTeamService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: MsTeamListTeamsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MsTeamListTeamsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MsTeamListTeamsPage].
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
        fun build(): MsTeamListTeamsPage =
            MsTeamListTeamsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MsTeamListTeamsPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "MsTeamListTeamsPage{service=$service, params=$params, response=$response}"
}
