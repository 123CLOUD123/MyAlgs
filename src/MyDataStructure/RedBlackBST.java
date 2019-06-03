package MyDataStructure;

/**
 * 红黑树
 * @author Cloud
 *
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

	private Node root;
	
	private class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		int n;
		boolean isRed;
		Node(Key key, Value value, int n, boolean isRed) {
			this.key = key;
			this.value = value;
			this.n = n;
			this.isRed = isRed;
		}
	}
	
	/**
	 * 计算节点总数
	 */
	public int size(Node node) {
		if (node == null) {
			return 0;
		}
		return node.n;
	}
	
	/**
	 * 左旋转
	 */
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
	
	/**
	 * 右旋转
	 */
	private Node rotateRight(Node node) {
		Node t = node.left;
		node.left = t.right;
		t.right = node;
		t.isRed = node.isRed;
		node.isRed = true;
		t.n = node.n;
		node.n = size(node.left) + size(node.right) + 1;
		return t;
	}
	
	/**
	 * 改变两个子节点均为红色的节点
	 */
	private void flipColor(Node node) {
		node.isRed = true;
		node.left.isRed = false;
		node.right.isRed = false;
	}
	
	/**
	 * 判断节点是否为红色
	 */
	private boolean isRed(Node node) {
		if (node == null) {
			return false;
		}
		return node.isRed;
	}
	
	/**
	 * 获取
	 */
	public Value get(Key key) {
		Node node = get(root, key);
		if (node == null) {
			return null;
		} else {
			return node.value;
		}
	}
	private Node get(Node node, Key key) {
		if (node == null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			return node;
		} else if (cmp > 0) {
			return get(node.right, key);
		} else {
			return get(node.left, key);
		}
	}
	
	/**
	 * 添加或更新
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}
	private Node put(Node node, Key key, Value value) {
		if (node == null) {
			return new Node(key, value, 1, true);
		}
		
		int cmp = key.compareTo(node.key);
		if (cmp == 0) {
			node.value = value;
		} else if (cmp < 0) {
			node.left = put(node.left, key, value);
		} else {
			node.right = put(node.right, key, value);
		}
		
		if (!isRed(node.left) && isRed(node.right)) {
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
	
	public boolean isBlackNode(Node node) {
		if (node.left != null) {
			if (!node.isRed && !node.left.isRed) {
				return true;
			} else {
				return false;
			}
		} else {
			if (!node.isRed) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	
	
}
