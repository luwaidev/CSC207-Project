package view;

import com.sun.tools.jconsole.JConsoleContext;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuState;
import interface_adapter.menu.MenuViewModel;

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
    public MenuView(MenuViewModel menuViewModel, MenuController menuController) {
        this.menuViewModel = menuViewModel;
        this.menuController = menuController;
        this.menuViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(menuViewModel.TITLE_LABEL);

        username = new JLabel("USERNAME");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();

        betPrediction = new JButton(menuViewModel.BET_PREDICTION_BUTTON);
        buttons.add(betPrediction);

        betHistory = new JButton(menuViewModel.BET_HISTORY_BUTTON);
        buttons.add(betHistory);

        logOut = new JButton(menuViewModel.LOG_OUT_BUTTON);
        buttons.add(logOut);

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

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuController.logout();
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(username);
        this.add(buttons);
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
        username.setText(state.getUsername());
    }

}
