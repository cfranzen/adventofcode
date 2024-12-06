package de.cfranzen.adventofcode2024.day3;


import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class MemorySection {

    private final List<Instruction> instructions;

    public static MemorySection of(Instruction... instructions) {
        return new MemorySection(List.of(instructions));
    }

    public static MemorySection of(Collection<? extends Instruction> instructions) {
        return new MemorySection(new ArrayList<>(instructions));
    }

    public void instructionsSum(final InstructionsResult result) {
        instructions.forEach(i -> i.calculate(result));
    }

    public void alwaysActiveInstructionsSum(final InstructionsResult result) {
        instructions.stream().filter(MultiplyInstruction.class::isInstance).forEach(i -> i.calculate(result));
    }
}
