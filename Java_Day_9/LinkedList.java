package com.day9.pluto;

public class LinkedList<T> implements AbstractLL<T>{

	Node<T> start;
	Node<T> end;
	Node<T> current;
	int maxCount;
	
	
	public void add(T data) {
		Node<T> tempNode = new Node<>(data);
		
		if(start == null) {
			start = end = current = tempNode;
		}else {
			end.next = tempNode;
			tempNode.previous = end;
			end = tempNode;
		}
		maxCount++;
	}
	
	public void delete(int index) {
		if(start == null || index > maxCount) {
			return;
		}
		if(start == end) {
			start = end = current = null;
		}else if(index == 0) {
			start = start.next;
			start.previous = null;
		}else if(index == maxCount - 1) {
			end = end.previous;
			end.next = null;
		}else {
			Node tempNode = start;
			
			for(int i = 0; i < index; i++, tempNode = tempNode.next) {
				tempNode.previous.next = tempNode.next;
				tempNode.next.previous = tempNode.previous;
				
				tempNode = null;
			}
			maxCount--;
		}
	}

	@Override
	public Node<T> getStart() {
		if(start == null) {
			return null;
		}
		current = start;
		return current;
	}

	@Override
	public Node<T> getNext() {
		if(start == null || current == end) {
			return null;
		}
		current = current.next;
		return current;
		
	}

	@Override
	public T getData() {
		return current.data;
	}

	@Override
	public Node<T> getLast() {
		return end;
	}

	@Override
	public Node<T> getCurr() {
		return current;
	}

	@Override
	public Node<T> getPrev() {		
		return current.previous;
	}
	
	

	
}