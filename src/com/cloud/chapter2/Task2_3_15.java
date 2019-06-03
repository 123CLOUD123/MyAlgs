package com.cloud.chapter2;

import com.cloud.MySort.QuickSort;
import com.cloud.MySort.SortUtil;

/**
 * 螺絲和螺帽
 * @author Cloud
 *
 */
public class Task2_3_15 {

	
	//假设螺丝数组为a, 螺帽数组为b
	public static void sort(Comparable[] a, Comparable[] b) {
		
		//1.选择b[0]作为切分元素，应用二分快速排序将a切分，同时找到螺帽b[0]配对的螺丝
		
		//2.选择b[1]作为切分元素，和上一步找到的切分螺丝进行比较，若比它小， 则在螺丝切分后的左数组进行继续切分并配对，否则在右数组切分配对
		
		//3.重复上一步操作，直到所有螺帽配对完成
	}
	
}
