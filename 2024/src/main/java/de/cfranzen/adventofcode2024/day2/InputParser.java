package de.cfranzen.adventofcode2024.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

class InputParser {

    private static final Pattern WHITESPACE_REGEX = Pattern.compile("\\s+");

    public List<Report> parseInput(final List<String> lines) {
        final List<Report> reports = new ArrayList<>();
        for (final String line : lines) {
            final var split = WHITESPACE_REGEX.split(line);
            final List<Level> levels = Arrays.stream(split).map(s -> Level.of(Integer.parseInt(s))).toList();
            reports.add(Report.of(levels));
        }
        return reports;
    }

}
