package view;

import interface_adapter.clear_users.ClearController;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearInteractor;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final SignupController signupController;
    private final ClearController clearController;

    private final JButton signUp;
    private final JButton login;

    // TODO Note: this is the new JButton for clearing the users file
    private final JButton clear;

    public SignupView(SignupController controller, SignupViewModel signupViewModel, ClearController clearController) {

        this.signupController = controller;
        this.clearController = clearController;
        this.signupViewModel = signupViewModel;
        signupViewModel.addPropertyChangeListener(this);

        // Style
        JPanel panel = this;
        panel.setBackground(Color.decode("#1e1e1e"));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);

        JLabel title = new JLabel(SignupViewModel.TITLE_LABEL, SwingConstants.LEFT);
        title.setFont(new Font("Futura", Font.BOLD, 94));
        title.setForeground(Color.decode("#A3B7FF"));
        title.setBounds(50, 40, 900, 100);

        titlePanel.setBackground(Color.decode("#181818"));
        titlePanel.setBounds(0, 0, 1024, 180);
        titlePanel.add(title);

        JLabel subtitle = new JLabel(SignupViewModel.SUBTITLE_LABEL, SwingConstants.LEFT);
        subtitle.setFont(new Font("Futura", Font.BOLD, 48));
        subtitle.setBackground(Color.decode("#1e1e1e"));
        subtitle.setForeground(Color.white);
        subtitle.setBounds(50, 200, 900, 100);
        JPanel subtitleUnderline = new JPanel();;
        subtitleUnderline.setBackground(Color.white);
        subtitleUnderline.setBounds(50, 305, 175, 2);

        JLabel usernameLabel = new JLabel(SignupViewModel.USERNAME_LABEL, SwingConstants.LEFT);
        LabelTextPanel usernameInfo = new LabelTextPanel(
                usernameLabel, usernameInputField);
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(new Font("Futura", Font.BOLD, 30));
        usernameInfo.setBackground(Color.decode("#1e1e1e"));
        usernameInfo.setBounds(-240, 350, 900, 50);

        JLabel passwordLabel = new JLabel(SignupViewModel.PASSWORD_LABEL);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                passwordLabel, passwordInputField);
        passwordLabel.setFont(new Font("Futura", Font.BOLD, 30));
        passwordLabel.setForeground(Color.white);
        passwordInfo.setBackground(Color.decode("#1e1e1e"));
        passwordInfo.setBounds(-242, 400, 900, 50);

        JLabel repeatPasswordLabel = new JLabel(SignupViewModel.REPEAT_PASSWORD_LABEL);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                repeatPasswordLabel, repeatPasswordInputField);
        repeatPasswordLabel.setFont(new Font("Futura", Font.BOLD, 30));
        repeatPasswordLabel.setForeground(Color.white);
        repeatPasswordInfo.setBackground(Color.decode("#1e1e1e"));
        repeatPasswordInfo.setBounds(-188, 450, 900, 100);

        JPanel line = new JPanel();
        line.setBackground(Color.white);
        line.setBounds(44, 600, 938, 2);

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.decode("#1e1e1e"));
        buttons.setBounds(-278, 650, 1024, 100);
        signUp = new JButton(SignupViewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
        signUp.setFont(new Font("Futura", Font.BOLD, 20));
        login = new JButton(SignupViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(login);
        login.setFont(new Font("Futura", Font.BOLD, 20));

        // TODO Note: the following line instantiates the "clear" button; it uses
        //      a CLEAR_BUTTON_LABEL constant which is defined in the SignupViewModel class.
        //      You need to add this "clear" button to the "buttons" panel.
        // DONE
        clear = new JButton(SignupViewModel.CLEAR_BUTTON_LABEL);
//        buttons.add(clear);

        signUp.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUp)) {
                            SignupState currentState = signupViewModel.getState();

                            signupController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword()
                            );
                        }
                    }
                }
        );


        // TODO Add the body to the actionPerformed method of the action listener below
        //      for the "clear" button. You'll need to write the controller before
        //      you can complete this.
        clear.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clearController.execute(panel);
                    }

                }
        );

        login.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        signupController.execute();
                    }
                }
        );

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        usernameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        String text = usernameInputField.getText() + e.getKeyChar();
                        currentState.setUsername(text);
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        passwordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

        repeatPasswordInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        SignupState currentState = signupViewModel.getState();
                        currentState.setRepeatPassword(repeatPasswordInputField.getText() + e.getKeyChar());
                        signupViewModel.setState(currentState); // Hmm, is this necessary?
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                }
        );

//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setLayout(null);
        this.add(titlePanel);
        this.add(subtitle);
        this.add(subtitleUnderline);
        this.add(usernameInfo);
        this.add(passwordInfo);
        this.add(repeatPasswordInfo);
        this.add(line);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }

}