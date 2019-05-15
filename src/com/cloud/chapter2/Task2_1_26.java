package com.cloud.chapter2;

import java.util.Arrays;

import com.cloud.test.ArrayGenerator;

/**
 * 原始数据类型
 * @author Cloud
 *
 */
public class Task2_1_26 {
	
	public static void sort(int[] a) {
		int len = a.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j] < a[j - 1]) {
					int tmp = a [j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = ArrayGenerator.getInt(20);
		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
	}
}
