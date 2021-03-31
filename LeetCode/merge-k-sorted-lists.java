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
    
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue < ListNode > pq = new PriorityQueue< ListNode >(new Comparator< ListNode >(){
            @Override
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });

        for (int i = 0; i < lists.length; i ++)
            if (lists[i] != null) pq.add(lists[i]);

        if (pq.isEmpty())
            return null;

        ListNode res = new ListNode(); ListNode curr = res;
        
        while (!pq.isEmpty()){

            ListNode peek = pq.poll();

            curr.val = peek.val;

            if (peek.next != null)
                pq.add(peek.next);

            if (!pq.isEmpty()){

                curr.next = new ListNode();
                curr = curr.next;
            }
        }

        return res;
    }
}
