package com.cloud.test;

import java.util.Arrays;



/**
 * 希尔排序
 * @author Cloud
 *
 */
public class ShellSort {
	
	public static void sort(Comparable[] a) {
		int len = a.length;
		int h = 1;
		while (h < len / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < len; i++) {
				for (int j = i; j >= h; j = j - h) {
					if (a[j].compareTo(a[j - h]) < 0) {
						Comparable tmp = a[j];
						a[j] = a[j - h];
						a[j - h] = tmp;
					}
				}
			}
			h = h / 3;
		}
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i].compareTo(a[i - 1]) < 0) {
				return false;
			}
		}
		return true;
	}
	
	
	public static void main(String [] args) {
		
		
		
		Integer[] a = ArrayGenerator.getInteger(10000);

		Timer t = new Timer();
		sort(a);  // 10
		
//		Merge.topSort(a);  // 5
//		SelectSort.sort(a);  //3.6
//		SelectSort.sort2(a); // 7.5
		double seconds = t.runTime();
		
		boolean isSorted = isSorted(a);
		System.out.println("是否已排序：" + (isSorted ? "是" : "否") + "，经过" + seconds + "秒");
		
	}
	
}
