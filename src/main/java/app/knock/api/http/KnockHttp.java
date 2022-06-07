package app.knock.api.http;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.model.KnockErrorResponse;
import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

@Getter
public class KnockHttp {

    private final OkHttpClient client;

    private final HttpUrl httpUrl;

    public KnockHttp(OkHttpClient client, String baseUrl) {
        this.client = client;
        this.httpUrl = HttpUrl.parse(baseUrl);
    }

    HttpUrl baseUrlBuilder(String baseResourcePath, List<String> pathSegments) {
        HttpUrl.Builder urlBuilder = httpUrl.newBuilder()
                .addPathSegments(baseResourcePath);

        for (String pathSegment: pathSegments) {
            urlBuilder.addEncodedPathSegment(pathSegment);
        }

        return urlBuilder.build();
    }

    Request buildPutUrl(String baseResourcePath, List<String> pathSegments, byte[] bodyBytes) {
        HttpUrl url = baseUrlBuilder(baseResourcePath, pathSegments);
        return new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .put(RequestBody.create(bodyBytes))
                .build();
    }

    Request buildGetUrl(String baseResourcePath, List<String> pathSegments) {
        HttpUrl url = baseUrlBuilder(baseResourcePath, pathSegments);
        return new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .get()
                .build();
    }

    Request buildDeleteUrl(String baseResourcePath, List<String> pathSegments) {
        HttpUrl url = baseUrlBuilder(baseResourcePath, pathSegments);
        return new Request.Builder()
                .url(url)
                .delete()
                .build();
    }

    public <T> T get(String baseResourcePath, String pathSegment, TypeReference<T> responseType) {
        return this.get(baseResourcePath, List.of(pathSegment), responseType);
    }

    public <T> T get(String baseResourcePath, List<String> pathSegments, TypeReference<T> responseType) {
        Request request = buildGetUrl(baseResourcePath, pathSegments);
        return execute(client, request, responseType);
    }

    public <T> T put(String baseResourcePath, String pathSegment, byte[] bodyBytes, TypeReference<T> responseType) {
        return this.put(baseResourcePath, List.of(pathSegment), bodyBytes, responseType);
    }

    public <T> T put(String baseResourcePath, List<String> pathSegments, byte[] bodyBytes, TypeReference<T> responseType) {
        Request request = buildPutUrl(baseResourcePath, pathSegments, bodyBytes);
        return execute(client, request, responseType);
    }

    public void delete(String baseResourcePath, List<String> pathSegments) {
        Request request = buildDeleteUrl(baseResourcePath, pathSegments);
        execute(client, request);
    }

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

    public static <T> T executeWithResponseType(OkHttpClient httpClient, Request request) {
        return execute(httpClient, request, new TypeReference<>() {});
    }

}
