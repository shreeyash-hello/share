package com.day9.pluto;


public class Node<T> {

	T data;
	
	Node<T> previous;
	Node<T> next;
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node(T temp) {
		data = temp;
	}
	
}
