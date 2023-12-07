package entity;

import entity.Team;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TeamTest {

    private Team team;
    private ArrayList<Integer> pointsPerGame;

    @Before
    public void setUp() {
        pointsPerGame = new ArrayList<>(Arrays.asList(10, 20, 30));
        team = new Team(1, pointsPerGame);
    }

    @Test
    public void testTeamConstructor() {
        assertEquals("Incorrect ID", 1, team.getId());
        assertEquals("Incorrect number of games", 3, team.getNumgames());
        assertEquals(pointsPerGame, team.getPoints_per_game());
        assertEquals(20.0, team.getAvg_points(), 0.01);
    }

    @Test
    public void testGetId() {
        assertEquals("Incorrect ID", 1, team.getId());
    }

    @Test
    public void testGetNumgames() {
        assertEquals("Incorrect number of games", 3, team.getNumgames());
    }

    @Test
    public void testGetPoints_per_game() {
        assertEquals(pointsPerGame, team.getPoints_per_game());
    }

    @Test
    public void testGetAvg_points() {
        assertEquals(20.0, team.getAvg_points(), 0.01);
    }

    @Test
    public void testAvgp() {
        double avg = team.avgp(new ArrayList<>(Arrays.asList(50, 60, 70)), 3);
        assertEquals(60.0, avg, 0.01);
    }
}