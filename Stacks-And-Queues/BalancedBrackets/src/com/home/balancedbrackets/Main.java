package com.home.balancedbrackets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/output.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

/*
Whenever we get opening braces we put in stack and when we get closing braces we pop from the stack and if that is NOT corresponding opening braces we will return NO

 */

    private static String isBalanced(String s) {

        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else{

                if (stack.isEmpty())
                    return "NO";

                char closingBracket = s.charAt(i);
                char  openingBracket = 'a';

                switch (closingBracket){
                    case ')':
                        openingBracket = '(';
                        break;
                    case '}':
                        openingBracket = '{';
                        break;
                    case ']':
                        openingBracket = '[';
                        break;
                }

                if (stack.pop() != openingBracket)
                    return "NO";
            }
        }

        if (!stack.isEmpty())
            return  "NO";

        return "YES";
    }

    private static String isBalancedAlternativeSolution(String s) {

        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else{

                if (stack.isEmpty()){
                    return "NO";
                }
                else {
                    char pop_val = stack.pop();
                    if (s.charAt(i) == ')' && pop_val != '('){
                        return "NO";
                    }
                    else if (s.charAt(i) == '}' && pop_val != '{'){
                        return "NO";
                    }
                    else if (s.charAt(i) == ']' && pop_val != '['){
                        return "NO";
                    }
                }

            }
        }

        if (!stack.isEmpty())
            return  "NO";

        return "YES";
    }
}
