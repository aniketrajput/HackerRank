package com.home.icecreamparlor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < t; i++) {

            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {

                int costItem = Integer.parseInt(costItems[j]);
                cost[j] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }

    private static void whatFlavors(int[] cost, int money) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < cost.length; i++) {
            int y = money - cost[i];

            if (hashMap.containsKey(y)) {
                System.out.println(hashMap.get(y) + 1  + " " + (i+1));
            }else {
                hashMap.put(cost[i], i);
            }
        }
    }
}
