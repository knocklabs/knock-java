package app.knock.api.model;

import app.knock.api.serialize.Json;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserIdentitySerializeTests {

    @Test
    void mappedPropertiesShouldUnwrap() {
        UserIdentity userIdentity = new UserIdentity.UserIdentityBuilder()
                .property("customProperty", "123")
                .property("custom_property", "hello!")
                .build();

        String json = Json.writeString(userIdentity);

        assertTrue(json.contains("\"customProperty\":\"123\""));
        assertTrue(json.contains("\"custom_property\":\"hello!\""));
    }

}
