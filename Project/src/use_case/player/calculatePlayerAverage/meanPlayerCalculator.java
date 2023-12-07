package use_case.player.calculatePlayerAverage;

import java.util.ArrayList;

public class meanPlayerCalculator implements playerCalculator {
    /*
    this implementation of calculatePlayer is essentially the same as the get average for team.
    - works for any type of stat (as long as you input the list that you want avg of)
        -> practically is fine since it's just the mean
     */
    @Override
    public String calculatePlayer(ArrayList<Integer> allStats) {
        int total = 0;
        for (int point : allStats) {
            total += point;
        }

        return "They are most likely to get " + total / allStats.size() + " points.";
    }
}
