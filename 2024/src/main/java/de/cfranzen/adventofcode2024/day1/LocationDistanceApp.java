package de.cfranzen.adventofcode2024.day1;

import de.cfranzen.adventofcode2024.util.InputDownloader;

import java.util.List;

public class LocationDistanceApp {

    public static void main(String[] args) {
        List<String> lines = new InputDownloader().downloadLines(2024, 1);
        new InputParser().parseInput(lines);

    }
}
