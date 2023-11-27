package view;

import interface_adapter.bet_prediction.BetController;
import interface_adapter.bet_prediction.BetPredictionState;
import interface_adapter.bet_prediction.BetPredictionViewModel;
import interface_adapter.bet_recommendation.RecommendState;
import interface_adapter.bet_recommendation.RecommendViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BetPredictionView extends JPanel {
    public final String viewName = "bet prediction";
    private final BetPredictionViewModel bpViewModel;

    final JTextField inputFieldA = new JTextField(15);
    final JTextField inputFieldB = new JTextField(15);

    final JButton predict;

    public BetPredictionView(BetPredictionViewModel bpViewModel){
        this.bpViewModel = bpViewModel;

        // Main title
        JLabel title = new JLabel((bpViewModel.TITLE_LABEL));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

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
        predict.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(predict)) {
                            BetPredictionState current = BetPredictionViewModel.getState();

                            BetController.execute(current.getInputA(), current.getInputB());
                        }
                    }

                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(teamInputs);
        this.add(predict);
    }
}
