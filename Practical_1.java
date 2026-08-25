// 1. Write a program to determine whether the given number is Prime or not.

import java.util.Scanner;

public class Practical_1 // PrimeNumber
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        boolean isPrime = true;

        if (n <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println(n + " is a Prime Number.");
        } else {
            System.out.println(n + " is Not a Prime Number.");
        }

        sc.close();
    }
}