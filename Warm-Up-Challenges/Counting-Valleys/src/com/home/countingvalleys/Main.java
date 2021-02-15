package com.home.countingvalleys;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\inarajp\\Desktop\\temp\\HackerRank\\Warm-Up-Challenges\\Counting-Valleys\\output.txt"));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int valleyCount = countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(valleyCount));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int countingValleys(int steps, String path) {

        int valleyCount = 0;
        int mountainCount = 0;
        int slope = 0;
        int hill = 0;

        for (int i = 0; i < path.length(); i++) {

            if (path.charAt(i) == 'D')
                slope++;
            else
                hill++;

            if (slope == hill && path.charAt(i) == 'U') {
                valleyCount++;
            }else {
                mountainCount++;
            }
        }

        return valleyCount;
    }
}


/*
* Alternate Solution
*
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        String s = in.next();

        int level = 0;
        int valleys = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'U'){
                level++;
            }else if(s.charAt(i) == 'D'){
                if(level == 0){
                    valleys++;
                }
                level--;
            }
        }
        System.out.println(valleys);
    }
}
*
* */
