package use_case.bet_predictor;

public class BetInteractor implements BetInputBoundary {
    // this class is for making predictions b/w two teams

    final BetTeamDataAccessInterface userDataAccessObject;
    // data access interface is a problem for later lol

    final BetOutputBoundary betPresenter;

    public BetInteractor(BetTeamDataAccessInterface userDataAccessInterface, BetOutputBoundary betOutputBoundary){
        this.userDataAccessObject = userDataAccessInterface;
        this.betPresenter = betOutputBoundary;
    }
    @Override
    public void execute(BetInputData betInputData) {
        // TODO: get team ids using input data

        // TODO: predict which team is more likely to win
        /*
        steps:
        1. search for game ids containing both teams
        2.
         */





    }
}
