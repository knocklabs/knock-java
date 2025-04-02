// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConditionTest {

    @Test
    fun create() {
        val condition =
            Condition.builder()
                .argument("some_property")
                .operator(Condition.Operator.EQUAL_TO)
                .variable("recipient.property")
                .build()

        assertThat(condition.argument()).contains("some_property")
        assertThat(condition.operator()).isEqualTo(Condition.Operator.EQUAL_TO)
        assertThat(condition.variable()).isEqualTo("recipient.property")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val condition =
            Condition.builder()
                .argument("some_property")
                .operator(Condition.Operator.EQUAL_TO)
                .variable("recipient.property")
                .build()

        val roundtrippedCondition =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(condition),
                jacksonTypeRef<Condition>(),
            )

        assertThat(roundtrippedCondition).isEqualTo(condition)
    }
}
