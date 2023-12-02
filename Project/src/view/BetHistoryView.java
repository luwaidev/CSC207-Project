package view;

import entity.BetHistory;
import interface_adapter.bet_history.BetHistoryController;
import interface_adapter.bet_history.BetHistoryState;
import interface_adapter.bet_history.BetHistoryViewModel;
import interface_adapter.bet_prediction.BetPredictionState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class BetHistoryView extends JPanel implements ActionListener, PropertyChangeListener {


    public final String viewName = "bet history";
    private final BetHistoryViewModel betHistoryViewModel;
    private final BetHistoryController betHistoryController;
    final JButton back;
    JLabel username;
    JTextArea history;
    public BetHistoryView(BetHistoryViewModel betHistoryViewModel, BetHistoryController betHistoryController) {

        this.betHistoryViewModel = betHistoryViewModel;
        this.betHistoryController = betHistoryController;
        this.betHistoryViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel((betHistoryViewModel.TITLE_LABEL));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
//        JTextArea history = new JTextArea((betHistoryViewModel.HISTORY));
        back = new JButton(betHistoryViewModel.BACK_BUTTON_LABEL);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        username = new JLabel("USERNAME");
        history = new JTextArea("HISTORY");


        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)){
                            betHistoryController.backToMain();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(username);
        this.add(title);
        this.add(back);
        this.add(history);
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        BetHistoryState state = (BetHistoryState) evt.getNewValue();

        // Might be bad to just override state completely itself
        // might want to just update username value, but this works for now
        betHistoryViewModel.setState(state);

        history.setText(state.getHistory());

        // Update username display
        username.setText(state.getUsername());

        // Update username in interactor
        betHistoryController.setUsername(state.getUsername());

        betHistoryController.setHistory(String.valueOf(username));

    }

}
