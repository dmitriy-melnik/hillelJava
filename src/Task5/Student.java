package Task5;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String lastName;
    private List<Integer> marks = new ArrayList();
    private List<Boolean> attandance = new ArrayList<>();

    public Student(String lastName) {
        this.lastName = lastName;
    }

    // getters

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public List<Boolean> getAttandance() {
        return attandance;
    }

    // setters

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // можно было добавлять оценки и посещение методом add, а не передавая целую коллекцию сразу, 
    // но в таком случае пришлось бы использовать массив либо коллекцию Map,
    // что усложнило бы задание, при том, что в задании нужно реализовать только добавление студента, а не его оценок и посещяемости
    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public void setAttandance(List<Boolean> attandance) {
        this.attandance = attandance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastName='" + lastName + '\'' +
                ", marks=" + marks +
                ", attandance=" + attandance +
                '}';
    }
}
