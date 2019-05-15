package com.cloud.MySort;

/**
 * 归并排序
 * @author Cloud
 *
 */
public class MergeSort {

	/**
	 * 辅助数组
	 */
	public static Comparable[] tmp;
	
	/**
	 * 原地归并
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
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
	
	/**
	 * 自上向下归并排序
	 * @param args
	 */
	public static void topSort(Comparable[] a) {
		
		int len = a.length;
		tmp = new Comparable[len];
		topSort(a, 0, len - 1);
		
	}
	
	public static void topSort(Comparable[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		
		int mid = lo + (hi - lo) / 2;
		topSort(a, lo, mid);
		topSort(a, mid + 1, hi);
		
		merge(a, lo, mid, hi);
	}
	
	/**
	 * 自下向上归并排序
	 * @param args
	 */
	public static void bottomSort(Comparable[] a) {
		int len = a.length;
		tmp  = new Comparable[len];
		for (int span = 1; span < len; span += span) {
			for (int lo = 0; lo < len - span; lo = lo + 2 * span) {
				merge(a, lo, lo + span - 1, Math.min(lo + 2 * span - 1, len - 1));
			}
		}
	}
	
	
	public static void main(String[] args) {
//		Integer[] a = SortUtil.getIntegerArray(1_000_000);
//		System.out.println("数组长度：" + a.length + "是否已排序：" + SortUtil.isSorted(a));
		
		double totalTime = 0.0;
		for (int i = 0; i < 50; i++) {
			Integer[] a = SortUtil.getIntegerArray(1_000_000);
			SortUtil.start();
			topSort(a);
			double time = SortUtil.end();
			totalTime += time;
		}
		double avgTime = totalTime / 50;
		
//		boolean isSorted = SortUtil.isSorted(a);
		System.out.println("平均时间：" + avgTime);  //1亿个数据，58s | 1百万 0.313 | 1千万 4.437s
	}
	
}
