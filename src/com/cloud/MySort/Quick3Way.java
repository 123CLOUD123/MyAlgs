package com.cloud.MySort;

/**
 *   三向切分快速排序
 * @author Cloud
 *
 */
public class Quick3Way {

	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		
		Comparable v = a[lo];
		int lt = lo;
		int gt = hi;
		int i = lo + 1;
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0) {
				SortUtil.exchange(a, lt++, i++);
			} else if (cmp >  0) {
				SortUtil.exchange(a, i, gt--);
			} else {
				i++;
			}
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);
	}
	
	public static void main(String[] args) {
		Integer[] a = SortUtil.getRepeatIntegerArray(10_000_000);
		System.out.println("是否已排序：" + SortUtil.isSorted(a)); 
		SortUtil.start();
		sort(a);
		double time = SortUtil.end();
		System.out.println("是否已排序：" + SortUtil.isSorted(a) + "， 运行时间：" + time + "秒"); //1千万- 3.2s 
	}
	
}
