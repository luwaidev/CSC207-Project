package use_case.bet_history;

public class BetHistoryInputData {
    private final String username;
    public BetHistoryInputData(String username) {
        this.username = username;
    }
    String getUsername() {return this.username;}

}
