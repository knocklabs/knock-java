package app.knock.api.resources;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class WorkflowsResourceTest {

    WorkflowsResource workflowsResource;

    @BeforeEach
    void setup() {
        OkHttpClient httpClient = mock(OkHttpClient.class);
        this.workflowsResource = new WorkflowsResource("https://notreal.app", httpClient);
    }

    @Test
    void buildBaseResource() {
        HttpUrl url = this.workflowsResource.buildBaseResource("test-key", "trigger");
        assertEquals("https://notreal.app/v1/workflows/test-key/trigger", url.toString());
    }

}
