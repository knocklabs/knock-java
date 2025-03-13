// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import app.knock.api.models
import app.knock.api.models.messages.Message
import app.knock.api.services.blocking.UserService
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List messages */
class UserListMessagesPage private constructor(
    private val usersService: UserService,
    private val params: UserListMessagesParams,
    private val response: Response,

) {

    fun response(): Response = response

    fun entries(): List<Message> = response().entries()

    fun pageInfo(): Optional<PageInfo> = response().pageInfo()

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is UserListMessagesPage && usersService == other.usersService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(usersService, params, response) /* spotless:on */

    override fun toString() = "UserListMessagesPage{usersService=$usersService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
      if (entries().isEmpty()) {
        return false;
      }

      return pageInfo().flatMap { it.after()}.isPresent
    }

    fun getNextPageParams(): Optional<UserListMessagesParams> {
      if (!hasNextPage()) {
        return Optional.empty()
      }

      return Optional.of(UserListMessagesParams.builder().from(params).apply {pageInfo().flatMap { it.after()}.ifPresent{ this.after(it) } }.build())
    }

    fun getNextPage(): Optional<UserListMessagesPage> {
      return getNextPageParams().map { usersService.listMessages(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(usersService: UserService, params: UserListMessagesParams, response: Response) =
            UserListMessagesPage(
              usersService,
              params,
              response,
            )
    }

    @NoAutoDetect
    class Response @JsonCreator constructor(
        @JsonProperty("entries") private val entries: JsonField<List<Message>> = JsonMissing.of(),
        @JsonProperty("page_info") private val pageInfo: JsonField<PageInfo> = JsonMissing.of(),
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        fun entries(): List<Message> = entries.getNullable("entries") ?: listOf()

        fun pageInfo(): Optional<PageInfo> = Optional.ofNullable(pageInfo.getNullable("page_info"))

        @JsonProperty("entries")
        fun _entries(): Optional<JsonField<List<Message>>> = Optional.ofNullable(entries)

        @JsonProperty("page_info")
        fun _pageInfo(): Optional<JsonField<PageInfo>> = Optional.ofNullable(pageInfo)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Response =
            apply {
                if (validated) {
                  return@apply
                }

                entries().map { it.validate() }
                pageInfo().ifPresent { it.validate() }
                validated = true
            }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
          if (this === other) {
              return true
          }

          return /* spotless:off */ other is Response && entries == other.entries && pageInfo == other.pageInfo && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(entries, pageInfo, additionalProperties) /* spotless:on */

        override fun toString() = "Response{entries=$entries, pageInfo=$pageInfo, additionalProperties=$additionalProperties}"

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of
             * [UserListMessagesPage].
             */
            @JvmStatic
            fun builder() = Builder()
        }

        class Builder {

            private var entries: JsonField<List<Message>> = JsonMissing.of()
            private var pageInfo: JsonField<PageInfo> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) =
                apply {
                    this.entries = page.entries
                    this.pageInfo = page.pageInfo
                    this.additionalProperties.putAll(page.additionalProperties)
                }

            fun entries(entries: List<Message>) = entries(JsonField.of(entries))

            fun entries(entries: JsonField<List<Message>>) = apply { this.entries = entries }

            fun pageInfo(pageInfo: PageInfo) = pageInfo(JsonField.of(pageInfo))

            fun pageInfo(pageInfo: JsonField<PageInfo>) = apply { this.pageInfo = pageInfo }

            fun putAdditionalProperty(key: String, value: JsonValue) =
                apply {
                    this.additionalProperties.put(key, value)
                }

            fun build() =
                Response(
                  entries,
                  pageInfo,
                  additionalProperties.toImmutable(),
                )
        }
    }

    class AutoPager(
        private val firstPage: UserListMessagesPage,

    ) : Iterable<Message> {

        override fun iterator(): Iterator<Message> =
            iterator {
                var page = firstPage
                var index = 0
                while (true) {
                  while (index < page.entries().size) {
                    yield(page.entries()[index++])
                  }
                  page = page.getNextPage().getOrNull() ?: break
                  index = 0
                }
            }

        fun stream(): Stream<Message> {
          return StreamSupport.stream(spliterator(), false)
        }
    }
}
