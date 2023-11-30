package interface_adapter.bet_prediction;

import use_case.bet_predictor.BetInputBoundary;
import use_case.bet_predictor.BetInputData;

import javax.swing.*;


public class BetPredictionController {
    final BetInputBoundary betUseCaseInteractor;

    public BetPredictionController(BetInputBoundary betUseCaseInteractor) {
        this.betUseCaseInteractor = betUseCaseInteractor;
    }


    public void execute(String team1, String team2, JPanel panel) {
        BetInputData betInputData = new BetInputData(team1, team2, panel);
        betUseCaseInteractor.execute(betInputData);
    }

    public void setUsername(String username){
        betUseCaseInteractor.setUsername(username);
    }
}
