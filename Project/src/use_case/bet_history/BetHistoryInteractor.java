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
    }
    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void backToMain() {
        betHistoryPresenter.backToMain();
    }



}
