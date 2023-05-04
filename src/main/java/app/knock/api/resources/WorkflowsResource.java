package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.util.*;

@Value
@EqualsAndHashCode(callSuper = false)
public class WorkflowsResource {

    private static final String BASE_RESOURCE_PATH = "v1/workflows";
    private static final String BASE_SCHEDULES_RESOURCE_PATH = "v1/schedules";

    KnockHttp knockHttp;

    HttpUrl workflowUrl(String key, String action) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, key, action).build();
    }

    HttpUrl buildListResource(SchedulesQueryParams queryParams) {
        HttpUrl.Builder urlBuilder = knockHttp.baseUrlBuilder(BASE_SCHEDULES_RESOURCE_PATH);
        queryParams.addQueryParams(urlBuilder);
        return urlBuilder.build();
    }

    /**
     * Trigger a Knock workflow.
     *
     * @param workflowTrigger  The workflow trigger request to send
     * @return the result of the workflow trigger
     * @throws KnockClientResourceException
     */
    public WorkflowTriggerResponse trigger(WorkflowTriggerRequest workflowTrigger) {
        return trigger(workflowTrigger, null);
    }

    /**
     * Trigger a Knock workflow.
     *
     * @param workflowTrigger  The workflow trigger request to send
     * @param methodOptions  Optional HTTP method options, e.g. to set the idempotency key of the request
     * @return the result of the workflow trigger
     * @throws KnockClientResourceException
     */
    public WorkflowTriggerResponse trigger(WorkflowTriggerRequest workflowTrigger, MethodOptions methodOptions) {
        HttpUrl url = workflowUrl(workflowTrigger.getKey(), "trigger");
        RequestBody body = knockHttp.objectToJsonRequestBody(workflowTrigger);
        Request.Builder requestBuilder = knockHttp.baseJsonRequest(url)
                .post(body);

        if (methodOptions != null && methodOptions.getIdempotencyKey() != null) {
            requestBuilder.addHeader("Idempotency-Key", methodOptions.getIdempotencyKey());
        }

        Request request = requestBuilder.build();
        return knockHttp.executeWithResponseType(request, new TypeReference<WorkflowTriggerResponse>() {
        });
    }

    /**
     * Uses the cancellationKey, and recipients attributes of the
     * WorkflowCancelRequest to cancel
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

    /**
     * Create schedules for a given workflow
     *
     * @param createSchedulesRequest  Attributes for schedules creation
     * @return List of created schedules
     * @throws KnockClientResourceException
     */
    public List<Schedule> createSchedules(CreateSchedulesRequest createSchedulesRequest) {
        HttpUrl url = knockHttp.baseUrlBuilder(BASE_SCHEDULES_RESOURCE_PATH).build();
        RequestBody body = knockHttp.objectToJsonRequestBody(createSchedulesRequest);
        Request.Builder requestBuilder = knockHttp.baseJsonRequest(url)
                .post(body);

        Request request = requestBuilder.build();
        return knockHttp.executeWithResponseType(request, new TypeReference<List<Schedule>>() {
        });
    }

    /**
     * Updates schedule instances
     *
     * @param updateSchedulesRequest  Attributes for updating schedules
     * @return List of updated schedules
     * @throws KnockClientResourceException
     */
    public List<Schedule> updateSchedules(UpdateSchedulesRequest updateSchedulesRequest) {
        HttpUrl url = knockHttp.baseUrlBuilder(BASE_SCHEDULES_RESOURCE_PATH).build();
        RequestBody body = knockHttp.objectToJsonRequestBody(updateSchedulesRequest);
        Request.Builder requestBuilder = knockHttp.baseJsonRequest(url)
                .put(body);

        Request request = requestBuilder.build();
        return knockHttp.executeWithResponseType(request, new TypeReference<List<Schedule>>() {
        });
    }

    /**
     * Deletes schedule instances
     *
     * @param deleteSchedulesRequest  Delete request params (schedules to be deleted)
     * @return List of deleted schedules
     * @throws KnockClientResourceException
     */
    public List<Schedule> deleteSchedules(DeleteSchedulesRequest deleteSchedulesRequest) {
        HttpUrl url = knockHttp.baseUrlBuilder(BASE_SCHEDULES_RESOURCE_PATH).build();
        RequestBody body = knockHttp.objectToJsonRequestBody(deleteSchedulesRequest);
        Request.Builder requestBuilder = knockHttp.baseJsonRequest(url)
                .delete(body);

        Request request = requestBuilder.build();
        return knockHttp.executeWithResponseType(request, new TypeReference<List<Schedule>>() {
        });
    }

    /**
     * Retrieve schedules for workflow
     *
     * @return a cursor result of schedules
     * @throws KnockClientResourceException
     */
    public CursorResult<Schedule> listSchedules(String workflowKey, SchedulesQueryParams queryParams) {
        queryParams.workflow(workflowKey);
        HttpUrl url = buildListResource(queryParams);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();

        return knockHttp.executeWithResponseType(request, new TypeReference<CursorResult<Schedule>>() {
        });
    }

    @Value
    @EqualsAndHashCode(callSuper = false)
    public static class SchedulesQueryParams {
        private final Map<String, Object> params = new HashMap<>();

        public void pageSize(Integer pageSize) {
            params.put("page_size", pageSize);
        }

        public void after(String after) {
            params.put("after", after);
        }

        public void before(String before) {
            params.put("before", before);
        }

        public void tenant(String tenant) {
            params.put("tenant", tenant);
        }

        public void workflow(String workflowKey) {
            params.put("workflow", workflowKey);
        }

        public void recipients(String... userIds) {
            params.put("recipients", userIds);
        }

        public void recipients(List<Map<String, Object>> recipients) {
            params.put("recipients", recipients);
        }

        public void addQueryParams(HttpUrl.Builder uriBuilder) {
            params.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> uriBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString()));
        }
    }
}
