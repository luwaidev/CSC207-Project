package view;

import interface_adapter.bet_recommendation.RecommendController;
import interface_adapter.bet_recommendation.RecommendState;
import interface_adapter.bet_recommendation.RecommendViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BetRecommendView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "bet recommendation";
    private final RecommendViewModel recommendViewModel;
    private final RecommendController recommendController;

    final JTextField playerinput = new JTextField(15);


    private final JLabel playerError = new JLabel();
    final JButton recommend;

    JLabel username;

    public BetRecommendView(RecommendViewModel recommendViewModel, RecommendController recommendController){
        this.recommendViewModel = recommendViewModel;
        this.recommendController = recommendController;
        this.recommendViewModel.addPropertyChangeListener(this);


        // Style
        JPanel panel = this;
        panel.setBackground(Color.decode("#1e1e1e"));

        // Title Panel
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(null);

        JLabel title = new JLabel(recommendViewModel.TITLE_LABEL, SwingConstants.CENTER);
        title.setFont(new Font("Futura", Font.BOLD, 64));
        title.setForeground(Color.decode("#A3B7FF"));
        title.setBounds(0, 0, 1024, 100);
        title.setBackground(Color.decode("#181818"));

        titlePanel.setBackground(Color.decode("#181818"));
        titlePanel.setBounds(0, 0, 1024, 100);
        titlePanel.add(title);

        // Subtitle Section
        JLabel subtitle = new JLabel(recommendViewModel.SUBTITLE_LABEL, SwingConstants.LEFT);
        subtitle.setFont(new Font("Futura", Font.BOLD, 48));
        subtitle.setBackground(Color.decode("#1e1e1e"));
        subtitle.setForeground(Color.white);
        subtitle.setBounds(44, 100, 900, 100);
        JPanel subtitleUnderline = new JPanel();;
        subtitleUnderline.setBackground(Color.white);
        subtitleUnderline.setBounds(44, 205, 400, 2);

        // Username Section
        username = new JLabel("USERNAME");
        username.setFont(new Font("Futura", Font.BOLD, 24));
        username.setForeground(Color.decode("#FFFFFF"));
        username.setBackground(Color.decode("#1e1e1e"));
        username.setBounds(500, 100, 900, 100);

        JPanel buttons = new JPanel();
        LabelTextPanel inputPlayer = new LabelTextPanel(new JLabel(recommendViewModel.INPUT_A_LABEL),playerinput);

        buttons.add(inputPlayer);


        recommend = new JButton(recommendViewModel.RECOMMEND_BUTTON_LABEL);
        recommend.setAlignmentX(Component.CENTER_ALIGNMENT);

        playerinput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                RecommendState current = RecommendViewModel.getState();
                current.setInputA(playerinput.getText()+e.getKeyChar());
                recommendViewModel.setState(current);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        recommend.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(recommend)) {
                            RecommendState current = RecommendViewModel.getState();

                            recommendController.execute(current.getInputA(),panel);
                        }
                    }

                }
        );

        panel.setLayout(null);

        this.add(titlePanel);
        this.add(subtitle);
        this.add(subtitleUnderline);
        this.add(username);
        this.add(buttons);
        this.add(recommend);
        this.add(inputPlayer);
        this.add(playerError);



    }


    @Override
    public void actionPerformed(ActionEvent e) {System.out.println("Click " + e.getActionCommand());

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        RecommendState state = (RecommendState) evt.getNewValue();
        if (state.getInputAerror()!= null){
            JOptionPane.showMessageDialog(this, state.getInputAerror());
        }

        // Update username display
        username.setText("Logged In as:" + state.getUsername());

        playerinput.setText(state.getInputA());
    }

}


