package com.cloud.chapter2;

import com.cloud.MySort.SortUtil;

/**
 * 希尔排序的递增序列
 * @author Cloud
 *
 */
public class Task2_1_30 {
	
	public static void testShellSort(int t) {
		Integer[] a = SortUtil.getIntegerArray(20000);
		int len = a.length;
		int h = 1;
		while (h < len / t) {
			h = h * t;
		}
		while (h >= 1) {
			for (int i = h; i < len; i++) {
				for (int j = i; j >= h; j -= h) {
					if (a[j].compareTo(a[j - h]) < 0) {
						SortUtil.exchange(a, j, j - h);
					}
				}
			}
			h = h / t;
		}
		System.out.print("，是否已排序：" + SortUtil.isSorted(a) + "-----------");
	}
	
	public static void main(String[] args) {
		
		for (int i = 2; i < 100; i++) {
			SortUtil.start();
			testShellSort(i);
			System.out.println("t:" + i + "，运行时间：" + SortUtil.end());
		}
	}
	
}
