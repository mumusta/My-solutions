package com.mumusta.algoexpert;

public class BSTConstruction {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public static BST insert(BST currentNode, int value){

            if (currentNode == null) return new BST(value);

            if (value < currentNode.value)
                currentNode.left = insert(currentNode.left, value);

            else currentNode.right = insert(currentNode.right, value);

            return currentNode;
        }

        public BST insert(int value) {

            insert(this, value);
            return this;
        }

        public static boolean contains(BST currentNode, int value){

            if (currentNode == null) return false;
            if (currentNode.value == value) return true;

            return contains(currentNode.left, value) || contains(currentNode.right, value);
        }

        public boolean contains(int value) {

            return contains(this, value);
        }

        public static int minimumValueInSubTree(BST currentNode){

            if (currentNode == null) return Integer.MAX_VALUE;

            return Math.min(currentNode.value, minimumValueInSubTree(currentNode.left));
        }

        public static void remove(BST parent, boolean isRight, BST currentNode, int value){

            if (currentNode == null) return;

            if (currentNode.value == value){

                int count = (currentNode.left == null ? 0 : 1) + (currentNode.right == null ? 0 : 1);

                if (count == 0){

                    if (isRight){

                        parent.right = null;
                    }

                    else {

                        parent.left = null;
                    }
                }

                else if (count == 1){

                    if (currentNode.left != null){

                        if (parent == null){

                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        }

                        else {

                            if (isRight){

                                parent.right = currentNode.left;
                            }

                            else {

                                parent.left = currentNode.left;
                            }
                        }
                    }

                    else {

                        if (parent == null){

                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        }

                        else {

                            if (isRight){

                                parent.right = currentNode.right;
                            }

                            else {

                                parent.left = currentNode.right;
                            }
                        }
                    }
                }

                else {

                    int minimum = minimumValueInSubTree(currentNode.right);
                    currentNode.value = minimum;
                    remove(currentNode, true, currentNode.right, minimum);
                }
            }

            else {

                remove(currentNode, false, currentNode.left, value);
                remove(currentNode, true, currentNode.right, value);
            }
        }

        public BST remove(int value) {

            if ((this.left != null || this.right != null) && this.contains(value)){

                remove(null, false, this, value);
            }

            return this;
        }

        public static void print(BST currentNode){

            if (currentNode == null) return;

            print(currentNode.left);
            System.out.println(currentNode.value);
            print(currentNode.right);
        }
    }

    public static void main(String[] args) {

        BST root = new BST(10);
        root.insert(2);

        root.remove(10);


        BST.print(root);
    }
}
