package de.cfranzen.adventofcode2024.day3;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    void testParsingMultiplyInstructions() {
        val results = new InputParser().parseInput(List.of(
                "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
        ));

        assertThat(results).containsExactly(
                MemorySection.of(
                        new MultiplyInstruction(2, 4),
                        new MultiplyInstruction(5, 5),
                        new MultiplyInstruction(11, 8),
                        new MultiplyInstruction(8, 5)
                )
        );
    }
}