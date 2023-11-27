package interface_adapter.bet_prediction;

import use_case.bet_predictor.BetOutputBoundary;
import use_case.bet_predictor.BetOutputData;

import javax.swing.*;

public class BetPresenter implements BetOutputBoundary {
    @Override
    public void prepareSuccessView(BetOutputData teams) {
        JOptionPane.showMessageDialog(teams.panel, teams.getHigherwinpct_team());

    }

    @Override
    public void prepareFailView(BetOutputData teams) {
        JOptionPane.showMessageDialog(teams.panel,"Invalid Player" );
    }
}
