public class Calculator {
    private Calculator(){}

    public static double result(double x1, double x2, Operation operation) {

        switch (operation) {
            case Sum: {
                return x1 + x2;
            }
            case Dif: {
                return x1 - x2;
            }
            case Mul: {
                return x1 * x2;
            }
            case Div: {
                return x1 / x2;
            }
            default: {
                return 0;
            }
        }
    }

    public enum Operation {
        Sum, Dif, Mul, Div;
    }
}
