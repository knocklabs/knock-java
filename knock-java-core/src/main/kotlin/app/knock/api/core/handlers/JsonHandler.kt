@file:JvmName("JsonHandler")

package app.knock.api.core.handlers

import app.knock.api.core.http.HttpResponse
import app.knock.api.core.http.HttpResponse.Handler
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw KnockInvalidDataException("Error reading response", e)
            }
    }
