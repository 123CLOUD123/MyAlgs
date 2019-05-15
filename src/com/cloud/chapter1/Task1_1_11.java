package com.cloud.chapter1;

import com.cloud.util.PrintUtil;

public class Task1_1_11 extends PrintUtil {
	
	public static void f(boolean[][] a) {
		int col = a[0].length;
		print("   ");
		for (int i = 0; i < col; i++) {
			print((i + 1) + "       ");
		}
		println("");
		for (int i = 0; i < a.length; i++) {
			boolean[] am = a[i];
			print((i + 1) + "  ");
			for (int j = 0; j < am.length; j++) {
				print(am[j] + "   ");
			}
			println("");
		}
	}
	
	public static void main(String [] args) {
		boolean[][] a = {{false, true, false, true},{true, true, true, true},{true, true, true, true}};
		f(a);
	}

}
