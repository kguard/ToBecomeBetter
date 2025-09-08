package com.kguard.tobecomebetter.swea;

import java.io.*;
import java.util.*;

// d3 0/1 Knapsack
// 기본 적인 dp 문제인 냅색 문제중에서 01 냅색(넣거나 넣지 않거나)
public class SWEA3282 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] v = new int[N];
            int[] c = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }
            int[][] dp = new int[N + 1][K + 1];
            int[] dp2 = new int[K + 1];

            /* 기본으로 0으로 초기화되어 있음
            for(int i = 0 ; i <= N; i++)
                dp[i][0] = 0;

            for(int i = 0 ; i <= K; i++)
                dp[0][K] = 0;
            */

            // 2차원 배열을 이용해서 푸는 방법
            for (int i = 1; i <= N; i++) // 물건을 선택
                for (int j = 1; j <= K; j++) { // 가방의 전체 무게, 가방의 무게를 점점 증가 시킴
                    int vi = v[i - 1]; // 현재 선택한 물건의 무게
                    int ci = c[i - 1]; // 현재 선택한 물건의 가치
                    if (vi > j) // 현재 선택한 물건의 무게가 가방의 전체 무게 보다 클 경우 -> 물건이 들어 갈 수가 없음
                        dp[i][j] = dp[i - 1][j]; // 물건을 선택할 수 없음 -> 이전 물건 까지의 가방 전체 무게에 대한 최적값을 대입
                    else  // 현재 선택한 물건의 무게가 가방 전체의 무게보다 작거나 같은 경우 -> 물건이 들어 갈 수 있음
                        // 물건이 들거 가거나, 넣지 않는 경우 -> 둘중 무엇이 큰지는 계산 전까지는 모름
                        // 넣지 않으면 이전 물건 까지의 현재 가방 무게에 대한 최적값을 대입
                        // 넣는 경우면 이전 물건에 대한 전체 무게에서 현재 무게를 뺀 무게에 대한 최적값을 대입
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vi] + ci);
                }

            // 1차원 배열을 풀어서 푸는 과정 (공간 복잡도를 줄일 수 있음)
            for (int i = 1; i <= N; i++)
                for (int j = K; j >= 1; j--) {
                    int vi = v[i-1];
                    int ci = c[i-1];
                    if(vi <= j)
                        dp2[j] = Math.max(dp2[j], dp2[j-vi]+ci);
                    else
                        break;
                }

            sb.append("#").append(tc).append(" ").append(dp2[K]).append("\n");
//            sb.append("#").append(tc).append(" ").append(dp[N][K]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
