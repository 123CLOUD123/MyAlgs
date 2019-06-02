package com.cloud.chapter2;

import java.util.Arrays;

/**
 * 不需要交换的插入排序
 * @author Cloud
 *
 */
public class Task2_1_25 {

	public static void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			Comparable b = a[i];
			int j;
			for (j = i; j > 0 && b.compareTo(a[j - 1]) < 0; j--) {
				a[j] = a[j - 1];
			}
			a[j] = b;
		}
	}
	
	
	public static void main(String[] args) {
		Integer[] a  = {3, 4, 22, 44, 33, 123,123,53,54,5,6,46,5,5,65,75,7};
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
