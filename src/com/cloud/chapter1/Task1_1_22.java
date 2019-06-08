package com.cloud.chapter1;

/**
 * 递归实现二分查找
 * @author Cloud
 *
 */
public class Task1_1_22 {

	public static int f(Comparable[] a, Comparable key) {
		return f(a, key, 0, a.length - 1);
	}
	private static int f(Comparable[] a, Comparable key, int lo, int hi) {
		if (lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		int cmp = key.compareTo(a[mid]);
		if (cmp < 0) {
			return f(a, key, lo, mid - 1);
		} else if (cmp > 0) {
			return f(a, key, mid + 1, hi);
		} else {
			return mid;
		}
	}
	
}
