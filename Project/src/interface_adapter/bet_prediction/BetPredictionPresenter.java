package interface_adapter.bet_prediction;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuViewModel;
import use_case.bet_predictor.BetOutputBoundary;
import use_case.bet_predictor.BetOutputData;

import javax.swing.*;

public class BetPredictionPresenter implements BetOutputBoundary {
    private final BetPredictionViewModel betPredictionViewModel;

    final ViewManagerModel viewManagerModel;

    public BetPredictionPresenter(ViewManagerModel viewManagerModel,
                          BetPredictionViewModel betPredictionViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.betPredictionViewModel = betPredictionViewModel;
    }

    @Override
    public void prepareSuccessView(BetOutputData teams) {
        JOptionPane.showMessageDialog(teams.panel, teams.getHigherwinpct_team());

    }

    @Override
    public void prepareFailView(BetOutputData teams) {
        JOptionPane.showMessageDialog(teams.panel,"Invalid Player" );
    }
}
