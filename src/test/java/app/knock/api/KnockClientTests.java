package app.knock.api;

import app.knock.api.KnockClient.KnockClientBuilder;
import app.knock.api.exception.KnockClientException;
import app.knock.api.util.Environment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class KnockClientTests {

    @Test
    void builderWithEnvVarSet() {
        Environment environment = mock(Environment.class);
        when(environment.getEnvVar(KnockClient.API_KEY_ENV_VAR)).thenReturn("pk_1234");

        KnockClientBuilder builder = new KnockClientBuilder(environment);
        KnockClient client = builder.build();

        assertEquals("https://api.knock.app", client.baseUrl);
        assertEquals("pk_1234", client.apiKey);
    }

    @Test
    void builderNoEnvVarSetErrors() {
        Environment environment = mock(Environment.class);
        when(environment.getEnvVar(KnockClient.API_KEY_ENV_VAR)).thenReturn(null);

        Throwable exception = assertThrows(KnockClientException.class, () -> new KnockClientBuilder(environment).build());

        assertEquals("API Key was not provided", exception.getMessage());
    }

    @Test
    void builderSetsEverything() {
        KnockClient client = KnockClient.builder()
                .apiKey("pk_1234")
                .baseUrl("https://notreal.app")
                .build();

        assertEquals("pk_1234", client.apiKey);
        assertEquals("https://notreal.app", client.baseUrl);
    }

}
