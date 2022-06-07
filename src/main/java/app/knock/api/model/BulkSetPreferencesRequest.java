package app.knock.api.model;

import lombok.Value;

import java.util.List;

@Value
public class BulkSetPreferencesRequest {

    List<String> userIds;



}
