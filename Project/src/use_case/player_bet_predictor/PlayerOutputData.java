package use_case.player_bet_predictor;

public class PlayerOutputData {
    private final double likelyPointNum;

    private boolean useCaseFailed;

    public PlayerOutputData(double likelyPointNum, boolean useCaseFailed){
        this.likelyPointNum = likelyPointNum;
        this.useCaseFailed = useCaseFailed;
    }
    public double getLikelyPointNum(){
        return this.likelyPointNum;
    }

}
