package de.cfranzen.adventofcode2024.day1;

import java.util.ArrayList;
import java.util.List;

public class DistanceCalculator {

    private DistanceCalculator() {
        // Do not instantiate
    }

    public static int calculate(LocationIdLists lists) {
        List<LocationId> left = new ArrayList<>(lists.firstList());
        List<LocationId> right = new ArrayList<>(lists.secondList());
        left.sort(LocationId::compareTo);
        right.sort(LocationId::compareTo);

        int distance = 0;
        for (int i = 0; i < left.size(); i++) {
            distance += left.get(i).distanceTo(right.get(i));
        }
        return distance;
    }
}
