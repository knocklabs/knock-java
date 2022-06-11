package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;
import java.util.List;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BulkChannelMessageStatusRequest {
    List<String> userIds;
    ZonedDateTime olderThan;
    ZonedDateTime newerThan;
    String deliveryStatus;
    String engagementStatus;
}
