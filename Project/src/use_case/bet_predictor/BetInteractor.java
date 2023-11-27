package use_case.bet_predictor;
import data_access.TeamDataAccessObject;
import entity.Team;

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
        String team1 = betInputData.getTeam1Name();
        String team2 = betInputData.getTeam2Name();

        Team team1 = getTeamStats




    }
}
