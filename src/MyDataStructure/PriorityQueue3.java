package MyDataStructure;

import java.util.Arrays;

/**
 * 基于二叉堆的优先队列
 * @author Cloud
 *
 */
public class PriorityQueue3<T extends Comparable> {
	
	private T[] a;
	
	private int size = 0;
	
	PriorityQueue3(int size) {
		a = (T[]) new Comparable[size + 1];
	}
	
	private void exch(int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	private void swim(int i) {
		if ((i / 2) < 1 || a[i].compareTo(a[i / 2]) < 0) {
			return;
		}
		exch(i, i / 2);
		swim(i / 2);
	}
	
	private void sink(int i) {
		int j = i * 2;
		if (j > size) {
			return;
		}
		if (j < size && a[j].compareTo(a[j + 1]) < 0) {
			j++;
		}
		if (a[i].compareTo(a[j]) < 0) {
			exch(i, j);
			sink(j);
		}
	}
	
	public void insert(T t) {
		a[++size] = t;
		swim(size);
	}
	
	public T delMax() {
		T max = a[1];
		a[1] = a[size];
		a[size--] = null;
		sink(1);
		return max;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(a);
	}
	
	public static void main(String[] args) {
		PriorityQueue3<Integer> p = new PriorityQueue3<Integer>(100);
		p.insert(5);
		System.out.println(p);
		for (int i = 0; i < 10; i++) {
			p.insert((int) (Math.random() * 10));
		}
		System.out.println(p);
		Comparable c = p.delMax();
		System.out.println(p);
		c = p.delMax();
		System.out.println(p);
	}
	
}
