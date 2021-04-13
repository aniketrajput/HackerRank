package com.home.lowestcommonancestor;

public class BinarySearchTree<T extends Comparable<T>> {

    Node<T> root = null;

    public Node<T> insert(T data){

        if (root == null){
            root = new Node<T>(data, null);
        }else {
            insert(root, data);
        }

        return root;
    }

    public void insert(Node<T> node, T data) {

        if (node.data.compareTo(data) > 0){        //go left

            if (node.getLeft() != null) {
                insert(node.getLeft(), data);
            }else {
                node.setLeft(new Node(data, node));
            }
        } else {                                    //go right
            if (node.getRight() != null){
                insert(node.getRight(), data);
            } else {
                node.setRight(new Node(data, node));
            }
        }
    }

    public void traverse(){
        if (root == null)
            return;

        traverse(root);
    }

    private void traverse(Node<T> node) {

        if (node.getLeft() != null)
            traverse(node.left);

        System.out.println(node.data);

        if (node.getRight() != null)
            traverse(node.right);
    }


    public Node<T> lowestCommonAncestor(Node<T> node, T v1, T v2) {

        if (node == null) {
            return null;
        }

        if (node.getData().compareTo(v1) == 0 || node.getData().compareTo(v2) == 0){
            return node;
        }

        Node left = lowestCommonAncestor(node.getLeft(), v1, v2);
        Node right = lowestCommonAncestor(node.getRight(), v1, v2);

        if (left != null && right != null){
            return node;
        }
        else{
            if (left == null && right != null){
                return right;
            }else if (left != null && right == null){
                return left;
            }else {
                return  null;
            }
        }
    }
}
