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
    final JTextField playerinput2 = new JTextField(15);

    private final JLabel playerError = new JLabel();
    final JButton recommend;

    public BetRecommendView(RecommendViewModel recommendViewModel, RecommendController recommendController){
        this.recommendViewModel = recommendViewModel;
        this.recommendController = recommendController;



        JLabel title = new JLabel((recommendViewModel.TITLE_LABEL));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        LabelTextPanel inputPlayer = new LabelTextPanel(new JLabel(recommendViewModel.INPUT_A_LABEL),playerinput);
        LabelTextPanel inputPlayer1 = new LabelTextPanel(new JLabel(recommendViewModel.INPUT_B_LABEL),playerinput2);
        buttons.add(inputPlayer);
        buttons.add(inputPlayer1);

        recommend = new JButton(recommendViewModel.RECOMMEND_BUTTON_LABEL);
        recommend.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel panel = this;
        recommend.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(recommend)) {
                            RecommendState current = RecommendViewModel.getState();

                            recommendController.execute(current.getInputA(), current.getInputB(), panel);
                        }
                    }

                }
        );
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

        playerinput2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                RecommendState current = RecommendViewModel.getState();
                current.setInputA(playerinput2.getText()+e.getKeyChar());
                recommendViewModel.setState(current);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.add(title);
        this.add(buttons);
        this.add(inputPlayer);
        this.add(playerError);
        this.add(inputPlayer1);


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
        playerinput.setText(state.getInputA());
    }

}


