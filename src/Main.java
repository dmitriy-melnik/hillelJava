import Task5.Group;
import Task5.Student;

public class Main {
    public static void main(String[] args) {

        Student ivan = new Student("Ivan", "Ivanov", 99);
        Student peter = new Student("Peter", "Petrov", 70);
        Group group1 = new Group(1);
        group1.addStudent(ivan);
        group1.addStudent(peter);
        group1.saveToFile("src/Task5/output.txt");

    }
}

/*public static int fibonachi(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        return fibonachi(number - 1) + fibonachi(number - 2);
    }*/

    /*public static double fib(double number) {
        double n0 = 0;
        double n1 = 1;
        for (int i = 2; i <= number; ++i) {
            double next = n0 + n1;
            n0 = n1;
            n1 = next;
        }
        return n1;
    }*/


// TASK 8, TEST --------------------------------------------------------------------------------------------------------

    /*
    MyArrayList a = new MyArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(5);
        a.add(7);
        a.add(9);
        a.add(5);
        System.out.println(a);
        a.remove(5);
        System.out.println("After remove 5: " + a);

    ArrayList list = new ArrayList();
        list.add(11);
        list.add(22);
        list.add(33);

        a.addAll(list);
        System.out.println("After addAll (это будет наш массив): " + a);
        System.out.println("Contains " + list + ": " + a.containsAll(list));

    MyArrayList a1 = new MyArrayList();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(7);
        a1.add(9);
        a1.add(11);
        a1.add(22);
        a1.add(33);
        a1.retainAll(list);
        System.out.println("After retainAll" + list + ": " + a1);

    MyArrayList a2 = new MyArrayList();
        a2.add(1);
        a2.add(2);
        a2.add(3);
        a2.add(7);
        a2.add(9);
        a2.add(11);
        a2.add(22);
        a2.add(33);
        a2.removeAll(list);
        System.out.println("After removeAll" + list + ": " + a2);
        */

// TASK 7, TEST --------------------------------------------------------------------------------------------------------

    /*
    Animal cat = new Cat();
    Animal crocodile = new Crocodile();
    Animal dog = new Dog();
    Animal fish = new Fish();
    Animal giraffe = new Giraffe();
    Animal giudeDog = new GuideDog();
    Animal hamster = new Hamster();
    Animal lion = new Lion();
    Animal wolf = new Wolf();

    ArrayList<Animal> animals = new ArrayList<>();
        animals.add(cat);
                animals.add(crocodile);
                animals.add(dog);
                animals.add(fish);
                animals.add(giraffe);
                animals.add(giudeDog);
                animals.add(hamster);
                animals.add(lion);
                animals.add(wolf);

                for (Animal a : animals) {
                System.out.println(a.voice());
                }
                */

// TASK 6, TEST --------------------------------------------------------------------------------------------------------

    /*
    ArrayInt arr = new ArrayInt();
        arr.add(4);
                arr.add(5);
                System.out.println(arr);
                System.out.println(arr.get(0));
                System.out.println(arr.contains(4));

                int[] a = {2, 3, 6};
                arr.addAll(a);
                System.out.println(arr);

                int[] b = {4, 5};
                System.out.println(arr.equals(b));

                System.out.println(arr.indexOf(5));
                System.out.println(arr.getSize());

                arr.quickSort();
                System.out.println(arr);
     */

// TASK 5, TEST --------------------------------------------------------------------------------------------------------

    /*
    Student ivanov = new Student("Ivanov");
    ArrayList<Integer> ivanovMarks = new ArrayList<Integer>();
        ivanovMarks.add(10);
                ivanovMarks.add(9);
                ivanovMarks.add(9);
                ivanovMarks.add(10);
                ivanov.setMarks(ivanovMarks);
                ArrayList<Boolean> ivanovAttandance = new ArrayList<Boolean>();
        ivanovAttandance.add(true);
        ivanovAttandance.add(true);
        ivanovAttandance.add(false);
        ivanovAttandance.add(true);
        ivanov.setAttandance(ivanovAttandance);

        Student petrov = new Student("Petrov");
        ArrayList<Integer> petrovMarks = new ArrayList<Integer>();
        petrovMarks.add(10);
        petrovMarks.add(10);
        petrovMarks.add(10);
        petrovMarks.add(10);
        petrov.setMarks(petrovMarks);
        ArrayList<Boolean> petrovAttandance = new ArrayList<Boolean>();
        petrovAttandance.add(true);
        petrovAttandance.add(true);
        petrovAttandance.add(true);
        petrovAttandance.add(true);
        petrov.setAttandance(petrovAttandance);

        Student sidorov = new Student("Sidorov");
        ArrayList<Integer> sidorovMarks = new ArrayList<Integer>();
        sidorovMarks.add(10);
        sidorovMarks.add(7);
        sidorovMarks.add(4);
        sidorovMarks.add(2);
        sidorov.setMarks(sidorovMarks);
        ArrayList<Boolean> sidorovAttandance = new ArrayList<Boolean>();
        sidorovAttandance.add(true);
        sidorovAttandance.add(false);
        sidorovAttandance.add(false);
        sidorovAttandance.add(false);
        sidorov.setAttandance(sidorovAttandance);

        Group group1 = new Group(1);
        group1.addStudent(ivanov);
        group1.addStudent(petrov);
        group1.addStudent(sidorov);
        group1.print();

        System.out.println(group1.contains("Ivanov"));

        group1.deleteByLastName("Ivanov");
        group1.print();

        System.out.println(group1.contains("Ivanov"));

        group1.clear();
        group1.print();
        */

// TASK 4 --------------------------------------------------------------------------------------------------------------

    /*String[][] students = new String[10][2];
        int[][] makrs = new int[10][10];
        boolean[][] attandance = new boolean[10][10];*/

    /*
    public static boolean containsStudent(String[][] students, String lastName) {
        for (String[] s : students) {
            if (s[0] == lastName) {
                return true;
            }
        }
        return false;
    }

    public static void addStudent(String[][] students, String lastName) {
        int count = 1;
        for (String[] s : students) {
            if (s[0] == null) {
                s[0] = lastName;
                s[1] = Integer.toString(count);
                break;
            }
            count++;
        }
    }

    public static int getStudentId(String[][] students, String lastName) {
        for (String[] s : students) {
            if (s[0] == lastName) {
                return Integer.parseInt(s[1]);
            }
        }
        return 0;
    }

    public static void addMark(int[][] marks, int studentId, int mark, int lesson) {
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                if (i + 1 == studentId && j + 1 == lesson) {
                    marks[i][j] = mark;
                }
            }
        }
    }

    public static void addAttandance(boolean[][] attandance, int studentId, boolean presence, int lesson) {
        for (int i = 0; i < attandance.length; i++) {
            for (int j = 0; j < attandance[i].length; j++) {
                if (i + 1 == studentId && j + 1 == lesson) {
                    attandance[i][j] = presence;
                }
            }
        }
    }

    public static void deleteStudent(String lastName, String[][] students, int[][] marks, boolean[][] attandance) {
        for (int i = 0; i < attandance.length; i++) {
            for (int j = 0; j < attandance[i].length; j++) {
                if (i + 1 == getStudentId(students, lastName)) {
                    attandance[i][j] = false;
                }
            }
        }

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                if (i + 1 == getStudentId(students, lastName)) {
                    marks[i][j] = 0;
                }
            }
        }

        for (String[] s : students) {
            if (s[0] == lastName) {
                s[0] = null;
                s[1] = null;
            }
        }

    }

    public static void sortByLastName(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            String min = array[i][0];
            int min_i = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j][0] == null) break;
                if (array[j][0].compareTo(min) < 0) {
                    min = array[j][0];
                    min_i = j;
                }
            }
            if (i != min_i) {
                String temp = array[i][0];
                array[i][0] = array[min_i][0];
                array[min_i][0] = temp;
            }
        }
    }

    public static void clear(String[][] students, int[][] marks, boolean[][] attandance) {
        for (int i = 0; i < attandance.length; i++) {
            for (int j = 0; j < attandance[i].length; j++) {
                attandance[i][j] = false;

            }
        }

        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                marks[i][j] = 0;
            }
        }

        for (String[] s : students) {
            s[0] = null;
            s[1] = null;
        }
    }

    public static void printStudents(String[][] array) {
        for (String[] s : array) {
            for (String s2 : s) {
                System.out.print(s2 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printMarks(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[L" + (j + 1) + "] - " + array[i][j] + "; ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printAttandance(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print((i + 1) + ": ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[L" + (j + 1) + "] - " + array[i][j] + "; ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // -----------------------

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public static boolean dotInRectangle(int x1, int y1, int x2, int y2, int x, int y) {
        boolean flagX = false;
        boolean flagY = false;
        if (x1 <= x2) {
            if (x <= x2 && x >= x1) {
                flagX = true;
            }
        } else if (x1 > x2) {
            if (x <= x1 && x >= x2) {
                flagX = true;
            }
        }

        if (y1 <= y2) {
            if (y <= y2 && y >= y1) {
                flagY = true;
            }
        } else if (y1 > y2) {
            if (y <= y1 && y >= y2) {
                flagY = true;
            }
        }
        return flagX && flagY;
    }


// TASK 3 --------------------------------------------------------------------------------------------------------------

    /*
    Scanner sc = new Scanner(System.in);

    // кратность числа
        System.out.println("Введите число: ");
                System.out.println(multiplicity(sc.nextInt()));

                // простое число
                System.out.println("Введите число: ");
                System.out.println(isPrime(sc.nextInt()));

                // четность числа
                System.out.println("Введите число: ");
                System.out.println(evenNumber(sc.nextInt()));

                // фигуры
                System.out.println("Введите ширину: ");
                int m = sc.nextInt();
                System.out.println("Введите длину: ");
                int n = sc.nextInt();

                printRectangle(m, n);
                printEnvelope(m, n);
                printChess(m, n);

                // калькулятор
                double a1 = getDouble();
                char operation = getOperationForCalculator();
                double a2 = getDouble();

                System.out.println("\nОтвет:");
                switch (operation) {
                case '+': {
                System.out.println(Calculator.sum(a1, a2));
                break;
                }
                case '-': {
                System.out.println(Calculator.dif(a1, a2));
                break;
                }
                case '*': {
                System.out.println(Calculator.mul(a1, a2));
                break;
                }
                case '/': {
                System.out.println(Calculator.div(a1, a2));
                break;
                }
                }

                // среднее значение
                String operationForAverage = getOperationForAverage();
                switch (operationForAverage) {
                case "two":
                System.out.println("\nСреднее арифметическое:\n" + Average.avg(getDouble(), getDouble()));
                break;
                case "two+":
                System.out.println("\nСреднее арифметическое:\n" + Average.avgOfList(getNumbers()));
                break;
                }

                // депозит
                System.out.println("Введите данные для депозита:\n");
                Scanner s = new Scanner(System.in);
                System.out.println("Сумма вклада: ");
                double moneyAmount = s.nextDouble();
                System.out.println("Процент годовых (указывать в сотых, например 0.10): ");
                double percentPerYear = s.nextDouble();
                System.out.println("Срок (в годах): ");
                int duration = s.nextInt();
                Deposit deposit = new Deposit(moneyAmount, percentPerYear, duration);
                ArrayList temp = deposit.moneyPerYear();
                for (int i = 0; i < temp.size(); i++) {
        System.out.println(i + 1 + " год: " + temp.get(i));
        }
    */

    /*
    public static char getOperationForCalculator() {

        System.out.println("\nВведите операцию (+, -, *, /, ~):\n");
        char operation;
        Scanner s = new Scanner(System.in);
        String input = s.next();

        while (!(input.matches("[+\\*-/ ]"))) {
            System.out.println("Вы ввели некорректную операцию, повторите ввод: ");
            input = s.next();
        }
        operation = input.charAt(0);

        return operation;
    }

    public static double getDouble() {
        Scanner s = new Scanner(System.in);
        double num;

        do {
            System.out.println("\nВведите число:\n");
            try {
                num = Double.valueOf(s.next());
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true);

        return num;
    }

    public static String getOperationForAverage() {
        System.out.println("\nДля нахождения среднего арифметического двух чисел введите 'two', для нахождения ср. ар. более двух чисел ведите 'two+': ");
        String avgOperation = null;
        Scanner s = new Scanner(System.in);
        avgOperation = s.next();
        while (!avgOperation.equals("two") && !avgOperation.equals("two+")) {
            System.out.println("Повторите ввод ('two' или 'two+'): ");
            avgOperation = s.next();
        }
        return avgOperation;
    }

    public static ArrayList<Double> getNumbers() {
        ArrayList<Double> numbers = new ArrayList<Double>();
        String inputNumber;
        Scanner s = new Scanner(System.in);

        System.out.println("Введите числа (для окончания ввода введите любой символ, кроме числа):");
        inputNumber = s.next();
        while (inputNumber.matches("(-|\\+)?[0-9]+(\\.[0-9]+)?")) {
            numbers.add(Double.parseDouble(inputNumber));
            inputNumber = s.next();
        }
        return numbers;
    }

    public static void printRectangle(int m, int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || j == m - 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }

    // работает только с квадратами
    public static void printEnvelope(int m, int n) {
        System.out.println();
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1) {
                    System.out.print("*");
                } else {
                    if (j == 0 || j == m - 1) {
                        System.out.print("*");
                    } else if (j == i){
                        temp = j;
                        if (j >= m / 2) {
                            temp = j + 1;
                        }
                        System.out.print("*");
                    }
                    else if (j == m - 1 - temp){
                        temp = 0;
                        System.out.print("*");
                    }
                    else {
                        System.out.print(" ");

                    }
                }
            }
            System.out.println();
        }
    }

    public static void printChess(int m, int n) {
        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i % 2 != 0) {
                    System.out.print("* ");
                } else {
                    System.out.print(" *");
                }
            }
            System.out.println();
        }
    }

    public static boolean evenNumber(int num) {
        return num % 2 == 0;
    }

    public static boolean isPrime(int num) {
        BigInteger numBI = BigInteger.valueOf(num);
        return numBI.isProbablePrime(1);
    }

    public static ArrayList<Integer> multiplicity(int number) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }
    */

