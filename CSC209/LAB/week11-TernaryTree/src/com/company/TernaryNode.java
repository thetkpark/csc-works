package com.company;

public class TernaryNode {
    int info;
    TernaryNode left, mid, right;

    public TernaryNode(int info) {
        this(info, null, null, null);
    }

    public TernaryNode(int info, TernaryNode left, TernaryNode mid, TernaryNode right) {
        this.info = info;
        this.left = left;
        this.mid = mid;
        this.right = right;
    }
}
