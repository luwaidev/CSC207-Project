package interface_adapter.bet_prediction;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BetPredictionViewModel extends ViewModel {

    public final String TITLE_LABEL = "SPORTSMART";
    public final String SUBTITLE_LABEL = "Bet Prediction";
    public final String INPUT_A_LABEL = "Team One: ";
    public final String INPUT_B_LABEL = "Team Two: ";

    public final String BACK_BUTTON_LABEL = "Back";
    public final String PREDICT_BUTTON_LABEL = "Predict Winner";

    private BetPredictionState state = new BetPredictionState();
    public BetPredictionViewModel(){super("bet prediction");}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }



    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }


    public void setState (BetPredictionState state) {this.state = state;}
    public BetPredictionState getState() {return state;}


}
