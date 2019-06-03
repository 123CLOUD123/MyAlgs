package MyDataStructure;

import com.cloud.MySort.SortUtil;

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
	
	//打印所有元素（先序遍历）
	public void printAll() {
		print(root);
		System.out.println();
	}
	
	private void print(Node node) {
		if (node == null) {
			return;
		}
		print(node.left);
		System.out.print("[" + node.k + ":" + node.t + "],");
		print(node.right);
	}
	
	//打印所有元素（中序遍历）
	public void printAll1() {
		print1(root);
		System.out.println();
	}
	private void print1(Node node) {
		if (node == null) {
			return;
		}
		System.out.print("[" + node.k + ":" + node.t + "],");
		print(node.left);
		print(node.right);
	}
	
	//计算树的高度
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
		a.printAll();
		
		//测试大小
		System.out.println("大小：" + a.size());

		// 测试删除最大键
		Integer max = a.max();
		System.out.println("最大键1：" + max);
		a.deleteMax();
		Integer max2 = a.max();
		System.out.println("最大键2：" + max2);

		// 测试删除最小键
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

		//测试打印
		a.printAll();
		
		//测试性能
		for (int i = 0; i < 1000000; i++) {
			int k = (int) (Math.random() * 1000000);
			a.put(k, "值" + k);
		}
		a.put(50000, "<<命中>>");
		SortUtil.start();
		String ss = a.get(50000);
		double tt = SortUtil.end();
		System.out.println("大小" + a.size() + "--" + ss + "--用时：" + tt);
		
		//测试计算树的高度
		System.out.println("-----------");
		BST<Integer, String> b = new BST<Integer, String>();
		b.put(0, "555");
		for (int i = 0; i < 10; i++) {
			int j = (int) (Math.random() * 10);
			b.put(j, j + "");
			System.out.print(j + "+++");
		}
		System.out.println();
		System.out.println("树的高度：" + b.height() + "--" + b.root.k);
	}
}
