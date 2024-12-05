package de.cfranzen.adventofcode2024.day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReportTest {

    @Test
    void testSafeTrivialReport() {
        assertThat(Report.of(1).isSafe()).isTrue();
        assertThat(Report.of(List.of()).isSafe()).isTrue();
    }

    @Test
    void testSafeIncrease() {
        assertThat(Report.of(1, 3, 6, 7, 9).isSafe()).isTrue();
    }

    @Test
    void testSafeDecrease() {
        assertThat(Report.of(7, 6, 4, 2, 1).isSafe()).isTrue();
    }

    @Test
    void testUnsafeTooLargeIncrease() {
        assertThat(Report.of(1, 2, 7, 8, 9).isSafe()).isFalse();
    }

    @Test
    void testUnsafeTooLargeDecrease() {
        assertThat(Report.of(9, 7, 6, 2, 1).isSafe()).isFalse();
    }

    @Test
    void testUnsafeDecreaseAndIncrease() {
        assertThat(Report.of(1, 3, 2, 4, 5).isSafe()).isFalse();
    }

    @Test
    void testUnsafeMissingMonotony() {
        assertThat(Report.of(8, 6, 4, 4, 1).isSafe()).isFalse();
    }

    @Test
    void testRelaxedSafe() {
        assertThat(Report.of(7, 6, 4, 2, 1).isRelaxedSafe()).isTrue();
        assertThat(Report.of(1, 3, 2, 4, 5).isRelaxedSafe()).isTrue();
        assertThat(Report.of(8, 6, 4, 4, 1).isRelaxedSafe()).isTrue();
        assertThat(Report.of(1, 3, 6, 7, 9).isRelaxedSafe()).isTrue();
        assertThat(Report.of(1, 1, 3, 4, 5).isRelaxedSafe()).isTrue();
    }

    @Test
    void testRelaxedUnsafe() {
        assertThat(Report.of(1, 2, 7, 8, 9).isRelaxedSafe()).isFalse();
        assertThat(Report.of(9, 7, 6, 2, 1).isRelaxedSafe()).isFalse();
    }
}