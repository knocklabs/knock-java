package app.knock.api.model;

import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChannelDataSerializeTests {

    String json = "{\"channel_id\":\"c2189f43-c732-488a-bfa0-fdf16e145cdf\",\"data\":{\"tokens\":[\"some-fcm-token\"]},\"__typename\":\"ChannelData\"}";

    @Test
    void jsonShouldDeserialize() {

        ChannelData data = Json.readBytes(json.getBytes(StandardCharsets.UTF_8), new TypeReference<>() {});

        assertEquals("ChannelData", data.getTypeName());
        assertEquals("c2189f43-c732-488a-bfa0-fdf16e145cdf", data.getChannelId());

        List<String> tokens = (List<String>)data.getData().get("tokens");
        assertEquals(List.of("some-fcm-token"), tokens);
    }

    @Test
    void shouldSerializeJsonCorrectly() {
        ChannelData data = ChannelData.builder()
                .typeName("ChannelData")
                .channelId("c2189f43-c732-488a-bfa0-fdf16e145cdf")
                .data("tokens", List.of("some-fcm-token"))
                .build();

        String result = Json.writeString(data);

        assertEquals(json, result);
    }
}
