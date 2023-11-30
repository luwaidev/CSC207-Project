package view;

import interface_adapter.game_history.GameHistoryViewModel;

import javax.swing.*;

public class GameHistoryView extends JPanel {
    public final String viewName = "game history";

    private final GameHistoryViewModel gameHistoryViewModel;

    public GameHistoryView(GameHistoryViewModel gameHistoryViewModel){
        this.gameHistoryViewModel = gameHistoryViewModel;
    }
}
