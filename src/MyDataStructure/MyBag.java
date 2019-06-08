package MyDataStructure;

import java.util.Iterator;


/**
 * 链表实现背包数据结构
 * @author Cloud
 *
 */
public class MyBag<Item> implements Iterable<Item> {

	
private Node first;
	
	private class Node {
		Node last;
		Item item;
		Node(Node last, Item item) {
			this.last = last;
			this.item = item;
		}
	}
	
	public void add(Item item) {
		Node node = new Node(first, item);
		first = node;
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
		MyBag<String> a = new MyBag<String>();
		for (int i = 0; i < 10; i++) {
			a.add("数字" + i);
		}
		for (String s : a) {
			System.out.println(s);
		}
	}
}
