package app.knock.api.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
public class MethodOptions {
    /**
     * The idempotency key to use for the request.
     */
    String idempotencyKey;

    public static class MethodOptionsBuilder {

        /**
         * The idempotency key to use for the request.
         *
         * @param idempotencyKey
         * @return
         */
        public MethodOptionsBuilder addIdempotencyKey(String idempotencyKey) {
            this.idempotencyKey = idempotencyKey;
            return this;
        }

    }

}
