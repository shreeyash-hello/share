package com.day7.bst;

public class BSTMain {

    public static void main(String[] args) {

        BST tree = new BST();

        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        System.out.print("Inorder: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.println("Height: " + tree.height(tree.root));

        System.out.println("Smallest: " + tree.findSmallest(tree.root));

        System.out.println("Largest: " + tree.findLargest(tree.root));

        tree.root = tree.delete(tree.root, 50);

        System.out.print("Inorder after deletion: ");
        tree.inorder(tree.root);
        System.out.println();
    }
}