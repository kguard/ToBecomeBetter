package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;
// 골드 3 아기 상어
// bfs를 여러번 하는 것
// 현재 위치를 기준으로 갈 수 있는것을 다 구한 다음, 움직이기
public class $Main_16236 {
    static int n;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());

        int size = 2;
        int y = 0;
        int x = 0;
        int time = 0;
        int count = 0;

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    y = i;
                    x = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            List<int[]> bfs = bfs(y, x, size);

            if (bfs.isEmpty())
                break;

            bfs.sort((s1, s2) -> {
                if (s1[2] != s2[2])
                    return Integer.compare(s1[2], s2[2]);
                if (s1[0] != s2[0])
                    return Integer.compare(s1[0], s2[0]);
                return Integer.compare(s1[1], s2[1]);
            });


            int ny = bfs.get(0)[0];
            int nx = bfs.get(0)[1];
            int nt = bfs.get(0)[2];

            map[ny][nx] = 0;
            y = ny;
            x = nx;
            count++;
            time += nt;

            if (count == size) {
                size++;
                count = 0;
            }
        }

        System.out.println(time);

    }

    static List<int[]> bfs(int y, int x, int s) {
        List<int[]> result = new ArrayList<>();
        int[] moveHeight = new int[]{-1, 0, 1, 0}, moveWidth = new int[]{0, -1, 0, 1};
        int[][] visited = new int[n][n];
        for (int[] v : visited)
            Arrays.fill(v, -1);
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        visited[y][x] = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + moveHeight[i];
                int nx = poll[1] + moveWidth[i];
                if (0 > ny || ny >= n || 0 > nx || nx >= n || visited[ny][nx] != -1 || map[ny][nx] > s)
                    continue;

                visited[ny][nx] = visited[poll[0]][poll[1]] + 1;
                q.add(new int[]{ny, nx});


                if (s > map[ny][nx] && map[ny][nx] > 0)
                    result.add(new int[]{ny, nx, visited[ny][nx]});

            }
        }
        return result;
    }

}
