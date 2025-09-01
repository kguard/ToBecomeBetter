package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;

public class Main_1992 {
    static int[][] map;

    static void quadTree(int size, int sy, int sx) {
        int start = map[sy][sx];
        if (size == 1) {
            System.out.print(start);
            return;
        }
        for (int i = sy; i < sy + size; i++)
            for (int j = sx; j < sx + size; j++)
                if (map[i][j] != start) {
                    System.out.print("(");
                    quadTree(size / 2, sy, sx);
                    quadTree(size / 2, sy, sx + size / 2);
                    quadTree(size / 2, sy + size / 2, sx);
                    quadTree(size / 2, sy + size / 2, sx + size / 2);
                    System.out.print(")");
                    return;
                }

        System.out.print(start);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        quadTree(N, 0, 0);
    }

}
