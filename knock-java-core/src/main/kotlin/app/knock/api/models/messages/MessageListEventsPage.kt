// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.models.PageInfo
import app.knock.api.services.blocking.MessageService
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** List events */
class MessageListEventsPage
private constructor(
    private val messagesService: MessageService,
    private val params: MessageListEventsParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun entries(): List<MessageEvent> = response().entries()

    fun pageInfo(): Optional<PageInfo> = response().pageInfo()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListEventsPage && messagesService == other.messagesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messagesService, params, response) /* spotless:on */

    override fun toString() =
        "MessageListEventsPage{messagesService=$messagesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        if (entries().isEmpty()) {
            return false
        }

        return pageInfo().flatMap { it.after() }.isPresent
    }

    fun getNextPageParams(): Optional<MessageListEventsParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            MessageListEventsParams.builder()
                .from(params)
                .apply { pageInfo().flatMap { it.after() }.ifPresent { this.after(it) } }
                .build()
        )
    }

    fun getNextPage(): Optional<MessageListEventsPage> {
        return getNextPageParams().map { messagesService.listEvents(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            messagesService: MessageService,
            params: MessageListEventsParams,
            response: Response,
        ) = MessageListEventsPage(messagesService, params, response)
    }

    class Response(
        private val entries: JsonField<List<MessageEvent>>,
        private val pageInfo: JsonField<PageInfo>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("entries") entries: JsonField<List<MessageEvent>> = JsonMissing.of(),
            @JsonProperty("page_info") pageInfo: JsonField<PageInfo> = JsonMissing.of(),
        ) : this(entries, pageInfo, mutableMapOf())

        fun entries(): List<MessageEvent> = entries.getNullable("entries") ?: listOf()

        fun pageInfo(): Optional<PageInfo> = Optional.ofNullable(pageInfo.getNullable("page_info"))

        @JsonProperty("entries")
        fun _entries(): Optional<JsonField<List<MessageEvent>>> = Optional.ofNullable(entries)

        @JsonProperty("page_info")
        fun _pageInfo(): Optional<JsonField<PageInfo>> = Optional.ofNullable(pageInfo)

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        private var validated: Boolean = false

        fun validate(): Response = apply {
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

        override fun toString() =
            "Response{entries=$entries, pageInfo=$pageInfo, additionalProperties=$additionalProperties}"

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [MessageListEventsPage].
             */
            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var entries: JsonField<List<MessageEvent>> = JsonMissing.of()
            private var pageInfo: JsonField<PageInfo> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.entries = page.entries
                this.pageInfo = page.pageInfo
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun entries(entries: List<MessageEvent>) = entries(JsonField.of(entries))

            fun entries(entries: JsonField<List<MessageEvent>>) = apply { this.entries = entries }

            fun pageInfo(pageInfo: PageInfo) = pageInfo(JsonField.of(pageInfo))

            fun pageInfo(pageInfo: JsonField<PageInfo>) = apply { this.pageInfo = pageInfo }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable instance of [Response].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Response = Response(entries, pageInfo, additionalProperties.toMutableMap())
        }
    }

    class AutoPager(private val firstPage: MessageListEventsPage) : Iterable<MessageEvent> {

        override fun iterator(): Iterator<MessageEvent> = iterator {
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

        fun stream(): Stream<MessageEvent> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
