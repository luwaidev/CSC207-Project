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

        // Style
        JPanel panel = this;
        panel.setBackground(Color.decode("#1e1e1e"));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);

        JLabel title = new JLabel(playerViewModel.TITLE_LABEL, SwingConstants.CENTER);
        title.setFont(new Font("Futura", Font.BOLD, 64));
        title.setForeground(Color.decode("#A3B7FF"));
        title.setBounds(0, 0, 1024, 100);
        title.setBackground(Color.decode("#181818"));

        titlePanel.setBackground(Color.decode("#181818"));
        titlePanel.setBounds(0, 0, 1024, 100);
        titlePanel.add(title);

        // Subtitle Section
        JLabel subtitle = new JLabel(playerViewModel.SUBTITLE_LABEL, SwingConstants.LEFT);
        subtitle.setFont(new Font("Futura", Font.BOLD, 48));
        subtitle.setBackground(Color.decode("#1e1e1e"));
        subtitle.setForeground(Color.white);
        subtitle.setBounds(44, 100, 900, 100);
        JPanel subtitleUnderline = new JPanel();;
        subtitleUnderline.setBackground(Color.white);
        subtitleUnderline.setBounds(44, 205, 340, 2);

        // Username Section
        username = new JLabel("USERNAME");
        username.setFont(new Font("Futura", Font.BOLD, 24));
        username.setForeground(Color.decode("#FFFFFF"));
        username.setBackground(Color.decode("#1e1e1e"));
        username.setBounds(500, 100, 900, 100);

        username = new JLabel("USERNAME");


        // Username Section
        username = new JLabel("USERNAME");
        username.setFont(new Font("Futura", Font.BOLD, 24));
        username.setForeground(Color.decode("#FFFFFF"));
        username.setBackground(Color.decode("#1e1e1e"));
        username.setBounds(650, 100, 900, 100);

        // First Team Input
        JLabel inputALabel = new JLabel(playerViewModel.INPUT_A_LABEL, SwingConstants.LEFT);
        LabelTextPanel inputA = new LabelTextPanel(
                inputALabel, inputFieldA);
        inputALabel.setFont(new Font("Futura", Font.BOLD, 30));
        inputALabel.setForeground(Color.white);
        inputA.setBackground(Color.decode("#1e1e1e"));
        inputA.setBounds(-240, 250, 900, 50);

        // Second Team Input
        JLabel inputBLabel = new JLabel(playerViewModel.INPUT_B_LABEL, SwingConstants.LEFT);
        LabelTextPanel inputB = new LabelTextPanel(
                inputBLabel, inputFieldB);
        inputBLabel.setFont(new Font("Futura", Font.BOLD, 30));
        inputBLabel.setForeground(Color.white);
        inputB.setBackground(Color.decode("#1e1e1e"));
        inputB.setBounds(-240, 300, 900, 50);

        // Divider Line
        JPanel line = new JPanel();
        line.setBackground(Color.white);
        line.setBounds(44, 600, 938, 2);

        // Button Section
        predict = new JButton(playerViewModel.PREDICT_BUTTON_LABEL);
        predict.setFont(new Font("Futura", Font.BOLD, 20));
        predict.setBackground(Color.decode("#FFFFFF"));
        predict.setBounds(44, 625, 200, 50);


        back = new JButton(playerViewModel.BACK_BUTTON_LABEL);
        back.setFont(new Font("Futura", Font.BOLD, 20));
        back.setBackground(Color.decode("#FFFFFF"));
        back.setBounds(784, 625, 200, 50);

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

        this.setLayout(null);
        this.add(titlePanel);
        this.add(subtitle);
        this.add(subtitleUnderline);
        this.add(username);
        this.add(inputA);
        this.add(inputB);
        this.add(line);
        this.add(predict);
        this.add(back);
    }


    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        PlayerState state = (PlayerState) evt.getNewValue();

        playerViewModel.setState(state);
        username.setText("Logged In As: "+ state.getUsername());
        playerController.setUsername(state.getUsername());

    }
}
