package shivam.learns.ds;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node {
    Node left;
    Node right;
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
