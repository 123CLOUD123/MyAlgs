package com.cloud.chapter2;

import com.cloud.MySort.SortUtil;

public class Task2_1_12 {

	public static void sort(Comparable[] a) {
		int len = a.length;
		Integer[] count = new Integer[len];
		int h = 1;
		while (h < len / 3) {
			h = h * 3 + 1;
		}
		while (h >= 1) {
			for (int i = h; h < len; i++) {
				for (int j = i; j > 0 && a[j].compareTo(a[j - 1]) < 0; j -= h) {
					count[j]++;
					SortUtil.exchange(a, j, j - h);
					SortUtil.exchange(count, j, j - h);
					count[j]++;
				}
			}
			h = h / 3;
		}
		for (int i = 0; i < len; i++) {
			System.out.println(count[i] / len);
		}
	}
	
}
