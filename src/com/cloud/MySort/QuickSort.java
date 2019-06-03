package com.cloud.MySort;

/**
 * 快速排序
 * @author Cloud
 *
 */
public class QuickSort {

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable p = a[lo];
		while (true) {
			
			//从左开始查找大于a[lo]的元素
			while (a[++i].compareTo(p) <= 0) {
				if (i == hi) {
					break;
				}
			}
			
			//从右开始查找小于a[lo]的元素
			while (a[--j].compareTo(p) >= 0) {
				if (j == lo) {
					break;
				}
			}
			
			//当i,j相遇时则跳出循环
			if (i >= j) {
				break;
			}
			
			//未相遇时则交换两元素并继续循环操作
			SortUtil.exchange(a, i, j);
		}
		
		SortUtil.exchange(a, lo, j);
		return j;
	}

	public static void main(String[] args) {
		Integer[] a = SortUtil.getIntegerArray(800_000);
		System.out.println("是否已排序：" + SortUtil.isSorted(a)); 
		SortUtil.start();
		sort(a);
		double time = SortUtil.end();
		System.out.println("是否已排序：" + SortUtil.isSorted(a) + "， 运行时间：" + time + "秒"); //1千万- 3.2s 
	}
}
