package use_case.bet_predictor;

public class BetInputData {

    private final String team1Name;
    private final String team2Name;

    public BetInputData(String team1, String team2) {
        this.team1Name = team1;
        this.team2Name = team2;

    }
    String getTeam1Name(){return this.team1Name;}
    String getTeam2Name(){return this.team2Name;}

}
