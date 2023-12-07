package use_case.player;

import data_access.PlayerDataAccessObject;
import entity.Player;
import use_case.player.calculatePlayerAverage.Context;
import use_case.player.calculatePlayerAverage.rangePlayerCalculatorOverlap;

public class PlayerInteractor implements PlayerInputBoundary {

    final PlayerDataAccessInterface playerDataAccessObject;
    final PlayerOutputBoundary playerPresenter;
    private String username = "username";

    public PlayerInteractor(PlayerDataAccessInterface playerDataAccessInterface,
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
