package use_case.bet_history;
import entity.User;
import entity.BetHistory;
import use_case.bet_predictor.BetOutputBoundary;

public class BetHistoryInteractor implements BetHistoryInputBoundary {
    final BetHistoryOutputBoundary betHistoryPresenter;
    public BetHistoryInteractor(BetHistoryOutputBoundary betHistoryPresenter) {
        this.betHistoryPresenter = betHistoryPresenter;

    }
    public void savetoHistory (String user, String team1, String team2, String winningTeam) {
        String bet = user+ team1 + team2 + winningTeam;
        BetHistory.setBetHistory(user, bet);
    }
    public void getHistory (String user) {
        BetHistory.getBetHistory(user);
    }

    public void exportHistory () {

    }

    public void importHistory () {

    }
}
