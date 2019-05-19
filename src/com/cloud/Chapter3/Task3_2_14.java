package com.cloud.Chapter3;


public class Task3_2_14<Key extends Comparable<Key>, Value> {
	
	private Node root;

	private class Node {
		Key key;
		Value value;
		Node left;
		Node right;

		Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}

	/**
	 * 获取最大值
	 */
	public Value max() {
		Node node = root;
		while(node != null) {
			if (node.right != null) {
				node = node.right;
			} else {
				return node.value;
			}
		}
		return null;
	}
	
	/**
	 * 获取最小值
	 */
	public Value min() {
		Node node = root;
		while(node != null) {
			if (node.left != null) {
				node = node.left;
			} else {
				return node.value;
			}
		}
		return null;
	}
	
}
