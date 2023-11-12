package use_case.bet_predictor;

public class BetOutputData {

    private final String higherwinpct_team;

    public BetOutputData(String higherwin_team, boolean useCaseFailed) {
        this.higherwinpct_team = higherwin_team;

    }
    public String getHigherwinpct_team() {
        return this.higherwinpct_team;
    }
}
