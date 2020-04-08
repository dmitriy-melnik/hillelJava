package Task5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Group {

    private int number;
    // данные о студентах хранятся в уже отсортированной коллекции
    // для правильной сортировки в TreeSet было передано лямбда-выражение
    // (также можно было передать анонимный класс компаратора либо Comparator.comparing(Student::getLastName), либо создать новый класс компаратора)
    private TreeSet<Student> students = new TreeSet<>((o1, o2) -> Double.compare(o1.getAvg(), o2.getAvg()));

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

    // вывод в файл txt
    public void saveToFile(String path) throws Exception{
        ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(path));
        Iterator<Student> sItr = students.iterator();
        while (sItr.hasNext()) {
            Student s = sItr.next();
            objectOut.writeObject(s);
        }
        objectOut.close();
    }

    // вывод из файла txt
    public void getFromFile(String path) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
        try {
            while (true) {
                addStudent((Student) in.readObject());
            }
        } catch (IOException e) {
            in.close();
        }
    }

    // вывод в файл txt в формате JSON
    public void saveToFileJSON(String path) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        FileWriter out = new FileWriter(path);
        Iterator<Student> sItr = students.iterator();
        while (sItr.hasNext()) {
            Student s = sItr.next();
            out.write(objectMapper.writeValueAsString(s) + "\n");
        }
        out.close();
    }

    // вывод из файла txt JSON данных
    public void getFromFileJSON(String path) throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        Scanner scanner = new Scanner(new FileReader(path));
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            addStudent(objectMapper.readValue(scanner.next(), Student.class));
        }
        scanner.close();
    }

}
