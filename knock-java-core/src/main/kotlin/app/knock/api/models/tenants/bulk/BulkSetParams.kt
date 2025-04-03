// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants.bulk

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.tenants.InlineTenantRequest
import app.knock.api.models.tenants.TenantRequest
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Bulk set tenants */
class BulkSetParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun tenants(): List<InlineTenantRequest> = body.tenants()

    /**
     * Returns the raw JSON value of [tenants].
     *
     * Unlike [tenants], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tenants(): JsonField<List<InlineTenantRequest>> = body._tenants()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BulkSetParams].
         *
         * The following fields are required:
         * ```java
         * .tenants()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BulkSetParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(bulkSetParams: BulkSetParams) = apply {
            body = bulkSetParams.body.toBuilder()
            additionalHeaders = bulkSetParams.additionalHeaders.toBuilder()
            additionalQueryParams = bulkSetParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [tenants]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        fun tenants(tenants: List<InlineTenantRequest>) = apply { body.tenants(tenants) }

        /**
         * Sets [Builder.tenants] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tenants] with a well-typed `List<InlineTenantRequest>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun tenants(tenants: JsonField<List<InlineTenantRequest>>) = apply { body.tenants(tenants) }

        /**
         * Adds a single [InlineTenantRequest] to [tenants].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addTenant(tenant: InlineTenantRequest) = apply { body.addTenant(tenant) }

        /** Alias for calling [addTenant] with `InlineTenantRequest.ofString(string)`. */
        fun addTenant(string: String) = apply { body.addTenant(string) }

        /**
         * Alias for calling [addTenant] with `InlineTenantRequest.ofTenantRequest(tenantRequest)`.
         */
        fun addTenant(tenantRequest: TenantRequest) = apply { body.addTenant(tenantRequest) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
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
         * Returns an immutable instance of [BulkSetParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .tenants()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BulkSetParams =
            BulkSetParams(body.build(), additionalHeaders.build(), additionalQueryParams.build())
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** A request to set tenants in bulk */
    class Body
    private constructor(
        private val tenants: JsonField<List<InlineTenantRequest>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("tenants")
            @ExcludeMissing
            tenants: JsonField<List<InlineTenantRequest>> = JsonMissing.of()
        ) : this(tenants, mutableMapOf())

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun tenants(): List<InlineTenantRequest> = tenants.getRequired("tenants")

        /**
         * Returns the raw JSON value of [tenants].
         *
         * Unlike [tenants], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tenants")
        @ExcludeMissing
        fun _tenants(): JsonField<List<InlineTenantRequest>> = tenants

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .tenants()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var tenants: JsonField<MutableList<InlineTenantRequest>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                tenants = body.tenants.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            fun tenants(tenants: List<InlineTenantRequest>) = tenants(JsonField.of(tenants))

            /**
             * Sets [Builder.tenants] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tenants] with a well-typed
             * `List<InlineTenantRequest>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun tenants(tenants: JsonField<List<InlineTenantRequest>>) = apply {
                this.tenants = tenants.map { it.toMutableList() }
            }

            /**
             * Adds a single [InlineTenantRequest] to [tenants].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addTenant(tenant: InlineTenantRequest) = apply {
                tenants =
                    (tenants ?: JsonField.of(mutableListOf())).also {
                        checkKnown("tenants", it).add(tenant)
                    }
            }

            /** Alias for calling [addTenant] with `InlineTenantRequest.ofString(string)`. */
            fun addTenant(string: String) = addTenant(InlineTenantRequest.ofString(string))

            /**
             * Alias for calling [addTenant] with
             * `InlineTenantRequest.ofTenantRequest(tenantRequest)`.
             */
            fun addTenant(tenantRequest: TenantRequest) =
                addTenant(InlineTenantRequest.ofTenantRequest(tenantRequest))

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .tenants()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("tenants", tenants).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            tenants().forEach { it.validate() }
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: KnockInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (tenants.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && tenants == other.tenants && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(tenants, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{tenants=$tenants, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BulkSetParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BulkSetParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
