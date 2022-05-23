package app.knock.api.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class WorkflowTriggerResult {
    String workflowRunId;
}
