package com.cloud.chapter2;

import java.util.Arrays;

import com.cloud.test.ArrayGenerator;

/**
 * 插入排序的哨兵
 * @author Cloud
 *
 */
public class Task2_1_24 {

	public static void sort(Comparable[] a) {
		int len = a.length;
		
		int min = 0;
		for (int i = 1; i < len; i++) {
			if (a[i].compareTo(a[min]) < 0) {
				min = i;
			}
		}
		Comparable tmp = a[0];
		a[0] = a[min];
		a[min] = tmp;
		
		for (int i = 1; i < len; i++) {
			for (int j = i; a[j].compareTo(a[j - 1]) < 0; j--) {
				tmp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = tmp;
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] a = ArrayGenerator.getInteger(40);
		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
