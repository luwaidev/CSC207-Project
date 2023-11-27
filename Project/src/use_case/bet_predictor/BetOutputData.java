package use_case.bet_predictor;

import javax.swing.*;

public class BetOutputData {

    private final String higherwinpct_team;
    public JPanel panel;

    public BetOutputData(String higherwin_team, JPanel jpanel) {
        this.higherwinpct_team = higherwin_team;
        this.panel = jpanel;

    }
    public String getHigherwinpct_team() {
        return this.higherwinpct_team;
    }
}
