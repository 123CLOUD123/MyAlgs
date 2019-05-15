package com.cloud.test;

import java.util.Iterator;

/**
 * 链表实现的堆栈
 * @author Cloud
 *
 * @param <T>
 */
public class LinkedContainer<T> implements Iterable<T> {

	private class Node<T> {
		T t;
		Node node;
	}
	
	private Node first;
	
	public void push(T t) {
		Node oldNode = first;
		first = new Node();
		first.t = t;
		first.node = oldNode;
	}
	
	public T pop() {
		Node top = first;
		first = first.node;
		return (T) top.t;
	}
	
	public static void main(String [] args) {
		LinkedContainer<String> s = new LinkedContainer<>();
		s.push("Zhang");
		s.push("Hao");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

	//添加迭代功能
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
