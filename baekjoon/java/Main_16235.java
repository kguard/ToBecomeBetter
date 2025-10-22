package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;
// 골드 3 나무 재테크
// 시뮬레이션으로 문제 해결 HashMap 사용

public class Main_16235 {
    static class Point {
        int y;
        int x;

        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return y == point.y && x == point.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                map[i][j] = 5;

        }

        int[][] a = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                a[i][j] = Integer.parseInt(st.nextToken());

        }

        HashMap<Point, ArrayDeque<Integer>> tree = new HashMap<>();
        HashMap<Point, List<Integer>> tempTree = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            Point p = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            int v = Integer.parseInt(st.nextToken());
            tempTree.computeIfAbsent(p, value -> new ArrayList<>()).add(v);
        }
        for(List<Integer> v : tempTree.values())
            Collections.sort(v);

        for(Map.Entry<Point, List<Integer>> entry : tempTree.entrySet()){
            Point p = entry.getKey();
            List<Integer> value = entry.getValue();
            tree.computeIfAbsent(p, v -> new ArrayDeque<>()).addAll(value);
        }


        int[] moveHeight = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] moveWidth = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        for (int time = 0; time < k; time++) {

            for (Map.Entry<Point, ArrayDeque<Integer>> entry : tree.entrySet()) {
                int y = entry.getKey().y;
                int x = entry.getKey().x;
                ArrayDeque<Integer> value = entry.getValue();
                int summer = 0;
                int size = value.size();
                for (int i = 0; i < size; i++) {
                    // 봄
                    int now = value.poll();

                    if (map[y][x] >= now) {
                        map[y][x] -= now;
                        value.add(now+1);
                    }
                    // 여름
                    else {
                        summer += now / 2;
                    }
                }
                map[y][x] += summer;
            }

            List<Point> validPoint = new ArrayList<>();
            for (Map.Entry<Point, ArrayDeque<Integer>> entry : tree.entrySet()) {
                int y = entry.getKey().y;
                int x = entry.getKey().x;
                List<Integer> value = new ArrayList<>(entry.getValue());
                int size = value.size();
                // 가을
                for(int i = 0; i <size; i++) {
                    if (value.get(i) % 5 == 0) {
                        for (int j = 0; j < 8; j++) {
                            int ny = y + moveHeight[j];
                            int nx = x + moveWidth[j];
                            if (1 <= ny && ny <= n && 1 <= nx && nx <= n) {
                                Point p = new Point(ny,nx);
                                validPoint.add(p);
                            }
                        }
                    }
                }
            }
            for(Point p : validPoint){
                tree.computeIfAbsent(p, value -> new ArrayDeque<>()).addFirst(1);
            }

            // 겨울
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] += a[i][j];
                }
            }

        }
        int count = 0;
        for (ArrayDeque<Integer> v : tree.values())
            count += v.size();
        System.out.println(count);

    }
}
