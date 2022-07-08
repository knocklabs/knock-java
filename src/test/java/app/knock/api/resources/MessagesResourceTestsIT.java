package app.knock.api.resources;

import app.knock.api.KnockClient;
import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class MessagesResourceTestsIT {

    static KnockClient client;

    @BeforeAll
    static void setup() {
        client = KnockClient.builder().build();
    }

    KnockMessage getOneMessage() {
        MessagesResource.QueryParams queryParams = new MessagesResource.QueryParams();
        queryParams.pageSize(10);

        CursorResult<KnockMessage> result = client.messages().list(queryParams);

        KnockMessage knockMessage = result.getItems().stream().findFirst().orElseGet(() -> null);
        assertNotNull(knockMessage, "Need a message to retrieve events");
        return knockMessage;
    }

    @Test
    void testGetAllMessages() {
        CursorResult<KnockMessage> result = client.messages().list(new MessagesResource.QueryParams());

        assertNotNull(result);
        assertNotNull(result.getItems());
        assertEquals(50, result.getItems().size());

        assertNotNull(result.getPageInfo());
        assertEquals(50, result.getPageInfo().getPageSize());
        assertNotNull(result.getPageInfo().getAfter());

    }

    @Test
    void testGetLess() {
        MessagesResource.QueryParams queryParams = new MessagesResource.QueryParams();
        queryParams.pageSize(10);
        CursorResult<KnockMessage> result = client.messages().list(queryParams);

        assertNotNull(result);
        assertNotNull(result.getItems());
        assertEquals(10, result.getItems().size());
    }

    @Test
    void testGetNext() {
        MessagesResource.QueryParams queryParams = new MessagesResource.QueryParams();
        queryParams.pageSize(10);
        CursorResult<KnockMessage> result = client.messages().list(queryParams);

        Set<String> ids_1 = result.getItems().stream()
                .map(KnockMessage::getId)
                .collect(Collectors.toSet());

        queryParams.after(result.getPageInfo().getAfter());
        CursorResult<KnockMessage> result2 = client.messages().list(queryParams);

        Set<String> ids_2 = result2.getItems().stream()
                .map(knockMessage -> knockMessage.getId())
                .collect(Collectors.toSet());

        ids_1.retainAll(ids_2);

        assertEquals(0, ids_1.size());

    }

    @Test
    void testGetOneMessageById() {
        MessagesResource.QueryParams queryParams = new MessagesResource.QueryParams();
        queryParams.pageSize(10);

        CursorResult<KnockMessage> result = client.messages().list(queryParams);

        KnockMessage knockMessage = result.getItems().stream().findFirst().orElseGet(() -> null);
        assertNotNull(knockMessage, "Need a message to retrieve events");

        KnockMessage singleKnockMessage = client.messages().get(knockMessage.getId());
        assertNotNull(singleKnockMessage);
        assertEquals(knockMessage.getId(), singleKnockMessage.getId());
    }

    @Test
    void testGetOneMessageById_missing() {
        try {
            KnockMessage knockMessage = client.messages().get("lkj32lkjsdf3");
            fail("expected resource_missing error");
        } catch (KnockClientResourceException e) {
            assertEquals("resource_missing", e.knockErrorResponse.getCode());
            assertEquals("The resource you requested does not exist", e.knockErrorResponse.getMessage());
            assertEquals(404, e.knockErrorResponse.getStatus());
            assertEquals("api_error", e.knockErrorResponse.getType());
        }
    }

    @Test
    void testGetEvents() {
        MessagesResource.QueryParams queryParams = new MessagesResource.QueryParams();
        queryParams.pageSize(10);

        KnockMessage knockMessage = getOneMessage();

        CursorResult<KnockMessageEvent> eventResult = client.messages().events(knockMessage.getId(), queryParams);
        assertNotNull(eventResult);
        assertTrue(eventResult.getItems().size() > 0);
    }

    @Test
    void testGetActivities() {
        MessagesResource.QueryParams queryParams = new MessagesResource.QueryParams();
        queryParams.pageSize(10);

        KnockMessage knockMessage = getOneMessage();

        CursorResult<Activity> activitiesResult = client.messages().activities(knockMessage.getId(), queryParams);
        assertNotNull(activitiesResult);
        assertTrue(activitiesResult.getItems().size() > 0);
    }

    @Test
    void testGetContent() {
        KnockMessage knockMessage = getOneMessage();

        KnockMessageContent messageContent = client.messages().content(knockMessage.getId());
        assertNotNull(messageContent);
        assertNotNull(messageContent.getData());
        assertTrue(messageContent.getData().size() > 0);
    }

    @Test
    void testSetAndDeleteStatus() {
        KnockMessage knockMessage = getOneMessage();

        if (knockMessage.getSeenAt() == null) {
            KnockMessage updatedMessage = client.messages().setStatus(knockMessage.getId(), "seen");
            assertNotNull(updatedMessage.getSeenAt());
            assertNotEquals(knockMessage.getSeenAt(), updatedMessage.getSeenAt());
        } else {
            KnockMessage updatedMessage = client.messages().deleteStatus(knockMessage.getId(), "seen");
            assertNull(updatedMessage.getSeenAt());
            assertNotEquals(knockMessage.getSeenAt(), updatedMessage.getSeenAt());
        }

        knockMessage = getOneMessage();
        if (knockMessage.getReadAt() == null) {
            KnockMessage updatedMessage = client.messages().setStatus(knockMessage.getId(), "read");
            assertNotNull(updatedMessage.getReadAt());
            assertNotEquals(knockMessage.getReadAt(), updatedMessage.getReadAt());
        } else {
            KnockMessage updatedMessage = client.messages().deleteStatus(knockMessage.getId(), "read");
            assertNull(updatedMessage.getReadAt());
            assertNotEquals(knockMessage.getReadAt(), updatedMessage.getReadAt());
        }

        knockMessage = getOneMessage();
        if (knockMessage.getArchivedAt() == null) {
            KnockMessage updatedMessage = client.messages().setStatus(knockMessage.getId(), "archived");
            assertNotNull(updatedMessage.getArchivedAt());
            assertNotEquals(knockMessage.getArchivedAt(), updatedMessage.getArchivedAt());
        } else {
            KnockMessage updatedMessage = client.messages().deleteStatus(knockMessage.getId(), "archived");
            assertNull(updatedMessage.getArchivedAt());
            assertNotEquals(knockMessage.getArchivedAt(), updatedMessage.getArchivedAt());
        }

    }

    @Test
    public void testBatchSetStatus() {
        MessagesResource.QueryParams queryParams = new MessagesResource.QueryParams();
        queryParams.pageSize(10);

        // Retrieve 10 unseen messages
        CursorResult<KnockMessage> result = client.messages().list(queryParams);
        List<String> unseenMessageIds = result.getItems().stream()
                .filter(msg -> msg.getSeenAt() == null)
                .map(KnockMessage::getId)
                .collect(Collectors.toList());

        Integer unseenCount = unseenMessageIds.size();

        // set to seen.
        BatchSetMessageStatusRequest request = BatchSetMessageStatusRequest.builder().messageIds(unseenMessageIds).build();
        List<KnockMessage> seenMessages = client.messages().batchSetStatus("seen", request);
        List<String> seenMessageIds = seenMessages.stream()
                .filter(msg -> msg.getSeenAt() != null)
                .map(KnockMessage::getId)
                .collect(Collectors.toList());

        assertEquals(unseenCount, seenMessageIds.size());

        // revert to unseen
        BatchSetMessageStatusRequest revertRequest = BatchSetMessageStatusRequest.builder().messageIds(seenMessageIds).build();
        List<KnockMessage> revertedMessages = client.messages().batchSetStatus("unseen", revertRequest);
        assertEquals(unseenCount, revertedMessages.size());
    }

    @Test
    public void testBulkOperation() {
        BulkChannelMessageStatusRequest request = BulkChannelMessageStatusRequest.builder()
                .deliveryStatus("sent")
                .build();

        BulkOperation bulkOperation = client.messages().bulkSetStatusInChannel("46952393-13fd-40c7-a453-5195a4261a54", "seen", request);

        assertTrue(client.bulkOperations().oGet(bulkOperation.getId()).isPresent());
    }

}
