package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;
// 골드 1 열쇠
// bfs를 이용, 열쇠를 하나 찾을때 마다 bfs 처음 부터 반복, 미지막에 bfs
// 열쇠를 못찾을 때 까지 bfs를 돎
// 마지막에 문서 찾기
public class Main_9328 {
    static int h, w;
    static char[][] map;
    static HashSet<Character> keys;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int count = 0;
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                String s = br.readLine();
                for (int j = 0; j < w; j++)
                    map[i][j] = s.charAt(j);
            }

            keys = new HashSet<>();
            char[] k = br.readLine().toCharArray();
            if(k[0] != '0') {
                for (char c : k)
                    keys.add(c);
            }


            while (findKey()) ;

            for(char[] c : map)
                System.out.println(Arrays.toString(c));


            int[] moveHeight = new int[]{-1, 1, 0, 0}, moveWidth = new int[]{0, 0, -1, 1};
            boolean[][] visited = new boolean[h][w];
            Queue<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < h; i++) {
                if (map[i][0] == '.') {
                    visited[i][0] = true;
                    q.add(new int[]{i, 0});
                } else if (Character.isUpperCase(map[i][0])) {
                    if (keys.contains(Character.toLowerCase(map[i][0]))) {
                        map[i][0] = '.';
                        visited[i][0] = true;
                        q.add(new int[]{i, 0});
                    }
                } else if (Character.isLowerCase(map[i][0])) {
                    keys.add(map[i][0]);
                    map[i][0] = '.';
                    visited[i][0] = true;
                    q.add(new int[]{i, 0});
                }
                else if(map[i][0] == '$'){
                    count++;
                    map[i][0] = '.';
                    visited[i][0] = true;
                    q.add(new int[]{i, 0});
                }

                if (map[i][w - 1] == '.') {
                    visited[i][w - 1] = true;
                    q.add(new int[]{i, w - 1});
                } else if (Character.isUpperCase(map[i][w - 1])) {
                    if (keys.contains(Character.toLowerCase(map[i][w - 1]))) {
                        map[i][w - 1] = '.';
                        visited[i][w - 1] = true;
                        q.add(new int[]{i, w - 1});
                    }
                } else if (Character.isLowerCase(map[i][w - 1])) {
                    keys.add(map[i][w - 1]);
                    map[i][w - 1] = '.';
                    visited[i][w - 1] = true;
                    q.add(new int[]{i, w - 1});
                }
                else if(map[i][w-1] == '$'){
                    count++;
                    map[i][w-1] = '.';
                    visited[i][w-1] = true;
                    q.add(new int[]{i, w-1});
                }

            }
            for (int i = 0; i < w; i++) {
                if (map[0][i] == '.') {
                    visited[0][i] = true;
                    q.add(new int[]{0, i});
                } else if (Character.isUpperCase(map[0][i])) {
                    if (keys.contains(Character.toLowerCase(map[0][i]))) {
                        map[0][i] = '.';
                        visited[0][i] = true;
                        q.add(new int[]{0, i});
                    }
                } else if (Character.isLowerCase(map[0][i])) {
                    keys.add(map[0][i]);
                    map[0][i] = '.';
                    visited[0][i] = true;
                    q.add(new int[]{0, i});
                }
                else if(map[0][i] == '$'){
                    count++;
                    map[0][i] = '.';
                    visited[0][i] = true;
                    q.add(new int[]{0, i});
                }



                if (map[h - 1][i] == '.') {
                    visited[h - 1][i] = true;
                    q.add(new int[]{h - 1, i});
                } else if (Character.isUpperCase(map[h - 1][i])) {
                    if (keys.contains(Character.toLowerCase(map[h - 1][i]))) {
                        map[h - 1][i] = '.';
                        visited[h - 1][i] = true;
                        q.add(new int[]{h - 1, i});
                    }
                } else if (Character.isLowerCase(map[h - 1][i])) {
                    keys.add(map[h - 1][i]);
                    map[h - 1][i] = '.';
                    visited[h - 1][i] = true;
                    q.add(new int[]{h - 1, i});

                }
                else if(map[h-1][i] == '$'){
                    count++;
                    map[h-1][i] = '.';
                    visited[h-1][i] = true;
                    q.add(new int[]{h-1, i});
                }

            }
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = poll[0] + moveHeight[i];
                    int nx = poll[1] + moveWidth[i];
//                    if (ny < 0 || ny >= h || nx < 0 || nx >= w || map[ny][nx] == '*' || visited[ny][nx])
//                        continue;
//                    if(Character.isUpperCase(map[ny][nx]) && !keys.contains(Character.toLowerCase(map[ny][nx]))){
//                        continue;
//                    }

                    if(0 <= ny &&  ny < h && 0 <= nx && nx < w && !visited[ny][nx] && map[ny][nx] != '*') {
                        if (map[ny][nx] == '$') {
                            count++;
                            visited[ny][nx] = true;
                            q.add(new int[]{ny, nx});
                        }else if(map[ny][nx] == '.'){
                            visited[ny][nx] = true;
                            q.add(new int[]{ny, nx});
                        }
                    }





                }
            }
            System.out.println(count);
        }
    }

    static boolean findKey() {
        boolean find = false;
        int[] moveHeight = new int[]{-1, 1, 0, 0}, moveWidth = new int[]{0, 0, -1, 1};
        boolean[][] visited = new boolean[h][w];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            if (map[i][0] == '.' || map[i][0] == '$') {
                visited[i][0] = true;
                q.add(new int[]{i, 0});
            } else if (Character.isUpperCase(map[i][0])) {
                if (keys.contains(Character.toLowerCase(map[i][0]))) {
                    map[i][0] = '.';
                    visited[i][0] = true;
                    q.add(new int[]{i, 0});
                }
            } else if (Character.isLowerCase(map[i][0])) {
                keys.add(map[i][0]);
                map[i][0] = '.';
                visited[i][0] = true;
                q.add(new int[]{i, 0});
                find = true;
            }

            if (map[i][w - 1] == '.' || map[i][w-1] == '$') {
                visited[i][w - 1] = true;
                q.add(new int[]{i, w - 1});
            } else if (Character.isUpperCase(map[i][w - 1])) {
                if (keys.contains(Character.toLowerCase(map[i][w - 1]))) {
                    map[i][w - 1] = '.';
                    visited[i][w - 1] = true;
                    q.add(new int[]{i, w - 1});
                }
            } else if (Character.isLowerCase(map[i][w - 1])) {
                keys.add(map[i][w - 1]);
                map[i][w - 1] = '.';
                visited[i][w - 1] = true;
                q.add(new int[]{i, w - 1});
                find = true;
            }
        }
        for (int i = 0; i < w; i++) {
            if (map[0][i] == '.' || map[0][i] == '$') {
                visited[0][i] = true;
                q.add(new int[]{0, i});
            } else if (Character.isUpperCase(map[0][i])) {
                if (keys.contains(Character.toLowerCase(map[0][i]))) {
                    map[0][i] = '.';
                    visited[0][i] = true;
                    q.add(new int[]{0, i});
                }
            } else if (Character.isLowerCase(map[0][i])) {
                keys.add(map[0][i]);
                map[0][i] = '.';
                visited[0][i] = true;
                q.add(new int[]{0, i});
                find = true;
            }


            if (map[h - 1][i] == '.'|| map[h-1][i] == '$') {
                visited[h - 1][i] = true;
                q.add(new int[]{h - 1, i});
            } else if (Character.isUpperCase(map[h - 1][i])) {
                if (keys.contains(Character.toLowerCase(map[h - 1][i]))) {
                    map[h - 1][i] = '.';
                    visited[h - 1][i] = true;
                    q.add(new int[]{h - 1, i});
                }
            } else if (Character.isLowerCase(map[h - 1][i])) {
                keys.add(map[h - 1][i]);
                map[h - 1][i] = '.';
                visited[h - 1][i] = true;
                q.add(new int[]{h - 1, i});
                find = true;
            }

        }
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + moveHeight[i];
                int nx = poll[1] + moveWidth[i];
                if (ny < 0 || ny >= h || nx < 0 || nx >= w || map[ny][nx] == '*' || visited[ny][nx])
                    continue;
                if (Character.isUpperCase(map[ny][nx])) {
                    if (keys.contains(Character.toLowerCase(map[ny][nx]))) {
                        map[ny][nx] = '.';
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    }
                } else if (Character.isLowerCase(map[ny][nx])) {
                    if(keys.add(map[ny][nx]))
                        find = true;
                    map[ny][nx] = '.';
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});

                } else {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }
        }
        return find;
    }
}
