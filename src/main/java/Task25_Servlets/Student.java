package Task25_Servlets;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private double avg;

    public static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "Ivan", "Ivanov", 55));
        students.add(new Student(2, "Peter", "Petrov", 99));
        students.add(new Student(3, "Akakiy", "Vsemoguschiy", 150));
    }

    public Student(int id, String firstName, String lastName, double avg) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avg = avg;
    }

    public static Student findUserById(int id) {
        for (Student s : students) {
            if (s.id == id) {
                return s;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static void setStudents(List<Student> students) {
        Student.students = students;
    }
}
