package interface_adapter.player_bets;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuViewModel;
import use_case.player_bet_predictor.PlayerOutputBoundary;
import use_case.player_bet_predictor.PlayerOutputData;

import javax.swing.*;

public class PlayerPresenter implements PlayerOutputBoundary {
    private final PlayerPredictionViewModel playerPredictionViewModel;

    final ViewManagerModel viewManagerModel;
    final MenuViewModel menuViewModel;

    public PlayerPresenter(ViewManagerModel viewManagerModel,
                           PlayerPredictionViewModel playerPredictionViewModel,
                           MenuViewModel menuViewModel){
        this.viewManagerModel = viewManagerModel;
        this.playerPredictionViewModel = playerPredictionViewModel;
        this.menuViewModel = menuViewModel;
    }

    @Override
    public void prepareSuccessView(PlayerOutputData playerOutputData){
        JOptionPane.showMessageDialog(playerOutputData.panel, playerOutputData.getLikelyPointNum());
    }

    @Override
    public void prepareFailView(PlayerOutputData playerOutputData){
        JOptionPane.showMessageDialog(playerOutputData.panel, "Invalid Player.");
    }

    public void backToMain() {
        this.viewManagerModel.setActiveView(menuViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
