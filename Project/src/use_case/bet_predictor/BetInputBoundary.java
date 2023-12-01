package use_case.bet_predictor;


public interface BetInputBoundary {
    void execute(BetInputData betInputData);

    void setUsername(String username);
}
