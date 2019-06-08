package MyDataStructure;

import java.util.Iterator;

/**
 * 链表实现堆栈
 * @author Cloud
 *
 * @param <Item>
 */
public class MyStack<Item> implements Iterable<Item> {
	
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
	
	public static void main(String[] args) {
		MyStack<String> a = new MyStack<String>();
		for (int i = 0; i < 10; i++) {
			a.push("数字" + i);
		}
		for (String s : a) {
			System.out.println(s);
		}
	}
	
}
