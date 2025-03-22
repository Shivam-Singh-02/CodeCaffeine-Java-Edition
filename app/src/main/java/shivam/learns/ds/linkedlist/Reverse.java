package shivam.learns.ds.linkedlist;




public class Reverse {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node head = null;
        head = linkedList.push(5);
        Reverse reverse = new Reverse();
        head = reverse.reverseR(head);
        linkedList.printR(head);

    }




    Node reverse(Node head){
        //1->2->3->4->5
        if(head == null || head.next == null)
            return head;

        Node current = head;
        Node prev = null;

        while(current != null){
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;

    }


    Node reverseR(Node head){
        if(head.next == null) {
            return head;
        }

        Node rest = reverseR(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

}
