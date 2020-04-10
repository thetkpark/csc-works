package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int newInfo){
        if(this.root == null){
            this.root = new Node(newInfo); //Empty tree -> Root point to new node
            return;
        }
        Node p = this.root;
        while(p!=null) { //Start searching
            if (newInfo < p.info){ //Check if newInfo should go left or right
                if(p.left != null) p = p.left; //Not null -> Continue moving
                else {
                    p.left = new Node(newInfo); //If null -> the end -> Insert here
                    return;
                }
            }
            else { //The newInfo is > than the left -> Go right
                if(p.right != null) p = p.right; //Not null -> Continue moving
                else {
                    p.right = new Node(newInfo); //If null -> the end -> Insert here
                    return;
                }
            }
        }

    }

    public Node search(int el){
        Node p = this.root;
        while(p!=null){ //Keep searching if not null
            if(p.info == el){
                System.out.println(el + " is found");
                return p; //Found it return it
            }
            else if(el < p.info) p = p.left; //Move left
            else p = p.right; //Move right
        }
        System.out.println(el + " is not found");
        return null;
    }

    public void inorderTraversalResursion(Node p){
        if(p != null){
            inorderTraversalResursion(p.left); // Finish left first
            System.out.print(p.info + " "); // Visit node p
            inorderTraversalResursion(p.right); //Then do the right side
        }
    }

    public void preorderTraversalResursion(Node p){
        if(p != null){
            System.out.print(p.info + " "); // Visit node p
            preorderTraversalResursion(p.left);
            preorderTraversalResursion(p.right);
        }
    }

    public void postorderTraversalResursion(Node p){
        if(p != null){
            preorderTraversalResursion(p.left);
            preorderTraversalResursion(p.right);
            System.out.print(p.info + " "); // Visit node p
        }
    }

    public void breathFirstTraversal(Node p){
        if(p == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(p);
        while(!q.isEmpty()){
            Node node = q.poll();
            System.out.print(node.info + " ");
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
        }
    }

    public void deleteByMerging(int deleteValue){
        Node p = this.root;
        Node prev = null;
        while(p!= null && p.info != deleteValue){ //Searching for node to delete
            prev = p;
            if(deleteValue >= p.info) p = p.right;
            else p = p.left;
        }
        Node nodeForPrevToPointTo = p;
        if(p == null) return; //No node is found to delete

        //Node with no child
        if(p.right == null && p.left == null) nodeForPrevToPointTo = null;

        //Node with single child
        else if(p.right == null) nodeForPrevToPointTo = p.left;
        else if (p.left == null) nodeForPrevToPointTo = p.right;

        //Node with two children
        else {
            //Search for rightmost node of the left subtree
            Node temp = nodeForPrevToPointTo.left;
            while(temp != null){
                if(temp.right == null) break;
                temp = temp.right;
            }
            temp.right = p.right; //Move right subtree to be marge with the rightmost node of the left subtree
            nodeForPrevToPointTo = p.left; //Specify what prev should point to
        }

        //Re point the pointer of the parent's node
        if(p == this.root){
            this.root = nodeForPrevToPointTo;
        }
        else if(prev.left == p) prev.left = nodeForPrevToPointTo;
        else prev.right = nodeForPrevToPointTo;
    }

}
