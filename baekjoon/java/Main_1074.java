package com.kguard.tobecomebetter.baekjoon.java;

import java.io.*;
import java.util.*;

public class Main_1074 {
    static int count = 0;

    static void check(int size, int sy, int sx, int r, int c) {
        if (sy == r && sx == c) {
            System.out.println(count);
        } else if (sy <= r && r < sy + size && sx <= c && c < sx + size) {
            check(size / 2, sy, sx, r, c);
            check(size / 2, sy, sx + size / 2, r, c);
            check(size / 2, sy + size / 2, sx, r, c);
            check(size / 2, sy + size / 2, sx + size / 2, r, c);
        } else
            count += size * size;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        check((int) Math.pow(2.0,N),0,0,R,C);
    }

}
