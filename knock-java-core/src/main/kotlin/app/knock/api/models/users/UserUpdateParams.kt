// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import java.util.Objects

/** Create or update a user with the provided identification data. */
class UserUpdateParams
private constructor(
    private val userId: String,
    private val identifyUserRequest: IdentifyUserRequest,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): String = userId

    /**
     * A set of parameters to identify a user with. Does not include the user ID, as that's
     * specified elsewhere in the request. You can supply any additional properties you'd like to
     * upsert against the user.
     */
    fun identifyUserRequest(): IdentifyUserRequest = identifyUserRequest

    fun _additionalBodyProperties(): Map<String, JsonValue> =
        identifyUserRequest._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [UserUpdateParams].
         *
         * The following fields are required:
         * ```java
         * .userId()
         * .identifyUserRequest()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UserUpdateParams]. */
    class Builder internal constructor() {

        private var userId: String? = null
        private var identifyUserRequest: IdentifyUserRequest? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(userUpdateParams: UserUpdateParams) = apply {
            userId = userUpdateParams.userId
            identifyUserRequest = userUpdateParams.identifyUserRequest
            additionalHeaders = userUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = userUpdateParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String) = apply { this.userId = userId }

        /**
         * A set of parameters to identify a user with. Does not include the user ID, as that's
         * specified elsewhere in the request. You can supply any additional properties you'd like
         * to upsert against the user.
         */
        fun identifyUserRequest(identifyUserRequest: IdentifyUserRequest) = apply {
            this.identifyUserRequest = identifyUserRequest
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
         * Returns an immutable instance of [UserUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .userId()
         * .identifyUserRequest()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): UserUpdateParams =
            UserUpdateParams(
                checkRequired("userId", userId),
                checkRequired("identifyUserRequest", identifyUserRequest),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): IdentifyUserRequest = identifyUserRequest

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> userId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is UserUpdateParams && userId == other.userId && identifyUserRequest == other.identifyUserRequest && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, identifyUserRequest, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "UserUpdateParams{userId=$userId, identifyUserRequest=$identifyUserRequest, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
