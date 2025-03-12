// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.tenants

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import app.knock.api.models
import app.knock.api.services.async.TenantServiceAsync
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/** List tenants */
class TenantListPageAsync private constructor(
    private val tenantsService: TenantServiceAsync,
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

      return /* spotless:off */ other is TenantListPageAsync && tenantsService == other.tenantsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(tenantsService, params, response) /* spotless:on */

    override fun toString() = "TenantListPageAsync{tenantsService=$tenantsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
      if (entries().isEmpty()) {
        return false;
      }

      return pageInfo().flatMap { it.after()}.isPresent
    }

    fun getNextPageParams(): Optional<TenantListParams> {
      if (!hasNextPage()) {
        return Optional.empty()
      }

      return Optional.of(TenantListParams.builder().from(params).apply {pageInfo().flatMap { it.after()}.ifPresent{ this.after(it) } }.build())
    }

    fun getNextPage(): CompletableFuture<Optional<TenantListPageAsync>> {
      return getNextPageParams().map {
        tenantsService.list(it).thenApply { Optional.of(it) }
      }.orElseGet {
          CompletableFuture.completedFuture(Optional.empty())
      }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(tenantsService: TenantServiceAsync, params: TenantListParams, response: Response) =
            TenantListPageAsync(
              tenantsService,
              params,
              response,
            )
    }

    @NoAutoDetect
    class Response @JsonCreator constructor(
        @JsonProperty("entries") private val entries: JsonField<List<Tenant>> = JsonMissing.of(),
        @JsonProperty("page_info") private val pageInfo: JsonField<PageInfo> = JsonMissing.of(),
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        fun entries(): List<Tenant> = entries.getNullable("entries") ?: listOf()

        fun pageInfo(): Optional<PageInfo> = Optional.ofNullable(pageInfo.getNullable("page_info"))

        @JsonProperty("entries")
        fun _entries(): Optional<JsonField<List<Tenant>>> = Optional.ofNullable(entries)

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

            /** Returns a mutable builder for constructing an instance of [TenantListPageAsync]. */
            @JvmStatic
            fun builder() = Builder()
        }

        class Builder {

            private var entries: JsonField<List<Tenant>> = JsonMissing.of()
            private var pageInfo: JsonField<PageInfo> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) =
                apply {
                    this.entries = page.entries
                    this.pageInfo = page.pageInfo
                    this.additionalProperties.putAll(page.additionalProperties)
                }

            fun entries(entries: List<Tenant>) = entries(JsonField.of(entries))

            fun entries(entries: JsonField<List<Tenant>>) = apply { this.entries = entries }

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
        private val firstPage: TenantListPageAsync,

    ) {

        fun forEach(action: Predicate<Tenant>, executor: Executor): CompletableFuture<Void> {
          fun CompletableFuture<Optional<TenantListPageAsync>>.forEach(action: (Tenant) -> Boolean, executor: Executor): CompletableFuture<Void> =
              thenComposeAsync(
                { page ->
                    page
                    .filter {
                        it.entries().all(action)
                    }
                    .map {
                        it.getNextPage().forEach(action, executor)
                    }
                    .orElseGet {
                        CompletableFuture.completedFuture(null)
                    }
                }, executor
              )
          return CompletableFuture.completedFuture(Optional.of(firstPage))
          .forEach(
            action::test, executor
          )
        }

        fun toList(executor: Executor): CompletableFuture<List<Tenant>> {
          val values = mutableListOf<Tenant>()
          return forEach(
            values::add, executor
          )
          .thenApply {
              values
          }
        }
    }
}
