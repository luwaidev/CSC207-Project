package use_case.player_bet_predictor;

import data_access.PlayerDataAccessObject;
import data_access.TeamDataAccessObject;
import entity.Player;
import use_case.player_bet_predictor.calculatePlayerAverage.Context;
import use_case.player_bet_predictor.calculatePlayerAverage.meanPlayerCalculator;
import use_case.player_bet_predictor.calculatePlayerAverage.rangePlayerCalculatorOverlap;

import java.util.ArrayList;

public class PlayerInteractor implements PlayerInputBoundary {

    final PlayerTeamDataAccessInterface playerDataAccessObject;
    final PlayerOutputBoundary playerPresenter;
    private String username = "username";

    public PlayerInteractor(PlayerTeamDataAccessInterface playerDataAccessInterface,
                                    PlayerOutputBoundary playerOutputBoundary) {
        this.playerDataAccessObject = playerDataAccessInterface;
        this.playerPresenter = playerOutputBoundary;

    }
    @Override
    public void execute(PlayerInputData playerInputData) {
        String playerFirstName = playerInputData.getFirstName();
        String playerLastName = playerInputData.getLastName();

        Player player = PlayerDataAccessObject.getPlayerStats(PlayerDataAccessObject.getPlayerID(playerFirstName, playerLastName));

        Context context = new Context(new rangePlayerCalculatorOverlap());

        PlayerOutputData pointsWon = new PlayerOutputData(context.executeStrategy(player.getPointsPerGame()), playerInputData.panel);
        playerPresenter.prepareSuccessView(pointsWon);

    }

    @Override
    public void setUsername(String username) {
        this.username = username;
        System.out.println("Username set to: " + username + " in BetInteractor");
    }

    @Override
    public void backToMain() {
        playerPresenter.backToMain();

    }
}
