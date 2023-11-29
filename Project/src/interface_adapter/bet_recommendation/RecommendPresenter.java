package interface_adapter.bet_recommendation;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import use_case.bet_recommendation.RecommendationOutputBoundary;
import use_case.bet_recommendation.RecommendationOutputData;

import javax.swing.*;


public class RecommendPresenter implements RecommendationOutputBoundary {
    private final MenuViewModel menuViewModel;
    private ViewManagerModel viewManagerModel;

    public RecommendPresenter(MenuViewModel menuViewModel,ViewManagerModel viewManagerModel) {
        this.menuViewModel = menuViewModel;
        this.viewManagerModel = viewManagerModel;

        this.viewManagerModel.setActiveView(menuViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(RecommendationOutputData recommendation) {
        JOptionPane.showMessageDialog(recommendation.panel, recommendation.getBet_recommendation());

        MenuState menuState = menuViewModel.getState();
        this.menuViewModel.setState(menuState);
        this.menuViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(menuViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(RecommendationOutputData recommendation) {
        JOptionPane.showMessageDialog(recommendation.panel,"Invalid Player" );

    }
}
