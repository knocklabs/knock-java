package app.knock.api.serialize;

import app.knock.api.exception.KnockClientJsonException;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class Json {

    static ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

    public static <T> String writeString(T obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JacksonException e) {
            throw new KnockClientJsonException("Unable to serialize object as JSON", e);
        }
    }

    public static <T> byte[] writeBytes(T obj) {
        try {
            return objectMapper.writeValueAsBytes(obj);
        } catch (JacksonException e) {
            throw new KnockClientJsonException("Unable to serialize object as JSON", e);
        }
    }

    public static <T> T readBytes(byte[] bytes, Class<T> clazz) {
        try {
            return objectMapper.readValue(bytes, clazz);
        } catch (IOException e) {
            throw new KnockClientJsonException("Unable to convert JSON to object", e);
        }
    }

    public static <T> T readBytes(byte[] bytes, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(bytes, typeReference);
        } catch (IOException e) {
            throw new KnockClientJsonException("Unable to convert JSON to object", e);
        }
    }
}
