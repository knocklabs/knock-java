// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.Params
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Returns a list of eligible in-app guides for a specific user and channel. */
class GuideGetChannelParams
private constructor(
    private val userId: String?,
    private val channelId: String?,
    private val data: String?,
    private val tenant: String?,
    private val type: String?,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): Optional<String> = Optional.ofNullable(userId)

    fun channelId(): Optional<String> = Optional.ofNullable(channelId)

    /** The data (JSON encoded object) to use for targeting and rendering guides. */
    fun data(): Optional<String> = Optional.ofNullable(data)

    /** The tenant ID to use for targeting and rendering guides. */
    fun tenant(): Optional<String> = Optional.ofNullable(tenant)

    /** The type of guides to filter by. */
    fun type(): Optional<String> = Optional.ofNullable(type)

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): GuideGetChannelParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [GuideGetChannelParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GuideGetChannelParams]. */
    class Builder internal constructor() {

        private var userId: String? = null
        private var channelId: String? = null
        private var data: String? = null
        private var tenant: String? = null
        private var type: String? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(guideGetChannelParams: GuideGetChannelParams) = apply {
            userId = guideGetChannelParams.userId
            channelId = guideGetChannelParams.channelId
            data = guideGetChannelParams.data
            tenant = guideGetChannelParams.tenant
            type = guideGetChannelParams.type
            additionalHeaders = guideGetChannelParams.additionalHeaders.toBuilder()
            additionalQueryParams = guideGetChannelParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String?) = apply { this.userId = userId }

        /** Alias for calling [Builder.userId] with `userId.orElse(null)`. */
        fun userId(userId: Optional<String>) = userId(userId.getOrNull())

        fun channelId(channelId: String?) = apply { this.channelId = channelId }

        /** Alias for calling [Builder.channelId] with `channelId.orElse(null)`. */
        fun channelId(channelId: Optional<String>) = channelId(channelId.getOrNull())

        /** The data (JSON encoded object) to use for targeting and rendering guides. */
        fun data(data: String?) = apply { this.data = data }

        /** Alias for calling [Builder.data] with `data.orElse(null)`. */
        fun data(data: Optional<String>) = data(data.getOrNull())

        /** The tenant ID to use for targeting and rendering guides. */
        fun tenant(tenant: String?) = apply { this.tenant = tenant }

        /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        /** The type of guides to filter by. */
        fun type(type: String?) = apply { this.type = type }

        /** Alias for calling [Builder.type] with `type.orElse(null)`. */
        fun type(type: Optional<String>) = type(type.getOrNull())

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
         * Returns an immutable instance of [GuideGetChannelParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): GuideGetChannelParams =
            GuideGetChannelParams(
                userId,
                channelId,
                data,
                tenant,
                type,
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> userId ?: ""
            1 -> channelId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams =
        QueryParams.builder()
            .apply {
                data?.let { put("data", it) }
                tenant?.let { put("tenant", it) }
                type?.let { put("type", it) }
                putAll(additionalQueryParams)
            }
            .build()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is GuideGetChannelParams && userId == other.userId && channelId == other.channelId && data == other.data && tenant == other.tenant && type == other.type && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, channelId, data, tenant, type, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "GuideGetChannelParams{userId=$userId, channelId=$channelId, data=$data, tenant=$tenant, type=$type, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
