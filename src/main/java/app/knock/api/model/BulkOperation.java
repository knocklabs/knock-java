package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BulkOperation {
    @JsonProperty("__typename")
    String typeName;
    String id;
    String name;
    ZonedDateTime completedAt;
    ZonedDateTime insertedAt;
    ZonedDateTime updatedAt;
    ZonedDateTime failedAt;
    Integer estimatedTotalRows;
    Integer processedRows;
    String progressPath;
    String status;
}
