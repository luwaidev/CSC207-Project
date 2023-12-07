package entity;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class BetHistoryTest {
    private BetHistory betHistory;
    private String user;
    private String type;
    private String betOrRec;


    @Before
    public void setUp() {
        betHistory = new BetHistory();

    }
    @Test
    public void testBetHistoryFunctionality() {
        // Adding bets for a user
        BetHistory.setBetHistory("user1", "teambet", "Team A vs Team B");
        BetHistory.setBetHistory("user1", "reccomendation", "Bet on Team A");
        BetHistory.setBetHistory("user1", "playerbet", "Player X to score");

        // Retrieving and validating bet history for the user
        String expectedHistory = "TeamBet Prediction History \n" +
                "1. Team A vs Team B\n" +
                " \nRecommendation Prediction History \n" +
                "1. Bet on Team A\n" +
                " \nPlayer Bet History \n" +
                "1. Player X to score\n";

        String actualHistory = BetHistory.getBetHistory("user1");
        assertEquals("all good",expectedHistory, actualHistory);

        // Test for a non-existing user
    }
    @Test
    public void testNonExistentUser() {
        BetHistory.setBetHistory("user1", "teambet", "Team A vs Team B");

        assertEquals("non-existent user returns null", null, BetHistory.getBetHistory("user2"));
    }
}
