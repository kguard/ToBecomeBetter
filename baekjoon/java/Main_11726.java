package com.kguard.tobecomebetter.baekjoon.java;

import java.util.Arrays;
import java.util.Scanner;

// 실버 3 2xn 타일링
// 다이나믹 프로그래밍(DP)
// 기본적인 dp 문제
// 이전 단계에서 더하는 개념 -> 갯수로는 이전 단계와 같음
// 이전 단계에서 1X2를 오른쪽에 하나 더한 결과 + 2번 이전 단계(2X1 2개 가능)에서 오른쪽에 2X1를 2개 붙이는 경우를 더하면 됨
public class Main_11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];
        dp[0] = 1; // 아무것도 없는 경우의 수 1개
        dp[1] = 1; // 2x1의 타일 하나만 들어갈 경우의 수 1개
        for(int i = 2; i <= N; i++){
            // 마지막 한 칸이 비어 있는 경우의 수 : 바로 이전의 경우의 수 , 마지막 두 칸이 비워져 있는 경우의 수 : 2칸이 비워져 있는 경우의 수
            // 2X1의 타일 1개가 마지막 1칸에 오는 경우의 수는 마지막 한 칸만 2X1이고 나머지는 이전의 모든 경우의 수 임
            // 1x2의 타일 2개가 마지막 2칸에 오는 경우의 수는 마지막 두 칸이 비워져 있는 경우의 수이기 떄문에
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] = ((dp[i-1] % 10007) + (dp[i-2] % 10007)) % 10007; // 모듈러 연산을 위해서
        }
        System.out.print(dp[N]);
    }
}
