package com.cloud.test;

public class RedBlackBST<Key extends Comparable, Value> {

	private Node root;
	
	private class Node {
		
	}
	
	protected void finalize() {
		System.out.println("kill object");
	}
	
	public static void main(String [] args) {
		new RedBlackBST<Comparable, String>();
		System.out.println("hello world");
	}
}
