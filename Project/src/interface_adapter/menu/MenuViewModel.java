package interface_adapter.menu;

import interface_adapter.ViewModel;
import interface_adapter.menu.MenuState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MenuViewModel extends ViewModel {

    public final String TITLE_LABEL = "Main Menu";
    public final String BET_PREDICTION_BUTTON = "Predict a Bet";
    public final String LOG_OUT_BUTTON = "Log Out";
    public final String BET_HISTORY_BUTTON = "Bet History";
    public final String BET_RECOMMENDATION_BUTTON = "Bet Recommendation";
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
