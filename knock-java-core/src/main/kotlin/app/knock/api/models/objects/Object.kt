// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.objects

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.checkRequired
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A custom-object entity which belongs to a collection. */
@NoAutoDetect
class Object @JsonCreator private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("__typename") @ExcludeMissing private val _typename: JsonField<String> = JsonMissing.of(),
    @JsonProperty("collection") @ExcludeMissing private val collection: JsonField<String> = JsonMissing.of(),
    @JsonProperty("updated_at") @ExcludeMissing private val updatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonProperty("created_at") @ExcludeMissing private val createdAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

) {

    fun id(): String = id.getRequired("id")

    fun _typename(): String = _typename.getRequired("__typename")

    fun collection(): String = collection.getRequired("collection")

    fun updatedAt(): OffsetDateTime = updatedAt.getRequired("updated_at")

    fun createdAt(): Optional<OffsetDateTime> = Optional.ofNullable(createdAt.getNullable("created_at"))

    @JsonProperty("id")
    @ExcludeMissing
    fun _id(): JsonField<String> = id

    @JsonProperty("__typename")
    @ExcludeMissing
    fun __typename(): JsonField<String> = _typename

    @JsonProperty("collection")
    @ExcludeMissing
    fun _collection(): JsonField<String> = collection

    @JsonProperty("updated_at")
    @ExcludeMissing
    fun _updatedAt(): JsonField<OffsetDateTime> = updatedAt

    @JsonProperty("created_at")
    @ExcludeMissing
    fun _createdAt(): JsonField<OffsetDateTime> = createdAt

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Object =
        apply {
            if (validated) {
              return@apply
            }

            id()
            _typename()
            collection()
            updatedAt()
            createdAt()
            validated = true
        }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [Object].
         *
         * The following fields are required:
         *
         * ```java
         * .id()
         * ._typename()
         * .collection()
         * .updatedAt()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [Object]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var _typename: JsonField<String>? = null
        private var collection: JsonField<String>? = null
        private var updatedAt: JsonField<OffsetDateTime>? = null
        private var createdAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(object_: Object) =
            apply {
                id = object_.id
                _typename = object_._typename
                collection = object_.collection
                updatedAt = object_.updatedAt
                createdAt = object_.createdAt
                additionalProperties = object_.additionalProperties.toMutableMap()
            }

        fun id(id: String) = id(JsonField.of(id))

        fun id(id: JsonField<String>) =
            apply {
                this.id = id
            }

        fun _typename(_typename: String) = _typename(JsonField.of(_typename))

        fun _typename(_typename: JsonField<String>) =
            apply {
                this._typename = _typename
            }

        fun collection(collection: String) = collection(JsonField.of(collection))

        fun collection(collection: JsonField<String>) =
            apply {
                this.collection = collection
            }

        fun updatedAt(updatedAt: OffsetDateTime) = updatedAt(JsonField.of(updatedAt))

        fun updatedAt(updatedAt: JsonField<OffsetDateTime>) =
            apply {
                this.updatedAt = updatedAt
            }

        fun createdAt(createdAt: OffsetDateTime?) = createdAt(JsonField.ofNullable(createdAt))

        fun createdAt(createdAt: Optional<OffsetDateTime>) = createdAt(createdAt.getOrNull())

        fun createdAt(createdAt: JsonField<OffsetDateTime>) =
            apply {
                this.createdAt = createdAt
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

        fun build(): Object =
            Object(
              checkRequired(
                "id", id
              ),
              checkRequired(
                "_typename", _typename
              ),
              checkRequired(
                "collection", collection
              ),
              checkRequired(
                "updatedAt", updatedAt
              ),
              createdAt,
              additionalProperties.toImmutable(),
            )
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is Object && id == other.id && _typename == other._typename && collection == other.collection && updatedAt == other.updatedAt && createdAt == other.createdAt && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, _typename, collection, updatedAt, createdAt, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() = "Object{id=$id, _typename=$_typename, collection=$collection, updatedAt=$updatedAt, createdAt=$createdAt, additionalProperties=$additionalProperties}"
}
