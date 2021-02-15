package com.home.salesbymatch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\inarajp\\Desktop\\temp\\HackerRank\\Warm-Up-Challenges\\Sales-By-Match\\output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ar[] = new int[n];
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int numberOfPairs = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(numberOfPairs));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    private static int sockMerchant(int n, int[] ar) {

        int pairCount = 0;

        for (int i = 0; i < n; i++) {

            if(ar[i] == 0 )
                continue;

            for (int j = i+1; j < n; j++) {

                if (ar[i] == ar[j]) {
                    pairCount++;
                    ar[i] = ar[j] = 0;
                    break;
                }
            }
        }

        return pairCount;
    }
}
