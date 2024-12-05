package de.cfranzen.adventofcode2024.day2;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class Level implements Comparable<Level> {

    private final int level;

    public static Level of(int id) {
        return new Level(id);
    }

    public int distanceTo(Level other) {
        return Math.abs(level - other.level);
    }

    @Override
    public int compareTo(final Level o) {
        return Integer.compare(level, o.level);
    }
}
