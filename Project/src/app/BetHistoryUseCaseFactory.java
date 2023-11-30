package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.bet_history.BetHistoryController;
import interface_adapter.bet_history.BetHistoryPresenter;
import interface_adapter.bet_history.BetHistoryViewModel;
import interface_adapter.bet_prediction.BetPredictionController;
import interface_adapter.bet_prediction.BetPredictionPresenter;
import interface_adapter.bet_prediction.BetPredictionViewModel;
import use_case.bet_history.BetHistoryInputBoundary;
import use_case.bet_history.BetHistoryInteractor;
import use_case.bet_history.BetHistoryOutputBoundary;
import use_case.bet_predictor.BetInputBoundary;
import use_case.bet_predictor.BetInteractor;
import use_case.bet_predictor.BetOutputBoundary;
import use_case.bet_predictor.BetTeamDataAccessInterface;
import view.BetHistoryView;
import view.BetPredictionView;

import javax.swing.*;
import java.io.IOException;

public class BetHistoryUseCaseFactory {
    /** Prevent instantiation. */
    private BetHistoryUseCaseFactory() {}

    public static BetHistoryView create(
            ViewManagerModel viewManagerModel,
            BetHistoryViewModel betHistoryViewModel){

        try {
            BetHistoryController betHistoryController = createBetHistoryUseCase(viewManagerModel, betHistoryViewModel);
            return new BetHistoryView(betHistoryViewModel, betHistoryController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static BetHistoryController createBetHistoryUseCase(
            ViewManagerModel viewManagerModel,
            BetHistoryViewModel betHistoryViewModel) throws IOException {

        BetHistoryOutputBoundary betHistoryOutputBoundary = new BetHistoryPresenter(viewManagerModel,
                betHistoryViewModel);

        BetHistoryInputBoundary betHistoryInteractor = new BetHistoryInteractor(betHistoryOutputBoundary);

        return new BetHistoryController(betHistoryInteractor);
    }
}
