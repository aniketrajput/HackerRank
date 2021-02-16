package com.home.jumpingontheclouds;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\inarajp\\Desktop\\temp\\HackerRank\\Warm-Up-Challenges\\JumpingOnTheClouds\\output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int arr[] = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int i = 0; i < arrItems.length; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = jumpingOnClouds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }

    private static int jumpingOnClouds(int[] arr) {

        int noOfJumps = 0;
        int i = 0;

        while (i < arr.length - 1) {

            if (i + 2 == arr.length || arr[i + 2] == 1) {
                i++;
                noOfJumps++;
            }else {
                i = i + 2;
                noOfJumps++;
            }
        }

        return noOfJumps;
    }
}
