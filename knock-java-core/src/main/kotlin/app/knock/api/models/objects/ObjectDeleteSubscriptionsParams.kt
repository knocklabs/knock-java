// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

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
 * Delete subscriptions for the specified recipients from an object. Returns the list of deleted
 * subscriptions.
 */
class ObjectDeleteSubscriptionsParams
private constructor(
    private val collection: String,
    private val objectId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun collection(): String = collection

    fun objectId(): String = objectId

    /**
     * The recipients of the subscription.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun recipients(): List<Recipient> = body.recipients()

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
         * Returns a mutable builder for constructing an instance of
         * [ObjectDeleteSubscriptionsParams].
         *
         * The following fields are required:
         * ```java
         * .collection()
         * .objectId()
         * .recipients()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ObjectDeleteSubscriptionsParams]. */
    class Builder internal constructor() {

        private var collection: String? = null
        private var objectId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(objectDeleteSubscriptionsParams: ObjectDeleteSubscriptionsParams) =
            apply {
                collection = objectDeleteSubscriptionsParams.collection
                objectId = objectDeleteSubscriptionsParams.objectId
                body = objectDeleteSubscriptionsParams.body.toBuilder()
                additionalHeaders = objectDeleteSubscriptionsParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    objectDeleteSubscriptionsParams.additionalQueryParams.toBuilder()
            }

        fun collection(collection: String) = apply { this.collection = collection }

        fun objectId(objectId: String) = apply { this.objectId = objectId }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [recipients]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The recipients of the subscription. */
        fun recipients(recipients: List<Recipient>) = apply { body.recipients(recipients) }

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
         * Returns an immutable instance of [ObjectDeleteSubscriptionsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .collection()
         * .objectId()
         * .recipients()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ObjectDeleteSubscriptionsParams =
            ObjectDeleteSubscriptionsParams(
                checkRequired("collection", collection),
                checkRequired("objectId", objectId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> collection
            1 -> objectId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** A request to delete subscriptions for a set of recipients. */
    class Body
    private constructor(
        private val recipients: JsonField<List<Recipient>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("recipients")
            @ExcludeMissing
            recipients: JsonField<List<Recipient>> = JsonMissing.of()
        ) : this(recipients, mutableMapOf())

        /**
         * The recipients of the subscription.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun recipients(): List<Recipient> = recipients.getRequired("recipients")

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
             * .recipients()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var recipients: JsonField<MutableList<Recipient>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                recipients = body.recipients.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The recipients of the subscription. */
            fun recipients(recipients: List<Recipient>) = recipients(JsonField.of(recipients))

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
             * .recipients()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("recipients", recipients).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            recipients().forEach { it.validate() }
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
            (recipients.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && recipients == other.recipients && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(recipients, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{recipients=$recipients, additionalProperties=$additionalProperties}"
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

        return /* spotless:off */ other is ObjectDeleteSubscriptionsParams && collection == other.collection && objectId == other.objectId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(collection, objectId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "ObjectDeleteSubscriptionsParams{collection=$collection, objectId=$objectId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
