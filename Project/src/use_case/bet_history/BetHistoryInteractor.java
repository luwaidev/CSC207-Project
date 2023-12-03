package use_case.bet_history;
import entity.BetHistory;

public class BetHistoryInteractor implements BetHistoryInputBoundary {
    final BetHistoryOutputBoundary betHistoryPresenter;
    private String username = "username";
    public String history = "history";

    public BetHistoryInteractor(BetHistoryOutputBoundary betHistoryPresenter) {
        this.betHistoryPresenter = betHistoryPresenter;
    }

    @Override
    public void setHistory(String betHistoryInputData) {
        this.history = String.valueOf(BetHistory.getBetHistory(username));
        if (history == null) {
            history = "No bets have been predicted yet";
        }
        betHistoryPresenter.sendHistory(history);

    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getHistory(String username) {
        this.history = String.valueOf(BetHistory.getBetHistory(username));
        if (history.equals("null")) {
            history = "No bets have been predicted yet";
        }
        return history;

        }
    @Override
    public void backToMain() {
        betHistoryPresenter.backToMain();
    }



}
