package app.knock.api.resources;

import app.knock.api.KnockClient;
import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TenantsResourceTestsIT {

    KnockClient client;

    final String tenantId = "tenant123";

    @BeforeEach
    void setup() {
        this.client = KnockClient.builder().build();
    }
    @Test
    void testGetAllTenants() {
        CursorResult<Tenant> result = client.tenants().list(new TenantsResource.QueryParams());

        assertNotNull(result);
        assertNotNull(result.getItems());
        assertEquals(50, result.getItems().size());

        assertNotNull(result.getPageInfo());
        assertEquals(50, result.getPageInfo().getPageSize());
        assertNotNull(result.getPageInfo().getAfter());
    }

    @Test
    void setAndGetTenant() {
        Tenant tenant = this.client.tenants().set(tenantId, Map.of("name", "Tenant123"));
        assertEquals("tenant123", tenant.getId());
    }

    @Test
    void deleteTenant() {
        Tenant tenant = this.client.tenants().set(tenantId, Map.of("name", "Tenant123"));
        this.client.tenants().delete(tenantId);
        assertNull(tenant.getId());
    }
}
