package com.cloud.chapter2;

import com.cloud.MySort.SortUtil;

/**
 * 非递归的快速排序
 * @author Cloud
 *
 */
public class Task2_3_20 {

	public static void sort(Comparable[] a) {
		
//		int lo = 0;
//		int hi = a.length - 1;
//		while (lo < hi) {
//			int p = partition(a, lo, hi);
//			int lo = 
//			while (hi < a.length - 1) {
//				
//			}
//		}
////		int sz = a.length;
//		while (sz != 1) {
//			int p = partition(a, 0, a.length - 1);
//		}
	}
	private static int partition(Comparable[] a, int lo, int hi) {
		Comparable v = a[lo];
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (a[++i].compareTo(v) < 0) {
				if (i == hi) {
					break;
				}
			}
			while (a[--j].compareTo(v) > 0) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			SortUtil.exchange(a, lo, j);
		}
		return j;
	}
	
}
