package MyDataStructure;

import java.util.Arrays;

/**
 * 优先队列（基于无序数组）
 * @author Cloud
 *
 * @param <T>
 */
public class PriorityQueue2<T extends Comparable> {

	private Comparable[] a;
	
	public void insert(T t) {
		if (a == null) {
			a = new Comparable[1];
			a[0] = t;
		} else {
			Comparable[] b = a;
			a = new Comparable[b.length + 1];
			for (int i = 0; i < b.length; i++) {
				a[i] = b[i];
			}
			a[b.length] = t;
		}
	}
	
	public Comparable delMax() {
		if (a == null || a.length == 0) {
			return null;
		}
		Comparable[] b = a;
		a = new Comparable[a.length - 1];
		int max = 0;
		for (int i = 1; i < b.length; i++) {
			if (b[i].compareTo(b[max]) > 0) {
				max = i;
			}
		}
		for (int i = 0; i < b.length; i++) {
			if (i == max) {
				continue;
			} else if (i < max) {
				a[i] = b[i];
			} else {
				a[i - 1] = b[i];
			}
			
		}
		return b[max];
	}
	
	@Override
	public String toString() {
		return Arrays.toString(a);
	}
	
	public static void main(String[] args) {
		PriorityQueue2<Integer> p = new PriorityQueue2<Integer>();
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
