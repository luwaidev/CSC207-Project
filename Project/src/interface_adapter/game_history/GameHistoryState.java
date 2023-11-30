package interface_adapter.game_history;

import interface_adapter.bet_prediction.BetPredictionState;

public class GameHistoryState {
    private String inputA = "";
    private String inputB = "";

    public GameHistoryState(GameHistoryState copy){
        inputA = copy.inputA;
        inputB = copy.inputB;
    }

    public GameHistoryState() {}

    public String getInputA() {return inputA;}
    public String getInputB() {return inputB;}
    public void setInputA(String inputA){this.inputA = inputA;}
    public void setInputB(String inputB){this.inputB = inputB;}
}
