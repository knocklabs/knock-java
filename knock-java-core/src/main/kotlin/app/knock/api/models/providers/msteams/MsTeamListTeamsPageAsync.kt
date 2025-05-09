// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.AutoPagerAsync
import app.knock.api.core.PageAsync
import app.knock.api.core.checkRequired
import app.knock.api.services.async.providers.MsTeamServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [MsTeamServiceAsync.listTeams] */
class MsTeamListTeamsPageAsync
private constructor(
    private val service: MsTeamServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: MsTeamListTeamsParams,
    private val response: MsTeamListTeamsPageResponse,
) : PageAsync<MsTeamListTeamsResponse> {

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

    override fun nextPage(): CompletableFuture<MsTeamListTeamsPageAsync> =
        service.listTeams(nextPageParams())

    fun autoPager(): AutoPagerAsync<MsTeamListTeamsResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): MsTeamListTeamsParams = params

    /** The response that this page was parsed from. */
    fun response(): MsTeamListTeamsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MsTeamListTeamsPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MsTeamListTeamsPageAsync]. */
    class Builder internal constructor() {

        private var service: MsTeamServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: MsTeamListTeamsParams? = null
        private var response: MsTeamListTeamsPageResponse? = null

        @JvmSynthetic
        internal fun from(msTeamListTeamsPageAsync: MsTeamListTeamsPageAsync) = apply {
            service = msTeamListTeamsPageAsync.service
            streamHandlerExecutor = msTeamListTeamsPageAsync.streamHandlerExecutor
            params = msTeamListTeamsPageAsync.params
            response = msTeamListTeamsPageAsync.response
        }

        fun service(service: MsTeamServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: MsTeamListTeamsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: MsTeamListTeamsPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [MsTeamListTeamsPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MsTeamListTeamsPageAsync =
            MsTeamListTeamsPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MsTeamListTeamsPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "MsTeamListTeamsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
