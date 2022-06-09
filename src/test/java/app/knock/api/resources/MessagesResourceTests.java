package app.knock.api.resources;

import app.knock.api.http.KnockHttp;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class MessagesResourceTests {

    MessagesResource messagesResource;

    @BeforeEach
    void setup() {
        OkHttpClient httpClient = mock(OkHttpClient.class);
        KnockHttp knockHttp = new KnockHttp(httpClient, "https://notreal.app");
        this.messagesResource = new MessagesResource(knockHttp);
    }

    @Test
    void buildBaseResource() {
        MessagesResource.QueryParams queryParams = new MessagesResource.QueryParams();
        queryParams.pageSize(34);
        queryParams.after("aaaa");
        queryParams.before("cccc");
        queryParams.channel_id("1234");
        queryParams.tenant("5678");
        queryParams.source("7890");
        queryParams.status(new String[]{"queued", "sent"});

        HttpUrl url = this.messagesResource.buildListResource(queryParams);
        assertEquals("https://notreal.app/v1/messages?after=aaaa&before=cccc&channel_id=1234&page_size=34&source=7890&status=%5Bqueued%2C%20sent%5D&tenant=5678", url.toString());
    }

}
