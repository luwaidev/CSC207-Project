package interface_adapter.bet_recommendation;


import use_case.bet_recommendation.RecommendationInputBoundary;
import use_case.bet_recommendation.RecommendationInputData;

import javax.swing.*;

public class RecommendController {
    final RecommendationInputBoundary recommendationInteractor;

    public RecommendController(RecommendationInputBoundary recommendationInteractor) {
        this.recommendationInteractor = recommendationInteractor;
    }


    public void execute(String name, JPanel panel) {
        RecommendationInputData recommendationInputData = new RecommendationInputData(name, panel);

        recommendationInteractor.execute(recommendationInputData);
    }

    public void backToMain(){
        recommendationInteractor.backToMain();
    }
}

