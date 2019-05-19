package com.cloud.Chapter3;



/**
 * 实现非递归的二叉查找树 get put方法
 * @author Cloud
 *
 */
public class Task3_2_13<K extends Comparable<K>, V> {

	private Node root;
	
	private class Node {
		K k;
		V v;
		Node left;
		Node right;
		Node(K k, V v) {
			this.k = k;
			this.v = v;
		}
	}
	
	//查找
	public V get(K k) {
		Node node = root;
		while (node != null) {
			int tmp = k.compareTo(node.k);
			if (tmp == 0) {
				return node.v;
			} else if (tmp < 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}
	
	//添加或更新
	public void put(K key, V value) {
		if (root == null) {
			root = new Node(key, value);
			return;
		}
		Node node = root;
		while (true) {
			int cmp = key.compareTo(node.k);
			if (cmp < 0) {
				if (node.left == null) {
					node.left = new Node(key, value);
					return;
				} else {
					node = node.left;
				}
			} else if (cmp > 0) {
				if (node.right == null) {
					node.right = new Node(key, value);
					return;
				} else {
					node = node.right;
				}
			} else {
				node.v = value;
				return;
			}
		}
	}
	
}
