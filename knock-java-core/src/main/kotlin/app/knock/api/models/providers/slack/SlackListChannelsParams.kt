// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.providers.slack

import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** List Slack channels for a Slack workspace. */
class SlackListChannelsParams
private constructor(
    private val channelId: String,
    private val accessTokenObject: String,
    private val queryOptions: QueryOptions?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun channelId(): String = channelId

    /** A JSON encoded string containing the access token object reference. */
    fun accessTokenObject(): String = accessTokenObject

    fun queryOptions(): Optional<QueryOptions> = Optional.ofNullable(queryOptions)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SlackListChannelsParams].
         *
         * The following fields are required:
         * ```java
         * .channelId()
         * .accessTokenObject()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SlackListChannelsParams]. */
    class Builder internal constructor() {

        private var channelId: String? = null
        private var accessTokenObject: String? = null
        private var queryOptions: QueryOptions? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(slackListChannelsParams: SlackListChannelsParams) = apply {
            channelId = slackListChannelsParams.channelId
            accessTokenObject = slackListChannelsParams.accessTokenObject
            queryOptions = slackListChannelsParams.queryOptions
            additionalHeaders = slackListChannelsParams.additionalHeaders.toBuilder()
            additionalQueryParams = slackListChannelsParams.additionalQueryParams.toBuilder()
        }

        fun channelId(channelId: String) = apply { this.channelId = channelId }

        /** A JSON encoded string containing the access token object reference. */
        fun accessTokenObject(accessTokenObject: String) = apply {
            this.accessTokenObject = accessTokenObject
        }

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
         * Returns an immutable instance of [SlackListChannelsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .channelId()
         * .accessTokenObject()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SlackListChannelsParams =
            SlackListChannelsParams(
                checkRequired("channelId", channelId),
                checkRequired("accessTokenObject", accessTokenObject),
                queryOptions,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> channelId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                put("access_token_object", accessTokenObject)
                queryOptions?.let {
                    it.cursor().ifPresent { put("query_options[cursor]", it) }
                    it.excludeArchived().ifPresent {
                        put("query_options[exclude_archived]", it.toString())
                    }
                    it.limit().ifPresent { put("query_options[limit]", it.toString()) }
                    it.teamId().ifPresent { put("query_options[team_id]", it) }
                    it.types().ifPresent { put("query_options[types]", it) }
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
        private val cursor: String?,
        private val excludeArchived: Boolean?,
        private val limit: Long?,
        private val teamId: String?,
        private val types: String?,
        private val additionalProperties: QueryParams,
    ) {

        /**
         * Paginate through collections of data by setting the cursor parameter to a next_cursor
         * attribute returned by a previous request's response_metadata. Default value fetches the
         * first "page" of the collection.
         */
        fun cursor(): Optional<String> = Optional.ofNullable(cursor)

        /** Set to true to exclude archived channels from the list. */
        fun excludeArchived(): Optional<Boolean> = Optional.ofNullable(excludeArchived)

        /** The maximum number of channels to return. */
        fun limit(): Optional<Long> = Optional.ofNullable(limit)

        /** Encoded team ID (T1234) to list channels in, required if org token is used. */
        fun teamId(): Optional<String> = Optional.ofNullable(teamId)

        /**
         * Mix and match channel types by providing a comma-separated list of any combination of
         * public_channel, private_channel, mpim, im.
         */
        fun types(): Optional<String> = Optional.ofNullable(types)

        fun _additionalProperties(): QueryParams = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [QueryOptions]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [QueryOptions]. */
        class Builder internal constructor() {

            private var cursor: String? = null
            private var excludeArchived: Boolean? = null
            private var limit: Long? = null
            private var teamId: String? = null
            private var types: String? = null
            private var additionalProperties: QueryParams.Builder = QueryParams.builder()

            @JvmSynthetic
            internal fun from(queryOptions: QueryOptions) = apply {
                cursor = queryOptions.cursor
                excludeArchived = queryOptions.excludeArchived
                limit = queryOptions.limit
                teamId = queryOptions.teamId
                types = queryOptions.types
                additionalProperties = queryOptions.additionalProperties.toBuilder()
            }

            /**
             * Paginate through collections of data by setting the cursor parameter to a next_cursor
             * attribute returned by a previous request's response_metadata. Default value fetches
             * the first "page" of the collection.
             */
            fun cursor(cursor: String?) = apply { this.cursor = cursor }

            /** Alias for calling [Builder.cursor] with `cursor.orElse(null)`. */
            fun cursor(cursor: Optional<String>) = cursor(cursor.getOrNull())

            /** Set to true to exclude archived channels from the list. */
            fun excludeArchived(excludeArchived: Boolean?) = apply {
                this.excludeArchived = excludeArchived
            }

            /**
             * Alias for [Builder.excludeArchived].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun excludeArchived(excludeArchived: Boolean) =
                excludeArchived(excludeArchived as Boolean?)

            /** Alias for calling [Builder.excludeArchived] with `excludeArchived.orElse(null)`. */
            fun excludeArchived(excludeArchived: Optional<Boolean>) =
                excludeArchived(excludeArchived.getOrNull())

            /** The maximum number of channels to return. */
            fun limit(limit: Long?) = apply { this.limit = limit }

            /**
             * Alias for [Builder.limit].
             *
             * This unboxed primitive overload exists for backwards compatibility.
             */
            fun limit(limit: Long) = limit(limit as Long?)

            /** Alias for calling [Builder.limit] with `limit.orElse(null)`. */
            fun limit(limit: Optional<Long>) = limit(limit.getOrNull())

            /** Encoded team ID (T1234) to list channels in, required if org token is used. */
            fun teamId(teamId: String?) = apply { this.teamId = teamId }

            /** Alias for calling [Builder.teamId] with `teamId.orElse(null)`. */
            fun teamId(teamId: Optional<String>) = teamId(teamId.getOrNull())

            /**
             * Mix and match channel types by providing a comma-separated list of any combination of
             * public_channel, private_channel, mpim, im.
             */
            fun types(types: String?) = apply { this.types = types }

            /** Alias for calling [Builder.types] with `types.orElse(null)`. */
            fun types(types: Optional<String>) = types(types.getOrNull())

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
            fun build(): QueryOptions =
                QueryOptions(
                    cursor,
                    excludeArchived,
                    limit,
                    teamId,
                    types,
                    additionalProperties.build(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is QueryOptions && cursor == other.cursor && excludeArchived == other.excludeArchived && limit == other.limit && teamId == other.teamId && types == other.types && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(cursor, excludeArchived, limit, teamId, types, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "QueryOptions{cursor=$cursor, excludeArchived=$excludeArchived, limit=$limit, teamId=$teamId, types=$types, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SlackListChannelsParams && channelId == other.channelId && accessTokenObject == other.accessTokenObject && queryOptions == other.queryOptions && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(channelId, accessTokenObject, queryOptions, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "SlackListChannelsParams{channelId=$channelId, accessTokenObject=$accessTokenObject, queryOptions=$queryOptions, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
