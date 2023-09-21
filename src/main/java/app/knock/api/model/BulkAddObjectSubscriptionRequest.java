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
public class BulkAddObjectSubscriptionRequest {

    @JsonProperty("__typename")
    String typeName;

    String id;
    List<Object> recipients;

    @Singular("properties")
    @JsonAnySetter
    Map<String, Object> properties;

    public <T> T properties(String key, Class<T> clazz) {
        if (this.properties != null && this.properties.containsKey(key)) {
            Object o = this.properties.get(key);
            return clazz.isInstance(o) ? clazz.cast(o) : null;
        }
        return null;
    }

    public static class BulkAddObjectSubscriptionRequestBuilder {

        List<Object> recipients;

        public BulkAddObjectSubscriptionRequestBuilder addRecipient(String... userIds) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, userIds);
            return this;
        }

        public BulkAddObjectSubscriptionRequestBuilder addRecipient(Map<String, Object> recipient) {
            if (this.recipients == null) { this.recipients = new ArrayList<>(); }
            Collections.addAll(this.recipients, recipient);
            return this;
        }

        public BulkAddObjectSubscriptionRequestBuilder addRecipient(ObjectRecipientIdentifier identifier) {
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
