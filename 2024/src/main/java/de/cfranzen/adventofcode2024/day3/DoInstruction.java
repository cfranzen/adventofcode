package de.cfranzen.adventofcode2024.day3;

public class DoInstruction implements Instruction {

    @Override
    public void calculate(final InstructionsResult result) {
        result.setActive(true);
    }
}
