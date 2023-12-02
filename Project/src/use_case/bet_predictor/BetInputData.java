package use_case.bet_predictor;

import javax.swing.*;

public class BetInputData {

    private final String team1;
    private final String team2;

    private final String username;


    public JPanel panel;
    public BetInputData(String team1, String team2, String username,  JPanel panel) {
        this.team1 = team1;
        this.team2 = team2;
        this.username = username;
        this.panel = panel;

    }
    String getTeam1Name(){return this.team1;}
    String getTeam2Name(){return this.team2;}
    String getUsername() {return this.username;}

}
