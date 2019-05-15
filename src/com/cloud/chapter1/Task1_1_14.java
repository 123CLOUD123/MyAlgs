package com.cloud.chapter1;

import com.cloud.util.PrintUtil;

/**
 * 编写一个静态方法lg(),接受一个整型参数n，返回不大于lgN的最大整数
 * @author Cloud
 *
 */
public class Task1_1_14 extends PrintUtil {
	
	public static int lg(int n) {
		if (n <= 0) {
			print("输入不合法");
		} else if (n <= 1) {
			return 0;
		}
		
		int s = 1;
		int i = 0;
		while(s <= n) {
			s = s*2;
			i++;
		}
		return i - 1;
	}
	
	public static void main(String [] args) {
		print(lg(18));
	}
}
