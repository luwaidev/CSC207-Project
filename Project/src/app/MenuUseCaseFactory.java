package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.bet_history.BetHistoryViewModel;
import interface_adapter.bet_prediction.BetPredictionViewModel;
import interface_adapter.bet_recommendation.RecommendViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuPresenter;
import interface_adapter.menu.MenuViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginUserDataAccessInterface;
import use_case.menu.MenuInputBoundary;
import use_case.menu.MenuInteractor;
import use_case.menu.MenuOutputBoundary;
import view.LoginView;
import view.MenuView;

import javax.swing.*;
import java.io.IOException;

public class MenuUseCaseFactory {
    /** Prevent instantiation. */
    private MenuUseCaseFactory() {}

    public static MenuView create(
            ViewManagerModel viewManagerModel,
            MenuViewModel menuViewModel, LoginViewModel loginViewModel,
            BetPredictionViewModel betPredictionViewModel, BetHistoryViewModel betHistoryViewModel, RecommendViewModel recommendViewModel){

        try {
            MenuController menuController = createMenuUseCase(viewManagerModel, menuViewModel,loginViewModel, betPredictionViewModel, betHistoryViewModel, recommendViewModel);
            return new MenuView(menuViewModel, menuController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static MenuController createMenuUseCase(
            ViewManagerModel viewManagerModel,
            MenuViewModel menuViewModel, LoginViewModel loginViewModel,
            BetPredictionViewModel betPredictionViewModel,BetHistoryViewModel betHistoryViewModel, RecommendViewModel recommendViewModel) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        MenuOutputBoundary menuOutputBoundary = new MenuPresenter(viewManagerModel, loginViewModel, betPredictionViewModel, betHistoryViewModel,recommendViewModel);

        MenuInputBoundary menuInteractor = new MenuInteractor(menuOutputBoundary);

        return new MenuController(menuInteractor);
    }
}
