package de.cfranzen.adventofcode2024.day4;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordCounterTest {
    @Test
    void testWordCounting() {
        val board = WordsBoard.of(
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"
        );

        assertThat(WordCounter.countWord(board, "XMAS")).isEqualTo(18L);
    }
}