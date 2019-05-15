package com.cloud.chapter2;

import com.cloud.MySort.InsertSort;
import com.cloud.MySort.SelectSort;
import com.cloud.MySort.SortUtil;

/**
 * 双倍测试
 * @author Cloud
 *
 */
public class Task2_1_31 {
	
	public static void compareSort() {
		for (int i = 0; i < 3; i++) {
			int tmp = 1;
			for (int j = 0; j < i; j++) {
				tmp *= 2;
			}
			
			
			//选择排序
			Integer[] a = SortUtil.getIntegerArray(10000 * tmp);
			System.out.println("长度：" + a.length);
			SortUtil.start();
			SelectSort.sort(a);
			System.out.println("长度：" + a.length + ",是否已排序：" + SortUtil.isSorted(a) + ",选择排序时间：" + SortUtil.end());
			
			//插入排序时间
			Integer[] b = SortUtil.getIntegerArray(10000 * tmp);
			System.out.println("长度：" + b.length);
			SortUtil.start();
			InsertSort.sort(b);
			System.out.println("长度：" + b.length + ",是否已排序：" + SortUtil.isSorted(b) + ",插入排序时间：" + SortUtil.end());
			
			//希尔排序
			Integer[] c = SortUtil.getIntegerArray(10000 * tmp);
			System.out.println("长度：" + c.length);
			SortUtil.start();
			InsertSort.sort(c);
			System.out.println("长度：" + c.length + ",是否已排序：" + SortUtil.isSorted(c) + ",希尔排序时间：" + SortUtil.end());
			
			System.out.println("-------------------------------");
		}
	}
	
	public static void main(String[] args) {
		compareSort();
	}
	
}
