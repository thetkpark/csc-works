package com.company;

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
}
