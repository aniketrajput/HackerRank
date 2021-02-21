/*
Initial Thoughts: We can sort this array and then find the minimum
                  absolute value of the elements to the right of each
                  element, because they will always be smaller than
                  something further away, thus reducing the number
                  of comparisons we need to do

Time Complexity: O(n log n) //We only iterated n times, but it took n log n to sort the array
Space Complexity: O(1) //We can treat the input array as given, and we did our sort in place, so no addition space
*/

package com.home.minimumdifferencearray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\inarajp\\Desktop\\temp\\HackerRank\\Greedy-Algorithms\\MinimumAbsoluteDifferenceArray\\output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new  int[n];
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arrItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        scanner.close();
        bufferedWriter.close();
    }


    //Optimal solution
    private static int minimumAbsoluteDifference(int[] arr) {

        int minimum = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {

            int currentMin = Math.abs(arr[i] - arr[i+1]);

            minimum = Math.min(minimum, currentMin);
        }

        return minimum;
    }



/*
    private static int minimumAbsoluteDifference(int[] arr) {

        int result = 9999;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                if (i == j)
                    continue;

//                System.out.println("(" + arr[i] + ", " + arr[j] + ")");

                int value = Math.abs(arr[i] - arr[j]);

                if (result > value)
                    result = value;
            }
        }

        return result;
    }

*/

}
















