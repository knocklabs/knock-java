// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects.bulk

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
import app.knock.api.models.recipients.RecipientReference
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Delete subscriptions for many objects in a single collection type. If a subscription for an
 * object in the collection doesn't exist, it will be skipped.
 */
class BulkDeleteSubscriptionsParams
private constructor(
    private val collection: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun collection(): Optional<String> = Optional.ofNullable(collection)

    /**
     * A list of subscriptions.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun subscriptions(): List<Subscription> = body.subscriptions()

    /**
     * Returns the raw JSON value of [subscriptions].
     *
     * Unlike [subscriptions], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _subscriptions(): JsonField<List<Subscription>> = body._subscriptions()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [BulkDeleteSubscriptionsParams].
         *
         * The following fields are required:
         * ```java
         * .subscriptions()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BulkDeleteSubscriptionsParams]. */
    class Builder internal constructor() {

        private var collection: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(bulkAddSubscriptionsParams: BulkDeleteSubscriptionsParams) = apply {
            collection = bulkAddSubscriptionsParams.collection
            body = bulkAddSubscriptionsParams.body.toBuilder()
            additionalHeaders = bulkAddSubscriptionsParams.additionalHeaders.toBuilder()
            additionalQueryParams = bulkAddSubscriptionsParams.additionalQueryParams.toBuilder()
        }

        fun collection(collection: String?) = apply { this.collection = collection }

        /** Alias for calling [Builder.collection] with `collection.orElse(null)`. */
        fun collection(collection: Optional<String>) = collection(collection.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [subscriptions]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** A list of subscriptions. */
        fun subscriptions(subscriptions: List<Subscription>) = apply {
            body.subscriptions(subscriptions)
        }

        /**
         * Sets [Builder.subscriptions] to an arbitrary JSON value.
         *
         * You should usually call [Builder.subscriptions] with a well-typed `List<Subscription>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun subscriptions(subscriptions: JsonField<List<Subscription>>) = apply {
            body.subscriptions(subscriptions)
        }

        /**
         * Adds a single [Subscription] to [subscriptions].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSubscription(subscription: Subscription) = apply {
            body.addSubscription(subscription)
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
         * Returns an immutable instance of [BulkDeleteSubscriptionsParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .subscriptions()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BulkDeleteSubscriptionsParams =
            BulkDeleteSubscriptionsParams(
                collection,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> collection ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** A request to upsert subscriptions for a set of objects in a single collection. */
    class Body
    private constructor(
        private val subscriptions: JsonField<List<Subscription>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("subscriptions")
            @ExcludeMissing
            subscriptions: JsonField<List<Subscription>> = JsonMissing.of()
        ) : this(subscriptions, mutableMapOf())

        /**
         * A list of subscriptions.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun subscriptions(): List<Subscription> = subscriptions.getRequired("subscriptions")

        /**
         * Returns the raw JSON value of [subscriptions].
         *
         * Unlike [subscriptions], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("subscriptions")
        @ExcludeMissing
        fun _subscriptions(): JsonField<List<Subscription>> = subscriptions

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
             * .subscriptions()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var subscriptions: JsonField<MutableList<Subscription>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                subscriptions = body.subscriptions.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** A list of subscriptions. */
            fun subscriptions(subscriptions: List<Subscription>) =
                subscriptions(JsonField.of(subscriptions))

            /**
             * Sets [Builder.subscriptions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.subscriptions] with a well-typed
             * `List<Subscription>` value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun subscriptions(subscriptions: JsonField<List<Subscription>>) = apply {
                this.subscriptions = subscriptions.map { it.toMutableList() }
            }

            /**
             * Adds a single [Subscription] to [subscriptions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSubscription(subscription: Subscription) = apply {
                subscriptions =
                    (subscriptions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("subscriptions", it).add(subscription)
                    }
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .subscriptions()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("subscriptions", subscriptions).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            subscriptions().forEach { it.validate() }
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
            (subscriptions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && subscriptions == other.subscriptions && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(subscriptions, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{subscriptions=$subscriptions, additionalProperties=$additionalProperties}"
    }

    class Subscription
    private constructor(
        private val id: JsonField<String>,
        private val recipients: JsonField<List<RecipientReference>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("recipients")
            @ExcludeMissing
            recipients: JsonField<List<RecipientReference>> = JsonMissing.of(),
        ) : this(id, recipients, mutableMapOf())

        /**
         * Unique identifier for the object.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * The recipients of the subscription. You can unsubscribe up to 100 recipients from an
         * object at a time.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun recipients(): List<RecipientReference> = recipients.getRequired("recipients")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [recipients].
         *
         * Unlike [recipients], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("recipients")
        @ExcludeMissing
        fun _recipients(): JsonField<List<RecipientReference>> = recipients

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
             * Returns a mutable builder for constructing an instance of [Subscription].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .recipients()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Subscription]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var recipients: JsonField<MutableList<RecipientReference>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(subscription: Subscription) = apply {
                id = subscription.id
                recipients = subscription.recipients.map { it.toMutableList() }
                additionalProperties = subscription.additionalProperties.toMutableMap()
            }

            /** Unique identifier for the object. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /**
             * The recipients of the subscription. You can unsubscribe up to 100 recipients from an
             * object at a time.
             */
            fun recipients(recipients: List<RecipientReference>) =
                recipients(JsonField.of(recipients))

            /**
             * Sets [Builder.recipients] to an arbitrary JSON value.
             *
             * You should usually call [Builder.recipients] with a well-typed
             * `List<RecipientReference>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun recipients(recipients: JsonField<List<RecipientReference>>) = apply {
                this.recipients = recipients.map { it.toMutableList() }
            }

            /**
             * Adds a single [RecipientReference] to [recipients].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addRecipient(recipient: RecipientReference) = apply {
                recipients =
                    (recipients ?: JsonField.of(mutableListOf())).also {
                        checkKnown("recipients", it).add(recipient)
                    }
            }

            /** Alias for calling [addRecipient] with `RecipientReference.ofUser(user)`. */
            fun addRecipient(user: String) = addRecipient(RecipientReference.ofUser(user))

            /**
             * Alias for calling [addRecipient] with
             * `RecipientReference.ofObjectReference(objectReference)`.
             */
            fun addRecipient(objectReference: RecipientReference.ObjectReference) =
                addRecipient(RecipientReference.ofObjectReference(objectReference))

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
             * Returns an immutable instance of [Subscription].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .recipients()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Subscription =
                Subscription(
                    checkRequired("id", id),
                    checkRequired("recipients", recipients).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Subscription = apply {
            if (validated) {
                return@apply
            }

            id()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (recipients.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Subscription && id == other.id && recipients == other.recipients && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(id, recipients, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Subscription{id=$id, recipients=$recipients, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BulkDeleteSubscriptionsParams && collection == other.collection && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(collection, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BulkDeleteSubscriptionsParams{collection=$collection, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
