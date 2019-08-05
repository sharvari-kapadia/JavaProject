package com.practice.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by SKapadia on 8/23/2016.
 */
public class GenericSorter<T> {

    Comparator<T> comparator;
    T[] input;

    public GenericSorter(T[] input, Comparator<T> comparator) {

        this.input = input;
        this.comparator = comparator;
    }

    public void sortItems() {

        Arrays.sort(input, comparator);
    }

    public static void main(String[] args) {

        //Sorting fruits by name
        Fruit[] fruits = new Fruit[] {
                new Fruit("banana", "banana description", 10),
                new Fruit("apple", "apple description", 16),
                new Fruit("watermelon", "watermelon description", 12),
                new Fruit("mango", "mango description", 20),
                new Fruit("strawberry", "strawberry description", 50)
        };

        GenericSorter<Fruit> fruitSorter = new GenericSorter<>(fruits, Fruit.fruitNameComparator);
        fruitSorter.sortItems();

        System.out.println("Fruits sorted by name: ");
        for (Fruit fruit : fruits) {
            fruit.printFruit();
        }

        //Sorting students by name
        Student[] students = new Student[] {
              new Student("sharvari", 23),
              new Student("aakash", 32),
              new Student("vidya", 29),
              new Student("ajay", 45),
              new Student("khushi", 100)
        };

        GenericSorter<Student> studentSorter = new GenericSorter<>(students, Student.studentNameComparator);
        studentSorter.sortItems();

        System.out.println("\nStudents sorted by name: ");
        for (Student student : students) {

            student.printStudent();
        }

    }
}
