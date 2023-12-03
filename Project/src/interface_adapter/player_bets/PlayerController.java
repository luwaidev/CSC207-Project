package interface_adapter.player_bets;

import use_case.player_bet_predictor.PlayerInputBoundary;
import use_case.player_bet_predictor.PlayerInputData;

import javax.swing.*;

public class PlayerController {
    final PlayerInputBoundary playerInteractor;
    public PlayerController(PlayerInputBoundary playerInteractor) {
        this.playerInteractor = playerInteractor;
    }

    public void execute(String firstName, String lastName, JPanel panel){
        PlayerInputData playerInputData = new PlayerInputData(firstName, lastName, panel);
        playerInteractor.execute(playerInputData);
    }

    public void setUsername(String username){
        playerInteractor.setUsername(username);
    }

    public void backToMain(){
        playerInteractor.backToMain();
    }


}
