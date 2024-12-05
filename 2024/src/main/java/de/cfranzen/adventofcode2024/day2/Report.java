package de.cfranzen.adventofcode2024.day2;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.*;

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
        return isIteratorSafe(levels.listIterator());
    }

    public boolean isRelaxedSafe() {
        if (isIteratorSafe(levels.listIterator())) {
            return true;
        }

        for (int blockedIndex = 0; blockedIndex < levels.size(); blockedIndex++) {
            if (isIteratorSafe(new FilteringListIterator<>(levels, blockedIndex))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIteratorSafe(final ListIterator<Level> levelIterator) {
        int expectedComparison = 0;
        while (levelIterator.hasNext()) {
            final var firstLevel = levelIterator.next();

            if (!levelIterator.hasNext()) {
                break;
            }
            final var secondLevel = levelIterator.next();
            levelIterator.previous();

            // Check for steady increase or decrease
            final int comparison = firstLevel.compareTo(secondLevel);
            if (comparison == 0) {
                return false;
            }
            if (expectedComparison == 0) {
                expectedComparison = comparison;
            } else if (expectedComparison != comparison) {
                return false;
            }

            // Check for distance range
            final int distance = firstLevel.distanceTo(secondLevel);
            if (distance < 1 || distance > 3) {
                return false;
            }
        }

        return true;
    }

}
