package interface_adapter.bet_prediction;

public class BetPredictionState {
    private String username = "";
    private String inputA = "";
    private String inputB = "";

    public BetPredictionState(BetPredictionState copy){
        inputA = copy.inputA;
        inputB = copy.inputB;
    }

    public BetPredictionState() {}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public String getInputA() {return inputA;}
    public String getInputB() {return inputB;}
    public void setInputA(String inputA){this.inputA = inputA;}
    public void setInputB(String inputB){this.inputB = inputB;}
}
