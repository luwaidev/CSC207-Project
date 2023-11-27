package use_case.bet_recommendation;

public class RecommendationInteractor implements RecommendationInputBoundary{
    final RecommendationDataAccessInterface playerDataAccessObject;
    final RecommendationOutputBoundary recommendPresenter;

    public RecommendationInteractor(RecommendationDataAccessInterface recommendationDataAccessInterface,
                                    RecommendationOutputBoundary recommendationOutputBoundary) {
        this.playerDataAccessObject = recommendationDataAccessInterface;
        this.recommendPresenter = recommendationOutputBoundary;

    }
    @Override
    public void execute(RecommendationInputData recommendationInputData) {
        String fav_player = recommendationInputData.getFav_player();



    }
}
