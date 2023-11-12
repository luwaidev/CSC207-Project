package interface_adapter.bet_prediction;

import use_case.bet_predictor.BetOutputBoundary;
import use_case.bet_predictor.BetOutputData;

public class BetPresenter implements BetOutputBoundary {
    @Override
    public void prepareSuccessView(BetOutputData team) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
