// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.workflows

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.Params
import com.knock.api.core.checkKnown
import com.knock.api.core.checkRequired
import com.knock.api.core.http.Headers
import com.knock.api.core.http.QueryParams
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * When invoked for a workflow using a specific workflow key and cancellation key,
 * will cancel any queued workflow runs associated with that key/cancellation key
 * pair. Can optionally be provided one or more recipients to scope the request to.
 */
class WorkflowCancelParams private constructor(
    private val key: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,

) : Params {

    fun key(): String = key

    /**
     * The cancellation key supplied to the workflow trigger endpoint to use for
     * cancelling one or more workflow runs.
     */
    fun cancellationKey(): String = body.cancellationKey()

    /**
     * An optional list of recipients to cancel the workflow for using the cancellation
     * key.
     */
    fun recipients(): Optional<List<String>> = body.recipients()

    fun tenant(): Optional<String> = body.tenant()

    /**
     * The cancellation key supplied to the workflow trigger endpoint to use for
     * cancelling one or more workflow runs.
     */
    fun _cancellationKey(): JsonField<String> = body._cancellationKey()

    /**
     * An optional list of recipients to cancel the workflow for using the cancellation
     * key.
     */
    fun _recipients(): JsonField<List<String>> = body._recipients()

    fun _tenant(): JsonField<String> = body._tenant()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic
    internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
      return when (index) {
          0 -> key
          else -> ""
      }
    }

    /** A set of parameters to cancel a workflow with */
    @NoAutoDetect
    class Body @JsonCreator private constructor(
        @JsonProperty("cancellation_key") @ExcludeMissing private val cancellationKey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("recipients") @ExcludeMissing private val recipients: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("tenant") @ExcludeMissing private val tenant: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        /**
         * The cancellation key supplied to the workflow trigger endpoint to use for
         * cancelling one or more workflow runs.
         */
        fun cancellationKey(): String = cancellationKey.getRequired("cancellation_key")

        /**
         * An optional list of recipients to cancel the workflow for using the cancellation
         * key.
         */
        fun recipients(): Optional<List<String>> = Optional.ofNullable(recipients.getNullable("recipients"))

        fun tenant(): Optional<String> = Optional.ofNullable(tenant.getNullable("tenant"))

        /**
         * The cancellation key supplied to the workflow trigger endpoint to use for
         * cancelling one or more workflow runs.
         */
        @JsonProperty("cancellation_key")
        @ExcludeMissing
        fun _cancellationKey(): JsonField<String> = cancellationKey

        /**
         * An optional list of recipients to cancel the workflow for using the cancellation
         * key.
         */
        @JsonProperty("recipients")
        @ExcludeMissing
        fun _recipients(): JsonField<List<String>> = recipients

        @JsonProperty("tenant")
        @ExcludeMissing
        fun _tenant(): JsonField<String> = tenant

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body =
            apply {
                if (validated) {
                  return@apply
                }

                cancellationKey()
                recipients()
                tenant()
                validated = true
            }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             *
             * ```java
             * .cancellationKey()
             * ```
             */
            @JvmStatic
            fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var cancellationKey: JsonField<String>? = null
            private var recipients: JsonField<MutableList<String>>? = null
            private var tenant: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) =
                apply {
                    cancellationKey = body.cancellationKey
                    recipients = body.recipients.map { it.toMutableList() }
                    tenant = body.tenant
                    additionalProperties = body.additionalProperties.toMutableMap()
                }

            /**
             * The cancellation key supplied to the workflow trigger endpoint to use for
             * cancelling one or more workflow runs.
             */
            fun cancellationKey(cancellationKey: String) = cancellationKey(JsonField.of(cancellationKey))

            /**
             * The cancellation key supplied to the workflow trigger endpoint to use for
             * cancelling one or more workflow runs.
             */
            fun cancellationKey(cancellationKey: JsonField<String>) =
                apply {
                    this.cancellationKey = cancellationKey
                }

            /**
             * An optional list of recipients to cancel the workflow for using the cancellation
             * key.
             */
            fun recipients(recipients: List<String>?) = recipients(JsonField.ofNullable(recipients))

            /**
             * An optional list of recipients to cancel the workflow for using the cancellation
             * key.
             */
            fun recipients(recipients: Optional<List<String>>) = recipients(recipients.getOrNull())

            /**
             * An optional list of recipients to cancel the workflow for using the cancellation
             * key.
             */
            fun recipients(recipients: JsonField<List<String>>) =
                apply {
                    this.recipients = recipients.map { it.toMutableList() }
                }

            /**
             * An optional list of recipients to cancel the workflow for using the cancellation
             * key.
             */
            fun addRecipient(recipient: String) =
                apply {
                    recipients = (recipients ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recipients", it).add(recipient)
                    }
                }

            fun tenant(tenant: String?) = tenant(JsonField.ofNullable(tenant))

            fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

            fun tenant(tenant: JsonField<String>) =
                apply {
                    this.tenant = tenant
                }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

            fun putAdditionalProperty(key: String, value: JsonValue) =
                apply {
                    additionalProperties.put(key, value)
                }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                apply {
                    this.additionalProperties.putAll(additionalProperties)
                }

            fun removeAdditionalProperty(key: String) =
                apply {
                    additionalProperties.remove(key)
                }

            fun removeAllAdditionalProperties(keys: Set<String>) =
                apply {
                    keys.forEach(::removeAdditionalProperty)
                }

            fun build(): Body =
                Body(
                  checkRequired(
                    "cancellationKey", cancellationKey
                  ),
                  (recipients ?: JsonMissing.of()).map { it.toImmutable() },
                  tenant,
                  additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return /* spotless:off */ other is Body && cancellationKey == other.cancellationKey && recipients == other.recipients && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(cancellationKey, recipients, tenant, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Body{cancellationKey=$cancellationKey, recipients=$recipients, tenant=$tenant, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [WorkflowCancelParams].
         *
         * The following fields are required:
         *
         * ```java
         * .key()
         * .cancellationKey()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [WorkflowCancelParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var key: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(workflowCancelParams: WorkflowCancelParams) =
            apply {
                key = workflowCancelParams.key
                body = workflowCancelParams.body.toBuilder()
                additionalHeaders = workflowCancelParams.additionalHeaders.toBuilder()
                additionalQueryParams = workflowCancelParams.additionalQueryParams.toBuilder()
            }

        fun key(key: String) =
            apply {
                this.key = key
            }

        /**
         * The cancellation key supplied to the workflow trigger endpoint to use for
         * cancelling one or more workflow runs.
         */
        fun cancellationKey(cancellationKey: String) =
            apply {
                body.cancellationKey(cancellationKey)
            }

        /**
         * The cancellation key supplied to the workflow trigger endpoint to use for
         * cancelling one or more workflow runs.
         */
        fun cancellationKey(cancellationKey: JsonField<String>) =
            apply {
                body.cancellationKey(cancellationKey)
            }

        /**
         * An optional list of recipients to cancel the workflow for using the cancellation
         * key.
         */
        fun recipients(recipients: List<String>?) =
            apply {
                body.recipients(recipients)
            }

        /**
         * An optional list of recipients to cancel the workflow for using the cancellation
         * key.
         */
        fun recipients(recipients: Optional<List<String>>) = recipients(recipients.getOrNull())

        /**
         * An optional list of recipients to cancel the workflow for using the cancellation
         * key.
         */
        fun recipients(recipients: JsonField<List<String>>) =
            apply {
                body.recipients(recipients)
            }

        /**
         * An optional list of recipients to cancel the workflow for using the cancellation
         * key.
         */
        fun addRecipient(recipient: String) =
            apply {
                body.addRecipient(recipient)
            }

        fun tenant(tenant: String?) =
            apply {
                body.tenant(tenant)
            }

        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        fun tenant(tenant: JsonField<String>) =
            apply {
                body.tenant(tenant)
            }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.additionalProperties(additionalBodyProperties)
            }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) =
            apply {
                body.putAdditionalProperty(
                  key, value
                )
            }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) =
            apply {
                body.removeAdditionalProperty(key)
            }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) =
            apply {
                body.removeAllAdditionalProperties(keys)
            }

        fun additionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.clear()
                putAllAdditionalHeaders(additionalHeaders)
            }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.clear()
                putAllAdditionalHeaders(additionalHeaders)
            }

        fun putAdditionalHeader(name: String, value: String) =
            apply {
                additionalHeaders.put(name, value)
            }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) =
            apply {
                additionalHeaders.put(name, values)
            }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.putAll(additionalHeaders)
            }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.putAll(additionalHeaders)
            }

        fun replaceAdditionalHeaders(name: String, value: String) =
            apply {
                additionalHeaders.replace(name, value)
            }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) =
            apply {
                additionalHeaders.replace(name, values)
            }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.replaceAll(additionalHeaders)
            }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.replaceAll(additionalHeaders)
            }

        fun removeAdditionalHeaders(name: String) =
            apply {
                additionalHeaders.remove(name)
            }

        fun removeAllAdditionalHeaders(names: Set<String>) =
            apply {
                additionalHeaders.removeAll(names)
            }

        fun additionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.clear()
                putAllAdditionalQueryParams(additionalQueryParams)
            }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.clear()
                putAllAdditionalQueryParams(additionalQueryParams)
            }

        fun putAdditionalQueryParam(key: String, value: String) =
            apply {
                additionalQueryParams.put(key, value)
            }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) =
            apply {
                additionalQueryParams.put(key, values)
            }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) =
            apply {
                additionalQueryParams.replace(key, value)
            }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) =
            apply {
                additionalQueryParams.replace(key, values)
            }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) =
            apply {
                additionalQueryParams.remove(key)
            }

        fun removeAllAdditionalQueryParams(keys: Set<String>) =
            apply {
                additionalQueryParams.removeAll(keys)
            }

        fun build(): WorkflowCancelParams =
            WorkflowCancelParams(
              checkRequired(
                "key", key
              ),
              body.build(),
              additionalHeaders.build(),
              additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is WorkflowCancelParams && key == other.key && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(key, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() = "WorkflowCancelParams{key=$key, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
