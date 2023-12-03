package view;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    final JButton logIn;
    final JButton createAccount;
    final JButton skipLogin;
    private final LoginController loginController;

    public LoginView(LoginViewModel loginViewModel, LoginController controller) {

        this.loginController = controller;
        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        // Style
        JPanel panel = this;
        panel.setBackground(Color.decode("#1e1e1e"));

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);

        JLabel title = new JLabel(loginViewModel.TITLE_LABEL, SwingConstants.LEFT);
        title.setFont(new Font("Futura", Font.BOLD, 94));
        title.setForeground(Color.decode("#A3B7FF"));
        title.setBounds(50, 40, 900, 100);

        titlePanel.setBackground(Color.decode("#181818"));
        titlePanel.setBounds(0, 0, 1024, 180);
        titlePanel.add(title);

        JLabel subtitle = new JLabel(loginViewModel.SUBTITLE_LABEL, SwingConstants.LEFT);
        subtitle.setFont(new Font("Futura", Font.BOLD, 48));
        subtitle.setBackground(Color.decode("#1e1e1e"));
        subtitle.setForeground(Color.white);
        subtitle.setBounds(50, 200, 900, 100);
        JPanel subtitleUnderline = new JPanel();;
        subtitleUnderline.setBackground(Color.white);
        subtitleUnderline.setBounds(50, 305, 175, 2);


        JLabel usernameLabel = new JLabel(loginViewModel.USERNAME_LABEL, SwingConstants.LEFT);
        LabelTextPanel usernameInfo = new LabelTextPanel(
                usernameLabel, usernameInputField);
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(new Font("Futura", Font.BOLD, 30));
        usernameInfo.setBackground(Color.decode("#1e1e1e"));
        usernameInfo.setBounds(-240, 350, 900, 50);


        JLabel passwordLabel = new JLabel(loginViewModel.PASSWORD_LABEL);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                passwordLabel, passwordInputField);
        passwordLabel.setFont(new Font("Futura", Font.BOLD, 30));
        passwordLabel.setForeground(Color.white);
        passwordInfo.setBackground(Color.decode("#1e1e1e"));
        passwordInfo.setBounds(-242, 400, 900, 50);

        JPanel line = new JPanel();
        line.setBackground(Color.white);
        line.setBounds(44, 600, 938, 2);

        JPanel buttons = new JPanel();
        buttons.setBackground(Color.decode("#1e1e1e"));
        buttons.setBounds(-225, 650, 1024, 100);
        logIn = new JButton(LoginViewModel.LOGIN_BUTTON_LABEL);
        buttons.add(logIn);
        logIn.setFont(new Font("Futura", Font.BOLD, 20));
        createAccount = new JButton(LoginViewModel.CREATE_ACCOUNT_BUTTON_LABEL);
        buttons.add(createAccount);
        createAccount.setFont(new Font("Futura", Font.BOLD, 20));
        skipLogin = new JButton(LoginViewModel.SKIP_BUTTON_LABEL);
        skipLogin.setFont(new Font("Futura", Font.BOLD, 20));
        buttons.add(skipLogin);

        logIn.addActionListener(                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)) {
                            LoginState currentState = loginViewModel.getState();


                            loginController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword()
                            );
                        }
                    }
                }
        );

        skipLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginController.skipLogin();
            }
        });

        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginController.createAccount();
            }
        });

        usernameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
                loginViewModel.setState(currentState);
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
                        LoginState currentState = loginViewModel.getState();
                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
                        loginViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.setLayout(null);
        this.add(titlePanel);
        this.add(subtitle);
        this.add(subtitleUnderline);
        this.add(usernameInfo);
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(passwordErrorField);
        this.add(line);
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
        LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
    }

}