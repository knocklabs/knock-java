// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.users.guides

import app.knock.api.core.JsonValue
import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GuideGetChannelResponseTest {

    @Test
    fun create() {
        val guideGetChannelResponse =
            GuideGetChannelResponse.builder()
                .addEntry(
                    GuideGetChannelResponse.Entry.builder()
                        .id("53595157-2fac-4a17-8dd7-e6603e32cb3a")
                        ._typename("Guide")
                        .addActivationUrlPattern(
                            GuideGetChannelResponse.Entry.ActivationUrlPattern.builder()
                                .directive("allow")
                                .pathname("/dairy/*")
                                .search("role=admin")
                                .build()
                        )
                        .addActivationUrlRule(
                            GuideGetChannelResponse.Entry.ActivationUrlRule.builder()
                                .argument("/workflows")
                                .directive("allow")
                                .operator("contains")
                                .variable("pathname")
                                .build()
                        )
                        .active(true)
                        .bypassGlobalGroupLimit(false)
                        .channelId("51b92f90-1504-4fda-95c1-495a3883bc4d")
                        .dashboardUrl("https://dashboard.knock.app/~/guides/nps-survey")
                        .insertedAt("2025-09-30T14:54:44.217756Z")
                        .key("nps-survey")
                        .semver("0.0.3")
                        .addStep(
                            GuideGetChannelResponse.Entry.Step.builder()
                                .content(
                                    GuideGetChannelResponse.Entry.Step.Content.builder()
                                        .putAdditionalProperty(
                                            "companyName",
                                            JsonValue.from("Knock"),
                                        )
                                        .build()
                                )
                                .message(
                                    GuideGetChannelResponse.Entry.Step.Message.builder()
                                        .id("33hjnKRKNx9ISRlixVBjhpkh28J")
                                        .archivedAt(null)
                                        .interactedAt(
                                            OffsetDateTime.parse("2025-10-07T15:10:59.291Z")
                                        )
                                        .linkClickedAt(null)
                                        .readAt(OffsetDateTime.parse("2025-10-07T15:10:59.291Z"))
                                        .seenAt(OffsetDateTime.parse("2025-10-06T18:46:03.210Z"))
                                        .build()
                                )
                                .ref("step_1")
                                .schemaKey("nps-survey")
                                .schemaSemver("0.0.3")
                                .schemaVariantKey("default")
                                .build()
                        )
                        .type("nps-survey")
                        .updatedAt("2025-10-03T17:46:53.653663Z")
                        .build()
                )
                .guideGroupDisplayLogs(
                    GuideGetChannelResponse.GuideGroupDisplayLogs.builder()
                        .putAdditionalProperty(
                            "default",
                            JsonValue.from("2025-10-07T15:10:59.291Z"),
                        )
                        .build()
                )
                .addGuideGroup(
                    GuideGetChannelResponse.GuideGroup.builder()
                        ._typename("GuideGroup")
                        .displayInterval(3600L)
                        .addDisplaySequence("changelog-card")
                        .insertedAt("2025-09-30T14:54:44.217756Z")
                        .key("default")
                        .updatedAt("2025-10-03T17:46:53.653663Z")
                        .build()
                )
                .addIneligibleGuide(
                    GuideGetChannelResponse.IneligibleGuide.builder()
                        .key("onboarding")
                        .message("The guide is not active")
                        .reason(GuideGetChannelResponse.IneligibleGuide.Reason.GUIDE_NOT_ACTIVE)
                        .build()
                )
                .build()

        assertThat(guideGetChannelResponse.entries())
            .containsExactly(
                GuideGetChannelResponse.Entry.builder()
                    .id("53595157-2fac-4a17-8dd7-e6603e32cb3a")
                    ._typename("Guide")
                    .addActivationUrlPattern(
                        GuideGetChannelResponse.Entry.ActivationUrlPattern.builder()
                            .directive("allow")
                            .pathname("/dairy/*")
                            .search("role=admin")
                            .build()
                    )
                    .addActivationUrlRule(
                        GuideGetChannelResponse.Entry.ActivationUrlRule.builder()
                            .argument("/workflows")
                            .directive("allow")
                            .operator("contains")
                            .variable("pathname")
                            .build()
                    )
                    .active(true)
                    .bypassGlobalGroupLimit(false)
                    .channelId("51b92f90-1504-4fda-95c1-495a3883bc4d")
                    .dashboardUrl("https://dashboard.knock.app/~/guides/nps-survey")
                    .insertedAt("2025-09-30T14:54:44.217756Z")
                    .key("nps-survey")
                    .semver("0.0.3")
                    .addStep(
                        GuideGetChannelResponse.Entry.Step.builder()
                            .content(
                                GuideGetChannelResponse.Entry.Step.Content.builder()
                                    .putAdditionalProperty("companyName", JsonValue.from("Knock"))
                                    .build()
                            )
                            .message(
                                GuideGetChannelResponse.Entry.Step.Message.builder()
                                    .id("33hjnKRKNx9ISRlixVBjhpkh28J")
                                    .archivedAt(null)
                                    .interactedAt(OffsetDateTime.parse("2025-10-07T15:10:59.291Z"))
                                    .linkClickedAt(null)
                                    .readAt(OffsetDateTime.parse("2025-10-07T15:10:59.291Z"))
                                    .seenAt(OffsetDateTime.parse("2025-10-06T18:46:03.210Z"))
                                    .build()
                            )
                            .ref("step_1")
                            .schemaKey("nps-survey")
                            .schemaSemver("0.0.3")
                            .schemaVariantKey("default")
                            .build()
                    )
                    .type("nps-survey")
                    .updatedAt("2025-10-03T17:46:53.653663Z")
                    .build()
            )
        assertThat(guideGetChannelResponse.guideGroupDisplayLogs())
            .isEqualTo(
                GuideGetChannelResponse.GuideGroupDisplayLogs.builder()
                    .putAdditionalProperty("default", JsonValue.from("2025-10-07T15:10:59.291Z"))
                    .build()
            )
        assertThat(guideGetChannelResponse.guideGroups())
            .containsExactly(
                GuideGetChannelResponse.GuideGroup.builder()
                    ._typename("GuideGroup")
                    .displayInterval(3600L)
                    .addDisplaySequence("changelog-card")
                    .insertedAt("2025-09-30T14:54:44.217756Z")
                    .key("default")
                    .updatedAt("2025-10-03T17:46:53.653663Z")
                    .build()
            )
        assertThat(guideGetChannelResponse.ineligibleGuides())
            .containsExactly(
                GuideGetChannelResponse.IneligibleGuide.builder()
                    .key("onboarding")
                    .message("The guide is not active")
                    .reason(GuideGetChannelResponse.IneligibleGuide.Reason.GUIDE_NOT_ACTIVE)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val guideGetChannelResponse =
            GuideGetChannelResponse.builder()
                .addEntry(
                    GuideGetChannelResponse.Entry.builder()
                        .id("53595157-2fac-4a17-8dd7-e6603e32cb3a")
                        ._typename("Guide")
                        .addActivationUrlPattern(
                            GuideGetChannelResponse.Entry.ActivationUrlPattern.builder()
                                .directive("allow")
                                .pathname("/dairy/*")
                                .search("role=admin")
                                .build()
                        )
                        .addActivationUrlRule(
                            GuideGetChannelResponse.Entry.ActivationUrlRule.builder()
                                .argument("/workflows")
                                .directive("allow")
                                .operator("contains")
                                .variable("pathname")
                                .build()
                        )
                        .active(true)
                        .bypassGlobalGroupLimit(false)
                        .channelId("51b92f90-1504-4fda-95c1-495a3883bc4d")
                        .dashboardUrl("https://dashboard.knock.app/~/guides/nps-survey")
                        .insertedAt("2025-09-30T14:54:44.217756Z")
                        .key("nps-survey")
                        .semver("0.0.3")
                        .addStep(
                            GuideGetChannelResponse.Entry.Step.builder()
                                .content(
                                    GuideGetChannelResponse.Entry.Step.Content.builder()
                                        .putAdditionalProperty(
                                            "companyName",
                                            JsonValue.from("Knock"),
                                        )
                                        .build()
                                )
                                .message(
                                    GuideGetChannelResponse.Entry.Step.Message.builder()
                                        .id("33hjnKRKNx9ISRlixVBjhpkh28J")
                                        .archivedAt(null)
                                        .interactedAt(
                                            OffsetDateTime.parse("2025-10-07T15:10:59.291Z")
                                        )
                                        .linkClickedAt(null)
                                        .readAt(OffsetDateTime.parse("2025-10-07T15:10:59.291Z"))
                                        .seenAt(OffsetDateTime.parse("2025-10-06T18:46:03.210Z"))
                                        .build()
                                )
                                .ref("step_1")
                                .schemaKey("nps-survey")
                                .schemaSemver("0.0.3")
                                .schemaVariantKey("default")
                                .build()
                        )
                        .type("nps-survey")
                        .updatedAt("2025-10-03T17:46:53.653663Z")
                        .build()
                )
                .guideGroupDisplayLogs(
                    GuideGetChannelResponse.GuideGroupDisplayLogs.builder()
                        .putAdditionalProperty(
                            "default",
                            JsonValue.from("2025-10-07T15:10:59.291Z"),
                        )
                        .build()
                )
                .addGuideGroup(
                    GuideGetChannelResponse.GuideGroup.builder()
                        ._typename("GuideGroup")
                        .displayInterval(3600L)
                        .addDisplaySequence("changelog-card")
                        .insertedAt("2025-09-30T14:54:44.217756Z")
                        .key("default")
                        .updatedAt("2025-10-03T17:46:53.653663Z")
                        .build()
                )
                .addIneligibleGuide(
                    GuideGetChannelResponse.IneligibleGuide.builder()
                        .key("onboarding")
                        .message("The guide is not active")
                        .reason(GuideGetChannelResponse.IneligibleGuide.Reason.GUIDE_NOT_ACTIVE)
                        .build()
                )
                .build()

        val roundtrippedGuideGetChannelResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(guideGetChannelResponse),
                jacksonTypeRef<GuideGetChannelResponse>(),
            )

        assertThat(roundtrippedGuideGetChannelResponse).isEqualTo(guideGetChannelResponse)
    }
}
