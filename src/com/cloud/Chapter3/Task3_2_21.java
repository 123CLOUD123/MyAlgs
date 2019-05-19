package com.cloud.Chapter3;

public class Task3_2_21<Key extends Comparable<Key>, Value> {

	private Node root;
	
	private class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		int height;
	}
	
	public Key randomKey() {
		int height = root.height;
		Node node = root;
		int random1 = (int) (Math.random() * height);
		for (int i = 0; i < random1; i++) {
			int random2 = (int) (Math.random() * 2);
			if (random2 == 0 && node.left != null) {
				node = node.left;
			} else if (random2 == 1 && node.right != null) {
				node = node.right;
			}
		}
		return node.key;
	}
	
}
