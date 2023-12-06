package use_case.player;

import javax.swing.*;

public class PlayerOutputData {
    private final double likelyPointNum;

    private boolean useCaseFailed;
    public JPanel panel;

    public PlayerOutputData(String likelyPointNum, JPanel panel){
        this.likelyPointNum = Double.parseDouble(likelyPointNum);
        this.panel = panel;
    }
    public double getLikelyPointNum(){
        return this.likelyPointNum;
    }

}
