package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkflowCancelRequest {
    String key;
    List<Object> recipients;
    String cancellation_key;

    public static WorkflowCancelRequest from(WorkflowTriggerRequest workflowTrigger) {
        return WorkflowCancelRequest.builder()
                .key(workflowTrigger.getKey())
                .recipients(workflowTrigger.getRecipients())
                .cancellation_key(workflowTrigger.getCancellationKey())
                .build();
    }

}
