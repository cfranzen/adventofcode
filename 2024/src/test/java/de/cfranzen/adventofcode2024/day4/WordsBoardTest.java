package de.cfranzen.adventofcode2024.day4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordsBoardTest {

    private final WordsBoard board = WordsBoard.of(
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

    @Test
    void testGettingSingleCharacters() {
        assertThat(board.getChar(0, 0)).isEqualTo('M');
        assertThat(board.getChar(3, 2)).isEqualTo('A');
        assertThat(board.getChar(6, 4)).isEqualTo('S');
        assertThat(board.getChar(9, 9)).isEqualTo('X');
    }

    @Test
    void testWordSearch_Horizontally() {
        assertThat(board.hasWord("XMAS", 0, 5, RowMovement.NONE, ColumnMovement.RIGHT)).isTrue();
        assertThat(board.hasWord("XMAS", 0, 6, RowMovement.NONE, ColumnMovement.RIGHT)).isFalse();
    }

    @Test
    void testWordSearch_ReverseHorizontally() {
        assertThat(board.hasWord("XMAS", 1, 4, RowMovement.NONE, ColumnMovement.LEFT)).isTrue();
        assertThat(board.hasWord("XMAS", 1, 5, RowMovement.NONE, ColumnMovement.LEFT)).isFalse();
    }

    @Test
    void testWordSearch_Vertically() {
        assertThat(board.hasWord("XMAS", 3, 9, RowMovement.DOWN, ColumnMovement.NONE)).isTrue();
        assertThat(board.hasWord("XMAS", 4, 9, RowMovement.DOWN, ColumnMovement.NONE)).isFalse();
    }

    @Test
    void testWordSearch_ReverseVertically() {
        assertThat(board.hasWord("XMAS", 4, 6, RowMovement.UP, ColumnMovement.NONE)).isTrue();
        assertThat(board.hasWord("XMAS", 5, 6, RowMovement.UP, ColumnMovement.NONE)).isFalse();
    }

    @Test
    void testWordSearch_Diagonally_LeftTopRightBottom() {
        assertThat(board.hasWord("XMAS", 0, 4, RowMovement.DOWN, ColumnMovement.RIGHT)).isTrue();
        assertThat(board.hasWord("XMAS", 0, 5, RowMovement.DOWN, ColumnMovement.RIGHT)).isFalse();
    }

    @Test
    void testWordSearch_ReverseDiagonally_LeftTopRightBottom() {
        assertThat(board.hasWord("XMAS", 9, 9, RowMovement.UP, ColumnMovement.LEFT)).isTrue();
        assertThat(board.hasWord("XMAS", 9, 8, RowMovement.UP, ColumnMovement.LEFT)).isFalse();
    }

    @Test
    void testWordSearch_IgnoreOutOfBoundsIndices() {
        assertThat(board.hasWord("XMAS", 10, 9, RowMovement.UP, ColumnMovement.LEFT)).isFalse();
        assertThat(board.hasWord("XMAS", 9, 9, RowMovement.DOWN, ColumnMovement.LEFT)).isFalse();
        assertThat(board.hasWord("XMAS", 9, 9, RowMovement.UP, ColumnMovement.RIGHT)).isFalse();
        assertThat(board.hasWord("XMAS", 0, 0, RowMovement.UP, ColumnMovement.RIGHT)).isFalse();
        assertThat(board.hasWord("XMAS", 0, 0, RowMovement.DOWN, ColumnMovement.LEFT)).isFalse();
    }
}