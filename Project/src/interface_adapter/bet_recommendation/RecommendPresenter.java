package interface_adapter.bet_recommendation;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import use_case.bet_recommendation.RecommendationOutputBoundary;
import use_case.bet_recommendation.RecommendationOutputData;

import javax.swing.*;


public class RecommendPresenter implements RecommendationOutputBoundary {

    public RecommendPresenter() {

    }

    @Override
    public void prepareSuccessView(RecommendationOutputData recommendation) {
        JOptionPane.showMessageDialog(recommendation.panel, recommendation.getBet_recommendation());

    }

    @Override
    public void prepareFailView(RecommendationOutputData recommendation) {
        JOptionPane.showMessageDialog(recommendation.panel,"Invalid Player" );

    }
}
