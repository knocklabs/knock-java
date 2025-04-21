// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflows

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.allMaxBy
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.objects.InlineObjectRequest
import app.knock.api.models.users.InlineIdentifyUserRequest
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * When invoked for a workflow using a specific workflow key and cancellation key, will cancel any
 * queued workflow runs associated with that key/cancellation key pair. Can optionally be provided
 * one or more recipients to scope the request to.
 */
class WorkflowCancelParams
private constructor(
    private val key: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun key(): String = key

    /**
     * An optional key that is used to reference a specific workflow trigger request when issuing a
     * [workflow cancellation](/send-notifications/canceling-workflows) request. Must be provided
     * while triggering a workflow in order to enable subsequent cancellation. Should be unique
     * across trigger requests to avoid unintentional cancellations.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun cancellationKey(): String = body.cancellationKey()

    /**
     * A list of recipients to cancel the notification for. If omitted, cancels for all recipients
     * associated with the cancellation key.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun recipients(): Optional<List<Recipient>> = body.recipients()

    /**
     * Returns the raw JSON value of [cancellationKey].
     *
     * Unlike [cancellationKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _cancellationKey(): JsonField<String> = body._cancellationKey()

    /**
     * Returns the raw JSON value of [recipients].
     *
     * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _recipients(): JsonField<List<Recipient>> = body._recipients()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WorkflowCancelParams].
         *
         * The following fields are required:
         * ```java
         * .key()
         * .cancellationKey()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WorkflowCancelParams]. */
    class Builder internal constructor() {

        private var key: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(workflowCancelParams: WorkflowCancelParams) = apply {
            key = workflowCancelParams.key
            body = workflowCancelParams.body.toBuilder()
            additionalHeaders = workflowCancelParams.additionalHeaders.toBuilder()
            additionalQueryParams = workflowCancelParams.additionalQueryParams.toBuilder()
        }

        fun key(key: String) = apply { this.key = key }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [cancellationKey]
         * - [recipients]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * An optional key that is used to reference a specific workflow trigger request when
         * issuing a [workflow cancellation](/send-notifications/canceling-workflows) request. Must
         * be provided while triggering a workflow in order to enable subsequent cancellation.
         * Should be unique across trigger requests to avoid unintentional cancellations.
         */
        fun cancellationKey(cancellationKey: String) = apply {
            body.cancellationKey(cancellationKey)
        }

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
         * A list of recipients to cancel the notification for. If omitted, cancels for all
         * recipients associated with the cancellation key.
         */
        fun recipients(recipients: List<Recipient>?) = apply { body.recipients(recipients) }

        /** Alias for calling [Builder.recipients] with `recipients.orElse(null)`. */
        fun recipients(recipients: Optional<List<Recipient>>) = recipients(recipients.getOrNull())

        /**
         * Sets [Builder.recipients] to an arbitrary JSON value.
         *
         * You should usually call [Builder.recipients] with a well-typed `List<Recipient>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun recipients(recipients: JsonField<List<Recipient>>) = apply {
            body.recipients(recipients)
        }

        /**
         * Adds a single [Recipient] to [recipients].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addRecipient(recipient: Recipient) = apply { body.addRecipient(recipient) }

        /** Alias for calling [addRecipient] with `Recipient.ofUser(user)`. */
        fun addRecipient(user: String) = apply { body.addRecipient(user) }

        /**
         * Alias for calling [addRecipient] with
         * `Recipient.ofInlineIdentifyUserRequest(inlineIdentifyUserRequest)`.
         */
        fun addRecipient(inlineIdentifyUserRequest: InlineIdentifyUserRequest) = apply {
            body.addRecipient(inlineIdentifyUserRequest)
        }

        /**
         * Alias for calling [addRecipient] with
         * `Recipient.ofInlineObjectRequest(inlineObjectRequest)`.
         */
        fun addRecipient(inlineObjectRequest: InlineObjectRequest) = apply {
            body.addRecipient(inlineObjectRequest)
        }

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
         * Returns an immutable instance of [WorkflowCancelParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .key()
         * .cancellationKey()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WorkflowCancelParams =
            WorkflowCancelParams(
                checkRequired("key", key),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> key
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /**
     * When invoked using a specific workflow key and cancellation key, will cancel any queued
     * workflow runs associated with that key/cancellation key pair. Can optionally provide one or
     * more recipients to scope the request to.
     */
    class Body
    private constructor(
        private val cancellationKey: JsonField<String>,
        private val recipients: JsonField<List<Recipient>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("cancellation_key")
            @ExcludeMissing
            cancellationKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("recipients")
            @ExcludeMissing
            recipients: JsonField<List<Recipient>> = JsonMissing.of(),
        ) : this(cancellationKey, recipients, mutableMapOf())

        /**
         * An optional key that is used to reference a specific workflow trigger request when
         * issuing a [workflow cancellation](/send-notifications/canceling-workflows) request. Must
         * be provided while triggering a workflow in order to enable subsequent cancellation.
         * Should be unique across trigger requests to avoid unintentional cancellations.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun cancellationKey(): String = cancellationKey.getRequired("cancellation_key")

        /**
         * A list of recipients to cancel the notification for. If omitted, cancels for all
         * recipients associated with the cancellation key.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun recipients(): Optional<List<Recipient>> = recipients.getOptional("recipients")

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
         * Returns the raw JSON value of [recipients].
         *
         * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recipients")
        @ExcludeMissing
        fun _recipients(): JsonField<List<Recipient>> = recipients

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
             * .cancellationKey()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var cancellationKey: JsonField<String>? = null
            private var recipients: JsonField<MutableList<Recipient>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                cancellationKey = body.cancellationKey
                recipients = body.recipients.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * An optional key that is used to reference a specific workflow trigger request when
             * issuing a [workflow cancellation](/send-notifications/canceling-workflows) request.
             * Must be provided while triggering a workflow in order to enable subsequent
             * cancellation. Should be unique across trigger requests to avoid unintentional
             * cancellations.
             */
            fun cancellationKey(cancellationKey: String) =
                cancellationKey(JsonField.of(cancellationKey))

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
             * A list of recipients to cancel the notification for. If omitted, cancels for all
             * recipients associated with the cancellation key.
             */
            fun recipients(recipients: List<Recipient>?) =
                recipients(JsonField.ofNullable(recipients))

            /** Alias for calling [Builder.recipients] with `recipients.orElse(null)`. */
            fun recipients(recipients: Optional<List<Recipient>>) =
                recipients(recipients.getOrNull())

            /**
             * Sets [Builder.recipients] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recipients] with a well-typed `List<Recipient>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun recipients(recipients: JsonField<List<Recipient>>) = apply {
                this.recipients = recipients.map { it.toMutableList() }
            }

            /**
             * Adds a single [Recipient] to [recipients].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRecipient(recipient: Recipient) = apply {
                recipients =
                    (recipients ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recipients", it).add(recipient)
                    }
            }

            /** Alias for calling [addRecipient] with `Recipient.ofUser(user)`. */
            fun addRecipient(user: String) = addRecipient(Recipient.ofUser(user))

            /**
             * Alias for calling [addRecipient] with
             * `Recipient.ofInlineIdentifyUserRequest(inlineIdentifyUserRequest)`.
             */
            fun addRecipient(inlineIdentifyUserRequest: InlineIdentifyUserRequest) =
                addRecipient(Recipient.ofInlineIdentifyUserRequest(inlineIdentifyUserRequest))

            /**
             * Alias for calling [addRecipient] with
             * `Recipient.ofInlineObjectRequest(inlineObjectRequest)`.
             */
            fun addRecipient(inlineObjectRequest: InlineObjectRequest) =
                addRecipient(Recipient.ofInlineObjectRequest(inlineObjectRequest))

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
             * .cancellationKey()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("cancellationKey", cancellationKey),
                    (recipients ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            cancellationKey()
            recipients().ifPresent { it.forEach { it.validate() } }
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
            (if (cancellationKey.asKnown().isPresent) 1 else 0) +
                (recipients.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && cancellationKey == other.cancellationKey && recipients == other.recipients && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(cancellationKey, recipients, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{cancellationKey=$cancellationKey, recipients=$recipients, additionalProperties=$additionalProperties}"
    }

    /**
     * Specifies a recipient in a request. This can either be a user identifier (string), an inline
     * user request (object), or an inline object request, which is determined by the presence of a
     * `collection` property.
     */
    @JsonDeserialize(using = Recipient.Deserializer::class)
    @JsonSerialize(using = Recipient.Serializer::class)
    class Recipient
    private constructor(
        private val user: String? = null,
        private val inlineIdentifyUserRequest: InlineIdentifyUserRequest? = null,
        private val inlineObjectRequest: InlineObjectRequest? = null,
        private val _json: JsonValue? = null,
    ) {

        /** The ID of the user. */
        fun user(): Optional<String> = Optional.ofNullable(user)

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert for the user you're supplying, replacing any properties specified.
         */
        fun inlineIdentifyUserRequest(): Optional<InlineIdentifyUserRequest> =
            Optional.ofNullable(inlineIdentifyUserRequest)

        /** A custom object entity which belongs to a collection. */
        fun inlineObjectRequest(): Optional<InlineObjectRequest> =
            Optional.ofNullable(inlineObjectRequest)

        fun isUser(): Boolean = user != null

        fun isInlineIdentifyUserRequest(): Boolean = inlineIdentifyUserRequest != null

        fun isInlineObjectRequest(): Boolean = inlineObjectRequest != null

        /** The ID of the user. */
        fun asUser(): String = user.getOrThrow("user")

        /**
         * A set of parameters to inline-identify a user with. Inline identifying the user will
         * ensure that the user is available before the request is executed in Knock. It will
         * perform an upsert for the user you're supplying, replacing any properties specified.
         */
        fun asInlineIdentifyUserRequest(): InlineIdentifyUserRequest =
            inlineIdentifyUserRequest.getOrThrow("inlineIdentifyUserRequest")

        /** A custom object entity which belongs to a collection. */
        fun asInlineObjectRequest(): InlineObjectRequest =
            inlineObjectRequest.getOrThrow("inlineObjectRequest")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                user != null -> visitor.visitUser(user)
                inlineIdentifyUserRequest != null ->
                    visitor.visitInlineIdentifyUserRequest(inlineIdentifyUserRequest)
                inlineObjectRequest != null -> visitor.visitInlineObjectRequest(inlineObjectRequest)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Recipient = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitUser(user: String) {}

                    override fun visitInlineIdentifyUserRequest(
                        inlineIdentifyUserRequest: InlineIdentifyUserRequest
                    ) {
                        inlineIdentifyUserRequest.validate()
                    }

                    override fun visitInlineObjectRequest(
                        inlineObjectRequest: InlineObjectRequest
                    ) {
                        inlineObjectRequest.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitUser(user: String) = 1

                    override fun visitInlineIdentifyUserRequest(
                        inlineIdentifyUserRequest: InlineIdentifyUserRequest
                    ) = inlineIdentifyUserRequest.validity()

                    override fun visitInlineObjectRequest(
                        inlineObjectRequest: InlineObjectRequest
                    ) = inlineObjectRequest.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Recipient && user == other.user && inlineIdentifyUserRequest == other.inlineIdentifyUserRequest && inlineObjectRequest == other.inlineObjectRequest /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(user, inlineIdentifyUserRequest, inlineObjectRequest) /* spotless:on */

        override fun toString(): String =
            when {
                user != null -> "Recipient{user=$user}"
                inlineIdentifyUserRequest != null ->
                    "Recipient{inlineIdentifyUserRequest=$inlineIdentifyUserRequest}"
                inlineObjectRequest != null -> "Recipient{inlineObjectRequest=$inlineObjectRequest}"
                _json != null -> "Recipient{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Recipient")
            }

        companion object {

            /** The ID of the user. */
            @JvmStatic fun ofUser(user: String) = Recipient(user = user)

            /**
             * A set of parameters to inline-identify a user with. Inline identifying the user will
             * ensure that the user is available before the request is executed in Knock. It will
             * perform an upsert for the user you're supplying, replacing any properties specified.
             */
            @JvmStatic
            fun ofInlineIdentifyUserRequest(inlineIdentifyUserRequest: InlineIdentifyUserRequest) =
                Recipient(inlineIdentifyUserRequest = inlineIdentifyUserRequest)

            /** A custom object entity which belongs to a collection. */
            @JvmStatic
            fun ofInlineObjectRequest(inlineObjectRequest: InlineObjectRequest) =
                Recipient(inlineObjectRequest = inlineObjectRequest)
        }

        /**
         * An interface that defines how to map each variant of [Recipient] to a value of type [T].
         */
        interface Visitor<out T> {

            /** The ID of the user. */
            fun visitUser(user: String): T

            /**
             * A set of parameters to inline-identify a user with. Inline identifying the user will
             * ensure that the user is available before the request is executed in Knock. It will
             * perform an upsert for the user you're supplying, replacing any properties specified.
             */
            fun visitInlineIdentifyUserRequest(
                inlineIdentifyUserRequest: InlineIdentifyUserRequest
            ): T

            /** A custom object entity which belongs to a collection. */
            fun visitInlineObjectRequest(inlineObjectRequest: InlineObjectRequest): T

            /**
             * Maps an unknown variant of [Recipient] to a value of type [T].
             *
             * An instance of [Recipient] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Recipient: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Recipient>(Recipient::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Recipient {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<InlineIdentifyUserRequest>())?.let {
                                Recipient(inlineIdentifyUserRequest = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<InlineObjectRequest>())?.let {
                                Recipient(inlineObjectRequest = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                                Recipient(user = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from array).
                    0 -> Recipient(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Recipient>(Recipient::class) {

            override fun serialize(
                value: Recipient,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.user != null -> generator.writeObject(value.user)
                    value.inlineIdentifyUserRequest != null ->
                        generator.writeObject(value.inlineIdentifyUserRequest)
                    value.inlineObjectRequest != null ->
                        generator.writeObject(value.inlineObjectRequest)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Recipient")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is WorkflowCancelParams && key == other.key && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(key, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "WorkflowCancelParams{key=$key, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
