package de.cfranzen.adventofcode2024.day3;

import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class InputParser {

    private static final Pattern MUL_REGEX = Pattern.compile("mul\\(([1-9][0-9]{0,2}),([1-9][0-9]{0,2})\\)");

    public List<MemorySection> parseInput(final List<String> lines) {
        final List<MemorySection> memorySections = new ArrayList<>();
        for (final String line : lines) {
            val multiplies = MUL_REGEX.matcher(line).results().map(r -> {
                val firstValue = Integer.parseInt(r.group(1));
                val secondValue = Integer.parseInt(r.group(2));
                return new MultiplyInstruction(firstValue, secondValue);
            }).toList();
            memorySections.add(MemorySection.of(multiplies));
        }
        return memorySections;
    }

}
