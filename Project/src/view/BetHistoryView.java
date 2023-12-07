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


        // Style
        JPanel panel = this;
        panel.setBackground(Color.decode("#1e1e1e"));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);

        JLabel title = new JLabel(betHistoryViewModel.TITLE_LABEL, SwingConstants.CENTER);
        title.setFont(new Font("Futura", Font.BOLD, 64));
        title.setForeground(Color.decode("#A3B7FF"));
        title.setBounds(0, 0, 1024, 100);
        title.setBackground(Color.decode("#181818"));

        titlePanel.setBackground(Color.decode("#181818"));
        titlePanel.setBounds(0, 0, 1024, 100);
        titlePanel.add(title);

        // Subtitle Section
        JLabel subtitle = new JLabel(betHistoryViewModel.SUBTITLE_LABEL, SwingConstants.LEFT);
        subtitle.setFont(new Font("Futura", Font.BOLD, 48));
        subtitle.setBackground(Color.decode("#1e1e1e"));
        subtitle.setForeground(Color.white);
        subtitle.setBounds(44, 100, 900, 100);
        JPanel subtitleUnderline = new JPanel();;
        subtitleUnderline.setBackground(Color.white);
        subtitleUnderline.setBounds(44, 205, 275, 2);

        // Username Section
        username = new JLabel("USERNAME");
        username.setFont(new Font("Futura", Font.BOLD, 24));
        username.setForeground(Color.decode("#FFFFFF"));
        username.setBackground(Color.decode("#1e1e1e"));
        username.setBounds(600, 100, 900, 100);


        // Divider Line
        JPanel line = new JPanel();
        line.setBackground(Color.white);
        line.setBounds(44, 600, 938, 2);

        // Back Button
        back = new JButton(betHistoryViewModel.BACK_BUTTON_LABEL);
        back.setFont(new Font("Futura", Font.BOLD, 20));
        back.setBackground(Color.decode("#FFFFFF"));
        back.setBounds(44, 625, 200, 50);

        history = new JTextArea("HISTORY");
        history.setFont(new Font("Futura", Font.BOLD, 24));
        history.setForeground(Color.white);
        history.setBackground(Color.decode("#1e1e1e"));
        history.setBounds(44, 250, 936, 300);
        history.setLineWrap(true);
        history.setWrapStyleWord(true);
        history.setAlignmentX(Component.LEFT_ALIGNMENT);


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

        this.setLayout(null);

        this.add(username);
        this.add(titlePanel);
        this.add(subtitle);
        this.add(subtitleUnderline);
        this.add(line);
        this.add(back);
        this.add(history);
    }
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        BetHistoryState state = (BetHistoryState) evt.getNewValue();

        // Update username display
        username.setText("Logged In As: " +state.getUsername());
        // Update username in interactor
        betHistoryController.setUsername(state.getUsername());
//            betHistoryController.setHistory(state.getHistory());



        history.setText(betHistoryController.getHistory(state.getUsername()));
    }

}
