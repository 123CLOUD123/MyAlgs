package com.cloud.Chapter3;

public class Task3_2_6 {
	
	private Node root;
	
	private class Node {
		Node left;
		Node right;
	}

	public int height() {
		return height(root);
	}
	
	private int height(Node node) {
		if (node == null) {
			return 0;
		}
		int leftH = height(node.left) + 1;
		int rightH = height(node.right) + 1;
		if (leftH > rightH) {
			return leftH;
		} else {
			return rightH;
		}
		
	}
}
