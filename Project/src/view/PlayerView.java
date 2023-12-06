package view;

import interface_adapter.player.PlayerController;
import interface_adapter.player.PlayerState;
import interface_adapter.player.PlayerViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PlayerView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "player";
    private final PlayerViewModel playerViewModel;
    private final PlayerController playerController;
    JLabel username;

    final JTextField inputFieldA = new JTextField(15);
    final JTextField inputFieldB = new JTextField(15);

    final JButton predict;

    final JButton back;

    public PlayerView(PlayerViewModel playerViewModel,
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
                PlayerState current = playerViewModel.getState();
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
                PlayerState current = playerViewModel.getState();
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
                            PlayerState current = playerViewModel.getState();
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
        PlayerState state = (PlayerState) evt.getNewValue();

        playerViewModel.setState(state);
        username.setText(state.getUsername());
        playerController.setUsername(state.getUsername());

    }
}
