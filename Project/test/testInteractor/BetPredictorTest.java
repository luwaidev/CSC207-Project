package testInteractor;

import data_access.TeamDataAccessObject;
import org.junit.Test;
import use_case.bet_predictor.BetInputData;
import use_case.bet_predictor.BetInteractor;
import use_case.bet_predictor.BetOutputBoundary;
import use_case.bet_predictor.BetOutputData;

import javax.swing.*;

import static org.junit.Assert.*;
public class BetPredictorTest {
    @Test
    public void testExecuteTeam1Wins() {
        // Setup
        BetInputData inputData = new BetInputData("Lakers", "Hawks", "user", new JPanel());
        BetOutputBoundary mockBetPresenter = new BetOutputBoundary() {
            @Override
            public void prepareSuccessView(BetOutputData data) {
                // Assertions for successful view preparation
                assertEquals("Lakers", data.getHigherwinpct_team());
                // Additional assertions as needed
            }

            @Override
            public void prepareFailView(BetOutputData data) {
                fail("prepareFailView should not be called in this scenario");
            }

            @Override
            public void backToMain() {
                // Assertions for returning to main, if applicable
            }
        };

        BetInteractor interactor = new BetInteractor(new TeamDataAccessObject(), mockBetPresenter);

        // Execute
        interactor.execute(inputData);

        // Verify that the correct team is predicted to win
        // Assertions are made within the mockBetPresenter's methods
    }

    @Test
    public void testExecuteTeam2Wins() {
        // Setup
        BetInputData inputData = new BetInputData("Hawks", "Lakers", "user", new JPanel());
        BetOutputBoundary mockBetPresenter = new BetOutputBoundary() {
            @Override
            public void prepareSuccessView(BetOutputData data) {
                assertEquals("Lakers", data.getHigherwinpct_team());
            }

            @Override
            public void prepareFailView(BetOutputData data) {
                fail("prepareFailView should not be called in this scenario");
            }

            @Override
            public void backToMain() {
                // Assertions for returning to main, if applicable
            }
        };

        BetInteractor interactor = new BetInteractor(new TeamDataAccessObject(), mockBetPresenter);

        // Execute
        interactor.execute(inputData);

        // Assertions are made within the mockBetPresenter's methods
    }
    @Test
    public void testExecuteWithInvalidTeamName() {
        // Setup
        BetInputData inputData = new BetInputData("InvalidTeamName1", "InvalidTeamName2", "user", new JPanel());
        BetOutputBoundary mockBetPresenter = new BetOutputBoundary() {
            @Override
            public void prepareSuccessView(BetOutputData data) {
                fail("prepareSuccessView should not be called with invalid team names");
            }

            @Override
            public void prepareFailView(BetOutputData data) {
                // This is the expected outcome, so we can check the data passed here
                assertNotNull("Data passed to fail view should not be null", data);
                // Additional assertions as needed
            }

            @Override
            public void backToMain() {
                // Assertions for returning to main, if applicable
            }
        };

        BetInteractor interactor = new BetInteractor(new TeamDataAccessObject(), mockBetPresenter);

        // Execute
        interactor.execute(inputData);

        // Verify that the fail view is prepared as expected
        // Assertions are made within the mockBetPresenter's methods
    }
    @Test
    public void testBetInputDataGetters() {
        JPanel panel = new JPanel();
        BetInputData inputData = new BetInputData("Team1", "Team2", "user", panel);

        assertEquals("Team1", inputData.getTeam1Name());
        assertEquals("Team2", inputData.getTeam2Name());
        assertEquals("user", inputData.getUsername());
        assertEquals(panel, inputData.panel);
    }
    @Test
    public void testSetUsername() {
        BetOutputBoundary mockBetPresenter = null;
        BetInteractor interactor = new BetInteractor(new TeamDataAccessObject(), mockBetPresenter);

        // Set a new username and then perform an action that depends on the username
        interactor.setUsername("newUser");
        // You can then perform actions that depend on the username,
        // such as executing a bet and verifying that the new username is used correctly
    }
}
