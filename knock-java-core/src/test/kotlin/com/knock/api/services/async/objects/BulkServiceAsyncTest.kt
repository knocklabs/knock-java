// File generated from our OpenAPI spec by Stainless.

package com.knock.api.services.async.objects

import com.knock.api.TestServerExtension
import com.knock.api.client.okhttp.KnockOkHttpClientAsync
import com.knock.api.core.JsonValue
import com.knock.api.models.objects.InlineObjectRequest
import com.knock.api.models.objects.bulk.BulkAddSubscriptionsParams
import com.knock.api.models.objects.bulk.BulkDeleteParams
import com.knock.api.models.objects.bulk.BulkSetParams
import com.knock.api.models.recipients.InlineChannelDataRequest
import com.knock.api.models.recipients.InlinePreferenceSetRequest
import com.knock.api.models.users.InlineIdentifyUserRequest
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BulkServiceAsyncTest {

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun delete() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val bulkServiceAsync = client.objects().bulk()

      val bulkOperationFuture = bulkServiceAsync.delete(BulkDeleteParams.builder()
          .collection("collection")
          .addObjectId("string")
          .build())

      val bulkOperation = bulkOperationFuture.get()
      bulkOperation.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun addSubscriptions() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val bulkServiceAsync = client.objects().bulk()

      val bulkOperationFuture = bulkServiceAsync.addSubscriptions(BulkAddSubscriptionsParams.builder()
          .collection("projects")
          .addSubscription(BulkAddSubscriptionsParams.Subscription.builder()
              .id("project-1")
              .addRecipient(InlineIdentifyUserRequest.builder()
                  .id("user_1")
                  .channelData(InlineChannelDataRequest.builder()
                      .putAdditionalProperty("97c5837d-c65c-4d54-aa39-080eeb81c69d", JsonValue.from(mapOf("data" to mapOf("tokens" to listOf("push_token_xxx")))))
                      .build())
                  .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                  .preferences(InlinePreferenceSetRequest.builder()
                      .putAdditionalProperty("default", JsonValue.from(mapOf(
                        "categories" to mapOf("transactional" to mapOf(
                          "channel_types" to mapOf(
                            "chat" to true,
                            "email" to false,
                            "http" to true,
                            "in_app_feed" to true,
                            "push" to true,
                            "sms" to true,
                          ), "conditions" to listOf(mapOf(
                            "argument" to "some_property",
                            "operator" to "equal_to",
                            "variable" to "recipient.property",
                          ))
                        )),
                        "channel_types" to mapOf(
                          "chat" to true,
                          "email" to true,
                          "http" to true,
                          "in_app_feed" to true,
                          "push" to true,
                          "sms" to true,
                        ),
                        "workflows" to mapOf("dinosaurs-loose" to mapOf(
                          "channel_types" to mapOf(
                            "chat" to true,
                            "email" to true,
                            "http" to true,
                            "in_app_feed" to true,
                            "push" to true,
                            "sms" to true,
                          ), "conditions" to listOf(mapOf(
                            "argument" to "some_property",
                            "operator" to "equal_to",
                            "variable" to "recipient.property",
                          ))
                        )),
                      )))
                      .build())
                  .build())
              .properties(BulkAddSubscriptionsParams.Subscription.Properties.builder()
                  .putAdditionalProperty("foo", JsonValue.from("bar"))
                  .build())
              .build())
          .build())

      val bulkOperation = bulkOperationFuture.get()
      bulkOperation.validate()
    }

    @Disabled("skipped: currently no good way to test endpoints defining callbacks, Prism mock server will fail trying to reach the provided callback url")
    @Test
    fun set() {
      val client = KnockOkHttpClientAsync.builder()
          .baseUrl(TestServerExtension.BASE_URL)
          .bearerToken("My Bearer Token")
          .build()
      val bulkServiceAsync = client.objects().bulk()

      val bulkOperationFuture = bulkServiceAsync.set(BulkSetParams.builder()
          .collection("collection")
          .addObject(InlineObjectRequest.builder()
              .id("project_1")
              .collection("projects")
              .channelData(InlineChannelDataRequest.builder()
                  .putAdditionalProperty("97c5837d-c65c-4d54-aa39-080eeb81c69d", JsonValue.from(mapOf("data" to mapOf("tokens" to listOf("push_token_xxx")))))
                  .build())
              .createdAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
              .preferences(InlinePreferenceSetRequest.builder()
                  .putAdditionalProperty("default", JsonValue.from(mapOf(
                    "categories" to mapOf("transactional" to mapOf(
                      "channel_types" to mapOf(
                        "chat" to true,
                        "email" to false,
                        "http" to true,
                        "in_app_feed" to true,
                        "push" to true,
                        "sms" to true,
                      ), "conditions" to listOf(mapOf(
                        "argument" to "some_property",
                        "operator" to "equal_to",
                        "variable" to "recipient.property",
                      ))
                    )),
                    "channel_types" to mapOf(
                      "chat" to true,
                      "email" to true,
                      "http" to true,
                      "in_app_feed" to true,
                      "push" to true,
                      "sms" to true,
                    ),
                    "workflows" to mapOf("dinosaurs-loose" to mapOf(
                      "channel_types" to mapOf(
                        "chat" to true,
                        "email" to true,
                        "http" to true,
                        "in_app_feed" to true,
                        "push" to true,
                        "sms" to true,
                      ), "conditions" to listOf(mapOf(
                        "argument" to "some_property",
                        "operator" to "equal_to",
                        "variable" to "recipient.property",
                      ))
                    )),
                  )))
                  .build())
              .build())
          .build())

      val bulkOperation = bulkOperationFuture.get()
      bulkOperation.validate()
    }
}
