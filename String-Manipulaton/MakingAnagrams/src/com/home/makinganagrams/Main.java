package com.home.makinganagrams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\inarajp\\Desktop\\temp\\HackerRank\\String-Manipulaton\\MakingAnagrams\\output.txt"));

        String a = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }

    private static int makeAnagram(String a, String b) {
        int count = 0;
        int[] arA = new int[26];
        int[] arB = new int[26];

        for (int i = 0; i < a.length(); i++) {
            arA[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            arB[b.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {

            count = count + Math.abs(arA[i] - arB[i]);
        }

        return count;
    }
}
