package app.knock.api.http;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.serialize.Json;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public abstract class RequestExecutorService {

    private RequestExecutorService() {}

    public static <T> T executeRequest(OkHttpClient httpClient, Request request, Class<T> clazz, boolean hasResponseBody) {
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new KnockClientResourceException("bad API response");
            } else {
                if (hasResponseBody) {
                    if (response.body() != null) {
                        return Json.readBytes(response.body().bytes(), clazz);
                    }
                    throw new KnockClientResourceException("empty response");
                } else {
                    return null;
                }
            }
        } catch (IOException e) {
            throw new KnockClientResourceException("an error occurred while calling the user.identify endpoint", e);
        }
    }

    public static <T> T executeRequestForResponse(OkHttpClient httpClient, Request request, Class<T> clazz) {
        return executeRequest(httpClient, request, clazz, true);
    }

}
