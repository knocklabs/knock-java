package app.knock.api.resources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import app.knock.api.http.KnockHttp;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TenantsResourceTests {

  TenantsResource tenantsResource;

  @BeforeEach
  void setup() {
    OkHttpClient httpClient = mock(OkHttpClient.class);
    KnockHttp knockHttp = new KnockHttp(httpClient, "https://notreal.app");
    this.tenantsResource = new TenantsResource(knockHttp);
  }

  @Test
  void buildBaseResource() {
    TenantsResource.QueryParams queryParams = new TenantsResource.QueryParams();
    queryParams.pageSize(50);
    queryParams.after("aaaa");
    queryParams.before("cccc");
    queryParams.tenantId("tenant123");
    queryParams.name("Tenant123");

    HttpUrl url = this.tenantsResource.buildListResource(queryParams);
    assertEquals(
      "https://notreal.app/v1/tenants?after=aaaa&before=cccc&name=Tenant123&page_size=50&tenantId=tenant123",
      url.toString()
    );
  }
}
