// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.models.recipients.preferences.PreferenceSetRequest
import java.util.Objects

/** Update a preference set */
class ObjectSetPreferencesParams
private constructor(
    private val collection: String,
    private val objectId: String,
    private val preferenceSetId: String,
    private val preferenceSetRequest: PreferenceSetRequest,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun collection(): String = collection

    fun objectId(): String = objectId

    fun preferenceSetId(): String = preferenceSetId

    /** Set preferences for a recipient */
    fun preferenceSetRequest(): PreferenceSetRequest = preferenceSetRequest

    fun _additionalBodyProperties(): Map<String, JsonValue> =
        preferenceSetRequest._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ObjectSetPreferencesParams].
         *
         * The following fields are required:
         * ```java
         * .collection()
         * .objectId()
         * .preferenceSetId()
         * .preferenceSetRequest()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ObjectSetPreferencesParams]. */
    class Builder internal constructor() {

        private var collection: String? = null
        private var objectId: String? = null
        private var preferenceSetId: String? = null
        private var preferenceSetRequest: PreferenceSetRequest? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(objectSetPreferencesParams: ObjectSetPreferencesParams) = apply {
            collection = objectSetPreferencesParams.collection
            objectId = objectSetPreferencesParams.objectId
            preferenceSetId = objectSetPreferencesParams.preferenceSetId
            preferenceSetRequest = objectSetPreferencesParams.preferenceSetRequest
            additionalHeaders = objectSetPreferencesParams.additionalHeaders.toBuilder()
            additionalQueryParams = objectSetPreferencesParams.additionalQueryParams.toBuilder()
        }

        fun collection(collection: String) = apply { this.collection = collection }

        fun objectId(objectId: String) = apply { this.objectId = objectId }

        fun preferenceSetId(preferenceSetId: String) = apply {
            this.preferenceSetId = preferenceSetId
        }

        /** Set preferences for a recipient */
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
         * Returns an immutable instance of [ObjectSetPreferencesParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .collection()
         * .objectId()
         * .preferenceSetId()
         * .preferenceSetRequest()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ObjectSetPreferencesParams =
            ObjectSetPreferencesParams(
                checkRequired("collection", collection),
                checkRequired("objectId", objectId),
                checkRequired("preferenceSetId", preferenceSetId),
                checkRequired("preferenceSetRequest", preferenceSetRequest),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): PreferenceSetRequest = preferenceSetRequest

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> collection
            1 -> objectId
            2 -> preferenceSetId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ObjectSetPreferencesParams && collection == other.collection && objectId == other.objectId && preferenceSetId == other.preferenceSetId && preferenceSetRequest == other.preferenceSetRequest && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(collection, objectId, preferenceSetId, preferenceSetRequest, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ObjectSetPreferencesParams{collection=$collection, objectId=$objectId, preferenceSetId=$preferenceSetId, preferenceSetRequest=$preferenceSetRequest, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
