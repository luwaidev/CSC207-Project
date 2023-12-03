package use_case.player_bet_predictor;

public interface PlayerInputBoundary {
    void execute(PlayerInputData playerInputData);
    void setUsername(String username);
    void backToMain();
}
