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
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Slack channel data */
@NoAutoDetect
class SlackChannelData
@JsonCreator
private constructor(
    @JsonProperty("connections")
    @ExcludeMissing
    private val connections: JsonField<List<Connection>> = JsonMissing.of(),
    @JsonProperty("token") @ExcludeMissing private val token: JsonField<Token> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun connections(): List<Connection> = connections.getRequired("connections")

    /** A token that's used to store the access token for a Slack workspace. */
    fun token(): Optional<Token> = Optional.ofNullable(token.getNullable("token"))

    @JsonProperty("connections")
    @ExcludeMissing
    fun _connections(): JsonField<List<Connection>> = connections

    /** A token that's used to store the access token for a Slack workspace. */
    @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<Token> = token

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): SlackChannelData = apply {
        if (validated) {
            return@apply
        }

        connections().forEach { it.validate() }
        token().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SlackChannelData].
         *
         * The following fields are required:
         * ```java
         * .connections()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [SlackChannelData]. */
    class Builder internal constructor() {

        private var connections: JsonField<MutableList<Connection>>? = null
        private var token: JsonField<Token> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(slackChannelData: SlackChannelData) = apply {
            connections = slackChannelData.connections.map { it.toMutableList() }
            token = slackChannelData.token
            additionalProperties = slackChannelData.additionalProperties.toMutableMap()
        }

        fun connections(connections: List<Connection>) = connections(JsonField.of(connections))

        fun connections(connections: JsonField<List<Connection>>) = apply {
            this.connections = connections.map { it.toMutableList() }
        }

        fun addConnection(connection: Connection) = apply {
            connections =
                (connections ?: JsonField.of(mutableListOf())).also {
                    checkKnown("connections", it).add(connection)
                }
        }

        /** A Slack connection, which either includes a channel_id or a user_id */
        fun addConnection(slackToken: Connection.SlackTokenConnection) =
            addConnection(Connection.ofSlackToken(slackToken))

        /** An incoming webhook Slack connection */
        fun addConnection(slackIncomingWebhook: Connection.SlackIncomingWebhookConnection) =
            addConnection(Connection.ofSlackIncomingWebhook(slackIncomingWebhook))

        /** A token that's used to store the access token for a Slack workspace. */
        fun token(token: Token?) = token(JsonField.ofNullable(token))

        /** A token that's used to store the access token for a Slack workspace. */
        fun token(token: Optional<Token>) = token(token.getOrNull())

        /** A token that's used to store the access token for a Slack workspace. */
        fun token(token: JsonField<Token>) = apply { this.token = token }

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

        fun build(): SlackChannelData =
            SlackChannelData(
                checkRequired("connections", connections).map { it.toImmutable() },
                token,
                additionalProperties.toImmutable(),
            )
    }

    /** A Slack connection, which either includes a channel_id or a user_id */
    @JsonDeserialize(using = Connection.Deserializer::class)
    @JsonSerialize(using = Connection.Serializer::class)
    class Connection
    private constructor(
        private val slackToken: SlackTokenConnection? = null,
        private val slackIncomingWebhook: SlackIncomingWebhookConnection? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A Slack connection, which either includes a channel_id or a user_id */
        fun slackToken(): Optional<SlackTokenConnection> = Optional.ofNullable(slackToken)

        /** An incoming webhook Slack connection */
        fun slackIncomingWebhook(): Optional<SlackIncomingWebhookConnection> =
            Optional.ofNullable(slackIncomingWebhook)

        fun isSlackToken(): Boolean = slackToken != null

        fun isSlackIncomingWebhook(): Boolean = slackIncomingWebhook != null

        /** A Slack connection, which either includes a channel_id or a user_id */
        fun asSlackToken(): SlackTokenConnection = slackToken.getOrThrow("slackToken")

        /** An incoming webhook Slack connection */
        fun asSlackIncomingWebhook(): SlackIncomingWebhookConnection =
            slackIncomingWebhook.getOrThrow("slackIncomingWebhook")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                slackToken != null -> visitor.visitSlackToken(slackToken)
                slackIncomingWebhook != null ->
                    visitor.visitSlackIncomingWebhook(slackIncomingWebhook)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Connection = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitSlackToken(slackToken: SlackTokenConnection) {
                        slackToken.validate()
                    }

                    override fun visitSlackIncomingWebhook(
                        slackIncomingWebhook: SlackIncomingWebhookConnection
                    ) {
                        slackIncomingWebhook.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Connection && slackToken == other.slackToken && slackIncomingWebhook == other.slackIncomingWebhook /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(slackToken, slackIncomingWebhook) /* spotless:on */

        override fun toString(): String =
            when {
                slackToken != null -> "Connection{slackToken=$slackToken}"
                slackIncomingWebhook != null ->
                    "Connection{slackIncomingWebhook=$slackIncomingWebhook}"
                _json != null -> "Connection{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Connection")
            }

        companion object {

            /** A Slack connection, which either includes a channel_id or a user_id */
            @JvmStatic
            fun ofSlackToken(slackToken: SlackTokenConnection) = Connection(slackToken = slackToken)

            /** An incoming webhook Slack connection */
            @JvmStatic
            fun ofSlackIncomingWebhook(slackIncomingWebhook: SlackIncomingWebhookConnection) =
                Connection(slackIncomingWebhook = slackIncomingWebhook)
        }

        /**
         * An interface that defines how to map each variant of [Connection] to a value of type [T].
         */
        interface Visitor<out T> {

            /** A Slack connection, which either includes a channel_id or a user_id */
            fun visitSlackToken(slackToken: SlackTokenConnection): T

            /** An incoming webhook Slack connection */
            fun visitSlackIncomingWebhook(slackIncomingWebhook: SlackIncomingWebhookConnection): T

            /**
             * Maps an unknown variant of [Connection] to a value of type [T].
             *
             * An instance of [Connection] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Connection: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Connection>(Connection::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Connection {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<SlackTokenConnection>()) { it.validate() }
                    ?.let {
                        return Connection(slackToken = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<SlackIncomingWebhookConnection>()) {
                        it.validate()
                    }
                    ?.let {
                        return Connection(slackIncomingWebhook = it, _json = json)
                    }

                return Connection(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Connection>(Connection::class) {

            override fun serialize(
                value: Connection,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.slackToken != null -> generator.writeObject(value.slackToken)
                    value.slackIncomingWebhook != null ->
                        generator.writeObject(value.slackIncomingWebhook)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Connection")
                }
            }
        }

        /** A Slack connection, which either includes a channel_id or a user_id */
        @NoAutoDetect
        class SlackTokenConnection
        @JsonCreator
        private constructor(
            @JsonProperty("access_token")
            @ExcludeMissing
            private val accessToken: JsonField<String> = JsonMissing.of(),
            @JsonProperty("channel_id")
            @ExcludeMissing
            private val channelId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("user_id")
            @ExcludeMissing
            private val userId: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun accessToken(): Optional<String> =
                Optional.ofNullable(accessToken.getNullable("access_token"))

            fun channelId(): Optional<String> =
                Optional.ofNullable(channelId.getNullable("channel_id"))

            fun userId(): Optional<String> = Optional.ofNullable(userId.getNullable("user_id"))

            @JsonProperty("access_token")
            @ExcludeMissing
            fun _accessToken(): JsonField<String> = accessToken

            @JsonProperty("channel_id")
            @ExcludeMissing
            fun _channelId(): JsonField<String> = channelId

            @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): SlackTokenConnection = apply {
                if (validated) {
                    return@apply
                }

                accessToken()
                channelId()
                userId()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [SlackTokenConnection].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SlackTokenConnection]. */
            class Builder internal constructor() {

                private var accessToken: JsonField<String> = JsonMissing.of()
                private var channelId: JsonField<String> = JsonMissing.of()
                private var userId: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(slackTokenConnection: SlackTokenConnection) = apply {
                    accessToken = slackTokenConnection.accessToken
                    channelId = slackTokenConnection.channelId
                    userId = slackTokenConnection.userId
                    additionalProperties = slackTokenConnection.additionalProperties.toMutableMap()
                }

                fun accessToken(accessToken: String?) =
                    accessToken(JsonField.ofNullable(accessToken))

                fun accessToken(accessToken: Optional<String>) =
                    accessToken(accessToken.getOrNull())

                fun accessToken(accessToken: JsonField<String>) = apply {
                    this.accessToken = accessToken
                }

                fun channelId(channelId: String?) = channelId(JsonField.ofNullable(channelId))

                fun channelId(channelId: Optional<String>) = channelId(channelId.getOrNull())

                fun channelId(channelId: JsonField<String>) = apply { this.channelId = channelId }

                fun userId(userId: String?) = userId(JsonField.ofNullable(userId))

                fun userId(userId: Optional<String>) = userId(userId.getOrNull())

                fun userId(userId: JsonField<String>) = apply { this.userId = userId }

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

                fun build(): SlackTokenConnection =
                    SlackTokenConnection(
                        accessToken,
                        channelId,
                        userId,
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is SlackTokenConnection && accessToken == other.accessToken && channelId == other.channelId && userId == other.userId && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(accessToken, channelId, userId, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SlackTokenConnection{accessToken=$accessToken, channelId=$channelId, userId=$userId, additionalProperties=$additionalProperties}"
        }

        /** An incoming webhook Slack connection */
        @NoAutoDetect
        class SlackIncomingWebhookConnection
        @JsonCreator
        private constructor(
            @JsonProperty("url")
            @ExcludeMissing
            private val url: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun url(): String = url.getRequired("url")

            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): SlackIncomingWebhookConnection = apply {
                if (validated) {
                    return@apply
                }

                url()
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of
                 * [SlackIncomingWebhookConnection].
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SlackIncomingWebhookConnection]. */
            class Builder internal constructor() {

                private var url: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(slackIncomingWebhookConnection: SlackIncomingWebhookConnection) =
                    apply {
                        url = slackIncomingWebhookConnection.url
                        additionalProperties =
                            slackIncomingWebhookConnection.additionalProperties.toMutableMap()
                    }

                fun url(url: String) = url(JsonField.of(url))

                fun url(url: JsonField<String>) = apply { this.url = url }

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

                fun build(): SlackIncomingWebhookConnection =
                    SlackIncomingWebhookConnection(
                        checkRequired("url", url),
                        additionalProperties.toImmutable(),
                    )
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is SlackIncomingWebhookConnection && url == other.url && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(url, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "SlackIncomingWebhookConnection{url=$url, additionalProperties=$additionalProperties}"
        }
    }

    /** A token that's used to store the access token for a Slack workspace. */
    @NoAutoDetect
    class Token
    @JsonCreator
    private constructor(
        @JsonProperty("access_token")
        @ExcludeMissing
        private val accessToken: JsonField<String> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun accessToken(): Optional<String> =
            Optional.ofNullable(accessToken.getNullable("access_token"))

        @JsonProperty("access_token")
        @ExcludeMissing
        fun _accessToken(): JsonField<String> = accessToken

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Token = apply {
            if (validated) {
                return@apply
            }

            accessToken()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Token].
             *
             * The following fields are required:
             * ```java
             * .accessToken()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Token]. */
        class Builder internal constructor() {

            private var accessToken: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(token: Token) = apply {
                accessToken = token.accessToken
                additionalProperties = token.additionalProperties.toMutableMap()
            }

            fun accessToken(accessToken: String?) = accessToken(JsonField.ofNullable(accessToken))

            fun accessToken(accessToken: Optional<String>) = accessToken(accessToken.getOrNull())

            fun accessToken(accessToken: JsonField<String>) = apply {
                this.accessToken = accessToken
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

            fun build(): Token =
                Token(checkRequired("accessToken", accessToken), additionalProperties.toImmutable())
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Token && accessToken == other.accessToken && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(accessToken, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Token{accessToken=$accessToken, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is SlackChannelData && connections == other.connections && token == other.token && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(connections, token, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "SlackChannelData{connections=$connections, token=$token, additionalProperties=$additionalProperties}"
}
