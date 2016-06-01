package com.practice.interview;

/**
 * Created by SKapadia on 4/25/2016.
 */
public class Q2_PushZeros {

    public static int[] pushZeros(int[] array) {
        int toPointer = 0;
        int fromPointer = 0;
        int untilPointer = 0;
        int arrayLength = array.length;

        while(toPointer < arrayLength && fromPointer < arrayLength && untilPointer < arrayLength) {
            while(toPointer < arrayLength && array[toPointer] != 0) {
                toPointer++;
            }

            fromPointer = toPointer;
            while(fromPointer < arrayLength && array[fromPointer] == 0) {
                fromPointer++;
            }

            untilPointer = fromPointer;
            while(untilPointer < arrayLength && array[untilPointer] != 0) {
                untilPointer++;
            }
            _pushZeros(array, toPointer, fromPointer, untilPointer);
        }

        return array;
    }

    private static void _pushZeros(int[] array, int to, int from, int until) {

        for(int i = from; i < until; i++) {
            array[to] = array[from];
            array[from] = 0;
            to++;
            from++;
        }
    }

    private static void printArray(int[] array) {
        System.out.println();
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 0, 0, 3, 4, 0, 5, 6, 0, 0, 7};
        Q2_PushZeros.pushZeros(array);
        printArray(array);
    }
}
