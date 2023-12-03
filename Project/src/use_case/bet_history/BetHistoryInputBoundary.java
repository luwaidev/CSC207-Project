package use_case.bet_history;


public interface BetHistoryInputBoundary {
    void setHistory(String username);
    String getHistory(String username);
    void setUsername(String username);
    void backToMain();
}
