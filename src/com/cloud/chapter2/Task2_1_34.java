package com.cloud.chapter2;

import com.cloud.MySort.SortUtil;

/**
 * 罕见情况
 * 
 * @author Cloud
 *
 */
public class Task2_1_34 {

	// 数组已经有序
	public static void test1(int n) {
		Integer[] a = SortUtil.getSortedInteger(n);
		System.out.println(SortUtil.isSorted(a));
		double selectTime = SortUtil.compareTime(a, "select");
		System.out.println(SortUtil.isSorted(a));

		a = SortUtil.getSortedInteger(n);
		System.out.println(SortUtil.isSorted(a));
		double insertTime = SortUtil.compareTime(a, "insert");
		System.out.println(SortUtil.isSorted(a));

		a = SortUtil.getSortedInteger(n);
		System.out.println(SortUtil.isSorted(a));
		double shellTime = SortUtil.compareTime(a, "shell");
		System.out.println(SortUtil.isSorted(a));

		System.out.println("选择、插入、希尔排序用时：" + selectTime + "--" + insertTime + "--" + shellTime);
	}

	// 数组逆序
	public static void test2(int n) {
		Integer[] a = SortUtil.getReserve(n);
		System.out.println(SortUtil.isSorted(a));
		double selectTime = SortUtil.compareTime(a, "select");
		System.out.println(SortUtil.isSorted(a));

		a = SortUtil.getReserve(n);
		System.out.println(SortUtil.isSorted(a));
		double insertTime = SortUtil.compareTime(a, "insert");
		System.out.println(SortUtil.isSorted(a));

		a = SortUtil.getReserve(n);
		System.out.println(SortUtil.isSorted(a));
		double shellTime = SortUtil.compareTime(a, "shell");
		System.out.println(SortUtil.isSorted(a));

		System.out.println("选择、插入、希尔排序用时：" + selectTime + "--" + insertTime + "--" + shellTime);
	}

	// 数组所有键相同
	public static void test3(int n) {
		Integer[] a = SortUtil.getSame(n);
		System.out.println(SortUtil.isSorted(a));
		double selectTime = SortUtil.compareTime(a, "select");
		System.out.println(SortUtil.isSorted(a));

		a = SortUtil.getSame(n);
		System.out.println(SortUtil.isSorted(a));
		double insertTime = SortUtil.compareTime(a, "insert");
		System.out.println(SortUtil.isSorted(a));

		a = SortUtil.getSame(n);
		System.out.println(SortUtil.isSorted(a));
		double shellTime = SortUtil.compareTime(a, "shell");
		System.out.println(SortUtil.isSorted(a));

		System.out.println("选择、插入、希尔排序用时：" + selectTime + "--" + insertTime + "--" + shellTime);
	}

	// 随机数组
	public static void test4(int n) {
		Integer[] a = SortUtil.getIntegerArray(n);
		System.out.println(SortUtil.isSorted(a));
		double selectTime = SortUtil.compareTime(a, "select");
		System.out.println(SortUtil.isSorted(a));

		a = SortUtil.getIntegerArray(n);
		System.out.println(SortUtil.isSorted(a));
		double insertTime = SortUtil.compareTime(a, "insert");
		System.out.println(SortUtil.isSorted(a));

		a = SortUtil.getIntegerArray(n);
		System.out.println(SortUtil.isSorted(a));
		double shellTime = SortUtil.compareTime(a, "shell");
		System.out.println(SortUtil.isSorted(a));

		System.out.println("选择、插入、希尔排序用时：" + selectTime + "--" + insertTime + "--" + shellTime);
	}

	public static void main(String[] args) {
//		test1(50000);
//		test2(50000);
//		test3(50000);
		test4(50000);
	}
}
