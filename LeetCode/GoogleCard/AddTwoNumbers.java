package com.mumusta.googlecard;

/**
 * Author: Muhammad Mustafa
 * Email: mumusta3.14@gmail.com
 * Created: 28/08/2022
 **/

public class AddTwoNumbers {

    private class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null, toReturn = null;
        int carry = 0, iteration = 0;

        while (l1 != null || l2 != null){

            if (iteration == 0){
                result = new ListNode();
                toReturn = result;
            }

            else {
                result.next = new ListNode();
                result = result.next;
            }

            iteration++;

            int  left = 0, right = 0;

            if (l1 != null){
                left = l1.val;
            }

            if (l2 != null){
                right = l2.val;
            }

            left += (right + carry);


            result.val = left % 10;
            carry = left / 10;

            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        if (carry > 0){
            result.next = new ListNode(carry);
        }


        return toReturn;
    }
}
