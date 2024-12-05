package de.cfranzen.adventofcode2024.day2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FilteringListIteratorTest {

    private final List<Integer> elements = List.of(1, 2, 3, 4);

    @Test
    void testIteration() {
        var iter = new FilteringListIterator<>(elements, 2);

        var results = new ArrayList<>();
        while (iter.hasNext()) {
            results.add(iter.next());
        }
        while (iter.hasPrevious()) {
            results.add(iter.previous());
        }
        assertThat(results).containsExactly(1, 2, 4, 4, 2, 1);
    }
}