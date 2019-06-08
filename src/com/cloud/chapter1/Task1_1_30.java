package com.cloud.chapter1;

/**
 * 数组联系
 * @author Cloud
 *
 */
public class Task1_1_30 {

	public static void f(int n) {
		boolean[][] a = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = g(i, j);
			}
		}
	}
	private static boolean g(int i, int j) {
		int max = i;
		if (max > j) {
			max = j;
		}
		int k = 2;
		while (k <= max) {
			if (i % k == 0 && j % k == 0) {
				return false;
			}
			k++;
		}
		return true;
	}
	
}
