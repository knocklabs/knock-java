package app.knock.api.resources;

import app.knock.api.KnockClient;
import app.knock.api.model.UserIdentity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
