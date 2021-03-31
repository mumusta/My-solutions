/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ArrayList <ListNode> seq = new ArrayList <ListNode>(); 

        do {
            seq.add(head);
            head = head.next;
        } while(head != null);

        if (seq.size() == 1)
            return null;

        n = seq.size() - n;

        if (n == 0) return seq.get(1);
        else if (n == (seq.size() - 1)) seq.get(n - 1).next = null;
        else seq.get(n - 1).next = seq.get(n).next;

        return seq.get(0);
    }
}
