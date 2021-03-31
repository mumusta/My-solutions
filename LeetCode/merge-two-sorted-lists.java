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
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if ((l1 == null) && (l2 == null))
            return null;

        ListNode res = new ListNode(); ListNode curr = res;
        
        while ((l1 != null) || (l2 != null)){

            int minima = 1000, who = 0;

            if ((l1 != null) && (l1.val < minima)){

                minima = l1.val; who = 1;
            }

            if ((l2 != null) && (l2.val < minima)){

                minima = l2.val; who = 2;
            }

            if (who == 1)
                l1 = l1.next;

            if (who == 2)
                l2 = l2.next;

            if ((l1 == null) && (l2 == null))
                curr.val = minima;

            else {

                curr.val = minima;
                curr.next = new ListNode();
                curr = curr.next;
            }
        }

        return res;
    }
}
