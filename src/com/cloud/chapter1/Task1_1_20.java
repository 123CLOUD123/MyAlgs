package com.cloud.chapter1;
/**
 * 递归计算
 * @author Cloud
 *
 */
public class Task1_1_20 {

	public static double f(int n) {
		return Math.log(g(n));
	}
	private static double g(int n) {
		if (n == 1) {
			return 1;
		}
		return n * g(n - 1);
	}
	
}
