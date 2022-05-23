package app.knock.api.resources;

import app.knock.api.KnockClient;
import app.knock.api.model.UserIdentity;
import app.knock.api.model.WorkflowTrigger;
import app.knock.api.model.WorkflowTriggerResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WorkflowResourceTestsIT {

    KnockClient client;

    /***
     * Note: This requires runtime configuration of KNOCK_API_KEY to be setup. These tests don't run by default as
     * to not require the API key.
     */
    @BeforeEach
    void setup() {
        client = KnockClient.builder().build();
    }

    @Test
    void shouldCreateUserIdentity() {
        String actorId = UUID.randomUUID().toString();
        String recipientId1 = UUID.randomUUID().toString();
        String recipientId2 = UUID.randomUUID().toString();

        client.users().identify(UserIdentity.builder()
                .id(actorId)
                .name("IT Test Actor")
                .email(actorId + "@example.com")
                .build());

        client.users().identify(UserIdentity.builder()
                .id(recipientId1)
                .name("IT Test Recipient 1")
                .email(recipientId1 + "@example.com")
                .build());

        client.users().identify(UserIdentity.builder()
                .id(recipientId2)
                .name("IT Test Recipient 2")
                .email(recipientId1 + "@example.com")
                .build());

        WorkflowTrigger workflowTrigger = WorkflowTrigger.builder()
                .key("new-feature")
                .actor(actorId)
                .recipients(List.of(recipientId1, recipientId2))
                .data("thing_1", "thing one value")
                .data("thing_2", "thing two value")
                .data("nested_thing", Map.of("nested_thing_1", 123.44, "nested_thing_2", 123))
                .build();

        WorkflowTriggerResult result = client.workflows().trigger(workflowTrigger);

        assertNotNull(UUID.fromString(result.getWorkflowRunId()));
    }

}
