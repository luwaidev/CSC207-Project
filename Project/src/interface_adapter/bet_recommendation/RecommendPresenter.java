package interface_adapter.bet_recommendation;

import use_case.bet_recommendation.RecommendationOutputBoundary;
import use_case.bet_recommendation.RecommendationOutputData;

import javax.swing.*;

public class RecommendPresenter implements RecommendationOutputBoundary {
    @Override
    public void prepareSuccessView(RecommendationOutputData recommendation) {
        JOptionPane.showMessageDialog(recommendation.panel, recommendation.getBet_recommendation());
    }

    @Override
    public void prepareFailView(RecommendationOutputData recommendation) {
        JOptionPane.showMessageDialog(recommendation.panel,"Invalid Player" );

    }
}
