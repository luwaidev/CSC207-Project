package use_case.player_bet_predictor;

public class PlayerInputData {
    private final String player;

    public PlayerInputData(String player){
        this.player = player;
    }

    String getPlayerName(){return this.player;}
}
