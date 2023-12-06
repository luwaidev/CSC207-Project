package entity;

import entity.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private ArrayList<Integer> pointsPerGame;

    @Before
    public void setUp() {
        pointsPerGame = new ArrayList<>(Arrays.asList(15, 25, 35));
        player = new Player(1, pointsPerGame);
    }

    @Test
    public void testPlayerConstructor() {
        assertEquals("Incorrect player ID", 1, player.getId());
        assertEquals("Incorrect number of games played", 3, player.getNumGamesPlayed());
        assertEquals(pointsPerGame, player.getPointsPerGame());
        assertEquals(25.0, player.getAvgPoints(), 0.01);
    }

    @Test
    public void testGetId() {
        assertEquals("Incorrect player ID", 1, player.getId());
    }

    @Test
    public void testGetNumGamesPlayed() {
        assertEquals("Incorrect number of games played", 3, player.getNumGamesPlayed());
    }

    @Test
    public void testGetPointsPerGame() {
        assertEquals(pointsPerGame, player.getPointsPerGame());
    }

    @Test
    public void testGetAvgPoints() {
        assertEquals(25.0, player.getAvgPoints(), 0.01);
    }

    @Test
    public void testAvg() {
        double avg = player.avg(new ArrayList<>(Arrays.asList(40, 50, 60)), 3);
        assertEquals(50.0, avg, 0.01);
    }
}
