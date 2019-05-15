package MyDataStructure;

/**
 * 双向链表
 * @author Cloud
 *
 */
public final class MyLinkedList<T> {

	private Node first;
	
	private Node last;
	
	private int length;
	
	private class Node<K> {
		K k;
		Node next;
		Node last;
		Node(K k, Node next, Node last) {
			this.k = k;
			this.next = next;
			this.last = last;
		}
	}
	
	//添加元素到最后
	public void add(T t) {
		if (first == null) {
			last = first = new Node<T>(t, null, null);
		} else {
			Node newNode = new Node<T>(t, null, last);
			last.next = newNode;
			last = newNode;
			
		}
		length++;
	}
	
	
	//获取第i个节点的值
	public T get(int i) {
		if (first == null) {
			System.out.println("空表");
			return null;
		}
		if (i >= this.length) {
			System.out.println("超过表的长度");
			return null;
		}
		if (i < 0) {
			System.out.println("只能顺序查询。");
			return null;
		}
		Node result = first;
		for (int j = 0; j < i; j++) {
			result = result.next;
		}
		return (T) result.k;
	}
	
	//删除第i个元素
	public T delete(int i) {
		if (first == null) {
			System.out.println("空表");
			return null;
		}
		if (i >= this.length) {
			System.out.println("超过表的长度");
			return null;
		}
		if (i < 0) {
			System.out.println("只能顺序查询。");
			return null;
		}
		Node result = first;
		for (int j = 0; j < i; j++) {
			result = result.next;
		}
		Node lastNode = result.last;
		Node nextNode = result.next;
		if (lastNode == null && nextNode == null) {
			first = last = null;
		} else if (lastNode == null) {
			nextNode.last = null;
			first = nextNode;
		} else if (nextNode == null) {
			lastNode.next = null;
			last = lastNode;
		} else {
			lastNode.next = nextNode;
			nextNode.last = lastNode;
		}
		this.length--;
		return (T) result.k;
		
	}
	
	//获取链表长度
	public int length() {
		return this.length;
	}
	
	public static void main(String[] args) {
		MyLinkedList<String> a = new MyLinkedList<String>();
		a.add("zhang");
		a.add("hao");
		a.add("like");
		System.out.println(a.get(2));
		System.out.println(a.length());
		a.delete(0);
		System.out.println(a.last.k);
		System.out.println(a.first.k);
		System.out.println(a.length());
	}
}
