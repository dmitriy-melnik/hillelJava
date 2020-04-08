package Task5;

import java.io.File;

public class Test {
    public static void main(String[] args) throws Exception {

        /*Student ivan = new Student("Ivan", "Ivanov", 99);
        Student peter = new Student("Peter", "Petrov", 55);
        Group group = new Group(0);
        *//*group.addStudent(ivan);
        group.addStudent(peter);
        group.saveToFileJSON("src/Task5/output.txt");*//*
        group.getFromFileJSON("src/Task5/output.txt");
        group.print();*/
        int numberOfStudents = 10000;
        for (int i = 0; i < 2; i++) {

            Group group1 = new Group(1);

            // java
            for (int m = 0; m < numberOfStudents; m++) {
                group1.addStudent(new Student("Ivan", "Ivanov", m));
            }

            System.out.println("\nNumber of studetns: " + numberOfStudents + "\n");
            System.out.println("Java\n");
            long startTime = System.currentTimeMillis();
            group1.saveToFile("src/Task5/output.txt");
            long allTime = System.currentTimeMillis() - startTime;
            System.out.println("Java serialization: " + allTime / 1000.0);

            group1.clear();

            startTime = System.currentTimeMillis();
            group1.getFromFile("src/Task5/output.txt");
            allTime = System.currentTimeMillis() - startTime;
            System.out.println("Java deserialization: " + allTime / 1000.0);
            System.out.println("File size: " + new File("src/Task5/output.txt").length() / 1024.0 / 1024.0 + " mb");

            // json
            for (int m = 0; m < numberOfStudents; m++) {
                group1.addStudent(new Student("Ivan", "Ivanov", m));
            }

            System.out.println("\nJSON\n");
            startTime = System.currentTimeMillis();
            group1.saveToFileJSON("src/Task5/outJSON.txt");
            allTime = System.currentTimeMillis() - startTime;
            System.out.println("JSON serialization: " + allTime / 1000.0);

            group1.clear();

            startTime = System.currentTimeMillis();
            group1.getFromFileJSON("src/Task5/outJSON.txt");
            allTime = System.currentTimeMillis() - startTime;
            System.out.println("JSON deserialization: " + allTime / 1000.0);
            System.out.println("File size: " + new File("src/Task5/outJSON.txt").length() / 1024.0 / 1024.0 + " mb");


            numberOfStudents = 1000000;
        }

    }
}
