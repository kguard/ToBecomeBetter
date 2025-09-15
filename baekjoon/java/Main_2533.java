package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;

// 골드 3 사회망 서비스(SNS)
// tree-dp
public class Main_2533 {
    static List<Integer>[] g;
    static boolean[] v;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        g = new List[N + 1];
        v = new boolean[N + 1];
        dp = new int[2][N+1];
        for (int i = 0; i <= N; i++)
            g[i] = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }
        dfs(1); // 아무 노드나 상관 없음
        System.out.println(Math.min(dp[1][1], dp[0][1])); // 노드는 같아야 함
//        for(int[] i : dp){
//            System.out.println(Arrays.toString(i));
//        }
    }

    static void dfs(int s) {
        v[s] = true;
        dp[0][s] = 0; // 해당 s 가 얼리어답터가 아닐 경우 -> 0 개
        dp[1][s] = 1; // 해당 s 가 얼디어답터일 경우 -> 1개
        for(int i : g[s]){ // 자식 노드 기준으로
            if(!v[i]){ // 방문 했는지 안했는지 확인
                dfs(i); // dfs를 통해서 자식노드의 값을 미리 구하기
                dp[0][s] += dp[1][i]; // 본인이 얼리어답터가 아니면 자식은 무조건 얼리어답터 여야함
                dp[1][s] += Math.min(dp[1][i], dp[0][i]); // 본인이 얼리어답터이면 자식은 얼리어답터일 수도, 아닐 수도 있음
            }
        }
    }
}
