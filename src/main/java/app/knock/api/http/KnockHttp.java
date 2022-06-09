package app.knock.api.http;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.model.KnockErrorResponse;
import app.knock.api.serialize.Json;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import okhttp3.*;

import java.io.IOException;

@Getter
public class KnockHttp {

    private final OkHttpClient client;

    private final HttpUrl httpUrl;

    public KnockHttp(OkHttpClient client, String baseUrl) {
        this.client = client;
        this.httpUrl = HttpUrl.parse(baseUrl);
    }

    public HttpUrl.Builder baseUrlBuilder(String baseUrl, String ... pathSegments) {
        HttpUrl.Builder urlBuilder = httpUrl.newBuilder();

        urlBuilder.addPathSegments(baseUrl);

        for (String pathSegment: pathSegments) {
            urlBuilder.addEncodedPathSegment(pathSegment);
        }
        return urlBuilder;
    }

    public Request.Builder baseJsonRequest(HttpUrl httpUrl) {
       return new Request.Builder()
                .url(httpUrl)
                .addHeader("Content-Type", "application/json");
    }

    public RequestBody objectToJsonRequestBody(Object object) {
        return RequestBody.create(Json.writeBytes(object));
    }

    public void execute(Request request) {
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                KnockErrorResponse errorResponse = Json.readBytes(response.body().bytes(), KnockErrorResponse.class);
                throw new KnockClientResourceException(errorResponse);
            }
        } catch (IOException e) {
            throw new KnockClientResourceException("an error occurred while calling a knock endpoint", e);
        }
    }

    public <T> T executeWithResponseType(Request request, TypeReference<T> typeRef) {
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                KnockErrorResponse errorResponse = Json.readBytes(response.body().bytes(), KnockErrorResponse.class);
                throw new KnockClientResourceException(errorResponse);
            } else {
                if (response.body() != null) {
                    return Json.readBytes(response.body().bytes(), typeRef);
                }
                throw new KnockClientResourceException("empty response");
            }
        } catch (IOException e) {
            throw new KnockClientResourceException("an error occurred while calling a knock endpoint", e);
        }
    }


}
