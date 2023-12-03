package view;

import interface_adapter.player_bets.PlayerController;
import interface_adapter.player_bets.PlayerPredictionState;
import interface_adapter.player_bets.PlayerPredictionViewModel;
import interface_adapter.menu.MenuState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "bet prediction";
    private final PlayerPredictionViewModel playerViewModel;
    private final PlayerController playerController;
    JLabel username;

    final JTextField inputFieldA = new JTextField(15);
    final JTextField inputFieldB = new JTextField(15);

    final JButton predict;

    final JButton back;

    public PlayerView(PlayerPredictionViewModel playerViewModel,
                      PlayerController playerController){
        this.playerViewModel = playerViewModel;
        this.playerController = playerController;
        this.playerViewModel.addPropertyChangeListener(this);

        // Main title
        JLabel title = new JLabel((playerViewModel.TITLE_LABEL));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        username = new JLabel("USERNAME");

        JPanel playerInputs = new JPanel();

        // player first name input
        LabelTextPanel inputA = new LabelTextPanel(new JLabel(playerViewModel.INPUT_A_LABEL), inputFieldA);
        playerInputs.add(inputA);

        // player last name input
        LabelTextPanel inputB = new LabelTextPanel(new JLabel(playerViewModel.INPUT_B_LABEL), inputFieldB);
        playerInputs.add(inputB);

        // predict points button and back button
        JPanel buttons = new JPanel();

        predict = new JButton(playerViewModel.PREDICT_BUTTON_LABEL);
        back = new JButton(playerViewModel.BACK_BUTTON_LABEL);
        buttons.add(predict);
        buttons.add(back);

        // set input field key listeners

        inputFieldA.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                PlayerPredictionState current = playerViewModel.getState();
                current.setInputA(inputFieldA.getText()+e.getKeyChar());
                playerViewModel.setState(current);
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
                PlayerPredictionState current = playerViewModel.getState();
                current.setInputB(inputFieldB.getText()+e.getKeyChar());
                playerViewModel.setState(current);
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
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(predict)){
                            PlayerPredictionState current = playerViewModel.getState();
                            playerController.execute(current.getInputA(), current.getInputB(), panel);

                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)){
                            playerController.backToMain();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(username);
        this.add(playerInputs);
        this.add(buttons);


    }


    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PlayerPredictionState state = (PlayerPredictionState) evt.getNewValue();

        playerViewModel.setState(state);
        username.setText(state.getUsername());
        playerController.setUsername(state.getUsername());

    }
}
