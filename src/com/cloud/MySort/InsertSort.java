package com.cloud.MySort;

public class InsertSort {
	
	public static void sort(Comparable[] a) {
		int len = a.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j].compareTo(a[j - 1]) < 0) {
					SortUtil.exchange(a, j - 1, j);
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
		System.out.print("是否已排序：" + SortUtil.isSorted(a) + "， 运行时间：" + time + "秒");  //10.012s | 64.706s
	}


}
