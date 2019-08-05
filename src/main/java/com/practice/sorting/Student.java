package com.practice.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by SKapadia on 8/23/2016.
 */
public class Student implements Comparable<Student> {

    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student student) {

        return this.score - student.score;
    }

    public void printStudent() {

        System.out.println("Name: " + name + " Score: " + score);
    }

    public static Comparator<Student> studentNameComparator = new Comparator<Student>() {

        @Override
        public int compare(Student student1, Student student2) {

            return student1.name.compareTo(student2.name);
        }
    };

    public static void main(String[] args) {

        Student[] students = new Student[5];
        students[0] = new Student("sharvari", 23);
        students[1] = new Student("aakash", 32);
        students[2] = new Student("vidya", 29);
        students[3] = new Student("ajay", 45);
        students[4] = new Student("khushi", 100);

        System.out.println("Students sorted by score:");
        Arrays.sort(students);

        for (Student student : students) {

            student.printStudent();
        }

        System.out.println("Students sorted by name:");
        Arrays.sort(students, Student.studentNameComparator);
    }
}
