package com.cloud.test;

public class Hao {
	
	private static Comparable[] tmp;
	
	/**
	 * 原地归并
	 * @param a
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
//		tmp = new Comparable[a.length];
		for (int i = 0; i < a.length; i++) {
			tmp[i] = a[i];
		}
		
		int i = lo;
		int j = mid + 1;
		
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = tmp[j++];
			} else if (j > hi) {
				a[k] = tmp[i++];
			} else if (a[i].compareTo(a[j]) < 0) {
				a[k] = tmp[i++];
			} else {
				a[k] = tmp[j++];
			}
		}
	}

	/**
	 * 自底向上归并
	 * @param a
	 */
	public static void sort1(Comparable[] a) {
		tmp = new Comparable[a.length];
		int len = a.length;
		for (int range = 1; range < len; range = range * 2) {
			for (int lo = 0; lo < len - range; lo = lo + range * 2) {
				merge(a, lo, lo + range - 1, Math.min(len - 1, lo + range * 2 - 1));
			}
		}
	}
}
