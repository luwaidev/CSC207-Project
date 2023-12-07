package data_access;
import data_access.TeamDataAccessObject;
import entity.Team;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TeamDAOTest {
    @Test
    public void testGetTeamIDWithValidTeam() {
        // Assuming 'Hawks' is a valid team in the API
        int result = TeamDataAccessObject.getTeamID("Hawks");
        assertNotEquals("Expected a valid team ID, not -1", -1, result);
    }

    @Test
    public void testGetTeamIDWithInvalidTeam() {
        // Assuming 'InvalidTeamName' is not a valid team in the API
        int result = TeamDataAccessObject.getTeamID("InvalidTeamName");
        assertEquals("Expected -1 for an invalid team name", -1, result);
    }
    @Test
    public void testGetTeamStatsWithValidID() {
        // Assuming 1 is a valid team ID in the API
        try {
            Team result = TeamDataAccessObject.getTeamStats(1);
            assertNotNull("Expected a non-null Team object", result);
            assertEquals("Expected team ID to match", 1, result.getId());
            // Further assertions can be made depending on the structure of the Team class
        } catch (Exception e) {
            fail("Did not expect an exception for a valid team ID");
        }
    }

    @Test
    public void testGetTeamStatsWithInvalidID() {
        // Assuming -1 is an invalid team ID
        try {
            Team result = TeamDataAccessObject.getTeamStats(-1);
            // Define expected behavior for invalid ID and assert
            // For example, expecting a null result or specific exception
        } catch (Exception e) {
            // Handle exception if your method is designed to throw one for invalid IDs
        }
    }

}
