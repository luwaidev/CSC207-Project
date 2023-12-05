package app;


import interface_adapter.ViewManagerModel;

import interface_adapter.bet_recommendation.RecommendController;
import interface_adapter.bet_recommendation.RecommendPresenter;
import interface_adapter.bet_recommendation.RecommendViewModel;

import interface_adapter.menu.MenuViewModel;
import use_case.bet_recommendation.RecommendationDataAccessInterface;
import use_case.bet_recommendation.RecommendationInputBoundary;
import use_case.bet_recommendation.RecommendationInteractor;
import use_case.bet_recommendation.RecommendationOutputBoundary;

import view.BetRecommendView;

import javax.swing.*;
import java.io.IOException;

public class BetRecommendationUseCaseFactory {
    /** Prevent instantiation. */
    private BetRecommendationUseCaseFactory() {}

    public static BetRecommendView create(
            ViewManagerModel viewManagerModel,
            RecommendViewModel recommendViewModel,
            RecommendationDataAccessInterface recommendationDataAccessInterface, MenuViewModel menuViewModel){

        try {
            RecommendController recommendController = createBetRecommendationUseCase(viewManagerModel, recommendViewModel, recommendationDataAccessInterface, menuViewModel);
            return new BetRecommendView(recommendViewModel, recommendController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static RecommendController createBetRecommendationUseCase(
            ViewManagerModel viewManagerModel,
            RecommendViewModel recommendViewModel, RecommendationDataAccessInterface recommendationDataAccessInterface, MenuViewModel menuViewModel) throws IOException {

        RecommendationOutputBoundary recommendationOutputBoundary = new RecommendPresenter(recommendViewModel,
                viewManagerModel, menuViewModel);

        RecommendationInputBoundary recommendationInteractor = new RecommendationInteractor(recommendationDataAccessInterface,recommendationOutputBoundary);

        return new RecommendController(recommendationInteractor);
    }
}
