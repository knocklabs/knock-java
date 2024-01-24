package app.knock.api.model;

import app.knock.api.serialize.Json;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.util.HashMap;
import java.util.Map;

public class WorkflowTriggerSerializeTests {

    @Test
    void mappedPropertiesShouldUnwrap() throws JSONException {
        WorkflowTriggerRequest workflowTrigger = WorkflowTriggerRequest.builder()
                .key("new-feature")
                .actor("actorId")
                .tenant("tenant-1")
                .cancellationKey("test")
                .addRecipient("recipientId1", "recipientId2")
                .addRecipient(Map.of("id", "user_3"))
                .addRecipient(WorkflowTriggerRequest.ObjectRecipientIdentifier.builder()
                        .id("identifier_id")
                        .collection("collection")
                        .build())
                .data("thing_1", "thing one value")
                .data("thing_2", "thing two value")
                .data("nested_thing", Map.of("nested_thing_1", 123.44, "nested_thing_2", 123))
                .build();

        String json = Json.writeString(workflowTrigger);

        JSONAssert.assertEquals("{actor:\"actorId\"}", json, false);
        JSONAssert.assertEquals("{tenant:\"tenant-1\"}", json, false);
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
                .actor(WorkflowTriggerRequest.ObjectRecipientIdentifier.builder()
                        .id("object-id")
                        .collection("collection")
                        .build())
                .cancellationKey("test")
                .addRecipient("recipientId1", "recipientId2")
                .addRecipient(Map.of("id", "user_3"))
                .addRecipient(WorkflowTriggerRequest.ObjectRecipientIdentifier.builder()
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
    
    @Test
    void mappedPropertiesShouldUnwrapActorAndTenantWithProperties() throws JSONException {
        Map<String, Object> actorProperties = new HashMap<>();
        actorProperties.put("id", "actor-1");
        actorProperties.put("collection", "actor-collection");
        actorProperties.put("name", "custom actor");
        actorProperties.put("foo", "var");

        Map<String, Object> tenantProperties = new HashMap<>();
        tenantProperties.put("id", "tenant-1");
        tenantProperties.put("name", "custom tenant");
        tenantProperties.put("lala", "1234");

        WorkflowTriggerRequest workflowTrigger = WorkflowTriggerRequest.builder()
                .key("new-feature")
                .actor(actorProperties)
                .tenant(tenantProperties)
                .cancellationKey("test")
                .addRecipient("recipientId1", "recipientId2")
                .addRecipient(Map.of("id", "user_3"))
                .addRecipient(WorkflowTriggerRequest.ObjectRecipientIdentifier.builder()
                        .id("identifier_id")
                        .collection("collection")
                        .build())
                .data("thing_1", "thing one value")
                .data("thing_2", "thing two value")
                .data("nested_thing", Map.of("nested_thing_1", 123.44, "nested_thing_2", 123))
                .build();

        String json = Json.writeString(workflowTrigger);

        JSONAssert.assertEquals(
                "{actor:{" +
                        "id: \"actor-1\"," +
                        "collection: \"actor-collection\"," +
                        "name: \"custom actor\"," +
                        "foo: \"var\"" +
                        "}}",
                json,
                false);
        JSONAssert.assertEquals(
                "{tenant:{" +
                        "id: \"tenant-1\"," +
                        "name: \"custom tenant\"," +
                        "lala: \"1234\"" +
                        "}}",
                json,
                false);

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
