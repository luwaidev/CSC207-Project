package interface_adapter.bet_prediction;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuViewModel;
import use_case.bet_predictor.BetOutputBoundary;
import use_case.bet_predictor.BetOutputData;


import javax.swing.*;

public class BetPresenter implements BetOutputBoundary {
    private ViewManagerModel viewManagerModel;
    private final MenuViewModel menuViewModel;

    public BetPresenter(ViewManagerModel viewManagerModel, MenuViewModel menuViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.menuViewModel = menuViewModel;
    }


    @Override
    public void prepareSuccessView(BetOutputData teams) {
        JOptionPane.showMessageDialog(teams.panel, teams.getHigherwinpct_team());

    }

    @Override
    public void prepareFailView(BetOutputData teams) {
        JOptionPane.showMessageDialog(teams.panel,"Invalid Player" );
    }

    @Override
    public void backToMain() {
        this.viewManagerModel.setActiveView(menuViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
