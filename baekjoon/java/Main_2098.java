package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;

public class Main_2098 {
    static int N;
    static int[][] map, dp;
    static int INF = 16000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        dp = new int[N][1 << N]; // [현재 위치][방문했던 정점들을 비트 마스킹으로 저장]
        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1); // 방문하지 않을 걸로 초기화

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(TSP(0, 1 << 0)); // 현재 정점 0, 0정점 방문 1 << 0
    }

    static int TSP(int now, int visit) {
        if (visit == ((1 << N) - 1)) { // 모두 방문한 경우 -> 현재 위치에서 시작한 위치로 돌아가야함
            if (map[now][0] == 0) // 현재 위치에서 시작 위치로 돌아갈 수 없는 경우
                return INF; // max return
            else
                return map[now][0]; // 돌아갈 수 있는 경우의 수는 단 한가지 -> 모든 정점을 방문했기 떄문에 바로 돌아가야함
        }

        if (dp[now][visit] != -1) // 중복되는 경우의 수가 나오면 진행해도 어쩌피 같은 경우의 수가 나올 테니 값 리턴
            return dp[now][visit]; // 이미 확인한 경우의 수

        // dp[now][visit]를 INF로 초기화
        // for 루프에서 유효한 경로를 하나도 찾지 못했을 때(막다른 길)
        // 최종적으로 INF가 저장되어 실패
        dp[now][visit] = INF; // 일단 INF를 저장해서 갈 수 있는 길 확인 시작
        // 아래 for문 이후에도 INF가 저장되면 갈 수 없다는 의미. -1 이랑은 의미가 다름

        for (int i = 0; i < N; i++) { // 다른 정점들을 확인
            if (map[now][i] == 0 || (visit & (1 << i)) != 0) // 현재 정점에서 다른 정점에 연결되어 있지 않거나, 이미 방문했던 정점이면 넘어감
                continue;
            // 현재 위치에서 방문한 정점을 제외하고, 방문할 정점중 최소 값을 찾아줌
            dp[now][visit] = Math.min(dp[now][visit], TSP(i, visit | (1 << i)) + map[now][i]);
        }

        return dp[now][visit]; // 현재 경우의 수의 최소값 리턴
    }
}
