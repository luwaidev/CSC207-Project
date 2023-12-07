package use_case.player.calculatePlayerAverage;

import java.util.ArrayList;

public class Context {
    private final playerCalculator playerCalculator;

    public Context(playerCalculator playerCalculator){
        this.playerCalculator = playerCalculator;
    }

    public String executeStrategy(ArrayList<Integer> allStats) {
        return playerCalculator.calculatePlayer(allStats);
    }
}
