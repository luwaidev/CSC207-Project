package use_case.bet_predictor;
import data_access.TeamDataAccessObject;
import entity.BetHistory;
import entity.Team;
import interface_adapter.bet_history.BetHistoryController;


public class BetInteractor implements BetInputBoundary {

    final BetTeamDataAccessInterface userDataAccessObject;

    final BetOutputBoundary betPresenter;
    private String username = "username";

    public BetInteractor(BetTeamDataAccessInterface userDataAccessInterface, BetOutputBoundary betOutputBoundary){
        this.userDataAccessObject = userDataAccessInterface;
        this.betPresenter = betOutputBoundary;
    }
    @Override
    public void execute(BetInputData betInputData) {
        String team1 = betInputData.getTeam1Name();
        String team2 = betInputData.getTeam2Name();
        String error = "Error";

        Team fteam = TeamDataAccessObject.getTeamStats(TeamDataAccessObject.getTeamID(team1));
        Team steam = TeamDataAccessObject.getTeamStats(TeamDataAccessObject.getTeamID(team2));
        if (fteam.getAvg_points() > steam.getAvg_points()) {
            BetHistory.setBetHistory(username,"teambet", team1 + " will beat " + team2);
            BetOutputData betWinner = new BetOutputData(team1, betInputData.panel);
            betPresenter.prepareSuccessView(betWinner);
        }
        else if (fteam.getAvg_points() < steam.getAvg_points()) {
            BetHistory.setBetHistory(username, "teambet", team2 + " will beat " + team1);
            BetOutputData betWinner = new BetOutputData(team2, betInputData.panel);
            betPresenter.prepareSuccessView(betWinner);
        }
        else{
            BetOutputData betWinner = new BetOutputData(error, betInputData.panel);
            betPresenter.prepareFailView(betWinner);
        }
    }

    @Override
    public void setUsername(String username){
        this.username = username;
        System.out.println("Username set to: " + username + " in BetInteractor");
    }

    @Override
    public void backToMain() {
        betPresenter.backToMain();
    }
}
