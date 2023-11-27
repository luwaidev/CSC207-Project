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

        Team fteam = TeamDataAccessObject.getTeamStats(TeamDataAccessObject.getTeamID(team1));
        Team steam = TeamDataAccessObject.getTeamStats(TeamDataAccessObject.getTeamID(team2));



        if (fteam.getAvg_points() > steam.getAvg_points()) {
            BetOutputData betWinner = new BetOutputData(team1, betInputData.panel);
        }
        else {
            BetOutputData betWinner = new BetOutputData(team2, betInputData.panel);
        }

    }
}
