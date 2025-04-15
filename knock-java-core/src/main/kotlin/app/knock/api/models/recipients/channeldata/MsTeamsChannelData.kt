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

/** Microsoft Teams channel data */
class MsTeamsChannelData
private constructor(
    private val connections: JsonField<List<Connection>>,
    private val msTeamsTenantId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("connections")
        @ExcludeMissing
        connections: JsonField<List<Connection>> = JsonMissing.of(),
        @JsonProperty("ms_teams_tenant_id")
        @ExcludeMissing
        msTeamsTenantId: JsonField<String> = JsonMissing.of(),
    ) : this(connections, msTeamsTenantId, mutableMapOf())

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun connections(): List<Connection> = connections.getRequired("connections")

    /**
     * The Microsoft Teams tenant ID
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun msTeamsTenantId(): Optional<String> = msTeamsTenantId.getOptional("ms_teams_tenant_id")

    /**
     * Returns the raw JSON value of [connections].
     *
     * Unlike [connections], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("connections")
    @ExcludeMissing
    fun _connections(): JsonField<List<Connection>> = connections

    /**
     * Returns the raw JSON value of [msTeamsTenantId].
     *
     * Unlike [msTeamsTenantId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("ms_teams_tenant_id")
    @ExcludeMissing
    fun _msTeamsTenantId(): JsonField<String> = msTeamsTenantId

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
         * Returns a mutable builder for constructing an instance of [MsTeamsChannelData].
         *
         * The following fields are required:
         * ```java
         * .connections()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MsTeamsChannelData]. */
    class Builder internal constructor() {

        private var connections: JsonField<MutableList<Connection>>? = null
        private var msTeamsTenantId: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(msTeamsChannelData: MsTeamsChannelData) = apply {
            connections = msTeamsChannelData.connections.map { it.toMutableList() }
            msTeamsTenantId = msTeamsChannelData.msTeamsTenantId
            additionalProperties = msTeamsChannelData.additionalProperties.toMutableMap()
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

        /** Alias for calling [addConnection] with `Connection.ofToken(token)`. */
        fun addConnection(token: Connection.TokenConnection) =
            addConnection(Connection.ofToken(token))

        /**
         * Alias for calling [addConnection] with `Connection.ofIncomingWebhook(incomingWebhook)`.
         */
        fun addConnection(incomingWebhook: Connection.IncomingWebhookConnection) =
            addConnection(Connection.ofIncomingWebhook(incomingWebhook))

        /** The Microsoft Teams tenant ID */
        fun msTeamsTenantId(msTeamsTenantId: String?) =
            msTeamsTenantId(JsonField.ofNullable(msTeamsTenantId))

        /** Alias for calling [Builder.msTeamsTenantId] with `msTeamsTenantId.orElse(null)`. */
        fun msTeamsTenantId(msTeamsTenantId: Optional<String>) =
            msTeamsTenantId(msTeamsTenantId.getOrNull())

        /**
         * Sets [Builder.msTeamsTenantId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.msTeamsTenantId] with a well-typed [String] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun msTeamsTenantId(msTeamsTenantId: JsonField<String>) = apply {
            this.msTeamsTenantId = msTeamsTenantId
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
         * Returns an immutable instance of [MsTeamsChannelData].
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
        fun build(): MsTeamsChannelData =
            MsTeamsChannelData(
                checkRequired("connections", connections).map { it.toImmutable() },
                msTeamsTenantId,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MsTeamsChannelData = apply {
        if (validated) {
            return@apply
        }

        connections().forEach { it.validate() }
        msTeamsTenantId()
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
            (if (msTeamsTenantId.asKnown().isPresent) 1 else 0)

    /** A Slack connection, which either includes a channel_id or a user_id */
    @JsonDeserialize(using = Connection.Deserializer::class)
    @JsonSerialize(using = Connection.Serializer::class)
    class Connection
    private constructor(
        private val token: TokenConnection? = null,
        private val incomingWebhook: IncomingWebhookConnection? = null,
        private val _json: JsonValue? = null,
    ) {

        /** A Slack connection, which either includes a channel_id or a user_id */
        fun token(): Optional<TokenConnection> = Optional.ofNullable(token)

        /** An incoming webhook Slack connection */
        fun incomingWebhook(): Optional<IncomingWebhookConnection> =
            Optional.ofNullable(incomingWebhook)

        fun isToken(): Boolean = token != null

        fun isIncomingWebhook(): Boolean = incomingWebhook != null

        /** A Slack connection, which either includes a channel_id or a user_id */
        fun asToken(): TokenConnection = token.getOrThrow("token")

        /** An incoming webhook Slack connection */
        fun asIncomingWebhook(): IncomingWebhookConnection =
            incomingWebhook.getOrThrow("incomingWebhook")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                token != null -> visitor.visitToken(token)
                incomingWebhook != null -> visitor.visitIncomingWebhook(incomingWebhook)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Connection = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitToken(token: TokenConnection) {
                        token.validate()
                    }

                    override fun visitIncomingWebhook(incomingWebhook: IncomingWebhookConnection) {
                        incomingWebhook.validate()
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
                    override fun visitToken(token: TokenConnection) = token.validity()

                    override fun visitIncomingWebhook(incomingWebhook: IncomingWebhookConnection) =
                        incomingWebhook.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Connection && token == other.token && incomingWebhook == other.incomingWebhook /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(token, incomingWebhook) /* spotless:on */

        override fun toString(): String =
            when {
                token != null -> "Connection{token=$token}"
                incomingWebhook != null -> "Connection{incomingWebhook=$incomingWebhook}"
                _json != null -> "Connection{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Connection")
            }

        companion object {

            /** A Slack connection, which either includes a channel_id or a user_id */
            @JvmStatic fun ofToken(token: TokenConnection) = Connection(token = token)

            /** An incoming webhook Slack connection */
            @JvmStatic
            fun ofIncomingWebhook(incomingWebhook: IncomingWebhookConnection) =
                Connection(incomingWebhook = incomingWebhook)
        }

        /**
         * An interface that defines how to map each variant of [Connection] to a value of type [T].
         */
        interface Visitor<out T> {

            /** A Slack connection, which either includes a channel_id or a user_id */
            fun visitToken(token: TokenConnection): T

            /** An incoming webhook Slack connection */
            fun visitIncomingWebhook(incomingWebhook: IncomingWebhookConnection): T

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
                            tryDeserialize(node, jacksonTypeRef<TokenConnection>())?.let {
                                Connection(token = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<IncomingWebhookConnection>())?.let {
                                Connection(incomingWebhook = it, _json = json)
                            },
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
                    value.token != null -> generator.writeObject(value.token)
                    value.incomingWebhook != null -> generator.writeObject(value.incomingWebhook)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Connection")
                }
            }
        }

        /** A Slack connection, which either includes a channel_id or a user_id */
        class TokenConnection
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

                /** Returns a mutable builder for constructing an instance of [TokenConnection]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [TokenConnection]. */
            class Builder internal constructor() {

                private var accessToken: JsonField<String> = JsonMissing.of()
                private var channelId: JsonField<String> = JsonMissing.of()
                private var userId: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(tokenConnection: TokenConnection) = apply {
                    accessToken = tokenConnection.accessToken
                    channelId = tokenConnection.channelId
                    userId = tokenConnection.userId
                    additionalProperties = tokenConnection.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [TokenConnection].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): TokenConnection =
                    TokenConnection(
                        accessToken,
                        channelId,
                        userId,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): TokenConnection = apply {
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

                return /* spotless:off */ other is TokenConnection && accessToken == other.accessToken && channelId == other.channelId && userId == other.userId && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(accessToken, channelId, userId, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "TokenConnection{accessToken=$accessToken, channelId=$channelId, userId=$userId, additionalProperties=$additionalProperties}"
        }

        /** An incoming webhook Slack connection */
        class IncomingWebhookConnection
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
                 * [IncomingWebhookConnection].
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [IncomingWebhookConnection]. */
            class Builder internal constructor() {

                private var url: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(incomingWebhookConnection: IncomingWebhookConnection) = apply {
                    url = incomingWebhookConnection.url
                    additionalProperties =
                        incomingWebhookConnection.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [IncomingWebhookConnection].
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
                fun build(): IncomingWebhookConnection =
                    IncomingWebhookConnection(
                        checkRequired("url", url),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): IncomingWebhookConnection = apply {
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

                return /* spotless:off */ other is IncomingWebhookConnection && url == other.url && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(url, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "IncomingWebhookConnection{url=$url, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MsTeamsChannelData && connections == other.connections && msTeamsTenantId == other.msTeamsTenantId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(connections, msTeamsTenantId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MsTeamsChannelData{connections=$connections, msTeamsTenantId=$msTeamsTenantId, additionalProperties=$additionalProperties}"
}
