package interface_adapter.menu;

import interface_adapter.logged_in.LoggedInState;

public class MenuState {
    private String username = "";

    public MenuState(MenuState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public MenuState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
