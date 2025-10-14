package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;
// 실버 1 동물원

public class Main_1309 {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[3][n];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[2][0] = 1;
        for(int i = 1; i < n ; i++){
            dp[0][i] = (dp[1][i-1] +dp[0][i-1] + dp[2][i-1]) % 9901;
            dp[1][i] = (dp[0][i-1] + dp[2][i-1]) % 9901;
            dp[2][i] = (dp[0][i-1] + dp[1][i-1]) % 9901;
        }
        System.out.println((dp[0][n-1]+dp[1][n-1]+dp[2][n-1])%9901);
    }
}
