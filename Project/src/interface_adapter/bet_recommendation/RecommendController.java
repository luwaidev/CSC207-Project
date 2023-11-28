package interface_adapter.bet_recommendation;


import use_case.bet_recommendation.RecommendationInputBoundary;
import use_case.bet_recommendation.RecommendationInputData;

public class RecommendController {
    final RecommendationInputBoundary recommendationInteractor;

    public RecommendController(RecommendationInputBoundary recommendationInteractor) {
        this.recommendationInteractor = recommendationInteractor;
    }


    public void execute(String player) {
        RecommendationInputData recommendationInputData = new RecommendationInputData(player);

        recommendationInteractor.execute(recommendationInputData);
    }
}
