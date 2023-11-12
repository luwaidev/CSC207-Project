package use_case.bet_predictor;

public class BetOutputData {

    private final String higherwinpct_team;
    private boolean useCaseFailed;

    public BetOutputData(String higherwinpct_team, boolean useCaseFailed) {
        this.higherwinpct_team = higherwinpct_team;
        this.useCaseFailed = useCaseFailed;

    }
    public String getHigherwinpct_team() {
        return this.higherwinpct_team;
    }
}
