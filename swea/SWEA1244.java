package com.kguard.tobecomebetter.swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1244 {
	static int[] nums;
	static int change;
	static int max;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			nums = Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
			change = sc.nextInt();
			if(change > nums.length)
				change = nums.length;
			max = 0;
			backtracking(0, 0);
			System.out.println("#" + i + " " + max);
		}
	}
	static void backtracking(int start, int depth) {
		System.out.println(Arrays.toString(nums).replaceAll("[^0-9]", "")+" Start: "+start+ " Depth: "+depth);
		if (depth == change) {
			max = Math.max(max, Integer.parseInt(Arrays.toString(nums).replaceAll("[^0-9]", "")));
			return;
		}
		for (int i = start; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++) {
				swap(i, j);
				backtracking(i, depth + 1);
				swap(i, j);
			}
	}

	static void swap(int a, int b) {
		int s = nums[a];
		nums[a] = nums[b];
		nums[b] = s;
	}
}
//public class SWEA1244 {
//	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		for (int i = 1; i <= t; i++) {
//			int[] nums = Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
//			int change = sc.nextInt();
//			for (int j = 0; j < nums.length; j++) {
//				int[] find = Arrays.copyOfRange(nums, j, nums.length);
//				int max = Arrays.stream(find).max().getAsInt();
//				int maxIndex = -1;
//				for (int k = nums.length - 1; k >= 0; k--)
//					if (nums[k] == max) {
//						maxIndex = k;
//						break;
//					}
//				if (nums[j] != max) {
//					int c = nums[j];
//					nums[j] = nums[maxIndex];
//					nums[maxIndex] = c;
//					change--;
//				}
//				if (change <= 0)
//					break;
//			}
//			if (change > 0)
//				if (change % 2 == 1) {
//					boolean same = false;
//					for(int k = 0 ; k < nums.length-2 ; k++) {
//						if(nums[k]== nums[nums.length-2]) 
//							same = true;
//							break;
//						}
//					if(!same) {
//					int c = nums[nums.length - 2];
//					nums[nums.length - 2] = nums[nums.length - 1];
//					nums[nums.length - 1] = c;
//					}
//				}
//			System.out.println("#" + i + " " + Arrays.toString(nums).replaceAll("[^0-9]", ""));
//		}
//	}
//
//}
