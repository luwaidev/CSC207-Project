package view;

import interface_adapter.bet_history.BetHistoryController;
import interface_adapter.bet_history.BetHistoryState;
import interface_adapter.bet_history.BetHistoryViewModel;
import interface_adapter.bet_prediction.BetPredictionState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;


public class BetHistoryView extends JPanel{


    public final String viewName = "bet history";
    private final BetHistoryViewModel betHistoryViewModel;
    private final BetHistoryController betHistoryController;
    final JButton back;
    JLabel username;
    public BetHistoryView(BetHistoryViewModel betHistoryViewModel, BetHistoryController betHistoryController) {

        this.betHistoryViewModel = betHistoryViewModel;
        this.betHistoryController = betHistoryController;

        JLabel title = new JLabel((betHistoryViewModel.TITLE_LABEL));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextArea history = new JTextArea((betHistoryViewModel.HISTORY));
        back = new JButton(betHistoryViewModel.BACK_BUTTON_LABEL);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.setAlignmentY(Component.BOTTOM_ALIGNMENT);


        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)){
                            betHistoryController.backToMain();
                            //add code to switch back to main menu;
                        }
                    }
                }
        );



        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(back);
        this.add(history);
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }


}
