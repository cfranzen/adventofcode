package de.cfranzen.adventofcode2024.day4;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.val;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class WordCounter {

    public static long countWord(WordsBoard board, String word) {
        long counter = 0;
        for (int row = 0; row < board.rowCount(); row++) {
            for (int col = 0; col < board.columnCount(); col++) {
                for (val rowMovement : RowMovement.values()) {
                    for (val columnMovement : ColumnMovement.values()) {
                        if (rowMovement == RowMovement.NONE && columnMovement == ColumnMovement.NONE) {
                            continue;
                        }

                        if (board.hasWord(word, row, col, rowMovement, columnMovement)) {
                            counter++;
                        }
                    }
                }
            }
        }
        return counter;
    }
}
