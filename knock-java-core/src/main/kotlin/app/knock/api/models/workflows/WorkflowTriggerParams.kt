// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflows

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.Params
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.recipients.RecipientRequest
import app.knock.api.models.tenants.InlineTenantRequest
import app.knock.api.models.tenants.TenantRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

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
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun actor(): Optional<RecipientRequest> = body.actor()

    /**
     * An optional key that is used in the workflow cancellation endpoint to target a cancellation
     * of any workflow runs associated with this trigger.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun cancellationKey(): Optional<String> = body.cancellationKey()

    /**
     * An optional map of data to be used in the workflow. This data will be available to the
     * workflow as a map in the `data` field.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<Data> = body.data()

    /**
     * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
     * trigger.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun recipients(): Optional<List<RecipientRequest>> = body.recipients()

    /**
     * An inline tenant request
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tenant(): Optional<InlineTenantRequest> = body.tenant()

    /**
     * Returns the raw JSON value of [actor].
     *
     * Unlike [actor], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _actor(): JsonField<RecipientRequest> = body._actor()

    /**
     * Returns the raw JSON value of [cancellationKey].
     *
     * Unlike [cancellationKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _cancellationKey(): JsonField<String> = body._cancellationKey()

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _data(): JsonField<Data> = body._data()

    /**
     * Returns the raw JSON value of [recipients].
     *
     * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _recipients(): JsonField<List<RecipientRequest>> = body._recipients()

    /**
     * Returns the raw JSON value of [tenant].
     *
     * Unlike [tenant], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tenant(): JsonField<InlineTenantRequest> = body._tenant()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic internal fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> key
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

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
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun actor(): Optional<RecipientRequest> = Optional.ofNullable(actor.getNullable("actor"))

        /**
         * An optional key that is used in the workflow cancellation endpoint to target a
         * cancellation of any workflow runs associated with this trigger.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun cancellationKey(): Optional<String> =
            Optional.ofNullable(cancellationKey.getNullable("cancellation_key"))

        /**
         * An optional map of data to be used in the workflow. This data will be available to the
         * workflow as a map in the `data` field.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun data(): Optional<Data> = Optional.ofNullable(data.getNullable("data"))

        /**
         * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
         * trigger.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun recipients(): Optional<List<RecipientRequest>> =
            Optional.ofNullable(recipients.getNullable("recipients"))

        /**
         * An inline tenant request
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tenant(): Optional<InlineTenantRequest> =
            Optional.ofNullable(tenant.getNullable("tenant"))

        /**
         * Returns the raw JSON value of [actor].
         *
         * Unlike [actor], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("actor") @ExcludeMissing fun _actor(): JsonField<RecipientRequest> = actor

        /**
         * Returns the raw JSON value of [cancellationKey].
         *
         * Unlike [cancellationKey], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cancellation_key")
        @ExcludeMissing
        fun _cancellationKey(): JsonField<String> = cancellationKey

        /**
         * Returns the raw JSON value of [data].
         *
         * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

        /**
         * Returns the raw JSON value of [recipients].
         *
         * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recipients")
        @ExcludeMissing
        fun _recipients(): JsonField<List<RecipientRequest>> = recipients

        /**
         * Returns the raw JSON value of [tenant].
         *
         * Unlike [tenant], this method doesn't throw if the JSON field has an unexpected type.
         */
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

            /** Alias for calling [Builder.actor] with `actor.orElse(null)`. */
            fun actor(actor: Optional<RecipientRequest>) = actor(actor.getOrNull())

            /**
             * Sets [Builder.actor] to an arbitrary JSON value.
             *
             * You should usually call [Builder.actor] with a well-typed [RecipientRequest] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun actor(actor: JsonField<RecipientRequest>) = apply { this.actor = actor }

            /** Alias for calling [actor] with `RecipientRequest.ofString(string)`. */
            fun actor(string: String) = actor(RecipientRequest.ofString(string))

            /**
             * Alias for calling [actor] with
             * `RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser)`.
             */
            fun actor(inlineIdentifyUser: InlineIdentifyUserRequest) =
                actor(RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser))

            /** Alias for calling [actor] with `RecipientRequest.ofInlineObject(inlineObject)`. */
            fun actor(inlineObject: InlineObjectRequest) =
                actor(RecipientRequest.ofInlineObject(inlineObject))

            /**
             * An optional key that is used in the workflow cancellation endpoint to target a
             * cancellation of any workflow runs associated with this trigger.
             */
            fun cancellationKey(cancellationKey: String?) =
                cancellationKey(JsonField.ofNullable(cancellationKey))

            /** Alias for calling [Builder.cancellationKey] with `cancellationKey.orElse(null)`. */
            fun cancellationKey(cancellationKey: Optional<String>) =
                cancellationKey(cancellationKey.getOrNull())

            /**
             * Sets [Builder.cancellationKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.cancellationKey] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun cancellationKey(cancellationKey: JsonField<String>) = apply {
                this.cancellationKey = cancellationKey
            }

            /**
             * An optional map of data to be used in the workflow. This data will be available to
             * the workflow as a map in the `data` field.
             */
            fun data(data: Data?) = data(JsonField.ofNullable(data))

            /** Alias for calling [Builder.data] with `data.orElse(null)`. */
            fun data(data: Optional<Data>) = data(data.getOrNull())

            /**
             * Sets [Builder.data] to an arbitrary JSON value.
             *
             * You should usually call [Builder.data] with a well-typed [Data] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun data(data: JsonField<Data>) = apply { this.data = data }

            /**
             * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
             * trigger.
             */
            fun recipients(recipients: List<RecipientRequest>) =
                recipients(JsonField.of(recipients))

            /**
             * Sets [Builder.recipients] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recipients] with a well-typed
             * `List<RecipientRequest>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun recipients(recipients: JsonField<List<RecipientRequest>>) = apply {
                this.recipients = recipients.map { it.toMutableList() }
            }

            /**
             * Adds a single [RecipientRequest] to [recipients].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRecipient(recipient: RecipientRequest) = apply {
                recipients =
                    (recipients ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recipients", it).add(recipient)
                    }
            }

            /** Alias for calling [addRecipient] with `RecipientRequest.ofString(string)`. */
            fun addRecipient(string: String) = addRecipient(RecipientRequest.ofString(string))

            /**
             * Alias for calling [addRecipient] with
             * `RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser)`.
             */
            fun addRecipient(inlineIdentifyUser: InlineIdentifyUserRequest) =
                addRecipient(RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser))

            /**
             * Alias for calling [addRecipient] with
             * `RecipientRequest.ofInlineObject(inlineObject)`.
             */
            fun addRecipient(inlineObject: InlineObjectRequest) =
                addRecipient(RecipientRequest.ofInlineObject(inlineObject))

            /** An inline tenant request */
            fun tenant(tenant: InlineTenantRequest?) = tenant(JsonField.ofNullable(tenant))

            /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
            fun tenant(tenant: Optional<InlineTenantRequest>) = tenant(tenant.getOrNull())

            /**
             * Sets [Builder.tenant] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tenant] with a well-typed [InlineTenantRequest]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun tenant(tenant: JsonField<InlineTenantRequest>) = apply { this.tenant = tenant }

            /** Alias for calling [tenant] with `InlineTenantRequest.ofString(string)`. */
            fun tenant(string: String) = tenant(InlineTenantRequest.ofString(string))

            /**
             * Alias for calling [tenant] with `InlineTenantRequest.ofTenantRequest(tenantRequest)`.
             */
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

            /**
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
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

        /** Alias for calling [Builder.actor] with `actor.orElse(null)`. */
        fun actor(actor: Optional<RecipientRequest>) = actor(actor.getOrNull())

        /**
         * Sets [Builder.actor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.actor] with a well-typed [RecipientRequest] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun actor(actor: JsonField<RecipientRequest>) = apply { body.actor(actor) }

        /** Alias for calling [actor] with `RecipientRequest.ofString(string)`. */
        fun actor(string: String) = apply { body.actor(string) }

        /**
         * Alias for calling [actor] with
         * `RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser)`.
         */
        fun actor(inlineIdentifyUser: InlineIdentifyUserRequest) = apply {
            body.actor(inlineIdentifyUser)
        }

        /** Alias for calling [actor] with `RecipientRequest.ofInlineObject(inlineObject)`. */
        fun actor(inlineObject: InlineObjectRequest) = apply { body.actor(inlineObject) }

        /**
         * An optional key that is used in the workflow cancellation endpoint to target a
         * cancellation of any workflow runs associated with this trigger.
         */
        fun cancellationKey(cancellationKey: String?) = apply {
            body.cancellationKey(cancellationKey)
        }

        /** Alias for calling [Builder.cancellationKey] with `cancellationKey.orElse(null)`. */
        fun cancellationKey(cancellationKey: Optional<String>) =
            cancellationKey(cancellationKey.getOrNull())

        /**
         * Sets [Builder.cancellationKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.cancellationKey] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun cancellationKey(cancellationKey: JsonField<String>) = apply {
            body.cancellationKey(cancellationKey)
        }

        /**
         * An optional map of data to be used in the workflow. This data will be available to the
         * workflow as a map in the `data` field.
         */
        fun data(data: Data?) = apply { body.data(data) }

        /** Alias for calling [Builder.data] with `data.orElse(null)`. */
        fun data(data: Optional<Data>) = data(data.getOrNull())

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { body.data(data) }

        /**
         * The recipients to trigger the workflow for. Cannot exceed 1000 recipients in a single
         * trigger.
         */
        fun recipients(recipients: List<RecipientRequest>) = apply { body.recipients(recipients) }

        /**
         * Sets [Builder.recipients] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipients] with a well-typed `List<RecipientRequest>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun recipients(recipients: JsonField<List<RecipientRequest>>) = apply {
            body.recipients(recipients)
        }

        /**
         * Adds a single [RecipientRequest] to [recipients].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRecipient(recipient: RecipientRequest) = apply { body.addRecipient(recipient) }

        /** Alias for calling [addRecipient] with `RecipientRequest.ofString(string)`. */
        fun addRecipient(string: String) = apply { body.addRecipient(string) }

        /**
         * Alias for calling [addRecipient] with
         * `RecipientRequest.ofInlineIdentifyUser(inlineIdentifyUser)`.
         */
        fun addRecipient(inlineIdentifyUser: InlineIdentifyUserRequest) = apply {
            body.addRecipient(inlineIdentifyUser)
        }

        /**
         * Alias for calling [addRecipient] with `RecipientRequest.ofInlineObject(inlineObject)`.
         */
        fun addRecipient(inlineObject: InlineObjectRequest) = apply {
            body.addRecipient(inlineObject)
        }

        /** An inline tenant request */
        fun tenant(tenant: InlineTenantRequest?) = apply { body.tenant(tenant) }

        /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
        fun tenant(tenant: Optional<InlineTenantRequest>) = tenant(tenant.getOrNull())

        /**
         * Sets [Builder.tenant] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tenant] with a well-typed [InlineTenantRequest] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun tenant(tenant: JsonField<InlineTenantRequest>) = apply { body.tenant(tenant) }

        /** Alias for calling [tenant] with `InlineTenantRequest.ofString(string)`. */
        fun tenant(string: String) = apply { body.tenant(string) }

        /** Alias for calling [tenant] with `InlineTenantRequest.ofTenantRequest(tenantRequest)`. */
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

        /**
         * Returns an immutable instance of [WorkflowTriggerParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .key()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
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

            /**
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
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
