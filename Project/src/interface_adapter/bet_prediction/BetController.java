package interface_adapter.bet_prediction;

import use_case.bet_predictor.BetInputBoundary;
import use_case.bet_predictor.BetInputData;

import javax.swing.*;


public class BetController {
    final BetInputBoundary betInteractor;
    public BetController(BetInputBoundary betUseCaseInteractor) {
        this.betInteractor = betUseCaseInteractor;
    }


    public void execute(String team1, String team2, JPanel panel) {
        BetInputData betInputData = new BetInputData(team1, team2,panel);

        betInteractor.execute(betInputData);
    }
}
