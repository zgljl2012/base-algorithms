package com.zgljl2012.algorithm;

public class 二分查找 {
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i=0;i<10;i++) {
			arr[i] = i+1;
		}
		System.out.println(isIn(arr, 2)); //1
		System.out.println(isIn(arr, 6)); //5
		System.out.println(isIn(arr, 11)); //-1
		System.out.println(isIn(arr, 10)); //-1
		System.out.println(isIn2(arr, 2, 0, arr.length-1)); //1
		System.out.println(isIn2(arr, 6, 0, arr.length-1)); //5
		System.out.println(isIn2(arr, 11, 0, arr.length-1)); //-1
		System.out.println(isIn2(arr, 10, 0, arr.length-1)); //-1
	}
	
	/**
	 * 二分查找算法
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int isIn(int[] arr, int target) {
		int left = 0, right = arr.length-1;
		while(left<=right) {
			int mid = (left+right)/2;
			if(arr[mid]==target) {
				return mid;
			} else if(arr[mid]>target) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return -1;
	}
	
	/**
	 * 二分查找算法递归版本
	 * @param arr
	 * @param target
	 * @param left
	 * @param right
	 * @return
	 */
	public static int isIn2(int[] arr, int target, int left, int right) {
		if(left<=right) {
			int mid = (left+right)/2;
			return arr[mid] == target? mid : (arr[mid]>target?isIn2(arr,target,left,mid-1):isIn2(arr,target,mid+1,right));
		}
		return -1;
	}
	
}
