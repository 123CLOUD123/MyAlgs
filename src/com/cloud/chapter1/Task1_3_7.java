package com.cloud.chapter1;
import java.util.Iterator;

public class Task1_3_7 {

	public static void main(String[] args) {
		MyStack<String> s = new MyStack<String>();
		s.push("test");
		String s1 = s.peek();
		String s2 = s.peek();
		System.out.println(s1 + "---" + s2);
	}
	
}




/**
 * 链表实现堆栈
 * @author Cloud
 *
 * @param <Item>
 */
class MyStack<Item> implements Iterable<Item> {
	
	private Node first;
	
	private class Node {
		Node last;
		Item item;
		Node(Node last, Item item) {
			this.last = last;
			this.item = item;
		}
	}
	
	public void push(Item item) {
		Node node = new Node(first, item);
		first = node;
	}
	
	public Item pop() {
		if (first == null) {
			return null;
		}
		Item item = first.item;
		first = first.last;
		return item;
	}
	
	public Item peek() {
		return first.item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node node = first;

			@Override
			public boolean hasNext() {
				return node != null;
			}

			@Override
			public Item next() {
				Item item = node.item;
				node = node.last;
				return item;
			}
			
		};
	}
	
	
	
}

