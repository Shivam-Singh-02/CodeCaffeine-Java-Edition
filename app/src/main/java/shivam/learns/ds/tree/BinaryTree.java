package shivam.learns.ds.tree;

/*
Binary tree is a special type of tree where each node has at most two children.
 */

import shivam.learns.ds.Node;

import java.util.*;

public class BinaryTree {
    Node root;
    static Scanner sc;

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
                if(temp.getLeft() == null)
                    temp.setLeft(hm.get(i));
                else
                    temp.setRight(hm.get(i));
            }
        }
        return root;
    }

    public static Node createTree() {

        Node root;
        int val;
        System.out.println("Enter val - ");
        val = sc.nextInt();
        if(val == -1)
            return null;
        root = new Node(val);
        System.out.println("Enter left val of "+val+" - ");
        root.setLeft(createTree());
        System.out.println("Enter right val of "+val+" - ");
        root.setRight(createTree());
        return root;
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();
        System.out.println("Printing the tree in PreOrder traversal");
        printTreePreOrder(root);
        System.out.println();
        System.out.println("Printing the tree in PreOrder traversal");
        printTreeInOrder(root);
        System.out.println();
        System.out.println("Printing the tree in PreOrder traversal");
        printTreePostOrder(root);
        System.out.println();
        System.out.println("Printing the tree in Level order traversal");
        printTreeLevelOrder(root);

    }

    private static void printTreePreOrder(Node root) {
        if(root == null)
            return;
        System.out.print(root.getVal()+" ");
        printTreePreOrder(root.getLeft());
        printTreePreOrder(root.getRight());
    }
    private static void printTreeInOrder(Node root) {
        if(root == null)
            return;
        printTreeInOrder(root.getLeft());
        System.out.print(root.getVal()+" ");
        printTreeInOrder(root.getRight());
    }

    private static void printTreePostOrder(Node root) {
        if(root == null)
            return;
        printTreePostOrder(root.getLeft());
        printTreePostOrder(root.getRight());
        System.out.print(root.getVal()+" ");
    }

    static Queue<Node> queue = new ArrayDeque<>();

    private static void printTreeLevelOrder(Node root) {
        if(root == null)
            return;
        System.out.println(root.getVal()+" ");
        if(root.getLeft() != null)
            queue.add(root.getLeft());
        if(root.getRight() != null)
            queue.add(root.getRight());
        while(!queue.isEmpty()){
            Node node = queue.poll();
            printTreeLevelOrder(node);
        }
    }
}
