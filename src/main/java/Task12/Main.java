package Task12;

import Task5.Student;
import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Student vasya = new Student("vasiliy", "sidorov", 90);
        Student petya = new Student("petya", "ivanov", 68);
        Student alex = new Student("alex", "lesli", 89);

        System.out.println("Выберите критерий сортировки:");
        System.out.println("1 - по имени");
        System.out.println("2 - по фамилии");
        System.out.println("Любое другое число - по среднему балу");
        Scanner s = new Scanner(System.in);
        Integer a = s.nextInt();

        if (a.equals(1)) {
            Comparator<Student> comparator = (o1, o2) -> (o1.getName().compareTo(o2.getName()));
            SetImpl<Student> bin = new SetImpl(comparator);
            bin.add(vasya);
            bin.add(petya);
            bin.add(alex);
            bin.printInorder();
        } else if (a.equals(2)) {
            Comparator<Student> comparator = (o1, o2) -> (o1.getLastName().compareTo(o2.getLastName()));
            SetImpl<Student> bin = new SetImpl(comparator);
            bin.add(vasya);
            bin.add(petya);
            bin.add(alex);
            bin.printInorder();
        } else {
            Comparator<Student> comparator = (o1, o2) -> (Double.compare(o1.getAvg(), o2.getAvg()));
            SetImpl<Student> bin = new SetImpl(comparator);
            bin.add(vasya);
            bin.add(petya);
            bin.add(alex);
            bin.printInorder();
        }

    }
}
