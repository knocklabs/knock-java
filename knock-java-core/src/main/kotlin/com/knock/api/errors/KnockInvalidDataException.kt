package com.knock.api.errors

class KnockInvalidDataException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : KnockException(message, cause)
