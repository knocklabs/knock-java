// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
import app.knock.api.core.immutableEmptyMap
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
import java.util.Objects
import java.util.Optional

/** Discord channel data */
@NoAutoDetect
class DiscordChannelData @JsonCreator private constructor(
    @JsonProperty("connections") @ExcludeMissing private val connections: JsonField<List<Connection>> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

) {

    fun connections(): List<Connection> = connections.getRequired("connections")

    @JsonProperty("connections")
    @ExcludeMissing
    fun _connections(): JsonField<List<Connection>> = connections

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): DiscordChannelData =
        apply {
            if (validated) {
              return@apply
            }

            connections().forEach { it.validate() }
            validated = true
        }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [DiscordChannelData].
         *
         * The following fields are required:
         *
         * ```java
         * .connections()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [DiscordChannelData]. */
    class Builder internal constructor() {

        private var connections: JsonField<MutableList<Connection>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(discordChannelData: DiscordChannelData) =
            apply {
                connections = discordChannelData.connections.map { it.toMutableList() }
                additionalProperties = discordChannelData.additionalProperties.toMutableMap()
            }

        fun connections(connections: List<Connection>) = connections(JsonField.of(connections))

        fun connections(connections: JsonField<List<Connection>>) =
            apply {
                this.connections = connections.map { it.toMutableList() }
            }

        fun addConnection(connection: Connection) =
            apply {
                connections = (connections ?: JsonField.of(mutableListOf())).also {
                    checkKnown("connections", it).add(connection)
                }
            }

        /** Discord channel connection */
        fun addConnection(discordChannel: Connection.DiscordChannelConnection) = addConnection(Connection.ofDiscordChannel(discordChannel))

        /** Discord incoming webhook connection */
        fun addConnection(discordIncomingWebhook: Connection.DiscordIncomingWebhookConnection) = addConnection(Connection.ofDiscordIncomingWebhook(discordIncomingWebhook))

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
            apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

        fun putAdditionalProperty(key: String, value: JsonValue) =
            apply {
                additionalProperties.put(key, value)
            }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
            apply {
                this.additionalProperties.putAll(additionalProperties)
            }

        fun removeAdditionalProperty(key: String) =
            apply {
                additionalProperties.remove(key)
            }

        fun removeAllAdditionalProperties(keys: Set<String>) =
            apply {
                keys.forEach(::removeAdditionalProperty)
            }

        fun build(): DiscordChannelData =
            DiscordChannelData(
              checkRequired(
                "connections", connections
              ).map { it.toImmutable() }, additionalProperties.toImmutable()
            )
    }

    /** Discord channel connection */
    @JsonDeserialize(using = Connection.Deserializer::class)
    @JsonSerialize(using = Connection.Serializer::class)
    class Connection private constructor(
        private val discordChannel: DiscordChannelConnection? = null,
        private val discordIncomingWebhook: DiscordIncomingWebhookConnection? = null,
        private val _json: JsonValue? = null,

    ) {

        /** Discord channel connection */
        fun discordChannel(): Optional<DiscordChannelConnection> = Optional.ofNullable(discordChannel)

        /** Discord incoming webhook connection */
        fun discordIncomingWebhook(): Optional<DiscordIncomingWebhookConnection> = Optional.ofNullable(discordIncomingWebhook)

        fun isDiscordChannel(): Boolean = discordChannel != null

        fun isDiscordIncomingWebhook(): Boolean = discordIncomingWebhook != null

        /** Discord channel connection */
        fun asDiscordChannel(): DiscordChannelConnection = discordChannel.getOrThrow("discordChannel")

        /** Discord incoming webhook connection */
        fun asDiscordIncomingWebhook(): DiscordIncomingWebhookConnection = discordIncomingWebhook.getOrThrow("discordIncomingWebhook")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
          return when {
              discordChannel != null -> visitor.visitDiscordChannel(discordChannel)
              discordIncomingWebhook != null -> visitor.visitDiscordIncomingWebhook(discordIncomingWebhook)
              else -> visitor.unknown(_json)
          }
        }

        private var validated: Boolean = false

        fun validate(): Connection =
            apply {
                if (validated) {
                  return@apply
                }

                accept(object : Visitor<Unit> {
                    override fun visitDiscordChannel(discordChannel: DiscordChannelConnection) {
                      discordChannel.validate()
                    }

                    override fun visitDiscordIncomingWebhook(discordIncomingWebhook: DiscordIncomingWebhookConnection) {
                      discordIncomingWebhook.validate()
                    }
                })
                validated = true
            }

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return /* spotless:off */ other is Connection && discordChannel == other.discordChannel && discordIncomingWebhook == other.discordIncomingWebhook /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(discordChannel, discordIncomingWebhook) /* spotless:on */

        override fun toString(): String =
            when {
                discordChannel != null -> "Connection{discordChannel=$discordChannel}"
                discordIncomingWebhook != null -> "Connection{discordIncomingWebhook=$discordIncomingWebhook}"
                _json != null -> "Connection{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Connection")
            }

        companion object {

            /** Discord channel connection */
            @JvmStatic
            fun ofDiscordChannel(discordChannel: DiscordChannelConnection) = Connection(discordChannel = discordChannel)

            /** Discord incoming webhook connection */
            @JvmStatic
            fun ofDiscordIncomingWebhook(discordIncomingWebhook: DiscordIncomingWebhookConnection) = Connection(discordIncomingWebhook = discordIncomingWebhook)
        }

        /**
         * An interface that defines how to map each variant of [Connection] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            /** Discord channel connection */
            fun visitDiscordChannel(discordChannel: DiscordChannelConnection): T

            /** Discord incoming webhook connection */
            fun visitDiscordIncomingWebhook(discordIncomingWebhook: DiscordIncomingWebhookConnection): T

            /**
             * Maps an unknown variant of [Connection] to a value of type [T].
             *
             * An instance of [Connection] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the
             * SDK is on an older version than the API, then the API may respond with new
             * variants that the SDK is unaware of.
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

              tryDeserialize(node, jacksonTypeRef<DiscordChannelConnection>()){ it.validate() }?.let {
                  return Connection(discordChannel = it, _json = json)
              }
              tryDeserialize(node, jacksonTypeRef<DiscordIncomingWebhookConnection>()){ it.validate() }?.let {
                  return Connection(discordIncomingWebhook = it, _json = json)
              }

              return Connection(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Connection>(Connection::class) {

            override fun serialize(value: Connection, generator: JsonGenerator, provider: SerializerProvider) {
              when {
                  value.discordChannel != null -> generator.writeObject(value.discordChannel)
                  value.discordIncomingWebhook != null -> generator.writeObject(value.discordIncomingWebhook)
                  value._json != null -> generator.writeObject(value._json)
                  else -> throw IllegalStateException("Invalid Connection")
              }
            }
        }

        /** Discord channel connection */
        @NoAutoDetect
        class DiscordChannelConnection @JsonCreator private constructor(
            @JsonProperty("channel_id") @ExcludeMissing private val channelId: JsonField<String> = JsonMissing.of(),
            @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

        ) {

            /** The Discord channel ID */
            fun channelId(): String = channelId.getRequired("channel_id")

            /** The Discord channel ID */
            @JsonProperty("channel_id")
            @ExcludeMissing
            fun _channelId(): JsonField<String> = channelId

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): DiscordChannelConnection =
                apply {
                    if (validated) {
                      return@apply
                    }

                    channelId()
                    validated = true
                }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of
                 * [DiscordChannelConnection].
                 *
                 * The following fields are required:
                 *
                 * ```java
                 * .channelId()
                 * ```
                 */
                @JvmStatic
                fun builder() = Builder()
            }

            /** A builder for [DiscordChannelConnection]. */
            class Builder internal constructor() {

                private var channelId: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(discordChannelConnection: DiscordChannelConnection) =
                    apply {
                        channelId = discordChannelConnection.channelId
                        additionalProperties = discordChannelConnection.additionalProperties.toMutableMap()
                    }

                /** The Discord channel ID */
                fun channelId(channelId: String) = channelId(JsonField.of(channelId))

                /** The Discord channel ID */
                fun channelId(channelId: JsonField<String>) =
                    apply {
                        this.channelId = channelId
                    }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                fun putAdditionalProperty(key: String, value: JsonValue) =
                    apply {
                        additionalProperties.put(key, value)
                    }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) =
                    apply {
                        additionalProperties.remove(key)
                    }

                fun removeAllAdditionalProperties(keys: Set<String>) =
                    apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                fun build(): DiscordChannelConnection =
                    DiscordChannelConnection(
                      checkRequired(
                        "channelId", channelId
                      ), additionalProperties.toImmutable()
                    )
            }

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return /* spotless:off */ other is DiscordChannelConnection && channelId == other.channelId && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(channelId, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "DiscordChannelConnection{channelId=$channelId, additionalProperties=$additionalProperties}"
        }

        /** Discord incoming webhook connection */
        @NoAutoDetect
        class DiscordIncomingWebhookConnection @JsonCreator private constructor(
            @JsonProperty("incoming_webhook") @ExcludeMissing private val incomingWebhook: JsonField<IncomingWebhook> = JsonMissing.of(),
            @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

        ) {

            /** The incoming webhook */
            fun incomingWebhook(): IncomingWebhook = incomingWebhook.getRequired("incoming_webhook")

            /** The incoming webhook */
            @JsonProperty("incoming_webhook")
            @ExcludeMissing
            fun _incomingWebhook(): JsonField<IncomingWebhook> = incomingWebhook

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): DiscordIncomingWebhookConnection =
                apply {
                    if (validated) {
                      return@apply
                    }

                    incomingWebhook().validate()
                    validated = true
                }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of
                 * [DiscordIncomingWebhookConnection].
                 *
                 * The following fields are required:
                 *
                 * ```java
                 * .incomingWebhook()
                 * ```
                 */
                @JvmStatic
                fun builder() = Builder()
            }

            /** A builder for [DiscordIncomingWebhookConnection]. */
            class Builder internal constructor() {

                private var incomingWebhook: JsonField<IncomingWebhook>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(discordIncomingWebhookConnection: DiscordIncomingWebhookConnection) =
                    apply {
                        incomingWebhook = discordIncomingWebhookConnection.incomingWebhook
                        additionalProperties = discordIncomingWebhookConnection.additionalProperties.toMutableMap()
                    }

                /** The incoming webhook */
                fun incomingWebhook(incomingWebhook: IncomingWebhook) = incomingWebhook(JsonField.of(incomingWebhook))

                /** The incoming webhook */
                fun incomingWebhook(incomingWebhook: JsonField<IncomingWebhook>) =
                    apply {
                        this.incomingWebhook = incomingWebhook
                    }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                fun putAdditionalProperty(key: String, value: JsonValue) =
                    apply {
                        additionalProperties.put(key, value)
                    }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) =
                    apply {
                        additionalProperties.remove(key)
                    }

                fun removeAllAdditionalProperties(keys: Set<String>) =
                    apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                fun build(): DiscordIncomingWebhookConnection =
                    DiscordIncomingWebhookConnection(
                      checkRequired(
                        "incomingWebhook", incomingWebhook
                      ), additionalProperties.toImmutable()
                    )
            }

            /** The incoming webhook */
            @NoAutoDetect
            class IncomingWebhook @JsonCreator private constructor(
                @JsonProperty("url") @ExcludeMissing private val url: JsonField<String> = JsonMissing.of(),
                @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

            ) {

                /** The URL of the incoming webhook */
                fun url(): String = url.getRequired("url")

                /** The URL of the incoming webhook */
                @JsonProperty("url")
                @ExcludeMissing
                fun _url(): JsonField<String> = url

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): IncomingWebhook =
                    apply {
                        if (validated) {
                          return@apply
                        }

                        url()
                        validated = true
                    }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [IncomingWebhook].
                     *
                     * The following fields are required:
                     *
                     * ```java
                     * .url()
                     * ```
                     */
                    @JvmStatic
                    fun builder() = Builder()
                }

                /** A builder for [IncomingWebhook]. */
                class Builder internal constructor() {

                    private var url: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(incomingWebhook: IncomingWebhook) =
                        apply {
                            url = incomingWebhook.url
                            additionalProperties = incomingWebhook.additionalProperties.toMutableMap()
                        }

                    /** The URL of the incoming webhook */
                    fun url(url: String) = url(JsonField.of(url))

                    /** The URL of the incoming webhook */
                    fun url(url: JsonField<String>) =
                        apply {
                            this.url = url
                        }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.clear()
                            putAllAdditionalProperties(additionalProperties)
                        }

                    fun putAdditionalProperty(key: String, value: JsonValue) =
                        apply {
                            additionalProperties.put(key, value)
                        }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) =
                        apply {
                            additionalProperties.remove(key)
                        }

                    fun removeAllAdditionalProperties(keys: Set<String>) =
                        apply {
                            keys.forEach(::removeAdditionalProperty)
                        }

                    fun build(): IncomingWebhook =
                        IncomingWebhook(
                          checkRequired(
                            "url", url
                          ), additionalProperties.toImmutable()
                        )
                }

                override fun equals(other: Any?): Boolean {
                  if (this === other) {
                      return true
                  }

                  return /* spotless:off */ other is IncomingWebhook && url == other.url && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(url, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() = "IncomingWebhook{url=$url, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
              if (this === other) {
                  return true
              }

              return /* spotless:off */ other is DiscordIncomingWebhookConnection && incomingWebhook == other.incomingWebhook && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(incomingWebhook, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() = "DiscordIncomingWebhookConnection{incomingWebhook=$incomingWebhook, additionalProperties=$additionalProperties}"
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

    override fun toString() = "DiscordChannelData{connections=$connections, additionalProperties=$additionalProperties}"
}
