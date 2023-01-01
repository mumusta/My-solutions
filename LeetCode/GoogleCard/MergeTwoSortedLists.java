package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 28/08/2022
 **/

public class MergeTwoSortedLists {

    private class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = null, current = null;

        while (list1 != null || list2 != null){

            int val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;

            if (list1 != null){

                val1 = list1.val;
            }

            if (list2 != null){

                val2 = list2.val;
            }

            if (result == null){

                if (val1 <= val2){

                    current = list1;
                    list1 = list1.next;
                }

                else {

                    current = list2;
                    list2 = list2.next;
                }


                result = current;
            }

            else {

                if (val1 <= val2){

                    current.next = list1;
                    list1 = list1.next;
                    current = current.next;
                }

                else {

                    current.next = list2;
                    list2 = list2.next;
                    current = current.next;
                }
            }
        }

        return result;
    }
}
