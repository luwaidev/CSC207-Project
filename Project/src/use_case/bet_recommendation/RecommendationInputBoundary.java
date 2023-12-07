package use_case.bet_recommendation;

public interface RecommendationInputBoundary {
    void execute(RecommendationInputData recommendationInputData);

    void setUsername(String username);

    void backToMain();
}
