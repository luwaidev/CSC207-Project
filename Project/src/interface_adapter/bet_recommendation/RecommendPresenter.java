package interface_adapter.bet_recommendation;

import interface_adapter.ViewManagerModel;
import interface_adapter.bet_history.BetHistoryViewModel;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import use_case.bet_recommendation.RecommendationOutputBoundary;
import use_case.bet_recommendation.RecommendationOutputData;

import javax.swing.*;


public class RecommendPresenter implements RecommendationOutputBoundary {
    private final RecommendViewModel recommendViewModel;
    private final MenuViewModel menuViewModel;

    final ViewManagerModel viewManagerModel;

    public RecommendPresenter(RecommendViewModel recommendViewModel, ViewManagerModel viewManagerModel,
                              MenuViewModel menuViewModel){
        this.viewManagerModel = viewManagerModel;
        this.recommendViewModel =recommendViewModel;
        this.menuViewModel = menuViewModel;

    }


    @Override
    public void prepareSuccessView(RecommendationOutputData recommendation) {
        JOptionPane.showMessageDialog(recommendation.panel, recommendation.getBet_recommendation());

    }

    @Override
    public void prepareFailView(RecommendationOutputData recommendation) {
        JOptionPane.showMessageDialog(recommendation.panel,"Invalid Player" );

    }

    @Override
    public void backToMain() {
        this.viewManagerModel.setActiveView(menuViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }
}
