package MyDataStructure;

import java.util.Arrays;

/**
 * 优先队列（有序数组）
 * @author Cloud
 *
 */
public class PriorityQueue1<T extends Comparable> {

	private Comparable[] a;
	
	public void insert(T c) {
		if (a == null) {
			a = new Comparable[1];
			a[0] = c;
		} else {
			Comparable[] t = a;
			a = new Comparable[t.length + 1];
			int i = 0;
			for (; i < t.length; i++) {
				if (t[i].compareTo(c) > 0) {
					break;
				}
			}
			int j = 0;
			while (true) {
				if (j == a.length) {
					break;
				} else if (j < i) {
					a[j] = t[j];
				} else if (j == i) {
					a[j] = c;
				} else {
					a[j] = t[j - 1];
				}
				j++;
			}
		}
	}
	
	public Comparable delMax() {
		if (a == null) {
			return null;
		}
		Comparable c = a[a.length - 1];
		Comparable[] t = a;
		a = new Comparable[a.length - 1];
		for (int i = 0; i < a.length; i++) {
			a[i] = t[i];
		}
		return c;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(a);
	}
	
	public static void main(String[] args) {
		PriorityQueue1<Integer> p = new PriorityQueue1<Integer>();
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
