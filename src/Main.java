import java.util.Scanner;
import java.util.SortedMap;

public class Main {
    public static void main(String[]args) {

        int a1 = getInt();
        char operation = getOperation();
        int a2 = getInt();

        System.out.println("\nОтвет:\n");
        switch (operation) {
            case '+': {
                System.out.println(Calculator.result(a1, a2, Calculator.Operation.Sum));
                break;
            }
            case '-': {
                System.out.println(Calculator.result(a1, a2, Calculator.Operation.Dif));
                break;
            }
            case '*': {
                System.out.println(Calculator.result(a1, a2, Calculator.Operation.Mul));
                break;
            }
            case '/': {
                System.out.println(Calculator.result(a1, a2, Calculator.Operation.Div));
                break;
            }
        }
    }

    public static int getInt() {
        System.out.println("\nВведите число:\n");
        int num;
        Scanner s = new Scanner(System.in);
        if(s.hasNextInt()) {
            num = s.nextInt();
        }
        else {
            System.out.println("Вы ввели некорректное число, попоробуйте еще раз:\n");
            s.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("\nВведите операцию (+, -, *, /,):\n");
        char operation;
        Scanner s = new Scanner(System.in);
        String input = s.next();
        if((input.matches("[+\\-*/]"))) {
            operation = input.charAt(0);
        }
        else {
            System.out.println("Вы ввели некорректную операцию");
            operation = getOperation();
        }
        return operation;
    }
}