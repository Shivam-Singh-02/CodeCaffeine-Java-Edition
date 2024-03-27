package shivam.learns.ds.tree;

/*
Binary tree is a special type of tree where each node has at most two children.
 */

import shivam.learns.ds.Node;

import java.util.*;

class Tupple {
    public Node node;
    public int x,y;
    public Tupple(Node root, int x, int y){
        this.node = root;
        this.x = x;
        this.y = y;
    }
}

public class BinaryTree {
    Node root;
    static Scanner sc;
    static Queue<Node> queue = new ArrayDeque<>();

    static TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>>();


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
        preOrderTraversal(root);
        System.out.println();
        System.out.println("Printing the tree in PreOrder traversal");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("Printing the tree in PreOrder traversal");
        postOrderTraversal(root);
        System.out.println();
        System.out.println("Printing the tree in Level order traversal");
        levelOrderTraversalIterative(root);
        System.out.println();
        System.out.println("Printing Vertical Order - ");
        verticalOrderTraversal(root);

    }

    private static void preOrderTraversal(Node root) {
        if(root == null)
            return;
        System.out.print(root.getVal()+" ");
        preOrderTraversal(root.getLeft());
        preOrderTraversal(root.getRight());
    }
    private static void inOrderTraversal(Node root) {
        if(root == null)
            return;
        inOrderTraversal(root.getLeft());
        System.out.print(root.getVal()+" ");
        inOrderTraversal(root.getRight());
    }
    private static void postOrderTraversal(Node root) {
        if(root == null)
            return;
        postOrderTraversal(root.getLeft());
        postOrderTraversal(root.getRight());
        System.out.print(root.getVal()+" ");
    }
    private static void levelOrderTraversal(Node root) {
        if(root == null)
            return;
        queue.add(root);
        System.out.println(root.getVal()+" ");
        if(root.getLeft() != null)
            queue.add(root.getLeft());
        if(root.getRight() != null)
            queue.add(root.getRight());
        while(!queue.isEmpty()){
            Node node = queue.poll();
            levelOrderTraversalIterative(node);
        }
    }
    private static void levelOrderTraversalIterative(Node root) {
        Queue<Node> queue = new ArrayDeque();
        if(root == null)
            return;
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.getVal()+" ");
            if(node.getLeft() != null)
                queue.add(node.getLeft());
            if(node.getRight() != null)
                queue.add(node.getRight());
        }
    }
    private static void verticalOrderTraversal(Node root) {
        ArrayDeque<Tupple> queue = new ArrayDeque<>();
        if(root == null)
            return;
        queue.add(new Tupple(root, 0, 0));
        while(!queue.isEmpty()){
            Tupple tupple = queue.poll();
            if(!map.containsKey(tupple.x))
                map.put(tupple.x,new TreeMap<>());
            if(!map.get(tupple.x).containsKey(tupple.y))
                map.get(tupple.x).put(tupple.y,new PriorityQueue<>());
            map.get(tupple.x).get(tupple.y).offer(tupple.node.getVal());
            if(tupple.node.getLeft()!=null)
                queue.add(new Tupple(tupple.node.getLeft(),tupple.x-1,tupple.y+1));
            if(tupple.node.getRight()!=null)
                queue.add(new Tupple(tupple.node.getRight(),tupple.x+1,tupple.y+1));

        }
        List<List<Integer>> answer = new LinkedList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values() ){
            List<Integer> temp = new LinkedList<>();
            for(PriorityQueue<Integer> q : ys.values()){
                while(!q.isEmpty()){
                    System.out.println(q.peek());
                    temp.add(q.poll());
                }
                answer.add(temp);
            }
        }
    }
}
