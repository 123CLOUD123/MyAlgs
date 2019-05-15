package com.cloud.MySort;

/**
 * 选择排序
 * 
 * @author Cloud
 *
 */
public class SelectSort {

	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i; j < a.length; j++) {
				if (a[j].compareTo(a[min]) < 0) {
					SortUtil.exchange(a, min, j);
				}
			}
		}
	}

	public static void main(String[] args) {
//		Integer[] a = SortUtil.getIntegerArray(80000);
		Integer[] a = SortUtil.getIntegerArray(200000);
		SortUtil.start();
		sort(a);
		double time = SortUtil.end();
		System.out.print("是否已排序：" + SortUtil.isSorted(a) + "， 运行时间：" + time + "秒");  //22.222s  |  138.459s
	}

}
