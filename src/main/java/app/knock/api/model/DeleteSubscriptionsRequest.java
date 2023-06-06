package app.knock.api.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Value
@Jacksonized
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteSubscriptionsRequest {

    @JsonProperty("__typename")
    String typeName;

    List<Object> recipients;

    public static class DeleteSubscriptionsRequestBuilder {

        List<Object> recipients;

        public DeleteSubscriptionsRequestBuilder addRecipient(String... userIds) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, userIds);
            return this;
        }

        public DeleteSubscriptionsRequestBuilder addRecipient(Map<String, Object> recipient) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, recipient);
            return this;
        }

        public DeleteSubscriptionsRequestBuilder addRecipient(ObjectRecipientIdentifier identifier) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, identifier);
            return this;
        }
    }

    @Getter
    @Builder
    public static class ObjectRecipientIdentifier {

        String id;
        String collection;
    }
}
