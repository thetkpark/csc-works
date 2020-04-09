package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public int countNode(){
        if(this.root == null) return 0;
        //Breath-first
        Queue<Node> q = new LinkedList<>();
        int count = 0;
        q.add(this.root);
        while(!q.isEmpty()){
            Node p = q.poll();
            count++;
            if(p.left != null) q.add(p.left);
            if(p.right != null) q.add(p.right);
        }
        return count;
    }

    public int countLeaves(){
        if(this.root == null) return 0;
        //Breath-first
        Queue<Node> q = new LinkedList<>();
        int count = 0;
        q.add(this.root);
        while(!q.isEmpty()){
            Node p = q.poll();
            if(p.left != null) q.add(p.left);
            if(p.right != null) q.add(p.right);
            if(p.left == null && p.right == null) count++;
        }
        return count;
    }

    public int getRightChild(){
        if(this.root == null) return 0;
        Stack<Node> stack = new Stack<>();
        int count = 0;
        stack.push(this.root);
        while(!stack.isEmpty()){
            Node p = stack.pop();
            if(p.right != null) stack.push(p.right);
            if(p.left != null) stack.push(p.left);
            if(p.right != null) count++;
        }
        return count;
    }

    public int getHeight(){
        if(this.root == null) return 0;
        int height = 0;
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> h = new LinkedList<>();
        q.add(this.root);
        h.add(1);
        while(!q.isEmpty()){
            Node p = q.poll();
            int currentHeight = h.poll();
            height = currentHeight;
            if(p.left != null){
                q.add(p.left);
                h.add(currentHeight+1);
            }
            if(p.right != null){
                q.add(p.right);
                h.add(currentHeight+1);
            }
        }
        return height;
    }
}
