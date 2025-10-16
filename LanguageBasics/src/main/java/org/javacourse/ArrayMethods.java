package org.javacourse;

import java.util.Random;
import java.util.Scanner;

public class ArrayMethods {
    public static void SearchAndCalcMaxArrayNumber(){
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the value of numbers in array = ");
        int arraySize = in.nextInt();
        System.out.print("Enter value are you searching(1-10) = ");
        int searchValue = in.nextInt();
        while (searchValue > 10 || searchValue < 1) {
            System.out.println("Invalid input");
            System.out.print("Enter value are you searching(1-10) = ");
            searchValue = in.nextInt();
        }

        int[] array = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(10);
        }
        outputArray(array);
        arraySearch(array, searchValue);
        System.out.println("The max number is " + findMax(array));
    }

    public static void arraySearch(int[] array, int searchValue) {
        for (int num : array) {
            if (num == searchValue) {
                System.out.println("Number " + num + " found");
                return;
            }
        }
        System.out.println(searchValue + " is not found");
    }

    public static int findMax(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    public static void outputArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.print("\n");
    }
}
