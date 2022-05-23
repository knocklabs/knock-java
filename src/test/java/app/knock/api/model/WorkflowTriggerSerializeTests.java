package app.knock.api.model;

import app.knock.api.serialize.Json;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WorkflowTriggerSerializeTests {

    @Test
    void mappedPropertiesShouldUnwrap() {
        WorkflowTrigger workflowTrigger = WorkflowTrigger.builder()
                .key("new-feature")
                .actor("actorId")
                .recipients(List.of("recipientId1", "recipientId2"))
                .data("thing_1", "thing one value")
                .data("thing_2", "thing two value")
                .data("nested_thing", Map.of("nested_thing_1", 123.44, "nested_thing_2", 123))
                .build();

        String json = Json.writeString(workflowTrigger);

        assertTrue(json.contains("\"actor\":\"actorId\""));
        assertTrue(json.contains("recipientId1"));
        assertTrue(json.contains("recipientId2"));
        assertTrue(json.contains("\"actor\":\"actorId\""));
        assertTrue(json.contains("\"thing one value\""));
        assertTrue(json.contains("123"));
        assertTrue(json.contains("123.44"));
    }

}
