package interface_adapter.menu;

import interface_adapter.ViewModel;
import interface_adapter.menu.MenuState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MenuViewModel extends ViewModel {

    public final String TITLE_LABEL = "SPORTSMART";
    public final String USER_WELCOME_LABEL = "Welcome, ";
    public final String USER_WELCOME_SUBLABEL = "what would you like to do? ";
    public final String BET_PREDICTION_BUTTON = "Prediction";
    public final String BET_PREDICTION_BUTTON_DESCRIPTION = "Input two teams, and have our state of the art algorithms determine which is a better bet";
    public final String BET_HISTORY_BUTTON = "History";
    public final String BET_HISTORY_BUTTON_DESCRIPTION = "View your previous team bets, player bets and recommendations";
    public final String BET_RECOMMENDATION_BUTTON = "Recommend";
    public final String BET_RECOMMENDATION_BUTTON_DESCRIPTION = "Input your favorite player and get a recommendation on how to bet for them";
    public final String PLAYER_BUTTON = "Player Bets";
    public final String PLAYER_BUTTON_DESCRIPTION = "Input your favorite player and get the probability they will score a set number of points";
    public final String LOG_OUT_BUTTON = "Log Out";
  
    private MenuState state = new MenuState();

    public MenuViewModel(){super("menu");}


    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }



    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    public void setState (MenuState state) {this.state = state;}
    public MenuState getState() {return state;}
}
