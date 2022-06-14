package app.knock.api.resources;

import app.knock.api.KnockClient;
import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.model.*;
import app.knock.api.serialize.Json;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UsersResourceTestsIT {

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
        UserIdentity userIdentity = client.users().identify("user_1", UserIdentity.builder()
                .name("User name")
                .email("user@gmail.com")
                .property("foo", "bar")
                .property("baz", true)
                .build());

        assertEquals("user_1", userIdentity.getId());
        assertEquals("User name", userIdentity.getName());
        assertEquals("user@gmail.com", userIdentity.getEmail());
        assertEquals("bar", userIdentity.property("foo", String.class));
        assertEquals(true, userIdentity.property("baz", Boolean.class));
    }

    @Test
    void shouldDeleteUserIdentity() {
        UserIdentity userIdentity = client.users().identify("test_delete_me", UserIdentity.builder()
                .name("User name")
                .email("user@gmail.com")
                .property("foo", "bar")
                .property("baz", true)
                .build());

        assertTrue(client.users().oGet("test_delete_me").isPresent());
        client.users().delete("test_delete_me");
        assertTrue(client.users().oGet("test_delete_me").isEmpty());
    }

    @Test
    void shouldGetPreferences() {
        UserIdentity userIdentity = client.users().identify("test_user_preferences", UserIdentity.builder()
                .name("User Pref Test")
                .email("user_pref@example.com")
                .build());

        List<PreferenceSet> preferenceSets = client.users().getPreferences("user_1");
        assertEquals(1, preferenceSets.size());
        assertEquals("default", preferenceSets.get(0).getId());
    }

    @Test
    void getUser() {
        UserIdentity userIdentity = client.users().identify("test_get_user", UserIdentity.builder()
                .name("User name")
                .email("test_get_user@example.com")
                .property("foo", "bar")
                .property("baz", true)
                .build());

        assertNotNull(client.users().get("test_get_user"));
        assertNotNull(client.users().oGet("test_get_user").get());
        assertNull(client.users().oGet("askfjlsejfes").orElse(null));

        try {
            client.users().get("askfjlsejfes");
            fail("there should be no user found");
        } catch (KnockClientResourceException e) {
            assertEquals("resource_missing", e.knockErrorResponse.getCode());
            assertEquals("The resource you requested does not exist", e.knockErrorResponse.getMessage());
            assertEquals(404, e.knockErrorResponse.getStatus());
            assertEquals("api_error", e.knockErrorResponse.getType());
        }
    }

    @Test
    void userChannelDataManipulation() {
        UserIdentity userIdentity = client.users().identify("test_get_user", UserIdentity.builder()
                .name("User name")
                .email("test_get_user@gmail.com")
                .property("foo", "bar")
                .property("baz", true)
                .build());

        String userId = userIdentity.getId();
        String channelId = "7341aee6-3956-4977-b0f4-032ac1e74336";

        client.users().unsetUserChannelData(userId, channelId);

        Assertions.assertThrows(KnockClientResourceException.class, () -> {
            client.users().getUserChannelData(userId, channelId);
        });

        ChannelData data = client.users().setChannelData(userId, channelId, Map.of("tokens", List.of("some-token")));
        ChannelData newData = client.users().getUserChannelData(userId, channelId);

        assertEquals(data, newData);
        assertEquals("some-token", ((List<String>) data.getData().get("tokens")).get(0));
        assertEquals("some-token", ((List<String>) newData.getData().get("tokens")).get(0));

        client.users().unsetUserChannelData(userId, channelId);
        client.users().delete(userId);
    }

    @Test
    void userFeed() {
        UsersResource.FeedQueryParams query = new UsersResource.FeedQueryParams();
        query.pageSize(5);

        FeedCursorResult feedCursorResult = client.users().feedItems("workflow_test_recipient_id_1", "46952393-13fd-40c7-a453-5195a4261a54", query);

        assertNotNull(feedCursorResult);
        assertEquals(5, feedCursorResult.getEntries().size());
        assertNull(feedCursorResult.getPageInfo().getBefore());
        assertNotNull(feedCursorResult.getPageInfo().getAfter());
    }

    @Test
    void testSetPreferences() {
        UserIdentity userIdentity = client.users().identify("test_user_preferences", UserIdentity.builder()
                .name("Test User Preferences")
                .email("test_user_preferences@gmail.com")
                .build());

        Map<String, Object> workflowPreferences = new UserPreferenceBuilder()
                .email(false)
                .sms(true)
                .condition("recipient.other_ids", "not_contains", "data.other_id")
                .build();

        Map<String, Object> otherCategoryPreferences = new UserPreferenceBuilder()
                .condition("recipient.muted_alert_ids", "not_contains", "data.alert_id")
                .condition("recipient.other_ids", "not_contains", "data.other_id")
                .build();

        PreferenceSetRequest request = PreferenceSetRequest.builder()
                .channelTypes(new UserPreferenceBuilder()
                        .email(true)
                        .buildChannelTypes())
                .workflow("new-feature", workflowPreferences)
                .category("other", otherCategoryPreferences)
                .build();

        String json = Json.writeString(request);

        client.users().setPreferences("test_user_preferences", request);

        PreferenceSet defaultPreferences = client.users().getDefaultPreferences("test_user_preferences");

        assertEquals(true, defaultPreferences.getChannelTypes().get("email"));
        assertEquals(workflowPreferences, defaultPreferences.getWorkflows().get("new-feature"));


    }
}
