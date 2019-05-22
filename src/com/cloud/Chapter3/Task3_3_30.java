package com.cloud.Chapter3;


/**
 * 缓存
 * @author Cloud
 *
 */
public class Task3_3_30<Key extends Comparable<Key>, Value> {

	private Node root;
	
	private Node cacheNode;
	
	private class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		int n;
		Boolean isRed;
		Node(Key key, Value value, int n, boolean isRed) {
			this.key = key;
			this.value = value;
			this.n = n;
			this.isRed = isRed;
		}
	}
	
	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return node.n;
	}
	
	private Node rotateRight(Node node) {
		Node t = node.left;
		node.left = t.right;
		t.right = node;
		t.isRed = node.isRed;
		node.isRed = true;
		t.n = node.n;
		node.n = size(node.left) +  size(node.right) + 1;
		return t;
	}
	
	private Node rotateLeft(Node node) {
		Node t = node.right;
		node.right = t.left;
		t.left = node;
		t.isRed = node.isRed;
		node.isRed = true;
		t.n = node.n;
		node.n = size(node.left) + size(node.right) + 1;
		return t;
	}
	
	private void flipColor(Node node) {
		node.isRed = true;
		node.left.isRed = false;
		node.right.isRed = false;
	}
	
	private boolean isRed(Node node) {
		if (node == null) {
			return false;
		}
		return node.isRed;
	}
	
	public Value get(Key key) {
		if (cacheNode != null) {
			if (cacheNode.key.compareTo(key) == 0) {
				return cacheNode.value;
			}
		}
		Node node = get(root, key);
		if (node == null) {
			return null;
		}
		return node.value;
	}
	
	private Node get(Node node, Key key) {
		if (node == null) {
			return null;
		}
		
		int cmp = node.key.compareTo(key);
		if (cmp == 0) {
			cacheNode = node;
			return node;
		} else if (cmp < 0) {
			return get(node.left, key);
		} else {
			return get(node.right, key);
		}
	}
	
	public void put(Key key, Value value) {
		if (cacheNode.key.compareTo(key) == 0) {
			cacheNode.value = value;
			return;
		}
		root = put(root, key, value);
	}
	
	private Node put(Node node, Key key, Value value) {
		if (node == null) {
			Node newNode = new Node(key, value, 1, true);
			cacheNode = newNode;
			return cacheNode;
		}
		
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			node.value = value;
			cacheNode = node;
		} else if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else {
			node.right = put(node.right, key, value);
		}
		
		if (isRed(node.right) && !isRed(node.left)) {
			node = rotateLeft(node);
		}
		if (isRed(node.left) && isRed(node.left.left)) {
			node = rotateRight(node);
		}
		if (isRed(node.left) && isRed(node.right)) {
			flipColor(node);
		}
		
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	
	
	
}
