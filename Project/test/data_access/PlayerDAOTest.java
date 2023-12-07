package data_access;

import entity.Player;
import data_access.PlayerDataAccessObject;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerDAOTest {

    @Test
    public void testGetPlayerIDValidPlayer() {
        // Assuming 'Russell Westbrook' is a valid player in the API
        int result = PlayerDataAccessObject.getPlayerID("Russell", "Westbrook");
        assertNotEquals("Expected a valid player ID, not -1", -1, result);
    }

    @Test
    public void testGetPlayerIDInvalidPlayer() {
        // Assuming 'InvalidFirstName', 'InvalidLastName' is not a valid player
        int result = PlayerDataAccessObject.getPlayerID("InvalidFirstName", "InvalidLastName");
        assertEquals("Expected -1 for an invalid player name", -1, result);
    }

    @Test
    public void testGetPlayerStatsWithValidID() {
        // Assuming a specific player ID returns a known set of points
        int testPlayerID = 237; // Replace with a valid player ID for testing

        try {
            Player result = PlayerDataAccessObject.getPlayerStats(testPlayerID);
            assertNotNull("Expected a non-null Player object", result);
            assertEquals("Expected player ID to match", testPlayerID, result.getId());
            // Additional assertions can be made based on the expected values of points

        } catch (Exception e) {
            fail("Did not expect an exception for a valid player ID");
        }
    }

    @Test
    public void testGetPlayerStatsWithInvalidID() {
        // Assuming -1 is an invalid player ID
        try {
            Player result = PlayerDataAccessObject.getPlayerStats(-1);
            // Define expected behavior for invalid ID and assert
            // For example, expecting a null result or specific exception
        } catch (Exception e) {
            // Handle exception if your method is designed to throw one for invalid IDs
        }
    }


}
