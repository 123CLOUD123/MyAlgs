package com.cloud.chapter1;

import java.util.Iterator;


public class Task1_3_41 {

	public static void main(String[] args) {
		MyQueue2<Integer> q1 = new MyQueue2<Integer>();
		for (int i = 0; i < 10; i++) {
			q1.enqueue(i);
		}
		MyQueue2<Integer> q2 = new MyQueue2<Integer>(q1);
		System.out.println(q2.deQueue());
	}
	
}


class MyQueue2<Item> implements Iterable<Item> {

	private Node first;
	
	private Node last;
	
	private int size;
	
	MyQueue2() {
	}
	
	MyQueue2(MyQueue2<Item> q) {
		MyQueue2<Item> cp = new MyQueue2<Item>();
		for (Item item : q) {
			cp.enqueue(item);
		}
		size = cp.size();
		first = cp.first;
		last = cp.last;
	}
	
	private class Node {
		Item item;
		Node next;
		Node(Item item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
	
	public void enqueue(Item item) {
		Node newFirst = new Node(item, null);
		
		if (size == 0) {
			last = first = newFirst;
		} else {
			first.next = newFirst;
			first = newFirst;
		}
		size++;
	}
	
	public Item deQueue() {
		if (last == null) {
			return null;
		}
		Item item = last.item;
		last = last.next;
		size--;
		return item;
	}
	
	public int size() {
		return size;
	}
	
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {

			private Node node = last;
			
			@Override
			public boolean hasNext() {
				return node != null;
			}

			@Override
			public Item next() {
				Item item = node.item;
				node = node.next;
				return item;
			}
			
		};
	}
	
}