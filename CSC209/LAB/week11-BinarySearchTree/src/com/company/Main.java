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
        tree.insert(200);

        tree.search(93);
        tree.search(110);
        tree.search(35);

        System.out.print("Inorder: ");
        tree.inorderTraversalResursion(tree.root);
        System.out.print("\nPreorder: ");
        tree.preorderTraversalResursion(tree.root);
        System.out.print("\nPostorder: ");
        tree.postorderTraversalResursion(tree.root);
        System.out.print("\nBreathFirst: ");
        tree.breathFirstTraversal(tree.root);

        System.out.println("\n\nBefore delete 100: " + tree.root.right.info);
        tree.deleteByMerging(100);
        System.out.println("After delete 100: " +tree.root.right.info);
        System.out.println(tree.root.right.right.right.right.right.info);

    }
}
