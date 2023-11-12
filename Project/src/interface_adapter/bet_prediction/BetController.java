package interface_adapter.bet_prediction;

import use_case.bet_predictor.BetInputBoundary;
import use_case.bet_predictor.BetInputData;


public class BetController {
    final BetInputBoundary betUseCaseInteractor;
    public BetController(BetInputBoundary betUseCaseInteractor) {
        this.betUseCaseInteractor = betUseCaseInteractor;
    }


    public void execute(String team1, String team2) {
        BetInputData loginInputData = new BetInputData(
                team1, team2);

        betUseCaseInteractor.execute(loginInputData);
    }
}
