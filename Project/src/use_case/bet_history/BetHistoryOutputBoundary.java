package use_case.bet_history;

public interface BetHistoryOutputBoundary {
    void backToMain();

    void sendHistory(String history);
}
