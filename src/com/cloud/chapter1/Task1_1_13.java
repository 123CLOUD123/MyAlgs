package com.cloud.chapter1;

import java.util.Arrays;

import com.cloud.util.PrintUtil;

/**
 * 编写一段代码，打印出一个M行N列的二维数组的转置
 * @author Cloud
 *
 */
public class Task1_1_13 extends PrintUtil {
	
	public static void f(int[][] a) {
		int[][] b = new int[a[0].length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				b[j][i] = a[i][j];
			}
		}
		print(Arrays.deepToString(b));
	}
	public static void main(String [] args) {
		int[][] a = {{1, 2}, {1, 3}, {1, 5}};
		f(a);
	}
}
