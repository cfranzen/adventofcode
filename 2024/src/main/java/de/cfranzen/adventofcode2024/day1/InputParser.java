package de.cfranzen.adventofcode2024.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class InputParser {

    private static final Pattern WHITESPACE_REGEX = Pattern.compile("\\s+");

    public LocationIdLists parseInput(final List<String> lines) {
        final List<LocationId> left = new ArrayList<>();
        final List<LocationId> right = new ArrayList<>();

        for (final String line : lines) {
            final var split = WHITESPACE_REGEX.split(line);
            final LocationId first = LocationId.of(Integer.parseInt(split[0]));
            final LocationId second = LocationId.of(Integer.parseInt(split[1]));
            left.add(first);
            right.add(second);
        }
        return new LocationIdLists(left, right);
    }

}
