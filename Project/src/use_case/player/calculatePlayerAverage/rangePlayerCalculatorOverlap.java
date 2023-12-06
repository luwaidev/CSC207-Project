package use_case.player.calculatePlayerAverage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collections;

public class rangePlayerCalculatorOverlap implements playerCalculator {
    /*
    Since this version is a bit more complicated, I wrote comments to go through each step.
    Feel free to check its correctness.

    Description/Explanation:
    - this calculator requires an input of an ArrayList of integers (stats that need to be calculated).
    - we take the minimum and the maximum stat value
    - find the range using max & min
    - divide the stats into "bins" (or ranges) of points that that has been previously achieved.
    - take each stat in the ArrayList<Integer> input and add how many times it occurs into their
    corresponding "bins"/ranges.

    (i'm not sure if this calculation makes sense, please check)
    - divide the highest value in the bins by the total number of games played for probability of getting points equivalent
    to the "bin"/range.

    returns a String saying which range of points is most likely to occur (along with the given %)

    related notes:
    - I divided the bins up into 2s, 3s, and then if all else fails into 1s
        -> I was worried that if I allowed for the possibility of 5, it would not be precise enough and that there
           wouldn't be enough stats for it to work properly.

    - note that the ranges allow for overlap (meaning that the ranges' mins and maxes will overlap)
        -> this means that the total of the values in each range >= allStats.size();
        -> left it alone since it doesn't affect it too much.
     */

    @Override
    public String calculatePlayer(ArrayList<Integer> allStats) {
        // find the minimum and maximum number of points in the given ArrayList<Integer> of stats.
        int min = findMin(allStats);
        int max = findMax(allStats);

        // find range of points
        int range = (max - min);

        /*
        Create HashMap<int[], Integer> to keep track of how many values appear in each "bin"/range.
        - int[] = "bin"/range
        - Integer = how many stats appear in there
         */
        HashMap<int[], Integer> points = new HashMap<>();
        // if the range is divisible by two, make the ranges in twos.
        if (range % 2 == 0) {
            /*
            for loop parameter explanation (double check for accuracy):
            - start with the min point value
            - run until max point value is in the highest range (hence why i < max and not i <= max)
            - increments of 2, since range%2 = 0
             */
            for (int i = min; i < max; i += 2) {
                // key indicating that range is between i and i+2
                int[] key = {i, i + 2};
                // num: # of times player has scored between i and i+2 (inclusive)
                int num = 0;
                // dict
                points.put(key, num);
                // go through each stat in allStats to check if they belong in range.
                for (int stat : allStats) {
                    if (stat == i || stat == i + 1 || stat == i + 2) {
                        points.put(key, num += 1);
                    }
                }
            }
        // same reasoning for the else-if and the following else statement :)
        } else if (range % 3 == 0) {
            // when it is divisible by 3
            for (int i = min; i < max; i += 3) {
                // same as for the earlier range
                int[] key = {i, i + 3};
                int num = 0;
                points.put(key, num);
                for (int stat : allStats) {
                    if (stat == i || stat == i + 1 || stat == i + 2 || stat == i + 3) {
                        points.put(key, num += 1);
                    }
                }
            }
            // i think that checking beyond this is kind of useless since the ranges would be far too big,
        } else {
            // case where range not divisible by 2 or 3 -> make the bins by 1 instead, simplest method.
            for (int i = min; i < max; i++) {
                int[] key = {i};
                int num = 0;
                points.put(key, num);
                for (int stat : allStats) {
                    if (stat == i) {
                        points.put(key, num += 1);
                    }
                }
            }

        }
        /*
         take highest value in the hashmap and then return its corresponding key
         take the highest value, divide by number of games played and that is the % that they will get
         points within that key (return string)
         */
        double maxProb = Collections.max(points.values());

        // find associated key
        // iterate each entry of hashmap
        int[] maxKey = new int[0];
        for (Entry<int[], Integer> entry : points.entrySet()) {
            // if give value is equal to value from entry
            // print the corresponding key
            if (entry.getValue() == maxProb) {
                maxKey = entry.getKey();
            }
        }


        double total = allStats.size();
        double probability = ((maxProb/total)*100);
        String prob = Double.toString(probability);
        String probPoints = Arrays.toString(maxKey);

        return "They have a " + prob + "% probability of achieving between " + probPoints + " points, inclusive.";
    }

    // private method for finding minimum value in ArrayList<Integer>
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

    // private method for finding max value in ArrayList<Integer>
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
