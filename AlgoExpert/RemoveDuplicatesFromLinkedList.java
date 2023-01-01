package com.mumusta.algoexpert;

public class RemoveDuplicatesFromLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {

        LinkedList left = linkedList, right = left.next;

        while (right != null){

            if (left.value == right.value){

                right = right.next;
            }

            else {

                left.next = right;
                left = left.next;
                right = right.next;
            }
        }

        left.next = null;

        return linkedList;
    }
}
