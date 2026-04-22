package com.day8.bst;

import java.util.Stack;

class BSTNode {
 int element;
 BSTNode leftChild;
 BSTNode rightChild;

 public BSTNode(int element) {
     this.element = element;
     this.leftChild = null;
     this.rightChild = null;
 }
}

public class InorderBST {

 public static void inorderTraversal(BSTNode root) {
     Stack<BSTNode> stack = new Stack<>();
     BSTNode current = root;
     while (current != null || !stack.isEmpty()) {
         while (current != null) {
             stack.push(current);
             current = current.leftChild;
         }
         current = stack.pop();
         System.out.print(current.element + " ");

         current = current.rightChild;
     }
 }

 public static void main(String[] args) {

     BSTNode root = new BSTNode(10);
     root.leftChild = new BSTNode(5);
     root.rightChild = new BSTNode(15);
     root.leftChild.leftChild = new BSTNode(2);
     root.leftChild.rightChild = new BSTNode(7);
     root.rightChild.rightChild = new BSTNode(20);

     System.out.print("Inorder Traversal: ");
     inorderTraversal(root);
 }
}