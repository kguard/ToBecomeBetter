package com.kguard.tobecomebetter.swea;

import java.util.Scanner;

public class SWEA2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		for (int t = 1; t <= test_case; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] nn = new int[n][n];
			int[][] prefix = new int[n + 1][n + 1];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					nn[i][j] = sc.nextInt();
			// 4중 for문을 사용한 코드..
//			int max = 0;
//			for (int i = 0; i <= n - m; i++)
//				for (int j = 0; j <= n - m; j++) {
//					int sum = 0;
//					for (int y = 0; y < m; y++)
//						for (int x = 0; x < m; x++)
//							sum += nn[i + y][j + x];
//					max = Math.max(max, sum);
//				}

			// 누적합을 이용한 코드 -> 처음부터 현재 위치 까지 더한 값 
			// 누적합을 구하는 코드  -> 땅따먹기를 생각하면 됨 
			// 2차원 배열에서는 바로 이전 행의 누적합 + 이전 열의 누적합 - 이전 행렬의 누적합을 하면
			for (int i = 1; i <= n; i++) 
				for (int j = 1; j <= n; j++)
					prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + nn[i - 1][j - 1];
			// 누적합을 이용해서 특정 구간의 합을 구하는 부분 
			// 누적합에서 특정 부분의 누적 합들을 빼고, 두번 빼진 부분을 더하면 
			int max = 0;
			for(int i = m ; i <= n ; i++) 
				for(int j = m ; j<=n ; j++) {
					int sum = prefix[i][j] - prefix[i-m][j] - prefix[i][j-m] + prefix[i-m][j-m];
					max = Math.max(max, sum);
				}
			System.out.println("#" + t + " " + max);
		}
	}

}
