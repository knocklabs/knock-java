package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.model.UserIdentity;
import app.knock.api.model.WorkflowTrigger;
import app.knock.api.model.WorkflowTriggerResult;
import app.knock.api.serialize.Json;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Value
@EqualsAndHashCode(callSuper = false)
public class WorkflowsResource {

    private static final String BASE_RESOURCE_PATH = "v1/workflows";

    String baseUrl;
    OkHttpClient httpClient;

    public WorkflowTriggerResult trigger(WorkflowTrigger workflowTrigger) {

        byte[] bodyBytes = Json.writeBytes(workflowTrigger);

        Request request = new Request.Builder()
                .url(buildBaseResource(workflowTrigger.getKey()))
                .addHeader("Content-Type", "application/json")
                .post(RequestBody.create(bodyBytes))
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new KnockClientResourceException("bad API response");
            } else {
                if (response.body() != null) {
                    return Json.readBytes(response.body().bytes(), WorkflowTriggerResult.class);
                }
                throw new KnockClientResourceException("empty response");
            }
        } catch (IOException e) {
            throw new KnockClientResourceException("an error occurred while calling the user.identify endpoint", e);
        }
    }

    HttpUrl buildBaseResource(String key) {
        return Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH)
                .addEncodedPathSegment(key)
                .addPathSegments("trigger")
                .build();
    }

}
