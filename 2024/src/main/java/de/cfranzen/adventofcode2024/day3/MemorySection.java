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

    public long instructionsSum() {
        return instructions.stream().mapToLong(Instruction::calculate).sum();
    }
}
