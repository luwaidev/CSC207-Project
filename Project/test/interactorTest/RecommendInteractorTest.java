package interactorTest;
import data_access.PlayerDataAccessObject;
import org.junit.Test;
import use_case.bet_recommendation.RecommendationInputData;
import use_case.bet_recommendation.RecommendationInteractor;
import use_case.bet_recommendation.RecommendationOutputBoundary;
import use_case.bet_recommendation.RecommendationOutputData;
import static org.junit.Assert.*;

import javax.swing.*;

public class RecommendInteractorTest {
    @Test
    public void testInputData () {
        JPanel panel = new JPanel();
        RecommendationInputData recommendationInputData = new RecommendationInputData("Devin Booker", panel);
        assertEquals("Devin Booker",recommendationInputData.getName());
        assertEquals(panel, recommendationInputData.panel);
    }
    @Test
    public void testRecommendation() {
        RecommendationInputData inputData = new RecommendationInputData("Kawhi Leonard" ,new JPanel());

        RecommendationOutputBoundary mockBetPresenter = new RecommendationOutputBoundary() {
            @Override
            public void prepareSuccessView(RecommendationOutputData recommendationOutputData) {
                assertEquals("Risky Bet : \n" + "Kawhi Leonard scoring over 28.5 pts\n" +
                        "Kawhi Leonard scoring under 23.5 pts\n\n" + "Safe Bet : \n" +
                        "Kawhi Leonard scoring over 26.5 pts\n" +
                        "Kawhi Leonard scoring under 25.5 pts\n", recommendationOutputData.getBet_recommendation());
            }

            @Override
            public void prepareFailView(RecommendationOutputData recommendationOutputData) {
                fail("prepareFailView should not be called in this scenario");
            }

            @Override
            public void backtoMain() {

            }


        };
        RecommendationInteractor recommendationInteractor = new
                RecommendationInteractor(new PlayerDataAccessObject(), mockBetPresenter);

        recommendationInteractor.execute(inputData);
    }
    @Test
    public void testRecommendationFailure() {
        RecommendationInputData inputData = new RecommendationInputData("Invalid Plyer" ,new JPanel());

        RecommendationOutputBoundary mockBetPresenter = new RecommendationOutputBoundary() {
            @Override
            public void prepareSuccessView(RecommendationOutputData recommendationOutputData) {
                fail("prepareSuccessView should not be called");
            }

            @Override
            public void prepareFailView(RecommendationOutputData recommendationOutputData) {
                assertNotNull("Data passed into the fail view should not be called",recommendationOutputData);
            }

            @Override
            public void backtoMain() {

            }


        };
        RecommendationInteractor recommendationInteractor = new RecommendationInteractor(new PlayerDataAccessObject(), mockBetPresenter);
        recommendationInteractor.execute(inputData);

    }
}