package use_case.player_bet_predictor.calculatePlayerAverage;

public class sampleCalculationAPI {
    public static void main(String[] args) {
        /*
        incomplete will be pushed for presentation demo purposes.
         */
        Context context = new Context(new rangePlayerCalculatorOverlap());
        Context newContext = new Context(new meanPlayerCalculator());
    }
}