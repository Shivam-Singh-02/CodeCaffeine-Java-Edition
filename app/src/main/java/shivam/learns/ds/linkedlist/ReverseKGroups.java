package shivam.learns.ds.linkedlist;

public class ReverseKGroups {
    Node head;
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node head = linkedList.push(5);
//        System.out.println("Initial LL");
//        linkedList.print(head);

        ReverseKGroups reverseKGroups = new ReverseKGroups();

        Node temp = head;
        Node prev = null;
        Node kthNode = null;
        while(temp != null ){
            kthNode = reverseKGroups.getKthNode(temp, 2);
            if(kthNode != null) {
                Node next = kthNode.next;
                kthNode.next = null;
                reverseKGroups.reverse(temp);
                if (temp == head) {
                    head = kthNode;
                } else {
                    prev.next = kthNode;
                }
                prev = temp;
                temp = next;
            }else {
                prev.next = temp;
                temp = null;
            }
        }
        System.out.println("Final LL");
        linkedList.print(head);

    }

    public Node getKthNode(Node head, int k) {
        while(k-- > 1){
            head = head.next;
        }
        return head;
    }

    public Node reverse(Node head) {
        if(head.next == null)
            return head;

        Node rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
}
