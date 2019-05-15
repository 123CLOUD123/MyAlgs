package com.cloud.test;

/**
 * 二分查找
 * @author Cloud
 *
 */
public class BinarySearch {
	
	public static int find(Comparable[] a, Comparable b) {
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (b.compareTo(a[mid]) < 0) {
				hi = mid - 1;
			} else if (b.compareTo(a[mid]) > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String [] args) {
		Integer [] a = {1,5,6,9,10,11,14,18,20,30,40,42};
		System.out.print(find(a, 18));
	}
}
