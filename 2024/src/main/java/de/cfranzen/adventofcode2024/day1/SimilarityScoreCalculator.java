package de.cfranzen.adventofcode2024.day1;

import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class SimilarityScoreCalculator {

    private SimilarityScoreCalculator() {
        // Do not instantiate
    }

    public static int calculate(LocationIdLists lists) {
        final Map<LocationId, Long> countByLocationId = lists.secondList().stream().collect(groupingBy(s -> s, counting()));

        int similarityScore = 0;
        for (LocationId id : lists.firstList()) {
            similarityScore += (int) (id.getId() * countByLocationId.getOrDefault(id, 0L));
        }
        return similarityScore;
    }
}
