package de.cfranzen.adventofcode2024.day4;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.val;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class WordsBoard {

    private final char[][] board;

    public static WordsBoard of(String... lines) {
        return of(List.of(lines));
    }

    public static WordsBoard of(List<String> lines) {
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("No lines with words given");
        }

        val expectedWidth = lines.getFirst().length();
        final char[][] board = new char[lines.size()][];
        for (int i = 0; i < board.length; i++) {
            val line = lines.get(i);
            if (line.length() != expectedWidth) {
                throw new IllegalArgumentException("Wrong number of characters in line " + i);
            }
            board[i] = line.toCharArray();
        }
        return new WordsBoard(board);
    }

    public char getChar(final int row, final int col) {
        return board[row][col];
    }

    public boolean hasWord(String word, int startRow, int startCol, RowMovement rowMovement, ColumnMovement columnMovement) {
        final int rowDelta = delta(rowMovement);
        final int colDelta = delta(columnMovement);
        final int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
            final int row = startRow + i * rowDelta;
            final int col = startCol + i * colDelta;
            if (!isValidRow(row) || !isValidColumne(col) || word.charAt(i) != getChar(row, col)) {
                return false;
            }
        }
        return true;
    }

    public int columnCount() {
        return board[0].length;
    }

    public int rowCount() {
        return board.length;
    }

    private boolean isValidColumne(final int col) {
        return col >= 0 && col < columnCount();
    }

    private boolean isValidRow(final int row) {
        return row >= 0 && row < rowCount();
    }

    private int delta(final ColumnMovement columnMovement) {
        return switch (columnMovement) {
            case LEFT -> -1;
            case RIGHT -> 1;
            case NONE -> 0;
        };
    }

    private int delta(final RowMovement rowMovement) {
        return switch (rowMovement) {
            case UP -> -1;
            case DOWN -> 1;
            case NONE -> 0;
        };
    }
}
