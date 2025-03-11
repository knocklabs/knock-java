// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.objects

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
import com.knock.api.models
import com.knock.api.models.schedules.Schedule
import com.knock.api.services.async.ObjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

/** List schedules */
class ObjectListSchedulesPageAsync private constructor(
    private val objectsService: ObjectServiceAsync,
    private val params: ObjectListSchedulesParams,
    private val response: Response,

) {

    fun response(): Response = response

    fun entries(): List<Schedule> = response().entries()

    fun pageInfo(): Optional<PageInfo> = response().pageInfo()

    override fun equals(other: Any?): Boolean {
      if (this === other) {
          return true
      }

      return /* spotless:off */ other is ObjectListSchedulesPageAsync && objectsService == other.objectsService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(objectsService, params, response) /* spotless:on */

    override fun toString() = "ObjectListSchedulesPageAsync{objectsService=$objectsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
      if (entries().isEmpty()) {
        return false;
      }

      return pageInfo().flatMap { it.after()}.isPresent
    }

    fun getNextPageParams(): Optional<ObjectListSchedulesParams> {
      if (!hasNextPage()) {
        return Optional.empty()
      }

      return Optional.of(ObjectListSchedulesParams.builder().from(params).apply {pageInfo().flatMap { it.after()}.ifPresent{ this.after(it) } }.build())
    }

    fun getNextPage(): CompletableFuture<Optional<ObjectListSchedulesPageAsync>> {
      return getNextPageParams().map {
        objectsService.listSchedules(it).thenApply { Optional.of(it) }
      }.orElseGet {
          CompletableFuture.completedFuture(Optional.empty())
      }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(objectsService: ObjectServiceAsync, params: ObjectListSchedulesParams, response: Response) =
            ObjectListSchedulesPageAsync(
              objectsService,
              params,
              response,
            )
    }

    @NoAutoDetect
    class Response @JsonCreator constructor(
        @JsonProperty("entries") private val entries: JsonField<List<Schedule>> = JsonMissing.of(),
        @JsonProperty("page_info") private val pageInfo: JsonField<PageInfo> = JsonMissing.of(),
        @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

    ) {

        fun entries(): List<Schedule> = entries.getNullable("entries") ?: listOf()

        fun pageInfo(): Optional<PageInfo> = Optional.ofNullable(pageInfo.getNullable("page_info"))

        @JsonProperty("entries")
        fun _entries(): Optional<JsonField<List<Schedule>>> = Optional.ofNullable(entries)

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
             * [ObjectListSchedulesPageAsync].
             */
            @JvmStatic
            fun builder() = Builder()
        }

        class Builder {

            private var entries: JsonField<List<Schedule>> = JsonMissing.of()
            private var pageInfo: JsonField<PageInfo> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) =
                apply {
                    this.entries = page.entries
                    this.pageInfo = page.pageInfo
                    this.additionalProperties.putAll(page.additionalProperties)
                }

            fun entries(entries: List<Schedule>) = entries(JsonField.of(entries))

            fun entries(entries: JsonField<List<Schedule>>) = apply { this.entries = entries }

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
        private val firstPage: ObjectListSchedulesPageAsync,

    ) {

        fun forEach(action: Predicate<Schedule>, executor: Executor): CompletableFuture<Void> {
          fun CompletableFuture<Optional<ObjectListSchedulesPageAsync>>.forEach(action: (Schedule) -> Boolean, executor: Executor): CompletableFuture<Void> =
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

        fun toList(executor: Executor): CompletableFuture<List<Schedule>> {
          val values = mutableListOf<Schedule>()
          return forEach(
            values::add, executor
          )
          .thenApply {
              values
          }
        }
    }
}
