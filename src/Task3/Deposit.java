package Task3;

import java.util.ArrayList;

import static java.lang.StrictMath.pow;

public class Deposit {

    private double moneyAmount;
    private double percentPerYear;
    private int duration;

    public Deposit(double moneyAmount, double percentPerYear, int duration) {
        this.moneyAmount = moneyAmount;
        this.percentPerYear = percentPerYear;
        this.duration = duration;
    }

    public ArrayList<Double> moneyPerYear() {
        ArrayList<Double> result = new ArrayList();
        for (int i = 1; i < duration; i++) {
            result.add(moneyAmount * pow((1 + percentPerYear), i));
        }
        return result;
    }
}
