package com.company;

public class Main {

    public static void main(String[] args) {
	// Sethanant Pipatpakorn 62130500230
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(50);
        tree.insert(70);
        tree.insert(10);
        tree.insert(1);
        tree.insert(18);
        tree.insert(110);
        tree.insert(26);
        tree.insert(15);
        tree.insert(19);
        tree.insert(34);
        tree.insert(200);
        tree.insert(48);

        System.out.println(tree.countNode());
        System.out.println(tree.countLeaves());
        System.out.println(tree.getRightChild());
        System.out.println(tree.getHeight());
    }
}
