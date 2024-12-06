package de.cfranzen.adventofcode2024.day3;

import de.cfranzen.adventofcode2024.util.InputDownloader;
import lombok.val;

import java.util.List;

public class MemoryInstructionsApp {

    public static void main(String[] args) {
        List<String> lines = new InputDownloader().downloadLines(2024, 3);
        final var memorySections = new InputParser().parseInput(lines);

        calculationPart1(memorySections);
        calculationPart2(memorySections);
    }

    private static void calculationPart1(final List<MemorySection> memorySections) {
        val result = new InstructionsResult();
        memorySections.forEach(m -> m.alwaysActiveInstructionsSum(result));
        System.out.println("Sum mul instructions (always active): " + result.getSum());
    }

    private static void calculationPart2(final List<MemorySection> memorySections) {
        val result = new InstructionsResult();
        memorySections.forEach(m -> m.instructionsSum(result));
        System.out.println("Sum mul instructions: " + result.getSum());
    }
}
