package interface_adapter.bet_history;

public class BetHistoryState {
    private String username = "";
    private String history = "";

    public BetHistoryState(BetHistoryState copy) {
        username = copy.username;
        history = copy.history;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public BetHistoryState() {}
    public String getUsername() {return username;}
    public String getHistory() {return history;}
    public void setHistory(String history) {this.history = history;}
    public void setUsername(String username) {this.username = username;}

}