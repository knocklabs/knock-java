// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.messages

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkKnown
import app.knock.api.core.checkRequired
import app.knock.api.core.toImmutable
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.shared.PageInfo
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** A message delivery log response. */
class MessageListDeliveryLogsPageResponse
private constructor(
    private val items: JsonField<List<MessageDeliveryLog>>,
    private val pageInfo: JsonField<PageInfo>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("items")
        @ExcludeMissing
        items: JsonField<List<MessageDeliveryLog>> = JsonMissing.of(),
        @JsonProperty("page_info") @ExcludeMissing pageInfo: JsonField<PageInfo> = JsonMissing.of(),
    ) : this(items, pageInfo, mutableMapOf())

    /**
     * Returns a paginated list of delivery logs from the downstream provider for the specified
     * message. For Knock in-app channels, the delivery logs will always be an empty list.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun items(): List<MessageDeliveryLog> = items.getRequired("items")

    /**
     * Pagination information for a list of resources.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun pageInfo(): PageInfo = pageInfo.getRequired("page_info")

    /**
     * Returns the raw JSON value of [items].
     *
     * Unlike [items], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("items") @ExcludeMissing fun _items(): JsonField<List<MessageDeliveryLog>> = items

    /**
     * Returns the raw JSON value of [pageInfo].
     *
     * Unlike [pageInfo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("page_info") @ExcludeMissing fun _pageInfo(): JsonField<PageInfo> = pageInfo

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
         * Returns a mutable builder for constructing an instance of
         * [MessageListDeliveryLogsPageResponse].
         *
         * The following fields are required:
         * ```java
         * .items()
         * .pageInfo()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageListDeliveryLogsPageResponse]. */
    class Builder internal constructor() {

        private var items: JsonField<MutableList<MessageDeliveryLog>>? = null
        private var pageInfo: JsonField<PageInfo>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            messageListDeliveryLogsPageResponse: MessageListDeliveryLogsPageResponse
        ) = apply {
            items = messageListDeliveryLogsPageResponse.items.map { it.toMutableList() }
            pageInfo = messageListDeliveryLogsPageResponse.pageInfo
            additionalProperties =
                messageListDeliveryLogsPageResponse.additionalProperties.toMutableMap()
        }

        /**
         * Returns a paginated list of delivery logs from the downstream provider for the specified
         * message. For Knock in-app channels, the delivery logs will always be an empty list.
         */
        fun items(items: List<MessageDeliveryLog>) = items(JsonField.of(items))

        /**
         * Sets [Builder.items] to an arbitrary JSON value.
         *
         * You should usually call [Builder.items] with a well-typed `List<MessageDeliveryLog>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun items(items: JsonField<List<MessageDeliveryLog>>) = apply {
            this.items = items.map { it.toMutableList() }
        }

        /**
         * Adds a single [MessageDeliveryLog] to [items].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addItem(item: MessageDeliveryLog) = apply {
            items =
                (items ?: JsonField.of(mutableListOf())).also { checkKnown("items", it).add(item) }
        }

        /** Pagination information for a list of resources. */
        fun pageInfo(pageInfo: PageInfo) = pageInfo(JsonField.of(pageInfo))

        /**
         * Sets [Builder.pageInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pageInfo] with a well-typed [PageInfo] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun pageInfo(pageInfo: JsonField<PageInfo>) = apply { this.pageInfo = pageInfo }

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
         * Returns an immutable instance of [MessageListDeliveryLogsPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .items()
         * .pageInfo()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageListDeliveryLogsPageResponse =
            MessageListDeliveryLogsPageResponse(
                checkRequired("items", items).map { it.toImmutable() },
                checkRequired("pageInfo", pageInfo),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MessageListDeliveryLogsPageResponse = apply {
        if (validated) {
            return@apply
        }

        items().forEach { it.validate() }
        pageInfo().validate()
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
        (items.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (pageInfo.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListDeliveryLogsPageResponse && items == other.items && pageInfo == other.pageInfo && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(items, pageInfo, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageListDeliveryLogsPageResponse{items=$items, pageInfo=$pageInfo, additionalProperties=$additionalProperties}"
}
