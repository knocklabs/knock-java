package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

@Value
@EqualsAndHashCode(callSuper = false)
public class TenantsResource {

  private static final String BASE_RESOURCE_PATH = "v1/tenants";

  KnockHttp knockHttp;

  HttpUrl buildListResource(QueryParams queryParams) {
    HttpUrl.Builder urlBuilder = knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH);
    queryParams.addQueryParams(urlBuilder);
    return urlBuilder.build();
  }

  HttpUrl tenantUrl(String tenantId) {
    return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, tenantId).build();
  }

  /**
   * Retrieve Tenants
   *
   * @param queryParams
   * @return a cursor result of tenants
   * @throws KnockClientResourceException
   */
  public CursorResult<Tenant> list(QueryParams queryParams) {
    HttpUrl url = buildListResource(queryParams);
    Request request = knockHttp.baseJsonRequest(url).get().build();

    return knockHttp.executeWithResponseType(
      request,
      new TypeReference<CursorResult<Tenant>>() {}
    );
  }

  /**
   * Retrieve a Tenant
   *
   * @param tenantId
   * @throws KnockClientResourceException Unable able to retrieve Tenant from the resource
   * @return Tenant
   */
  public Tenant get(String tenantId) {
    HttpUrl url = tenantUrl(tenantId);
    Request request = knockHttp.baseJsonRequest(url).get().build();
    return knockHttp.executeWithResponseType(
      request,
      new TypeReference<Tenant>() {}
    );
  }

  /**
   * Set a map of data for a specific Tenant.
   *
   * @param tenantId
   * @param tenantData
   * @return
   */
  public Tenant set(String tenantId, Map<String, Object> tenantData) {
    HttpUrl url = tenantUrl(tenantId);
    RequestBody body = knockHttp.objectToJsonRequestBody(tenantData);
    Request request = knockHttp.baseJsonRequest(url).put(body).build();
    return knockHttp.executeWithResponseType(
      request,
      new TypeReference<Tenant>() {}
    );
  }

  /**
   * Delete a specific Tenant
   *
   * @param tenantId
   */
  public void delete(String tenantId) {
    HttpUrl url = tenantUrl(tenantId);
    Request request = knockHttp.baseJsonRequest(url).delete().build();
    knockHttp.execute(request);
  }

  @Value
  @EqualsAndHashCode(callSuper = false)
  public static class QueryParams {

    private final Map<String, Object> params = new HashMap<>();

    public void pageSize(Integer pageSize) {
      params.put("page_size", pageSize);
    }

    public void after(String after) {
      params.put("after", after);
    }

    public void before(String before) {
      params.put("before", before);
    }

    public void tenantId(String tenantId) {
      params.put("tenantId", tenantId);
    }

    public void name(String name) {
      params.put("name", name);
    }

    public void addQueryParams(HttpUrl.Builder uriBuilder) {
      params
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .forEach(
          entry ->
            uriBuilder.addQueryParameter(
              entry.getKey(),
              entry.getValue().toString()
            )
        );
    }
  }
}
