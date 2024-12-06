package de.cfranzen.adventofcode2024.day3;

import de.cfranzen.adventofcode2024.util.InputDownloader;

import java.util.List;

public class MemoryInstructionsApp {

    public static void main(String[] args) {
        List<String> lines = new InputDownloader().downloadLines(2024, 3);
        final var memorySections = new InputParser().parseInput(lines);

        calculationPart1(memorySections);
    }

    private static void calculationPart1(final List<MemorySection> memorySections) {
        long sum = memorySections.stream().mapToLong(MemorySection::instructionsSum).sum();
        System.out.println("Sum mul instructions: " + sum);
    }
}
