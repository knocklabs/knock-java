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

/** Discord channel data */
class DiscordChannelData
private constructor(
    private val connections: JsonField<List<Connection>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("connections")
        @ExcludeMissing
        connections: JsonField<List<Connection>> = JsonMissing.of()
    ) : this(connections, mutableMapOf())

    /**
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun connections(): List<Connection> = connections.getRequired("connections")

    /**
     * Returns the raw JSON value of [connections].
     *
     * Unlike [connections], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("connections")
    @ExcludeMissing
    fun _connections(): JsonField<List<Connection>> = connections

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
         * Returns a mutable builder for constructing an instance of [DiscordChannelData].
         *
         * The following fields are required:
         * ```java
         * .connections()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DiscordChannelData]. */
    class Builder internal constructor() {

        private var connections: JsonField<MutableList<Connection>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(discordChannelData: DiscordChannelData) = apply {
            connections = discordChannelData.connections.map { it.toMutableList() }
            additionalProperties = discordChannelData.additionalProperties.toMutableMap()
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

        /** Alias for calling [addConnection] with `Connection.ofChannel(channel)`. */
        fun addConnection(channel: Connection.ChannelConnection) =
            addConnection(Connection.ofChannel(channel))

        /**
         * Alias for calling [addConnection] with `Connection.ofIncomingWebhook(incomingWebhook)`.
         */
        fun addConnection(incomingWebhook: Connection.IncomingWebhookConnection) =
            addConnection(Connection.ofIncomingWebhook(incomingWebhook))

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
         * Returns an immutable instance of [DiscordChannelData].
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
        fun build(): DiscordChannelData =
            DiscordChannelData(
                checkRequired("connections", connections).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): DiscordChannelData = apply {
        if (validated) {
            return@apply
        }

        connections().forEach { it.validate() }
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
        (connections.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** Discord channel connection */
    @JsonDeserialize(using = Connection.Deserializer::class)
    @JsonSerialize(using = Connection.Serializer::class)
    class Connection
    private constructor(
        private val channel: ChannelConnection? = null,
        private val incomingWebhook: IncomingWebhookConnection? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Discord channel connection */
        fun channel(): Optional<ChannelConnection> = Optional.ofNullable(channel)

        /** An incoming webhook Slack connection */
        fun incomingWebhook(): Optional<IncomingWebhookConnection> =
            Optional.ofNullable(incomingWebhook)

        fun isChannel(): Boolean = channel != null

        fun isIncomingWebhook(): Boolean = incomingWebhook != null

        /** Discord channel connection */
        fun asChannel(): ChannelConnection = channel.getOrThrow("channel")

        /** An incoming webhook Slack connection */
        fun asIncomingWebhook(): IncomingWebhookConnection =
            incomingWebhook.getOrThrow("incomingWebhook")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                channel != null -> visitor.visitChannel(channel)
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
                    override fun visitChannel(channel: ChannelConnection) {
                        channel.validate()
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
                    override fun visitChannel(channel: ChannelConnection) = channel.validity()

                    override fun visitIncomingWebhook(incomingWebhook: IncomingWebhookConnection) =
                        incomingWebhook.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Connection && channel == other.channel && incomingWebhook == other.incomingWebhook /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(channel, incomingWebhook) /* spotless:on */

        override fun toString(): String =
            when {
                channel != null -> "Connection{channel=$channel}"
                incomingWebhook != null -> "Connection{incomingWebhook=$incomingWebhook}"
                _json != null -> "Connection{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Connection")
            }

        companion object {

            /** Discord channel connection */
            @JvmStatic fun ofChannel(channel: ChannelConnection) = Connection(channel = channel)

            /** An incoming webhook Slack connection */
            @JvmStatic
            fun ofIncomingWebhook(incomingWebhook: IncomingWebhookConnection) =
                Connection(incomingWebhook = incomingWebhook)
        }

        /**
         * An interface that defines how to map each variant of [Connection] to a value of type [T].
         */
        interface Visitor<out T> {

            /** Discord channel connection */
            fun visitChannel(channel: ChannelConnection): T

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
                            tryDeserialize(node, jacksonTypeRef<ChannelConnection>())?.let {
                                Connection(channel = it, _json = json)
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
                    value.channel != null -> generator.writeObject(value.channel)
                    value.incomingWebhook != null -> generator.writeObject(value.incomingWebhook)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Connection")
                }
            }
        }

        /** Discord channel connection */
        class ChannelConnection
        private constructor(
            private val channelId: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("channel_id")
                @ExcludeMissing
                channelId: JsonField<String> = JsonMissing.of()
            ) : this(channelId, mutableMapOf())

            /**
             * The Discord channel ID
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun channelId(): String = channelId.getRequired("channel_id")

            /**
             * Returns the raw JSON value of [channelId].
             *
             * Unlike [channelId], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("channel_id")
            @ExcludeMissing
            fun _channelId(): JsonField<String> = channelId

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
                 * Returns a mutable builder for constructing an instance of [ChannelConnection].
                 *
                 * The following fields are required:
                 * ```java
                 * .channelId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChannelConnection]. */
            class Builder internal constructor() {

                private var channelId: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(channelConnection: ChannelConnection) = apply {
                    channelId = channelConnection.channelId
                    additionalProperties = channelConnection.additionalProperties.toMutableMap()
                }

                /** The Discord channel ID */
                fun channelId(channelId: String) = channelId(JsonField.of(channelId))

                /**
                 * Sets [Builder.channelId] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.channelId] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun channelId(channelId: JsonField<String>) = apply { this.channelId = channelId }

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
                 * Returns an immutable instance of [ChannelConnection].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .channelId()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): ChannelConnection =
                    ChannelConnection(
                        checkRequired("channelId", channelId),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ChannelConnection = apply {
                if (validated) {
                    return@apply
                }

                channelId()
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
            internal fun validity(): Int = (if (channelId.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ChannelConnection && channelId == other.channelId && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(channelId, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChannelConnection{channelId=$channelId, additionalProperties=$additionalProperties}"
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

        return /* spotless:off */ other is DiscordChannelData && connections == other.connections && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(connections, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DiscordChannelData{connections=$connections, additionalProperties=$additionalProperties}"
}
