package use_case.player_bet_predictor;

import use_case.bet_predictor.BetOutputData;

public interface PlayerOutputBoundary {
    void prepareSuccessView(PlayerOutputData playerOutputData);

    void prepareFailView(String error);

}
