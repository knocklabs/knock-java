package app.knock.api.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedCursorResult {

    List<FeedItem> entries;
    PageInfo pageInfo;
    FeedMetadata meta;
    Map<String, Object> vars;

}
