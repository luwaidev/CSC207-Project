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
    private Object state;

    public BetHistoryViewModel() {
        super(viewName);
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() { support.firePropertyChange("state", null, this.state);    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

}