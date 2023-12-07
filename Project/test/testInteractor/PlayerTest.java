package testInteractor;

import org.junit.Before;
import org.junit.Test;
import use_case.player.PlayerInputData;
import use_case.player.calculatePlayerAverage.Context;
import use_case.player.calculatePlayerAverage.meanPlayerCalculator;
import use_case.player.calculatePlayerAverage.rangePlayerCalculatorOverlap;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void testCalculatePlayerWithNonEmptyList() {
        meanPlayerCalculator calculator = new meanPlayerCalculator();
        ArrayList<Integer> stats = new ArrayList<>();
        stats.add(10);
        stats.add(20);
        stats.add(30);

        String result = calculator.calculatePlayer(stats);
        assertEquals("They are most likely to get 20 points.", result);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculatePlayerWithEmptyList() {
        meanPlayerCalculator calculator = new meanPlayerCalculator();
        ArrayList<Integer> stats = new ArrayList<>();

        calculator.calculatePlayer(stats); // This will throw ArithmeticException
    }

    @Test
    public void testCalculatePlayerWithSingleElement() {
        meanPlayerCalculator calculator = new meanPlayerCalculator();
        ArrayList<Integer> stats = new ArrayList<>();
        stats.add(15);

        String result = calculator.calculatePlayer(stats);
        assertEquals("They are most likely to get 15 points.", result);
    }
    @Test
    public void testCalculatePlayerWithRangeDivisibleByTwo() {
        rangePlayerCalculatorOverlap calculator = new rangePlayerCalculatorOverlap();
        ArrayList<Integer> stats = new ArrayList<>(Arrays.asList(10, 12, 14, 16, 18));

        String result = calculator.calculatePlayer(stats);
        // Assert the expected result based on your logic
    }
    @Test
    public void testContextWithRangePlayerCalculatorOverlap() {
        Context context = new Context(new rangePlayerCalculatorOverlap());
        ArrayList<Integer> stats = new ArrayList<>();
        stats.add(10);
        stats.add(12);
        stats.add(14);

        String result = context.executeStrategy(stats);
        // Assert the expected result based on your logic in rangePlayerCalculatorOverlap
    }

    @Test
    public void testCalculatePlayerWithStatsLeadingToDifferentMaxKey() {
        rangePlayerCalculatorOverlap calculator = new rangePlayerCalculatorOverlap();
        ArrayList<Integer> stats = new ArrayList<>();
        // Add stats that lead to a different maxKey
        // For example, if your ranges are 0-2, 2-4, add stats that will make 2-4 have the highest count
        stats.add(2);
        stats.add(3);
        stats.add(3);
        stats.add(4);

        String result = calculator.calculatePlayer(stats);
        // Assert the expected result based on the logic for these specific stats
    }

    @Test
    public void testContextWithMeanPlayerCalculator() {
        Context context = new Context(new meanPlayerCalculator());
        ArrayList<Integer> stats = new ArrayList<>();
        stats.add(10);
        stats.add(20);
        stats.add(30);

        String result = context.executeStrategy(stats);
        assertEquals("They are most likely to get 20 points.", result);
    }

    private PlayerInputData playerInputData;
    private final String firstName = "John";
    private final String lastName = "Doe";
    private JPanel panel;

    @Before
    public void setUp() {
        panel = new JPanel();
        playerInputData = new PlayerInputData(firstName, lastName, panel);
    }

    @Test
    public void testGetFirstName() {
        assertEquals("Incorrect first name", firstName, playerInputData.getFirstName());
    }

    @Test
    public void testGetLastName() {
        assertEquals("Incorrect last name", lastName, playerInputData.getLastName());
    }

    @Test
    public void testPanel() {
        assertEquals("Panel should be the same as the one passed in constructor", panel, playerInputData.panel);
    }

}
