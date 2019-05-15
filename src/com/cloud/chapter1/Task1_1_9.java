package com.cloud.chapter1;

import com.cloud.util.PrintUtil;

/**
 * 编写一段代码，将一个正整数用二进制表示并转化为一个String类型的值
 * @author Cloud
 *
 */
public class Task1_1_9 extends PrintUtil {
	
	public static String f(int n) {
		if (n <= 0) {
			return "请输入正整数";
		} else {
			String s = "";
			for (; n != 0; n = n / 2) {
				s = n % 2 + s;
			}
			return s;
		}
	}
	
	public static void main(String [] args) {
		println(f(33));
	}
	
}
