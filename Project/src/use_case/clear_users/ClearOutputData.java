package use_case.clear_users;

// TODO Complete me

import javax.swing.*;

public class ClearOutputData {
    public String users;
    public JPanel panel;



    public ClearOutputData(JPanel panel, String users){
        this.users = users;
        this.panel = panel;
    }
    public ClearOutputData(String users){
        this.users = users;
    }
}
