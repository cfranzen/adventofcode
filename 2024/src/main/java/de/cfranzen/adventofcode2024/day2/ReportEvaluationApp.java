package de.cfranzen.adventofcode2024.day2;

import de.cfranzen.adventofcode2024.util.InputDownloader;

import java.util.List;

public class ReportEvaluationApp {

    public static void main(String[] args) {
        List<String> lines = new InputDownloader().downloadLines(2024, 2);
        final var reports = new InputParser().parseInput(lines);

        calculationPart1(reports);
    }

    private static void calculationPart1(final List<Report> reports) {
        long safeReportsCount = reports.stream().filter(Report::isSafe).count();
        System.out.println("Overall safe reports: " + safeReportsCount);
    }
}
