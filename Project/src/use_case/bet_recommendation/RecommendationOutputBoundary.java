package use_case.bet_recommendation;



public interface RecommendationOutputBoundary {
    void prepareSuccessView(RecommendationOutputData recommendation);

    void prepareFailView(RecommendationOutputData recommendationOutputData);

}

