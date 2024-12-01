package de.cfranzen.adventofcode2024.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimilarityScoreCalculatorTest {

    @Test
    void testSimilarityCalculation() {
        final var firstList = List.of(
                LocationId.of(3), LocationId.of(4), LocationId.of(2), LocationId.of(1), LocationId.of(3), LocationId.of(3)
        );
        final var secondList = List.of(
                LocationId.of(4), LocationId.of(3), LocationId.of(5), LocationId.of(3), LocationId.of(9), LocationId.of(3)
        );
        final var lists = new LocationIdLists(firstList, secondList);
        final var similarity = SimilarityScoreCalculator.calculate(lists);
        assertThat(similarity).isEqualTo(31);
    }

}