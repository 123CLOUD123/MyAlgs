package MyDataStructure;

/**
 * 二叉查找树
 * 
 * @author Cloud
 *
 * @param <K>
 * @param <T>
 */
public class BST<K extends Comparable<K>, T> {

	private Node root;

	private class Node {
		private K k;
		private T t;
		private Node left;
		private Node right;
		private int n;

		Node(K k, T t, int n) {
			this.k = k;
			this.t = t;
			this.n = n;
		}

	}

	// 查找
	public T get(K k) {
		return get(root, k);
	}
	private T get(Node node, K k) {
		if (node == null) {
			return null;
		}
		int tmp = k.compareTo(node.k);
		if (tmp == 0) {
			return node.t;
		} else if (tmp < 0) {
			return get(node.left, k);
		} else {
			return get(node.right, k);
		}
	}

	// 添加或更新
	public void put(K k, T t) {
		root = put(root, k, t);
	}
	private Node put(Node node, K k, T t) {
		if (node == null) {
			return new Node(k, t, 1);
		}
		int tmp = k.compareTo(node.k);
		if (tmp < 0) {
			node.left = put(node.left, k, t);
		} else if (tmp > 0) {
			node.right = put(node.right, k, t);
		} else {
			node.t = t;
		}
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	//刪除指定鍵的節點
	public void delete(K k) {
		root = delete(root, k);
	}
	private Node delete(Node node, K k) {
		if (node == null) {
			return null;
		}
		
		int tmp = k.compareTo(node.k);
		if (tmp < 0) {
			node.left = delete(node.left, k);
		} else if (tmp > 0) {
			node.right = delete(node.right, k);
		} else {
			if (node.left == null) {
				return node.right;
			}
			if (node.right == null) {
				return  node.left;
			}
			Node t = node;
			node = min(t.right);
			node.right = deleteMin(t.right);
			node.left = t.left;
		}
		
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}

	// 获取最大键
	public K max() {
		return max(root).k;
	}

	private Node max(Node node) {
		if (node == null) {
			return null;
		}
		if (node.right == null) {
			return node;
		}
		return max(node.right);

	}

	// 获取最小键值
	public K min() {
		return min(root).k;
	}

	private Node min(Node node) {
		if (node == null) {
			return null;
		}
		if (node.left == null) {
			return node;
		}
		return min(node.left);
	}

	// 删除最小节点
	public void deleteMin() {
		root = deleteMin(root);
	}
	private Node deleteMin(Node node) {
		if (node.left == null) {
			return node.right;
		}
		node.left = deleteMin(node.left);
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}
	
	//删除最大节点
	public void deleteMax() {
		root = deleteMax(root);
	}
	private Node deleteMax(Node node) {
		if (node.right == null) {
			return node.left;
		}
		node.right = deleteMax(node.right);
		node.n = size(node.left) + size(node.right) + 1;
		return node;
	}

	// 获取以节点为根节点的树的结点总数
	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		return node.n;
	}

	public static void main(String[] args) {
		BST<Integer, String> a = new BST<Integer, String>();
		a.put(500, "字符500");
		for (int i = 0; i < 100; i++) {
			int key = (int) (Math.random() * 1000);
//			int key = i;
			a.put(key, "字符" + key);
		}
		String s = (String) a.get(500);
		System.out.println(s);
		a.put(500, "字符5050");
		s = a.get(500);
		System.out.println(s);
		
		//测试大小
		System.out.println("大小：" + a.size());

		// 测试最大键
		Integer max = a.max();
		System.out.println("最大键1：" + max);
		a.deleteMax();
		Integer max2 = a.max();
		System.out.println("最大键2：" + max2);

		// 测试最小键
		Integer min = a.min();
		System.out.println("最小键1：" + min);
		a.deleteMin();
		Integer min2 = a.min();
		System.out.println("最小键2：" + min2);
		
		//测试大小
		System.out.println("大小：" + a.size());
		
		//测试删除指定节点
		a.delete(500);
		System.out.println("大小：" + a.size());
		s =  a.get(500);
		System.out.println(s);

	}
}
