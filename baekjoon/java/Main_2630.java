package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;

// 실버 2 색종이 만들기
// 분할정복, 재귀
public class Main_2630 {
    static int[][] map;
    static int[] result;

    static void checkColor(int size, int sy, int sx) {
        int color = map[sy][sx];
        if (size == 1) {
            result[color]++;
            return;
        }
        for (int i = sy; i < sy + size; i++)
            for (int j = sx; j < sx + size; j++)
                if (map[i][j] != color) {
                    checkColor(size / 2, sy, sx);
                    checkColor(size / 2, sy + size / 2, sx);
                    checkColor(size / 2, sy, sx + size / 2);
                    checkColor(size / 2, sy + size / 2, sx + size / 2);
                    return;
                }

        result[color]++; // 다 채워 졌을 때
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new int[2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkColor(N,0,0);
        for (int i : result) {
            System.out.println(i);
        }


    }
}
