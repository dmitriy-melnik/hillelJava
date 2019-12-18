package Task5;

import java.util.Iterator;
import java.util.TreeSet;

public class Group {

    private int number;
    // данные о студентах хранятся в уже отсортированной коллекции
    // для правильной сортировки в TreeSet было передано лямбда-выражение
    // (также можно было передать анонимный класс компаратора либо Comparator.comparing(Student::getLastName), либо создать новый класс компаратора)
    private TreeSet<Student> students = new TreeSet<>((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

    public Group(int number) {
        this.number = number;
    }

    // getters

    public int getNumber() {
        return number;
    }

    public TreeSet<Student> getStudents() {
        return students;
    }

    // setters

    public void setNumber(int number) {
        this.number = number;
    }

    // добавление студента

    public void addStudent(Student s) {
        students.add(s);
    }

    // вывод всех студентов группы

    public void print() {
        System.out.println("Group number " + number);
        for (Student s : students)
            System.out.println(s);
    }

    // удаление студента (реализовано с помощью итератора)

    public void deleteByLastName(String lastName) {
        Iterator<Student> sItr = students.iterator();
        while (sItr.hasNext()) {
            Student s = sItr.next();
            if (s.getLastName().equals(lastName)) {
                sItr.remove();
            }
        }
    }

    // наличие студента

    public boolean contains(String lastName) {
        for (Student s : students) {
            if (s.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    // очистка группы

    public void clear() {
        students.clear();
    }

}
