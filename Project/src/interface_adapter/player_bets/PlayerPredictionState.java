package interface_adapter.player_bets;

public class PlayerPredictionState {
    private String username = "";
    private String inputA = "";
    private String inputB = "";
    public PlayerPredictionState(PlayerPredictionState copy){
        inputA = copy.inputA;
        inputB = copy.inputB;
    }
    public PlayerPredictionState(){

    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getInputA(){
        return inputA;
    }

    public String getInputB(){
        return inputB;
    }

    public void setInputA(String inputA){
        this.inputA = inputA;
    }

    public void setInputB(String inputB){
        this.inputB = inputB;
    }

}
