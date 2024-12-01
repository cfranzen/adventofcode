package de.cfranzen.adventofcode.day16;

import java.util.Objects;
import java.util.Set;

public class Valve {

    private final String id;
    private final int flowRate;
    private final Set<String> connectedTo;

    public Valve(final String id, final int flowRate, final Set<String> connectedTo) {
        this.id = id;
        this.flowRate = flowRate;
        this.connectedTo = connectedTo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Valve valve = (Valve) o;
        return id.equals(valve.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Valve{" +
                "id='" + id + '\'' +
                ", flowRate=" + flowRate +
                ", connectedTo=" + connectedTo +
                '}';
    }
}
