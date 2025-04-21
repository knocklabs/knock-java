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

/**
 * Returns a paginated list of `activities` associated with a given message. For messages produced
 * after a [batch step](/designing-workflows/batch-function), this will contain one or more
 * activities. Non-batched messages will always return a single activity.
 */
class MessageListActivitiesPageResponse
private constructor(
    private val entries: JsonField<List<Activity>>,
    private val pageInfo: JsonField<PageInfo>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("entries")
        @ExcludeMissing
        entries: JsonField<List<Activity>> = JsonMissing.of(),
        @JsonProperty("page_info") @ExcludeMissing pageInfo: JsonField<PageInfo> = JsonMissing.of(),
    ) : this(entries, pageInfo, mutableMapOf())

    /**
     * A list of activities.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun entries(): List<Activity> = entries.getRequired("entries")

    /**
     * Pagination information for a list of resources.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun pageInfo(): PageInfo = pageInfo.getRequired("page_info")

    /**
     * Returns the raw JSON value of [entries].
     *
     * Unlike [entries], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("entries") @ExcludeMissing fun _entries(): JsonField<List<Activity>> = entries

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
         * [MessageListActivitiesPageResponse].
         *
         * The following fields are required:
         * ```java
         * .entries()
         * .pageInfo()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [MessageListActivitiesPageResponse]. */
    class Builder internal constructor() {

        private var entries: JsonField<MutableList<Activity>>? = null
        private var pageInfo: JsonField<PageInfo>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(messageListActivitiesPageResponse: MessageListActivitiesPageResponse) =
            apply {
                entries = messageListActivitiesPageResponse.entries.map { it.toMutableList() }
                pageInfo = messageListActivitiesPageResponse.pageInfo
                additionalProperties =
                    messageListActivitiesPageResponse.additionalProperties.toMutableMap()
            }

        /** A list of activities. */
        fun entries(entries: List<Activity>) = entries(JsonField.of(entries))

        /**
         * Sets [Builder.entries] to an arbitrary JSON value.
         *
         * You should usually call [Builder.entries] with a well-typed `List<Activity>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun entries(entries: JsonField<List<Activity>>) = apply {
            this.entries = entries.map { it.toMutableList() }
        }

        /**
         * Adds a single [Activity] to [entries].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEntry(entry: Activity) = apply {
            entries =
                (entries ?: JsonField.of(mutableListOf())).also {
                    checkKnown("entries", it).add(entry)
                }
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
         * Returns an immutable instance of [MessageListActivitiesPageResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .entries()
         * .pageInfo()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): MessageListActivitiesPageResponse =
            MessageListActivitiesPageResponse(
                checkRequired("entries", entries).map { it.toImmutable() },
                checkRequired("pageInfo", pageInfo),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): MessageListActivitiesPageResponse = apply {
        if (validated) {
            return@apply
        }

        entries().forEach { it.validate() }
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
        (entries.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (pageInfo.asKnown().getOrNull()?.validity() ?: 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is MessageListActivitiesPageResponse && entries == other.entries && pageInfo == other.pageInfo && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(entries, pageInfo, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "MessageListActivitiesPageResponse{entries=$entries, pageInfo=$pageInfo, additionalProperties=$additionalProperties}"
}
