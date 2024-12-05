package de.cfranzen.adventofcode2024.day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    @Test
    void testParsing() {
        final var parser = new InputParser();

        final var result = parser.parseInput(List.of(
                "7 6 4 2 1",
                "1 2 7 8 9",
                "9 7 6 2 1",
                "1 3 2 4 5",
                "8 6 4 4 1",
                "1 3 6 7 9"
        ));

        assertThat(result).containsExactly(
                Report.of(7, 6, 4, 2, 1),
                Report.of(1, 2, 7, 8, 9),
                Report.of(9, 7, 6, 2, 1),
                Report.of(1, 3, 2, 4, 5),
                Report.of(8, 6, 4, 4, 1),
                Report.of(1, 3, 6, 7, 9)
        );
    }

}