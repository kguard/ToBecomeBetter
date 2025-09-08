package com.kguard.tobecomebetter.baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 골드 1 달이차오른다, 가자
// BFS, 비트 마스킹
// visited 배열을 3차원으로 설정해서 key를 가지고 있는 경우를 다 다른 경우 로 생각해 줘야함
// 이때 키 가지고 있는 것을 비트마스킹을 사용
// 모든 키를 다 탐색하기 위해서 [N][M][64]로 설정
public class Main_1194 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        boolean[][][] v = new boolean[N][M][64];
        int[] moveHeight = new int[]{-1, 1, 0, 0,};
        int[] moveWidth = new int[]{0, 0, -1, 1};

        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == '0') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0], start[1], 0, 0}); // y, x, 현재 키, 이동 횟수
        v[start[0]][start[1]][0] = true;
        int result = -1;
        roop:
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + moveHeight[i];
                int nx = poll[1] + moveWidth[i];
                int key = poll[2];
                int count = poll[3];
                if (0 > ny || ny >= N || 0 > nx || nx >= M || map[ny][nx] == '#') continue;

/*
                if (map[ny][nx] == '1') {
                    result = count+1;
                    break roop;
                } else if (map[ny][nx] == '.' || map[ny][nx] == '0') {
                    if (!v[ny][nx][key]) {
                        v[ny][nx][key] = true;
                        q.offer(new int[]{ny, nx, key, count + 1});
                    }
                } else if (Character.isUpperCase(map[ny][nx])) {
                    if ((key & (1 << (map[ny][nx] - 65))) != 0 && !v[ny][nx][key]) {
                        v[ny][nx][key] = true;
                        q.offer(new int[]{ny, nx, key, count + 1});
                    }
                } else if (Character.isLowerCase(map[ny][nx])) {
                    key =  key | (1 << (map[ny][nx] - 97));
                    if (!v[ny][nx][key]) {
                        v[ny][nx][key] = true;
                        q.offer(new int[]{ny, nx, key, count + 1});
                    }
                }
*/


                else if (map[ny][nx] == '1') {
                    result = count + 1;
                    break roop;
                } else if (Character.isUpperCase(map[ny][nx]) && (key & (1 << (map[ny][nx] - 65))) == 0) {
                    continue;
                } else if (Character.isLowerCase(map[ny][nx])) {
                    key = key | (1 << (map[ny][nx] - 97));
                }

                if (!v[ny][nx][key]) {
                    v[ny][nx][key] = true;
                    q.offer(new int[]{ny, nx, key, count + 1});
                }
            }
        }
        System.out.println(result);
    }
}
