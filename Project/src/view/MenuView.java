package view;

import com.sun.tools.jconsole.JConsoleContext;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "menu";
    private final MenuViewModel menuViewModel;
    private final MenuController menuController;
    JLabel username;
    final JButton betPrediction;
    final JButton logOut;
    final JButton betHistory;
    final JButton betRecommendation;
    final JButton player;
    public MenuView(MenuViewModel menuViewModel, MenuController menuController) {
        this.menuViewModel = menuViewModel;
        this.menuController = menuController;
        this.menuViewModel.addPropertyChangeListener(this);

        // Style
        JPanel panel = this;
        panel.setBackground(Color.decode("#1e1e1e"));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);

        JLabel title = new JLabel(menuViewModel.TITLE_LABEL, SwingConstants.CENTER);
        title.setFont(new Font("Futura", Font.BOLD, 64));
        title.setForeground(Color.decode("#A3B7FF"));
        title.setBounds(0, 0, 1024, 100);
        title.setBackground(Color.decode("#181818"));

        titlePanel.setBackground(Color.decode("#181818"));
        titlePanel.setBounds(0, 0, 1024, 100);
        titlePanel.add(title);

        username = new JLabel(menuViewModel.USER_WELCOME_LABEL, SwingConstants.LEFT);
        username.setFont(new Font("Futura", Font.BOLD, 48));
        username.setForeground(Color.decode("#FFFFFF"));
        username.setBackground(Color.decode("#1e1e1e"));
        username.setBounds(50, 90, 900, 100);

        JLabel subtitle = new JLabel(menuViewModel.USER_WELCOME_SUBLABEL, SwingConstants.LEFT);
        subtitle.setFont(new Font("Futura", Font.BOLD, 34));
        subtitle.setForeground(Color.decode("#FFFFFF"));
        subtitle.setBackground(Color.decode("#1e1e1e"));
        subtitle.setBounds(50, 150, 900, 100);

        JPanel line = new JPanel();
        line.setBackground(Color.decode("#FFFFFF"));
        line.setBounds(50, 240, 900, 2);

        // Button Section

//        Bet Prediction
        JPanel betPredictionPanel = new JPanel();
        betPredictionPanel.setLayout(null);
        betPredictionPanel.setBackground(Color.decode("#181818"));
        betPredictionPanel.setBounds(50, 275, 275, 200);
        betPrediction = new JButton(menuViewModel.BET_PREDICTION_BUTTON);
        betPrediction.setBounds(10, 10, 255, 40);
        betPrediction.setFont(new Font("Futura", Font.BOLD, 28));
        betPrediction.setBackground(Color.decode("#ffffff"));

        JTextArea betPredictionDescription = new JTextArea(menuViewModel.BET_PREDICTION_BUTTON_DESCRIPTION);
        betPredictionDescription.setBounds(10, 60, 255, 100);
        betPredictionDescription.setFont(new Font("Futura", Font.BOLD, 18));
        betPredictionDescription.setForeground(Color.decode("#FFFFFF"));
        betPredictionDescription.setBackground(Color.decode("#181818"));
        betPredictionDescription.setLineWrap(true);
        betPredictionDescription.setWrapStyleWord(true);
        betPredictionDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

        betPredictionPanel.add(betPrediction);
        betPredictionPanel.add(betPredictionDescription);

        // Bet History
        JPanel betHistoryPanel = new JPanel();
        betHistoryPanel.setLayout(null);
        betHistoryPanel.setBackground(Color.decode("#181818"));
        betHistoryPanel.setBounds(362, 275, 275, 200);
        betHistory = new JButton(menuViewModel.BET_HISTORY_BUTTON);
        betHistory.setBounds(10, 10, 255, 40);
        betHistory.setFont(new Font("Futura", Font.BOLD, 28));
        betHistory.setBackground(Color.decode("#ffffff"));

        JTextArea betHistoryDescription = new JTextArea(menuViewModel.BET_HISTORY_BUTTON_DESCRIPTION);
        betHistoryDescription.setBounds(10, 60, 255, 100);
        betHistoryDescription.setFont(new Font("Futura", Font.BOLD, 18));
        betHistoryDescription.setForeground(Color.decode("#FFFFFF"));
        betHistoryDescription.setBackground(Color.decode("#181818"));
        betHistoryDescription.setLineWrap(true);
        betHistoryDescription.setWrapStyleWord(true);
        betHistoryDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

        betHistoryPanel.add(betHistory);
        betHistoryPanel.add(betHistoryDescription);

        // Bet recomendation
//        betRecomendationPanel.setBounds(675, 275, 275, 200);

        JPanel betRecomendationPanel = new JPanel();
        betRecomendationPanel.setLayout(null);
        betRecomendationPanel.setBackground(Color.decode("#181818"));
        betRecomendationPanel.setBounds(50, 500, 275, 200);
        betRecommendation = new JButton(menuViewModel.BET_RECOMMENDATION_BUTTON);
        betRecommendation.setBounds(10, 10, 255, 40);
        betRecommendation.setFont(new Font("Futura", Font.BOLD, 28));
        betRecommendation.setBackground(Color.decode("#ffffff"));

        JTextArea betRecomendationDescription = new JTextArea(menuViewModel.BET_RECOMMENDATION_BUTTON_DESCRIPTION);
        betRecomendationDescription.setBounds(10, 60, 255, 100);
        betRecomendationDescription.setFont(new Font("Futura", Font.BOLD, 18));
        betRecomendationDescription.setForeground(Color.decode("#FFFFFF"));
        betRecomendationDescription.setBackground(Color.decode("#181818"));
        betRecomendationDescription.setLineWrap(true);
        betRecomendationDescription.setWrapStyleWord(true);
        betRecomendationDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

        betRecomendationPanel.add(betRecommendation);
        betRecomendationPanel.add(betRecomendationDescription);

        // Player
        JPanel playerPanel = new JPanel();
        playerPanel.setLayout(null);
        playerPanel.setBackground(Color.decode("#181818"));
        playerPanel.setBounds(362, 500, 275, 200);
        player = new JButton(menuViewModel.PLAYER_BUTTON);
        player.setBounds(10, 10, 255, 40);
        player.setFont(new Font("Futura", Font.BOLD, 28));
        player.setBackground(Color.decode("#ffffff"));

        JTextArea playerDescription = new JTextArea(menuViewModel.PLAYER_BUTTON_DESCRIPTION);
        playerDescription.setBounds(10, 60, 255, 100);
        playerDescription.setFont(new Font("Futura", Font.BOLD, 18));
        playerDescription.setForeground(Color.decode("#FFFFFF"));
        playerDescription.setBackground(Color.decode("#181818"));
        playerDescription.setLineWrap(true);
        playerDescription.setWrapStyleWord(true);
        playerDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

        playerPanel.add(player);
        playerPanel.add(playerDescription);
      
        // Log out button
        logOut = new JButton(menuViewModel.LOG_OUT_BUTTON);
        logOut.setBounds(675, 650, 275, 40);
        logOut.setFont(new Font("Futura", Font.BOLD, 28));
        logOut.setBackground(Color.decode("#ffffff"));


        betRecommendation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.openBetRecommendation(menuViewModel.getState().getUsername());
            }
        });

        betPrediction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.openBetPredictor(menuViewModel.getState().getUsername());
            }
        });


        betHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.openBetHistory(menuViewModel.getState().getUsername());
            }
        });

        player.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.openPlayer(menuViewModel.getState().getUsername());
            }
        });

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.logout();
            }
        });

        this.setLayout(null);

        this.add(titlePanel);
        this.add(subtitle);
        this.add(line);
        this.add(username);
        this.add(betPredictionPanel);
        this.add(betHistoryPanel);
        this.add(betRecomendationPanel);
        this.add(playerPanel);
        this.add(logOut);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        MenuState state = (MenuState) evt.getNewValue();
        menuViewModel.setState(state);
        username.setText(menuViewModel.USER_WELCOME_LABEL + state.getUsername());
    }

}
