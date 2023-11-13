package use_case.bet_predictor;

public class BetInputData {

    private final String team1;
    private final String team2;

    public BetInputData(String team1, String team2) {
        this.team1 = team1;
        this.team2 = team2;

    }
    String getTeam1Name(){return this.team1;}
    String getTeam2Name(){return this.team2;}

}
