package com.day7.bst;

class BST {

    BTNode root;

    BTNode insert(BTNode root, int element) {
        if (root == null)
            return new BTNode(element);

        if (element < root.data)
            root.leftChild = insert(root.leftChild, element);
        else if (element > root.data)
            root.rightChild = insert(root.rightChild, element);

        return root;
    }

    int height(BTNode root) {
        if (root == null)
            return -1;

        int left = height(root.leftChild);
        int right = height(root.rightChild);

        return Math.max(left, right) + 1;
    }

    int findSmallest(BTNode root) {
        if (root == null)
            throw new RuntimeException("Tree is empty");

        BTNode current = root;
        while (current.leftChild != null) {
            current = current.leftChild;
        }
        return current.data;
    }

    int findLargest(BTNode root) {
        if (root == null)
            throw new RuntimeException("Tree is empty");

        BTNode current = root;

        while (current.rightChild != null) {
            current = current.rightChild;
        }

        return current.data;
    }

    BTNode findMax(BTNode root) {
        while (root.rightChild != null) {
            root = root.rightChild;
        }
        return root;
    }

    BTNode delete(BTNode root, int key) {
        if (root == null)
            return null;

        if (key < root.data) {
            root.leftChild = delete(root.leftChild, key);
        } else if (key > root.data) {
            root.rightChild = delete(root.rightChild, key);
        } else {
            if (root.leftChild == null && root.rightChild == null) {
                return null;
            }
            else if (root.leftChild == null) {
                return root.rightChild;
            } else if (root.rightChild == null) {
                return root.leftChild;
            }
            else {
                BTNode pred = findMax(root.leftChild);
                root.data = pred.data;
                root.leftChild = delete(root.leftChild, pred.data);
            }
        }
        return root;
    }

    void inorder(BTNode root) {
        if (root != null) {
            inorder(root.leftChild);
            System.out.print(root.data + " ");
            inorder(root.rightChild);
        }
    }
}
