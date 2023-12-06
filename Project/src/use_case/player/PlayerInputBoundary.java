package use_case.player;

public interface PlayerInputBoundary {
    void execute(PlayerInputData playerInputData);
    void setUsername(String username);
    void backToMain();
}
