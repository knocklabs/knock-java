// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.workflows

import app.knock.api.core.ExcludeMissing
import app.knock.api.core.JsonField
import app.knock.api.core.JsonMissing
import app.knock.api.core.JsonValue
import app.knock.api.core.NoAutoDetect
import app.knock.api.core.checkRequired
import app.knock.api.core.immutableEmptyMap
import app.knock.api.core.toImmutable
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Objects

/** The response from triggering a workflow */
@NoAutoDetect
class WorkflowTriggerResponse @JsonCreator private constructor(
    @JsonProperty("workflow_run_id") @ExcludeMissing private val workflowRunId: JsonField<String> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),

) {

    /**
     * The ID of the workflow trigger. This value allows you to track individual
     * workflow runs associated with this trigger request.
     */
    fun workflowRunId(): String = workflowRunId.getRequired("workflow_run_id")

    /**
     * The ID of the workflow trigger. This value allows you to track individual
     * workflow runs associated with this trigger request.
     */
    @JsonProperty("workflow_run_id")
    @ExcludeMissing
    fun _workflowRunId(): JsonField<String> = workflowRunId

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): WorkflowTriggerResponse =
        apply {
            if (validated) {
              return@apply
            }

            workflowRunId()
            validated = true
        }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [WorkflowTriggerResponse].
         *
         * The following fields are required:
         *
         * ```java
         * .workflowRunId()
         * ```
         */
        @JvmStatic
        fun builder() = Builder()
    }

    /** A builder for [WorkflowTriggerResponse]. */
    class Builder internal constructor() {

        private var workflowRunId: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(workflowTriggerResponse: WorkflowTriggerResponse) =
            apply {
                workflowRunId = workflowTriggerResponse.workflowRunId
                additionalProperties = workflowTriggerResponse.additionalProperties.toMutableMap()
            }

        /**
         * The ID of the workflow trigger. This value allows you to track individual
         * workflow runs associated with this trigger request.
         */
        fun workflowRunId(workflowRunId: String) = workflowRunId(JsonField.of(workflowRunId))

        /**
         * The ID of the workflow trigger. This value allows you to track individual
         * workflow runs associated with this trigger request.
         */
        fun workflowRunId(workflowRunId: JsonField<String>) =
            apply {
                this.workflowRunId = workflowRunId
            }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) =
            apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

        fun putAdditionalProperty(key: String, value: JsonValue) =
            apply {
                additionalProperties.put(key, value)
            }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
            apply {
                this.additionalProperties.putAll(additionalProperties)
            }

        fun removeAdditionalProperty(key: String) =
            apply {
                additionalProperties.remove(key)
            }

        fun removeAllAdditionalProperties(keys: Set<String>) =
            apply {
                keys.forEach(::removeAdditionalProperty)
            }

        fun build(): WorkflowTriggerResponse =
            WorkflowTriggerResponse(
              checkRequired(
                "workflowRunId", workflowRunId
              ), additionalProperties.toImmutable()
            )
    }

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

    override fun toString() = "WorkflowTriggerResponse{workflowRunId=$workflowRunId, additionalProperties=$additionalProperties}"
}
