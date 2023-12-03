package use_case.player_bet_predictor.calculatePlayerAverage;

import java.util.ArrayList;

public class Context {
    private playerCalculator playerCalculator;

    public Context(playerCalculator playerCalculator){
        this.playerCalculator = playerCalculator;
    }

    public String executeStrategy(ArrayList<Integer> allStats) {
        return playerCalculator.calculatePlayer(allStats);
    }
}
