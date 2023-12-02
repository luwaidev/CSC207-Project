package use_case.bet_history;

public interface BetHistoryOutputBoundary {

    void sendHistory(String history);

    void backToMain();
}
