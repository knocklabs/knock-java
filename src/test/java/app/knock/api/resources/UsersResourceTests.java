package app.knock.api.resources;

import app.knock.api.http.KnockHttp;
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
        KnockHttp knockHttp = new KnockHttp(httpClient, "https://notreal.app");
        this.usersResource = new UsersResource(knockHttp);
    }

    @Test
    void buildResourceURLs() {
       String userId = "user12345";
       String channelId = "channel1234";
       String preferenceSetId = "pset12345";

       assertEquals("https://notreal.app/v1/users/user12345", this.usersResource.userUrl(userId).toString());
       assertEquals("https://notreal.app/v1/users/user12345/channel_id/channel1234", this.usersResource.userChannelUrl(userId, channelId).toString());
       assertEquals("https://notreal.app/v1/users/user12345/preferences", this.usersResource.userPreferencesUrl(userId).toString());
       assertEquals("https://notreal.app/v1/users/user12345/preferences/pset12345", this.usersResource.userPreferencesUrl(userId, preferenceSetId).toString());
    }

}
