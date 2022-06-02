package app.knock.api.resources;

import app.knock.api.KnockClient;
import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.model.UserIdentity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        client.users().delete("user_1");
    }

    @Test
    void getUser() {
        UserIdentity userIdentity = client.users().identify("test_get_user", UserIdentity.builder()
                .name("User name")
                .email("test_get_user@gmail.com")
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
}
