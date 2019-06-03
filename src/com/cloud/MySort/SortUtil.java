package com.cloud.MySort;

import java.util.Arrays;

/**
 * 排序用工具类
 * @author Cloud
 *
 */
public class SortUtil {
	
	private static long millsTime;

	/**
	 * 交换数组中的两个元素
	 */
	public static void exchange(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	/**
	 * 判断数组是否已经有序
	 */
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (a[i].compareTo(a[i - 1]) < 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 随机生成大小为参数len大小的Integer数组
	 */
	public static Integer[] getIntegerArray(int len) {
		Integer[] a = new Integer[len];
		for (int i = 0; i < len; i++) {
			int num = (int) (Math.random() * len);
			a[i] = num;
		}
		return a;
	}
	
	/**
	 * 随机生成大小为参数len大小的Integer数组,包含許多重複元素
	 */
	public static Integer[] getRepeatIntegerArray(int len) {
		Integer[] a = new Integer[len + len / 2];
		for (int i = 0; i < len; i++) {
			int num = (int) (Math.random() * len);
			a[i] = num;
		}
		for (int i = 0; i < len / 2; i++) {
			a[len + i] = len / 2;
		}
		return a;
	}
	
	/**
	 * 随机生成只有n种值的长度为len数组
	 */
	public static Integer[] getIntegerArrayLimited(int n, int len) {
		Integer[] a = new Integer[len];
		for (int i = 0; i < len; i++) {
			if (i < n) {
				a[i] = i;
			} else {
				a[i] = (int) (Math.random() * n);
			}
		}
		return a;
	}
	
	/**
	 * 生成有序数组
	 */
	public static Integer[] getSortedInteger(int len) {
		Integer[] a = new Integer[len];
		for (int i = 0; i < len; i++) {
			a[i] = i;
		}
		return a;
	}
	
	/**
	 * 生成逆序数组
	 */
	public static Integer[] getReserve(int len) {
		Integer[] a = new Integer[len];
		for (int i = 0; i < len; i++) {
			a[i] = len - i;
		}
		return a;
	}
	
	/**
	 * 生成元素全部相同的数组
	 */
	public static Integer[] getSame(int len) {
		Integer[] a = new Integer[len];
		Arrays.fill(a, 1);
		return a;
	}
	
	/**
	 * 格式化打印数组
	 */
	public static void println(Comparable[] a) {
		System.out.println(Arrays.toString(a));
	}
	
	/**
	 * 比较排序性能
	 */
	public static double compareTime(Comparable[] a, String algs) {
		
		start();
		if (algs.equals("insert")) {
			InsertSort.sort(a);
		} else if (algs.equals("select")) {
			SelectSort.sort(a);
		} else if (algs.equals("shell")) {
			ShellSort.sort(a);
		}
		return end();
		
	}
	
	/**
	 * 计算程序运行时间
	 */
	public static void start() {
		millsTime = System.currentTimeMillis();
	}
	public static double end() {
		return (System.currentTimeMillis() - millsTime) / 1000.0;
	}
}
