package use_case.bet_recommendation;

import javax.swing.*;

public class RecommendationInputData {
    private final String first_name;
    private final String last_name;

    public JPanel panel;

    public RecommendationInputData(String first_name, String last_name, JPanel panel) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.panel = panel;
    }

    String getFirst_name(){return this.first_name;}

    String getLast_name() {return this.last_name;}

}
