package entity;


import java.util.ArrayList;

public class Team {

    private final int id;
    private int numgames;
    private ArrayList<Integer> points_per_game;
    private double avg_points;

    public Team(int id, ArrayList<Integer> ppg) {
        this.id = id;
        this.points_per_game = ppg;
        this.numgames = points_per_game.size();
        this.avg_points = avgp(points_per_game, numgames);
    }

    public int avgp(ArrayList<Integer> ppg, int numgames) {
       int total = 0;
       for (int point : ppg) {
           total += point;
       }
       return total/numgames;
    }
}
