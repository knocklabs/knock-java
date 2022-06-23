package app.knock.api.model;

import app.knock.api.serialize.Json;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.Map;

public class WorkflowTriggerSerializeTests {

    @Test
    void mappedPropertiesShouldUnwrap() throws JSONException {
        WorkflowTriggerRequest workflowTrigger = WorkflowTriggerRequest.builder()
                .key("new-feature")
                .actor("actorId")
                .cancellationKey("test")
                .addRecipient("recipientId1", "recipientId2")
                .addRecipient(Map.of("id", "user_3"))
                .addRecipient(WorkflowTriggerRequest.TriggerIdentifier.builder()
                        .id("identifier_id")
                        .collection("collection")
                        .build())
                .data("thing_1", "thing one value")
                .data("thing_2", "thing two value")
                .data("nested_thing", Map.of("nested_thing_1", 123.44, "nested_thing_2", 123))
                .build();

        String json = Json.writeString(workflowTrigger);

        JSONAssert.assertEquals("{actor:\"actorId\"}", json, false);
        JSONAssert.assertEquals("{cancellation_key:\"test\"}", json, false);
        JSONAssert.assertEquals("{" +
                "recipients: [" +
                    "\"recipientId1\", " +
                    "\"recipientId2\", " +
                "   {" +
                "       id: \"identifier_id\", " +
                "       collection: \"collection\"" +
                "   }," +
                "   { id: \"user_3\"}" +
                "]" +
              "}", json, false);

        JSONAssert.assertEquals("{" +
                "data: {" +
                    "thing_1: \"thing one value\"," +
                    "thing_2: \"thing two value\"," +
                    "nested_thing: {" +
                        "nested_thing_1: 123.44," +
                        "nested_thing_2: 123" +
                    "}" +
                "}}", json, false);
    }

    @Test
    void mappedPropertiesShouldUnwrapActorObject() throws JSONException {
        WorkflowTriggerRequest workflowTrigger = WorkflowTriggerRequest.builder()
                .key("new-feature")
                .actor(WorkflowTriggerRequest.TriggerIdentifier.builder()
                        .id("object-id")
                        .collection("collection")
                        .build())
                .cancellationKey("test")
                .addRecipient("recipientId1", "recipientId2")
                .addRecipient(Map.of("id", "user_3"))
                .addRecipient(WorkflowTriggerRequest.TriggerIdentifier.builder()
                        .id("identifier_id")
                        .collection("collection")
                        .build())
                .data("thing_1", "thing one value")
                .data("thing_2", "thing two value")
                .data("nested_thing", Map.of("nested_thing_1", 123.44, "nested_thing_2", 123))
                .build();

        String json = Json.writeString(workflowTrigger);

        JSONAssert.assertEquals("{actor:{id: \"object-id\", collection: \"collection\"}}", json, false);
        JSONAssert.assertEquals("{cancellation_key:\"test\"}", json, false);
        JSONAssert.assertEquals("{" +
                "recipients: [" +
                    "\"recipientId1\", " +
                    "\"recipientId2\", " +
                "   {" +
                "       id: \"identifier_id\", " +
                "       collection: \"collection\"" +
                "   }," +
                "   { id: \"user_3\"}" +
                "]" +
              "}", json, false);

        JSONAssert.assertEquals("{" +
                "data: {" +
                    "thing_1: \"thing one value\"," +
                    "thing_2: \"thing two value\"," +
                    "nested_thing: {" +
                        "nested_thing_1: 123.44," +
                        "nested_thing_2: 123" +
                    "}" +
                "}}", json, false);
    }

}
