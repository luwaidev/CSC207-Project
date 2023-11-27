package use_case.bet_recommendation;

import javax.swing.*;

public class RecommendationOutputData {
    private final String bet_recommendation;
    private boolean useCaseFailed;
    public JPanel panel;

    public RecommendationOutputData(String bet_recommendation, JPanel panel) {
        this.bet_recommendation = bet_recommendation;
        this.panel = panel;

    }
    public String getBet_recommendation() {
        return this.bet_recommendation;
    }
}
