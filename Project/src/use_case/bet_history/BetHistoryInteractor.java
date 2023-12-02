package use_case.bet_history;
import entity.User;
import entity.BetHistory;
import use_case.bet_predictor.BetOutputBoundary;

public class BetHistoryInteractor implements BetHistoryInputBoundary {
    final BetHistoryOutputBoundary betHistoryPresenter;
    private String username = "username";
    public String history = "";
    public BetHistoryInteractor(BetHistoryOutputBoundary betHistoryPresenter) {
        this.betHistoryPresenter = betHistoryPresenter;

    }
    @Override
    public void execute(BetHistoryInputData betHistoryInputData) {
        history = String.valueOf(BetHistory.getBetHistory(username));
        betHistoryPresenter.sendHistory(history);
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
