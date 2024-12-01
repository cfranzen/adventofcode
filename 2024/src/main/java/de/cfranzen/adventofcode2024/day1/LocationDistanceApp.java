package de.cfranzen.adventofcode2024.day1;

import de.cfranzen.adventofcode2024.util.InputDownloader;

import java.util.List;

public class LocationDistanceApp {

    public static void main(String[] args) {
        List<String> lines = new InputDownloader().downloadLines(2024, 1);
        final var lists = new InputParser().parseInput(lines);

        calculationPart1(lists);
        calculationPart2(lists);
    }

    private static void calculationPart1(final LocationIdLists lists) {
        final var distance = DistanceCalculator.calculate(lists);
        System.out.println("Overall distance is " + distance);
    }

    private static void calculationPart2(final LocationIdLists lists) {
        final var similarity = SimilarityScoreCalculator.calculate(lists);
        System.out.println("Overall similarity score is " + similarity);
    }
}
