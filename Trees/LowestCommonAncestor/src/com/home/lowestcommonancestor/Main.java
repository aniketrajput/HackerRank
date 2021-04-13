package com.home.lowestcommonancestor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        Node<Integer> root = null;

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int data = scanner.nextInt();
            root = bst.insert(data);
        }

        bst.traverse();

        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();

        scanner.close();

        Node<Integer> ans = bst.lowestCommonAncestor(root, v1, v2);
        System.out.println(ans.data);
    }
}
