package interface_adapter.menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.bet_history.BetHistoryState;
import interface_adapter.bet_history.BetHistoryViewModel;
import interface_adapter.bet_prediction.BetPredictionState;
import interface_adapter.bet_prediction.BetPredictionViewModel;
import interface_adapter.bet_recommendation.RecommendViewModel;
import interface_adapter.login.LoginViewModel;
import use_case.menu.MenuOutputBoundary;
import use_case.menu.MenuOutputData;
import view.BetRecommendView;
import view.ViewManager;


public class MenuPresenter implements MenuOutputBoundary {
    private final LoginViewModel loginViewModel;
    private final BetPredictionViewModel betPredictionViewModel;
    private final BetHistoryViewModel betHistoryViewModel;
    private final RecommendViewModel recommendViewModel;

    private ViewManagerModel viewManagerModel;
    public MenuPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, BetPredictionViewModel betPredictionViewModel, BetHistoryViewModel betHistoryViewModel, RecommendViewModel recommendViewModel){
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.betPredictionViewModel = betPredictionViewModel;
        this.betHistoryViewModel = betHistoryViewModel;
        this.recommendViewModel = recommendViewModel;

    }

    @Override
    public void openBetPredictor(MenuOutputData menuOutputData) {
        // Update bet predictor with username
        BetPredictionState betPredictionState = betPredictionViewModel.getState();
        betPredictionState.setUsername(menuOutputData.getUsername());
        betPredictionViewModel.setState(betPredictionState);
        betPredictionViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(betPredictionViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
//        System.out.println(this.viewManagerModel.getActiveView());
    }

    @Override
    public void openBetHistory(MenuOutputData menuOutputData) {
        BetHistoryState betHistoryState = betHistoryViewModel.getState();
        betHistoryState.setUsername(menuOutputData.getUsername());
        this.betHistoryViewModel.setState(betHistoryState);
        this.betHistoryViewModel.firePropertyChanged();
        betHistoryViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(betHistoryViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void logout(){
        this.viewManagerModel.setActiveView(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }
    @Override
    public void openBetRecommendation(){
        this.viewManagerModel.setActiveView(recommendViewModel.getViewName());

        this.viewManagerModel.firePropertyChanged();
        System.out.println(this.viewManagerModel.getActiveView());
    }

}