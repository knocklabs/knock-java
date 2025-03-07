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
import com.knock.api.core.immutableEmptyMap
import com.knock.api.core.toImmutable
import com.knock.api.services.blocking.MessageService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport

/** List activities */
class MessageListActivitiesPage
private constructor(
    private val messagesService: MessageService,
    private val params: MessageListActivitiesParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun items(): List<MessageListActivitiesResponse> = response().items()

    fun pageInfo(): Optional<PageInfo> = response().pageInfo()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListActivitiesPage && messagesService == other.messagesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(messagesService, params, response) /* spotless:on */

    override fun toString() =
        "MessageListActivitiesPage{messagesService=$messagesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        if (items().isEmpty()) {
            return false
        }

        return pageInfo().flatMap { it.after() }.isPresent
    }

    fun getNextPageParams(): Optional<MessageListActivitiesParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            MessageListActivitiesParams.builder()
                .from(params)
                .apply { pageInfo().flatMap { it.after() }.ifPresent { this.after(it) } }
                .build()
        )
    }

    fun getNextPage(): Optional<MessageListActivitiesPage> {
        return getNextPageParams().map { messagesService.listActivities(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            messagesService: MessageService,
            params: MessageListActivitiesParams,
            response: Response,
        ) = MessageListActivitiesPage(messagesService, params, response)
    }

    @NoAutoDetect
    class Response
    @JsonCreator
    constructor(
        @JsonProperty("items")
        private val items: JsonField<List<MessageListActivitiesResponse>> = JsonMissing.of(),
        @JsonProperty("page_info") private val pageInfo: JsonField<PageInfo> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        fun items(): List<MessageListActivitiesResponse> = items.getNullable("items") ?: listOf()

        fun pageInfo(): Optional<PageInfo> = Optional.ofNullable(pageInfo.getNullable("page_info"))

        @JsonProperty("items")
        fun _items(): Optional<JsonField<List<MessageListActivitiesResponse>>> =
            Optional.ofNullable(items)

        @JsonProperty("page_info")
        fun _pageInfo(): Optional<JsonField<PageInfo>> = Optional.ofNullable(pageInfo)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Response = apply {
            if (validated) {
                return@apply
            }

            items().map { it.validate() }
            pageInfo().ifPresent { it.validate() }
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Response && items == other.items && pageInfo == other.pageInfo && additionalProperties == other.additionalProperties /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(items, pageInfo, additionalProperties) /* spotless:on */

        override fun toString() =
            "Response{items=$items, pageInfo=$pageInfo, additionalProperties=$additionalProperties}"

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of
             * [MessageListActivitiesPage].
             */
            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var items: JsonField<List<MessageListActivitiesResponse>> = JsonMissing.of()
            private var pageInfo: JsonField<PageInfo> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.items = page.items
                this.pageInfo = page.pageInfo
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun items(items: List<MessageListActivitiesResponse>) = items(JsonField.of(items))

            fun items(items: JsonField<List<MessageListActivitiesResponse>>) = apply {
                this.items = items
            }

            fun pageInfo(pageInfo: PageInfo) = pageInfo(JsonField.of(pageInfo))

            fun pageInfo(pageInfo: JsonField<PageInfo>) = apply { this.pageInfo = pageInfo }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() = Response(items, pageInfo, additionalProperties.toImmutable())
        }
    }

    class AutoPager(private val firstPage: MessageListActivitiesPage) :
        Iterable<MessageListActivitiesResponse> {

        override fun iterator(): Iterator<MessageListActivitiesResponse> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.items().size) {
                    yield(page.items()[index++])
                }
                page = page.getNextPage().orElse(null) ?: break
                index = 0
            }
        }

        fun stream(): Stream<MessageListActivitiesResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
