package de.cfranzen.adventofcode2024.day1;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class LocationId implements Comparable<LocationId> {

    private final int id;

    public static LocationId of(int id) {
        return new LocationId(id);
    }

    public int distanceTo(LocationId other) {
        return Math.abs(id - other.id);
    }

    @Override
    public int compareTo(final LocationId o) {
        return Integer.compare(id, o.id);
    }
}
