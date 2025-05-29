// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.models.recipients.channeldata.ChannelDataRequest
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Updates or creates channel data for a specific user and channel ID. If no user exists in the
 * current environment for the given `user_id`, Knock will create the user entry as part of this
 * request.
 */
class UserSetChannelDataParams
private constructor(
    private val userId: String?,
    private val channelId: String?,
    private val channelDataRequest: ChannelDataRequest,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): Optional<String> = Optional.ofNullable(userId)

    fun channelId(): Optional<String> = Optional.ofNullable(channelId)

    /** A request to set channel data for a type of channel. */
    fun channelDataRequest(): ChannelDataRequest = channelDataRequest

    fun _additionalBodyProperties(): Map<String, JsonValue> =
        channelDataRequest._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserSetChannelDataParams].
         *
         * The following fields are required:
         * ```java
         * .channelDataRequest()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserSetChannelDataParams]. */
    class Builder internal constructor() {

        private var userId: String? = null
        private var channelId: String? = null
        private var channelDataRequest: ChannelDataRequest? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userSetChannelDataParams: UserSetChannelDataParams) = apply {
            userId = userSetChannelDataParams.userId
            channelId = userSetChannelDataParams.channelId
            channelDataRequest = userSetChannelDataParams.channelDataRequest
            additionalHeaders = userSetChannelDataParams.additionalHeaders.toBuilder()
            additionalQueryParams = userSetChannelDataParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String?) = apply { this.userId = userId }

        /** Alias for calling [Builder.userId] with `userId.orElse(null)`. */
        fun userId(userId: Optional<String>) = userId(userId.getOrNull())

        fun channelId(channelId: String?) = apply { this.channelId = channelId }

        /** Alias for calling [Builder.channelId] with `channelId.orElse(null)`. */
        fun channelId(channelId: Optional<String>) = channelId(channelId.getOrNull())

        /** A request to set channel data for a type of channel. */
        fun channelDataRequest(channelDataRequest: ChannelDataRequest) = apply {
            this.channelDataRequest = channelDataRequest
        }

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
         * Returns an immutable instance of [UserSetChannelDataParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .channelDataRequest()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserSetChannelDataParams =
            UserSetChannelDataParams(
                userId,
                channelId,
                checkRequired("channelDataRequest", channelDataRequest),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): ChannelDataRequest = channelDataRequest

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> userId ?: ""
            1 -> channelId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserSetChannelDataParams && userId == other.userId && channelId == other.channelId && channelDataRequest == other.channelDataRequest && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, channelId, channelDataRequest, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "UserSetChannelDataParams{userId=$userId, channelId=$channelId, channelDataRequest=$channelDataRequest, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
