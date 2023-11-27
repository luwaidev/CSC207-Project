package interface_adapter.bet_history;
import interface_adapter.ViewModel;
import interface_adapter.bet_prediction.BetPredictionState;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BetHistoryViewModel extends ViewModel {

    private static final String viewName = "Bet History";
    public final String TITLE_LABEL = "Bet History";
    private final JTextArea history = null;

    public BetHistoryViewModel() {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
//    private BetPredictionState state = new BetPredictionState();
//
//    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
//
//    public void firePropertyChanged() {
//        support.firePropertyChange("state", null, this.state);
//    }
//
//
//
//    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        support.addPropertyChangeListener(listener);
//    }
//
//
//    public void setState (BetPredictionState state) {this.state = state;}
//    public BetPredictionState getState() {return state;}
}