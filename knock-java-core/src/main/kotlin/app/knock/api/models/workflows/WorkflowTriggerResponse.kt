// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflows

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.checkRequired
import app.knock.api.errors.KnockInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects

/** The response from triggering a workflow */
class WorkflowTriggerResponse
private constructor(
    private val workflowRunId: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("workflow_run_id")
        @ExcludeMissing
        workflowRunId: JsonField<String> = JsonMissing.of()
    ) : this(workflowRunId, mutableMapOf())

    /**
     * The ID of the workflow trigger. This value allows you to track individual workflow runs
     * associated with this trigger request.
     *
     * @throws KnockInvalidDataException if the JSON field has an unexpected type or is unexpectedly
     *   missing or null (e.g. if the server responded with an unexpected value).
     */
    fun workflowRunId(): String = workflowRunId.getRequired("workflow_run_id")

    /**
     * Returns the raw JSON value of [workflowRunId].
     *
     * Unlike [workflowRunId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("workflow_run_id")
    @ExcludeMissing
    fun _workflowRunId(): JsonField<String> = workflowRunId

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WorkflowTriggerResponse].
         *
         * The following fields are required:
         * ```java
         * .workflowRunId()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WorkflowTriggerResponse]. */
    class Builder internal constructor() {

        private var workflowRunId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(workflowTriggerResponse: WorkflowTriggerResponse) = apply {
            workflowRunId = workflowTriggerResponse.workflowRunId
            additionalProperties = workflowTriggerResponse.additionalProperties.toMutableMap()
        }

        /**
         * The ID of the workflow trigger. This value allows you to track individual workflow runs
         * associated with this trigger request.
         */
        fun workflowRunId(workflowRunId: String) = workflowRunId(JsonField.of(workflowRunId))

        /**
         * Sets [Builder.workflowRunId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.workflowRunId] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun workflowRunId(workflowRunId: JsonField<String>) = apply {
            this.workflowRunId = workflowRunId
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [WorkflowTriggerResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .workflowRunId()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WorkflowTriggerResponse =
            WorkflowTriggerResponse(
                checkRequired("workflowRunId", workflowRunId),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): WorkflowTriggerResponse = apply {
        if (validated) {
            return@apply
        }

        workflowRunId()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: KnockInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = (if (workflowRunId.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is WorkflowTriggerResponse && workflowRunId == other.workflowRunId && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(workflowRunId, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "WorkflowTriggerResponse{workflowRunId=$workflowRunId, additionalProperties=$additionalProperties}"
}
