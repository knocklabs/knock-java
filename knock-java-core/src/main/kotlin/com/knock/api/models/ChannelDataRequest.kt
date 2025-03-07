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
import com.knock.api.core.checkRequired
import com.knock.api.core.getOrThrow
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.errors.KnockInvalidDataException
import java.util.Objects
import java.util.Optional

/** Set channel data for a type of channel */
@NoAutoDetect
class ChannelDataRequest
@JsonCreator
private constructor(
    @JsonProperty("data") @ExcludeMissing private val data: JsonField<Data> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** Channel data for push providers */
    fun data(): Data = data.getRequired("data")

    /** Channel data for push providers */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ChannelDataRequest = apply {
        if (validated) {
            return@apply
        }

        data().validate()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ChannelDataRequest].
         *
         * The following fields are required:
         * ```java
         * .data()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChannelDataRequest]. */
    class Builder internal constructor() {

        private var data: JsonField<Data>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(channelDataRequest: ChannelDataRequest) = apply {
            data = channelDataRequest.data
            additionalProperties = channelDataRequest.additionalProperties.toMutableMap()
        }

        /** Channel data for push providers */
        fun data(data: Data) = data(JsonField.of(data))

        /** Channel data for push providers */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /** Channel data for push providers */
        fun data(pushChannel: PushChannelData) = data(Data.ofPushChannel(pushChannel))

        /** OneSignal channel data */
        fun data(oneSignalChannel: OneSignalChannelData) =
            data(Data.ofOneSignalChannel(oneSignalChannel))

        /** Slack channel data */
        fun data(slackChannel: SlackChannelData) = data(Data.ofSlackChannel(slackChannel))

        /** Microsoft Teams channel data */
        fun data(msTeamsChannel: MsTeamsChannelData) = data(Data.ofMsTeamsChannel(msTeamsChannel))

        /** Discord channel data */
        fun data(discordChannel: DiscordChannelData) = data(Data.ofDiscordChannel(discordChannel))

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

        fun build(): ChannelDataRequest =
            ChannelDataRequest(checkRequired("data", data), additionalProperties.toImmutable())
    }

    /** Channel data for push providers */
    @JsonDeserialize(using = Data.Deserializer::class)
    @JsonSerialize(using = Data.Serializer::class)
    class Data
    private constructor(
        private val pushChannel: PushChannelData? = null,
        private val oneSignalChannel: OneSignalChannelData? = null,
        private val slackChannel: SlackChannelData? = null,
        private val msTeamsChannel: MsTeamsChannelData? = null,
        private val discordChannel: DiscordChannelData? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Channel data for push providers */
        fun pushChannel(): Optional<PushChannelData> = Optional.ofNullable(pushChannel)

        /** OneSignal channel data */
        fun oneSignalChannel(): Optional<OneSignalChannelData> =
            Optional.ofNullable(oneSignalChannel)

        /** Slack channel data */
        fun slackChannel(): Optional<SlackChannelData> = Optional.ofNullable(slackChannel)

        /** Microsoft Teams channel data */
        fun msTeamsChannel(): Optional<MsTeamsChannelData> = Optional.ofNullable(msTeamsChannel)

        /** Discord channel data */
        fun discordChannel(): Optional<DiscordChannelData> = Optional.ofNullable(discordChannel)

        fun isPushChannel(): Boolean = pushChannel != null

        fun isOneSignalChannel(): Boolean = oneSignalChannel != null

        fun isSlackChannel(): Boolean = slackChannel != null

        fun isMsTeamsChannel(): Boolean = msTeamsChannel != null

        fun isDiscordChannel(): Boolean = discordChannel != null

        /** Channel data for push providers */
        fun asPushChannel(): PushChannelData = pushChannel.getOrThrow("pushChannel")

        /** OneSignal channel data */
        fun asOneSignalChannel(): OneSignalChannelData =
            oneSignalChannel.getOrThrow("oneSignalChannel")

        /** Slack channel data */
        fun asSlackChannel(): SlackChannelData = slackChannel.getOrThrow("slackChannel")

        /** Microsoft Teams channel data */
        fun asMsTeamsChannel(): MsTeamsChannelData = msTeamsChannel.getOrThrow("msTeamsChannel")

        /** Discord channel data */
        fun asDiscordChannel(): DiscordChannelData = discordChannel.getOrThrow("discordChannel")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                pushChannel != null -> visitor.visitPushChannel(pushChannel)
                oneSignalChannel != null -> visitor.visitOneSignalChannel(oneSignalChannel)
                slackChannel != null -> visitor.visitSlackChannel(slackChannel)
                msTeamsChannel != null -> visitor.visitMsTeamsChannel(msTeamsChannel)
                discordChannel != null -> visitor.visitDiscordChannel(discordChannel)
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
                    override fun visitPushChannel(pushChannel: PushChannelData) {
                        pushChannel.validate()
                    }

                    override fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData) {
                        oneSignalChannel.validate()
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
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Data && pushChannel == other.pushChannel && oneSignalChannel == other.oneSignalChannel && slackChannel == other.slackChannel && msTeamsChannel == other.msTeamsChannel && discordChannel == other.discordChannel /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(pushChannel, oneSignalChannel, slackChannel, msTeamsChannel, discordChannel) /* spotless:on */

        override fun toString(): String =
            when {
                pushChannel != null -> "Data{pushChannel=$pushChannel}"
                oneSignalChannel != null -> "Data{oneSignalChannel=$oneSignalChannel}"
                slackChannel != null -> "Data{slackChannel=$slackChannel}"
                msTeamsChannel != null -> "Data{msTeamsChannel=$msTeamsChannel}"
                discordChannel != null -> "Data{discordChannel=$discordChannel}"
                _json != null -> "Data{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Data")
            }

        companion object {

            /** Channel data for push providers */
            @JvmStatic
            fun ofPushChannel(pushChannel: PushChannelData) = Data(pushChannel = pushChannel)

            /** OneSignal channel data */
            @JvmStatic
            fun ofOneSignalChannel(oneSignalChannel: OneSignalChannelData) =
                Data(oneSignalChannel = oneSignalChannel)

            /** Slack channel data */
            @JvmStatic
            fun ofSlackChannel(slackChannel: SlackChannelData) = Data(slackChannel = slackChannel)

            /** Microsoft Teams channel data */
            @JvmStatic
            fun ofMsTeamsChannel(msTeamsChannel: MsTeamsChannelData) =
                Data(msTeamsChannel = msTeamsChannel)

            /** Discord channel data */
            @JvmStatic
            fun ofDiscordChannel(discordChannel: DiscordChannelData) =
                Data(discordChannel = discordChannel)
        }

        /** An interface that defines how to map each variant of [Data] to a value of type [T]. */
        interface Visitor<out T> {

            /** Channel data for push providers */
            fun visitPushChannel(pushChannel: PushChannelData): T

            /** OneSignal channel data */
            fun visitOneSignalChannel(oneSignalChannel: OneSignalChannelData): T

            /** Slack channel data */
            fun visitSlackChannel(slackChannel: SlackChannelData): T

            /** Microsoft Teams channel data */
            fun visitMsTeamsChannel(msTeamsChannel: MsTeamsChannelData): T

            /** Discord channel data */
            fun visitDiscordChannel(discordChannel: DiscordChannelData): T

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

                tryDeserialize(node, jacksonTypeRef<PushChannelData>()) { it.validate() }
                    ?.let {
                        return Data(pushChannel = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<OneSignalChannelData>()) { it.validate() }
                    ?.let {
                        return Data(oneSignalChannel = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<SlackChannelData>()) { it.validate() }
                    ?.let {
                        return Data(slackChannel = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<MsTeamsChannelData>()) { it.validate() }
                    ?.let {
                        return Data(msTeamsChannel = it, _json = json)
                    }
                tryDeserialize(node, jacksonTypeRef<DiscordChannelData>()) { it.validate() }
                    ?.let {
                        return Data(discordChannel = it, _json = json)
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
                    value.pushChannel != null -> generator.writeObject(value.pushChannel)
                    value.oneSignalChannel != null -> generator.writeObject(value.oneSignalChannel)
                    value.slackChannel != null -> generator.writeObject(value.slackChannel)
                    value.msTeamsChannel != null -> generator.writeObject(value.msTeamsChannel)
                    value.discordChannel != null -> generator.writeObject(value.discordChannel)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Data")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ChannelDataRequest && data == other.data && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(data, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChannelDataRequest{data=$data, additionalProperties=$additionalProperties}"
}
