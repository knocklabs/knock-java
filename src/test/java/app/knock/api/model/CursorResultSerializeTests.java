package app.knock.api.model;

import app.knock.api.serialize.Json;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CursorResultSerializeTests {


    @Test
    void buildMessageWithRecipientIdentifier() {
        List<KnockMessage> entries = Arrays.asList(
                KnockMessage.builder()
                        .id("1")
                        .cursor("aaa")
                        .recipient("recipient_1")
                        .build(),
                KnockMessage.builder()
                        .id("2")
                        .cursor("bbb")
                        .recipient("recipient_2")
                        .build(),
                KnockMessage.builder()
                        .id("3")
                        .cursor("ccc")
                        .recipient("recipient_3")
                        .build()
        );

        CursorResult<KnockMessage> cursorResult = CursorResult.<KnockMessage>builder()
                .items(entries)
                .pageInfo(PageInfo.builder()
                        .before("aaa")
                        .after("ccc")
                        .pageSize(3)
                        .build())
                .build();

        String json = Json.writeString(cursorResult);

        assertTrue(json.contains("\"id\":\"1\""));
        assertTrue(json.contains("\"id\":\"2\""));
        assertTrue(json.contains("\"id\":\"3\""));
        assertTrue(json.contains("\"__cursor\":\"aaa\""));
        assertTrue(json.contains("\"__cursor\":\"bbb\""));
        assertTrue(json.contains("\"__cursor\":\"ccc\""));
        assertTrue(json.contains("\"before\":\"aaa\""));
        assertTrue(json.contains("\"after\":\"ccc\""));
        assertTrue(json.contains("\"page_size\":3"));
    }

}
