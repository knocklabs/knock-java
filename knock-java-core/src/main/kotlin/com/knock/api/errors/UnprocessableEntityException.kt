package com.knock.api.errors

import com.knock.api.core.http.Headers

class UnprocessableEntityException(headers: Headers, body: String, error: KnockError) :
    KnockServiceException(422, headers, body, error)
