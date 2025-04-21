// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.Params
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Records that a guide has been seen by a user, triggering any associated seen events. */
class GuideMarkMessageAsSeenParams
private constructor(
    private val userId: String,
    private val messageId: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun userId(): String = userId

    fun messageId(): String = messageId

    /**
     * The unique identifier for the channel.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun channelId(): String = body.channelId()

    /**
     * The unique identifier for the guide.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun guideId(): String = body.guideId()

    /**
     * The key of the guide.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun guideKey(): String = body.guideKey()

    /**
     * The step reference of the guide.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun guideStepRef(): String = body.guideStepRef()

    /** The content of the guide. */
    fun _content(): JsonValue = body._content()

    /** The data of the guide. */
    fun _data(): JsonValue = body._data()

    /**
     * Whether the guide is final.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isFinal(): Optional<Boolean> = body.isFinal()

    /** The metadata of the guide. */
    fun _metadata(): JsonValue = body._metadata()

    /**
     * The tenant ID of the guide.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun tenant(): Optional<String> = body.tenant()

    /**
     * Returns the raw JSON value of [channelId].
     *
     * Unlike [channelId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _channelId(): JsonField<String> = body._channelId()

    /**
     * Returns the raw JSON value of [guideId].
     *
     * Unlike [guideId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _guideId(): JsonField<String> = body._guideId()

    /**
     * Returns the raw JSON value of [guideKey].
     *
     * Unlike [guideKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _guideKey(): JsonField<String> = body._guideKey()

    /**
     * Returns the raw JSON value of [guideStepRef].
     *
     * Unlike [guideStepRef], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _guideStepRef(): JsonField<String> = body._guideStepRef()

    /**
     * Returns the raw JSON value of [isFinal].
     *
     * Unlike [isFinal], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _isFinal(): JsonField<Boolean> = body._isFinal()

    /**
     * Returns the raw JSON value of [tenant].
     *
     * Unlike [tenant], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _tenant(): JsonField<String> = body._tenant()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [GuideMarkMessageAsSeenParams].
         *
         * The following fields are required:
         * ```java
         * .userId()
         * .messageId()
         * .channelId()
         * .guideId()
         * .guideKey()
         * .guideStepRef()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [GuideMarkMessageAsSeenParams]. */
    class Builder internal constructor() {

        private var userId: String? = null
        private var messageId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(guideMarkMessageAsSeenParams: GuideMarkMessageAsSeenParams) = apply {
            userId = guideMarkMessageAsSeenParams.userId
            messageId = guideMarkMessageAsSeenParams.messageId
            body = guideMarkMessageAsSeenParams.body.toBuilder()
            additionalHeaders = guideMarkMessageAsSeenParams.additionalHeaders.toBuilder()
            additionalQueryParams = guideMarkMessageAsSeenParams.additionalQueryParams.toBuilder()
        }

        fun userId(userId: String) = apply { this.userId = userId }

        fun messageId(messageId: String) = apply { this.messageId = messageId }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [channelId]
         * - [guideId]
         * - [guideKey]
         * - [guideStepRef]
         * - [content]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The unique identifier for the channel. */
        fun channelId(channelId: String) = apply { body.channelId(channelId) }

        /**
         * Sets [Builder.channelId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channelId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun channelId(channelId: JsonField<String>) = apply { body.channelId(channelId) }

        /** The unique identifier for the guide. */
        fun guideId(guideId: String) = apply { body.guideId(guideId) }

        /**
         * Sets [Builder.guideId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.guideId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun guideId(guideId: JsonField<String>) = apply { body.guideId(guideId) }

        /** The key of the guide. */
        fun guideKey(guideKey: String) = apply { body.guideKey(guideKey) }

        /**
         * Sets [Builder.guideKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.guideKey] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun guideKey(guideKey: JsonField<String>) = apply { body.guideKey(guideKey) }

        /** The step reference of the guide. */
        fun guideStepRef(guideStepRef: String) = apply { body.guideStepRef(guideStepRef) }

        /**
         * Sets [Builder.guideStepRef] to an arbitrary JSON value.
         *
         * You should usually call [Builder.guideStepRef] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun guideStepRef(guideStepRef: JsonField<String>) = apply {
            body.guideStepRef(guideStepRef)
        }

        /** The content of the guide. */
        fun content(content: JsonValue) = apply { body.content(content) }

        /** The data of the guide. */
        fun data(data: JsonValue) = apply { body.data(data) }

        /** Whether the guide is final. */
        fun isFinal(isFinal: Boolean) = apply { body.isFinal(isFinal) }

        /**
         * Sets [Builder.isFinal] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isFinal] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun isFinal(isFinal: JsonField<Boolean>) = apply { body.isFinal(isFinal) }

        /** The metadata of the guide. */
        fun metadata(metadata: JsonValue) = apply { body.metadata(metadata) }

        /** The tenant ID of the guide. */
        fun tenant(tenant: String?) = apply { body.tenant(tenant) }

        /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        /**
         * Sets [Builder.tenant] to an arbitrary JSON value.
         *
         * You should usually call [Builder.tenant] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun tenant(tenant: JsonField<String>) = apply { body.tenant(tenant) }

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
         * Returns an immutable instance of [GuideMarkMessageAsSeenParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .userId()
         * .messageId()
         * .channelId()
         * .guideId()
         * .guideKey()
         * .guideStepRef()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): GuideMarkMessageAsSeenParams =
            GuideMarkMessageAsSeenParams(
                checkRequired("userId", userId),
                checkRequired("messageId", messageId),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> userId
            1 -> messageId
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** A request to trigger a guide action. */
    class Body
    private constructor(
        private val channelId: JsonField<String>,
        private val guideId: JsonField<String>,
        private val guideKey: JsonField<String>,
        private val guideStepRef: JsonField<String>,
        private val content: JsonValue,
        private val data: JsonValue,
        private val isFinal: JsonField<Boolean>,
        private val metadata: JsonValue,
        private val tenant: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("channel_id")
            @ExcludeMissing
            channelId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("guide_id") @ExcludeMissing guideId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("guide_key")
            @ExcludeMissing
            guideKey: JsonField<String> = JsonMissing.of(),
            @JsonProperty("guide_step_ref")
            @ExcludeMissing
            guideStepRef: JsonField<String> = JsonMissing.of(),
            @JsonProperty("content") @ExcludeMissing content: JsonValue = JsonMissing.of(),
            @JsonProperty("data") @ExcludeMissing data: JsonValue = JsonMissing.of(),
            @JsonProperty("is_final")
            @ExcludeMissing
            isFinal: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("metadata") @ExcludeMissing metadata: JsonValue = JsonMissing.of(),
            @JsonProperty("tenant") @ExcludeMissing tenant: JsonField<String> = JsonMissing.of(),
        ) : this(
            channelId,
            guideId,
            guideKey,
            guideStepRef,
            content,
            data,
            isFinal,
            metadata,
            tenant,
            mutableMapOf(),
        )

        /**
         * The unique identifier for the channel.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun channelId(): String = channelId.getRequired("channel_id")

        /**
         * The unique identifier for the guide.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun guideId(): String = guideId.getRequired("guide_id")

        /**
         * The key of the guide.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun guideKey(): String = guideKey.getRequired("guide_key")

        /**
         * The step reference of the guide.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun guideStepRef(): String = guideStepRef.getRequired("guide_step_ref")

        /** The content of the guide. */
        @JsonProperty("content") @ExcludeMissing fun _content(): JsonValue = content

        /** The data of the guide. */
        @JsonProperty("data") @ExcludeMissing fun _data(): JsonValue = data

        /**
         * Whether the guide is final.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun isFinal(): Optional<Boolean> = isFinal.getOptional("is_final")

        /** The metadata of the guide. */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

        /**
         * The tenant ID of the guide.
         *
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun tenant(): Optional<String> = tenant.getOptional("tenant")

        /**
         * Returns the raw JSON value of [channelId].
         *
         * Unlike [channelId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("channel_id") @ExcludeMissing fun _channelId(): JsonField<String> = channelId

        /**
         * Returns the raw JSON value of [guideId].
         *
         * Unlike [guideId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("guide_id") @ExcludeMissing fun _guideId(): JsonField<String> = guideId

        /**
         * Returns the raw JSON value of [guideKey].
         *
         * Unlike [guideKey], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("guide_key") @ExcludeMissing fun _guideKey(): JsonField<String> = guideKey

        /**
         * Returns the raw JSON value of [guideStepRef].
         *
         * Unlike [guideStepRef], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("guide_step_ref")
        @ExcludeMissing
        fun _guideStepRef(): JsonField<String> = guideStepRef

        /**
         * Returns the raw JSON value of [isFinal].
         *
         * Unlike [isFinal], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("is_final") @ExcludeMissing fun _isFinal(): JsonField<Boolean> = isFinal

        /**
         * Returns the raw JSON value of [tenant].
         *
         * Unlike [tenant], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("tenant") @ExcludeMissing fun _tenant(): JsonField<String> = tenant

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
             * .channelId()
             * .guideId()
             * .guideKey()
             * .guideStepRef()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var channelId: JsonField<String>? = null
            private var guideId: JsonField<String>? = null
            private var guideKey: JsonField<String>? = null
            private var guideStepRef: JsonField<String>? = null
            private var content: JsonValue = JsonMissing.of()
            private var data: JsonValue = JsonMissing.of()
            private var isFinal: JsonField<Boolean> = JsonMissing.of()
            private var metadata: JsonValue = JsonMissing.of()
            private var tenant: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                channelId = body.channelId
                guideId = body.guideId
                guideKey = body.guideKey
                guideStepRef = body.guideStepRef
                content = body.content
                data = body.data
                isFinal = body.isFinal
                metadata = body.metadata
                tenant = body.tenant
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The unique identifier for the channel. */
            fun channelId(channelId: String) = channelId(JsonField.of(channelId))

            /**
             * Sets [Builder.channelId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.channelId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun channelId(channelId: JsonField<String>) = apply { this.channelId = channelId }

            /** The unique identifier for the guide. */
            fun guideId(guideId: String) = guideId(JsonField.of(guideId))

            /**
             * Sets [Builder.guideId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.guideId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun guideId(guideId: JsonField<String>) = apply { this.guideId = guideId }

            /** The key of the guide. */
            fun guideKey(guideKey: String) = guideKey(JsonField.of(guideKey))

            /**
             * Sets [Builder.guideKey] to an arbitrary JSON value.
             *
             * You should usually call [Builder.guideKey] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun guideKey(guideKey: JsonField<String>) = apply { this.guideKey = guideKey }

            /** The step reference of the guide. */
            fun guideStepRef(guideStepRef: String) = guideStepRef(JsonField.of(guideStepRef))

            /**
             * Sets [Builder.guideStepRef] to an arbitrary JSON value.
             *
             * You should usually call [Builder.guideStepRef] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun guideStepRef(guideStepRef: JsonField<String>) = apply {
                this.guideStepRef = guideStepRef
            }

            /** The content of the guide. */
            fun content(content: JsonValue) = apply { this.content = content }

            /** The data of the guide. */
            fun data(data: JsonValue) = apply { this.data = data }

            /** Whether the guide is final. */
            fun isFinal(isFinal: Boolean) = isFinal(JsonField.of(isFinal))

            /**
             * Sets [Builder.isFinal] to an arbitrary JSON value.
             *
             * You should usually call [Builder.isFinal] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun isFinal(isFinal: JsonField<Boolean>) = apply { this.isFinal = isFinal }

            /** The metadata of the guide. */
            fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

            /** The tenant ID of the guide. */
            fun tenant(tenant: String?) = tenant(JsonField.ofNullable(tenant))

            /** Alias for calling [Builder.tenant] with `tenant.orElse(null)`. */
            fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

            /**
             * Sets [Builder.tenant] to an arbitrary JSON value.
             *
             * You should usually call [Builder.tenant] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun tenant(tenant: JsonField<String>) = apply { this.tenant = tenant }

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
             * .channelId()
             * .guideId()
             * .guideKey()
             * .guideStepRef()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("channelId", channelId),
                    checkRequired("guideId", guideId),
                    checkRequired("guideKey", guideKey),
                    checkRequired("guideStepRef", guideStepRef),
                    content,
                    data,
                    isFinal,
                    metadata,
                    tenant,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            channelId()
            guideId()
            guideKey()
            guideStepRef()
            isFinal()
            tenant()
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
            (if (channelId.asKnown().isPresent) 1 else 0) +
                (if (guideId.asKnown().isPresent) 1 else 0) +
                (if (guideKey.asKnown().isPresent) 1 else 0) +
                (if (guideStepRef.asKnown().isPresent) 1 else 0) +
                (if (isFinal.asKnown().isPresent) 1 else 0) +
                (if (tenant.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Body && channelId == other.channelId && guideId == other.guideId && guideKey == other.guideKey && guideStepRef == other.guideStepRef && content == other.content && data == other.data && isFinal == other.isFinal && metadata == other.metadata && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(channelId, guideId, guideKey, guideStepRef, content, data, isFinal, metadata, tenant, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{channelId=$channelId, guideId=$guideId, guideKey=$guideKey, guideStepRef=$guideStepRef, content=$content, data=$data, isFinal=$isFinal, metadata=$metadata, tenant=$tenant, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is GuideMarkMessageAsSeenParams && userId == other.userId && messageId == other.messageId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(userId, messageId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "GuideMarkMessageAsSeenParams{userId=$userId, messageId=$messageId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
