// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.msteams

import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * List the Microsoft Teams channels within a team. By default, archived and private channels are
 * excluded from the results.
 */
class MsTeamListChannelsParams
private constructor(
    private val channelId: String?,
    private val msTeamsTenantObject: String,
    private val teamId: String,
    private val queryOptions: QueryOptions?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun channelId(): Optional<String> = Optional.ofNullable(channelId)

    /** A JSON encoded string containing the Microsoft Teams tenant object reference. */
    fun msTeamsTenantObject(): String = msTeamsTenantObject

    /** Microsoft Teams team ID. */
    fun teamId(): String = teamId

    fun queryOptions(): Optional<QueryOptions> = Optional.ofNullable(queryOptions)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MsTeamListChannelsParams].
         *
         * The following fields are required:
         * ```java
         * .msTeamsTenantObject()
         * .teamId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MsTeamListChannelsParams]. */
    class Builder internal constructor() {

        private var channelId: String? = null
        private var msTeamsTenantObject: String? = null
        private var teamId: String? = null
        private var queryOptions: QueryOptions? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(msTeamListChannelsParams: MsTeamListChannelsParams) = apply {
            channelId = msTeamListChannelsParams.channelId
            msTeamsTenantObject = msTeamListChannelsParams.msTeamsTenantObject
            teamId = msTeamListChannelsParams.teamId
            queryOptions = msTeamListChannelsParams.queryOptions
            additionalHeaders = msTeamListChannelsParams.additionalHeaders.toBuilder()
            additionalQueryParams = msTeamListChannelsParams.additionalQueryParams.toBuilder()
        }

        fun channelId(channelId: String?) = apply { this.channelId = channelId }

        /** Alias for calling [Builder.channelId] with `channelId.orElse(null)`. */
        fun channelId(channelId: Optional<String>) = channelId(channelId.getOrNull())

        /** A JSON encoded string containing the Microsoft Teams tenant object reference. */
        fun msTeamsTenantObject(msTeamsTenantObject: String) = apply {
            this.msTeamsTenantObject = msTeamsTenantObject
        }

        /** Microsoft Teams team ID. */
        fun teamId(teamId: String) = apply { this.teamId = teamId }

        fun queryOptions(queryOptions: QueryOptions?) = apply { this.queryOptions = queryOptions }

        /** Alias for calling [Builder.queryOptions] with `queryOptions.orElse(null)`. */
        fun queryOptions(queryOptions: Optional<QueryOptions>) =
            queryOptions(queryOptions.getOrNull())

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [MsTeamListChannelsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .msTeamsTenantObject()
         * .teamId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MsTeamListChannelsParams =
            MsTeamListChannelsParams(
                channelId,
                checkRequired("msTeamsTenantObject", msTeamsTenantObject),
                checkRequired("teamId", teamId),
                queryOptions,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> channelId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("ms_teams_tenant_object", msTeamsTenantObject)
                put("team_id", teamId)
                queryOptions?.let {
                    it.filter().ifPresent { put("query_options[\$filter]", it) }
                    it.select().ifPresent { put("query_options[\$select]", it) }
                    it._additionalProperties().keys().forEach { key ->
                        it._additionalProperties().values(key).forEach { value ->
                            put("query_options[$key]", value)
                        }
                    }
                }
                putAll(additionalQueryParams)
            }
            .build()

    class QueryOptions
    private constructor(
        private val filter: String?,
        private val select: String?,
        private val additionalProperties: QueryParams,
    ) {

        /**
         * [OData param](https://learn.microsoft.com/en-us/graph/query-parameters) passed to the
         * Microsoft Graph API to filter channels.
         */
        fun filter(): Optional<String> = Optional.ofNullable(filter)

        /**
         * [OData param](https://learn.microsoft.com/en-us/graph/query-parameters) passed to the
         * Microsoft Graph API to select specific properties.
         */
        fun select(): Optional<String> = Optional.ofNullable(select)

        fun _additionalProperties(): QueryParams = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [QueryOptions]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [QueryOptions]. */
        class Builder internal constructor() {

            private var filter: String? = null
            private var select: String? = null
            private var additionalProperties: QueryParams.Builder = QueryParams.builder()

            @JvmSynthetic
            internal fun from(queryOptions: QueryOptions) = apply {
                filter = queryOptions.filter
                select = queryOptions.select
                additionalProperties = queryOptions.additionalProperties.toBuilder()
            }

            /**
             * [OData param](https://learn.microsoft.com/en-us/graph/query-parameters) passed to the
             * Microsoft Graph API to filter channels.
             */
            fun filter(filter: String?) = apply { this.filter = filter }

            /** Alias for calling [Builder.filter] with `filter.orElse(null)`. */
            fun filter(filter: Optional<String>) = filter(filter.getOrNull())

            /**
             * [OData param](https://learn.microsoft.com/en-us/graph/query-parameters) passed to the
             * Microsoft Graph API to select specific properties.
             */
            fun select(select: String?) = apply { this.select = select }

            /** Alias for calling [Builder.select] with `select.orElse(null)`. */
            fun select(select: Optional<String>) = select(select.getOrNull())

            fun additionalProperties(additionalProperties: QueryParams) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun additionalProperties(additionalProperties: Map<String, Iterable<String>>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: String) = apply {
                additionalProperties.put(key, value)
            }

            fun putAdditionalProperties(key: String, values: Iterable<String>) = apply {
                additionalProperties.put(key, values)
            }

            fun putAllAdditionalProperties(additionalProperties: QueryParams) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, Iterable<String>>) =
                apply {
                    this.additionalProperties.putAll(additionalProperties)
                }

            fun replaceAdditionalProperties(key: String, value: String) = apply {
                additionalProperties.replace(key, value)
            }

            fun replaceAdditionalProperties(key: String, values: Iterable<String>) = apply {
                additionalProperties.replace(key, values)
            }

            fun replaceAllAdditionalProperties(additionalProperties: QueryParams) = apply {
                this.additionalProperties.replaceAll(additionalProperties)
            }

            fun replaceAllAdditionalProperties(
                additionalProperties: Map<String, Iterable<String>>
            ) = apply { this.additionalProperties.replaceAll(additionalProperties) }

            fun removeAdditionalProperties(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                additionalProperties.removeAll(keys)
            }

            /**
             * Returns an immutable instance of [QueryOptions].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): QueryOptions = QueryOptions(filter, select, additionalProperties.build())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is QueryOptions && filter == other.filter && select == other.select && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(filter, select, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "QueryOptions{filter=$filter, select=$select, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MsTeamListChannelsParams && channelId == other.channelId && msTeamsTenantObject == other.msTeamsTenantObject && teamId == other.teamId && queryOptions == other.queryOptions && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(channelId, msTeamsTenantObject, teamId, queryOptions, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "MsTeamListChannelsParams{channelId=$channelId, msTeamsTenantObject=$msTeamsTenantObject, teamId=$teamId, queryOptions=$queryOptions, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
