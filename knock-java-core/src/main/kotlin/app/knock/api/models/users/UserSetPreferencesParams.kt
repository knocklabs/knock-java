// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Updates a complete preference set for a user. This is a destructive operation that will replace
 * the existing preference set for the user.
 */
class UserSetPreferencesParams
private constructor(
    private val userId: String?,
    private val id: String?,
    private val preferenceSetRequest: PreferenceSetRequest,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): Optional<String> = Optional.ofNullable(userId)

    fun id(): Optional<String> = Optional.ofNullable(id)

    /** A request to set a preference set for a recipient. */
    fun preferenceSetRequest(): PreferenceSetRequest = preferenceSetRequest

    fun _additionalBodyProperties(): Map<String, JsonValue> =
        preferenceSetRequest._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserSetPreferencesParams].
         *
         * The following fields are required:
         * ```java
         * .preferenceSetRequest()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserSetPreferencesParams]. */
    class Builder internal constructor() {

        private var userId: String? = null
        private var id: String? = null
        private var preferenceSetRequest: PreferenceSetRequest? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userSetPreferencesParams: UserSetPreferencesParams) = apply {
            userId = userSetPreferencesParams.userId
            id = userSetPreferencesParams.id
            preferenceSetRequest = userSetPreferencesParams.preferenceSetRequest
            additionalHeaders = userSetPreferencesParams.additionalHeaders.toBuilder()
            additionalQueryParams = userSetPreferencesParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String?) = apply { this.userId = userId }

        /** Alias for calling [Builder.userId] with `userId.orElse(null)`. */
        fun userId(userId: Optional<String>) = userId(userId.getOrNull())

        fun id(id: String?) = apply { this.id = id }

        /** Alias for calling [Builder.id] with `id.orElse(null)`. */
        fun id(id: Optional<String>) = id(id.getOrNull())

        /** A request to set a preference set for a recipient. */
        fun preferenceSetRequest(preferenceSetRequest: PreferenceSetRequest) = apply {
            this.preferenceSetRequest = preferenceSetRequest
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
         * Returns an immutable instance of [UserSetPreferencesParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .preferenceSetRequest()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserSetPreferencesParams =
            UserSetPreferencesParams(
                userId,
                id,
                checkRequired("preferenceSetRequest", preferenceSetRequest),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): PreferenceSetRequest = preferenceSetRequest

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> userId ?: ""
            1 -> id ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserSetPreferencesParams && userId == other.userId && id == other.id && preferenceSetRequest == other.preferenceSetRequest && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, id, preferenceSetRequest, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "UserSetPreferencesParams{userId=$userId, id=$id, preferenceSetRequest=$preferenceSetRequest, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
