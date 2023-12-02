package interface_adapter.bet_recommendation;


import use_case.bet_recommendation.RecommendationInputBoundary;
import use_case.bet_recommendation.RecommendationInputData;

import javax.swing.*;

public class RecommendController {
    final RecommendationInputBoundary recommendationInteractor;

    public RecommendController(RecommendationInputBoundary recommendationInteractor) {
        this.recommendationInteractor = recommendationInteractor;
    }


    public void execute(String first_name, String last_name, JPanel panel) {
        RecommendationInputData recommendationInputData = new RecommendationInputData(first_name,last_name,panel);

        recommendationInteractor.execute(recommendationInputData);
    }
}

