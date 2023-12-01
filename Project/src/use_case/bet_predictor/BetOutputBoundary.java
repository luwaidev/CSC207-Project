package use_case.bet_predictor;


public interface BetOutputBoundary {
    void prepareSuccessView(BetOutputData team);

    void prepareFailView(BetOutputData team);

    void backToMain();


}
