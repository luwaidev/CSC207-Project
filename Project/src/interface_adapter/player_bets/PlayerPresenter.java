package interface_adapter.player_bets;

import use_case.player_bet_predictor.PlayerOutputBoundary;
import use_case.player_bet_predictor.PlayerOutputData;

public class PlayerPresenter implements PlayerOutputBoundary {
    @Override
    public void prepareSuccessView(PlayerOutputData playerOutputData){
    }

    @Override
    public void prepareFailView(String error){

    }
}
