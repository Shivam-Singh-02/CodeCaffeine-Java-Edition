package shivam.learns.ds.linkedlist;

class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}

public class LinkedList {

    Node push(int n) {
        Node head = null;
        Node temp = null;
        int count = 1;
        while(count<=n){
            if(head == null) {
                head = new Node(count++);
                temp = head;
            }
            else{
                temp.next = new Node(count++);
                temp = temp.next;
            }
        }
        return head;
    }

    void print(Node temp){
        while(temp!=null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    void printR(Node temp){
        if(temp == null)
            return;
        System.out.println(temp.val);
        printR(temp.next);
    }

}
