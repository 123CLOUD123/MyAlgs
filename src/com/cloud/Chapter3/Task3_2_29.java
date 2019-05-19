package com.cloud.Chapter3;

/**
 * 二叉树检查
 * @author Cloud
 *
 */
public class Task3_2_29<Key extends Comparable<Key>, Value> {

	private Node root;
	
	private class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		int nodeCount;
		Node(Key key, Value value, int nodeCount) {
			this.key = key;
			this.value = value;
			this.nodeCount = nodeCount;
		}
	}
	
	public boolean isBinaryTree(Node node) {
		if (nodeCount(node) == node.nodeCount) {
			return true;
		} else {
			return false;
		}
	}
	private int nodeCount(Node node) {
		if (node == null) {
			return 0;
		}
		return nodeCount(node.left) + nodeCount(node.right) + 1;
	}
	
	
	
}
