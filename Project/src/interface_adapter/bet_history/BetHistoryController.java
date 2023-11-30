package interface_adapter.bet_history;

import use_case.bet_history.BetHistoryInputBoundary;
import use_case.bet_history.BetHistoryInteractor;

public class BetHistoryController {
    final BetHistoryInputBoundary betHistoryInteractor;
    public BetHistoryController(BetHistoryInputBoundary betHistoryInteractor) {
        this.betHistoryInteractor = betHistoryInteractor;
    }
}
