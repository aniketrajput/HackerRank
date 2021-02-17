package com.home.twodarraysds;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\inarajp\\Desktop\\temp\\HackerRank\\Warm-Up-Challenges\\2DArrayDS\\output.txt"));

        int arr[][] = new int[6][6];

        for (int i = 0; i < 6; i++) {

            String arrRowItems[] = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrRowItem = Integer.parseInt(arrRowItems[i]);
                arr[i][j] = arrRowItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }

    private static int hourglassSum(int[][] arr) {

        int largestSum = -1000;

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                int sum = 0;

                sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                if (sum > largestSum){
                    largestSum = sum;
                }
            }
        }

        return largestSum;
    }
}




























