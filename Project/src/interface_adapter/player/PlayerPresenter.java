package interface_adapter.player;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuViewModel;
import use_case.player.PlayerOutputBoundary;
import use_case.player.PlayerOutputData;

import javax.swing.*;

public class PlayerPresenter implements PlayerOutputBoundary {
    private final PlayerViewModel playerPredictionViewModel;

    final ViewManagerModel viewManagerModel;
    final MenuViewModel menuViewModel;

    public PlayerPresenter(ViewManagerModel viewManagerModel,
                           PlayerViewModel playerPredictionViewModel,
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
