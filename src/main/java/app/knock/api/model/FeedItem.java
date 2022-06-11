package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedItem {

    @JsonProperty("__typename")
    String typeName;

    @JsonProperty("__cursor")
    String cursor;

    String id;
    String tenant;
    String totalActivities;
    String totalActors;
    ZonedDateTime readAt;
    ZonedDateTime seenAt;
    ZonedDateTime insertedAt;
    ZonedDateTime updatedAt;
    ZonedDateTime archivedAt;

    WorkflowSource workflowSource;
    List<KnockMessageActivity> activities;
    List<Map<String, Object>> actors;
    Map<String, Object> data;
    List<Map<String, Object>> blocks;

}
