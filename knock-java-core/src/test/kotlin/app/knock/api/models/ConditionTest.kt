// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConditionTest {

    @Test
    fun createCondition() {
        val condition =
            Condition.builder()
                .argument("some_property")
                .operator(Condition.Operator.EQUAL_TO)
                .variable("recipient.property")
                .build()
        assertThat(condition).isNotNull
        assertThat(condition.argument()).contains("some_property")
        assertThat(condition.operator()).isEqualTo(Condition.Operator.EQUAL_TO)
        assertThat(condition.variable()).isEqualTo("recipient.property")
    }
}
