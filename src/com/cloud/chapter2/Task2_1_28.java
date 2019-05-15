package com.cloud.chapter2;

import com.cloud.MySort.InsertSort;
import com.cloud.MySort.SortUtil;
import com.cloud.test.SelectSort;

/**
 * 相等的主键
 * @author Cloud
 *
 */
public class Task2_1_28 {

	public static void test(int len) {
		
		//插入排序的时间
		Integer[] a = SortUtil.getIntegerArrayLimited(2, len);
		System.out.println(SortUtil.isSorted(a));
		SortUtil.start();
		InsertSort.sort(a);
		double insertSortTime = SortUtil.end();
		System.out.println(SortUtil.isSorted(a));
		System.out.println("插入排序时间：" + insertSortTime);
		
		System.out.println();
		
		//选择排序的时间
		Integer[] b = SortUtil.getIntegerArrayLimited(2, len);
		System.out.println(SortUtil.isSorted(b));
		SortUtil.start();
		SelectSort.sort(b);
		double selectSortTime = SortUtil.end();
		System.out.println(SortUtil.isSorted(b));
		System.out.println("选择排序时间：" + selectSortTime);
		
	}
	
	public static void main(String[] args) {
		test(20000);
	}
}
