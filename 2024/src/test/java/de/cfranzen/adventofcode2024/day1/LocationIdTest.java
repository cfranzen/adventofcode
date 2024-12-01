package de.cfranzen.adventofcode2024.day1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LocationIdTest {

    @Test
    void testDistanceCalculation() {
        assertThat(LocationId.of(1).distanceTo(LocationId.of(3))).isEqualTo(2);
        assertThat(LocationId.of(2).distanceTo(LocationId.of(3))).isEqualTo(1);
        assertThat(LocationId.of(3).distanceTo(LocationId.of(3))).isZero();
        assertThat(LocationId.of(3).distanceTo(LocationId.of(4))).isEqualTo(1);
        assertThat(LocationId.of(3).distanceTo(LocationId.of(5))).isEqualTo(2);
        assertThat(LocationId.of(4).distanceTo(LocationId.of(9))).isEqualTo(5);
    }

}