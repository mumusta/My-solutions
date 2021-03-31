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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode curr = new ListNode(0); ListNode head = curr;
        boolean hasNext1 = true, hasNext2 = true;

        while (hasNext1 || hasNext2){

            if (hasNext1){

                curr.val += l1.val;

                if (l1.next == null)
                    hasNext1 = false;

                else l1 = l1.next;
            }

            if(hasNext2){

                curr.val += l2.val;

                if (l2.next == null)
                    hasNext2 = false;

                else l2 = l2.next;
            }

            if (curr.val > 9){

                curr.next = new ListNode(curr.val / 10);
                curr.val = curr.val % 10;
                curr = curr.next;
            }

            else {

                if (hasNext1 || hasNext2){

                    curr.next = new ListNode(0);
                    curr = curr.next;
                }
            }
        }

        return head;
    }
}
