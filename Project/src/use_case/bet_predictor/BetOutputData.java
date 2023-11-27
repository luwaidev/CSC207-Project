package use_case.bet_predictor;

import javax.swing.*;

public class BetOutputData {

    private final String higherwinpct_team;
    private boolean useCaseFailed;
    public JPanel panel;

    public BetOutputData(String higherwin_team, JPanel panel ) {
        this.higherwinpct_team = higherwin_team;
        this.panel = panel;
}
    public String getHigherwinpct_team() {
        return this.higherwinpct_team;
    }
}
