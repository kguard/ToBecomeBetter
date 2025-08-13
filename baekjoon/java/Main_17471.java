package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;

// 골드 3 게리멘더링
// 수학, 그래프 이론, 브루트포스 알고리즘, 그래프 탐색, 조합론, 너비 우선 탐색, 깊이 우선 탐색
// 부분집합 + 완전 탐색을 생각함
public class Main_17471 {
    static List<Integer> a = new ArrayList<>();// 하나의 집합을 사용해서 모든 부분집합을 구하기
    static List<List<Integer>> sl = new ArrayList<>(); // 부분 집합들의 조합들

    static List<Integer>[] g; // 연결된 관계

    static int N; // 인원 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] p = new int[N];  for (int i = 0; i < N; i++) p[i] = Integer.parseInt(st.nextToken());

        g = new List[N]; for (int i = 0; i < N; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                int a = Integer.parseInt(st.nextToken()) - 1;
                g[i].add(a);
                g[a].add(i);
            }
        }
        int min  = Integer.MAX_VALUE;

        subs(0);

        sl.remove(0);
        sl.remove(sl.size() - 1);

        for(List i : sl)
            System.out.println(i);

        for (int i = 0; i < sl.size() / 2; i++) {
            System.out.println(sl.get(i));
            System.out.println(sl.get(sl.size()-i-1));
            if (bfs(sl.get(i)) && bfs(sl.get(sl.size() - i - 1))) {
                int count1 = 0, count2 = 0;
                for (int j : sl.get(i)) {
                    count1 += p[j];
                }
                for (int j : sl.get(sl.size() - i - 1)) {
                    count2 += p[j];
                }
                min = Math.min(min, Math.abs(count1-count2));
            }
            if(min == 0)
                break;
        }
        if(min == Integer.MAX_VALUE)
            min = -1;
        System.out.println(min);
        br.close();
    }

    static void subs(int cnt) { // k는 1아니면 2
        if (cnt == N) {
            List<Integer> t = new ArrayList<>(a);
            sl.add(t);
            return;
        }
        a.add(cnt);
        subs(cnt + 1);
        a.remove(Integer.valueOf(cnt));
        subs(cnt + 1);
    }

    static boolean bfs(List<Integer> c) {
        boolean[] v = new boolean[N];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(c.get(0));
        v[c.get(0)] = true;
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int i : g[poll]) {
                if (!v[i] && c.contains(i)) {
                    v[i] = true;
                    q.add(i);
                }
            }
        }
        for (int i : c)
            if (!v[i]) return false;

        return true;
    }
}
