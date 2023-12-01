package view;

import interface_adapter.bet_prediction.BetPredictionController;
import interface_adapter.bet_prediction.BetPredictionState;
import interface_adapter.bet_prediction.BetPredictionViewModel;
import interface_adapter.menu.MenuState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BetPredictionView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "bet prediction";
    private final BetPredictionViewModel bpViewModel;
    private final BetPredictionController betPredictionController;
    JLabel username;

    final JTextField inputFieldA = new JTextField(15);
    final JTextField inputFieldB = new JTextField(15);

    final JButton predict;

    public BetPredictionView(BetPredictionViewModel bpViewModel, BetPredictionController betPredictionController){

        this.bpViewModel = bpViewModel;
        this.betPredictionController = betPredictionController;
        this.bpViewModel.addPropertyChangeListener(this);

        // Main title
        JLabel title = new JLabel((bpViewModel.TITLE_LABEL));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        username = new JLabel("USERNAME");

        JPanel teamInputs = new JPanel();
        // First Team Input
        LabelTextPanel inputA = new LabelTextPanel(new JLabel(bpViewModel.INPUT_A_LABEL),inputFieldA);
        teamInputs.add(inputA);
        // Second Team Input
        LabelTextPanel inputB = new LabelTextPanel(new JLabel(bpViewModel.INPUT_B_LABEL),inputFieldB);
        teamInputs.add(inputB);

        // Predict Bet Button
        predict = new JButton(bpViewModel.PREDICT_BUTTON_LABEL);
        predict.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Set Input Field Key Listeners
        inputFieldA.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                BetPredictionState current = bpViewModel.getState();
                current.setInputA(inputFieldA.getText()+e.getKeyChar());
                bpViewModel.setState(current);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        inputFieldB.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                BetPredictionState current = bpViewModel.getState();
                current.setInputB(inputFieldB.getText()+e.getKeyChar());
                bpViewModel.setState(current);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        JPanel panel = this;

        predict.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(predict)) {
                            BetPredictionState current = bpViewModel.getState();

                            betPredictionController.execute(current.getInputA(), current.getInputB(), panel);

                        }
                    }

                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(username);
        this.add(teamInputs);
        this.add(predict);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        BetPredictionState state = (BetPredictionState) evt.getNewValue();

        // Might be bad to just override state completely itself
        // might want to just update username value, but this works for now
        bpViewModel.setState(state);

        // Update username display
        username.setText(state.getUsername());

        // Update username in interactor
        betPredictionController.setUsername(state.getUsername());

    }
}
