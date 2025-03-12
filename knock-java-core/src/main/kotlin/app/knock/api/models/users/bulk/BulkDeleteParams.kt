// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.bulk

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.Params
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.http.Headers
import app.knock.api.core.http.QueryParams
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects

/** Bulk delete users */
class BulkDeleteParams private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,

) : Params {

    fun userIds(): List<String> = body.userIds()

    fun _userIds(): JsonField<List<String>> = body._userIds()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    @JvmSynthetic
    internal fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** A request to delete users in bulk */
    @NoAutoDetect
    class Body @JsonCreator private constructor(
        @JsonProperty("user_ids") @ExcludeMissing private val userIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        fun userIds(): List<String> = userIds.getRequired("user_ids")

        @JsonProperty("user_ids")
        @ExcludeMissing
        fun _userIds(): JsonField<List<String>> = userIds

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Body =
            apply {
                if (validated) {
                  return@apply
                }

                userIds()
                validated = true
            }

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             *
             * ```java
             * .userIds()
             * ```
             */
            @JvmStatic
            fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var userIds: JsonField<MutableList<String>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) =
                apply {
                    userIds = body.userIds.map { it.toMutableList() }
                    additionalProperties = body.additionalProperties.toMutableMap()
                }

            fun userIds(userIds: List<String>) = userIds(JsonField.of(userIds))

            fun userIds(userIds: JsonField<List<String>>) =
                apply {
                    this.userIds = userIds.map { it.toMutableList() }
                }

            fun addUserId(userId: String) =
                apply {
                    userIds = (userIds ?: JsonField.of(mutableListOf())).also {
                        checkKnown("userIds", it).add(userId)
                    }
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

            fun build(): Body =
                Body(
                  checkRequired(
                    "userIds", userIds
                  ).map { it.toImmutable() }, additionalProperties.toImmutable()
                )
        }

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return /* spotless:off */ other is Body && userIds == other.userIds && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(userIds, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Body{userIds=$userIds, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BulkDeleteParams].
         *
         * The following fields are required:
         *
         * ```java
         * .userIds()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [BulkDeleteParams]. */
    @NoAutoDetect
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(bulkDeleteParams: BulkDeleteParams) =
            apply {
                body = bulkDeleteParams.body.toBuilder()
                additionalHeaders = bulkDeleteParams.additionalHeaders.toBuilder()
                additionalQueryParams = bulkDeleteParams.additionalQueryParams.toBuilder()
            }

        fun userIds(userIds: List<String>) =
            apply {
                body.userIds(userIds)
            }

        fun userIds(userIds: JsonField<List<String>>) =
            apply {
                body.userIds(userIds)
            }

        fun addUserId(userId: String) =
            apply {
                body.addUserId(userId)
            }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.additionalProperties(additionalBodyProperties)
            }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) =
            apply {
                body.putAdditionalProperty(
                  key, value
                )
            }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) =
            apply {
                body.removeAdditionalProperty(key)
            }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) =
            apply {
                body.removeAllAdditionalProperties(keys)
            }

        fun additionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.clear()
                putAllAdditionalHeaders(additionalHeaders)
            }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.clear()
                putAllAdditionalHeaders(additionalHeaders)
            }

        fun putAdditionalHeader(name: String, value: String) =
            apply {
                additionalHeaders.put(name, value)
            }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) =
            apply {
                additionalHeaders.put(name, values)
            }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.putAll(additionalHeaders)
            }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.putAll(additionalHeaders)
            }

        fun replaceAdditionalHeaders(name: String, value: String) =
            apply {
                additionalHeaders.replace(name, value)
            }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) =
            apply {
                additionalHeaders.replace(name, values)
            }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) =
            apply {
                this.additionalHeaders.replaceAll(additionalHeaders)
            }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) =
            apply {
                this.additionalHeaders.replaceAll(additionalHeaders)
            }

        fun removeAdditionalHeaders(name: String) =
            apply {
                additionalHeaders.remove(name)
            }

        fun removeAllAdditionalHeaders(names: Set<String>) =
            apply {
                additionalHeaders.removeAll(names)
            }

        fun additionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.clear()
                putAllAdditionalQueryParams(additionalQueryParams)
            }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.clear()
                putAllAdditionalQueryParams(additionalQueryParams)
            }

        fun putAdditionalQueryParam(key: String, value: String) =
            apply {
                additionalQueryParams.put(key, value)
            }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) =
            apply {
                additionalQueryParams.put(key, values)
            }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) =
            apply {
                additionalQueryParams.replace(key, value)
            }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) =
            apply {
                additionalQueryParams.replace(key, values)
            }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) =
            apply {
                additionalQueryParams.remove(key)
            }

        fun removeAllAdditionalQueryParams(keys: Set<String>) =
            apply {
                additionalQueryParams.removeAll(keys)
            }

        fun build(): BulkDeleteParams =
            BulkDeleteParams(
              body.build(),
              additionalHeaders.build(),
              additionalQueryParams.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is BulkDeleteParams && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() = "BulkDeleteParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
