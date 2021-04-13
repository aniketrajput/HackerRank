package com.home.queueusingtwostacks;

import java.util.Scanner;
import java.util.Stack;

class MyQueue<T> {

    Stack<T> inputStack = new Stack<>();
    Stack<T> outputStack = new Stack<>();

    public void enqueue(T item) {
        inputStack.push(item);
    }

    public void dequeue() {

        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        outputStack.pop();
    }

    public T peek() {

        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }

        return outputStack.peek();
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MyQueue<Integer> queue = new MyQueue<Integer>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {

            int operation = scanner.nextInt();

            if (operation == 1) {   //enqueue
                queue.enqueue(scanner.nextInt());
            } else if (operation == 2) {    //dequeue
                queue.dequeue();
            }else { //peek or print
                System.out.println(queue.peek());
            }
        }
    }
}
