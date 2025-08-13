package com.kguard.tobecomebetter.baekjoon.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 참외밭
public class Main_2477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int K = Integer.parseInt(br.readLine());
        int h = 0, w = 0, hIndex = 0, wIndex = 0;
        List<Integer> list = new ArrayList<>();
        List<Boolean> check = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int position = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            switch (position) {
                case 1:
                case 2:
                    if(w < value) {
                        w = value;
                        wIndex = i;
                    }
                    break;
                case 3:
                case 4:
                    if(h < value) {
                        h = value;
                        hIndex = i;
                    }
                    break;
            }
            list.add(value);
            check.add(false);
        }

        check.set((wIndex + 1) % 6, true);
        check.set(wIndex % 6, true);
        check.set((wIndex - 1 + 6) % 6, true);
        check.set((hIndex + 1) % 6, true);
        check.set(hIndex % 6, true);
        check.set((hIndex - 1 + 6) % 6, true);

        int whole = h * w;
        int minus = 1;
        for (int i = 0; i < 6; i++) {
            if (!check.get(i))
                minus *= list.get(i);
        }

        System.out.println((whole - minus) * K);

    }
}
