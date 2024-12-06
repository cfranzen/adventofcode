package de.cfranzen.adventofcode2024.day3;

import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

class InputParser {

    private static final Pattern REGEX = Pattern.compile("mul\\(([1-9][0-9]{0,2}),([1-9][0-9]{0,2})\\)|do\\(\\)|don't\\(\\)");

    public List<MemorySection> parseInput(final List<String> lines) {
        final List<MemorySection> memorySections = new ArrayList<>();
        for (final String line : lines) {
            val instructions = REGEX.matcher(line).results().map(r -> {
                if (r.group(0).startsWith("mul")) {
                    val firstValue = Integer.parseInt(r.group(1));
                    val secondValue = Integer.parseInt(r.group(2));
                    return new MultiplyInstruction(firstValue, secondValue);

                } else if (r.group(0).startsWith("don't")) {
                    return new DontInstruction();

                } else {
                    return new DoInstruction();
                }
            }).toList();

            memorySections.add(MemorySection.of(instructions));
        }
        return memorySections;
    }

}
