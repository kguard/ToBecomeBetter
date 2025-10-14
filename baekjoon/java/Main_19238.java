package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;
// 골드 2 스타트 택시
// 단순 bfs 하나로만 하는 시뮬레이션
public class Main_19238 {
    static int[] moveHeight = new int[]{-1, 1, 0, 0}, moveWidth = new int[]{0, 0, -1, 1};
    static int n, m, f, sy, sx;
    static int[][] map;
    static int[][] customers;
    static HashSet<List<Integer>> v = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        sy = Integer.parseInt(st.nextToken()) - 1;
        sx = Integer.parseInt(st.nextToken()) - 1;

        customers = new int[m][4];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++)
                customers[i][j] = Integer.parseInt(st.nextToken()) - 1;
        }
        for (int i = 0; i < m; i++) {
            int[][] now = bfs(sy, sx);
            int ny = -1;
            int nx = -1;
            int ey = 0;
            int ex = 0;
            for (int j = 0; j < m; j++) {

                if (v.contains(Arrays.asList(customers[j][0], customers[j][1])) || now[customers[j][0]][customers[j][1]] == -1)
                    continue;

                if (ny == -1 && nx == -1) {
                    ny = customers[j][0];
                    nx = customers[j][1];
                    ey = customers[j][2];
                    ex = customers[j][3];
                    continue;
                }

                if (now[customers[j][0]][customers[j][1]] < now[ny][nx]) {
                    ny = customers[j][0];
                    nx = customers[j][1];
                    ey = customers[j][2];
                    ex = customers[j][3];
                } else if (now[customers[j][0]][customers[j][1]] == now[ny][nx]) {
                    if (customers[j][0] < ny) {
                        ny = customers[j][0];
                        nx = customers[j][1];
                        ey = customers[j][2];
                        ex = customers[j][3];
                    } else if (customers[j][0] == ny) {
                        if (customers[j][1] < nx) {
                            ny = customers[j][0];
                            nx = customers[j][1];
                            ey = customers[j][2];
                            ex = customers[j][3];
                        }
                    }
                }
            }
            sy = ny;
            sx = nx;
            v.add(Arrays.asList(sy, sx));
            if (sx == -1 && sy == -1) {
                f = -1;
                break;
            }
            if (f - now[sy][sx] < 0) {
                f = -1;
                break;
            } else
                f -= now[sy][sx];


            int end = bfs(sy, sx)[ey][ex];
            if (end == -1) {
                f = -1;
                break;
            }
            if (f - end < 0) {
                f = -1;
                break;
            } else {
                f -= end;
                f += end * 2;
                sy = ey;
                sx = ex;
            }

        }

        System.out.println(f);
    }

    static int[][] bfs(int y, int x) {
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(visited[i], -1);
        Queue<int[]> q = new ArrayDeque<>();
        visited[y][x] = 0;
        q.add(new int[]{y, x, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + moveHeight[i];
                int nx = poll[1] + moveWidth[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || map[ny][nx] == 1 || visited[ny][nx] != -1)
                    continue;
                visited[ny][nx] = poll[2] + 1;
                q.add(new int[]{ny, nx, visited[ny][nx]});
            }
        }
        return visited;
    }
}
