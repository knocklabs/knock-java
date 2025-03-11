// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.audiences

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
import com.knock.api.models.users.User
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A user belonging to an audience */
@NoAutoDetect
class AudienceMember @JsonCreator private constructor(
    @JsonProperty("__typename") @ExcludeMissing private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("added_at") @ExcludeMissing private val addedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("user") @ExcludeMissing private val user: JsonField<User> = JsonMissing.of(),
    @JsonProperty("user_id") @ExcludeMissing private val userId: JsonField<String> = JsonMissing.of(),
    @JsonProperty("tenant") @ExcludeMissing private val tenant: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

) {

    fun _typename(): String = _typename.getRequired("__typename")

    fun addedAt(): OffsetDateTime = addedAt.getRequired("added_at")

    /** A user object */
    fun user(): User = user.getRequired("user")

    fun userId(): String = userId.getRequired("user_id")

    fun tenant(): Optional<String> = Optional.ofNullable(tenant.getNullable("tenant"))

    @JsonProperty("__typename")
    @ExcludeMissing
    fun __typename(): JsonField<String> = _typename

    @JsonProperty("added_at")
    @ExcludeMissing
    fun _addedAt(): JsonField<OffsetDateTime> = addedAt

    /** A user object */
    @JsonProperty("user")
    @ExcludeMissing
    fun _user(): JsonField<User> = user

    @JsonProperty("user_id")
    @ExcludeMissing
    fun _userId(): JsonField<String> = userId

    @JsonProperty("tenant")
    @ExcludeMissing
    fun _tenant(): JsonField<String> = tenant

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): AudienceMember =
        apply {
            if (validated) {
              return@apply
            }

            _typename()
            addedAt()
            user().validate()
            userId()
            tenant()
            validated = true
        }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AudienceMember].
         *
         * The following fields are required:
         *
         * ```java
         * ._typename()
         * .addedAt()
         * .user()
         * .userId()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [AudienceMember]. */
    class Builder internal constructor() {

        private var _typename: JsonField<String>? = null
        private var addedAt: JsonField<OffsetDateTime>? = null
        private var user: JsonField<User>? = null
        private var userId: JsonField<String>? = null
        private var tenant: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(audienceMember: AudienceMember) =
            apply {
                _typename = audienceMember._typename
                addedAt = audienceMember.addedAt
                user = audienceMember.user
                userId = audienceMember.userId
                tenant = audienceMember.tenant
                additionalProperties = audienceMember.additionalProperties.toMutableMap()
            }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) =
            apply {
                this._typename = _typename
            }

        fun addedAt(addedAt: OffsetDateTime) = addedAt(JsonField.of(addedAt))

        fun addedAt(addedAt: JsonField<OffsetDateTime>) =
            apply {
                this.addedAt = addedAt
            }

        /** A user object */
        fun user(user: User) = user(JsonField.of(user))

        /** A user object */
        fun user(user: JsonField<User>) =
            apply {
                this.user = user
            }

        fun userId(userId: String) = userId(JsonField.of(userId))

        fun userId(userId: JsonField<String>) =
            apply {
                this.userId = userId
            }

        fun tenant(tenant: String?) = tenant(JsonField.ofNullable(tenant))

        fun tenant(tenant: Optional<String>) = tenant(tenant.getOrNull())

        fun tenant(tenant: JsonField<String>) =
            apply {
                this.tenant = tenant
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

        fun build(): AudienceMember =
            AudienceMember(
              checkRequired(
                "_typename", _typename
              ),
              checkRequired(
                "addedAt", addedAt
              ),
              checkRequired(
                "user", user
              ),
              checkRequired(
                "userId", userId
              ),
              tenant,
              additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is AudienceMember && _typename == other._typename && addedAt == other.addedAt && user == other.user && userId == other.userId && tenant == other.tenant && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(_typename, addedAt, user, userId, tenant, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() = "AudienceMember{_typename=$_typename, addedAt=$addedAt, user=$user, userId=$userId, tenant=$tenant, additionalProperties=$additionalProperties}"
}
