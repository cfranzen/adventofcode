package de.cfranzen.adventofcode2024.day3;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class MultiplyInstruction implements Instruction {

    private final int first;

    private final int second;

    @Override
    public long calculate() {
        return (long) first * second;
    }
}
