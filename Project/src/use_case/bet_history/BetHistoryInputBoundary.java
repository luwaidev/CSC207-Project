package use_case.bet_history;


public interface BetHistoryInputBoundary {
    void execute(BetHistoryInputData betHistoryInputData);
    void setUsername(String username);
    void backToMain();
}
