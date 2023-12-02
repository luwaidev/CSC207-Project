package interface_adapter.bet_history;

import interface_adapter.logged_in.LoggedInState;

public class BetHistoryState {
    private String username = "";

    public BetHistoryState(BetHistoryState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public BetHistoryState() {}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

}