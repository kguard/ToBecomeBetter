package com.kguard.tobecomebetter.swea;

import java.util.*;
import java.io.*;

/*
// bfs를 이용해서 문제를 풀게 되면 오류가 나버림
public class Solution_24527_장애물피하기 {
    static int[] moveHeight = {1, -1, 0, 0};
    static int[] moveWidth = {0, 0, 1, -1};
    static int x1, x2, y1, y2, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }

    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        HashSet<String> v = new HashSet<>();
        int[] start = new int[]{0, 0, 0};
        queue.offer(start);
        v.add(start[0] + "," + start[1]);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int count = poll[2];
            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + moveHeight[i];
                int nx = poll[1] + moveWidth[i];

                String check = ny + "," + nx;
                if (count + 1 > k) // 움직인 카운트에 대한 부분은 두개의 절대 값을 더함으로 써 확인
                    continue;
                if (x1 <= nx && nx <= x2 && y1 <= ny && ny <= y2)
                    continue;
                if (v.contains(check))
                    continue;
                v.add(check);
                queue.offer(new int[]{ny, nx,count+1});
            }
        }
        return v.size();
    }
}*/

// 수학적으로 풀었을 떄
// k를 기준으로 2k * (k+1) + 1 개의 죄표가 나오는데 여기서 일부분을 지워야 됨
//public class Solution_24527_장애물피하기 {
//    static int[] moveHeight = {1, -1, 0, 0};
//    static int[] moveWidth = {0, 0, 1, -1};
//    static int x1, x2, y1, y2, k;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = null;
//        StringBuilder sb = new StringBuilder();
//        int t = Integer.parseInt(br.readLine());
//        for (int tc = 1; tc <= t; tc++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            x1 = Integer.parseInt(st.nextToken());
//            x2 = Integer.parseInt(st.nextToken());
//            y1 = Integer.parseInt(st.nextToken());
//            y2 = Integer.parseInt(st.nextToken());
//            k = Integer.parseInt(st.nextToken());
//            if(k < y1){
//                sb.append(countWhole(k));
//            }else{
//                sb.append(countWhole(k) - (long)(x2 - x1 + 1) * (k - y1 + 1);
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb.toString());
//        br.close();
//    }
//
//    static long countWhole(int k) {
//        return 2L * k * (k + 1) + 1;
//    }
//
//    static long countPoints(long k, long Y) {
//        if (Y < 0) return 0;
//        return (Y + 1) * (2 * k + 1) - Y * (Y + 1);
//    }
//}
