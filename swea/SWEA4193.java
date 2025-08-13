package com.kguard.tobecomebetter.swea;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 수영대회 결승전 (완전 탐색 + 구현) D4
public class SWEA4193 {
    private static class xy {
        int x;
        int y;

        public xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class node extends xy {
        int depth;

        public node(int x, int y, int depth) {
            super(x, y);
            this.depth = depth;
        }
    }

    static int[][] sea;
    static int n;
    static int[] moveHeight = {1, 0, -1, 0};
    static int[] moveWidth = {0, 1, 0, -1};
    static int sx;
    static int sy;
    static int ex;
    static int ey;
    static boolean[][] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            sea = new int[n][n];
            sc.nextLine();
            for (int i = 0; i < n; i++)
                sea[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sx = sc.nextInt();
            sy = sc.nextInt();
            ex = sc.nextInt();
            ey = sc.nextInt();
            visit = new boolean[n][n];
            System.out.println("#" + t + " " + bfs());

        }
    }


    private static int bfs() {
        Queue<node> queue = new LinkedList<>();
        queue.add(new node(sx, sy, 0));
        while (!queue.isEmpty()) {
            node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + moveWidth[i];
                int nextY = now.y + moveHeight[i];
                if (nextX == ex && nextY == ey)
                    return now.depth + 1;
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visit[nextX][nextY]) {
                    if (sea[nextX][nextY] == 2) {
                        if (now.depth % 3 == 2) {
                            visit[nextX][nextY] = true;
                            queue.add(new node(nextX, nextY, now.depth + 1));
                        } else {
                            visit[now.x][now.y] = true;
                            queue.add(new node(now.x, now.y, now.depth + 1));
                        }
                    } else if (sea[nextX][nextY] == 0) {
                        visit[nextX][nextY] = true;
                        queue.add(new node(nextX, nextY, now.depth + 1));
                    }
                }
            }
        }
        return -1;
    }
}
