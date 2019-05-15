package com.cloud.chapter1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.cloud.util.PrintUtil;

/**
 * 编写一段程序，如果double类型的变量x和y都严格位于0和1之间则打印true，否则打印false
 * @author Cloud
 *
 */
public class Task1_1_5 extends PrintUtil {
	public static void f(double x, double y) {
		if (x > 0 && x < 1 && y > 0 && y < 1) {
			println(true);
		} else {
			println(false);
		}
	}
	public static void main(String [] args) throws IOException {
		f(0.1, 0.2);
		f(0.2, 2);
	}
}
