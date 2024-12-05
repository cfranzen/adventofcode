package de.cfranzen.adventofcode2024.day2;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class Report {

    private final List<Level> levels;

    public static Report of(int... levels) {
        return of(Arrays.stream(levels).mapToObj(Level::of).toList());
    }

    public static Report of(Level... levels) {
        return new Report(new ArrayList<>(Arrays.asList(levels)));
    }

    public static Report of(Collection<Level> levels) {
        return new Report(new ArrayList<>(levels));
    }

    public boolean isSafe() {
        if (levels.size() <= 1) {
            return true;
        }

        // Check for steady increase or decrease
        final int expectedComparison = levels.get(0).compareTo(levels.get(1));
        for (int i = 1; i < levels.size() - 1; i++) {
            final int comparison = levels.get(i).compareTo(levels.get(i + 1));
            if (expectedComparison != comparison) {
                return false;
            }
        }

        // Check for distance range
        for (int i = 0; i < levels.size() - 1; i++) {
            final int distance = levels.get(i).distanceTo(levels.get(i + 1));
            if (distance < 1 || distance > 3) {
                return false;
            }
        }

        return true;
    }
}
