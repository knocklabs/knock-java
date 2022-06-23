package app.knock.api.model;

import app.knock.api.serialize.Json;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorkflowTriggerSerializeTests {

    @Test
    void mappedPropertiesShouldUnwrap() {
        WorkflowTriggerRequest workflowTrigger = WorkflowTriggerRequest.builder()
                .key("new-feature")
                .actor("actorId")
                .cancellationKey("test")
                .addRecipient("recipientId1", "recipientId2")
                .addRecipient(Map.of("id", "user_3"))
                .addRecipient(WorkflowTriggerRequest.RecipientIdentifier.builder()
                        .id("identifier_id")
                        .attribute("something", "cool")
                        .build())
                .data("thing_1", "thing one value")
                .data("thing_2", "thing two value")
                .data("nested_thing", Map.of("nested_thing_1", 123.44, "nested_thing_2", 123))
                .build();

        String json = Json.writeString(workflowTrigger);

        assertTrue(json.contains("\"actor\":\"actorId\""));
        assertTrue(json.contains("\"cancellation_key\":\"test\""));
        assertTrue(json.contains("recipientId1"));
        assertTrue(json.contains("recipientId2"));
        assertTrue(json.contains("\"id\":\"identifier_id\",\"attributes\":{\"something\":\"cool\"}"));
        assertTrue(json.contains("\"id\":\"user_3\""));
        assertTrue(json.contains("\"actor\":\"actorId\""));
        assertTrue(json.contains("\"thing one value\""));
        assertTrue(json.contains("123"));
        assertTrue(json.contains("123.44"));
    }

}
