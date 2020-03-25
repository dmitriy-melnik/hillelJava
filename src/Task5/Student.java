package Task5;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

    private String lastName;
    private String name;
    private double avg;
    @JsonIgnore
    private transient List<Integer> marks = new ArrayList();
    @JsonIgnore
    private transient List<Boolean> attandance = new ArrayList<>();

    public Student(String name, String lastName, double avg) {
        this.name = name;
        this.lastName = lastName;
        this.avg = avg;
    }

    public Student() {

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

    public String getName() {
        return name;
    }

    public double getAvg() {
        return avg;
    }

    // setters


    public void setName(String name) {
        this.name = name;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

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
        return name + "," + lastName + "," + avg;
    }
}
