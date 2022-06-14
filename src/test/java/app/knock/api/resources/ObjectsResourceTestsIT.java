package app.knock.api.resources;

import app.knock.api.KnockClient;
import app.knock.api.model.KnockObject;
import app.knock.api.model.PreferenceSetRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectsResourceTestsIT {

    KnockClient client;

    final String collectionId = "hello";
    final String objectId = "test-object-app";
    final String preferenceId = "project-1";

    @BeforeEach
    void setup() {
        this.client = KnockClient.builder().build();
    }

    @Test
    void setAndGetObject() {
        KnockObject object = this.client.objects().set(collectionId, objectId, Map.of("test", "value"));
        assertEquals("test-object-app", object.getId());
    }

    @Test
    void getPreferences() {
        var preferenceSet = this.client.objects().getPreferences(collectionId, objectId);

        assertEquals(1, preferenceSet.size());
    }

    @Test
    void setPreferences() {
        var preferenceSetRequest = PreferenceSetRequest.builder()
                .category("park-wide", Map.of("sms", false))
                .workflow("dinosaurs-loose", Map.of("channel_types", Map.of("email", true, "sms", true)))
                .build();
        var preferenceSet = this.client.objects().setPreferences(collectionId, objectId, preferenceId, preferenceSetRequest);

        assertEquals(1, preferenceSet.getCategories().size());
    }
}
