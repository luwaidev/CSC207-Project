package interface_adapter.player_bets;

import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PlayerPredictionViewModel extends ViewModel {
    public final String TITLE_LABEL = "Predict amount of points";
    public final String INPUT_A_LABEL = "Player First Name";
    public final String INPUT_B_LABEL = "Player Last Name";
    public final String BACK_BUTTON_LABEL = "Back";
    public final String PREDICT_BUTTON_LABEL = "Predict amount of points";
    private PlayerPredictionState state = new PlayerPredictionState();

    public PlayerPredictionViewModel(){
        super("player prediction");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setState (PlayerPredictionState state){
        this.state = state;
    }

    public PlayerPredictionState getState(){
        return state;
    }
}
