package data_access.calculatePlayerAverage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class rangePlayerCalculator implements playerCalculator {
    /*
    this version is a bit more complicated. i'm still working on it
     */

    // TODO: since this version is a bit more complicated, i'll write comments going through each thing later as a check.
    @Override
    public Object calculatePLayer(ArrayList<Integer> allStats) {
        // (1) take the range (max - min) of points
        int min = findMin(allStats);
        int max = findMax(allStats);
        int range = (max - min);

        // (2) divide into bins (make sure num of bins is not > size of list)

        // interval is how the bins are divided up
        HashMap<int[], int[]> points = new HashMap<>();
        if (range/2 != 0) {
            // when divisible by 2

            //
            for (int i = min; i < max; i+= 2){
                // not entirely sure if the for loop parameters work accurately. someone pls double check
                int[] key = {i, i + 2};
                points.put(key, null);
            }
            for (int stats : allStats) {

            }

        } else if (range/3 != 0) {
            // when it is divisible by 3
            for (int i = min; i < max; i += 3) {
                // same as for the earlier range
                int[] key = {i, i + 3};
                points.put(key, null);
            }
        }

        // (3) make bins into dict
        // (4) assign into their respective bins
        // (5) take bin w/ most things inside
        // (6) divide by total number of
    }

    private static int findMin(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }

        int min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    private static int findMax(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is empty or null");
        }

        int max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            if (current > max) {
                max = current;
            }
        }

        return max;
    }
}
