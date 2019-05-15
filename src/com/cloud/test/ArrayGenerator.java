package com.cloud.test;


public class ArrayGenerator {
	
	public static Integer[] getInteger(int len) {
		Integer[] a = new Integer[len];
		for (int i = 0; i < len; i++) {
			int num = (int) (Math.random() * len);
			a[i] = num;
		}
		return a;
	}
	
	
	public static int[] getInt(int len) {
		int[] a = new int[len];
		for (int i = 0; i < len; i++) {
			int num = (int) (Math.random() * len);
			a[i] = num;
		}
		return a;
	}
	
}
