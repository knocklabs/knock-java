// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.errors.KnockInvalidDataException
import app.knock.api.models.PageInfo
import app.knock.api.services.blocking.TenantService
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

/** List tenants */
class TenantListPage
private constructor(
    private val tenantsService: TenantService,
    private val params: TenantListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun entries(): List<Tenant> = response().entries()

    fun pageInfo(): Optional<PageInfo> = response().pageInfo()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TenantListPage && tenantsService == other.tenantsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(tenantsService, params, response) /* spotless:on */

    override fun toString() =
        "TenantListPage{tenantsService=$tenantsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        if (entries().isEmpty()) {
            return false
        }

        return pageInfo().flatMap { it.after() }.isPresent
    }

    fun getNextPageParams(): Optional<TenantListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            TenantListParams.builder()
                .from(params)
                .apply { pageInfo().flatMap { it.after() }.ifPresent { this.after(it) } }
                .build()
        )
    }

    fun getNextPage(): Optional<TenantListPage> {
        return getNextPageParams().map { tenantsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(tenantsService: TenantService, params: TenantListParams, response: Response) =
            TenantListPage(tenantsService, params, response)
    }

    class Response(
        private val entries: JsonField<List<Tenant>>,
        private val pageInfo: JsonField<PageInfo>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("entries") entries: JsonField<List<Tenant>> = JsonMissing.of(),
            @JsonProperty("page_info") pageInfo: JsonField<PageInfo> = JsonMissing.of(),
        ) : this(entries, pageInfo, mutableMapOf())

        fun entries(): List<Tenant> = entries.getOptional("entries").getOrNull() ?: listOf()

        fun pageInfo(): Optional<PageInfo> = pageInfo.getOptional("page_info")

        @JsonProperty("entries")
        fun _entries(): Optional<JsonField<List<Tenant>>> = Optional.ofNullable(entries)

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

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: KnockInvalidDataException) {
                false
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

            /** Returns a mutable builder for constructing an instance of [TenantListPage]. */
            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var entries: JsonField<List<Tenant>> = JsonMissing.of()
            private var pageInfo: JsonField<PageInfo> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.entries = page.entries
                this.pageInfo = page.pageInfo
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun entries(entries: List<Tenant>) = entries(JsonField.of(entries))

            fun entries(entries: JsonField<List<Tenant>>) = apply { this.entries = entries }

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

    class AutoPager(private val firstPage: TenantListPage) : Iterable<Tenant> {

        override fun iterator(): Iterator<Tenant> = iterator {
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

        fun stream(): Stream<Tenant> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
