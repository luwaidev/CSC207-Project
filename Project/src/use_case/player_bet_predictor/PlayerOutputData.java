package use_case.player_bet_predictor;

public class PlayerOutputData {
    private final double likelyPointNum;

    private boolean useCaseFailed;

    public PlayerOutputData(String likelyPointNum){
        this.likelyPointNum = Double.parseDouble(likelyPointNum);
    }
    public double getLikelyPointNum(){
        return this.likelyPointNum;
    }

}
