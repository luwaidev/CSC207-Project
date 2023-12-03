package use_case.player_bet_predictor;

import javax.swing.*;

public class PlayerInputData {
    private final String firstName;
    private final String lastName;
    public JPanel panel;

    public PlayerInputData(String firstName, String lastName, JPanel panel){
        this.firstName = firstName;
        this.lastName = lastName;
        this.panel = panel;
    }

    String getFirstName(){
        return this.firstName;
    }

    String getLastName(){
        return this.lastName;
    }


}
