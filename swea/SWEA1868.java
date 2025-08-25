package com.kguard.tobecomebetter.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// D4 파핑파핑 지뢰찾기
// 지뢰를 찾은 다음에 근처 지뢰가 0인거 부터 bfs 실행
// visit는 초반에 근처 지뢰 위치를 구하는 함수를 생성
public class SWEA1868 {
    private static class xy {
        int x;
        int y;

        public xy(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] moveHeight = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] moveWidth = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] visit;
    static String[][] graph;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 1; t <= tc; t++) {
            n = sc.nextInt();
            graph = new String[n][n];
            visit = new int[n][n];
            int count = 0;
            for (int i = 0; i < n; i++)
                graph[i] = sc.next().split("");
            countBomb();

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (visit[i][j] == 0 && !graph[i][j].equals("*")) {
                        count++;
                        dfs(i, j);
//                      bfs(i, j);
                    }

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (visit[i][j] > 0 && !graph[i][j].equals("*"))
                        count++;

            System.out.println("#" + t + " " + count);
        }
    }

    private static void countBomb() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k <= 7; k++) {
                    int newY = i + moveHeight[k];
                    int newX = j + moveWidth[k];
                    if (0 <= newX && newX < n && 0 <= newY && newY < n && graph[newY][newX].equals("*"))
                        count++;
                }
                visit[i][j] = count;
            }
    }

    private static void bfs(int y, int x) {
        Queue<xy> queue = new LinkedList<>();
        queue.add(new xy(y, x));
        visit[y][x] = -1; // 이미 방문한 노드이면 -1로 방문 표시
        while (!queue.isEmpty()) {
            xy poll = queue.poll();
            assert poll != null;
            for (int i = 0; i <= 7; i++) {
                int newY = poll.y + moveHeight[i];
                int newX = poll.x + moveWidth[i];
                if (0 <= newY && newY < n && 0 <= newX && newX < n && !graph[newY][newX].equals("*")) {
                    if (visit[newY][newX] == 0)
                        queue.add(new xy(newY, newX));
                    visit[newY][newX] = -1;
                }
            }
        }
    }

    private static void dfs(int y, int x) {
        visit[y][x] = -1;
        for (int i = 0; i <= 7; i++) {
            int newY = y + moveHeight[i];
            int newX = x + moveWidth[i];
            if (0 <= newY && newY < n && 0 <= newX && newX < n && !graph[newY][newX].equals("*")) {
                if (visit[newY][newX] == 0)
                    dfs(newY, newX);
                visit[newY][newX] = -1;
            }
        }
    }
}
