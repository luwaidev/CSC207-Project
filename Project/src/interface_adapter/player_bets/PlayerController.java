package interface_adapter.player_bets;

import use_case.player_bet_predictor.PlayerInputBoundary;
import use_case.player_bet_predictor.PlayerInputData;

public class PlayerController {
    final PlayerInputBoundary playerInteractor;
    public PlayerController(PlayerInputBoundary playerInteractor) {
        this.playerInteractor = playerInteractor;
    }

    public void execute(String firstName, String lastName){
        PlayerInputData playerInputData = new PlayerInputData(firstName, lastName);
        playerInteractor.execute(playerInputData);
    }
}
