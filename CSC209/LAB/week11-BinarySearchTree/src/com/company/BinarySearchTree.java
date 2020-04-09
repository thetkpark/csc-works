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
}
