package app.knock.api.errors

import app.knock.api.core.http.Headers

class UnprocessableEntityException(headers: Headers, body: String, error: KnockError) :
    KnockServiceException(422, headers, body, error)
