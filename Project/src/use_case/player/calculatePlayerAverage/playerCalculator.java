package use_case.player.calculatePlayerAverage;

import java.util.ArrayList;

public interface playerCalculator {
    /*
    this implementation should work for any list of player stats (since it just takes in a list) and
    technically could also be applied for team prediction calculations, but it's tailored primarily for
    calculating for players so keep that in mind when using for other things.

     */

    // i had to make it return object since rangePlayerCalculator and meanPlayerCalculator have different return types.
    String calculatePlayer(ArrayList<Integer> allStats);
}
