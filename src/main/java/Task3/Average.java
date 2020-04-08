package Task3;

import java.util.ArrayList;

public class Average {

    private Average() {}

    public static double avg(double d1, double d2) {

        return Calculator.sum(d1,d2) / 2;
    }

    public static double avgOfList(ArrayList<Double> numbers) {
        if (numbers.size() > 0) {
            double sum = 0;
            for (double d : numbers) {
                sum += d;
            }
            return sum / numbers.size();
        }
        else return 0;
    }
}
