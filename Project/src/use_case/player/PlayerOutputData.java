package use_case.player;

import javax.swing.*;

public class PlayerOutputData {
    private final String likelyPointNum;

    private boolean useCaseFailed;
    public JPanel panel;

    public PlayerOutputData(String likelyPointNum, JPanel panel){
        this.likelyPointNum = likelyPointNum;
        this.panel = panel;
    }
    public String getLikelyPointNum(){
        return this.likelyPointNum;
    }

}
