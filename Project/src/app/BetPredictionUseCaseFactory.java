package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.bet_prediction.BetPredictionViewModel;
import interface_adapter.bet_prediction.BetPredictionPresenter;
import interface_adapter.bet_prediction.BetPredictionController;

import interface_adapter.menu.MenuViewModel;
import use_case.bet_predictor.BetInputBoundary;
import use_case.bet_predictor.BetInteractor;
import use_case.bet_predictor.BetOutputBoundary;

import use_case.bet_predictor.BetTeamDataAccessInterface;
import view.BetPredictionView;

import javax.swing.*;
import java.io.IOException;

public class BetPredictionUseCaseFactory {
        /** Prevent instantiation. */
        private BetPredictionUseCaseFactory() {}

        public static BetPredictionView create(
                ViewManagerModel viewManagerModel,
                BetPredictionViewModel betPredictionViewModel,
                BetTeamDataAccessInterface dataAccessInterface,
                MenuViewModel menuViewModel){

            try {
                BetPredictionController betPredictionController = createBetPredictionUseCase(viewManagerModel,
                        betPredictionViewModel, dataAccessInterface, menuViewModel);
                return new BetPredictionView(betPredictionViewModel, betPredictionController);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Could not open user data file.");
            }

            return null;
        }

        private static BetPredictionController createBetPredictionUseCase(
                ViewManagerModel viewManagerModel,
                BetPredictionViewModel betPredictionViewModel, BetTeamDataAccessInterface dataAccessInterface, MenuViewModel menuViewModel) throws IOException {

            BetOutputBoundary betOutputBoundary = new BetPredictionPresenter(viewManagerModel,
                    betPredictionViewModel, menuViewModel);

            BetInputBoundary betInteractor = new BetInteractor(dataAccessInterface, betOutputBoundary);

            return new BetPredictionController(betInteractor);
        }

}
