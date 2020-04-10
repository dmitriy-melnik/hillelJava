package Task27;
import Task25_Servlets.Student;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(new Student(1, "Ivan", "Ivanov", 55),
                new Student(2, "Peter", "Petrov", 99),
                new Student(3, "Akakiy", "Vsemoguschiy", 150),
                new Student(4, "Sidor", "Sidorov", 75),
                new Student(5, "Iiiiiigor", "Eager", 100),
                new Student(6, "Platon", "Platoniy", 10),
                new Student(7, "Anatoliy", "Shevchenko", 80));

        List<String> result = studentStream
                .filter(s -> {
                    char[] vowelArr = new char[]{'a', 'e', 'i', 'o', 'u', 'y'};
                    char[] arrayToProc = s.getFirstName().toLowerCase().toCharArray();
                    int counter = 0;

                    for (char ch : arrayToProc) {
                        for (char ch2 : vowelArr) {
                            if (ch == ch2) {
                                counter++;
                            }
                        }
                    }
                    return counter > 3;
                })
                .map(s -> s.getLastName())
                .map(s -> s.toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
    }

}
