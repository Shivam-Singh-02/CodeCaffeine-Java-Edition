package shivam.practice.leetcode;

import java.util.ArrayList;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class RemoveNodesFromLL {

    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> li = new ArrayList<>();
        ListNode temp = head;
        ArrayList<Integer> list = new ArrayList();
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        System.out.println(list);
        for(int i=list.size()-2; i>=0; i--){
            if(list.get(i) < list.get(i+1))
                list.remove(list.get(i));
        }
        return head;
    }
}
