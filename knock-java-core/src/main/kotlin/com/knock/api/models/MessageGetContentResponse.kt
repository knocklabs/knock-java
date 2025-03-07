// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

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
import com.knock.api.core.BaseDeserializer
import com.knock.api.core.BaseSerializer
import com.knock.api.core.Enum
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkKnown
import com.knock.api.core.checkRequired
import com.knock.api.core.getOrThrow
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.errors.KnockInvalidDataException
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/** The contents of a message */
@NoAutoDetect
class MessageGetContentResponse
@JsonCreator
private constructor(
    @JsonProperty("__typename")
    @ExcludeMissing
    private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<Data> = JsonMissing.of(),
    @JsonProperty("inserted_at")
    @ExcludeMissing
    private val insertedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("message_id")
    @ExcludeMissing
    private val messageId: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun _typename(): String = _typename.getRequired("__typename")

    /** The contents of an email message */
    fun data(): Data = data.getRequired("data")

    fun insertedAt(): OffsetDateTime = insertedAt.getRequired("inserted_at")

    fun messageId(): String = messageId.getRequired("message_id")

    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    /** The contents of an email message */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    @JsonProperty("inserted_at")
    @ExcludeMissing
    fun _insertedAt(): JsonField<OffsetDateTime> = insertedAt

    @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): MessageGetContentResponse = apply {
        if (validated) {
            return@apply
        }

        _typename()
        data().validate()
        insertedAt()
        messageId()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [MessageGetContentResponse].
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

    /** A builder for [MessageGetContentResponse]. */
    class Builder internal constructor() {

        private var _typename: JsonField<String>? = null
        private var data: JsonField<Data>? = null
        private var insertedAt: JsonField<OffsetDateTime>? = null
        private var messageId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageGetContentResponse: MessageGetContentResponse) = apply {
            _typename = messageGetContentResponse._typename
            data = messageGetContentResponse.data
            insertedAt = messageGetContentResponse.insertedAt
            messageId = messageGetContentResponse.messageId
            additionalProperties = messageGetContentResponse.additionalProperties.toMutableMap()
        }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        /** The contents of an email message */
        fun data(data: Data) = data(JsonField.of(data))

        /** The contents of an email message */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** The contents of an email message */
        fun data(messageEmailContent: Data.MessageEmailContent) =
            data(Data.ofMessageEmailContent(messageEmailContent))

        /** The contents of an SMS message */
        fun data(messageSmsContent: Data.MessageSmsContent) =
            data(Data.ofMessageSmsContent(messageSmsContent))

        /** The contents of a push message */
        fun data(messagePushContent: Data.MessagePushContent) =
            data(Data.ofMessagePushContent(messagePushContent))

        /** The contents of a chat message */
        fun data(messageChatContent: Data.MessageChatContent) =
            data(Data.ofMessageChatContent(messageChatContent))

        /** The contents of a message in an app feed */
        fun data(messageInAppFeedContent: Data.MessageInAppFeedContent) =
            data(Data.ofMessageInAppFeedContent(messageInAppFeedContent))

        fun insertedAt(insertedAt: OffsetDateTime) = insertedAt(JsonField.of(insertedAt))

        fun insertedAt(insertedAt: JsonField<OffsetDateTime>) = apply {
            this.insertedAt = insertedAt
        }

        fun messageId(messageId: String) = messageId(JsonField.of(messageId))

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

        fun build(): MessageGetContentResponse =
            MessageGetContentResponse(
                checkRequired("_typename", _typename),
                checkRequired("data", data),
                checkRequired("insertedAt", insertedAt),
                checkRequired("messageId", messageId),
                additionalProperties.toImmutable(),
            )
    }

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

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                messageEmailContent != null -> visitor.visitMessageEmailContent(messageEmailContent)
                messageSmsContent != null -> visitor.visitMessageSmsContent(messageSmsContent)
                messagePushContent != null -> visitor.visitMessagePushContent(messagePushContent)
                messageChatContent != null -> visitor.visitMessageChatContent(messageChatContent)
                messageInAppFeedContent != null ->
                    visitor.visitMessageInAppFeedContent(messageInAppFeedContent)
                else -> visitor.unknown(_json)
            }
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

                tryDeserialize(node, jacksonTypeRef<MessageEmailContent>()) { it.validate() }
                    ?.let {
                        return Data(messageEmailContent = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<MessageSmsContent>()) { it.validate() }
                    ?.let {
                        return Data(messageSmsContent = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<MessagePushContent>()) { it.validate() }
                    ?.let {
                        return Data(messagePushContent = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<MessageChatContent>()) { it.validate() }
                    ?.let {
                        return Data(messageChatContent = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<MessageInAppFeedContent>()) { it.validate() }
                    ?.let {
                        return Data(messageInAppFeedContent = it, _json = json)
                    }

                return Data(_json = json)
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
        @NoAutoDetect
        class MessageEmailContent
        @JsonCreator
        private constructor(
            @JsonProperty("__typename")
            @ExcludeMissing
            private val _typename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("from")
            @ExcludeMissing
            private val from: JsonField<String> = JsonMissing.of(),
            @JsonProperty("html_body")
            @ExcludeMissing
            private val htmlBody: JsonField<String> = JsonMissing.of(),
            @JsonProperty("subject_line")
            @ExcludeMissing
            private val subjectLine: JsonField<String> = JsonMissing.of(),
            @JsonProperty("text_body")
            @ExcludeMissing
            private val textBody: JsonField<String> = JsonMissing.of(),
            @JsonProperty("to")
            @ExcludeMissing
            private val to: JsonField<String> = JsonMissing.of(),
            @JsonProperty("bcc")
            @ExcludeMissing
            private val bcc: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cc")
            @ExcludeMissing
            private val cc: JsonField<String> = JsonMissing.of(),
            @JsonProperty("reply_to")
            @ExcludeMissing
            private val replyTo: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun _typename(): String = _typename.getRequired("__typename")

            fun from(): String = from.getRequired("from")

            fun htmlBody(): String = htmlBody.getRequired("html_body")

            fun subjectLine(): String = subjectLine.getRequired("subject_line")

            fun textBody(): String = textBody.getRequired("text_body")

            fun to(): String = to.getRequired("to")

            fun bcc(): Optional<String> = Optional.ofNullable(bcc.getNullable("bcc"))

            fun cc(): Optional<String> = Optional.ofNullable(cc.getNullable("cc"))

            fun replyTo(): Optional<String> = Optional.ofNullable(replyTo.getNullable("reply_to"))

            @JsonProperty("__typename")
            @ExcludeMissing
            fun __typename(): JsonField<String> = _typename

            @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<String> = from

            @JsonProperty("html_body") @ExcludeMissing fun _htmlBody(): JsonField<String> = htmlBody

            @JsonProperty("subject_line")
            @ExcludeMissing
            fun _subjectLine(): JsonField<String> = subjectLine

            @JsonProperty("text_body") @ExcludeMissing fun _textBody(): JsonField<String> = textBody

            @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<String> = to

            @JsonProperty("bcc") @ExcludeMissing fun _bcc(): JsonField<String> = bcc

            @JsonProperty("cc") @ExcludeMissing fun _cc(): JsonField<String> = cc

            @JsonProperty("reply_to") @ExcludeMissing fun _replyTo(): JsonField<String> = replyTo

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

                fun from(from: String) = from(JsonField.of(from))

                fun from(from: JsonField<String>) = apply { this.from = from }

                fun htmlBody(htmlBody: String) = htmlBody(JsonField.of(htmlBody))

                fun htmlBody(htmlBody: JsonField<String>) = apply { this.htmlBody = htmlBody }

                fun subjectLine(subjectLine: String) = subjectLine(JsonField.of(subjectLine))

                fun subjectLine(subjectLine: JsonField<String>) = apply {
                    this.subjectLine = subjectLine
                }

                fun textBody(textBody: String) = textBody(JsonField.of(textBody))

                fun textBody(textBody: JsonField<String>) = apply { this.textBody = textBody }

                fun to(to: String) = to(JsonField.of(to))

                fun to(to: JsonField<String>) = apply { this.to = to }

                fun bcc(bcc: String?) = bcc(JsonField.ofNullable(bcc))

                fun bcc(bcc: Optional<String>) = bcc(bcc.orElse(null))

                fun bcc(bcc: JsonField<String>) = apply { this.bcc = bcc }

                fun cc(cc: String?) = cc(JsonField.ofNullable(cc))

                fun cc(cc: Optional<String>) = cc(cc.orElse(null))

                fun cc(cc: JsonField<String>) = apply { this.cc = cc }

                fun replyTo(replyTo: String?) = replyTo(JsonField.ofNullable(replyTo))

                fun replyTo(replyTo: Optional<String>) = replyTo(replyTo.orElse(null))

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
                        additionalProperties.toImmutable(),
                    )
            }

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
        @NoAutoDetect
        class MessageSmsContent
        @JsonCreator
        private constructor(
            @JsonProperty("__typename")
            @ExcludeMissing
            private val _typename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("body")
            @ExcludeMissing
            private val body: JsonField<String> = JsonMissing.of(),
            @JsonProperty("to")
            @ExcludeMissing
            private val to: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun _typename(): String = _typename.getRequired("__typename")

            fun body(): String = body.getRequired("body")

            fun to(): String = to.getRequired("to")

            @JsonProperty("__typename")
            @ExcludeMissing
            fun __typename(): JsonField<String> = _typename

            @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<String> = body

            @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<String> = to

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

                fun body(body: String) = body(JsonField.of(body))

                fun body(body: JsonField<String>) = apply { this.body = body }

                fun to(to: String) = to(JsonField.of(to))

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

                fun build(): MessageSmsContent =
                    MessageSmsContent(
                        checkRequired("_typename", _typename),
                        checkRequired("body", body),
                        checkRequired("to", to),
                        additionalProperties.toImmutable(),
                    )
            }

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
        @NoAutoDetect
        class MessagePushContent
        @JsonCreator
        private constructor(
            @JsonProperty("token")
            @ExcludeMissing
            private val token: JsonField<String> = JsonMissing.of(),
            @JsonProperty("__typename")
            @ExcludeMissing
            private val _typename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("body")
            @ExcludeMissing
            private val body: JsonField<String> = JsonMissing.of(),
            @JsonProperty("title")
            @ExcludeMissing
            private val title: JsonField<String> = JsonMissing.of(),
            @JsonProperty("data")
            @ExcludeMissing
            private val data: JsonField<InnerData> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun token(): String = token.getRequired("token")

            fun _typename(): String = _typename.getRequired("__typename")

            fun body(): String = body.getRequired("body")

            fun title(): String = title.getRequired("title")

            fun data(): Optional<InnerData> = Optional.ofNullable(data.getNullable("data"))

            @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<String> = token

            @JsonProperty("__typename")
            @ExcludeMissing
            fun __typename(): JsonField<String> = _typename

            @JsonProperty("body") @ExcludeMissing fun _body(): JsonField<String> = body

            @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

            @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<InnerData> = data

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): MessagePushContent = apply {
                if (validated) {
                    return@apply
                }

                token()
                _typename()
                body()
                title()
                data().ifPresent { it.validate() }
                validated = true
            }

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
                private var data: JsonField<InnerData> = JsonMissing.of()
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

                fun token(token: JsonField<String>) = apply { this.token = token }

                fun _typename(_typename: String) = _typename(JsonField.of(_typename))

                fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

                fun body(body: String) = body(JsonField.of(body))

                fun body(body: JsonField<String>) = apply { this.body = body }

                fun title(title: String) = title(JsonField.of(title))

                fun title(title: JsonField<String>) = apply { this.title = title }

                fun data(data: InnerData?) = data(JsonField.ofNullable(data))

                fun data(data: Optional<InnerData>) = data(data.orElse(null))

                fun data(data: JsonField<InnerData>) = apply { this.data = data }

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

                fun build(): MessagePushContent =
                    MessagePushContent(
                        checkRequired("token", token),
                        checkRequired("_typename", _typename),
                        checkRequired("body", body),
                        checkRequired("title", title),
                        data,
                        additionalProperties.toImmutable(),
                    )
            }

            @NoAutoDetect
            class InnerData
            @JsonCreator
            private constructor(
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): InnerData = apply {
                    if (validated) {
                        return@apply
                    }

                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [InnerData]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [InnerData]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(innerData: InnerData) = apply {
                        additionalProperties = innerData.additionalProperties.toMutableMap()
                    }

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

                    fun build(): InnerData = InnerData(additionalProperties.toImmutable())
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is InnerData && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "InnerData{additionalProperties=$additionalProperties}"
            }

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
        @NoAutoDetect
        class MessageChatContent
        @JsonCreator
        private constructor(
            @JsonProperty("__typename")
            @ExcludeMissing
            private val _typename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("connection")
            @ExcludeMissing
            private val connection: JsonField<Connection> = JsonMissing.of(),
            @JsonProperty("template")
            @ExcludeMissing
            private val template: JsonField<Template> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            private val metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun _typename(): String = _typename.getRequired("__typename")

            /** The channel data connection from the recipient to the underlying provider */
            fun connection(): Connection = connection.getRequired("connection")

            fun template(): Template = template.getRequired("template")

            fun metadata(): Optional<Metadata> =
                Optional.ofNullable(metadata.getNullable("metadata"))

            @JsonProperty("__typename")
            @ExcludeMissing
            fun __typename(): JsonField<String> = _typename

            /** The channel data connection from the recipient to the underlying provider */
            @JsonProperty("connection")
            @ExcludeMissing
            fun _connection(): JsonField<Connection> = connection

            @JsonProperty("template")
            @ExcludeMissing
            fun _template(): JsonField<Template> = template

            @JsonProperty("metadata")
            @ExcludeMissing
            fun _metadata(): JsonField<Metadata> = metadata

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): MessageChatContent = apply {
                if (validated) {
                    return@apply
                }

                _typename()
                connection().validate()
                template().validate()
                metadata().ifPresent { it.validate() }
                validated = true
            }

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
                private var connection: JsonField<Connection>? = null
                private var template: JsonField<Template>? = null
                private var metadata: JsonField<Metadata> = JsonMissing.of()
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

                fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

                /** The channel data connection from the recipient to the underlying provider */
                fun connection(connection: Connection) = connection(JsonField.of(connection))

                /** The channel data connection from the recipient to the underlying provider */
                fun connection(connection: JsonField<Connection>) = apply {
                    this.connection = connection
                }

                fun template(template: Template) = template(JsonField.of(template))

                fun template(template: JsonField<Template>) = apply { this.template = template }

                fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

                fun metadata(metadata: Optional<Metadata>) = metadata(metadata.orElse(null))

                fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

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

                fun build(): MessageChatContent =
                    MessageChatContent(
                        checkRequired("_typename", _typename),
                        checkRequired("connection", connection),
                        checkRequired("template", template),
                        metadata,
                        additionalProperties.toImmutable(),
                    )
            }

            /** The channel data connection from the recipient to the underlying provider */
            @NoAutoDetect
            class Connection
            @JsonCreator
            private constructor(
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Connection = apply {
                    if (validated) {
                        return@apply
                    }

                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Connection]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Connection]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(connection: Connection) = apply {
                        additionalProperties = connection.additionalProperties.toMutableMap()
                    }

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

                    fun build(): Connection = Connection(additionalProperties.toImmutable())
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Connection && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "Connection{additionalProperties=$additionalProperties}"
            }

            @NoAutoDetect
            class Template
            @JsonCreator
            private constructor(
                @JsonProperty("blocks")
                @ExcludeMissing
                private val blocks: JsonField<List<Block>> = JsonMissing.of(),
                @JsonProperty("json_content")
                @ExcludeMissing
                private val jsonContent: JsonField<JsonContent> = JsonMissing.of(),
                @JsonProperty("summary")
                @ExcludeMissing
                private val summary: JsonField<String> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /** The structured blocks of the message */
                fun blocks(): Optional<List<Block>> =
                    Optional.ofNullable(blocks.getNullable("blocks"))

                /** The JSON content of the message */
                fun jsonContent(): Optional<JsonContent> =
                    Optional.ofNullable(jsonContent.getNullable("json_content"))

                fun summary(): Optional<String> =
                    Optional.ofNullable(summary.getNullable("summary"))

                /** The structured blocks of the message */
                @JsonProperty("blocks")
                @ExcludeMissing
                fun _blocks(): JsonField<List<Block>> = blocks

                /** The JSON content of the message */
                @JsonProperty("json_content")
                @ExcludeMissing
                fun _jsonContent(): JsonField<JsonContent> = jsonContent

                @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<String> = summary

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Template = apply {
                    if (validated) {
                        return@apply
                    }

                    blocks().ifPresent { it.forEach { it.validate() } }
                    jsonContent().ifPresent { it.validate() }
                    summary()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Template]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Template]. */
                class Builder internal constructor() {

                    private var blocks: JsonField<MutableList<Block>>? = null
                    private var jsonContent: JsonField<JsonContent> = JsonMissing.of()
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

                    /** The structured blocks of the message */
                    fun blocks(blocks: Optional<List<Block>>) = blocks(blocks.orElse(null))

                    /** The structured blocks of the message */
                    fun blocks(blocks: JsonField<List<Block>>) = apply {
                        this.blocks = blocks.map { it.toMutableList() }
                    }

                    /** The structured blocks of the message */
                    fun addBlock(block: Block) = apply {
                        blocks =
                            (blocks ?: JsonField.of(mutableListOf())).also {
                                checkKnown("blocks", it).add(block)
                            }
                    }

                    /** The JSON content of the message */
                    fun jsonContent(jsonContent: JsonContent?) =
                        jsonContent(JsonField.ofNullable(jsonContent))

                    /** The JSON content of the message */
                    fun jsonContent(jsonContent: Optional<JsonContent>) =
                        jsonContent(jsonContent.orElse(null))

                    /** The JSON content of the message */
                    fun jsonContent(jsonContent: JsonField<JsonContent>) = apply {
                        this.jsonContent = jsonContent
                    }

                    fun summary(summary: String?) = summary(JsonField.ofNullable(summary))

                    fun summary(summary: Optional<String>) = summary(summary.orElse(null))

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

                    fun build(): Template =
                        Template(
                            (blocks ?: JsonMissing.of()).map { it.toImmutable() },
                            jsonContent,
                            summary,
                            additionalProperties.toImmutable(),
                        )
                }

                /** A block in a chat message */
                @NoAutoDetect
                class Block
                @JsonCreator
                private constructor(
                    @JsonProperty("content")
                    @ExcludeMissing
                    private val content: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    private val name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    private val type: JsonField<Type> = JsonMissing.of(),
                    @JsonAnySetter
                    private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
                ) {

                    fun content(): String = content.getRequired("content")

                    fun name(): String = name.getRequired("name")

                    fun type(): Type = type.getRequired("type")

                    @JsonProperty("content")
                    @ExcludeMissing
                    fun _content(): JsonField<String> = content

                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    private var validated: Boolean = false

                    fun validate(): Block = apply {
                        if (validated) {
                            return@apply
                        }

                        content()
                        name()
                        type()
                        validated = true
                    }

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

                        fun content(content: JsonField<String>) = apply { this.content = content }

                        fun name(name: String) = name(JsonField.of(name))

                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun type(type: Type) = type(JsonField.of(type))

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

                        fun build(): Block =
                            Block(
                                checkRequired("content", content),
                                checkRequired("name", name),
                                checkRequired("type", type),
                                additionalProperties.toImmutable(),
                            )
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

                /** The JSON content of the message */
                @NoAutoDetect
                class JsonContent
                @JsonCreator
                private constructor(
                    @JsonAnySetter
                    private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
                ) {

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    private var validated: Boolean = false

                    fun validate(): JsonContent = apply {
                        if (validated) {
                            return@apply
                        }

                        validated = true
                    }

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of [JsonContent].
                         */
                        @JvmStatic fun builder() = Builder()
                    }

                    /** A builder for [JsonContent]. */
                    class Builder internal constructor() {

                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(jsonContent: JsonContent) = apply {
                            additionalProperties = jsonContent.additionalProperties.toMutableMap()
                        }

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

                        fun build(): JsonContent = JsonContent(additionalProperties.toImmutable())
                    }

                    override fun equals(other: Any?): Boolean {
                        if (this === other) {
                            return true
                        }

                        return /* spotless:off */ other is JsonContent && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "JsonContent{additionalProperties=$additionalProperties}"
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

            @NoAutoDetect
            class Metadata
            @JsonCreator
            private constructor(
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap()
            ) {

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): Metadata = apply {
                    if (validated) {
                        return@apply
                    }

                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /** Returns a mutable builder for constructing an instance of [Metadata]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Metadata]. */
                class Builder internal constructor() {

                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(metadata: Metadata) = apply {
                        additionalProperties = metadata.additionalProperties.toMutableMap()
                    }

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

                    fun build(): Metadata = Metadata(additionalProperties.toImmutable())
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
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
        @NoAutoDetect
        class MessageInAppFeedContent
        @JsonCreator
        private constructor(
            @JsonProperty("__typename")
            @ExcludeMissing
            private val _typename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("blocks")
            @ExcludeMissing
            private val blocks: JsonField<List<Block>> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun _typename(): String = _typename.getRequired("__typename")

            /** The blocks of the message */
            fun blocks(): List<Block> = blocks.getRequired("blocks")

            @JsonProperty("__typename")
            @ExcludeMissing
            fun __typename(): JsonField<String> = _typename

            /** The blocks of the message */
            @JsonProperty("blocks") @ExcludeMissing fun _blocks(): JsonField<List<Block>> = blocks

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): MessageInAppFeedContent = apply {
                if (validated) {
                    return@apply
                }

                _typename()
                blocks().forEach { it.validate() }
                validated = true
            }

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

                fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

                /** The blocks of the message */
                fun blocks(blocks: List<Block>) = blocks(JsonField.of(blocks))

                /** The blocks of the message */
                fun blocks(blocks: JsonField<List<Block>>) = apply {
                    this.blocks = blocks.map { it.toMutableList() }
                }

                /** The blocks of the message */
                fun addBlock(block: Block) = apply {
                    blocks =
                        (blocks ?: JsonField.of(mutableListOf())).also {
                            checkKnown("blocks", it).add(block)
                        }
                }

                /** A content (text or markdown) block in a message in an app feed */
                fun addBlock(messageInAppFeedContent: Block.MessageInAppFeedContentBlock) =
                    addBlock(Block.ofMessageInAppFeedContent(messageInAppFeedContent))

                /** A set of buttons in a message in an app feed */
                fun addBlock(messageInAppFeedButtonSet: Block.MessageInAppFeedButtonSetBlock) =
                    addBlock(Block.ofMessageInAppFeedButtonSet(messageInAppFeedButtonSet))

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

                fun build(): MessageInAppFeedContent =
                    MessageInAppFeedContent(
                        checkRequired("_typename", _typename),
                        checkRequired("blocks", blocks).map { it.toImmutable() },
                        additionalProperties.toImmutable(),
                    )
            }

            /** A content (text or markdown) block in a message in an app feed */
            @JsonDeserialize(using = Block.Deserializer::class)
            @JsonSerialize(using = Block.Serializer::class)
            class Block
            private constructor(
                private val messageInAppFeedContent: MessageInAppFeedContentBlock? = null,
                private val messageInAppFeedButtonSet: MessageInAppFeedButtonSetBlock? = null,
                private val _json: JsonValue? = null,
            ) {

                /** A content (text or markdown) block in a message in an app feed */
                fun messageInAppFeedContent(): Optional<MessageInAppFeedContentBlock> =
                    Optional.ofNullable(messageInAppFeedContent)

                /** A set of buttons in a message in an app feed */
                fun messageInAppFeedButtonSet(): Optional<MessageInAppFeedButtonSetBlock> =
                    Optional.ofNullable(messageInAppFeedButtonSet)

                fun isMessageInAppFeedContent(): Boolean = messageInAppFeedContent != null

                fun isMessageInAppFeedButtonSet(): Boolean = messageInAppFeedButtonSet != null

                /** A content (text or markdown) block in a message in an app feed */
                fun asMessageInAppFeedContent(): MessageInAppFeedContentBlock =
                    messageInAppFeedContent.getOrThrow("messageInAppFeedContent")

                /** A set of buttons in a message in an app feed */
                fun asMessageInAppFeedButtonSet(): MessageInAppFeedButtonSetBlock =
                    messageInAppFeedButtonSet.getOrThrow("messageInAppFeedButtonSet")

                fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

                fun <T> accept(visitor: Visitor<T>): T {
                    return when {
                        messageInAppFeedContent != null ->
                            visitor.visitMessageInAppFeedContent(messageInAppFeedContent)
                        messageInAppFeedButtonSet != null ->
                            visitor.visitMessageInAppFeedButtonSet(messageInAppFeedButtonSet)
                        else -> visitor.unknown(_json)
                    }
                }

                private var validated: Boolean = false

                fun validate(): Block = apply {
                    if (validated) {
                        return@apply
                    }

                    accept(
                        object : Visitor<Unit> {
                            override fun visitMessageInAppFeedContent(
                                messageInAppFeedContent: MessageInAppFeedContentBlock
                            ) {
                                messageInAppFeedContent.validate()
                            }

                            override fun visitMessageInAppFeedButtonSet(
                                messageInAppFeedButtonSet: MessageInAppFeedButtonSetBlock
                            ) {
                                messageInAppFeedButtonSet.validate()
                            }
                        }
                    )
                    validated = true
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is Block && messageInAppFeedContent == other.messageInAppFeedContent && messageInAppFeedButtonSet == other.messageInAppFeedButtonSet /* spotless:on */
                }

                override fun hashCode(): Int = /* spotless:off */ Objects.hash(messageInAppFeedContent, messageInAppFeedButtonSet) /* spotless:on */

                override fun toString(): String =
                    when {
                        messageInAppFeedContent != null ->
                            "Block{messageInAppFeedContent=$messageInAppFeedContent}"
                        messageInAppFeedButtonSet != null ->
                            "Block{messageInAppFeedButtonSet=$messageInAppFeedButtonSet}"
                        _json != null -> "Block{_unknown=$_json}"
                        else -> throw IllegalStateException("Invalid Block")
                    }

                companion object {

                    /** A content (text or markdown) block in a message in an app feed */
                    @JvmStatic
                    fun ofMessageInAppFeedContent(
                        messageInAppFeedContent: MessageInAppFeedContentBlock
                    ) = Block(messageInAppFeedContent = messageInAppFeedContent)

                    /** A set of buttons in a message in an app feed */
                    @JvmStatic
                    fun ofMessageInAppFeedButtonSet(
                        messageInAppFeedButtonSet: MessageInAppFeedButtonSetBlock
                    ) = Block(messageInAppFeedButtonSet = messageInAppFeedButtonSet)
                }

                /**
                 * An interface that defines how to map each variant of [Block] to a value of type
                 * [T].
                 */
                interface Visitor<out T> {

                    /** A content (text or markdown) block in a message in an app feed */
                    fun visitMessageInAppFeedContent(
                        messageInAppFeedContent: MessageInAppFeedContentBlock
                    ): T

                    /** A set of buttons in a message in an app feed */
                    fun visitMessageInAppFeedButtonSet(
                        messageInAppFeedButtonSet: MessageInAppFeedButtonSetBlock
                    ): T

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

                        tryDeserialize(node, jacksonTypeRef<MessageInAppFeedContentBlock>()) {
                                it.validate()
                            }
                            ?.let {
                                return Block(messageInAppFeedContent = it, _json = json)
                            }
                        tryDeserialize(node, jacksonTypeRef<MessageInAppFeedButtonSetBlock>()) {
                                it.validate()
                            }
                            ?.let {
                                return Block(messageInAppFeedButtonSet = it, _json = json)
                            }

                        return Block(_json = json)
                    }
                }

                internal class Serializer : BaseSerializer<Block>(Block::class) {

                    override fun serialize(
                        value: Block,
                        generator: JsonGenerator,
                        provider: SerializerProvider,
                    ) {
                        when {
                            value.messageInAppFeedContent != null ->
                                generator.writeObject(value.messageInAppFeedContent)
                            value.messageInAppFeedButtonSet != null ->
                                generator.writeObject(value.messageInAppFeedButtonSet)
                            value._json != null -> generator.writeObject(value._json)
                            else -> throw IllegalStateException("Invalid Block")
                        }
                    }
                }

                /** A content (text or markdown) block in a message in an app feed */
                @NoAutoDetect
                class MessageInAppFeedContentBlock
                @JsonCreator
                private constructor(
                    @JsonProperty("content")
                    @ExcludeMissing
                    private val content: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    private val name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("rendered")
                    @ExcludeMissing
                    private val rendered: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    private val type: JsonField<Type> = JsonMissing.of(),
                    @JsonAnySetter
                    private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
                ) {

                    fun content(): String = content.getRequired("content")

                    fun name(): String = name.getRequired("name")

                    fun rendered(): String = rendered.getRequired("rendered")

                    fun type(): Type = type.getRequired("type")

                    @JsonProperty("content")
                    @ExcludeMissing
                    fun _content(): JsonField<String> = content

                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    @JsonProperty("rendered")
                    @ExcludeMissing
                    fun _rendered(): JsonField<String> = rendered

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    private var validated: Boolean = false

                    fun validate(): MessageInAppFeedContentBlock = apply {
                        if (validated) {
                            return@apply
                        }

                        content()
                        name()
                        rendered()
                        type()
                        validated = true
                    }

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [MessageInAppFeedContentBlock].
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

                    /** A builder for [MessageInAppFeedContentBlock]. */
                    class Builder internal constructor() {

                        private var content: JsonField<String>? = null
                        private var name: JsonField<String>? = null
                        private var rendered: JsonField<String>? = null
                        private var type: JsonField<Type>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(
                            messageInAppFeedContentBlock: MessageInAppFeedContentBlock
                        ) = apply {
                            content = messageInAppFeedContentBlock.content
                            name = messageInAppFeedContentBlock.name
                            rendered = messageInAppFeedContentBlock.rendered
                            type = messageInAppFeedContentBlock.type
                            additionalProperties =
                                messageInAppFeedContentBlock.additionalProperties.toMutableMap()
                        }

                        fun content(content: String) = content(JsonField.of(content))

                        fun content(content: JsonField<String>) = apply { this.content = content }

                        fun name(name: String) = name(JsonField.of(name))

                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun rendered(rendered: String) = rendered(JsonField.of(rendered))

                        fun rendered(rendered: JsonField<String>) = apply {
                            this.rendered = rendered
                        }

                        fun type(type: Type) = type(JsonField.of(type))

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

                        fun build(): MessageInAppFeedContentBlock =
                            MessageInAppFeedContentBlock(
                                checkRequired("content", content),
                                checkRequired("name", name),
                                checkRequired("rendered", rendered),
                                checkRequired("type", type),
                                additionalProperties.toImmutable(),
                            )
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

                        return /* spotless:off */ other is MessageInAppFeedContentBlock && content == other.content && name == other.name && rendered == other.rendered && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(content, name, rendered, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "MessageInAppFeedContentBlock{content=$content, name=$name, rendered=$rendered, type=$type, additionalProperties=$additionalProperties}"
                }

                /** A set of buttons in a message in an app feed */
                @NoAutoDetect
                class MessageInAppFeedButtonSetBlock
                @JsonCreator
                private constructor(
                    @JsonProperty("buttons")
                    @ExcludeMissing
                    private val buttons: JsonField<List<Button>> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    private val name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    private val type: JsonField<Type> = JsonMissing.of(),
                    @JsonAnySetter
                    private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
                ) {

                    fun buttons(): List<Button> = buttons.getRequired("buttons")

                    fun name(): String = name.getRequired("name")

                    fun type(): Type = type.getRequired("type")

                    @JsonProperty("buttons")
                    @ExcludeMissing
                    fun _buttons(): JsonField<List<Button>> = buttons

                    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

                    @JsonAnyGetter
                    @ExcludeMissing
                    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                    private var validated: Boolean = false

                    fun validate(): MessageInAppFeedButtonSetBlock = apply {
                        if (validated) {
                            return@apply
                        }

                        buttons().forEach { it.validate() }
                        name()
                        type()
                        validated = true
                    }

                    fun toBuilder() = Builder().from(this)

                    companion object {

                        /**
                         * Returns a mutable builder for constructing an instance of
                         * [MessageInAppFeedButtonSetBlock].
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

                    /** A builder for [MessageInAppFeedButtonSetBlock]. */
                    class Builder internal constructor() {

                        private var buttons: JsonField<MutableList<Button>>? = null
                        private var name: JsonField<String>? = null
                        private var type: JsonField<Type>? = null
                        private var additionalProperties: MutableMap<String, JsonValue> =
                            mutableMapOf()

                        @JvmSynthetic
                        internal fun from(
                            messageInAppFeedButtonSetBlock: MessageInAppFeedButtonSetBlock
                        ) = apply {
                            buttons =
                                messageInAppFeedButtonSetBlock.buttons.map { it.toMutableList() }
                            name = messageInAppFeedButtonSetBlock.name
                            type = messageInAppFeedButtonSetBlock.type
                            additionalProperties =
                                messageInAppFeedButtonSetBlock.additionalProperties.toMutableMap()
                        }

                        fun buttons(buttons: List<Button>) = buttons(JsonField.of(buttons))

                        fun buttons(buttons: JsonField<List<Button>>) = apply {
                            this.buttons = buttons.map { it.toMutableList() }
                        }

                        fun addButton(button: Button) = apply {
                            buttons =
                                (buttons ?: JsonField.of(mutableListOf())).also {
                                    checkKnown("buttons", it).add(button)
                                }
                        }

                        fun name(name: String) = name(JsonField.of(name))

                        fun name(name: JsonField<String>) = apply { this.name = name }

                        fun type(type: Type) = type(JsonField.of(type))

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

                        fun build(): MessageInAppFeedButtonSetBlock =
                            MessageInAppFeedButtonSetBlock(
                                checkRequired("buttons", buttons).map { it.toImmutable() },
                                checkRequired("name", name),
                                checkRequired("type", type),
                                additionalProperties.toImmutable(),
                            )
                    }

                    /** A button in a set of buttons */
                    @NoAutoDetect
                    class Button
                    @JsonCreator
                    private constructor(
                        @JsonProperty("action")
                        @ExcludeMissing
                        private val action: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("label")
                        @ExcludeMissing
                        private val label: JsonField<String> = JsonMissing.of(),
                        @JsonProperty("name")
                        @ExcludeMissing
                        private val name: JsonField<String> = JsonMissing.of(),
                        @JsonAnySetter
                        private val additionalProperties: Map<String, JsonValue> =
                            immutableEmptyMap(),
                    ) {

                        fun action(): String = action.getRequired("action")

                        fun label(): String = label.getRequired("label")

                        fun name(): String = name.getRequired("name")

                        @JsonProperty("action")
                        @ExcludeMissing
                        fun _action(): JsonField<String> = action

                        @JsonProperty("label")
                        @ExcludeMissing
                        fun _label(): JsonField<String> = label

                        @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                        @JsonAnyGetter
                        @ExcludeMissing
                        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

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

                            fun action(action: JsonField<String>) = apply { this.action = action }

                            fun label(label: String) = label(JsonField.of(label))

                            fun label(label: JsonField<String>) = apply { this.label = label }

                            fun name(name: String) = name(JsonField.of(name))

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

                            fun build(): Button =
                                Button(
                                    checkRequired("action", action),
                                    checkRequired("label", label),
                                    checkRequired("name", name),
                                    additionalProperties.toImmutable(),
                                )
                        }

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

                        return /* spotless:off */ other is MessageInAppFeedButtonSetBlock && buttons == other.buttons && name == other.name && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
                    }

                    /* spotless:off */
                    private val hashCode: Int by lazy { Objects.hash(buttons, name, type, additionalProperties) }
                    /* spotless:on */

                    override fun hashCode(): Int = hashCode

                    override fun toString() =
                        "MessageInAppFeedButtonSetBlock{buttons=$buttons, name=$name, type=$type, additionalProperties=$additionalProperties}"
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

        return /* spotless:off */ other is MessageGetContentResponse && _typename == other._typename && data == other.data && insertedAt == other.insertedAt && messageId == other.messageId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(_typename, data, insertedAt, messageId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageGetContentResponse{_typename=$_typename, data=$data, insertedAt=$insertedAt, messageId=$messageId, additionalProperties=$additionalProperties}"
}
