package app.knock.api.errors

import app.knock.api.core.http.Headers

class RateLimitException(
        headers: Headers,
        body: String,
        error: KnockError,
) : KnockServiceException(429, headers, body, error)
