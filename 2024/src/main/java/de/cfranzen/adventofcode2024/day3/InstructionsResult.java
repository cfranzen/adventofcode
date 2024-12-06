package de.cfranzen.adventofcode2024.day3;

import lombok.Data;

@Data
public class InstructionsResult {

    private long sum = 0;

    private boolean active = true;

    public void add(final long value) {
        if (active) sum += value;
    }
}
