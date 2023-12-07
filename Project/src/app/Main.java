package app;

import data_access.FileUserDataAccessObject;
import data_access.PlayerDataAccessObject;
import data_access.TeamDataAccessObject;
import entity.CommonUserFactory;
import interface_adapter.bet_history.BetHistoryViewModel;
import interface_adapter.bet_recommendation.RecommendViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.player.PlayerViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.bet_prediction.BetPredictionViewModel;
import interface_adapter.ViewManagerModel;

import view.*;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("SportSmart");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.

        // Initialize View Models
        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();

        MenuViewModel menuViewModel = new MenuViewModel();
        BetPredictionViewModel betPredictionViewModel = new BetPredictionViewModel();
        BetHistoryViewModel betHistoryViewModel = new BetHistoryViewModel();
        RecommendViewModel recommendViewModel = new RecommendViewModel();
        PlayerViewModel playerViewModel = new PlayerViewModel();

        // Create UserDataAccess Object
        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create TeamDataAccess Object
        TeamDataAccessObject teamDataAccessObject = new TeamDataAccessObject();
        PlayerDataAccessObject playerDataAccessObject = new PlayerDataAccessObject();

        // Initialize Views
        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, menuViewModel,
                signupViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
        views.add(loggedInView, loggedInView.viewName);

        MenuView menuView = MenuUseCaseFactory.create(viewManagerModel, menuViewModel, loginViewModel,
                betPredictionViewModel, betHistoryViewModel, recommendViewModel, playerViewModel);
        views.add(menuView, menuView.viewName);

        BetPredictionView betPredictionView = BetPredictionUseCaseFactory.create(viewManagerModel,
                                                                                betPredictionViewModel, teamDataAccessObject, menuViewModel);
        views.add(betPredictionView, betPredictionView.viewName);

        BetHistoryView betHistoryView = BetHistoryUseCaseFactory.create(viewManagerModel,
                                                                        betHistoryViewModel, menuViewModel);
        views.add(betHistoryView, betHistoryView.viewName);

        BetRecommendView betRecommendView = BetRecommendationUseCaseFactory.create(viewManagerModel,
                recommendViewModel, playerDataAccessObject, menuViewModel);
        views.add(betRecommendView,betRecommendView.viewName);

        PlayerView playerView = PlayerUseCaseFactory.create(viewManagerModel, playerViewModel, menuViewModel, playerDataAccessObject);
        views.add(playerView, playerView.viewName);

    // CHANGE THIS VALUE TO CHANGE ACTIVE VIEW FOR DEV
        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        // STYLING GUIDE
        // Colors
        // #1e1e1e - Main background color
        // #181818 - Darker background color
        // #A3B7FF - Light blue Highlight

        // Set size
        application.setSize(new Dimension(1024, 768));
        application.setResizable(false);

        application.setBackground(Color.decode("#1e1e1e"));
//        application.pack();
        application.setVisible(true);

        // List fonts
//        String fonts[] =
//                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//
//        for (int i = 0; i < fonts.length; i++) {
//            System.out.println(fonts[i]);
//        }
    }
}