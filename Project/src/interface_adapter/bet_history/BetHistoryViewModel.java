package interface_adapter.bet_history;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BetHistoryViewModel extends ViewModel {

    public final String TITLE_LABEL = "Bet History";
    private static BetHistoryState state = new BetHistoryState();
    public BetHistoryViewModel(){super("bet history");}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }



    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    public void setState (BetHistoryState state) {this.state = state;}
    public static BetHistoryState getState() {return state;}


}