package interface_adapter.bet_history;

public class BetHistoryState {
    private String inputA = "a";
    private String inputB = "b";

    public BetHistoryState(BetHistoryState copy){
        inputA = copy.inputA;
        inputB = copy.inputB;
    }

    public BetHistoryState() {}


}