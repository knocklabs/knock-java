// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.channeldata

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.Enum
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.allMaxBy
import app.knock.api.core.checkRequired
import app.knock.api.core.getOrThrow
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

/** Channel data for a given channel type. */
class ChannelData
private constructor(
    private val channelId: JsonField<String>,
    private val data: JsonField<Data>,
    private val provider: JsonField<Provider>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("channel_id") @ExcludeMissing channelId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("provider") @ExcludeMissing provider: JsonField<Provider> = JsonMissing.of(),
    ) : this(channelId, data, provider, mutableMapOf())

    /**
     * The unique identifier for the channel.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun channelId(): String = channelId.getRequired("channel_id")

    /**
     * Channel data for a given channel type.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun data(): Data = data.getRequired("data")

    /**
     * The type of provider.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun provider(): Optional<Provider> = provider.getOptional("provider")

    /**
     * Returns the raw JSON value of [channelId].
     *
     * Unlike [channelId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("channel_id") @ExcludeMissing fun _channelId(): JsonField<String> = channelId

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [provider].
     *
     * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("provider") @ExcludeMissing fun _provider(): JsonField<Provider> = provider

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
         * Returns a mutable builder for constructing an instance of [ChannelData].
         *
         * The following fields are required:
         * ```java
         * .channelId()
         * .data()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChannelData]. */
    class Builder internal constructor() {

        private var channelId: JsonField<String>? = null
        private var data: JsonField<Data>? = null
        private var provider: JsonField<Provider> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(channelData: ChannelData) = apply {
            channelId = channelData.channelId
            data = channelData.data
            provider = channelData.provider
            additionalProperties = channelData.additionalProperties.toMutableMap()
        }

        /** The unique identifier for the channel. */
        fun channelId(channelId: String) = channelId(JsonField.of(channelId))

        /**
         * Sets [Builder.channelId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.channelId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun channelId(channelId: JsonField<String>) = apply { this.channelId = channelId }

        /** Channel data for a given channel type. */
        fun data(data: Data) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** Alias for calling [data] with `Data.ofPushChannel(pushChannel)`. */
        fun data(pushChannel: PushChannelData) = data(Data.ofPushChannel(pushChannel))

        /** Alias for calling [data] with `Data.ofSlackChannel(slackChannel)`. */
        fun data(slackChannel: SlackChannelData) = data(Data.ofSlackChannel(slackChannel))

        /** Alias for calling [data] with `Data.ofMsTeamsChannel(msTeamsChannel)`. */
        fun data(msTeamsChannel: MsTeamsChannelData) = data(Data.ofMsTeamsChannel(msTeamsChannel))

        /** Alias for calling [data] with `Data.ofDiscordChannel(discordChannel)`. */
        fun data(discordChannel: DiscordChannelData) = data(Data.ofDiscordChannel(discordChannel))

        /** Alias for calling [data] with `Data.ofOneSignalChannel(oneSignalChannel)`. */
        fun data(oneSignalChannel: OneSignalChannelData) =
            data(Data.ofOneSignalChannel(oneSignalChannel))

        /** The type of provider. */
        fun provider(provider: Provider) = provider(JsonField.of(provider))

        /**
         * Sets [Builder.provider] to an arbitrary JSON value.
         *
         * You should usually call [Builder.provider] with a well-typed [Provider] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun provider(provider: JsonField<Provider>) = apply { this.provider = provider }

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
         * Returns an immutable instance of [ChannelData].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .channelId()
         * .data()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChannelData =
            ChannelData(
                checkRequired("channelId", channelId),
                checkRequired("data", data),
                provider,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChannelData = apply {
        if (validated) {
            return@apply
        }

        channelId()
        data().validate()
        provider().ifPresent { it.validate() }
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
        (if (channelId.asKnown().isPresent) 1 else 0) +
            (data.asKnown().getOrNull()?.validity() ?: 0) +
            (provider.asKnown().getOrNull()?.validity() ?: 0)

    /** Channel data for a given channel type. */
    @JsonDeserialize(using = Data.Deserializer::class)
    @JsonSerialize(using = Data.Serializer::class)
    class Data
    private constructor(
        private val pushChannel: PushChannelData? = null,
        private val slackChannel: SlackChannelData? = null,
        private val msTeamsChannel: MsTeamsChannelData? = null,
        private val discordChannel: DiscordChannelData? = null,
        private val oneSignalChannel: OneSignalChannelData? = null,
        private val _json: JsonValue? = null,
    ) {

        /** The content of a push notification. */
        fun pushChannel(): Optional<PushChannelData> = Optional.ofNullable(pushChannel)

        /** Slack channel data */
        fun slackChannel(): Optional<SlackChannelData> = Optional.ofNullable(slackChannel)

        /** Microsoft Teams channel connection. */
        fun msTeamsChannel(): Optional<MsTeamsChannelData> = Optional.ofNullable(msTeamsChannel)

        /** Discord channel data. */
        fun discordChannel(): Optional<DiscordChannelData> = Optional.ofNullable(discordChannel)

        /** OneSignal channel data. */
        fun oneSignalChannel(): Optional<OneSignalChannelData> =
            Optional.ofNullable(oneSignalChannel)

        fun isPushChannel(): Boolean = pushChannel != null

        fun isSlackChannel(): Boolean = slackChannel != null

        fun isMsTeamsChannel(): Boolean = msTeamsChannel != null

        fun isDiscordChannel(): Boolean = discordChannel != null

        fun isOneSignalChannel(): Boolean = oneSignalChannel != null

        /** The content of a push notification. */
        fun asPushChannel(): PushChannelData = pushChannel.getOrThrow("pushChannel")

        /** Slack channel data */
        fun asSlackChannel(): SlackChannelData = slackChannel.getOrThrow("slackChannel")

        /** Microsoft Teams channel connection. */
        fun asMsTeamsChannel(): MsTeamsChannelData = msTeamsChannel.getOrThrow("msTeamsChannel")

        /** Discord channel data. */
        fun asDiscordChannel(): DiscordChannelData = discordChannel.getOrThrow("discordChannel")

        /** OneSignal channel data. */
        fun asOneSignalChannel(): OneSignalChannelData =
            oneSignalChannel.getOrThrow("oneSignalChannel")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                pushChannel != null -> visitor.visitPushChannel(pushChannel)
                slackChannel != null -> visitor.visitSlackChannel(slackChannel)
                msTeamsChannel != null -> visitor.visitMsTeamsChannel(msTeamsChannel)
                discordChannel != null -> visitor.visitDiscordChannel(discordChannel)
                oneSignalChannel != null -> visitor.visitOneSignalChannel(oneSignalChannel)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitPushChannel(pushChannel: PushChannelData) {
                        pushChannel.validate()
                    }

                    override fun visitSlackChannel(slackChannel: SlackChannelData) {
                        slackChannel.validate()
                    }

                    override fun visitMsTeamsChannel(msTeamsChannel: MsTeamsChannelData) {
                        msTeamsChannel.validate()
                    }

                    override fun visitDiscordChannel(discordChannel: DiscordChannelData) {
                        discordChannel.validate()
                    }

                    override fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData) {
                        oneSignalChannel.validate()
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
                    override fun visitPushChannel(pushChannel: PushChannelData) =
                        pushChannel.validity()

                    override fun visitSlackChannel(slackChannel: SlackChannelData) =
                        slackChannel.validity()

                    override fun visitMsTeamsChannel(msTeamsChannel: MsTeamsChannelData) =
                        msTeamsChannel.validity()

                    override fun visitDiscordChannel(discordChannel: DiscordChannelData) =
                        discordChannel.validity()

                    override fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData) =
                        oneSignalChannel.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Data && pushChannel == other.pushChannel && slackChannel == other.slackChannel && msTeamsChannel == other.msTeamsChannel && discordChannel == other.discordChannel && oneSignalChannel == other.oneSignalChannel /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(pushChannel, slackChannel, msTeamsChannel, discordChannel, oneSignalChannel) /* spotless:on */

        override fun toString(): String =
            when {
                pushChannel != null -> "Data{pushChannel=$pushChannel}"
                slackChannel != null -> "Data{slackChannel=$slackChannel}"
                msTeamsChannel != null -> "Data{msTeamsChannel=$msTeamsChannel}"
                discordChannel != null -> "Data{discordChannel=$discordChannel}"
                oneSignalChannel != null -> "Data{oneSignalChannel=$oneSignalChannel}"
                _json != null -> "Data{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Data")
            }

        companion object {

            /** The content of a push notification. */
            @JvmStatic
            fun ofPushChannel(pushChannel: PushChannelData) = Data(pushChannel = pushChannel)

            /** Slack channel data */
            @JvmStatic
            fun ofSlackChannel(slackChannel: SlackChannelData) = Data(slackChannel = slackChannel)

            /** Microsoft Teams channel connection. */
            @JvmStatic
            fun ofMsTeamsChannel(msTeamsChannel: MsTeamsChannelData) =
                Data(msTeamsChannel = msTeamsChannel)

            /** Discord channel data. */
            @JvmStatic
            fun ofDiscordChannel(discordChannel: DiscordChannelData) =
                Data(discordChannel = discordChannel)

            /** OneSignal channel data. */
            @JvmStatic
            fun ofOneSignalChannel(oneSignalChannel: OneSignalChannelData) =
                Data(oneSignalChannel = oneSignalChannel)
        }

        /** An interface that defines how to map each variant of [Data] to a value of type [T]. */
        interface Visitor<out T> {

            /** The content of a push notification. */
            fun visitPushChannel(pushChannel: PushChannelData): T

            /** Slack channel data */
            fun visitSlackChannel(slackChannel: SlackChannelData): T

            /** Microsoft Teams channel connection. */
            fun visitMsTeamsChannel(msTeamsChannel: MsTeamsChannelData): T

            /** Discord channel data. */
            fun visitDiscordChannel(discordChannel: DiscordChannelData): T

            /** OneSignal channel data. */
            fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData): T

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
                            tryDeserialize(node, jacksonTypeRef<PushChannelData>())?.let {
                                Data(pushChannel = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<SlackChannelData>())?.let {
                                Data(slackChannel = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<MsTeamsChannelData>())?.let {
                                Data(msTeamsChannel = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<DiscordChannelData>())?.let {
                                Data(discordChannel = it, _json = json)
                            },
                            tryDeserialize(node, jacksonTypeRef<OneSignalChannelData>())?.let {
                                Data(oneSignalChannel = it, _json = json)
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
                    value.pushChannel != null -> generator.writeObject(value.pushChannel)
                    value.slackChannel != null -> generator.writeObject(value.slackChannel)
                    value.msTeamsChannel != null -> generator.writeObject(value.msTeamsChannel)
                    value.discordChannel != null -> generator.writeObject(value.discordChannel)
                    value.oneSignalChannel != null -> generator.writeObject(value.oneSignalChannel)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Data")
                }
            }
        }
    }

    /** The type of provider. */
    class Provider @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PUSH_FCM = of("push_fcm")

            @JvmField val PUSH_APNS = of("push_apns")

            @JvmField val PUSH_EXPO = of("push_expo")

            @JvmField val PUSH_ONE_SIGNAL = of("push_one_signal")

            @JvmField val CHAT_SLACK = of("chat_slack")

            @JvmField val CHAT_MS_TEAMS = of("chat_ms_teams")

            @JvmField val CHAT_DISCORD = of("chat_discord")

            @JvmField val HTTP_KNOCK_WEBHOOK = of("http_knock_webhook")

            @JvmStatic fun of(value: String) = Provider(JsonField.of(value))
        }

        /** An enum containing [Provider]'s known values. */
        enum class Known {
            PUSH_FCM,
            PUSH_APNS,
            PUSH_EXPO,
            PUSH_ONE_SIGNAL,
            CHAT_SLACK,
            CHAT_MS_TEAMS,
            CHAT_DISCORD,
            HTTP_KNOCK_WEBHOOK,
        }

        /**
         * An enum containing [Provider]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Provider] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PUSH_FCM,
            PUSH_APNS,
            PUSH_EXPO,
            PUSH_ONE_SIGNAL,
            CHAT_SLACK,
            CHAT_MS_TEAMS,
            CHAT_DISCORD,
            HTTP_KNOCK_WEBHOOK,
            /** An enum member indicating that [Provider] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PUSH_FCM -> Value.PUSH_FCM
                PUSH_APNS -> Value.PUSH_APNS
                PUSH_EXPO -> Value.PUSH_EXPO
                PUSH_ONE_SIGNAL -> Value.PUSH_ONE_SIGNAL
                CHAT_SLACK -> Value.CHAT_SLACK
                CHAT_MS_TEAMS -> Value.CHAT_MS_TEAMS
                CHAT_DISCORD -> Value.CHAT_DISCORD
                HTTP_KNOCK_WEBHOOK -> Value.HTTP_KNOCK_WEBHOOK
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws KnockInvalidDataException if this class instance's value is a not a known member.
         */
        fun known(): Known =
            when (this) {
                PUSH_FCM -> Known.PUSH_FCM
                PUSH_APNS -> Known.PUSH_APNS
                PUSH_EXPO -> Known.PUSH_EXPO
                PUSH_ONE_SIGNAL -> Known.PUSH_ONE_SIGNAL
                CHAT_SLACK -> Known.CHAT_SLACK
                CHAT_MS_TEAMS -> Known.CHAT_MS_TEAMS
                CHAT_DISCORD -> Known.CHAT_DISCORD
                HTTP_KNOCK_WEBHOOK -> Known.HTTP_KNOCK_WEBHOOK
                else -> throw KnockInvalidDataException("Unknown Provider: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws KnockInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { KnockInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Provider = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Provider && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChannelData && channelId == other.channelId && data == other.data && provider == other.provider && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(channelId, data, provider, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChannelData{channelId=$channelId, data=$data, provider=$provider, additionalProperties=$additionalProperties}"
}
