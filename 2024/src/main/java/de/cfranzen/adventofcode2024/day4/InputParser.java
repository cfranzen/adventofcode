package de.cfranzen.adventofcode2024.day4;

import java.util.List;

class InputParser {

    public WordsBoard parseInput(final List<String> lines) {
        return WordsBoard.of(lines);
    }

}
