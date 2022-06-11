package app.knock.api.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Jacksonized
@Builder
public class BatchSetMessageStatusRequest {
    List<String> messageIds;
}
