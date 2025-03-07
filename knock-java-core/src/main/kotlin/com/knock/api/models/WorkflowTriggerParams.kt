// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

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

/**
 * Trigger a workflow specified by the key to run for the given recipients, using the parameters
 * provided. Returns an identifier for the workflow run request. All workflow runs are executed
 * asynchronously.
 */
class WorkflowTriggerParams
private constructor(
    private val key: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun key(): String = key

    /**
     * Specifies a recipient in a request. This can either be a user identifier (string), an inline
     * user request (object), or an inline object request, which is determined by the presence of a
     * `collection` property.
     */
    fun actor(): Optional<RecipientRequest> = body.actor()

    /**
     * An optional key that is used in the workflow cancellation endpoint to target a cancellation
     * of any workflow runs associated with this trigger.
     */
    fun cancellationKey(): Optional<String> = body.cancellationKey()

    /**
     * An optional map of data to be used in the workflow. This data will be available to the
     * workflow as a map in the `data` field.
     */
    fun data(): Optional<Data> = body.data()

    /**
     * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
     * trigger.
     */
    fun recipients(): Optional<List<RecipientRequest>> = body.recipients()

    /** An inline tenant request */
    fun tenant(): Optional<InlineTenantRequest> = body.tenant()

    /**
     * Specifies a recipient in a request. This can either be a user identifier (string), an inline
     * user request (object), or an inline object request, which is determined by the presence of a
     * `collection` property.
     */
    fun _actor(): JsonField<RecipientRequest> = body._actor()

    /**
     * An optional key that is used in the workflow cancellation endpoint to target a cancellation
     * of any workflow runs associated with this trigger.
     */
    fun _cancellationKey(): JsonField<String> = body._cancellationKey()

    /**
     * An optional map of data to be used in the workflow. This data will be available to the
     * workflow as a map in the `data` field.
     */
    fun _data(): JsonField<Data> = body._data()

    /**
     * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
     * trigger.
     */
    fun _recipients(): JsonField<List<RecipientRequest>> = body._recipients()

    /** An inline tenant request */
    fun _tenant(): JsonField<InlineTenantRequest> = body._tenant()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> key
            else -> ""
        }
    }

    /** A set of parameters to trigger a workflow with. */
    @NoAutoDetect
    class Body
    @JsonCreator
    private constructor(
        @JsonProperty("actor")
        @ExcludeMissing
        private val actor: JsonField<RecipientRequest> = JsonMissing.of(),
        @JsonProperty("cancellation_key")
        @ExcludeMissing
        private val cancellationKey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing private val data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("recipients")
        @ExcludeMissing
        private val recipients: JsonField<List<RecipientRequest>> = JsonMissing.of(),
        @JsonProperty("tenant")
        @ExcludeMissing
        private val tenant: JsonField<InlineTenantRequest> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        fun actor(): Optional<RecipientRequest> = Optional.ofNullable(actor.getNullable("actor"))

        /**
         * An optional key that is used in the workflow cancellation endpoint to target a
         * cancellation of any workflow runs associated with this trigger.
         */
        fun cancellationKey(): Optional<String> =
            Optional.ofNullable(cancellationKey.getNullable("cancellation_key"))

        /**
         * An optional map of data to be used in the workflow. This data will be available to the
         * workflow as a map in the `data` field.
         */
        fun data(): Optional<Data> = Optional.ofNullable(data.getNullable("data"))

        /**
         * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
         * trigger.
         */
        fun recipients(): Optional<List<RecipientRequest>> =
            Optional.ofNullable(recipients.getNullable("recipients"))

        /** An inline tenant request */
        fun tenant(): Optional<InlineTenantRequest> =
            Optional.ofNullable(tenant.getNullable("tenant"))

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<RecipientRequest> = actor

        /**
         * An optional key that is used in the workflow cancellation endpoint to target a
         * cancellation of any workflow runs associated with this trigger.
         */
        @JsonProperty("cancellation_key")
        @ExcludeMissing
        fun _cancellationKey(): JsonField<String> = cancellationKey

        /**
         * An optional map of data to be used in the workflow. This data will be available to the
         * workflow as a map in the `data` field.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

        /**
         * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
         * trigger.
         */
        @JsonProperty("recipients")
        @ExcludeMissing
        fun _recipients(): JsonField<List<RecipientRequest>> = recipients

        /** An inline tenant request */
        @JsonProperty("tenant")
        @ExcludeMissing
        fun _tenant(): JsonField<InlineTenantRequest> = tenant

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            actor().ifPresent { it.validate() }
            cancellationKey()
            data().ifPresent { it.validate() }
            recipients().ifPresent { it.forEach { it.validate() } }
            tenant().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var actor: JsonField<RecipientRequest> = JsonMissing.of()
            private var cancellationKey: JsonField<String> = JsonMissing.of()
            private var data: JsonField<Data> = JsonMissing.of()
            private var recipients: JsonField<MutableList<RecipientRequest>>? = null
            private var tenant: JsonField<InlineTenantRequest> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                actor = body.actor
                cancellationKey = body.cancellationKey
                data = body.data
                recipients = body.recipients.map { it.toMutableList() }
                tenant = body.tenant
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Specifies a recipient in a request. This can either be a user identifier (string), an
             * inline user request (object), or an inline object request, which is determined by the
             * presence of a `collection` property.
             */
            fun actor(actor: RecipientRequest?) = actor(JsonField.ofNullable(actor))

            /**
             * Specifies a recipient in a request. This can either be a user identifier (string), an
             * inline user request (object), or an inline object request, which is determined by the
             * presence of a `collection` property.
             */
            fun actor(actor: Optional<RecipientRequest>) = actor(actor.orElse(null))

            /**
             * Specifies a recipient in a request. This can either be a user identifier (string), an
             * inline user request (object), or an inline object request, which is determined by the
             * presence of a `collection` property.
             */
            fun actor(actor: JsonField<RecipientRequest>) = apply { this.actor = actor }

            /** A user identifier */
            fun actor(string: String) = actor(RecipientRequest.ofString(string))

            /**
             * A set of parameters to inline-identify a user with. Inline identifying the user will
             * ensure that the user is available before the request is executed in Knock. It will
             * perform an upsert against the user you're supplying, replacing any properties
             * specified.
             */
            fun actor(inlineIdentifyUser: InlineIdentifyUserRequest) =
                actor(RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser))

            /** Inline identifies a custom object belonging to a collection */
            fun actor(inlineObject: InlineObjectRequest) =
                actor(RecipientRequest.ofInlineObject(inlineObject))

            /**
             * An optional key that is used in the workflow cancellation endpoint to target a
             * cancellation of any workflow runs associated with this trigger.
             */
            fun cancellationKey(cancellationKey: String?) =
                cancellationKey(JsonField.ofNullable(cancellationKey))

            /**
             * An optional key that is used in the workflow cancellation endpoint to target a
             * cancellation of any workflow runs associated with this trigger.
             */
            fun cancellationKey(cancellationKey: Optional<String>) =
                cancellationKey(cancellationKey.orElse(null))

            /**
             * An optional key that is used in the workflow cancellation endpoint to target a
             * cancellation of any workflow runs associated with this trigger.
             */
            fun cancellationKey(cancellationKey: JsonField<String>) = apply {
                this.cancellationKey = cancellationKey
            }

            /**
             * An optional map of data to be used in the workflow. This data will be available to
             * the workflow as a map in the `data` field.
             */
            fun data(data: Data?) = data(JsonField.ofNullable(data))

            /**
             * An optional map of data to be used in the workflow. This data will be available to
             * the workflow as a map in the `data` field.
             */
            fun data(data: Optional<Data>) = data(data.orElse(null))

            /**
             * An optional map of data to be used in the workflow. This data will be available to
             * the workflow as a map in the `data` field.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

            /**
             * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
             * trigger.
             */
            fun recipients(recipients: List<RecipientRequest>) =
                recipients(JsonField.of(recipients))

            /**
             * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
             * trigger.
             */
            fun recipients(recipients: JsonField<List<RecipientRequest>>) = apply {
                this.recipients = recipients.map { it.toMutableList() }
            }

            /**
             * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
             * trigger.
             */
            fun addRecipient(recipient: RecipientRequest) = apply {
                recipients =
                    (recipients ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recipients", it).add(recipient)
                    }
            }

            /** A user identifier */
            fun addRecipient(string: String) = addRecipient(RecipientRequest.ofString(string))

            /**
             * A set of parameters to inline-identify a user with. Inline identifying the user will
             * ensure that the user is available before the request is executed in Knock. It will
             * perform an upsert against the user you're supplying, replacing any properties
             * specified.
             */
            fun addRecipient(inlineIdentifyUser: InlineIdentifyUserRequest) =
                addRecipient(RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser))

            /** Inline identifies a custom object belonging to a collection */
            fun addRecipient(inlineObject: InlineObjectRequest) =
                addRecipient(RecipientRequest.ofInlineObject(inlineObject))

            /** An inline tenant request */
            fun tenant(tenant: InlineTenantRequest?) = tenant(JsonField.ofNullable(tenant))

            /** An inline tenant request */
            fun tenant(tenant: Optional<InlineTenantRequest>) = tenant(tenant.orElse(null))

            /** An inline tenant request */
            fun tenant(tenant: JsonField<InlineTenantRequest>) = apply { this.tenant = tenant }

            /** A tenant identifier */
            fun tenant(string: String) = tenant(InlineTenantRequest.ofString(string))

            /** A tenant to be set in the system */
            fun tenant(tenantRequest: TenantRequest) =
                tenant(InlineTenantRequest.ofTenantRequest(tenantRequest))

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

            fun build(): Body =
                Body(
                    actor,
                    cancellationKey,
                    data,
                    (recipients ?: JsonMissing.of()).map { it.toImmutable() },
                    tenant,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && actor == other.actor && cancellationKey == other.cancellationKey && data == other.data && recipients == other.recipients && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(actor, cancellationKey, data, recipients, tenant, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{actor=$actor, cancellationKey=$cancellationKey, data=$data, recipients=$recipients, tenant=$tenant, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WorkflowTriggerParams].
         *
         * The following fields are required:
         * ```java
         * .key()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WorkflowTriggerParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var key: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(workflowTriggerParams: WorkflowTriggerParams) = apply {
            key = workflowTriggerParams.key
            body = workflowTriggerParams.body.toBuilder()
            additionalHeaders = workflowTriggerParams.additionalHeaders.toBuilder()
            additionalQueryParams = workflowTriggerParams.additionalQueryParams.toBuilder()
        }

        fun key(key: String) = apply { this.key = key }

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        fun actor(actor: RecipientRequest?) = apply { body.actor(actor) }

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        fun actor(actor: Optional<RecipientRequest>) = actor(actor.orElse(null))

        /**
         * Specifies a recipient in a request. This can either be a user identifier (string), an
         * inline user request (object), or an inline object request, which is determined by the
         * presence of a `collection` property.
         */
        fun actor(actor: JsonField<RecipientRequest>) = apply { body.actor(actor) }

        /** A user identifier */
        fun actor(string: String) = apply { body.actor(string) }

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert against the user you're supplying, replacing any properties specified.
         */
        fun actor(inlineIdentifyUser: InlineIdentifyUserRequest) = apply {
            body.actor(inlineIdentifyUser)
        }

        /** Inline identifies a custom object belonging to a collection */
        fun actor(inlineObject: InlineObjectRequest) = apply { body.actor(inlineObject) }

        /**
         * An optional key that is used in the workflow cancellation endpoint to target a
         * cancellation of any workflow runs associated with this trigger.
         */
        fun cancellationKey(cancellationKey: String?) = apply {
            body.cancellationKey(cancellationKey)
        }

        /**
         * An optional key that is used in the workflow cancellation endpoint to target a
         * cancellation of any workflow runs associated with this trigger.
         */
        fun cancellationKey(cancellationKey: Optional<String>) =
            cancellationKey(cancellationKey.orElse(null))

        /**
         * An optional key that is used in the workflow cancellation endpoint to target a
         * cancellation of any workflow runs associated with this trigger.
         */
        fun cancellationKey(cancellationKey: JsonField<String>) = apply {
            body.cancellationKey(cancellationKey)
        }

        /**
         * An optional map of data to be used in the workflow. This data will be available to the
         * workflow as a map in the `data` field.
         */
        fun data(data: Data?) = apply { body.data(data) }

        /**
         * An optional map of data to be used in the workflow. This data will be available to the
         * workflow as a map in the `data` field.
         */
        fun data(data: Optional<Data>) = data(data.orElse(null))

        /**
         * An optional map of data to be used in the workflow. This data will be available to the
         * workflow as a map in the `data` field.
         */
        fun data(data: JsonField<Data>) = apply { body.data(data) }

        /**
         * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
         * trigger.
         */
        fun recipients(recipients: List<RecipientRequest>) = apply { body.recipients(recipients) }

        /**
         * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
         * trigger.
         */
        fun recipients(recipients: JsonField<List<RecipientRequest>>) = apply {
            body.recipients(recipients)
        }

        /**
         * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
         * trigger.
         */
        fun addRecipient(recipient: RecipientRequest) = apply { body.addRecipient(recipient) }

        /** A user identifier */
        fun addRecipient(string: String) = apply { body.addRecipient(string) }

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert against the user you're supplying, replacing any properties specified.
         */
        fun addRecipient(inlineIdentifyUser: InlineIdentifyUserRequest) = apply {
            body.addRecipient(inlineIdentifyUser)
        }

        /** Inline identifies a custom object belonging to a collection */
        fun addRecipient(inlineObject: InlineObjectRequest) = apply {
            body.addRecipient(inlineObject)
        }

        /** An inline tenant request */
        fun tenant(tenant: InlineTenantRequest?) = apply { body.tenant(tenant) }

        /** An inline tenant request */
        fun tenant(tenant: Optional<InlineTenantRequest>) = tenant(tenant.orElse(null))

        /** An inline tenant request */
        fun tenant(tenant: JsonField<InlineTenantRequest>) = apply { body.tenant(tenant) }

        /** A tenant identifier */
        fun tenant(string: String) = apply { body.tenant(string) }

        /** A tenant to be set in the system */
        fun tenant(tenantRequest: TenantRequest) = apply { body.tenant(tenantRequest) }

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

        fun build(): WorkflowTriggerParams =
            WorkflowTriggerParams(
                checkRequired("key", key),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /**
     * An optional map of data to be used in the workflow. This data will be available to the
     * workflow as a map in the `data` field.
     */
    @NoAutoDetect
    class Data
    @JsonCreator
    private constructor(
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                additionalProperties = data.additionalProperties.toMutableMap()
            }

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

            fun build(): Data = Data(additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Data && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Data{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is WorkflowTriggerParams && key == other.key && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(key, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "WorkflowTriggerParams{key=$key, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
