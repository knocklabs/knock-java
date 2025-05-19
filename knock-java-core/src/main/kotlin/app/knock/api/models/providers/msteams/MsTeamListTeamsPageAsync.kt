// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.checkRequired
import app.knock.api.services.async.providers.MsTeamServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [MsTeamServiceAsync.listTeams] */
class MsTeamListTeamsPageAsync
private constructor(
    private val service: MsTeamServiceAsync,
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

        return skipToken().map { skipToken ->
            params
                .toBuilder()
                .queryOptions(
                    params.queryOptions().map { it.toBuilder().skiptoken(skipToken).build() }
                )
                .build()
        }
    }

    fun getNextPage(): CompletableFuture<Optional<MsTeamListTeamsPageAsync>> =
        getNextPageParams()
            .map { service.listTeams(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

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
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MsTeamListTeamsPageAsync]. */
    class Builder internal constructor() {

        private var service: MsTeamServiceAsync? = null
        private var params: MsTeamListTeamsParams? = null
        private var response: MsTeamListTeamsPageResponse? = null

        @JvmSynthetic
        internal fun from(msTeamListTeamsPageAsync: MsTeamListTeamsPageAsync) = apply {
            service = msTeamListTeamsPageAsync.service
            params = msTeamListTeamsPageAsync.params
            response = msTeamListTeamsPageAsync.response
        }

        fun service(service: MsTeamServiceAsync) = apply { this.service = service }

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
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MsTeamListTeamsPageAsync =
            MsTeamListTeamsPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: MsTeamListTeamsPageAsync) {

        fun forEach(
            action: Predicate<MsTeamListTeamsResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<MsTeamListTeamsPageAsync>>.forEach(
                action: (MsTeamListTeamsResponse) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.msTeamsTeams().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<MsTeamListTeamsResponse>> {
            val values = mutableListOf<MsTeamListTeamsResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MsTeamListTeamsPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "MsTeamListTeamsPageAsync{service=$service, params=$params, response=$response}"
}
