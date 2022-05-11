package app.knock.api.model;

import app.knock.api.serialize.Json;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserIdentitySerializeTests {

    @Test
    void mappedPropertiesShouldUnwrap() {
        UserIdentity userIdentity = new UserIdentity.UserIdentityBuilder()
                .customProperties(Map.of("customProperty", "123", "custom_property", "hello!"))
                .build();

        String json = Json.writeString(userIdentity);

        assertEquals("{\"id\":null,\"name\":null,\"email\":null,\"avatar\":null,\"phone_number\":null,\"customProperty\":\"123\",\"custom_property\":\"hello!\"}", json);
    }

}
