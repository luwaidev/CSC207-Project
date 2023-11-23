package interface_adapter.bet_prediction;

public class BetPredictionState {
    private String inputA = "";
    private String inputB = "";

    public BetPredictionState(BetPredictionState copy){
        inputA = copy.inputA;
        inputB = copy.inputB;
    }

    public BetPredictionState() {}

    public String getInputA() {return inputA;}
    public String getInputB() {return inputB;}
    public void setInputA(String inputA){this.inputA = inputA;}
    public void setInputB(String inputB){this.inputB = inputB;}
}
