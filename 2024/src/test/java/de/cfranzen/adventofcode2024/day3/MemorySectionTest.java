package de.cfranzen.adventofcode2024.day3;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemorySectionTest {

    @Test
    void testSumCalculation() {
        val memorySection = MemorySection.of(
                new MultiplyInstruction(4, 5),
                new MultiplyInstruction(2, 3),
                new MultiplyInstruction(10, 30)
        );

        val result = new InstructionsResult();
        memorySection.alwaysActiveInstructionsSum(result);

        assertThat(result.getSum()).isEqualTo((4L * 5L) + (2L * 3L) + (10L * 30L));
    }

    @Test
    void testSumCalculationIgnoringActivation() {
        val memorySection = MemorySection.of(
                new MultiplyInstruction(4, 5),
                new DontInstruction(),
                new MultiplyInstruction(2, 3),
                new DoInstruction(),
                new MultiplyInstruction(10, 30)
        );

        val result = new InstructionsResult();
        memorySection.alwaysActiveInstructionsSum(result);

        assertThat(result.getSum()).isEqualTo((4L * 5L) + (2L * 3L) + (10L * 30L));
    }

    @Test
    void testSumCalculationWithActivation() {
        val memorySection = MemorySection.of(
                new MultiplyInstruction(4, 5),
                new DontInstruction(),
                new MultiplyInstruction(2, 3),
                new DoInstruction(),
                new MultiplyInstruction(10, 30)
        );

        val result = new InstructionsResult();
        memorySection.instructionsSum(result);

        assertThat(result.getSum()).isEqualTo((4L * 5L) + (10L * 30L));
    }
}