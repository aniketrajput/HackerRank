package com.home.repeatedstring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\inarajp\\Desktop\\temp\\HackerRank\\Warm-Up-Challenges\\RepeatedString\\output.txt"));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }

    private static long repeatedString(String s, long n){

        long acount = 0;
        long q = 0;
        long r = 0;
        int len = s.length();
        long substrlen = 0;

        q = n / len;
        r = n % len;

        substrlen = r == 0 ? 0 : r;

        acount = q * getCharCount(s, s.length()) + getCharCount(s, substrlen);

        return  acount;
    }

    private static long getCharCount(String s, long len) {
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        return count;
    }

    /*

    private static long repeatedString(String s, long n) {

        long i = 0;
        int j = 0;
        long count = 0;

        while (i < n) {

            if (s.charAt(j) == 'a') {
                count++;
            }

            if (j == s.length() - 1) {
                j = 0;
            }else {
                j++;
            }

            i++;
        }

        return count;
    }

    private  static long optimizedRepeatedString1(String s, long n){

        long aCount = 0;
        int i = 0;
        long result = 0;

        while(i < s.length()){
            if (s.charAt(i) == 'a')
                aCount++;

            i++;
        }

        while (n != 0) {

            if (n - s.length() >= 0) {
                result = result + aCount;
                n = n - s.length();
            }else {
                int j = 0;

                while(j < n){
                    if(s.charAt(j) == 'a'){
                        result = result + 1;
                    }
                    j++;
                }

                n = 0;
            }
        }

        return result;
    }

*/
}
