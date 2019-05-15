package com.cloud.chapter2;

import com.cloud.MySort.MergeSort;
import com.cloud.MySort.SortUtil;

public class Task2_2_3 {
	
	private static Comparable[] tmp;
	
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int len = a.length;
		for (int i = lo; i <= hi; i++) {
			tmp[i] = a[i];
		}
		
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = tmp[j++];
			} else if (j > hi) {
				a[k] = tmp[i++];
			} else if (tmp[i].compareTo(tmp[j]) < 0) {
				a[k] = tmp[i++];
			} else {
				a[k] = tmp[j++];
			}
		}
	}

	public static void sort(Comparable[] a) {
		int len = a.length;
		tmp = new Comparable[len];
		for (int span = 1; span < len; span += span) {
			for (int lo = 0; lo < len - span; lo = lo + 2 * span) {
				merge(a, lo, lo + span - 1, Math.min(len - 1, lo + 2 * span - 1));
			}
		}
		
	}
	
	public static void main(String[] args) {
		String[] a = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
		sort(a);
		SortUtil.println(a);
	}
}
