package interface_adapter.menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.bet_history.BetHistoryViewModel;
import interface_adapter.bet_prediction.BetPredictionViewModel;
import interface_adapter.login.LoginViewModel;
import use_case.menu.MenuOutputBoundary;
import view.ViewManager;

public class MenuPresenter implements MenuOutputBoundary {
    private final LoginViewModel loginViewModel;
    private final BetPredictionViewModel betPredictionViewModel;
    private final BetHistoryViewModel betHistoryViewModel;

    private ViewManagerModel viewManagerModel;
    public MenuPresenter(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, BetPredictionViewModel betPredictionViewModel, BetHistoryViewModel betHistoryViewModel){
        this.viewManagerModel = viewManagerModel;
        this.loginViewModel = loginViewModel;
        this.betPredictionViewModel = betPredictionViewModel;
        this.betHistoryViewModel = betHistoryViewModel;

    }

    @Override
    public void openBetPredictor() {
        this.viewManagerModel.setActiveView(betPredictionViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
        System.out.println(this.viewManagerModel.getActiveView());
    }

    public void openBetHistory() {
        this.viewManagerModel.setActiveView(betHistoryViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
        System.out.println(this.viewManagerModel.getActiveView());
    }
}
