package com.cloud.chapter2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 归并有序的队列
 * @author Cloud
 *
 */
public class Task2_2_14 {

	public static Queue sort(Queue<Integer> a, Queue<Integer> b) {
		Queue<Integer> q = new LinkedList<Integer>();
		Integer[] arr = new Integer[a.size() + b.size()];
		int k = 0;
		for (Integer co : a) {
			arr[k++] = co;
		}
		for (Integer co : b) {
			arr[k++] = co;
		}
		
		int mid = a.size() - 1;
		int hi = a.size() + b.size() - 1;
		int i = 0;
		int j = mid + 1;
		for (int n = 0; n <= hi; n++) {
			if (i > mid) {
				q.offer(arr[j++]);
			} else if (j > hi) {
				q.offer(arr[i++]);
			} else if (arr[i].compareTo(arr[j]) < 0) {
				q.offer(arr[i++]);
			} else {
				q.offer(arr[j++]);
			}
		}
		return q;
	}
	
	public static void main(String[] args) {
		Queue<Integer> a = new LinkedList<Integer>();
		Queue<Integer> b = new LinkedList<Integer>();
		for (int i = 0; i < 4; i++) {
			a.offer(2 * i);
			b.offer(2 * i + 1);
		}
		b.offer(88);
		Queue c = sort(a, b);
		System.out.println(c);
	}
	
}
