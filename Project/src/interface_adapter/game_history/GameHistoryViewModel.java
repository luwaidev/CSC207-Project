package interface_adapter.game_history;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameHistoryViewModel extends ViewModel {


    private GameHistoryState state = new GameHistoryState();
    public GameHistoryViewModel(){super("game history");}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }



    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    public void setState (GameHistoryState state) {this.state = state;}
    public GameHistoryState getState() {return state;}
}
