// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Slack channel data */
class SlackChannelData
private constructor(
    private val connections: JsonField<List<Connection>>,
    private val token: JsonField<Token>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("connections")
        @ExcludeMissing
        connections: JsonField<List<Connection>> = JsonMissing.of(),
        @JsonProperty("token") @ExcludeMissing token: JsonField<Token> = JsonMissing.of(),
    ) : this(connections, token, mutableMapOf())

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun connections(): List<Connection> = connections.getRequired("connections")

    /**
     * A token that's used to store the access token for a Slack workspace.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun token(): Optional<Token> = token.getOptional("token")

    /**
     * Returns the raw JSON value of [connections].
     *
     * Unlike [connections], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("connections")
    @ExcludeMissing
    fun _connections(): JsonField<List<Connection>> = connections

    /**
     * Returns the raw JSON value of [token].
     *
     * Unlike [token], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("token") @ExcludeMissing fun _token(): JsonField<Token> = token

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

        /**
         * Sets [Builder.connections] to an arbitrary JSON value.
         *
         * You should usually call [Builder.connections] with a well-typed `List<Connection>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun connections(connections: JsonField<List<Connection>>) = apply {
            this.connections = connections.map { it.toMutableList() }
        }

        /**
         * Adds a single [Connection] to [connections].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addConnection(connection: Connection) = apply {
            connections =
                (connections ?: JsonField.of(mutableListOf())).also {
                    checkKnown("connections", it).add(connection)
                }
        }

        /** Alias for calling [addConnection] with `Connection.ofSlackToken(slackToken)`. */
        fun addConnection(slackToken: Connection.SlackTokenConnection) =
            addConnection(Connection.ofSlackToken(slackToken))

        /**
         * Alias for calling [addConnection] with
         * `Connection.ofSlackIncomingWebhook(slackIncomingWebhook)`.
         */
        fun addConnection(slackIncomingWebhook: Connection.SlackIncomingWebhookConnection) =
            addConnection(Connection.ofSlackIncomingWebhook(slackIncomingWebhook))

        /** A token that's used to store the access token for a Slack workspace. */
        fun token(token: Token?) = token(JsonField.ofNullable(token))

        /** Alias for calling [Builder.token] with `token.orElse(null)`. */
        fun token(token: Optional<Token>) = token(token.getOrNull())

        /**
         * Sets [Builder.token] to an arbitrary JSON value.
         *
         * You should usually call [Builder.token] with a well-typed [Token] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
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

        /**
         * Returns an immutable instance of [SlackChannelData].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .connections()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): SlackChannelData =
            SlackChannelData(
                checkRequired("connections", connections).map { it.toImmutable() },
                token,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): SlackChannelData = apply {
        if (validated) {
            return@apply
        }

        connections().forEach { it.validate() }
        token().ifPresent { it.validate() }
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
        (connections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (token.asKnown().getOrNull()?.validity() ?: 0)

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

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                slackToken != null -> visitor.visitSlackToken(slackToken)
                slackIncomingWebhook != null ->
                    visitor.visitSlackIncomingWebhook(slackIncomingWebhook)
                else -> visitor.unknown(_json)
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
                    override fun visitSlackToken(slackToken: SlackTokenConnection) =
                        slackToken.validity()

                    override fun visitSlackIncomingWebhook(
                        slackIncomingWebhook: SlackIncomingWebhookConnection
                    ) = slackIncomingWebhook.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

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

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<SlackTokenConnection>())?.let {
                                Connection(slackToken = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<SlackIncomingWebhookConnection>())
                                ?.let { Connection(slackIncomingWebhook = it, _json = json) },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> Connection(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
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
        class SlackTokenConnection
        private constructor(
            private val accessToken: JsonField<String>,
            private val channelId: JsonField<String>,
            private val userId: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("access_token")
                @ExcludeMissing
                accessToken: JsonField<String> = JsonMissing.of(),
                @JsonProperty("channel_id")
                @ExcludeMissing
                channelId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("user_id")
                @ExcludeMissing
                userId: JsonField<String> = JsonMissing.of(),
            ) : this(accessToken, channelId, userId, mutableMapOf())

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun accessToken(): Optional<String> = accessToken.getOptional("access_token")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun channelId(): Optional<String> = channelId.getOptional("channel_id")

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun userId(): Optional<String> = userId.getOptional("user_id")

            /**
             * Returns the raw JSON value of [accessToken].
             *
             * Unlike [accessToken], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("access_token")
            @ExcludeMissing
            fun _accessToken(): JsonField<String> = accessToken

            /**
             * Returns the raw JSON value of [channelId].
             *
             * Unlike [channelId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("channel_id")
            @ExcludeMissing
            fun _channelId(): JsonField<String> = channelId

            /**
             * Returns the raw JSON value of [userId].
             *
             * Unlike [userId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("user_id") @ExcludeMissing fun _userId(): JsonField<String> = userId

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

                /** Alias for calling [Builder.accessToken] with `accessToken.orElse(null)`. */
                fun accessToken(accessToken: Optional<String>) =
                    accessToken(accessToken.getOrNull())

                /**
                 * Sets [Builder.accessToken] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.accessToken] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun accessToken(accessToken: JsonField<String>) = apply {
                    this.accessToken = accessToken
                }

                fun channelId(channelId: String?) = channelId(JsonField.ofNullable(channelId))

                /** Alias for calling [Builder.channelId] with `channelId.orElse(null)`. */
                fun channelId(channelId: Optional<String>) = channelId(channelId.getOrNull())

                /**
                 * Sets [Builder.channelId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.channelId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun channelId(channelId: JsonField<String>) = apply { this.channelId = channelId }

                fun userId(userId: String?) = userId(JsonField.ofNullable(userId))

                /** Alias for calling [Builder.userId] with `userId.orElse(null)`. */
                fun userId(userId: Optional<String>) = userId(userId.getOrNull())

                /**
                 * Sets [Builder.userId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.userId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
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

                /**
                 * Returns an immutable instance of [SlackTokenConnection].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): SlackTokenConnection =
                    SlackTokenConnection(
                        accessToken,
                        channelId,
                        userId,
                        additionalProperties.toMutableMap(),
                    )
            }

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
                (if (accessToken.asKnown().isPresent) 1 else 0) +
                    (if (channelId.asKnown().isPresent) 1 else 0) +
                    (if (userId.asKnown().isPresent) 1 else 0)

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
        class SlackIncomingWebhookConnection
        private constructor(
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of()
            ) : this(url, mutableMapOf())

            /**
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun url(): String = url.getRequired("url")

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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

                /**
                 * Sets [Builder.url] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.url] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
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

                /**
                 * Returns an immutable instance of [SlackIncomingWebhookConnection].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): SlackIncomingWebhookConnection =
                    SlackIncomingWebhookConnection(
                        checkRequired("url", url),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): SlackIncomingWebhookConnection = apply {
                if (validated) {
                    return@apply
                }

                url()
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
            @JvmSynthetic internal fun validity(): Int = (if (url.asKnown().isPresent) 1 else 0)

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
    class Token
    private constructor(
        private val accessToken: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("access_token")
            @ExcludeMissing
            accessToken: JsonField<String> = JsonMissing.of()
        ) : this(accessToken, mutableMapOf())

        /**
         * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun accessToken(): Optional<String> = accessToken.getOptional("access_token")

        /**
         * Returns the raw JSON value of [accessToken].
         *
         * Unlike [accessToken], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("access_token")
        @ExcludeMissing
        fun _accessToken(): JsonField<String> = accessToken

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

            /** Alias for calling [Builder.accessToken] with `accessToken.orElse(null)`. */
            fun accessToken(accessToken: Optional<String>) = accessToken(accessToken.getOrNull())

            /**
             * Sets [Builder.accessToken] to an arbitrary JSON value.
             *
             * You should usually call [Builder.accessToken] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
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

            /**
             * Returns an immutable instance of [Token].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .accessToken()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Token =
                Token(
                    checkRequired("accessToken", accessToken),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Token = apply {
            if (validated) {
                return@apply
            }

            accessToken()
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
        @JvmSynthetic internal fun validity(): Int = (if (accessToken.asKnown().isPresent) 1 else 0)

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
