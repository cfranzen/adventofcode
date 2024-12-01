package de.cfranzen.adventofcode2024.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    void testParsingInput() {
        final var parser = new InputParser();

        final var result = parser.parseInput(List.of(
                "3   4",
                "4   3",
                "2   5",
                "1   3",
                "3   9",
                "3   3"
        ));

        assertThat(result.firstList()).containsExactly(
                LocationId.of(3), LocationId.of(4), LocationId.of(2), LocationId.of(1), LocationId.of(3), LocationId.of(3)
        );

        assertThat(result.secondList()).containsExactly(
                LocationId.of(4), LocationId.of(3), LocationId.of(5), LocationId.of(3), LocationId.of(9), LocationId.of(3)
        );
    }

}