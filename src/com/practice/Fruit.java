/*Example to understand Comparable and Comparator*/
package com.practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by SKapadia on 8/8/2016.
 */
public class Fruit implements Comparable<Fruit> {

    private String name;
    private String description;
    private int quantity;

    Fruit(String name, String description, int quantity) {

        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public static void print(Fruit fruit) {

        System.out.println(fruit.name + " " + fruit.description + " " + fruit.quantity);
    }

    @Override
    public int compareTo(Fruit fruit) {

        return this.quantity - fruit.quantity;
    }

    public static Comparator<Fruit> fruitNameComparator = new Comparator<Fruit>() {

        @Override
        public int compare(Fruit fruit1, Fruit fruit2) {
            return fruit1.name.compareTo(fruit2.name);
        }
    };

    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[5];
        fruits[0] = new Fruit("banana", "banana description", 10);
        fruits[1] = new Fruit("apple", "apple description", 16);
        fruits[2] = new Fruit("watermelon", "watermelon description", 12);
        fruits[3] = new Fruit("mango", "mango description", 20);
        fruits[4] = new Fruit("strawberry", "strawberry description", 50);

        System.out.println("Sorted by quantity: ");
        Arrays.sort(fruits);
        for(int i = 0; i < fruits.length; i++) {
            Fruit.print(fruits[i]);
        }

        System.out.println("\nSorted by name: ");
        Arrays.sort(fruits, fruitNameComparator);
        for(int i = 0; i < fruits.length; i++) {
            Fruit.print(fruits[i]);
        }
    }
}
