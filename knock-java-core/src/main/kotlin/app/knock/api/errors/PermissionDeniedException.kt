package app.knock.api.errors

import app.knock.api.core.http.Headers

class PermissionDeniedException(headers: Headers, body: String, error: KnockError) :
    KnockServiceException(403, headers, body, error)
