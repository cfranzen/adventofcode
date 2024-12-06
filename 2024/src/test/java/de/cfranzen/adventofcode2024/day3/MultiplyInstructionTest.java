package de.cfranzen.adventofcode2024.day3;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyInstructionTest {

    @Test
    void testMultiplication() {
        val result = new InstructionsResult();
        new MultiplyInstruction(4, 5).calculate(result);
        assertThat(result.getSum()).isEqualTo(20L);
    }

}