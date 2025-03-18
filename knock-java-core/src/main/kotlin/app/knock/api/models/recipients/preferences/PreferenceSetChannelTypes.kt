// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.recipients.preferences

import app.knock.api.core.BaseDeserializer
import app.knock.api.core.BaseSerializer
import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
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

/** Channel type preferences */
@NoAutoDetect
class PreferenceSetChannelTypes
@JsonCreator
private constructor(
    @JsonProperty("chat") @ExcludeMissing private val chat: JsonField<Chat> = JsonMissing.of(),
    @JsonProperty("email") @ExcludeMissing private val email: JsonField<Email> = JsonMissing.of(),
    @JsonProperty("http") @ExcludeMissing private val http: JsonField<Http> = JsonMissing.of(),
    @JsonProperty("in_app_feed")
    @ExcludeMissing
    private val inAppFeed: JsonField<InAppFeed> = JsonMissing.of(),
    @JsonProperty("push") @ExcludeMissing private val push: JsonField<Push> = JsonMissing.of(),
    @JsonProperty("sms") @ExcludeMissing private val sms: JsonField<Sms> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun chat(): Optional<Chat> = Optional.ofNullable(chat.getNullable("chat"))

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): Optional<Email> = Optional.ofNullable(email.getNullable("email"))

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun http(): Optional<Http> = Optional.ofNullable(http.getNullable("http"))

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun inAppFeed(): Optional<InAppFeed> = Optional.ofNullable(inAppFeed.getNullable("in_app_feed"))

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun push(): Optional<Push> = Optional.ofNullable(push.getNullable("push"))

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun sms(): Optional<Sms> = Optional.ofNullable(sms.getNullable("sms"))

    /**
     * Returns the raw JSON value of [chat].
     *
     * Unlike [chat], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("chat") @ExcludeMissing fun _chat(): JsonField<Chat> = chat

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<Email> = email

    /**
     * Returns the raw JSON value of [http].
     *
     * Unlike [http], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("http") @ExcludeMissing fun _http(): JsonField<Http> = http

    /**
     * Returns the raw JSON value of [inAppFeed].
     *
     * Unlike [inAppFeed], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("in_app_feed") @ExcludeMissing fun _inAppFeed(): JsonField<InAppFeed> = inAppFeed

    /**
     * Returns the raw JSON value of [push].
     *
     * Unlike [push], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("push") @ExcludeMissing fun _push(): JsonField<Push> = push

    /**
     * Returns the raw JSON value of [sms].
     *
     * Unlike [sms], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("sms") @ExcludeMissing fun _sms(): JsonField<Sms> = sms

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): PreferenceSetChannelTypes = apply {
        if (validated) {
            return@apply
        }

        chat().ifPresent { it.validate() }
        email().ifPresent { it.validate() }
        http().ifPresent { it.validate() }
        inAppFeed().ifPresent { it.validate() }
        push().ifPresent { it.validate() }
        sms().ifPresent { it.validate() }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PreferenceSetChannelTypes].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [PreferenceSetChannelTypes]. */
    class Builder internal constructor() {

        private var chat: JsonField<Chat> = JsonMissing.of()
        private var email: JsonField<Email> = JsonMissing.of()
        private var http: JsonField<Http> = JsonMissing.of()
        private var inAppFeed: JsonField<InAppFeed> = JsonMissing.of()
        private var push: JsonField<Push> = JsonMissing.of()
        private var sms: JsonField<Sms> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(preferenceSetChannelTypes: PreferenceSetChannelTypes) = apply {
            chat = preferenceSetChannelTypes.chat
            email = preferenceSetChannelTypes.email
            http = preferenceSetChannelTypes.http
            inAppFeed = preferenceSetChannelTypes.inAppFeed
            push = preferenceSetChannelTypes.push
            sms = preferenceSetChannelTypes.sms
            additionalProperties = preferenceSetChannelTypes.additionalProperties.toMutableMap()
        }

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun chat(chat: Chat) = chat(JsonField.of(chat))

        /**
         * Sets [Builder.chat] to an arbitrary JSON value.
         *
         * You should usually call [Builder.chat] with a well-typed [Chat] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun chat(chat: JsonField<Chat>) = apply { this.chat = chat }

        /** Alias for calling [chat] with `Chat.ofBool(bool)`. */
        fun chat(bool: Boolean) = chat(Chat.ofBool(bool))

        /**
         * Alias for calling [chat] with
         * `Chat.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)`.
         */
        fun chat(preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting) =
            chat(Chat.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting))

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun email(email: Email) = email(JsonField.of(email))

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [Email] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<Email>) = apply { this.email = email }

        /** Alias for calling [email] with `Email.ofBool(bool)`. */
        fun email(bool: Boolean) = email(Email.ofBool(bool))

        /**
         * Alias for calling [email] with
         * `Email.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)`.
         */
        fun email(preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting) =
            email(Email.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting))

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun http(http: Http) = http(JsonField.of(http))

        /**
         * Sets [Builder.http] to an arbitrary JSON value.
         *
         * You should usually call [Builder.http] with a well-typed [Http] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun http(http: JsonField<Http>) = apply { this.http = http }

        /** Alias for calling [http] with `Http.ofBool(bool)`. */
        fun http(bool: Boolean) = http(Http.ofBool(bool))

        /**
         * Alias for calling [http] with
         * `Http.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)`.
         */
        fun http(preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting) =
            http(Http.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting))

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun inAppFeed(inAppFeed: InAppFeed) = inAppFeed(JsonField.of(inAppFeed))

        /**
         * Sets [Builder.inAppFeed] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inAppFeed] with a well-typed [InAppFeed] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun inAppFeed(inAppFeed: JsonField<InAppFeed>) = apply { this.inAppFeed = inAppFeed }

        /** Alias for calling [inAppFeed] with `InAppFeed.ofBool(bool)`. */
        fun inAppFeed(bool: Boolean) = inAppFeed(InAppFeed.ofBool(bool))

        /**
         * Alias for calling [inAppFeed] with
         * `InAppFeed.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)`.
         */
        fun inAppFeed(preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting) =
            inAppFeed(InAppFeed.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting))

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun push(push: Push) = push(JsonField.of(push))

        /**
         * Sets [Builder.push] to an arbitrary JSON value.
         *
         * You should usually call [Builder.push] with a well-typed [Push] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun push(push: JsonField<Push>) = apply { this.push = push }

        /** Alias for calling [push] with `Push.ofBool(bool)`. */
        fun push(bool: Boolean) = push(Push.ofBool(bool))

        /**
         * Alias for calling [push] with
         * `Push.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)`.
         */
        fun push(preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting) =
            push(Push.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting))

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun sms(sms: Sms) = sms(JsonField.of(sms))

        /**
         * Sets [Builder.sms] to an arbitrary JSON value.
         *
         * You should usually call [Builder.sms] with a well-typed [Sms] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun sms(sms: JsonField<Sms>) = apply { this.sms = sms }

        /** Alias for calling [sms] with `Sms.ofBool(bool)`. */
        fun sms(bool: Boolean) = sms(Sms.ofBool(bool))

        /**
         * Alias for calling [sms] with
         * `Sms.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)`.
         */
        fun sms(preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting) =
            sms(Sms.ofPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting))

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
         * Returns an immutable instance of [PreferenceSetChannelTypes].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): PreferenceSetChannelTypes =
            PreferenceSetChannelTypes(
                chat,
                email,
                http,
                inAppFeed,
                push,
                sms,
                additionalProperties.toImmutable(),
            )
    }

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     */
    @JsonDeserialize(using = Chat.Deserializer::class)
    @JsonSerialize(using = Chat.Serializer::class)
    class Chat
    private constructor(
        private val bool: Boolean? = null,
        private val preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting? = null,
        private val _json: JsonValue? = null,
    ) {

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun preferenceSetChannelTypeSetting(): Optional<PreferenceSetChannelTypeSetting> =
            Optional.ofNullable(preferenceSetChannelTypeSetting)

        fun isBool(): Boolean = bool != null

        fun isPreferenceSetChannelTypeSetting(): Boolean = preferenceSetChannelTypeSetting != null

        fun asBool(): Boolean = bool.getOrThrow("bool")

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun asPreferenceSetChannelTypeSetting(): PreferenceSetChannelTypeSetting =
            preferenceSetChannelTypeSetting.getOrThrow("preferenceSetChannelTypeSetting")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                bool != null -> visitor.visitBool(bool)
                preferenceSetChannelTypeSetting != null ->
                    visitor.visitPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Chat = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {}

                    override fun visitPreferenceSetChannelTypeSetting(
                        preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
                    ) {
                        preferenceSetChannelTypeSetting.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Chat && bool == other.bool && preferenceSetChannelTypeSetting == other.preferenceSetChannelTypeSetting /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, preferenceSetChannelTypeSetting) /* spotless:on */

        override fun toString(): String =
            when {
                bool != null -> "Chat{bool=$bool}"
                preferenceSetChannelTypeSetting != null ->
                    "Chat{preferenceSetChannelTypeSetting=$preferenceSetChannelTypeSetting}"
                _json != null -> "Chat{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Chat")
            }

        companion object {

            @JvmStatic fun ofBool(bool: Boolean) = Chat(bool = bool)

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            @JvmStatic
            fun ofPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ) = Chat(preferenceSetChannelTypeSetting = preferenceSetChannelTypeSetting)
        }

        /** An interface that defines how to map each variant of [Chat] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitBool(bool: Boolean): T

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            fun visitPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ): T

            /**
             * Maps an unknown variant of [Chat] to a value of type [T].
             *
             * An instance of [Chat] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Chat: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Chat>(Chat::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Chat {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                    return Chat(bool = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<PreferenceSetChannelTypeSetting>()) {
                        it.validate()
                    }
                    ?.let {
                        return Chat(preferenceSetChannelTypeSetting = it, _json = json)
                    }

                return Chat(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Chat>(Chat::class) {

            override fun serialize(
                value: Chat,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.bool != null -> generator.writeObject(value.bool)
                    value.preferenceSetChannelTypeSetting != null ->
                        generator.writeObject(value.preferenceSetChannelTypeSetting)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Chat")
                }
            }
        }
    }

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     */
    @JsonDeserialize(using = Email.Deserializer::class)
    @JsonSerialize(using = Email.Serializer::class)
    class Email
    private constructor(
        private val bool: Boolean? = null,
        private val preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting? = null,
        private val _json: JsonValue? = null,
    ) {

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun preferenceSetChannelTypeSetting(): Optional<PreferenceSetChannelTypeSetting> =
            Optional.ofNullable(preferenceSetChannelTypeSetting)

        fun isBool(): Boolean = bool != null

        fun isPreferenceSetChannelTypeSetting(): Boolean = preferenceSetChannelTypeSetting != null

        fun asBool(): Boolean = bool.getOrThrow("bool")

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun asPreferenceSetChannelTypeSetting(): PreferenceSetChannelTypeSetting =
            preferenceSetChannelTypeSetting.getOrThrow("preferenceSetChannelTypeSetting")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                bool != null -> visitor.visitBool(bool)
                preferenceSetChannelTypeSetting != null ->
                    visitor.visitPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Email = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {}

                    override fun visitPreferenceSetChannelTypeSetting(
                        preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
                    ) {
                        preferenceSetChannelTypeSetting.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Email && bool == other.bool && preferenceSetChannelTypeSetting == other.preferenceSetChannelTypeSetting /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, preferenceSetChannelTypeSetting) /* spotless:on */

        override fun toString(): String =
            when {
                bool != null -> "Email{bool=$bool}"
                preferenceSetChannelTypeSetting != null ->
                    "Email{preferenceSetChannelTypeSetting=$preferenceSetChannelTypeSetting}"
                _json != null -> "Email{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Email")
            }

        companion object {

            @JvmStatic fun ofBool(bool: Boolean) = Email(bool = bool)

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            @JvmStatic
            fun ofPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ) = Email(preferenceSetChannelTypeSetting = preferenceSetChannelTypeSetting)
        }

        /** An interface that defines how to map each variant of [Email] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitBool(bool: Boolean): T

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            fun visitPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ): T

            /**
             * Maps an unknown variant of [Email] to a value of type [T].
             *
             * An instance of [Email] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Email: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Email>(Email::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Email {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                    return Email(bool = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<PreferenceSetChannelTypeSetting>()) {
                        it.validate()
                    }
                    ?.let {
                        return Email(preferenceSetChannelTypeSetting = it, _json = json)
                    }

                return Email(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Email>(Email::class) {

            override fun serialize(
                value: Email,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.bool != null -> generator.writeObject(value.bool)
                    value.preferenceSetChannelTypeSetting != null ->
                        generator.writeObject(value.preferenceSetChannelTypeSetting)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Email")
                }
            }
        }
    }

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     */
    @JsonDeserialize(using = Http.Deserializer::class)
    @JsonSerialize(using = Http.Serializer::class)
    class Http
    private constructor(
        private val bool: Boolean? = null,
        private val preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting? = null,
        private val _json: JsonValue? = null,
    ) {

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun preferenceSetChannelTypeSetting(): Optional<PreferenceSetChannelTypeSetting> =
            Optional.ofNullable(preferenceSetChannelTypeSetting)

        fun isBool(): Boolean = bool != null

        fun isPreferenceSetChannelTypeSetting(): Boolean = preferenceSetChannelTypeSetting != null

        fun asBool(): Boolean = bool.getOrThrow("bool")

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun asPreferenceSetChannelTypeSetting(): PreferenceSetChannelTypeSetting =
            preferenceSetChannelTypeSetting.getOrThrow("preferenceSetChannelTypeSetting")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                bool != null -> visitor.visitBool(bool)
                preferenceSetChannelTypeSetting != null ->
                    visitor.visitPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Http = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {}

                    override fun visitPreferenceSetChannelTypeSetting(
                        preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
                    ) {
                        preferenceSetChannelTypeSetting.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Http && bool == other.bool && preferenceSetChannelTypeSetting == other.preferenceSetChannelTypeSetting /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, preferenceSetChannelTypeSetting) /* spotless:on */

        override fun toString(): String =
            when {
                bool != null -> "Http{bool=$bool}"
                preferenceSetChannelTypeSetting != null ->
                    "Http{preferenceSetChannelTypeSetting=$preferenceSetChannelTypeSetting}"
                _json != null -> "Http{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Http")
            }

        companion object {

            @JvmStatic fun ofBool(bool: Boolean) = Http(bool = bool)

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            @JvmStatic
            fun ofPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ) = Http(preferenceSetChannelTypeSetting = preferenceSetChannelTypeSetting)
        }

        /** An interface that defines how to map each variant of [Http] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitBool(bool: Boolean): T

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            fun visitPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ): T

            /**
             * Maps an unknown variant of [Http] to a value of type [T].
             *
             * An instance of [Http] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Http: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Http>(Http::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Http {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                    return Http(bool = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<PreferenceSetChannelTypeSetting>()) {
                        it.validate()
                    }
                    ?.let {
                        return Http(preferenceSetChannelTypeSetting = it, _json = json)
                    }

                return Http(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Http>(Http::class) {

            override fun serialize(
                value: Http,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.bool != null -> generator.writeObject(value.bool)
                    value.preferenceSetChannelTypeSetting != null ->
                        generator.writeObject(value.preferenceSetChannelTypeSetting)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Http")
                }
            }
        }
    }

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     */
    @JsonDeserialize(using = InAppFeed.Deserializer::class)
    @JsonSerialize(using = InAppFeed.Serializer::class)
    class InAppFeed
    private constructor(
        private val bool: Boolean? = null,
        private val preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting? = null,
        private val _json: JsonValue? = null,
    ) {

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun preferenceSetChannelTypeSetting(): Optional<PreferenceSetChannelTypeSetting> =
            Optional.ofNullable(preferenceSetChannelTypeSetting)

        fun isBool(): Boolean = bool != null

        fun isPreferenceSetChannelTypeSetting(): Boolean = preferenceSetChannelTypeSetting != null

        fun asBool(): Boolean = bool.getOrThrow("bool")

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun asPreferenceSetChannelTypeSetting(): PreferenceSetChannelTypeSetting =
            preferenceSetChannelTypeSetting.getOrThrow("preferenceSetChannelTypeSetting")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                bool != null -> visitor.visitBool(bool)
                preferenceSetChannelTypeSetting != null ->
                    visitor.visitPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): InAppFeed = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {}

                    override fun visitPreferenceSetChannelTypeSetting(
                        preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
                    ) {
                        preferenceSetChannelTypeSetting.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is InAppFeed && bool == other.bool && preferenceSetChannelTypeSetting == other.preferenceSetChannelTypeSetting /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, preferenceSetChannelTypeSetting) /* spotless:on */

        override fun toString(): String =
            when {
                bool != null -> "InAppFeed{bool=$bool}"
                preferenceSetChannelTypeSetting != null ->
                    "InAppFeed{preferenceSetChannelTypeSetting=$preferenceSetChannelTypeSetting}"
                _json != null -> "InAppFeed{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid InAppFeed")
            }

        companion object {

            @JvmStatic fun ofBool(bool: Boolean) = InAppFeed(bool = bool)

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            @JvmStatic
            fun ofPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ) = InAppFeed(preferenceSetChannelTypeSetting = preferenceSetChannelTypeSetting)
        }

        /**
         * An interface that defines how to map each variant of [InAppFeed] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitBool(bool: Boolean): T

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            fun visitPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ): T

            /**
             * Maps an unknown variant of [InAppFeed] to a value of type [T].
             *
             * An instance of [InAppFeed] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown InAppFeed: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<InAppFeed>(InAppFeed::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): InAppFeed {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                    return InAppFeed(bool = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<PreferenceSetChannelTypeSetting>()) {
                        it.validate()
                    }
                    ?.let {
                        return InAppFeed(preferenceSetChannelTypeSetting = it, _json = json)
                    }

                return InAppFeed(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<InAppFeed>(InAppFeed::class) {

            override fun serialize(
                value: InAppFeed,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.bool != null -> generator.writeObject(value.bool)
                    value.preferenceSetChannelTypeSetting != null ->
                        generator.writeObject(value.preferenceSetChannelTypeSetting)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid InAppFeed")
                }
            }
        }
    }

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     */
    @JsonDeserialize(using = Push.Deserializer::class)
    @JsonSerialize(using = Push.Serializer::class)
    class Push
    private constructor(
        private val bool: Boolean? = null,
        private val preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting? = null,
        private val _json: JsonValue? = null,
    ) {

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun preferenceSetChannelTypeSetting(): Optional<PreferenceSetChannelTypeSetting> =
            Optional.ofNullable(preferenceSetChannelTypeSetting)

        fun isBool(): Boolean = bool != null

        fun isPreferenceSetChannelTypeSetting(): Boolean = preferenceSetChannelTypeSetting != null

        fun asBool(): Boolean = bool.getOrThrow("bool")

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun asPreferenceSetChannelTypeSetting(): PreferenceSetChannelTypeSetting =
            preferenceSetChannelTypeSetting.getOrThrow("preferenceSetChannelTypeSetting")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                bool != null -> visitor.visitBool(bool)
                preferenceSetChannelTypeSetting != null ->
                    visitor.visitPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Push = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {}

                    override fun visitPreferenceSetChannelTypeSetting(
                        preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
                    ) {
                        preferenceSetChannelTypeSetting.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Push && bool == other.bool && preferenceSetChannelTypeSetting == other.preferenceSetChannelTypeSetting /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, preferenceSetChannelTypeSetting) /* spotless:on */

        override fun toString(): String =
            when {
                bool != null -> "Push{bool=$bool}"
                preferenceSetChannelTypeSetting != null ->
                    "Push{preferenceSetChannelTypeSetting=$preferenceSetChannelTypeSetting}"
                _json != null -> "Push{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Push")
            }

        companion object {

            @JvmStatic fun ofBool(bool: Boolean) = Push(bool = bool)

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            @JvmStatic
            fun ofPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ) = Push(preferenceSetChannelTypeSetting = preferenceSetChannelTypeSetting)
        }

        /** An interface that defines how to map each variant of [Push] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitBool(bool: Boolean): T

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            fun visitPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ): T

            /**
             * Maps an unknown variant of [Push] to a value of type [T].
             *
             * An instance of [Push] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Push: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Push>(Push::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Push {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                    return Push(bool = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<PreferenceSetChannelTypeSetting>()) {
                        it.validate()
                    }
                    ?.let {
                        return Push(preferenceSetChannelTypeSetting = it, _json = json)
                    }

                return Push(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Push>(Push::class) {

            override fun serialize(
                value: Push,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.bool != null -> generator.writeObject(value.bool)
                    value.preferenceSetChannelTypeSetting != null ->
                        generator.writeObject(value.preferenceSetChannelTypeSetting)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Push")
                }
            }
        }
    }

    /**
     * A set of settings for a channel type. Currently, this can only be a list of conditions to
     * apply.
     */
    @JsonDeserialize(using = Sms.Deserializer::class)
    @JsonSerialize(using = Sms.Serializer::class)
    class Sms
    private constructor(
        private val bool: Boolean? = null,
        private val preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting? = null,
        private val _json: JsonValue? = null,
    ) {

        fun bool(): Optional<Boolean> = Optional.ofNullable(bool)

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun preferenceSetChannelTypeSetting(): Optional<PreferenceSetChannelTypeSetting> =
            Optional.ofNullable(preferenceSetChannelTypeSetting)

        fun isBool(): Boolean = bool != null

        fun isPreferenceSetChannelTypeSetting(): Boolean = preferenceSetChannelTypeSetting != null

        fun asBool(): Boolean = bool.getOrThrow("bool")

        /**
         * A set of settings for a channel type. Currently, this can only be a list of conditions to
         * apply.
         */
        fun asPreferenceSetChannelTypeSetting(): PreferenceSetChannelTypeSetting =
            preferenceSetChannelTypeSetting.getOrThrow("preferenceSetChannelTypeSetting")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                bool != null -> visitor.visitBool(bool)
                preferenceSetChannelTypeSetting != null ->
                    visitor.visitPreferenceSetChannelTypeSetting(preferenceSetChannelTypeSetting)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Sms = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitBool(bool: Boolean) {}

                    override fun visitPreferenceSetChannelTypeSetting(
                        preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
                    ) {
                        preferenceSetChannelTypeSetting.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Sms && bool == other.bool && preferenceSetChannelTypeSetting == other.preferenceSetChannelTypeSetting /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(bool, preferenceSetChannelTypeSetting) /* spotless:on */

        override fun toString(): String =
            when {
                bool != null -> "Sms{bool=$bool}"
                preferenceSetChannelTypeSetting != null ->
                    "Sms{preferenceSetChannelTypeSetting=$preferenceSetChannelTypeSetting}"
                _json != null -> "Sms{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Sms")
            }

        companion object {

            @JvmStatic fun ofBool(bool: Boolean) = Sms(bool = bool)

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            @JvmStatic
            fun ofPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ) = Sms(preferenceSetChannelTypeSetting = preferenceSetChannelTypeSetting)
        }

        /** An interface that defines how to map each variant of [Sms] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitBool(bool: Boolean): T

            /**
             * A set of settings for a channel type. Currently, this can only be a list of
             * conditions to apply.
             */
            fun visitPreferenceSetChannelTypeSetting(
                preferenceSetChannelTypeSetting: PreferenceSetChannelTypeSetting
            ): T

            /**
             * Maps an unknown variant of [Sms] to a value of type [T].
             *
             * An instance of [Sms] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws KnockInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw KnockInvalidDataException("Unknown Sms: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Sms>(Sms::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Sms {
                val json = JsonValue.fromJsonNode(node)

                tryDeserialize(node, jacksonTypeRef<Boolean>())?.let {
                    return Sms(bool = it, _json = json)
                }
                tryDeserialize(node, jacksonTypeRef<PreferenceSetChannelTypeSetting>()) {
                        it.validate()
                    }
                    ?.let {
                        return Sms(preferenceSetChannelTypeSetting = it, _json = json)
                    }

                return Sms(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Sms>(Sms::class) {

            override fun serialize(
                value: Sms,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.bool != null -> generator.writeObject(value.bool)
                    value.preferenceSetChannelTypeSetting != null ->
                        generator.writeObject(value.preferenceSetChannelTypeSetting)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Sms")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is PreferenceSetChannelTypes && chat == other.chat && email == other.email && http == other.http && inAppFeed == other.inAppFeed && push == other.push && sms == other.sms && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(chat, email, http, inAppFeed, push, sms, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "PreferenceSetChannelTypes{chat=$chat, email=$email, http=$http, inAppFeed=$inAppFeed, push=$push, sms=$sms, additionalProperties=$additionalProperties}"
}
