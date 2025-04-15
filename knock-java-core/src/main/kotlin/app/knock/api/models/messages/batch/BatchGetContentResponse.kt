// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages.batch

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.Enum
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.allMaxBy
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The contents of a message */
class BatchGetContentResponse
private constructor(
    private val _typename: JsonField<String>,
    private val data: JsonField<Data>,
    private val insertedAt: JsonField<OffsetDateTime>,
    private val messageId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("__typename") @ExcludeMissing _typename: JsonField<String> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("inserted_at")
        @ExcludeMissing
        insertedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("message_id") @ExcludeMissing messageId: JsonField<String> = JsonMissing.of(),
    ) : this(_typename, data, insertedAt, messageId, mutableMapOf())

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun _typename(): String = _typename.getRequired("__typename")

    /**
     * The contents of an email message
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): Data = data.getRequired("data")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun insertedAt(): OffsetDateTime = insertedAt.getRequired("inserted_at")

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun messageId(): String = messageId.getRequired("message_id")

    /**
     * Returns the raw JSON value of [_typename].
     *
     * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [insertedAt].
     *
     * Unlike [insertedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inserted_at")
    @ExcludeMissing
    fun _insertedAt(): JsonField<OffsetDateTime> = insertedAt

    /**
     * Returns the raw JSON value of [messageId].
     *
     * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

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
         * Returns a mutable builder for constructing an instance of [BatchGetContentResponse].
         *
         * The following fields are required:
         * ```java
         * ._typename()
         * .data()
         * .insertedAt()
         * .messageId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [BatchGetContentResponse]. */
    class Builder internal constructor() {

        private var _typename: JsonField<String>? = null
        private var data: JsonField<Data>? = null
        private var insertedAt: JsonField<OffsetDateTime>? = null
        private var messageId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(batchGetContentResponse: BatchGetContentResponse) = apply {
            _typename = batchGetContentResponse._typename
            data = batchGetContentResponse.data
            insertedAt = batchGetContentResponse.insertedAt
            messageId = batchGetContentResponse.messageId
            additionalProperties = batchGetContentResponse.additionalProperties.toMutableMap()
        }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        /**
         * Sets [Builder._typename] to an arbitrary JSON value.
         *
         * You should usually call [Builder._typename] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** The contents of an email message */
        fun data(data: Data) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** Alias for calling [data] with `Data.ofMessageEmailContent(messageEmailContent)`. */
        fun data(messageEmailContent: Data.MessageEmailContent) =
            data(Data.ofMessageEmailContent(messageEmailContent))

        /** Alias for calling [data] with `Data.ofMessageSmsContent(messageSmsContent)`. */
        fun data(messageSmsContent: Data.MessageSmsContent) =
            data(Data.ofMessageSmsContent(messageSmsContent))

        /** Alias for calling [data] with `Data.ofMessagePushContent(messagePushContent)`. */
        fun data(messagePushContent: Data.MessagePushContent) =
            data(Data.ofMessagePushContent(messagePushContent))

        /** Alias for calling [data] with `Data.ofMessageChatContent(messageChatContent)`. */
        fun data(messageChatContent: Data.MessageChatContent) =
            data(Data.ofMessageChatContent(messageChatContent))

        /**
         * Alias for calling [data] with `Data.ofMessageInAppFeedContent(messageInAppFeedContent)`.
         */
        fun data(messageInAppFeedContent: Data.MessageInAppFeedContent) =
            data(Data.ofMessageInAppFeedContent(messageInAppFeedContent))

        fun insertedAt(insertedAt: OffsetDateTime) = insertedAt(JsonField.of(insertedAt))

        /**
         * Sets [Builder.insertedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.insertedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun insertedAt(insertedAt: JsonField<OffsetDateTime>) = apply {
            this.insertedAt = insertedAt
        }

        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

        /**
         * Sets [Builder.messageId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.messageId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

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
         * Returns an immutable instance of [BatchGetContentResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * ._typename()
         * .data()
         * .insertedAt()
         * .messageId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): BatchGetContentResponse =
            BatchGetContentResponse(
                checkRequired("_typename", _typename),
                checkRequired("data", data),
                checkRequired("insertedAt", insertedAt),
                checkRequired("messageId", messageId),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): BatchGetContentResponse = apply {
        if (validated) {
            return@apply
        }

        _typename()
        data().validate()
        insertedAt()
        messageId()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (_typename.asKnown().isPresent) 1 else 0) +
            (data.asKnown().getOrNull()?.validity() ?: 0) +
            (if (insertedAt.asKnown().isPresent) 1 else 0) +
            (if (messageId.asKnown().isPresent) 1 else 0)

    /** The contents of an email message */
    @JsonDeserialize(using = Data.Deserializer::class)
    @JsonSerialize(using = Data.Serializer::class)
    class Data
    private constructor(
        private val messageEmailContent: MessageEmailContent? = null,
        private val messageSmsContent: MessageSmsContent? = null,
        private val messagePushContent: MessagePushContent? = null,
        private val messageChatContent: MessageChatContent? = null,
        private val messageInAppFeedContent: MessageInAppFeedContent? = null,
        private val _json: JsonValue? = null,
    ) {

        /** The contents of an email message */
        fun messageEmailContent(): Optional<MessageEmailContent> =
            Optional.ofNullable(messageEmailContent)

        /** The contents of an SMS message */
        fun messageSmsContent(): Optional<MessageSmsContent> =
            Optional.ofNullable(messageSmsContent)

        /** The contents of a push message */
        fun messagePushContent(): Optional<MessagePushContent> =
            Optional.ofNullable(messagePushContent)

        /** The contents of a chat message */
        fun messageChatContent(): Optional<MessageChatContent> =
            Optional.ofNullable(messageChatContent)

        /** The contents of a message in an app feed */
        fun messageInAppFeedContent(): Optional<MessageInAppFeedContent> =
            Optional.ofNullable(messageInAppFeedContent)

        fun isMessageEmailContent(): Boolean = messageEmailContent != null

        fun isMessageSmsContent(): Boolean = messageSmsContent != null

        fun isMessagePushContent(): Boolean = messagePushContent != null

        fun isMessageChatContent(): Boolean = messageChatContent != null

        fun isMessageInAppFeedContent(): Boolean = messageInAppFeedContent != null

        /** The contents of an email message */
        fun asMessageEmailContent(): MessageEmailContent =
            messageEmailContent.getOrThrow("messageEmailContent")

        /** The contents of an SMS message */
        fun asMessageSmsContent(): MessageSmsContent =
            messageSmsContent.getOrThrow("messageSmsContent")

        /** The contents of a push message */
        fun asMessagePushContent(): MessagePushContent =
            messagePushContent.getOrThrow("messagePushContent")

        /** The contents of a chat message */
        fun asMessageChatContent(): MessageChatContent =
            messageChatContent.getOrThrow("messageChatContent")

        /** The contents of a message in an app feed */
        fun asMessageInAppFeedContent(): MessageInAppFeedContent =
            messageInAppFeedContent.getOrThrow("messageInAppFeedContent")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                messageEmailContent != null -> visitor.visitMessageEmailContent(messageEmailContent)
                messageSmsContent != null -> visitor.visitMessageSmsContent(messageSmsContent)
                messagePushContent != null -> visitor.visitMessagePushContent(messagePushContent)
                messageChatContent != null -> visitor.visitMessageChatContent(messageChatContent)
                messageInAppFeedContent != null ->
                    visitor.visitMessageInAppFeedContent(messageInAppFeedContent)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitMessageEmailContent(
                        messageEmailContent: MessageEmailContent
                    ) {
                        messageEmailContent.validate()
                    }

                    override fun visitMessageSmsContent(messageSmsContent: MessageSmsContent) {
                        messageSmsContent.validate()
                    }

                    override fun visitMessagePushContent(messagePushContent: MessagePushContent) {
                        messagePushContent.validate()
                    }

                    override fun visitMessageChatContent(messageChatContent: MessageChatContent) {
                        messageChatContent.validate()
                    }

                    override fun visitMessageInAppFeedContent(
                        messageInAppFeedContent: MessageInAppFeedContent
                    ) {
                        messageInAppFeedContent.validate()
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
                    override fun visitMessageEmailContent(
                        messageEmailContent: MessageEmailContent
                    ) = messageEmailContent.validity()

                    override fun visitMessageSmsContent(messageSmsContent: MessageSmsContent) =
                        messageSmsContent.validity()

                    override fun visitMessagePushContent(messagePushContent: MessagePushContent) =
                        messagePushContent.validity()

                    override fun visitMessageChatContent(messageChatContent: MessageChatContent) =
                        messageChatContent.validity()

                    override fun visitMessageInAppFeedContent(
                        messageInAppFeedContent: MessageInAppFeedContent
                    ) = messageInAppFeedContent.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Data && messageEmailContent == other.messageEmailContent && messageSmsContent == other.messageSmsContent && messagePushContent == other.messagePushContent && messageChatContent == other.messageChatContent && messageInAppFeedContent == other.messageInAppFeedContent /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(messageEmailContent, messageSmsContent, messagePushContent, messageChatContent, messageInAppFeedContent) /* spotless:on */

        override fun toString(): String =
            when {
                messageEmailContent != null -> "Data{messageEmailContent=$messageEmailContent}"
                messageSmsContent != null -> "Data{messageSmsContent=$messageSmsContent}"
                messagePushContent != null -> "Data{messagePushContent=$messagePushContent}"
                messageChatContent != null -> "Data{messageChatContent=$messageChatContent}"
                messageInAppFeedContent != null ->
                    "Data{messageInAppFeedContent=$messageInAppFeedContent}"
                _json != null -> "Data{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Data")
            }

        companion object {

            /** The contents of an email message */
            @JvmStatic
            fun ofMessageEmailContent(messageEmailContent: MessageEmailContent) =
                Data(messageEmailContent = messageEmailContent)

            /** The contents of an SMS message */
            @JvmStatic
            fun ofMessageSmsContent(messageSmsContent: MessageSmsContent) =
                Data(messageSmsContent = messageSmsContent)

            /** The contents of a push message */
            @JvmStatic
            fun ofMessagePushContent(messagePushContent: MessagePushContent) =
                Data(messagePushContent = messagePushContent)

            /** The contents of a chat message */
            @JvmStatic
            fun ofMessageChatContent(messageChatContent: MessageChatContent) =
                Data(messageChatContent = messageChatContent)

            /** The contents of a message in an app feed */
            @JvmStatic
            fun ofMessageInAppFeedContent(messageInAppFeedContent: MessageInAppFeedContent) =
                Data(messageInAppFeedContent = messageInAppFeedContent)
        }

        /** An interface that defines how to map each variant of [Data] to a value of type [T]. */
        interface Visitor<out T> {

            /** The contents of an email message */
            fun visitMessageEmailContent(messageEmailContent: MessageEmailContent): T

            /** The contents of an SMS message */
            fun visitMessageSmsContent(messageSmsContent: MessageSmsContent): T

            /** The contents of a push message */
            fun visitMessagePushContent(messagePushContent: MessagePushContent): T

            /** The contents of a chat message */
            fun visitMessageChatContent(messageChatContent: MessageChatContent): T

            /** The contents of a message in an app feed */
            fun visitMessageInAppFeedContent(messageInAppFeedContent: MessageInAppFeedContent): T

            /**
             * Maps an unknown variant of [Data] to a value of type [T].
             *
             * An instance of [Data] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Data: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Data>(Data::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Data {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<MessageEmailContent>())?.let {
                                Data(messageEmailContent = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<MessageSmsContent>())?.let {
                                Data(messageSmsContent = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<MessagePushContent>())?.let {
                                Data(messagePushContent = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<MessageChatContent>())?.let {
                                Data(messageChatContent = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<MessageInAppFeedContent>())?.let {
                                Data(messageInAppFeedContent = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Data(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer : BaseSerializer<Data>(Data::class) {

            override fun serialize(
                value: Data,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.messageEmailContent != null ->
                        generator.writeObject(value.messageEmailContent)
                    value.messageSmsContent != null ->
                        generator.writeObject(value.messageSmsContent)
                    value.messagePushContent != null ->
                        generator.writeObject(value.messagePushContent)
                    value.messageChatContent != null ->
                        generator.writeObject(value.messageChatContent)
                    value.messageInAppFeedContent != null ->
                        generator.writeObject(value.messageInAppFeedContent)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Data")
                }
            }
        }

        /** The contents of an email message */
        class MessageEmailContent
        private constructor(
            private val _typename: JsonField<String>,
            private val from: JsonField<String>,
            private val htmlBody: JsonField<String>,
            private val subjectLine: JsonField<String>,
            private val textBody: JsonField<String>,
            private val to: JsonField<String>,
            private val bcc: JsonField<String>,
            private val cc: JsonField<String>,
            private val replyTo: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("__typename")
                @ExcludeMissing
                _typename: JsonField<String> = JsonMissing.of(),
                @JsonProperty("from") @ExcludeMissing from: JsonField<String> = JsonMissing.of(),
                @JsonProperty("html_body")
                @ExcludeMissing
                htmlBody: JsonField<String> = JsonMissing.of(),
                @JsonProperty("subject_line")
                @ExcludeMissing
                subjectLine: JsonField<String> = JsonMissing.of(),
                @JsonProperty("text_body")
                @ExcludeMissing
                textBody: JsonField<String> = JsonMissing.of(),
                @JsonProperty("to") @ExcludeMissing to: JsonField<String> = JsonMissing.of(),
                @JsonProperty("bcc") @ExcludeMissing bcc: JsonField<String> = JsonMissing.of(),
                @JsonProperty("cc") @ExcludeMissing cc: JsonField<String> = JsonMissing.of(),
                @JsonProperty("reply_to")
                @ExcludeMissing
                replyTo: JsonField<String> = JsonMissing.of(),
            ) : this(
                _typename,
                from,
                htmlBody,
                subjectLine,
                textBody,
                to,
                bcc,
                cc,
                replyTo,
                mutableMapOf(),
            )

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun _typename(): String = _typename.getRequired("__typename")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun from(): String = from.getRequired("from")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun htmlBody(): String = htmlBody.getRequired("html_body")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun subjectLine(): String = subjectLine.getRequired("subject_line")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun textBody(): String = textBody.getRequired("text_body")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun to(): String = to.getRequired("to")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun bcc(): Optional<String> = bcc.getOptional("bcc")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun cc(): Optional<String> = cc.getOptional("cc")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun replyTo(): Optional<String> = replyTo.getOptional("reply_to")

            /**
             * Returns the raw JSON value of [_typename].
             *
             * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("__typename")
            @ExcludeMissing
            fun __typename(): JsonField<String> = _typename

            /**
             * Returns the raw JSON value of [from].
             *
             * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<String> = from

            /**
             * Returns the raw JSON value of [htmlBody].
             *
             * Unlike [htmlBody], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("html_body") @ExcludeMissing fun _htmlBody(): JsonField<String> = htmlBody

            /**
             * Returns the raw JSON value of [subjectLine].
             *
             * Unlike [subjectLine], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("subject_line")
            @ExcludeMissing
            fun _subjectLine(): JsonField<String> = subjectLine

            /**
             * Returns the raw JSON value of [textBody].
             *
             * Unlike [textBody], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("text_body") @ExcludeMissing fun _textBody(): JsonField<String> = textBody

            /**
             * Returns the raw JSON value of [to].
             *
             * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<String> = to

            /**
             * Returns the raw JSON value of [bcc].
             *
             * Unlike [bcc], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("bcc") @ExcludeMissing fun _bcc(): JsonField<String> = bcc

            /**
             * Returns the raw JSON value of [cc].
             *
             * Unlike [cc], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cc") @ExcludeMissing fun _cc(): JsonField<String> = cc

            /**
             * Returns the raw JSON value of [replyTo].
             *
             * Unlike [replyTo], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reply_to") @ExcludeMissing fun _replyTo(): JsonField<String> = replyTo

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
                 * Returns a mutable builder for constructing an instance of [MessageEmailContent].
                 *
                 * The following fields are required:
                 * ```java
                 * ._typename()
                 * .from()
                 * .htmlBody()
                 * .subjectLine()
                 * .textBody()
                 * .to()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [MessageEmailContent]. */
            class Builder internal constructor() {

                private var _typename: JsonField<String>? = null
                private var from: JsonField<String>? = null
                private var htmlBody: JsonField<String>? = null
                private var subjectLine: JsonField<String>? = null
                private var textBody: JsonField<String>? = null
                private var to: JsonField<String>? = null
                private var bcc: JsonField<String> = JsonMissing.of()
                private var cc: JsonField<String> = JsonMissing.of()
                private var replyTo: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(messageEmailContent: MessageEmailContent) = apply {
                    _typename = messageEmailContent._typename
                    from = messageEmailContent.from
                    htmlBody = messageEmailContent.htmlBody
                    subjectLine = messageEmailContent.subjectLine
                    textBody = messageEmailContent.textBody
                    to = messageEmailContent.to
                    bcc = messageEmailContent.bcc
                    cc = messageEmailContent.cc
                    replyTo = messageEmailContent.replyTo
                    additionalProperties = messageEmailContent.additionalProperties.toMutableMap()
                }

                fun _typename(_typename: String) = _typename(JsonField.of(_typename))

                /**
                 * Sets [Builder._typename] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder._typename] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

                fun from(from: String) = from(JsonField.of(from))

                /**
                 * Sets [Builder.from] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.from] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun from(from: JsonField<String>) = apply { this.from = from }

                fun htmlBody(htmlBody: String) = htmlBody(JsonField.of(htmlBody))

                /**
                 * Sets [Builder.htmlBody] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.htmlBody] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun htmlBody(htmlBody: JsonField<String>) = apply { this.htmlBody = htmlBody }

                fun subjectLine(subjectLine: String) = subjectLine(JsonField.of(subjectLine))

                /**
                 * Sets [Builder.subjectLine] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.subjectLine] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun subjectLine(subjectLine: JsonField<String>) = apply {
                    this.subjectLine = subjectLine
                }

                fun textBody(textBody: String) = textBody(JsonField.of(textBody))

                /**
                 * Sets [Builder.textBody] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.textBody] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun textBody(textBody: JsonField<String>) = apply { this.textBody = textBody }

                fun to(to: String) = to(JsonField.of(to))

                /**
                 * Sets [Builder.to] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.to] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun to(to: JsonField<String>) = apply { this.to = to }

                fun bcc(bcc: String?) = bcc(JsonField.ofNullable(bcc))

                /** Alias for calling [Builder.bcc] with `bcc.orElse(null)`. */
                fun bcc(bcc: Optional<String>) = bcc(bcc.getOrNull())

                /**
                 * Sets [Builder.bcc] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bcc] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun bcc(bcc: JsonField<String>) = apply { this.bcc = bcc }

                fun cc(cc: String?) = cc(JsonField.ofNullable(cc))

                /** Alias for calling [Builder.cc] with `cc.orElse(null)`. */
                fun cc(cc: Optional<String>) = cc(cc.getOrNull())

                /**
                 * Sets [Builder.cc] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cc] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun cc(cc: JsonField<String>) = apply { this.cc = cc }

                fun replyTo(replyTo: String?) = replyTo(JsonField.ofNullable(replyTo))

                /** Alias for calling [Builder.replyTo] with `replyTo.orElse(null)`. */
                fun replyTo(replyTo: Optional<String>) = replyTo(replyTo.getOrNull())

                /**
                 * Sets [Builder.replyTo] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.replyTo] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun replyTo(replyTo: JsonField<String>) = apply { this.replyTo = replyTo }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [MessageEmailContent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * ._typename()
                 * .from()
                 * .htmlBody()
                 * .subjectLine()
                 * .textBody()
                 * .to()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): MessageEmailContent =
                    MessageEmailContent(
                        checkRequired("_typename", _typename),
                        checkRequired("from", from),
                        checkRequired("htmlBody", htmlBody),
                        checkRequired("subjectLine", subjectLine),
                        checkRequired("textBody", textBody),
                        checkRequired("to", to),
                        bcc,
                        cc,
                        replyTo,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): MessageEmailContent = apply {
                if (validated) {
                    return@apply
                }

                _typename()
                from()
                htmlBody()
                subjectLine()
                textBody()
                to()
                bcc()
                cc()
                replyTo()
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
                (if (_typename.asKnown().isPresent) 1 else 0) +
                    (if (from.asKnown().isPresent) 1 else 0) +
                    (if (htmlBody.asKnown().isPresent) 1 else 0) +
                    (if (subjectLine.asKnown().isPresent) 1 else 0) +
                    (if (textBody.asKnown().isPresent) 1 else 0) +
                    (if (to.asKnown().isPresent) 1 else 0) +
                    (if (bcc.asKnown().isPresent) 1 else 0) +
                    (if (cc.asKnown().isPresent) 1 else 0) +
                    (if (replyTo.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is MessageEmailContent && _typename == other._typename && from == other.from && htmlBody == other.htmlBody && subjectLine == other.subjectLine && textBody == other.textBody && to == other.to && bcc == other.bcc && cc == other.cc && replyTo == other.replyTo && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(_typename, from, htmlBody, subjectLine, textBody, to, bcc, cc, replyTo, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "MessageEmailContent{_typename=$_typename, from=$from, htmlBody=$htmlBody, subjectLine=$subjectLine, textBody=$textBody, to=$to, bcc=$bcc, cc=$cc, replyTo=$replyTo, additionalProperties=$additionalProperties}"
        }

        /** The contents of an SMS message */
        class MessageSmsContent
        private constructor(
            private val _typename: JsonField<String>,
            private val body: JsonField<String>,
            private val to: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("__typename")
                @ExcludeMissing
                _typename: JsonField<String> = JsonMissing.of(),
                @JsonProperty("body") @ExcludeMissing body: JsonField<String> = JsonMissing.of(),
                @JsonProperty("to") @ExcludeMissing to: JsonField<String> = JsonMissing.of(),
            ) : this(_typename, body, to, mutableMapOf())

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun _typename(): String = _typename.getRequired("__typename")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun body(): String = body.getRequired("body")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun to(): String = to.getRequired("to")

            /**
             * Returns the raw JSON value of [_typename].
             *
             * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("__typename")
            @ExcludeMissing
            fun __typename(): JsonField<String> = _typename

            /**
             * Returns the raw JSON value of [body].
             *
             * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<String> = body

            /**
             * Returns the raw JSON value of [to].
             *
             * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<String> = to

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
                 * Returns a mutable builder for constructing an instance of [MessageSmsContent].
                 *
                 * The following fields are required:
                 * ```java
                 * ._typename()
                 * .body()
                 * .to()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [MessageSmsContent]. */
            class Builder internal constructor() {

                private var _typename: JsonField<String>? = null
                private var body: JsonField<String>? = null
                private var to: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(messageSmsContent: MessageSmsContent) = apply {
                    _typename = messageSmsContent._typename
                    body = messageSmsContent.body
                    to = messageSmsContent.to
                    additionalProperties = messageSmsContent.additionalProperties.toMutableMap()
                }

                fun _typename(_typename: String) = _typename(JsonField.of(_typename))

                /**
                 * Sets [Builder._typename] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder._typename] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

                fun body(body: String) = body(JsonField.of(body))

                /**
                 * Sets [Builder.body] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.body] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun body(body: JsonField<String>) = apply { this.body = body }

                fun to(to: String) = to(JsonField.of(to))

                /**
                 * Sets [Builder.to] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.to] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun to(to: JsonField<String>) = apply { this.to = to }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [MessageSmsContent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * ._typename()
                 * .body()
                 * .to()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): MessageSmsContent =
                    MessageSmsContent(
                        checkRequired("_typename", _typename),
                        checkRequired("body", body),
                        checkRequired("to", to),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): MessageSmsContent = apply {
                if (validated) {
                    return@apply
                }

                _typename()
                body()
                to()
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
                (if (_typename.asKnown().isPresent) 1 else 0) +
                    (if (body.asKnown().isPresent) 1 else 0) +
                    (if (to.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is MessageSmsContent && _typename == other._typename && body == other.body && to == other.to && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(_typename, body, to, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "MessageSmsContent{_typename=$_typename, body=$body, to=$to, additionalProperties=$additionalProperties}"
        }

        /** The contents of a push message */
        class MessagePushContent
        private constructor(
            private val token: JsonField<String>,
            private val _typename: JsonField<String>,
            private val body: JsonField<String>,
            private val title: JsonField<String>,
            private val data: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("token") @ExcludeMissing token: JsonField<String> = JsonMissing.of(),
                @JsonProperty("__typename")
                @ExcludeMissing
                _typename: JsonField<String> = JsonMissing.of(),
                @JsonProperty("body") @ExcludeMissing body: JsonField<String> = JsonMissing.of(),
                @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
                @JsonProperty("data") @ExcludeMissing data: JsonValue = JsonMissing.of(),
            ) : this(token, _typename, body, title, data, mutableMapOf())

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun token(): String = token.getRequired("token")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun _typename(): String = _typename.getRequired("__typename")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun body(): String = body.getRequired("body")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun title(): String = title.getRequired("title")

            @JsonProperty("data") @ExcludeMissing fun _data(): JsonValue = data

            /**
             * Returns the raw JSON value of [token].
             *
             * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

            /**
             * Returns the raw JSON value of [_typename].
             *
             * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("__typename")
            @ExcludeMissing
            fun __typename(): JsonField<String> = _typename

            /**
             * Returns the raw JSON value of [body].
             *
             * Unlike [body], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<String> = body

            /**
             * Returns the raw JSON value of [title].
             *
             * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

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
                 * Returns a mutable builder for constructing an instance of [MessagePushContent].
                 *
                 * The following fields are required:
                 * ```java
                 * .token()
                 * ._typename()
                 * .body()
                 * .title()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [MessagePushContent]. */
            class Builder internal constructor() {

                private var token: JsonField<String>? = null
                private var _typename: JsonField<String>? = null
                private var body: JsonField<String>? = null
                private var title: JsonField<String>? = null
                private var data: JsonValue = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(messagePushContent: MessagePushContent) = apply {
                    token = messagePushContent.token
                    _typename = messagePushContent._typename
                    body = messagePushContent.body
                    title = messagePushContent.title
                    data = messagePushContent.data
                    additionalProperties = messagePushContent.additionalProperties.toMutableMap()
                }

                fun token(token: String) = token(JsonField.of(token))

                /**
                 * Sets [Builder.token] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.token] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun token(token: JsonField<String>) = apply { this.token = token }

                fun _typename(_typename: String) = _typename(JsonField.of(_typename))

                /**
                 * Sets [Builder._typename] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder._typename] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

                fun body(body: String) = body(JsonField.of(body))

                /**
                 * Sets [Builder.body] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.body] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun body(body: JsonField<String>) = apply { this.body = body }

                fun title(title: String) = title(JsonField.of(title))

                /**
                 * Sets [Builder.title] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.title] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun title(title: JsonField<String>) = apply { this.title = title }

                fun data(data: JsonValue) = apply { this.data = data }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [MessagePushContent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .token()
                 * ._typename()
                 * .body()
                 * .title()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): MessagePushContent =
                    MessagePushContent(
                        checkRequired("token", token),
                        checkRequired("_typename", _typename),
                        checkRequired("body", body),
                        checkRequired("title", title),
                        data,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): MessagePushContent = apply {
                if (validated) {
                    return@apply
                }

                token()
                _typename()
                body()
                title()
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
                (if (token.asKnown().isPresent) 1 else 0) +
                    (if (_typename.asKnown().isPresent) 1 else 0) +
                    (if (body.asKnown().isPresent) 1 else 0) +
                    (if (title.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is MessagePushContent && token == other.token && _typename == other._typename && body == other.body && title == other.title && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(token, _typename, body, title, data, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "MessagePushContent{token=$token, _typename=$_typename, body=$body, title=$title, data=$data, additionalProperties=$additionalProperties}"
        }

        /** The contents of a chat message */
        class MessageChatContent
        private constructor(
            private val _typename: JsonField<String>,
            private val connection: JsonValue,
            private val template: JsonField<Template>,
            private val metadata: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("__typename")
                @ExcludeMissing
                _typename: JsonField<String> = JsonMissing.of(),
                @JsonProperty("connection")
                @ExcludeMissing
                connection: JsonValue = JsonMissing.of(),
                @JsonProperty("template")
                @ExcludeMissing
                template: JsonField<Template> = JsonMissing.of(),
                @JsonProperty("metadata") @ExcludeMissing metadata: JsonValue = JsonMissing.of(),
            ) : this(_typename, connection, template, metadata, mutableMapOf())

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun _typename(): String = _typename.getRequired("__typename")

            /** The channel data connection from the recipient to the underlying provider */
            @JsonProperty("connection") @ExcludeMissing fun _connection(): JsonValue = connection

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun template(): Template = template.getRequired("template")

            @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

            /**
             * Returns the raw JSON value of [_typename].
             *
             * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("__typename")
            @ExcludeMissing
            fun __typename(): JsonField<String> = _typename

            /**
             * Returns the raw JSON value of [template].
             *
             * Unlike [template], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("template")
            @ExcludeMissing
            fun _template(): JsonField<Template> = template

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
                 * Returns a mutable builder for constructing an instance of [MessageChatContent].
                 *
                 * The following fields are required:
                 * ```java
                 * ._typename()
                 * .connection()
                 * .template()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [MessageChatContent]. */
            class Builder internal constructor() {

                private var _typename: JsonField<String>? = null
                private var connection: JsonValue? = null
                private var template: JsonField<Template>? = null
                private var metadata: JsonValue = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(messageChatContent: MessageChatContent) = apply {
                    _typename = messageChatContent._typename
                    connection = messageChatContent.connection
                    template = messageChatContent.template
                    metadata = messageChatContent.metadata
                    additionalProperties = messageChatContent.additionalProperties.toMutableMap()
                }

                fun _typename(_typename: String) = _typename(JsonField.of(_typename))

                /**
                 * Sets [Builder._typename] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder._typename] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

                /** The channel data connection from the recipient to the underlying provider */
                fun connection(connection: JsonValue) = apply { this.connection = connection }

                fun template(template: Template) = template(JsonField.of(template))

                /**
                 * Sets [Builder.template] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.template] with a well-typed [Template] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun template(template: JsonField<Template>) = apply { this.template = template }

                fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [MessageChatContent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * ._typename()
                 * .connection()
                 * .template()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): MessageChatContent =
                    MessageChatContent(
                        checkRequired("_typename", _typename),
                        checkRequired("connection", connection),
                        checkRequired("template", template),
                        metadata,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): MessageChatContent = apply {
                if (validated) {
                    return@apply
                }

                _typename()
                template().validate()
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
                (if (_typename.asKnown().isPresent) 1 else 0) +
                    (template.asKnown().getOrNull()?.validity() ?: 0)

            class Template
            private constructor(
                private val blocks: JsonField<List<Block>>,
                private val jsonContent: JsonValue,
                private val summary: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("blocks")
                    @ExcludeMissing
                    blocks: JsonField<List<Block>> = JsonMissing.of(),
                    @JsonProperty("json_content")
                    @ExcludeMissing
                    jsonContent: JsonValue = JsonMissing.of(),
                    @JsonProperty("summary")
                    @ExcludeMissing
                    summary: JsonField<String> = JsonMissing.of(),
                ) : this(blocks, jsonContent, summary, mutableMapOf())

                /**
                 * The structured blocks of the message
                 *
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun blocks(): Optional<List<Block>> = blocks.getOptional("blocks")

                /** The JSON content of the message */
                @JsonProperty("json_content")
                @ExcludeMissing
                fun _jsonContent(): JsonValue = jsonContent

                /**
                 * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun summary(): Optional<String> = summary.getOptional("summary")

                /**
                 * Returns the raw JSON value of [blocks].
                 *
                 * Unlike [blocks], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("blocks")
                @ExcludeMissing
                fun _blocks(): JsonField<List<Block>> = blocks

                /**
                 * Returns the raw JSON value of [summary].
                 *
                 * Unlike [summary], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<String> = summary

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

                    /** Returns a mutable builder for constructing an instance of [Template]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Template]. */
                class Builder internal constructor() {

                    private var blocks: JsonField<MutableList<Block>>? = null
                    private var jsonContent: JsonValue = JsonMissing.of()
                    private var summary: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(template: Template) = apply {
                        blocks = template.blocks.map { it.toMutableList() }
                        jsonContent = template.jsonContent
                        summary = template.summary
                        additionalProperties = template.additionalProperties.toMutableMap()
                    }

                    /** The structured blocks of the message */
                    fun blocks(blocks: List<Block>?) = blocks(JsonField.ofNullable(blocks))

                    /** Alias for calling [Builder.blocks] with `blocks.orElse(null)`. */
                    fun blocks(blocks: Optional<List<Block>>) = blocks(blocks.getOrNull())

                    /**
                     * Sets [Builder.blocks] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.blocks] with a well-typed `List<Block>`
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun blocks(blocks: JsonField<List<Block>>) = apply {
                        this.blocks = blocks.map { it.toMutableList() }
                    }

                    /**
                     * Adds a single [Block] to [blocks].
                     *
                     * @throws IllegalStateException if the field was previously set to a non-list.
                     */
                    fun addBlock(block: Block) = apply {
                        blocks =
                            (blocks ?: JsonField.of(mutableListOf())).also {
                                checkKnown("blocks", it).add(block)
                            }
                    }

                    /** The JSON content of the message */
                    fun jsonContent(jsonContent: JsonValue) = apply {
                        this.jsonContent = jsonContent
                    }

                    fun summary(summary: String?) = summary(JsonField.ofNullable(summary))

                    /** Alias for calling [Builder.summary] with `summary.orElse(null)`. */
                    fun summary(summary: Optional<String>) = summary(summary.getOrNull())

                    /**
                     * Sets [Builder.summary] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.summary] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun summary(summary: JsonField<String>) = apply { this.summary = summary }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    /**
                     * Returns an immutable instance of [Template].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Template =
                        Template(
                            (blocks ?: JsonMissing.of()).map { it.toImmutable() },
                            jsonContent,
                            summary,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Template = apply {
                    if (validated) {
                        return@apply
                    }

                    blocks().ifPresent { it.forEach { it.validate() } }
                    summary()
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
                    (blocks.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                        (if (summary.asKnown().isPresent) 1 else 0)

                /** A block in a chat message */
                class Block
                private constructor(
                    private val content: JsonField<String>,
                    private val name: JsonField<String>,
                    private val type: JsonField<Type>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("content")
                        @ExcludeMissing
                        content: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("name")
                        @ExcludeMissing
                        name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        type: JsonField<Type> = JsonMissing.of(),
                    ) : this(content, name, type, mutableMapOf())

                    /**
                     * @throws KnockInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun content(): String = content.getRequired("content")

                    /**
                     * @throws KnockInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun name(): String = name.getRequired("name")

                    /**
                     * @throws KnockInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun type(): Type = type.getRequired("type")

                    /**
                     * Returns the raw JSON value of [content].
                     *
                     * Unlike [content], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("content")
                    @ExcludeMissing
                    fun _content(): JsonField<String> = content

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                         * Returns a mutable builder for constructing an instance of [Block].
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * .name()
                         * .type()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [Block]. */
                    class Builder internal constructor() {

                        private var content: JsonField<String>? = null
                        private var name: JsonField<String>? = null
                        private var type: JsonField<Type>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(block: Block) = apply {
                            content = block.content
                            name = block.name
                            type = block.type
                            additionalProperties = block.additionalProperties.toMutableMap()
                        }

                        fun content(content: String) = content(JsonField.of(content))

                        /**
                         * Sets [Builder.content] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.content] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun content(content: JsonField<String>) = apply { this.content = content }

                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun type(type: Type) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [Type] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<Type>) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [Block].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * .name()
                         * .type()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): Block =
                            Block(
                                checkRequired("content", content),
                                checkRequired("name", name),
                                checkRequired("type", type),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): Block = apply {
                        if (validated) {
                            return@apply
                        }

                        content()
                        name()
                        type().validate()
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
                        (if (content.asKnown().isPresent) 1 else 0) +
                            (if (name.asKnown().isPresent) 1 else 0) +
                            (type.asKnown().getOrNull()?.validity() ?: 0)

                    class Type
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val TEXT = of("text")

                            @JvmField val MARKDOWN = of("markdown")

                            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                        }

                        /** An enum containing [Type]'s known values. */
                        enum class Known {
                            TEXT,
                            MARKDOWN,
                        }

                        /**
                         * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Type] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            TEXT,
                            MARKDOWN,
                            /**
                             * An enum member indicating that [Type] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                TEXT -> Value.TEXT
                                MARKDOWN -> Value.MARKDOWN
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws KnockInvalidDataException if this class instance's value is a not
                         *   a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                TEXT -> Known.TEXT
                                MARKDOWN -> Known.MARKDOWN
                                else -> throw KnockInvalidDataException("Unknown Type: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws KnockInvalidDataException if this class instance's value does not
                         *   have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                KnockInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        fun validate(): Type = apply {
                            if (validated) {
                                return@apply
                            }

                            known()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is Block && content == other.content && name == other.name && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(content, name, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "Block{content=$content, name=$name, type=$type, additionalProperties=$additionalProperties}"
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Template && blocks == other.blocks && jsonContent == other.jsonContent && summary == other.summary && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(blocks, jsonContent, summary, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Template{blocks=$blocks, jsonContent=$jsonContent, summary=$summary, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is MessageChatContent && _typename == other._typename && connection == other.connection && template == other.template && metadata == other.metadata && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(_typename, connection, template, metadata, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "MessageChatContent{_typename=$_typename, connection=$connection, template=$template, metadata=$metadata, additionalProperties=$additionalProperties}"
        }

        /** The contents of a message in an app feed */
        class MessageInAppFeedContent
        private constructor(
            private val _typename: JsonField<String>,
            private val blocks: JsonField<List<Block>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("__typename")
                @ExcludeMissing
                _typename: JsonField<String> = JsonMissing.of(),
                @JsonProperty("blocks")
                @ExcludeMissing
                blocks: JsonField<List<Block>> = JsonMissing.of(),
            ) : this(_typename, blocks, mutableMapOf())

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun _typename(): String = _typename.getRequired("__typename")

            /**
             * The blocks of the message
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun blocks(): List<Block> = blocks.getRequired("blocks")

            /**
             * Returns the raw JSON value of [_typename].
             *
             * Unlike [_typename], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("__typename")
            @ExcludeMissing
            fun __typename(): JsonField<String> = _typename

            /**
             * Returns the raw JSON value of [blocks].
             *
             * Unlike [blocks], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("blocks") @ExcludeMissing fun _blocks(): JsonField<List<Block>> = blocks

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
                 * Returns a mutable builder for constructing an instance of
                 * [MessageInAppFeedContent].
                 *
                 * The following fields are required:
                 * ```java
                 * ._typename()
                 * .blocks()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [MessageInAppFeedContent]. */
            class Builder internal constructor() {

                private var _typename: JsonField<String>? = null
                private var blocks: JsonField<MutableList<Block>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(messageInAppFeedContent: MessageInAppFeedContent) = apply {
                    _typename = messageInAppFeedContent._typename
                    blocks = messageInAppFeedContent.blocks.map { it.toMutableList() }
                    additionalProperties =
                        messageInAppFeedContent.additionalProperties.toMutableMap()
                }

                fun _typename(_typename: String) = _typename(JsonField.of(_typename))

                /**
                 * Sets [Builder._typename] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder._typename] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

                /** The blocks of the message */
                fun blocks(blocks: List<Block>) = blocks(JsonField.of(blocks))

                /**
                 * Sets [Builder.blocks] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.blocks] with a well-typed `List<Block>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun blocks(blocks: JsonField<List<Block>>) = apply {
                    this.blocks = blocks.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Block] to [blocks].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addBlock(block: Block) = apply {
                    blocks =
                        (blocks ?: JsonField.of(mutableListOf())).also {
                            checkKnown("blocks", it).add(block)
                        }
                }

                /** Alias for calling [addBlock] with `Block.ofContent(content)`. */
                fun addBlock(content: Block.ContentBlock) = addBlock(Block.ofContent(content))

                /** Alias for calling [addBlock] with `Block.ofButtonSet(buttonSet)`. */
                fun addBlock(buttonSet: Block.ButtonSetBlock) =
                    addBlock(Block.ofButtonSet(buttonSet))

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [MessageInAppFeedContent].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * ._typename()
                 * .blocks()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): MessageInAppFeedContent =
                    MessageInAppFeedContent(
                        checkRequired("_typename", _typename),
                        checkRequired("blocks", blocks).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): MessageInAppFeedContent = apply {
                if (validated) {
                    return@apply
                }

                _typename()
                blocks().forEach { it.validate() }
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
                (if (_typename.asKnown().isPresent) 1 else 0) +
                    (blocks.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

            /** A content (text or markdown) block in a message in an app feed */
            @JsonDeserialize(using = Block.Deserializer::class)
            @JsonSerialize(using = Block.Serializer::class)
            class Block
            private constructor(
                private val content: ContentBlock? = null,
                private val buttonSet: ButtonSetBlock? = null,
                private val _json: JsonValue? = null,
            ) {

                /** A content (text or markdown) block in a message in an app feed */
                fun content(): Optional<ContentBlock> = Optional.ofNullable(content)

                /** A set of buttons in a message in an app feed */
                fun buttonSet(): Optional<ButtonSetBlock> = Optional.ofNullable(buttonSet)

                fun isContent(): Boolean = content != null

                fun isButtonSet(): Boolean = buttonSet != null

                /** A content (text or markdown) block in a message in an app feed */
                fun asContent(): ContentBlock = content.getOrThrow("content")

                /** A set of buttons in a message in an app feed */
                fun asButtonSet(): ButtonSetBlock = buttonSet.getOrThrow("buttonSet")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T =
                    when {
                        content != null -> visitor.visitContent(content)
                        buttonSet != null -> visitor.visitButtonSet(buttonSet)
                        else -> visitor.unknown(_json)
                    }

                private var validated: Boolean = false

                fun validate(): Block = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitContent(content: ContentBlock) {
                                content.validate()
                            }

                            override fun visitButtonSet(buttonSet: ButtonSetBlock) {
                                buttonSet.validate()
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
                            override fun visitContent(content: ContentBlock) = content.validity()

                            override fun visitButtonSet(buttonSet: ButtonSetBlock) =
                                buttonSet.validity()

                            override fun unknown(json: JsonValue?) = 0
                        }
                    )

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Block && content == other.content && buttonSet == other.buttonSet /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(content, buttonSet) /* spotless:on */

                override fun toString(): String =
                    when {
                        content != null -> "Block{content=$content}"
                        buttonSet != null -> "Block{buttonSet=$buttonSet}"
                        _json != null -> "Block{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Block")
                    }

                companion object {

                    /** A content (text or markdown) block in a message in an app feed */
                    @JvmStatic fun ofContent(content: ContentBlock) = Block(content = content)

                    /** A set of buttons in a message in an app feed */
                    @JvmStatic
                    fun ofButtonSet(buttonSet: ButtonSetBlock) = Block(buttonSet = buttonSet)
                }

                /**
                 * An interface that defines how to map each variant of [Block] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    /** A content (text or markdown) block in a message in an app feed */
                    fun visitContent(content: ContentBlock): T

                    /** A set of buttons in a message in an app feed */
                    fun visitButtonSet(buttonSet: ButtonSetBlock): T

                    /**
                     * Maps an unknown variant of [Block] to a value of type [T].
                     *
                     * An instance of [Block] can contain an unknown variant if it was deserialized
                     * from data that doesn't match any known variant. For example, if the SDK is on
                     * an older version than the API, then the API may respond with new variants
                     * that the SDK is unaware of.
                     *
                     * @throws KnockInvalidDataException in the default implementation.
                     */
                    fun unknown(json: JsonValue?): T {
                        throw KnockInvalidDataException("Unknown Block: $json")
                    }
                }

                internal class Deserializer : BaseDeserializer<Block>(Block::class) {

                    override fun ObjectCodec.deserialize(node: JsonNode): Block {
                        val json = JsonValue.fromJsonNode(node)

                        val bestMatches =
                            sequenceOf(
                                    tryDeserialize(node, jacksonTypeRef<ContentBlock>())?.let {
                                        Block(content = it, _json = json)
                                    },
                                    tryDeserialize(node, jacksonTypeRef<ButtonSetBlock>())?.let {
                                        Block(buttonSet = it, _json = json)
                                    },
                                )
                                .filterNotNull()
                                .allMaxBy { it.validity() }
                                .toList()
                        return when (bestMatches.size) {
                            // This can happen if what we're deserializing is completely
                            // incompatible with all the possible variants (e.g. deserializing from
                            // boolean).
                            0 -> Block(_json = json)
                            1 -> bestMatches.single()
                            // If there's more than one match with the highest validity, then use
                            // the first completely valid match, or simply the first match if none
                            // are completely valid.
                            else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                        }
                    }
                }

                internal class Serializer : BaseSerializer<Block>(Block::class) {

                    override fun serialize(
                        value: Block,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.content != null -> generator.writeObject(value.content)
                            value.buttonSet != null -> generator.writeObject(value.buttonSet)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Block")
                        }
                    }
                }

                /** A content (text or markdown) block in a message in an app feed */
                class ContentBlock
                private constructor(
                    private val content: JsonField<String>,
                    private val name: JsonField<String>,
                    private val rendered: JsonField<String>,
                    private val type: JsonField<Type>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("content")
                        @ExcludeMissing
                        content: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("name")
                        @ExcludeMissing
                        name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("rendered")
                        @ExcludeMissing
                        rendered: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        type: JsonField<Type> = JsonMissing.of(),
                    ) : this(content, name, rendered, type, mutableMapOf())

                    /**
                     * @throws KnockInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun content(): String = content.getRequired("content")

                    /**
                     * @throws KnockInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun name(): String = name.getRequired("name")

                    /**
                     * @throws KnockInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun rendered(): String = rendered.getRequired("rendered")

                    /**
                     * @throws KnockInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun type(): Type = type.getRequired("type")

                    /**
                     * Returns the raw JSON value of [content].
                     *
                     * Unlike [content], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("content")
                    @ExcludeMissing
                    fun _content(): JsonField<String> = content

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    /**
                     * Returns the raw JSON value of [rendered].
                     *
                     * Unlike [rendered], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("rendered")
                    @ExcludeMissing
                    fun _rendered(): JsonField<String> = rendered

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                         * Returns a mutable builder for constructing an instance of [ContentBlock].
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * .name()
                         * .rendered()
                         * .type()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [ContentBlock]. */
                    class Builder internal constructor() {

                        private var content: JsonField<String>? = null
                        private var name: JsonField<String>? = null
                        private var rendered: JsonField<String>? = null
                        private var type: JsonField<Type>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(contentBlock: ContentBlock) = apply {
                            content = contentBlock.content
                            name = contentBlock.name
                            rendered = contentBlock.rendered
                            type = contentBlock.type
                            additionalProperties = contentBlock.additionalProperties.toMutableMap()
                        }

                        fun content(content: String) = content(JsonField.of(content))

                        /**
                         * Sets [Builder.content] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.content] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun content(content: JsonField<String>) = apply { this.content = content }

                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun rendered(rendered: String) = rendered(JsonField.of(rendered))

                        /**
                         * Sets [Builder.rendered] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.rendered] with a well-typed [String]
                         * value instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun rendered(rendered: JsonField<String>) = apply {
                            this.rendered = rendered
                        }

                        fun type(type: Type) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [Type] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<Type>) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [ContentBlock].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .content()
                         * .name()
                         * .rendered()
                         * .type()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): ContentBlock =
                            ContentBlock(
                                checkRequired("content", content),
                                checkRequired("name", name),
                                checkRequired("rendered", rendered),
                                checkRequired("type", type),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): ContentBlock = apply {
                        if (validated) {
                            return@apply
                        }

                        content()
                        name()
                        rendered()
                        type().validate()
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
                        (if (content.asKnown().isPresent) 1 else 0) +
                            (if (name.asKnown().isPresent) 1 else 0) +
                            (if (rendered.asKnown().isPresent) 1 else 0) +
                            (type.asKnown().getOrNull()?.validity() ?: 0)

                    class Type
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val MARKDOWN = of("markdown")

                            @JvmField val TEXT = of("text")

                            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                        }

                        /** An enum containing [Type]'s known values. */
                        enum class Known {
                            MARKDOWN,
                            TEXT,
                        }

                        /**
                         * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Type] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            MARKDOWN,
                            TEXT,
                            /**
                             * An enum member indicating that [Type] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                MARKDOWN -> Value.MARKDOWN
                                TEXT -> Value.TEXT
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws KnockInvalidDataException if this class instance's value is a not
                         *   a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                MARKDOWN -> Known.MARKDOWN
                                TEXT -> Known.TEXT
                                else -> throw KnockInvalidDataException("Unknown Type: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws KnockInvalidDataException if this class instance's value does not
                         *   have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                KnockInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        fun validate(): Type = apply {
                            if (validated) {
                                return@apply
                            }

                            known()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is ContentBlock && content == other.content && name == other.name && rendered == other.rendered && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(content, name, rendered, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "ContentBlock{content=$content, name=$name, rendered=$rendered, type=$type, additionalProperties=$additionalProperties}"
                }

                /** A set of buttons in a message in an app feed */
                class ButtonSetBlock
                private constructor(
                    private val buttons: JsonField<List<Button>>,
                    private val name: JsonField<String>,
                    private val type: JsonField<Type>,
                    private val additionalProperties: MutableMap<String, JsonValue>,
                ) {

                    @JsonCreator
                    private constructor(
                        @JsonProperty("buttons")
                        @ExcludeMissing
                        buttons: JsonField<List<Button>> = JsonMissing.of(),
                        @JsonProperty("name")
                        @ExcludeMissing
                        name: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("type")
                        @ExcludeMissing
                        type: JsonField<Type> = JsonMissing.of(),
                    ) : this(buttons, name, type, mutableMapOf())

                    /**
                     * @throws KnockInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun buttons(): List<Button> = buttons.getRequired("buttons")

                    /**
                     * @throws KnockInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun name(): String = name.getRequired("name")

                    /**
                     * @throws KnockInvalidDataException if the JSON field has an unexpected type or
                     *   is unexpectedly missing or null (e.g. if the server responded with an
                     *   unexpected value).
                     */
                    fun type(): Type = type.getRequired("type")

                    /**
                     * Returns the raw JSON value of [buttons].
                     *
                     * Unlike [buttons], this method doesn't throw if the JSON field has an
                     * unexpected type.
                     */
                    @JsonProperty("buttons")
                    @ExcludeMissing
                    fun _buttons(): JsonField<List<Button>> = buttons

                    /**
                     * Returns the raw JSON value of [name].
                     *
                     * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    /**
                     * Returns the raw JSON value of [type].
                     *
                     * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                     * type.
                     */
                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
                         * Returns a mutable builder for constructing an instance of
                         * [ButtonSetBlock].
                         *
                         * The following fields are required:
                         * ```java
                         * .buttons()
                         * .name()
                         * .type()
                         * ```
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [ButtonSetBlock]. */
                    class Builder internal constructor() {

                        private var buttons: JsonField<MutableList<Button>>? = null
                        private var name: JsonField<String>? = null
                        private var type: JsonField<Type>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(buttonSetBlock: ButtonSetBlock) = apply {
                            buttons = buttonSetBlock.buttons.map { it.toMutableList() }
                            name = buttonSetBlock.name
                            type = buttonSetBlock.type
                            additionalProperties =
                                buttonSetBlock.additionalProperties.toMutableMap()
                        }

                        fun buttons(buttons: List<Button>) = buttons(JsonField.of(buttons))

                        /**
                         * Sets [Builder.buttons] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.buttons] with a well-typed
                         * `List<Button>` value instead. This method is primarily for setting the
                         * field to an undocumented or not yet supported value.
                         */
                        fun buttons(buttons: JsonField<List<Button>>) = apply {
                            this.buttons = buttons.map { it.toMutableList() }
                        }

                        /**
                         * Adds a single [Button] to [buttons].
                         *
                         * @throws IllegalStateException if the field was previously set to a
                         *   non-list.
                         */
                        fun addButton(button: Button) = apply {
                            buttons =
                                (buttons ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("buttons", it).add(button)
                                }
                        }

                        fun name(name: String) = name(JsonField.of(name))

                        /**
                         * Sets [Builder.name] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.name] with a well-typed [String] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun type(type: Type) = type(JsonField.of(type))

                        /**
                         * Sets [Builder.type] to an arbitrary JSON value.
                         *
                         * You should usually call [Builder.type] with a well-typed [Type] value
                         * instead. This method is primarily for setting the field to an
                         * undocumented or not yet supported value.
                         */
                        fun type(type: JsonField<Type>) = apply { this.type = type }

                        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                            apply {
                                this.additionalProperties.clear()
                                putAllAdditionalProperties(additionalProperties)
                            }

                        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                            additionalProperties.put(key, value)
                        }

                        fun putAllAdditionalProperties(
                            additionalProperties: Map<String, JsonValue>
                        ) = apply { this.additionalProperties.putAll(additionalProperties) }

                        fun removeAdditionalProperty(key: String) = apply {
                            additionalProperties.remove(key)
                        }

                        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                        /**
                         * Returns an immutable instance of [ButtonSetBlock].
                         *
                         * Further updates to this [Builder] will not mutate the returned instance.
                         *
                         * The following fields are required:
                         * ```java
                         * .buttons()
                         * .name()
                         * .type()
                         * ```
                         *
                         * @throws IllegalStateException if any required field is unset.
                         */
                        fun build(): ButtonSetBlock =
                            ButtonSetBlock(
                                checkRequired("buttons", buttons).map { it.toImmutable() },
                                checkRequired("name", name),
                                checkRequired("type", type),
                                additionalProperties.toMutableMap(),
                            )
                    }

                    private var validated: Boolean = false

                    fun validate(): ButtonSetBlock = apply {
                        if (validated) {
                            return@apply
                        }

                        buttons().forEach { it.validate() }
                        name()
                        type().validate()
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
                        (buttons.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                            (if (name.asKnown().isPresent) 1 else 0) +
                            (type.asKnown().getOrNull()?.validity() ?: 0)

                    /** A button in a set of buttons */
                    class Button
                    private constructor(
                        private val action: JsonField<String>,
                        private val label: JsonField<String>,
                        private val name: JsonField<String>,
                        private val additionalProperties: MutableMap<String, JsonValue>,
                    ) {

                        @JsonCreator
                        private constructor(
                            @JsonProperty("action")
                            @ExcludeMissing
                            action: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("label")
                            @ExcludeMissing
                            label: JsonField<String> = JsonMissing.of(),
                            @JsonProperty("name")
                            @ExcludeMissing
                            name: JsonField<String> = JsonMissing.of(),
                        ) : this(action, label, name, mutableMapOf())

                        /**
                         * @throws KnockInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun action(): String = action.getRequired("action")

                        /**
                         * @throws KnockInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun label(): String = label.getRequired("label")

                        /**
                         * @throws KnockInvalidDataException if the JSON field has an unexpected
                         *   type or is unexpectedly missing or null (e.g. if the server responded
                         *   with an unexpected value).
                         */
                        fun name(): String = name.getRequired("name")

                        /**
                         * Returns the raw JSON value of [action].
                         *
                         * Unlike [action], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("action")
                        @ExcludeMissing
                        fun _action(): JsonField<String> = action

                        /**
                         * Returns the raw JSON value of [label].
                         *
                         * Unlike [label], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("label")
                        @ExcludeMissing
                        fun _label(): JsonField<String> = label

                        /**
                         * Returns the raw JSON value of [name].
                         *
                         * Unlike [name], this method doesn't throw if the JSON field has an
                         * unexpected type.
                         */
                        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
                             * Returns a mutable builder for constructing an instance of [Button].
                             *
                             * The following fields are required:
                             * ```java
                             * .action()
                             * .label()
                             * .name()
                             * ```
                             */
                            @JvmStatic fun builder() = Builder()
                        }

                        /** A builder for [Button]. */
                        class Builder internal constructor() {

                            private var action: JsonField<String>? = null
                            private var label: JsonField<String>? = null
                            private var name: JsonField<String>? = null
                            private var additionalProperties: MutableMap<String, JsonValue> =
                                mutableMapOf()

                            @JvmSynthetic
                            internal fun from(button: Button) = apply {
                                action = button.action
                                label = button.label
                                name = button.name
                                additionalProperties = button.additionalProperties.toMutableMap()
                            }

                            fun action(action: String) = action(JsonField.of(action))

                            /**
                             * Sets [Builder.action] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.action] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun action(action: JsonField<String>) = apply { this.action = action }

                            fun label(label: String) = label(JsonField.of(label))

                            /**
                             * Sets [Builder.label] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.label] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun label(label: JsonField<String>) = apply { this.label = label }

                            fun name(name: String) = name(JsonField.of(name))

                            /**
                             * Sets [Builder.name] to an arbitrary JSON value.
                             *
                             * You should usually call [Builder.name] with a well-typed [String]
                             * value instead. This method is primarily for setting the field to an
                             * undocumented or not yet supported value.
                             */
                            fun name(name: JsonField<String>) = apply { this.name = name }

                            fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                                apply {
                                    this.additionalProperties.clear()
                                    putAllAdditionalProperties(additionalProperties)
                                }

                            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                                additionalProperties.put(key, value)
                            }

                            fun putAllAdditionalProperties(
                                additionalProperties: Map<String, JsonValue>
                            ) = apply { this.additionalProperties.putAll(additionalProperties) }

                            fun removeAdditionalProperty(key: String) = apply {
                                additionalProperties.remove(key)
                            }

                            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                                keys.forEach(::removeAdditionalProperty)
                            }

                            /**
                             * Returns an immutable instance of [Button].
                             *
                             * Further updates to this [Builder] will not mutate the returned
                             * instance.
                             *
                             * The following fields are required:
                             * ```java
                             * .action()
                             * .label()
                             * .name()
                             * ```
                             *
                             * @throws IllegalStateException if any required field is unset.
                             */
                            fun build(): Button =
                                Button(
                                    checkRequired("action", action),
                                    checkRequired("label", label),
                                    checkRequired("name", name),
                                    additionalProperties.toMutableMap(),
                                )
                        }

                        private var validated: Boolean = false

                        fun validate(): Button = apply {
                            if (validated) {
                                return@apply
                            }

                            action()
                            label()
                            name()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int =
                            (if (action.asKnown().isPresent) 1 else 0) +
                                (if (label.asKnown().isPresent) 1 else 0) +
                                (if (name.asKnown().isPresent) 1 else 0)

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Button && action == other.action && label == other.label && name == other.name && additionalProperties == other.additionalProperties /* spotless:on */
                        }

                        /* spotless:off */
                        private val hashCode: Int by lazy { Objects.hash(action, label, name, additionalProperties) }
                        /* spotless:on */

                        override fun hashCode(): Int = hashCode

                        override fun toString() =
                            "Button{action=$action, label=$label, name=$name, additionalProperties=$additionalProperties}"
                    }

                    class Type
                    @JsonCreator
                    private constructor(private val value: JsonField<String>) : Enum {

                        /**
                         * Returns this class instance's raw value.
                         *
                         * This is usually only useful if this instance was deserialized from data
                         * that doesn't match any known member, and you want to know that value. For
                         * example, if the SDK is on an older version than the API, then the API may
                         * respond with new members that the SDK is unaware of.
                         */
                        @com.fasterxml.jackson.annotation.JsonValue
                        fun _value(): JsonField<String> = value

                        companion object {

                            @JvmField val BUTTON_SET = of("button_set")

                            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                        }

                        /** An enum containing [Type]'s known values. */
                        enum class Known {
                            BUTTON_SET
                        }

                        /**
                         * An enum containing [Type]'s known values, as well as an [_UNKNOWN]
                         * member.
                         *
                         * An instance of [Type] can contain an unknown value in a couple of cases:
                         * - It was deserialized from data that doesn't match any known member. For
                         *   example, if the SDK is on an older version than the API, then the API
                         *   may respond with new members that the SDK is unaware of.
                         * - It was constructed with an arbitrary value using the [of] method.
                         */
                        enum class Value {
                            BUTTON_SET,
                            /**
                             * An enum member indicating that [Type] was instantiated with an
                             * unknown value.
                             */
                            _UNKNOWN,
                        }

                        /**
                         * Returns an enum member corresponding to this class instance's value, or
                         * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                         *
                         * Use the [known] method instead if you're certain the value is always
                         * known or if you want to throw for the unknown case.
                         */
                        fun value(): Value =
                            when (this) {
                                BUTTON_SET -> Value.BUTTON_SET
                                else -> Value._UNKNOWN
                            }

                        /**
                         * Returns an enum member corresponding to this class instance's value.
                         *
                         * Use the [value] method instead if you're uncertain the value is always
                         * known and don't want to throw for the unknown case.
                         *
                         * @throws KnockInvalidDataException if this class instance's value is a not
                         *   a known member.
                         */
                        fun known(): Known =
                            when (this) {
                                BUTTON_SET -> Known.BUTTON_SET
                                else -> throw KnockInvalidDataException("Unknown Type: $value")
                            }

                        /**
                         * Returns this class instance's primitive wire representation.
                         *
                         * This differs from the [toString] method because that method is primarily
                         * for debugging and generally doesn't throw.
                         *
                         * @throws KnockInvalidDataException if this class instance's value does not
                         *   have the expected primitive type.
                         */
                        fun asString(): String =
                            _value().asString().orElseThrow {
                                KnockInvalidDataException("Value is not a String")
                            }

                        private var validated: Boolean = false

                        fun validate(): Type = apply {
                            if (validated) {
                                return@apply
                            }

                            known()
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
                         * Returns a score indicating how many valid values are contained in this
                         * object recursively.
                         *
                         * Used for best match union deserialization.
                         */
                        @JvmSynthetic
                        internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

                        override fun equals(other: Any?): Boolean {
                            if (this === other) {
                                return true
                            }

                            return /* spotless:off */ other is Type && value == other.value /* spotless:on */
                        }

                        override fun hashCode() = value.hashCode()

                        override fun toString() = value.toString()
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is ButtonSetBlock && buttons == other.buttons && name == other.name && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(buttons, name, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "ButtonSetBlock{buttons=$buttons, name=$name, type=$type, additionalProperties=$additionalProperties}"
                }
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is MessageInAppFeedContent && _typename == other._typename && blocks == other.blocks && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(_typename, blocks, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "MessageInAppFeedContent{_typename=$_typename, blocks=$blocks, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchGetContentResponse && _typename == other._typename && data == other.data && insertedAt == other.insertedAt && messageId == other.messageId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(_typename, data, insertedAt, messageId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "BatchGetContentResponse{_typename=$_typename, data=$data, insertedAt=$insertedAt, messageId=$messageId, additionalProperties=$additionalProperties}"
}
