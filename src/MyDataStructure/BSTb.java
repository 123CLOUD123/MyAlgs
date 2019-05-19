package MyDataStructure;

/**
 * 非递归二叉树
 * 
 * @author Cloud
 *
 */
public class BSTb<Key extends Comparable<Key>, Value> {

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
	 * 获取
	 */
	public Value get(Key key) {
		Node node = root;
		while (node != null) {
			int cmp = key.compareTo(node.key);
			if (cmp < 0) {
				node = node.left;
			} else if (cmp > 0) {
				node = node.right;
			} else {
				return node.value;
			}
		}
		return null;
	}
	
	/**
	 * 添加或更新
	 */
	public void put(Key key, Value value) {
		if (root == null) {
			root = new Node(key, value);
			return;
		}
		Node node = root;
		while (true) {
			int cmp = key.compareTo(node.key);
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
				node.value = value;
				return;
			}
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
	
	/**
	 * 删除最大值
	 */
	public void deleteMax() {
		if (root == null) {
			return;
		}
		if (root.right == null) {
			root = root.left;
			return;
		}
		Node node = root.right;
		Node lastNode = root;
		while (node != null) {
			if (node.right == null) {
				lastNode.right = node.left;
				return;
			} else {
				lastNode = node;
				node = node.right;
			}
		}
	}
	
	/**
	 * 删除最小值
	 */
	public void deleteMin() {
		if (root == null) {
			return;
		}
		if (root.left == null) {
			root = root.right;
			return;
		}
		Node node = root.left;
		Node lastNode = root;
		while (node != null) {
			if (node.left == null) {
				lastNode.left = node.right;
				return;
			} else {
				lastNode = node;
				node = node.left;
			}
		}
	}
	
	public static void main(String[] args) {
		
		BSTb<Integer, String> bst = new BSTb<Integer, String>();
		for (int i = 0; i < 100; i++) {
			int key = (int) (Math.random() * 100);
			bst.put(key, "值" + key);
		}
		String v1 = bst.get(50);
		System.out.println(v1);
		
		System.out.println("-----------获取最大最小----------");
		
		//测试获取最大值、最小值
		System.out.println("最大值：" + bst.max());
		System.out.println("最小值：" + bst.min());
		
		System.out.println("-----------测试删除最大最小----------");
		
		//测试删除最大节点
		bst.deleteMax();
		bst.deleteMin();
		System.out.println("最大值：" + bst.max());
		System.out.println("最小值：" + bst.min());
		
		System.out.println("-----------分界线----------");
		
		
	}
}
