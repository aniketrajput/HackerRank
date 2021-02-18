package com.home.countswaps;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    static int swapCount = 0;

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int a[] = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrItems.length; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            a[i] = arrItem;
        }

        countSwaps(a);

        scanner.close();
    }

    private static void countSwaps(int[] a) {

        for (int lastUnsortedIndex = a.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            for (int i = 0; i < lastUnsortedIndex; i++) {

                if (a[i] > a[i+1]) {
                    swap(a, i, i+1);
                }
            }
        }

        System.out.println("Array is sorted in " + swapCount + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }

    private static void swap(int[] a, int i, int j) {

        swapCount++;

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
















