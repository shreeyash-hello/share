package com.day3.LL;

public class SinglyLL implements LinkedList{
	class Node {
		int data;
		Node next;
	}
	
	private Node start;
	private Node end;
	
	public SinglyLL(){
		start = null;
		end = null;
	}

	@Override
	public void addAtFront(int element) {
	    Node newNode = new Node();
	    newNode.data = element;
	    newNode.next = null;

	    if(start == null) {
	        start = end = newNode;
	    } else {
	        newNode.next = start;
	        start = newNode;
	    }
	}

	@Override
	public void addAtEnd(int element) {
	    Node newNode = new Node();
	    newNode.data = element;
	    newNode.next = null;

	    if(start == null) {
	        start = end = newNode;
	        return;
	    }

	    end.next = newNode;
	    end = newNode;
	}

	@Override
	public int deleteFirstNode() {
	    if (start == null) {
	        return -1;
	    }
	    int value = start.data;
	    start = start.next;
	    if (start == null) {
	        end = null;
	    }
	    return value;
	}

	@Override
	public boolean isEmpty() {
	    return start == null;
	}

	@Override
	public void print() {
	    Node current = start;
	    while (current != null) {
	        System.out.print(current.data + " -> ");
	        current = current.next;
	    }
	    System.out.print("null");
	}
	
	public int showFirst() {
		return start.data;
	}
	
	
}