// File generated from our OpenAPI spec by Stainless.

package app.knock.api.models.shared

import app.knock.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ConditionTest {

    @Test
    fun create() {
        val condition =
            Condition.builder()
                .argument("frog_genome")
                .operator(Condition.Operator.CONTAINS)
                .variable("specimen.dna_sequence")
                .build()

        assertThat(condition.argument()).contains("frog_genome")
        assertThat(condition.operator()).isEqualTo(Condition.Operator.CONTAINS)
        assertThat(condition.variable()).isEqualTo("specimen.dna_sequence")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val condition =
            Condition.builder()
                .argument("frog_genome")
                .operator(Condition.Operator.CONTAINS)
                .variable("specimen.dna_sequence")
                .build()

        val roundtrippedCondition =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(condition),
                jacksonTypeRef<Condition>(),
            )

        assertThat(roundtrippedCondition).isEqualTo(condition)
    }
}
