package com.cloud.test;

public class SelectSort {
	
	public static void sort(Comparable[] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			int min = i;
			for (int j = i + 1; j < len; j++) {
				if (a[min].compareTo(a[j]) > 0) {
					min = j;
				}
			}
			Comparable tmp = a[min];
			a[min] = a[i];
			a[i] = tmp;
		}
	}
	
	public static void sort2(Comparable[] a) {
		int len = a.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j].compareTo(a[j - 1]) < 0) {
					Comparable tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
				}
			}
		}
	}
}
