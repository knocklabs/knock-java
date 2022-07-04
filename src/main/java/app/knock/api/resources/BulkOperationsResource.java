package app.knock.api.resources;

import app.knock.api.exception.KnockClientResourceException;
import app.knock.api.http.KnockHttp;
import app.knock.api.model.BulkOperation;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.EqualsAndHashCode;
import lombok.Value;
import okhttp3.HttpUrl;
import okhttp3.Request;

import java.util.Optional;

@Value
@EqualsAndHashCode(callSuper = false)
public class BulkOperationsResource {

    private static final String BASE_RESOURCE_PATH = "v1/bulk_operations";

    KnockHttp knockHttp;

    HttpUrl bulkOperationUrl(String id) {
        return knockHttp.baseUrlBuilder(BASE_RESOURCE_PATH, id).build();
    }

    /**
     * Get a bulk operation.
     *
     * @param bulkOperationId
     * @return a bulk operation
     * @throws KnockClientResourceException
     */
    public BulkOperation get(String bulkOperationId) {
        HttpUrl url = bulkOperationUrl(bulkOperationId);
        Request request = knockHttp.baseJsonRequest(url)
                .get()
                .build();
        return knockHttp.executeWithResponseType(request, new TypeReference<BulkOperation>() {
        });
    }

    /**
     * Retrieve an optional bulk operation.
     *
     * @param bulkOperationId
     * @return an optional single message
     */
    public Optional<BulkOperation> oGet(String bulkOperationId) {
        try {
            return Optional.of(get(bulkOperationId));
        } catch (KnockClientResourceException e) {
            return Optional.empty();
        }
    }

}
