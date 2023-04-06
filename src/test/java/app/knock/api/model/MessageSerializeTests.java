package app.knock.api.model;

import app.knock.api.serialize.Json;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageSerializeTests {

    @Test
    void buildMessage() {
        KnockMessage message = KnockMessage.builder()
                .typeName("Message")
                .id("message-123456")
                .cursor("abcd999898")
                .channelId("channel-1234")
                .recipient("string recipient")
                .workflow("test-workflow")
                .tenant("tenant-4444")
                .status("delivered")
                .readAt(ZonedDateTime.parse("2021-03-05T12:00:00Z"))
                .seenAt(ZonedDateTime.parse("2021-04-05T12:00:00Z"))
                .archivedAt(ZonedDateTime.parse("2021-05-05T12:00:00Z"))
                .insertedAt(ZonedDateTime.parse("2021-06-05T12:00:00Z"))
                .updatedAt(ZonedDateTime.parse("2021-07-05T12:00:00Z"))
                .source(
                        WorkflowSource.builder()
                                .typeName("WorkflowSource")
                                .key("merged-changes")
                                .versionId("41255523")
                                .build())
                .data("entry_1", "value_1")
                .build();

        String json = Json.writeString(message);

        assertTrue(json.contains("\"__typename\":\"Message\""));
        assertTrue(json.contains("\"id\":\"message-123456\""));
        assertTrue(json.contains("\"__cursor\":\"abcd999898\""));
        assertTrue(json.contains("\"channel_id\":\"channel-1234\""));
        assertTrue(json.contains("\"recipient\":\"string recipient\""));
        assertTrue(json.contains("\"workflow\":\"test-workflow\""));
        assertTrue(json.contains("\"tenant\":\"tenant-4444\""));
        assertTrue(json.contains("\"status\":\"delivered\""));
        assertTrue(json.contains("\"read_at\":\"2021-03-05T12:00:00Z\""));
        assertTrue(json.contains("\"seen_at\":\"2021-04-05T12:00:00Z\""));
        assertTrue(json.contains("\"archived_at\":\"2021-05-05T12:00:00Z\""));
        assertTrue(json.contains("\"inserted_at\":\"2021-06-05T12:00:00Z\""));
        assertTrue(json.contains("\"updated_at\":\"2021-07-05T12:00:00Z\""));
        assertTrue(json.contains("\"__typename\":\"WorkflowSource\""));
        assertTrue(json.contains("\"key\":\"merged-changes\""));
        assertTrue(json.contains("\"version_id\":\"41255523\""));
        assertTrue(json.contains("\"entry_1\":\"value_1\""));
    }

    @Test
    void buildMessageWithRecipientIdentifier() {
        KnockMessage message = KnockMessage.builder()
                .recipient(
                        RecipientIdentifier.builder()
                                .id("project_1")
                                .collection("projects")
                                .build())
                .build();

        String json = Json.writeString(message);

        assertTrue(json.contains("\"id\":\"project_1\""));
        assertTrue(json.contains("\"collection\":\"projects\""));
    }

}
