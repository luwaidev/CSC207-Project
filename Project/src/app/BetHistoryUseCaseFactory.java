package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.bet_history.BetHistoryController;
import interface_adapter.bet_history.BetHistoryPresenter;
import interface_adapter.bet_history.BetHistoryViewModel;
import interface_adapter.menu.MenuViewModel;
import use_case.bet_history.BetHistoryInputBoundary;
import use_case.bet_history.BetHistoryInteractor;
import use_case.bet_history.BetHistoryOutputBoundary;
import view.BetHistoryView;

import javax.swing.*;
import java.io.IOException;

public class BetHistoryUseCaseFactory {
    /** Prevent instantiation. */
    private BetHistoryUseCaseFactory() {}

    public static BetHistoryView create(
            ViewManagerModel viewManagerModel,
            BetHistoryViewModel betHistoryViewModel, MenuViewModel menuViewModel){

        try {
            BetHistoryController betHistoryController = createBetHistoryUseCase(viewManagerModel, betHistoryViewModel, menuViewModel);
            return new BetHistoryView(betHistoryViewModel, betHistoryController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static BetHistoryController createBetHistoryUseCase(
            ViewManagerModel viewManagerModel,
            BetHistoryViewModel betHistoryViewModel, MenuViewModel menuViewModel) throws IOException {

        BetHistoryOutputBoundary betHistoryOutputBoundary = new BetHistoryPresenter(betHistoryViewModel, viewManagerModel,
                menuViewModel);

        BetHistoryInputBoundary betHistoryInteractor = new BetHistoryInteractor(betHistoryOutputBoundary);

        return new BetHistoryController(betHistoryInteractor);
    }
}
