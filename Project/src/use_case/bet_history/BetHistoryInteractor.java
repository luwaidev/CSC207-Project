package use_case.bet_history;
import entity.User;
import entity.BetHistory;

public class BetHistoryInteractor {
    public void savetoHistory (User user, String team1, String team2, String winningTeam) {
        String bet = user.getName() + team1 + team2 + winningTeam;
        BetHistory.setBetHistory(user, bet);
    }
    public void getHistory (User user) {
        BetHistory.getBetHistory(user);
    }

    public void exportHistory () {

    }

    public void importHistory () {

    }
}
