package app.knock.api.resources;

import app.knock.api.KnockClient;
import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.model.KnockError;
import app.knock.api.model.UserIdentity;
import app.knock.api.model.WorkflowTrigger;
import app.knock.api.model.WorkflowTriggerResult;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class WorkflowResourceTestsIT {

    static KnockClient client;
    static String actorId = "workflow_test_actor_1";
    static String recipientId1 = "workflow_test_recipient_id_1";
    static String recipientId2 = "workflow_test_recipient_id_2";


    @BeforeAll
    static void setup() {
        client = KnockClient.builder().build();
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
    }



    @Test
    void testSuccessfulWorkflowTrigger() {
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

    @Test
    public void testInactiveWorkflowTrigger() {
        WorkflowTrigger workflowTrigger = WorkflowTrigger.builder()
                .key("inactive-workflow")
                .actor(actorId)
                .recipients(List.of(recipientId1, recipientId2))
                .build();

        try {
            client.workflows().trigger(workflowTrigger);
            fail("expected workflow_inactive");
        } catch (KnockClientResourceException e) {
            assertEquals("workflow_inactive", e.knockErrorResponse.getCode());
            assertEquals("The workflow you tried to invoke is marked as inactive", e.knockErrorResponse.getMessage());
            assertEquals(400, e.knockErrorResponse.getStatus());
            assertEquals("invalid_request_error", e.knockErrorResponse.getType());
        }
    }

    @Test
    public void testMissingActor() {
        WorkflowTrigger workflowTrigger = WorkflowTrigger.builder()
                .key("new-feature")
                .actor(UUID.randomUUID().toString())
                .recipients(List.of(recipientId1, recipientId2))
                .build();

        try {
            client.workflows().trigger(workflowTrigger);
            fail("expected actor_missing");
        } catch (KnockClientResourceException e) {
            assertEquals("actor_missing", e.knockErrorResponse.getCode());
        }
    }

    @Test
    public void testCancelWorkflow() {
        String cancellationKey = UUID.randomUUID().toString();

        WorkflowTrigger workflowTrigger = WorkflowTrigger.builder()
                .key("delayed-workflow")
                .actor(actorId)
                .cancellation_key(cancellationKey)
                .recipients(List.of(recipientId1, recipientId2))
                .build();

        client.workflows().trigger(workflowTrigger);

        client.workflows().cancel(workflowTrigger);
    }

    @Test
    public void testCancelWorkflowWithoutCancellationId() {
        WorkflowTrigger workflowTrigger = WorkflowTrigger.builder()
                .key("delayed-workflow")
                .actor(actorId)
                .recipients(List.of(recipientId1, recipientId2))
                .build();

        client.workflows().trigger(workflowTrigger);

        try {
            client.workflows().cancel(workflowTrigger);
            fail("expected invalid_params");
        } catch (KnockClientResourceException e) {
            assertEquals("invalid_params", e.knockErrorResponse.getCode());
            KnockError knockError = e.knockErrorResponse.getErrors().get(0);
            assertEquals("cancellation_key", knockError.getField());
            assertEquals("can't be blank", knockError.getMessage());
            assertEquals("required", knockError.getType());
        }
    }

}
