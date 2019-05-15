package com.cloud.chapter1;

import com.cloud.util.PrintUtil;

/**
 *  编写一个程序，获得三个整数参数，如果他们都相等则打印equal，否则打印not equal
 * @author Cloud
 *
 */
public class Task1_1_3 extends PrintUtil {
	
	public static void f(int i, int j, int k) {
		if (i == j && i == k) {
			println("equal");
		} else {
			println("not equal");
		}
	}
	
	public static void main(String [] args) {
		f(1, 3, 1);
		f(1, 1, 1);
	}
}
