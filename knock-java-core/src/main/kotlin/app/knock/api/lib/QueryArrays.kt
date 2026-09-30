package app.knock.api.lib

import app.knock.api.core.http.QueryParams
import app.knock.api.models.recipients.RecipientReference

/**
 * An element of an array query parameter: either a scalar (e.g. a user ID) or a set of fields
 * (e.g. an object reference's `id` and `collection`).
 */
internal sealed class QueryArrayElement {

    internal class Value(val value: String) : QueryArrayElement()

    internal class Fields(val fields: List<Pair<String, String>>) : QueryArrayElement()
}

/**
 * Serializes an array query parameter in the forms the Knock API accepts.
 *
 * Arrays of scalars use the bracket form (`key[]=a&key[]=b`). Any array containing an object uses
 * the indexed form for every element (`key[0]=a&key[1][id]=b&key[1][collection]=c`), because the
 * API rejects `key[][id]=...` with a 422.
 */
internal fun QueryParams.Builder.putQueryArray(key: String, elements: List<QueryArrayElement>) {
    if (elements.all { it is QueryArrayElement.Value }) {
        elements.forEach { put("$key[]", (it as QueryArrayElement.Value).value) }
        return
    }
    elements.forEachIndexed { index, element ->
        when (element) {
            is QueryArrayElement.Value -> put("$key[$index]", element.value)
            is QueryArrayElement.Fields ->
                element.fields.forEach { (field, value) -> put("$key[$index][$field]", value) }
        }
    }
}

/** Serializes a single object-valued query parameter as `key[field]=value`. */
internal fun QueryParams.Builder.putQueryObject(key: String, element: QueryArrayElement) {
    when (element) {
        is QueryArrayElement.Value -> put(key, element.value)
        is QueryArrayElement.Fields ->
            element.fields.forEach { (field, value) -> put("$key[$field]", value) }
    }
}

internal fun RecipientReference.toQueryArrayElement(): QueryArrayElement =
    accept(
        object : RecipientReference.Visitor<QueryArrayElement> {
            override fun visitUser(user: String) = QueryArrayElement.Value(user)

            override fun visitObjectReference(
                objectReference: RecipientReference.ObjectReference
            ): QueryArrayElement {
                val fields = mutableListOf<Pair<String, String>>()
                objectReference.id().ifPresent { fields.add("id" to it) }
                objectReference.collection().ifPresent { fields.add("collection" to it) }
                objectReference._additionalProperties().forEach { (key, value) ->
                    fields.add(key to value.toString())
                }
                return QueryArrayElement.Fields(fields)
            }
        }
    )
