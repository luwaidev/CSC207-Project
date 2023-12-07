package interface_adapter.bet_recommendation;

import interface_adapter.ViewModel;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RecommendViewModel extends ViewModel {
    public final String TITLE_LABEL = "SPORTSMART";
    public final String SUBTITLE_LABEL = "Bet Recommendation";
    public final String INPUT_A_LABEL = "Enter your favorite player's first and last name with one space in between";
    public final String RECOMMEND_BUTTON_LABEL = "Recommend";
    public final String BACK_BUTTON_LABEL = "Back";

    private static RecommendState state = new RecommendState();
    public RecommendViewModel(){super("bet recommendation");}
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public void setState (RecommendState state) {
        RecommendViewModel.state = state;}
    public static RecommendState getState() {return state;}



}
