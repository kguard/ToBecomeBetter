package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;

// 골드5
// 냅색 문제(배낭 문제) -> 기본적인 dp 문제
public class Main_12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] weights = new int[N];
        int[] values = new int[N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K+1];
        for(int i = 0; i < N; i++)
            for(int j = K; j >= 1; j--){
                int w = weights[i];
                int v = values[i];
                if(w <= j)
                    dp[j] = Math.max(dp[j],dp[j-w]+v);
                else
                    break;
            }

        System.out.println(dp[K]);
    }
}
