package de.cfranzen.adventofcode2024.day4;

import de.cfranzen.adventofcode2024.util.InputDownloader;

import java.util.List;

public class WordSearchApp {

    public static void main(String[] args) {
        List<String> lines = new InputDownloader().downloadLines(2024, 4);
        final var wordsBoard = new InputParser().parseInput(lines);

        calculationPart1(wordsBoard);
    }

    private static void calculationPart1(final WordsBoard wordsBoard) {
        System.out.println("XMAS count: " + WordCounter.countWord(wordsBoard, "XMAS"));
    }
}
