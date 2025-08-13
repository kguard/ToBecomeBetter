package com.kguard.tobecomebetter.swea;

import java.util.Arrays;
import java.util.Scanner;


public class SWEA2071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String buffer = sc.nextLine();
		for (int i = 1; i <= t; i++) {
			int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int sum = 0;
			for(int s : nums) {
				sum += s;
			}
			System.out.println("#"+i+" "+Math.round(sum/10.0));
		}

	}

}
