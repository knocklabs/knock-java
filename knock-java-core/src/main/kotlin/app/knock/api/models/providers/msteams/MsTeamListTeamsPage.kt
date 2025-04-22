// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.checkRequired
import app.knock.api.services.blocking.providers.MsTeamService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [MsTeamService.listTeams] */
class MsTeamListTeamsPage
private constructor(
    private val service: MsTeamService,
    private val params: MsTeamListTeamsParams,
    private val response: MsTeamListTeamsPageResponse,
) {

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

    fun hasNextPage(): Boolean = msTeamsTeams().isNotEmpty() && skipToken().isPresent

    fun getNextPageParams(): Optional<MsTeamListTeamsParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            params.toBuilder().apply { skipToken().ifPresent { queryOptionsSkiptoken(it) } }.build()
        )
    }

    fun getNextPage(): Optional<MsTeamListTeamsPage> =
        getNextPageParams().map { service.listTeams(it) }

    fun autoPager(): AutoPager = AutoPager(this)

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

    class AutoPager(private val firstPage: MsTeamListTeamsPage) :
        Iterable<MsTeamListTeamsResponse> {

        override fun iterator(): Iterator<MsTeamListTeamsResponse> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.msTeamsTeams().size) {
                    yield(page.msTeamsTeams()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<MsTeamListTeamsResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
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
