package de.cfranzen.adventofcode.day16;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private final Pattern PATTERN = Pattern.compile("Valve ([A-Z]+) has flow rate=(\\d+); tunnel(s)? lead(s)? to valve(s)? ([A-Z]+(, [A-Z]+)*)");

    public List<Valve> parsePairs(final List<String> lines) {
        final List<Valve> valves = new ArrayList<>();
        lines.forEach(l -> parseLine(l, valves));
        return valves;
    }

    private void parseLine(final String line, final List<Valve> valves) {
        final Matcher matcher = PATTERN.matcher(line);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("unable to parse line: " + line);
        }

        var id = matcher.group(1);
        var flowRate = Integer.parseInt(matcher.group(2));
        var connectedTo = matcher.group(6).split(", ");

        valves.add(new Valve(id, flowRate, Set.of(connectedTo)));
    }
}
