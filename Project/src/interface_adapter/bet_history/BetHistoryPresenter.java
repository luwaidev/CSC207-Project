package interface_adapter.bet_history;

import interface_adapter.ViewManagerModel;
import interface_adapter.bet_prediction.BetPredictionViewModel;
import use_case.bet_history.BetHistoryOutputBoundary;

public class BetHistoryPresenter implements BetHistoryOutputBoundary {
    private final BetHistoryViewModel betHistoryViewModel;

    final ViewManagerModel viewManagerModel;

    public BetHistoryPresenter(ViewManagerModel viewManagerModel,
                               BetHistoryViewModel betHistoryViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.betHistoryViewModel = betHistoryViewModel;
    }
}
