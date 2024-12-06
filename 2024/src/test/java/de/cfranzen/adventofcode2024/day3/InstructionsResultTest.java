package de.cfranzen.adventofcode2024.day3;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InstructionsResultTest {

    @Test
    void testSumCalculation() {
        val result = new InstructionsResult();
        result.add(5L);
        result.add(10L);
        result.add(20L);
        assertThat(result.getSum()).isEqualTo(35L);
    }

    @Test
    void testActivationDeactivation() {
        val result = new InstructionsResult();
        result.add(5L);
        result.setActive(false);
        result.add(10L);
        result.setActive(true);
        result.add(20L);
        assertThat(result.getSum()).isEqualTo(25L);
    }
}