package com.cloud.chapter2;

import com.cloud.MySort.SortUtil;

public class Task2_1_19 {

	public static void sort() {
		Integer[] a = new Integer[100];
		for (int i = 0; i < 100; i++) {
			a[i] = 100 - i;
		}
		int h = 1;
		while (h < 34) {
			h = h * 3 + 1;
		}
		while (h >= 1) {
			for (int i = h; i < 100; i++) {
				for (int j = i; j > 0 && a[j].compareTo(a[j - 1]) < 0; j-= h) {
					SortUtil.exchange(a, j - 1, j);
				}
			}
			h = h / 3;
		}
	}
	
}
