package Task3;

public class Calculator {
    private Calculator(){}

    public static double sum(double d1, double d2) {

        return d1 + d2;
    }

    public static double dif(double d1, double d2) {

        return d1 - d2;
    }

    public static double mul(double d1, double d2) {

        return d1 * d2;
    }

    public static double div(double d1, double d2) {

        if (d2 == 0) {
            throw new IllegalArgumentException("Делить на ноль нельзя");
        }
        else {
            return d1 / d2;
        }
    }

}
