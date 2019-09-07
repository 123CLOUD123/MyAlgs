package MyDataStructure;

import java.util.Iterator;

public class MyQueue<Item> implements Iterable<Item> {

	private Node first;
	
	private Node last;
	
	private int size;
	
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
	
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			q.enqueue(i);
		}
		for (Integer i : q) {
			System.out.println(i);
		}
		int i = q.deQueue();
		System.out.println(i);
	}
	
}
