package org.javacourse;

import java.util.Scanner;

public class Calculator {

    public static void Calc() {
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            Menu();
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Result = " + Add(firstNumber(), lastNumber()));
                    break;
                case 2:
                    System.out.println("Result = " + Subtract(firstNumber(),lastNumber()));
                    break;
                case 3:
                    System.out.println("Result = " + Multiply(firstNumber(), lastNumber()));
                    break;
                case 4:
                    System.out.println("Result = " + Divide(firstNumber(), lastNumber()));
                    break;
                case 5:
                    System.out.println("Bye! Bye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);
    }

    public static void Menu() {
        System.out.println("------------Calculator------------");
        System.out.println("Options:");
        System.out.println("[1] Addition");
        System.out.println("[2] Subtraction");
        System.out.println("[3] Multiplication");
        System.out.println("[4] Division");
        System.out.println("[5] Exit Calculator");
        System.out.print("Input: ");
    }

    public static int Add(int a, int b) {
        return a + b;
    }

    public static int Subtract(int a, int b) {
        return a - b;
    }

    public static int Multiply(int a, int b) {
        return a * b;
    }

    public static int Divide(int a, int b) {
        return a / b;
    }

    public static int firstNumber() {
        Scanner scan = new Scanner(System.in);
        int number;
        System.out.print("Input a first number = ");
        number = scan.nextInt();
        return number;
    }
    public static int lastNumber() {
        Scanner scan = new Scanner(System.in);
        int number;
        System.out.print("Input a last number = ");
        number = scan.nextInt();
        return number;
    }
}
