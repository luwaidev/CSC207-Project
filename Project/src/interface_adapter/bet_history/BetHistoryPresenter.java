package interface_adapter.bet_history;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuViewModel;
import use_case.bet_history.BetHistoryOutputBoundary;

public class BetHistoryPresenter implements BetHistoryOutputBoundary {

    private final BetHistoryViewModel betHistoryViewModel;
    final MenuViewModel menuViewModel;
    final ViewManagerModel viewManagerModel;

    public BetHistoryPresenter(BetHistoryViewModel betHistoryViewModel, ViewManagerModel viewManagerModel, MenuViewModel menuViewModel) {
        this.betHistoryViewModel = betHistoryViewModel;
        this.viewManagerModel = viewManagerModel;
        this.menuViewModel = menuViewModel;
    }

//    @Override
//    public void sendHistory(String history) {
//        betHistoryViewModel.HISTORY = history;
//    }

    @Override
    public void backToMain() {
        this.viewManagerModel.setActiveView(menuViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
