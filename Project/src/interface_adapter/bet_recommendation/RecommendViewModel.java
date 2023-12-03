package interface_adapter.bet_recommendation;

import interface_adapter.ViewModel;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RecommendViewModel extends ViewModel {
    public final String TITLE_LABEL = "Bet Recommendation";
    public final String INPUT_A_LABEL = "Favorite Player First Name";
    public final String INPUT_B_LABEL = "Favorite Player Last Name";
    public final String RECOMMEND_BUTTON_LABEL = "Generate Recommendation";

    private static RecommendState state = new RecommendState();
    public RecommendViewModel(){super("Bet Recommendation");}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public void setState (RecommendState state) {this.state = state;}
    public static RecommendState getState() {return state;}



}
