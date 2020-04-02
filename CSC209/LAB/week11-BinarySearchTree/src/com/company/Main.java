package com.company;

public class Main {

    public static void main(String[] args) {
	    // BinarySearchTree 02/04/2020
        // Sethanant Pipatpakorn 62130500230
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(25);
        tree.insert(100);
        tree.insert(35);
        tree.insert(35);
        tree.insert(93);
        tree.insert(11);
        tree.insert(99);
        tree.insert(65);

        System.out.println(tree.root.right.left.right.right.info);
        System.out.println(tree.root.left.info);

        tree.insert(24);
        tree.insert(20);
        tree.insert(15);
        tree.insert(10);

        tree.search(93);
        tree.search(110);
        tree.search(35);
    }
}
