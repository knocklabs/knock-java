package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.WorkflowCancelRequest;
import app.knock.api.model.WorkflowTriggerRequest;
import app.knock.api.model.WorkflowTriggerResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

@Value
@EqualsAndHashCode(callSuper = false)
public class WorkflowsResource {

    private static final String BASE_RESOURCE_PATH = "v1/workflows";

    KnockHttp knockHttp;

    HttpUrl workflowUrl(String key, String action) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, key, action).build();
    }

    /**
     * Trigger a Knock workflow.
     *
     * @param workflowTrigger
     * @return the result of the workflow trigger
     * @throws KnockClientResourceException
     */
    public WorkflowTriggerResponse trigger(WorkflowTriggerRequest workflowTrigger) {
        HttpUrl url = workflowUrl(workflowTrigger.getKey(), "trigger");
        RequestBody body = knockHttp.objectToJsonRequestBody(workflowTrigger);
        Request request = knockHttp.baseJsonRequest(url)
                .post(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    /**
     * Uses the cancellationKey, and recipients attributes of the WorkflowCancelRequest to cancel
     * the workflow for the specified recipients.
     *
     * @param workflowCancelRequest
     * @throws KnockClientResourceException
     */
    public void cancel(WorkflowCancelRequest workflowCancelRequest) {
        HttpUrl url = workflowUrl(workflowCancelRequest.getKey(), "cancel");
        RequestBody body = knockHttp.objectToJsonRequestBody(workflowCancelRequest);
        Request request = knockHttp.baseJsonRequest(url)
                .post(body)
                .build();

        knockHttp.execute(request);
    }

}
