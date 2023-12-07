package app;

import entity.Player;
import interface_adapter.ViewManagerModel;
import interface_adapter.bet_recommendation.RecommendController;
import interface_adapter.bet_recommendation.RecommendPresenter;
import interface_adapter.bet_recommendation.RecommendViewModel;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.player.PlayerController;
import interface_adapter.player.PlayerViewModel;
import interface_adapter.player.PlayerPresenter;
import use_case.bet_recommendation.RecommendationDataAccessInterface;
import use_case.player.PlayerDataAccessInterface;
import use_case.player.PlayerInputBoundary;
import use_case.player.PlayerInteractor;
import use_case.player.PlayerOutputBoundary;
import view.BetRecommendView;
import view.PlayerView;

import javax.swing.*;
import java.io.IOException;

public class PlayerUseCaseFactory {
    /** Prevent instantiation. */
    private PlayerUseCaseFactory() {}

    public static PlayerView create(
            ViewManagerModel viewManagerModel, PlayerViewModel playerViewModel,
            MenuViewModel menuViewModel, PlayerDataAccessInterface playerDataAccessInterface){

        try {
            PlayerController playerController = createPlayerUseCase(viewManagerModel,
                    playerViewModel, menuViewModel, playerDataAccessInterface);
            return new PlayerView(playerViewModel, playerController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static PlayerController createPlayerUseCase(
            ViewManagerModel viewManagerModel,
            PlayerViewModel playerViewModel, MenuViewModel menuViewModel, PlayerDataAccessInterface playerDataAccessInterface) throws IOException {

        PlayerOutputBoundary playerOutputBoundary = new PlayerPresenter(viewManagerModel,
                playerViewModel, menuViewModel);

        PlayerInputBoundary playerInteractor = new PlayerInteractor(playerDataAccessInterface,
                playerOutputBoundary);

        return new PlayerController(playerInteractor);
    }
}
