package use_case.bet_recommendation;

import javax.swing.*;

public class RecommendationInputData {
    private final String name;


    public JPanel panel;

    public RecommendationInputData(String name, JPanel panel) {
        this.name = name;

        this.panel = panel;
    }

    public String getName(){return this.name;}



}
