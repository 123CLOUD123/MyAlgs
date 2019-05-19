package com.cloud.Chapter3;

/**
 * 缓存
 * @author Cloud
 *
 */
public class Task3_2_28<Key extends Comparable<Key>, Value> {
	
	private Node root;
	
	private Node cacheNode;
	
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
	
	public Value get(Key key) {
		if (cacheNode != null && cacheNode.key.compareTo(key) ==  0) {
			return cacheNode.value;
		}
		return get(root, key).value;
	}
	private Node get(Node node, Key key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			this.cacheNode = node;
			return node;
		} else if (cmp < 0) {
			return get(node.left, key);
		} else {
			return get(node.right, key);
		}
	}
	
	public void put(Key key, Value value) {
		if (cacheNode != null && cacheNode.key.compareTo(key) ==  0) {
			cacheNode.value = value;
			return;
		}
		root = put(root, key, value);
	}
	private Node put(Node node, Key key, Value value) {
		if (node == null) {
			Node newNode = new Node(key, value);
			cacheNode = newNode;
			return newNode;
		}
		
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			cacheNode = node;
			node.value = value;
		} else if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else {
			node.right = put(node.right, key, value);
		}
		return node;
	}
	
}
