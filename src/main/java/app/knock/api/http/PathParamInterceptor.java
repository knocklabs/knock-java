package app.knock.api.http;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

/**
 * Parses an incoming URL and replaces path parameters
 * {@see https://stackoverflow.com/a/36936566}
 */
public class PathParamInterceptor implements Interceptor {

    private final String pathKey;
    private final String pathValue;

    private PathParamInterceptor(String key, String value) {
        this.pathKey = String.format("{%s}", key);
        this.pathValue = value;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest = chain.request();

        HttpUrl.Builder urlBuilder = originalRequest.url().newBuilder();
        List<String> segments = originalRequest.url().pathSegments();

        for (int i = 0; i < segments.size(); i++) {
            if (pathKey.equalsIgnoreCase(segments.get(i))) {
                urlBuilder.setPathSegment(i, this.pathValue);
            }
        }

        Request newRequest = originalRequest.newBuilder()
                .url(urlBuilder.build())
                .build();

        return chain.proceed(newRequest);
    }
}
