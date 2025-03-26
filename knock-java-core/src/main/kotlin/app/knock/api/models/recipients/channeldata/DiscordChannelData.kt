// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
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

        /** Alias for calling [addConnection] with `Connection.ofDiscordChannel(discordChannel)`. */
        fun addConnection(discordChannel: Connection.DiscordChannelConnection) =
            addConnection(Connection.ofDiscordChannel(discordChannel))

        /**
         * Alias for calling [addConnection] with
         * `Connection.ofDiscordIncomingWebhook(discordIncomingWebhook)`.
         */
        fun addConnection(discordIncomingWebhook: Connection.DiscordIncomingWebhookConnection) =
            addConnection(Connection.ofDiscordIncomingWebhook(discordIncomingWebhook))

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

    /** Discord channel connection */
    @JsonDeserialize(using = Connection.Deserializer::class)
    @JsonSerialize(using = Connection.Serializer::class)
    class Connection
    private constructor(
        private val discordChannel: DiscordChannelConnection? = null,
        private val discordIncomingWebhook: DiscordIncomingWebhookConnection? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Discord channel connection */
        fun discordChannel(): Optional<DiscordChannelConnection> =
            Optional.ofNullable(discordChannel)

        /** Discord incoming webhook connection */
        fun discordIncomingWebhook(): Optional<DiscordIncomingWebhookConnection> =
            Optional.ofNullable(discordIncomingWebhook)

        fun isDiscordChannel(): Boolean = discordChannel != null

        fun isDiscordIncomingWebhook(): Boolean = discordIncomingWebhook != null

        /** Discord channel connection */
        fun asDiscordChannel(): DiscordChannelConnection =
            discordChannel.getOrThrow("discordChannel")

        /** Discord incoming webhook connection */
        fun asDiscordIncomingWebhook(): DiscordIncomingWebhookConnection =
            discordIncomingWebhook.getOrThrow("discordIncomingWebhook")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                discordChannel != null -> visitor.visitDiscordChannel(discordChannel)
                discordIncomingWebhook != null ->
                    visitor.visitDiscordIncomingWebhook(discordIncomingWebhook)
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
                    override fun visitDiscordChannel(discordChannel: DiscordChannelConnection) {
                        discordChannel.validate()
                    }

                    override fun visitDiscordIncomingWebhook(
                        discordIncomingWebhook: DiscordIncomingWebhookConnection
                    ) {
                        discordIncomingWebhook.validate()
                    }
                }
            )
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
                discordIncomingWebhook != null ->
                    "Connection{discordIncomingWebhook=$discordIncomingWebhook}"
                _json != null -> "Connection{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Connection")
            }

        companion object {

            /** Discord channel connection */
            @JvmStatic
            fun ofDiscordChannel(discordChannel: DiscordChannelConnection) =
                Connection(discordChannel = discordChannel)

            /** Discord incoming webhook connection */
            @JvmStatic
            fun ofDiscordIncomingWebhook(discordIncomingWebhook: DiscordIncomingWebhookConnection) =
                Connection(discordIncomingWebhook = discordIncomingWebhook)
        }

        /**
         * An interface that defines how to map each variant of [Connection] to a value of type [T].
         */
        interface Visitor<out T> {

            /** Discord channel connection */
            fun visitDiscordChannel(discordChannel: DiscordChannelConnection): T

            /** Discord incoming webhook connection */
            fun visitDiscordIncomingWebhook(
                discordIncomingWebhook: DiscordIncomingWebhookConnection
            ): T

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

                tryDeserialize(node, jacksonTypeRef<DiscordChannelConnection>()) { it.validate() }
                    ?.let {
                        return Connection(discordChannel = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<DiscordIncomingWebhookConnection>()) {
                        it.validate()
                    }
                    ?.let {
                        return Connection(discordIncomingWebhook = it, _json = json)
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
                    value.discordChannel != null -> generator.writeObject(value.discordChannel)
                    value.discordIncomingWebhook != null ->
                        generator.writeObject(value.discordIncomingWebhook)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Connection")
                }
            }
        }

        /** Discord channel connection */
        class DiscordChannelConnection
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
                 * Returns a mutable builder for constructing an instance of
                 * [DiscordChannelConnection].
                 *
                 * The following fields are required:
                 * ```java
                 * .channelId()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [DiscordChannelConnection]. */
            class Builder internal constructor() {

                private var channelId: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(discordChannelConnection: DiscordChannelConnection) = apply {
                    channelId = discordChannelConnection.channelId
                    additionalProperties =
                        discordChannelConnection.additionalProperties.toMutableMap()
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
                 * Returns an immutable instance of [DiscordChannelConnection].
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
                fun build(): DiscordChannelConnection =
                    DiscordChannelConnection(
                        checkRequired("channelId", channelId),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): DiscordChannelConnection = apply {
                if (validated) {
                    return@apply
                }

                channelId()
                validated = true
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

            override fun toString() =
                "DiscordChannelConnection{channelId=$channelId, additionalProperties=$additionalProperties}"
        }

        /** Discord incoming webhook connection */
        class DiscordIncomingWebhookConnection
        private constructor(
            private val incomingWebhook: JsonField<IncomingWebhook>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("incoming_webhook")
                @ExcludeMissing
                incomingWebhook: JsonField<IncomingWebhook> = JsonMissing.of()
            ) : this(incomingWebhook, mutableMapOf())

            /**
             * The incoming webhook
             *
             * @throws KnockInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun incomingWebhook(): IncomingWebhook = incomingWebhook.getRequired("incoming_webhook")

            /**
             * Returns the raw JSON value of [incomingWebhook].
             *
             * Unlike [incomingWebhook], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("incoming_webhook")
            @ExcludeMissing
            fun _incomingWebhook(): JsonField<IncomingWebhook> = incomingWebhook

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
                 * [DiscordIncomingWebhookConnection].
                 *
                 * The following fields are required:
                 * ```java
                 * .incomingWebhook()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [DiscordIncomingWebhookConnection]. */
            class Builder internal constructor() {

                private var incomingWebhook: JsonField<IncomingWebhook>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(
                    discordIncomingWebhookConnection: DiscordIncomingWebhookConnection
                ) = apply {
                    incomingWebhook = discordIncomingWebhookConnection.incomingWebhook
                    additionalProperties =
                        discordIncomingWebhookConnection.additionalProperties.toMutableMap()
                }

                /** The incoming webhook */
                fun incomingWebhook(incomingWebhook: IncomingWebhook) =
                    incomingWebhook(JsonField.of(incomingWebhook))

                /**
                 * Sets [Builder.incomingWebhook] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.incomingWebhook] with a well-typed
                 * [IncomingWebhook] value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun incomingWebhook(incomingWebhook: JsonField<IncomingWebhook>) = apply {
                    this.incomingWebhook = incomingWebhook
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

                /**
                 * Returns an immutable instance of [DiscordIncomingWebhookConnection].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .incomingWebhook()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): DiscordIncomingWebhookConnection =
                    DiscordIncomingWebhookConnection(
                        checkRequired("incomingWebhook", incomingWebhook),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): DiscordIncomingWebhookConnection = apply {
                if (validated) {
                    return@apply
                }

                incomingWebhook().validate()
                validated = true
            }

            /** The incoming webhook */
            class IncomingWebhook
            private constructor(
                private val url: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of()
                ) : this(url, mutableMapOf())

                /**
                 * The URL of the incoming webhook
                 *
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
                     * Returns a mutable builder for constructing an instance of [IncomingWebhook].
                     *
                     * The following fields are required:
                     * ```java
                     * .url()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [IncomingWebhook]. */
                class Builder internal constructor() {

                    private var url: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(incomingWebhook: IncomingWebhook) = apply {
                        url = incomingWebhook.url
                        additionalProperties = incomingWebhook.additionalProperties.toMutableMap()
                    }

                    /** The URL of the incoming webhook */
                    fun url(url: String) = url(JsonField.of(url))

                    /**
                     * Sets [Builder.url] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.url] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
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
                     * Returns an immutable instance of [IncomingWebhook].
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
                    fun build(): IncomingWebhook =
                        IncomingWebhook(
                            checkRequired("url", url),
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): IncomingWebhook = apply {
                    if (validated) {
                        return@apply
                    }

                    url()
                    validated = true
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

                override fun toString() =
                    "IncomingWebhook{url=$url, additionalProperties=$additionalProperties}"
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

            override fun toString() =
                "DiscordIncomingWebhookConnection{incomingWebhook=$incomingWebhook, additionalProperties=$additionalProperties}"
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
