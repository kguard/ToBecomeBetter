package com.kguard.tobecomebetter.swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1206 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int n = sc.nextInt();
			// nextInt 이후에 \n을 제거하기 위해 nextLine();
			String buffer = sc.nextLine();
			int[] building = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int sum = 0;
			for (int j = 2; j < n - 2; j++) {
				int max = 0;
				for (int k = 1; k <= 2; k++) {
					max = Math.max(max, building[j - k]);
					max = Math.max(max, building[j + k]);
				}
				if (max < building[j])
					sum += building[j] - max;
			}
			System.out.println("#" + i + " " + sum);
		}
	}

}
