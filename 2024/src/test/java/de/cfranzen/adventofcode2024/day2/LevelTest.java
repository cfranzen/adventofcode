package de.cfranzen.adventofcode2024.day2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LevelTest {

    @Test
    void testComparison() {
        assertThat(Level.of(1).compareTo(Level.of(2))).isNegative();
        assertThat(Level.of(1).compareTo(Level.of(5))).isNegative();
        assertThat(Level.of(2).compareTo(Level.of(1))).isPositive();
        assertThat(Level.of(5).compareTo(Level.of(1))).isPositive();
        assertThat(Level.of(1).compareTo(Level.of(1))).isZero();
    }

    @Test
    void testDistanceCalculation() {
        assertThat(Level.of(1).distanceTo(Level.of(2))).isEqualTo(1);
        assertThat(Level.of(2).distanceTo(Level.of(1))).isEqualTo(1);
        assertThat(Level.of(1).distanceTo(Level.of(5))).isEqualTo(4);
        assertThat(Level.of(5).distanceTo(Level.of(1))).isEqualTo(4);
        assertThat(Level.of(1).distanceTo(Level.of(1))).isZero();
    }
}