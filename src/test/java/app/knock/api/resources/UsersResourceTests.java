package app.knock.api.resources;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class UsersResourceTests {

    UsersResource usersResource;

    @BeforeEach
    void setup() {
        OkHttpClient httpClient = mock(OkHttpClient.class);
        this.usersResource = new UsersResource("https://notreal.app", httpClient);
    }

    @Test
    void buildBaseResource() {
        HttpUrl url = this.usersResource.buildBaseResource("123");
        assertEquals("https://notreal.app/v1/users/123", url.toString());
    }

}
