package use_case.bet_recommendation;



public interface RecommendationOutputBoundary {
    void prepareSuccessView(RecommendationOutputData recommendationOutputData);

    void prepareFailView(RecommendationOutputData recommendationOutputData);

}

