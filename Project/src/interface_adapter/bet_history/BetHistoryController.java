package interface_adapter.bet_history;
import entity.User;
import use_case.bet_history.BetHistoryInputBoundary;
import use_case.bet_history.BetHistoryInputData;

import javax.swing.*;

public class BetHistoryController {
    final BetHistoryInputBoundary betHistoryUseCaseInteractor;
    public BetHistoryController(BetHistoryInputBoundary betHistoryUseCaseInteractor){
        this.betHistoryUseCaseInteractor = betHistoryUseCaseInteractor;
    }

    public void execute(User user, JPanel panel) {

    }
}
