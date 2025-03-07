// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.knock.api.core.ExcludeMissing
import com.knock.api.core.JsonField
import com.knock.api.core.JsonMissing
import com.knock.api.core.JsonValue
import com.knock.api.core.NoAutoDetect
import com.knock.api.core.checkRequired
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/** A user object */
@NoAutoDetect
class User
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("__typename")
    @ExcludeMissing
    private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("updated_at")
    @ExcludeMissing
    private val updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("avatar")
    @ExcludeMissing
    private val avatar: JsonField<String> = JsonMissing.of(),
    @JsonProperty("created_at")
    @ExcludeMissing
    private val createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("email") @ExcludeMissing private val email: JsonField<String> = JsonMissing.of(),
    @JsonProperty("name") @ExcludeMissing private val name: JsonField<String> = JsonMissing.of(),
    @JsonProperty("phone_number")
    @ExcludeMissing
    private val phoneNumber: JsonField<String> = JsonMissing.of(),
    @JsonProperty("timezone")
    @ExcludeMissing
    private val timezone: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    fun id(): String = id.getRequired("id")

    fun _typename(): String = _typename.getRequired("__typename")

    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

    fun avatar(): Optional<String> = Optional.ofNullable(avatar.getNullable("avatar"))

    fun createdAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(createdAt.getNullable("created_at"))

    fun email(): Optional<String> = Optional.ofNullable(email.getNullable("email"))

    fun name(): Optional<String> = Optional.ofNullable(name.getNullable("name"))

    fun phoneNumber(): Optional<String> =
        Optional.ofNullable(phoneNumber.getNullable("phone_number"))

    fun timezone(): Optional<String> = Optional.ofNullable(timezone.getNullable("timezone"))

    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    @JsonProperty("__typename") @ExcludeMissing fun __typename(): JsonField<String> = _typename

    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    @JsonProperty("avatar") @ExcludeMissing fun _avatar(): JsonField<String> = avatar

    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

    @JsonProperty("phone_number")
    @ExcludeMissing
    fun _phoneNumber(): JsonField<String> = phoneNumber

    @JsonProperty("timezone") @ExcludeMissing fun _timezone(): JsonField<String> = timezone

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): User = apply {
        if (validated) {
            return@apply
        }

        id()
        _typename()
        updatedAt()
        avatar()
        createdAt()
        email()
        name()
        phoneNumber()
        timezone()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [User].
         *
         * The following fields are required:
         * ```java
         * .id()
         * ._typename()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [User]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var _typename: JsonField<String>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var avatar: JsonField<String> = JsonMissing.of()
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var name: JsonField<String> = JsonMissing.of()
        private var phoneNumber: JsonField<String> = JsonMissing.of()
        private var timezone: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(user: User) = apply {
            id = user.id
            _typename = user._typename
            updatedAt = user.updatedAt
            avatar = user.avatar
            createdAt = user.createdAt
            email = user.email
            name = user.name
            phoneNumber = user.phoneNumber
            timezone = user.timezone
            additionalProperties = user.additionalProperties.toMutableMap()
        }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) = apply { this.id = id }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) = apply { this._typename = _typename }

        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) = apply { this.updatedAt = updatedAt }

        fun avatar(avatar: String?) = avatar(JsonField.ofNullable(avatar))

        fun avatar(avatar: Optional<String>) = avatar(avatar.orElse(null))

        fun avatar(avatar: JsonField<String>) = apply { this.avatar = avatar }

        fun createdAt(createdAt: OffsetDateTime?) = createdAt(JsonField.ofNullable(createdAt))

        fun createdAt(createdAt: Optional<OffsetDateTime>) = createdAt(createdAt.orElse(null))

        fun createdAt(createdAt: JsonField<OffsetDateTime>) = apply { this.createdAt = createdAt }

        fun email(email: String?) = email(JsonField.ofNullable(email))

        fun email(email: Optional<String>) = email(email.orElse(null))

        fun email(email: JsonField<String>) = apply { this.email = email }

        fun name(name: String?) = name(JsonField.ofNullable(name))

        fun name(name: Optional<String>) = name(name.orElse(null))

        fun name(name: JsonField<String>) = apply { this.name = name }

        fun phoneNumber(phoneNumber: String?) = phoneNumber(JsonField.ofNullable(phoneNumber))

        fun phoneNumber(phoneNumber: Optional<String>) = phoneNumber(phoneNumber.orElse(null))

        fun phoneNumber(phoneNumber: JsonField<String>) = apply { this.phoneNumber = phoneNumber }

        fun timezone(timezone: String?) = timezone(JsonField.ofNullable(timezone))

        fun timezone(timezone: Optional<String>) = timezone(timezone.orElse(null))

        fun timezone(timezone: JsonField<String>) = apply { this.timezone = timezone }

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

        fun build(): User =
            User(
                checkRequired("id", id),
                checkRequired("_typename", _typename),
                checkRequired("updatedAt", updatedAt),
                avatar,
                createdAt,
                email,
                name,
                phoneNumber,
                timezone,
                additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is User && id == other.id && _typename == other._typename && updatedAt == other.updatedAt && avatar == other.avatar && createdAt == other.createdAt && email == other.email && name == other.name && phoneNumber == other.phoneNumber && timezone == other.timezone && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, updatedAt, avatar, createdAt, email, name, phoneNumber, timezone, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "User{id=$id, _typename=$_typename, updatedAt=$updatedAt, avatar=$avatar, createdAt=$createdAt, email=$email, name=$name, phoneNumber=$phoneNumber, timezone=$timezone, additionalProperties=$additionalProperties}"
}
