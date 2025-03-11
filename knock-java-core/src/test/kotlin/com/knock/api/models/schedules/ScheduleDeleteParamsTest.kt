// File generated from our OpenAPI spec by Stainless.

package com.knock.api.models.schedules

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ScheduleDeleteParamsTest {

    @Test
    fun create() {
      ScheduleDeleteParams.builder()
          .addScheduleId("123e4567-e89b-12d3-a456-426614174000")
          .build()
    }

    @Test
    fun body() {
      val params = ScheduleDeleteParams.builder()
          .addScheduleId("123e4567-e89b-12d3-a456-426614174000")
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.scheduleIds()).isEqualTo(listOf("123e4567-e89b-12d3-a456-426614174000"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
      val params = ScheduleDeleteParams.builder()
          .addScheduleId("123e4567-e89b-12d3-a456-426614174000")
          .build()

      val body = params._body()

      assertNotNull(body)
      assertThat(body.scheduleIds()).isEqualTo(listOf("123e4567-e89b-12d3-a456-426614174000"))
    }
}
