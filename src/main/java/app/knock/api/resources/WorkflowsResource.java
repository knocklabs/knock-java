package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.WorkflowTrigger;
import app.knock.api.model.WorkflowTriggerResult;
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
    public WorkflowTriggerResult trigger(WorkflowTrigger workflowTrigger) {
        HttpUrl url = workflowUrl(workflowTrigger.getKey(), "trigger");
        RequestBody body = knockHttp.objectToJsonRequestBody(workflowTrigger);
        Request request = knockHttp.baseJsonRequest(url)
                .post(body)
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<>() {
        });
    }

    /**
     * Uses the cancellationKey, and recipients attributes of the WorkflowTrigger to cancel
     * the workflow for the specified recipients.
     *
     * @param workflowTrigger
     * @throws KnockClientResourceException
     */
    public void cancel(WorkflowTrigger workflowTrigger) {
        HttpUrl url = workflowUrl(workflowTrigger.getKey(), "cancel");
        RequestBody body = knockHttp.objectToJsonRequestBody(workflowTrigger);
        Request request = knockHttp.baseJsonRequest(url)
                .post(body)
                .build();

        knockHttp.execute(request);
    }

}
