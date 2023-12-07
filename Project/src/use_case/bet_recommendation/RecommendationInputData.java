package use_case.bet_recommendation;

import javax.swing.*;

public class RecommendationInputData {
    private final String name;

    private String username;

    public JPanel panel;

    public RecommendationInputData(String name, JPanel panel) {
        this.name = name;
        this.panel = panel;
    }


    String getName(){return this.name;}
    String getUsername() {return this.username;}


}

