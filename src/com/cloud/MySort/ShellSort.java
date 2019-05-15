package com.cloud.MySort;

/**
 * 希尔排序
 * @author Cloud
 *
 */
public class ShellSort {

	/**
	 * 使用递增序列4n+1
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		int len = a.length;
		int h = 1;
		while (h < len / 20) {
			h = 20 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < len; i++) {
				for (int j = i; j >= h; j -= h) {
					if (a[j].compareTo(a[j - h]) < 0) {
						SortUtil.exchange(a, j, j - h);
					}
				}
			}
			h = h / 20;
		}
	}
	
	public static void main(String[] args) {
//		Integer[] a = SortUtil.getIntegerArray(80000);
		Integer[] a = SortUtil.getIntegerArray(200000);
		SortUtil.start();
		sort(a);
		double time = SortUtil.end();
		System.out.print("是否已排序：" + SortUtil.isSorted(a) + "， 运行时间：" + time + "秒");  // 14.012s | 92.026s
	}
}
