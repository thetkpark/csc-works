package com.company;

public class Main {

    public static void main(String[] args) {
	    ThreeWayTree tree = new ThreeWayTree();
	    tree.root = new TernaryNode(50);

	    tree.root.left = new TernaryNode(31);
	    tree.root.mid = new TernaryNode(53);
        tree.root.right = new TernaryNode(87);

        tree.root.left.left = new TernaryNode(12);
        tree.root.left.mid = new TernaryNode(29);
        tree.root.left.right = new TernaryNode(43);

        System.out.println(tree.root.left.left.info);

        tree.root.left.right.left = new TernaryNode(33);
        tree.root.left.right.right = new TernaryNode(44);
        tree.root.left.right.right.left = new TernaryNode(43);
        tree.root.left.right.right.right = new TernaryNode(46);

        System.out.println(tree.root.left.right.right.left.info);
        System.out.println(tree.root.left.right.right.right.info);
    }
}
