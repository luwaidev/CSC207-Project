package use_case.player_bet_predictor;

import entity.Player;

import java.util.ArrayList;

public class PlayerInteractor implements PlayerInputBoundary {

    final PlayerTeamDataAccessInterface playerDataAccessObject;
    final PlayerOutputBoundary playerPresenter;

    public PlayerInteractor(PlayerTeamDataAccessInterface playerDataAccessInterface,
                                    PlayerOutputBoundary playerOutputBoundary) {
        this.playerDataAccessObject = playerDataAccessInterface;
        this.playerPresenter = playerOutputBoundary;

    }
    @Override
    public void execute(PlayerInputData playerInputData) {
        String playerName = playerInputData.getPlayerName();

        // use player name to find ID in DAO

        // if ID is found in DAO, take the list of points

        // now calculate the average



    }
}
