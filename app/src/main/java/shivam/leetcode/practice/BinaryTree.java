package shivam.leetcode.practice;

/*
Binary tree is a special type of tree where each node has at most two children.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node {
    public Node left;
    public Node right;
    int val;
    public  Node() {

    }
    public Node(int val) {
        this.val = val;
        left = right = null;
    }
    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTree {
    Node root;
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        printTreeInOrder(root);
    }

    private static void printTreeInOrder(Node root) {
        if(root == null)
            return;
        printTreeInOrder(root.left);
        System.out.println(root.val);
        printTreeInOrder(root.right);
    }

    public BinaryTree() {
        root = null;
    }
    //Function to construct binary tree from parent array.
    public static Node createTree(int ar[], int N) {
        //Your code here
        Map<Integer, Node> hm = new HashMap();
        Node root = null;
        for(int i=0 ;i<N; i++){
            if(ar[i] == -1){
                root = new Node(i);
                hm.put(i, root);
            }
            else
                hm.put(i,  new Node(i));
        }

        for(int i=0 ;i<N; i++){
            if(ar[i] != -1){
                Node temp = hm.get(ar[i]);
                if(temp.left == null)
                    temp.left = hm.get(i);
                else
                    temp.right = hm.get(i);
            }
        }
        return root;
    }

    public static Node createTree() {

        Node root = null;
        int val;
        System.out.println("Enter val - ");
        val = sc.nextInt();
        if(val == -1)
            return null;
        root = new Node(val);
        System.out.println("Enter left val of "+val+" - ");
        root.left = createTree();
        System.out.println("Enter right val of "+val+" - ");
        root.right = createTree();

        return root;
    }
}
