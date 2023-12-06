package use_case.player.calculatePlayerAverage;

import java.util.ArrayList;

public class sampleCalculation {
    public static void main(String[] args) {
        Context context = new Context(new rangePlayerCalculatorOverlap());
        Context newContext = new Context(new meanPlayerCalculator());
        ArrayList<Integer> sampleData = new ArrayList<Integer>();
        sampleData.add(10);
        sampleData.add(11);
        sampleData.add(14);
        sampleData.add(26);
        sampleData.add(13);
        sampleData.add(13);
        sampleData.add(13);
        sampleData.add(12);

        System.out.println(context.executeStrategy(sampleData));
        System.out.println(newContext.executeStrategy(sampleData));
    }

}
