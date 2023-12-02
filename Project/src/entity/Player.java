package entity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {
    private final int playerId;
    private final int numGamesPlayed;
    private final ArrayList<Integer> pointsPerGame;
    private final double avgPoints;
    public int getId() {return playerId;}

    public int getNumGamesPlayed() {return numGamesPlayed;}

    public ArrayList<Integer> getPointsPerGame(){ return pointsPerGame;}

    public double getAvgPoints(){return avgPoints;}

    public Player(int playerId, ArrayList<Integer> playerPointsPerGame){
        this.playerId = playerId;
        this.pointsPerGame = playerPointsPerGame;
        this.numGamesPlayed = pointsPerGame.size();
        this.avgPoints = avg(playerPointsPerGame, numGamesPlayed);
    }

    public double avg(ArrayList<Integer> playerPointsPerGame, int numGamesPlayed){
        int total = 0;
        for (int point : playerPointsPerGame) {
            total += point;
        }
        return (double) total/numGamesPlayed;
    }

}
