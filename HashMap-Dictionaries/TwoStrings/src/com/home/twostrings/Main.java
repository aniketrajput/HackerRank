package com.home.twostrings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\inarajp\\Desktop\\temp\\HackerRank\\HashMap-Dictionaries\\TwoStrings\\outtput.txt"));

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < p; i++) {

            String s1 = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String s2 = scanner.nextLine();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = optimalTwoString(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }

    private static String optimalTwoString(String s1, String s2){

        Set<Character> s1Set = new HashSet <>();
        Set<Character> s2Set = new HashSet <>();

        for (Character c : s1.toCharArray()) {
            s1Set.add(c);
        }

        for (Character c : s2.toCharArray()) {
            s2Set.add(c);
        }

        s1Set.retainAll(s2Set);

        // store the set intersection in s1Set
        if (!s1Set.isEmpty())
            return "YES";

        return "NO";
    }

    private static String twoStrings(String s1, String s2) {

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            hashMap.put(s1.charAt(i), i);
        }

        for (int i = 0; i < s2.length(); i++) {
            if (hashMap.containsKey(s2.charAt(i))) {
                return "YES";
            }
        }

        return "NO";
    }
}

/*

Brute Force Method:
One easy way to solve this problem would be:

Find out all the sub-strings of first string.
Find out all the sub-strings of second string.
Once you have all the sub-strings, see if you can find any common sub-strings.
Output “YES” or “NO” based upon your findings.
Note that, this method works fine, but you will waste a lot of time in finding out all the valid sub-strings. So, we need to find a way to optimize it somehow.

Efficient Method:
There is a very big hint hidden in the problem statement itself. The problem says that the sub-string could be as small as one character. So, you do not need even need to find out all the sub-strings. If you can find a common character, that should be all.

So let us assume you are given with two strings:

str1 = “barbell”
str2 = “trapper”

An efficient way to solve this problem could be:

Add all the characters of str1 to setA. So, setA would look like
setA = < b, a, r, e, l >
Add all the characters of str2 to setB. So, setB would become
setB = < t, r, a, p, e >
Take an intersection of both the sets. An intersection should give you the common characters.
After the intersection, you will get the common characters as:
< a, r, e >
If you can find some characters after intersection, the result is “YES”, else “NO”.


Time Complexity: O(n)
     Here n is the length of longer string. We need to scan both the string and we will take maximum time equivalent to length of the longest string.

Space Complexity: O(1)
    This is because in the english alphabets we have only 26 characters so the set size can never exceed the 26, which is constant so O(1)

 */