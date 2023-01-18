package com.mumusta.algoexpert;

import java.util.ArrayList;

//Reconstruct BST
public class ReconstructBST {

    private int index = 0;

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    //Time: O(N) Memory: O(h)
    private void helper(BST currentNode, int greaterThanOrEqual, int smallerThan, ArrayList<Integer> list){

        if (index == list.size()) return;

        int number = list.get(index);

        if ((greaterThanOrEqual <= number) && (number < smallerThan) && (number < currentNode.value)){

            currentNode.left = new BST(number);     index ++;
            helper(currentNode.left, greaterThanOrEqual, currentNode.value, list);
        }

        if (index == list.size()) return;

        number = list.get(index);

        if ((greaterThanOrEqual <= number) && (number < smallerThan) && (number >= currentNode.value)){

            currentNode.right = new BST(number);     index ++;
            helper(currentNode.right, currentNode.value, smallerThan, list);
        }
    }


    //Time: O(N^2) Memory: O(h)
    private BST helper2(int left, int right, ArrayList<Integer> list){

        if ((left > right) || (left < 0) || (right >= list.size())) return null;
        if (left == right) return new BST(list.get(left));

        int currentValue = list.get(left), firstGreaterIndex = right;

        BST result = new BST(currentValue);

        for (int i = left + 1; i <= right; i ++){

            int v = list.get(i);

            if (v >= currentValue){

                firstGreaterIndex = i;
                break;
            }
        }

        if (list.get(firstGreaterIndex) >= currentValue){

            result.left = helper2(left + 1, firstGreaterIndex - 1, list);
            result.right = helper2(firstGreaterIndex, right, list);
        }

        else {

            result.left = helper2(left + 1, right, list);
        }

        return result;
    }

    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {

        //My solution which run in O(N) so close to his second solution

//        BST root = new BST(preOrderTraversalValues.get(0));
//        index++;
//        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues);
//        return root;


        //His first solution which run in O(N^2)

        return helper2(0, preOrderTraversalValues.size() - 1, preOrderTraversalValues);
    }

    public static void main(String[] args) {

        ArrayList<Integer> x = new ArrayList<>();

        //x.add(10);x.add(4);x.add(2);x.add(1);x.add(5);x.add(17);x.add(19);x.add(18);
        x.add(3); x.add(3);

        new ReconstructBST().reconstructBst(x);
    }
}
