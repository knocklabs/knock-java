package app.knock.api.http;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.model.KnockErrorResponse;
import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class KnockHttp {

    public static void execute(OkHttpClient httpClient, Request request) {
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                KnockErrorResponse errorResponse = Json.readBytes(response.body().bytes(), KnockErrorResponse.class);
                throw new KnockClientResourceException(errorResponse);
            }
        } catch (IOException e) {
            throw new KnockClientResourceException("an error occurred while calling a knock endpoint", e);
        }
    }

    public static <T> T execute(OkHttpClient httpClient, Request request, TypeReference<T> typeReference) {
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                KnockErrorResponse errorResponse = Json.readBytes(response.body().bytes(), KnockErrorResponse.class);
                throw new KnockClientResourceException(errorResponse);
            } else {
                if (response.body() != null) {
                    return Json.readBytes(response.body().bytes(), typeReference);
                }
                throw new KnockClientResourceException("empty response");
            }
        } catch (IOException e) {
            throw new KnockClientResourceException("an error occurred while calling a knock endpoint", e);
        }
    }

}
