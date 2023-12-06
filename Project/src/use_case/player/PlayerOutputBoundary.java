package use_case.player;

public interface PlayerOutputBoundary {
    void prepareSuccessView(PlayerOutputData playerOutputData);

    void prepareFailView(PlayerOutputData playerOutputData);
    void backToMain();

}
