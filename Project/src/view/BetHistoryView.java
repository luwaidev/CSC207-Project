package view;

import interface_adapter.bet_history.BetHistoryController;
import interface_adapter.bet_history.BetHistoryState;
import interface_adapter.bet_history.BetHistoryViewModel;
import interface_adapter.bet_prediction.BetPredictionState;
import interface_adapter.bet_prediction.BetPredictionViewModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class BetHistoryView extends JPanel{


    public final String viewName = "bet history";
    private final BetHistoryViewModel betHistoryViewModel;
    private final BetHistoryController betHistoryController;


    public BetHistoryView(BetHistoryViewModel betHistoryViewModel, BetHistoryController betHistoryController) {

        this.betHistoryViewModel = betHistoryViewModel;
        this.betHistoryController = betHistoryController;

        JLabel title = new JLabel((betHistoryViewModel.TITLE_LABEL));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        BetHistoryState current = betHistoryViewModel.getState();


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
    }

}
