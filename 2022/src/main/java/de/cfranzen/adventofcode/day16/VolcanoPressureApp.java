package de.cfranzen.adventofcode.day16;


import de.cfranzen.adventofcode.util.InputDownloader;

import java.util.List;


public class VolcanoPressureApp {

    public static void main(String[] args) {
        final List<String> lines = new InputDownloader().downloadLines(2022, 16);
        final List<Valve> valves = new InputParser().parsePairs(lines);
        calculatePart1(valves);
        calculatePart2(valves);
    }

    private static void calculatePart1(final List<Valve> valves) {
        valves.forEach(System.out::println);
    }

    private static void calculatePart2(final List<Valve> valves) {

    }


}
