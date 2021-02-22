package com.home.leftrotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\inarajp\\Desktop\\temp\\HackerRank\\Arrays\\ArraysLeftRotation\\output"));

        String [] nd = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);

        int a[] = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1){
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }

    private static int[] rotLeft(int[] a, int d) {

        int temp[] = new int[a.length];

        if (d > a.length) {
            while (d > a.length) {
                d = d - a.length;
            }
        }

        int j = 0;
        for (int i = d; i < a.length; i++, j++) {
            temp[j] = a[i];
        }

        for (int i = 0; i < d; i++,j++) {
            temp[j] = a[i];
        }

        return  temp;
    }
}
