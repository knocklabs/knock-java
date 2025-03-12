package app.knock.api.errors

import app.knock.api.core.http.Headers

class NotFoundException(
        headers: Headers,
        body: String,
        error: KnockError,
) : KnockServiceException(404, headers, body, error)
