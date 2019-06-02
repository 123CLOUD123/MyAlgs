package com.cloud.chapter2;

import java.util.Arrays;

/**
 * 简介排序
 * @author Cloud
 *
 */
public class Task2_2_20 {

	public static int[] sort(Comparable[] a) {
		int[] perm = new int[a.length];
		sort(a, 0, a.length - 1, perm);
		return perm;
	}
	private static void sort(Comparable[] a, int lo, int hi, int[] perm) {
		if (lo >= hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid, perm);
		sort(a, mid + 1, hi, perm);
		merge(a, lo, mid, hi, perm);
	}
	private static void merge(Comparable[] a, int lo, int mid, int hi, int[] perm) {
		int i = lo;
		int j = mid + 1;
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				perm[k] = j++;
			} else if (j > hi) {
				perm[k] = i++;
			} else if (a[i].compareTo(a[j]) < 0) {
				perm[k] = i++;
			} else {
				perm[k] = j++;
			}
		}
	}
	
}
