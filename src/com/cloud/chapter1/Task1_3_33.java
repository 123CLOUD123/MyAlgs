package com.cloud.chapter1;



public class Task1_3_33 {

	public static void main(String[] args) {
		Deque<String> d = new Deque<String>();
		d.pushLeft("left1");
		d.pushLeft("left2");
		d.pushRight("right1");
		d.pushRight("right2");
		String l2 = d.popLeft();
		String r2 = d.popRight();
		System.out.println(l2 + "-" + r2);
	}
	
}

class Deque<Item> {

	private Node left;
	
	private Node right;
	
	private int length;
	
	private class Node {
		Item item;
		Node left;
		Node right;
		Node(Item item, Node left, Node right) {
			this.item = item;
			this.left = left;
			this.right = right;
		}
	}
	
	
	public void pushLeft(Item item) {
		if (left == null) {
			left = right = new Node(item, null, null);
		} else {
			Node newNode = new Node(item, null, left);
			left = newNode;
		}
	}
	
	public void pushRight(Item item) {
		if (right == null) {
			left = right = new Node(item, null, null);
		} else {
			Node newNode = new Node(item, right, null);
			right = newNode;
		}
	}
	
	public Item popLeft() {
		if (left == null) {
			return null;
		}
		Item item = left.item;
		left = left.right;
		return item;
	}
	
	public Item popRight() {
		if (right == null) {
			return null;
		}
		Item item = right.item;
		right = right.left;
		return item;
	}
	
	

	
	//获取链表长度
	public int size() {
		return this.length;
	}
	
	public boolean isEmpty() {
		return this.length == 0;
	}
	
}

