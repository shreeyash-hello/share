package com.day9.pluto;

public interface AbstractLL<T> {
	
	public T getData();
	public Node<T> getStart();
	public Node<T> getNext();
	public Node<T> getLast();
	public Node<T> getCurr();
	public Node<T> getPrev();

}