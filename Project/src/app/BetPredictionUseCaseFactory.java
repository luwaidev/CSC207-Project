package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.bet_prediction.BetPredictionViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuPresenter;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.bet_prediction.BetPredictionPresenter;
import interface_adapter.bet_prediction.BetPredictionController;

import use_case.bet_predictor.BetInputBoundary;
import use_case.bet_predictor.BetInteractor;
import use_case.bet_predictor.BetOutputBoundary;

import use_case.bet_predictor.BetTeamDataAccessInterface;
import use_case.menu.MenuInteractor;
import view.BetPredictionView;
import view.MenuView;

import javax.swing.*;
import java.io.IOException;

public class BetPredictionUseCaseFactory {
        /** Prevent instantiation. */
        private BetPredictionUseCaseFactory() {}

        public static BetPredictionView create(
                ViewManagerModel viewManagerModel,
                BetPredictionViewModel betPredictionViewModel, BetTeamDataAccessInterface dataAccessInterface){

            try {
                BetPredictionController betPredictionController = createBetPredictionUseCase(viewManagerModel,
                        betPredictionViewModel, dataAccessInterface);
                return new BetPredictionView(betPredictionViewModel, betPredictionController);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Could not open user data file.");
            }

            return null;
        }

        private static BetPredictionController createBetPredictionUseCase(
                ViewManagerModel viewManagerModel,
                BetPredictionViewModel betPredictionViewModel, BetTeamDataAccessInterface dataAccessInterface) throws IOException {

            BetOutputBoundary betOutputBoundary = new BetPredictionPresenter(viewManagerModel,
                    betPredictionViewModel);

            BetInputBoundary betInteractor = new BetInteractor(dataAccessInterface, betOutputBoundary);

            return new BetPredictionController(betInteractor);
        }

}
