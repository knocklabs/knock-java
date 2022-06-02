package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.KnockErrorResponse;
import app.knock.api.model.WorkflowTrigger;
import app.knock.api.model.WorkflowTriggerResult;
import app.knock.api.serialize.Json;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.*;

import java.io.IOException;
import java.util.Objects;

@Value
@EqualsAndHashCode(callSuper = false)
public class WorkflowsResource {

    private static final String BASE_RESOURCE_PATH = "v1/workflows";

    String baseUrl;
    OkHttpClient httpClient;

    /**
     * Trigger a Knock workflow.
     *
     * @param workflowTrigger
     * @return the result of the workflow trigger
     * @throws KnockClientResourceException
     */
    public WorkflowTriggerResult trigger(WorkflowTrigger workflowTrigger) {
        byte[] bodyBytes = Json.writeBytes(workflowTrigger);

        Request request = new Request.Builder()
                .url(buildBaseResource(workflowTrigger.getKey(), "trigger"))
                .addHeader("Content-Type", "application/json")
                .post(RequestBody.create(bodyBytes))
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                KnockErrorResponse errorResponse = Json.readBytes(response.body().bytes(), KnockErrorResponse.class);
                throw new KnockClientResourceException(errorResponse);
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

    /**
     * Uses the cancellationKey, and recipients attributes of the WorkflowTrigger to cancel
     * the workflow for the specified recipients.
     *
     * @param workflowTrigger
     * @throws KnockClientResourceException
     */
    public void cancel(WorkflowTrigger workflowTrigger) {
        byte[] bodyBytes = Json.writeBytes(workflowTrigger);

        Request request = new Request.Builder()
                .url(buildBaseResource(workflowTrigger.getKey(), "cancel"))
                .addHeader("Content-Type", "application/json")
                .post(RequestBody.create(bodyBytes))
                .build();

        KnockHttp.execute(httpClient, request);
    }

    HttpUrl buildBaseResource(String key, String action) {
        return Objects.requireNonNull(HttpUrl.parse(baseUrl))
                .newBuilder()
                .addPathSegments(BASE_RESOURCE_PATH)
                .addEncodedPathSegment(key)
                .addPathSegments(action)
                .build();
    }

}
