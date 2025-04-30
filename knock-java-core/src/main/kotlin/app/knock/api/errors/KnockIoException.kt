package app.knock.api.errors

class KnockIoException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : KnockException(message, cause)
