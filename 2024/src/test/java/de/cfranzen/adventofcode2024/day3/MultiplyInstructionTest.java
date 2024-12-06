package de.cfranzen.adventofcode2024.day3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyInstructionTest {

    @Test
    void testMultiplication() {
        assertThat(new MultiplyInstruction(4, 5).calculate()).isEqualTo(20L);
    }

}